/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

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
public class RecursoTest {
    
    public RecursoTest() {
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
     * Test of getNomeRecurso method, of class Recurso.
     */
    @Test
    public void testGetNomeRecurso() {
        System.out.println("getNomeRecurso");
        Recurso instance = null;
        String expResult = "";
        String result = instance.getNomeRecurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomeRecurso method, of class Recurso.
     */
    @Test
    public void testSetNomeRecurso() {
        System.out.println("setNomeRecurso");
        String nomeRecurso = "";
        Recurso instance = null;
        instance.setNomeRecurso(nomeRecurso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
