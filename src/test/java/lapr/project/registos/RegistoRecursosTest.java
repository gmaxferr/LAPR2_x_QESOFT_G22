/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import lapr.project.model.Recurso;
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
public class RegistoRecursosTest {
    
    public RegistoRecursosTest() {
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
     * Test of criarRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testCriarRecurso() {
        System.out.println("criarRecurso");
        String nome = "";
        RegistoRecursos instance = new RegistoRecursos();
        Recurso expResult = null;
        Recurso result = instance.criarRecurso(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDeRecursos method, of class RegistoRecursos.
     */
    @Test
    public void testGetListaDeRecursos() {
        System.out.println("getListaDeRecursos");
        RegistoRecursos instance = new RegistoRecursos();
        ArrayList<Recurso> expResult = null;
        ArrayList<Recurso> result = instance.getListaDeRecursos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testSetRecurso() {
        System.out.println("setRecurso");
        Recurso rec = null;
        RegistoRecursos instance = new RegistoRecursos();
        instance.setRecurso(rec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valida method, of class RegistoRecursos.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        RegistoRecursos instance = new RegistoRecursos();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
