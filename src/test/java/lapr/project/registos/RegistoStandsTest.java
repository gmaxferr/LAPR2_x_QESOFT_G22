/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.Stand;
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
public class RegistoStandsTest {
    
    public RegistoStandsTest() {
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
     * Test of getListaStands method, of class RegistoStands.
     */
    @Test
    public void testGetListaStands() {
        System.out.println("getListaStands");
        RegistoStands instance = new RegistoStands();
        List<Stand> expResult = null;
        List<Stand> result = instance.getListaStands();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStand method, of class RegistoStands.
     */
    @Test
    public void testAddStand() {
        System.out.println("addStand");
        Stand stand = null;
        RegistoStands instance = new RegistoStands();
        instance.addStand(stand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
