/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class MecanismoPredefinidoBTest {
    
    public MecanismoPredefinidoBTest() {
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
     * Test of getNome method, of class MecanismoPredefinidoB.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        MecanismoPredefinidoB instance = new MecanismoPredefinidoB();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class MecanismoPredefinidoB.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        MecanismoPredefinidoB instance = new MecanismoPredefinidoB();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atribui method, of class MecanismoPredefinidoB.
     */
    @Test
    public void testAtribui() {
        System.out.println("atribui");
        Exposicao exposicaoEscolhida = null;
        String numeroFAEStr = "";
        MecanismoPredefinidoB instance = new MecanismoPredefinidoB();
        List<AtribuicoesCandidatura> expResult = null;
        List<AtribuicoesCandidatura> result = instance.atribui(exposicaoEscolhida, numeroFAEStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
