/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;
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
     * Test of getListaFAE method, of class RegistoFAE.
     */
    @Test
    public void testGetListaFAE() {
        System.out.println("getListaFAE");
        RegistoFAE instance = new RegistoFAE();
        List<FAE> expResult = null;
        List<FAE> result = instance.getListaFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionaFAE method, of class RegistoFAE.
     */
    @Test
    public void testAdicionaFAE() {
        System.out.println("adicionaFAE");
        Utilizador u = null;
        RegistoFAE instance = new RegistoFAE();
        boolean expResult = false;
        boolean result = instance.adicionaFAE(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmaAddFAE method, of class RegistoFAE.
     */
    @Test
    public void testConfirmaAddFAE() {
        System.out.println("confirmaAddFAE");
        RegistoFAE instance = new RegistoFAE();
        instance.confirmaAddFAE();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFAE method, of class RegistoFAE.
     */
    @Test
    public void testIsFAE() {
        System.out.println("isFAE");
        String usernameFAE = "";
        RegistoFAE instance = new RegistoFAE();
        boolean expResult = false;
        boolean result = instance.isFAE(usernameFAE);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistoOrganizadoresParaValidacoes method, of class RegistoFAE.
     */
    @Test
    public void testSetRegistoOrganizadoresParaValidacoes() {
        System.out.println("setRegistoOrganizadoresParaValidacoes");
        RegistoOrganizadores ro = null;
        RegistoFAE instance = new RegistoFAE();
        instance.setRegistoOrganizadoresParaValidacoes(ro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFAE method, of class RegistoFAE.
     */
    @Test
    public void testGetFAE() {
        System.out.println("getFAE");
        String usernameFAE = "";
        RegistoFAE instance = new RegistoFAE();
        FAE expResult = null;
        FAE result = instance.getFAE(usernameFAE);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaUtilizadoresCorrespondentesAosFae method, of class RegistoFAE.
     */
    @Test
    public void testGetListaUtilizadoresCorrespondentesAosFae() {
        System.out.println("getListaUtilizadoresCorrespondentesAosFae");
        RegistoFAE instance = new RegistoFAE();
        List<Utilizador> expResult = null;
        List<Utilizador> result = instance.getListaUtilizadoresCorrespondentesAosFae();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
