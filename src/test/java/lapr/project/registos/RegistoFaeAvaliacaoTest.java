/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.Avaliacao;
import lapr.project.model.FAE;
import lapr.project.model.FaeAvaliacao;
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
public class RegistoFaeAvaliacaoTest {
    
    public RegistoFaeAvaliacaoTest() {
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
     * Test of getObjFaeDecisaoDoFae method, of class RegistoFaeAvaliacao.
     */
    @Test
    public void testGetObjFaeDecisaoDoFae() {
        System.out.println("getObjFaeDecisaoDoFae");
        String usernameFae = "";
        RegistoFaeAvaliacao instance = new RegistoFaeAvaliacao();
        FaeAvaliacao expResult = null;
        FaeAvaliacao result = instance.getObjFaeDecisaoDoFae(usernameFae);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvaliacaoDoFae method, of class RegistoFaeAvaliacao.
     */
    @Test
    public void testGetAvaliacaoDoFae() {
        System.out.println("getAvaliacaoDoFae");
        String usernameFAE = "";
        RegistoFaeAvaliacao instance = new RegistoFaeAvaliacao();
        Avaliacao expResult = null;
        Avaliacao result = instance.getAvaliacaoDoFae(usernameFAE);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFaeAvaliacao method, of class RegistoFaeAvaliacao.
     */
    @Test
    public void testAddFaeAvaliacao() {
        System.out.println("addFaeAvaliacao");
        FAE fae = null;
        RegistoFaeAvaliacao instance = new RegistoFaeAvaliacao();
        instance.addFaeAvaliacao(fae);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaTodosFAE method, of class RegistoFaeAvaliacao.
     */
    @Test
    public void testGetListaTodosFAE() {
        System.out.println("getListaTodosFAE");
        RegistoFaeAvaliacao instance = new RegistoFaeAvaliacao();
        List<FAE> expResult = null;
        List<FAE> result = instance.getListaTodosFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaUtilizadoresAssociadoAosFAE method, of class RegistoFaeAvaliacao.
     */
    @Test
    public void testGetListaUtilizadoresAssociadoAosFAE() {
        System.out.println("getListaUtilizadoresAssociadoAosFAE");
        RegistoFaeAvaliacao instance = new RegistoFaeAvaliacao();
        List<Utilizador> expResult = null;
        List<Utilizador> result = instance.getListaUtilizadoresAssociadoAosFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
