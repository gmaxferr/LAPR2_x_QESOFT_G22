package lapr.project.registos;

import java.util.List;
import lapr.project.dados.DadosInstanciados;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class RegistoFAETest {

    public RegistoFAETest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of adicionaFAE method, of class RegistoFAE. Verifica se ao ser
     * adicionado como FAE tbmé atualizada a variavel isFAE
     */
    @Test
    public void testAdicionaFAEIsFAE() {
        System.out.println("adicionaFAE Verifica se ao ser adicionado como FAE tbmé atualizada a variavel isFAE");
        RegistoFAE rfae = new RegistoFAE();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@hot.com");
        rfae.adicionaFAE(u);
        assertEquals(true, u.getIsFAE());
    }

    /**
     * Test of adicionaFAE method, of class RegistoFAE. Verifica se é adicionado
     * um FAE válido
     */
    @Test
    public void testAdicionaFAEAdicionarFAEValido() {
        System.out.println("adicionaFAE Verifica se é adicionado um FAE quando é válido");
        RegistoFAE rfae = new RegistoFAE();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@hot.com");
        boolean adicionou = rfae.adicionaFAE(u);
        assertEquals(true, adicionou);
    }

    /**
     * Test of adicionaFAE method, of class RegistoFAE. Verifica se é adicionado
     * um FAE inválido
     */
    @Test
    public void testAdicionaFAEAdicionarFAERepetido() {
        System.out.println("adicionaFAE Verifica se é adicionado um FAE quando é inválido");
        RegistoFAE rfae = new RegistoFAE();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@hot.com");
        rfae.adicionaFAE(u);
        boolean adicionou = rfae.adicionaFAE(u);
        assertEquals(false, adicionou);
    }

    /**
     * Test of adicionaFAE method, of class RegistoFAE. Verifica se é adicionado
     * um FAE inválido
     */
    @Test
    public void testAdicionaFAEAdicionarFAEQueJaEOrganizador() {
        System.out.println("adicionaFAE Verifica se é adicionado um FAE que já é organizador da expo");
        Exposicao expo = new DadosInstanciados().getExpo1();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@hot.com");
        expo.getRegistoOrganizadores().addOrganizador(u); //valido
        RegistoFAE rfae = expo.getRegistoFAE();
        boolean adicionou = rfae.adicionaFAE(u); //nao pode adicionar
        assertEquals(false, adicionou);
    }

    /**
     * Test of isFAE method, of class RegistoFAE. Testa se depois de adicionar
     * um FAE a variável isFAE relacionada com o utilizador atualiza
     */
    @Test
    public void testIsFAE() {
        System.out.println("isFAE Testa se depois de adicionar um FAE a variável isFAE relacionada com o utilizador atualiza");
        Exposicao expo = new DadosInstanciados().getExpo1();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@hot.com");
        expo.getRegistoFAE().adicionaFAE(u);
        assertEquals(true, u.getIsFAE());
    }

    /**
     * Test of isFAE method, of class RegistoFAE. Testa se depois de tentar
     * adicionar um FAE inválido a variável isFAE relacionada com este
     * utilizador atualiza
     */
    @Test
    public void testIsFAEUtilizadorInvalido() {
        System.out.println("isFAE Testa se depois de tentar adicionar um FAE inválido a variável isFAE relacionada com o utilizador atualiza");
        Exposicao expo = new DadosInstanciados().getExpo1();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@hot.com");
        expo.getRegistoFAE().adicionaFAE(u);
        u = new Utilizador("Ricardo2", "Ricardo", "password".toCharArray(), "email@hot.com");
        expo.getRegistoFAE().adicionaFAE(u); //nao adiciona
        assertEquals(false, u.getIsFAE());
    }

    /**
     * Test of getFAE method, of class RegistoFAE. Testa se devolve o FAE
     * passando o username de um FAE correto por parametro
     */
    @Test
    public void testGetFAE() {
        System.out.println("getFAE Testa se devolve o FAE passando o username de um FAE correto por parametro");
        boolean encontrou = false;
        Exposicao expo = new DadosInstanciados().getExpo1();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@hot.com");
        expo.getRegistoFAE().adicionaFAE(u);
        FAE fae = expo.getRegistoFAE().getFAE("Ricardo");
        if (fae.getUtilizador().equals(u)) {
            encontrou = true;
        }
        assertEquals(true, encontrou);
    }

    /**
     * Test of getFAE method, of class RegistoFAE. Testa se devolve o FAE
     * passando o username de um FAE incorreto por parametro
     */
    @Test
    public void testGetFAEnvalido() {
        System.out.println("getFAE Testa se devolve o FAE passando o username de um FAE incorreto por parametro");
        boolean encontrou = false;
        Exposicao expo = new DadosInstanciados().getExpo1();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@hot.com");
        expo.getRegistoFAE().adicionaFAE(u);
        FAE fae = expo.getRegistoFAE().getFAE("Ricardo2");
        if (fae.getUtilizador().equals(u)) {
            encontrou = true;
        }
        assertEquals(false, encontrou);
    }

    /**
     * Test of getListaUtilizadoresCorrespondentesAosFae method, of class
     * RegistoFAE. Testa se devolve corretamente os utilizadores associados aos
     * FAE da exposição.
     */
    @Test
    public void testGetListaUtilizadoresCorrespondentesAosFae() {
        System.out.println("getListaUtilizadoresCorrespondentesAosFae Testa se devolve corretamente os utilizadores associados aos FAE da exposição");
        Exposicao expo = new DadosInstanciados().getExpo1();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@hot.com");
        expo.getRegistoFAE().adicionaFAE(u);
        List<Utilizador> listaDeUtilizadores = expo.getRegistoFAE().getListaUtilizadoresCorrespondentesAosFae();
        assertEquals(true, listaDeUtilizadores.get(0).equals(u));
    }
}
