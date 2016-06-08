/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.AtribuicaoStand;
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
public class RegistoAtribuicoesStandsTest {
    
    public RegistoAtribuicoesStandsTest() {
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
     * Test of getListaAtribuicoesStand method, of class RegistoAtribuicoesStands.
     */
    @Test
    public void testGetListaAtribuicoesStand() {
        System.out.println("getListaAtribuicoesStand");
        RegistoAtribuicoesStands instance = new RegistoAtribuicoesStands();
        List<AtribuicaoStand> expResult = null;
        List<AtribuicaoStand> result = instance.getListaAtribuicoesStand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaAtribuicoesStand method, of class RegistoAtribuicoesStands.
     */
    @Test
    public void testSetListaAtribuicoesStand() {
        System.out.println("setListaAtribuicoesStand");
        List<AtribuicaoStand> listaAtribuicoesStand = null;
        RegistoAtribuicoesStands instance = new RegistoAtribuicoesStands();
        instance.setListaAtribuicoesStand(listaAtribuicoesStand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class RegistoAtribuicoesStands.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        List<AtribuicaoStand> listAtr = null;
        RegistoAtribuicoesStands instance = new RegistoAtribuicoesStands();
        instance.addAll(listAtr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
