/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.Mecanismo;
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
public class RegistoMecanismosTest {
    
    public RegistoMecanismosTest() {
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
     * Test of getListaMecanismos method, of class RegistoMecanismos.
     */
    @Test
    public void testGetListaMecanismos() {
        System.out.println("getListaMecanismos");
        RegistoMecanismos instance = new RegistoMecanismos();
        List<Mecanismo> expResult = null;
        List<Mecanismo> result = instance.getListaMecanismos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMecanismo method, of class RegistoMecanismos.
     */
    @Test
    public void testAddMecanismo() {
        System.out.println("addMecanismo");
        Mecanismo mecanismo = null;
        RegistoMecanismos instance = new RegistoMecanismos();
        instance.addMecanismo(mecanismo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
