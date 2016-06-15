package lapr.project.controller;

import lapr.project.exceptions.InvalidPasswordException;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoUtilizadores;
import lapr.project.utils.CaesarsCypher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guilherme
 */
public class AlterarPerfilDeUtilizadorControllerTest {

    private AlterarPerfilDeUtilizadorController instance;
    private CentroExposicoes ce;
    private Utilizador u;
    private RegistoUtilizadores ru;
    private final String nome = "nome";
    private final String email = "112sss@aaa444.ccc888";
    private final String username = "username";
    private final char[] password = {'A', '.', 'c', '1', 'e'};

    public AlterarPerfilDeUtilizadorControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        ru = ce.getRegistoUtilizadores();
        u = new Utilizador();
        u.setNome(nome);
        u.setUsername(username);
        u.setPwd(password);
        u.setEmail(email);
        ru.addUtilizador(u);
        instance = new AlterarPerfilDeUtilizadorController(ce);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of carregaRegistoUtilizadores method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testCarregaRegistoUtilizadores() {
        System.out.println("carregaRegistoUtilizadores");
        instance.carregaRegistoUtilizadores();
    }

    /**
     * Test of identificaUtilizador method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testIdentificaUtilizador() {
        System.out.println("identificaUtilizador");
        String username = "username";
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador(username);
    }

    /**
     * Test of getNomeUtilizador method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetNomeUtilizador() {
        System.out.println("getNomeUtilizador");
        instance.carregaRegistoUtilizadores();
        ru.addUtilizador(u);
        instance.identificaUtilizador("username");
        String expResult = "nome";
        String result = instance.getNomeUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailUtilizador method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetEmailUtilizador() {
        System.out.println("getEmailUtilizador");
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");
        String expResult = email;
        String result = instance.getEmailUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPasswordUtilizador method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetPasswordUtilizador() {
        System.out.println("getPasswordUtilizador");
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");
        boolean expResult = true;
        boolean result = u.VerificaCorrespondenciaPassword(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeNome method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testChangeNome() {
        System.out.println("changeNome");
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");
        String nome = "nome1";
        boolean expResult = true;
        boolean result = instance.changeNome(nome);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeUsername method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testChangeUsername() {
        System.out.println("changeUsername");
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");
        String username = "novoUsername";
        boolean expResult = true;
        boolean result = instance.changeUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeEmail method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testChangeEmail() {
        System.out.println("changeEmail");
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");
        String email = "aaa222sd@dss.com";
        boolean expResult = true;
        boolean result = instance.changeEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of changePassword method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");
        char[] badPassword = {'a', 'b', 'c', 'd', 'e'};
        try {
            boolean result = instance.changePassword(badPassword);
        } catch (InvalidPasswordException ipe) {
            char[] goodPassword = {'a', 'B', '.', '1', 'r', 'l'};
            boolean expResult = true;
            boolean result = instance.changePassword(goodPassword);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of confirmaAlteracoes method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testConfirmaAlteracoes() {
        System.out.println("confirmaAlteracoes");

        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");

        instance.changeEmail("1150@snc.cx");
        instance.changeNome("sss");
        instance.changeUsername("userN");
        char[] pass = {'a', 'B', '.', '1', 'r', 'Q'};
        instance.changePassword(pass);
        instance.confirmaAlteracoes();
    }

}
