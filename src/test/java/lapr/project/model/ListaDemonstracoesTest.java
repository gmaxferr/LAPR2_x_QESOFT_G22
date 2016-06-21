/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guima
 */
public class ListaDemonstracoesTest {

    public ListaDemonstracoesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ListaDemonstracoes instance;
    private int size = 2;
    private Demonstracao d;
    private Demonstracao d2;
    private Exposicao e;
    CentroExposicoes ce;
    private String cod1;
    private String cod2;

    @Before
    public void setUp() {
        cod1 = "cod1";
        cod2 = "cod2";
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        instance = new ListaDemonstracoes();
        d = new Demonstracao("descricao", e);
        d.setCodigoIdentificacao(cod1);
        d2 = new Demonstracao("descricao2", e);
        d2.setCodigoIdentificacao(cod2);
        instance.getListaDemonstracoesAdicionadas().add(d);
        instance.getListaDemonstracoesAdicionadas().add(d2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class ListaDemonstracoes.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = size;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDemonstracoesAdicionadas method, of class
     * ListaDemonstracoes.
     */
    @Test
    public void testGetListaDemonstracoesAdicionadas() {
        System.out.println("getListaDemonstracoesAdicionadas");
        List<Demonstracao> expResult = new ArrayList<Demonstracao>();
        expResult.add(d);
        expResult.add(d2);
        List<Demonstracao> result = instance.getListaDemonstracoesAdicionadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDemonstracaoAt method, of class ListaDemonstracoes.
     */
    @Test
    public void testGetDemonstracaoAt() {
        System.out.println("getDemonstracaoAt");
        int index = 0;
        Demonstracao expResult = d;
        Demonstracao result = instance.getDemonstracaoAt(index);
        assertEquals(expResult, result);
        int index2 = 1;
        Demonstracao expResult2 = d2;
        Demonstracao result2 = instance.getDemonstracaoAt(index2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of adicionarDemonstracao method, of class ListaDemonstracoes.
     */
    @Test
    public void testAdicionarDemonstracao() {
        System.out.println("adicionarDemonstracao");

        Demonstracao demonstracao = new Demonstracao("descricao3", e);
        boolean expResult = true;
        boolean result = instance.adicionarDemonstracao(demonstracao);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeDemonstracao method, of class ListaDemonstracoes.
     */
    @Test
    public void testRemoveDemonstracao() {
        System.out.println("removeDemonstracao");
        String codigoIdentificacao = cod1;
        int expResult = 0;
        int result = instance.removeDemonstracao(codigoIdentificacao);
        assertEquals(expResult, result);
    }

    /**
     * Test of localizarDemonstracaoParaRemover method, of class
     * ListaDemonstracoes.
     */
    @Test
    public void testLocalizarDemonstracaoParaRemover() {
        System.out.println("localizarDemonstracaoParaRemover");
        String codigoIdentificacao = cod1;
        int expResult = 0;
        int result = instance.localizarDemonstracaoParaRemover(codigoIdentificacao);
        assertEquals(expResult, result);
    }

}
