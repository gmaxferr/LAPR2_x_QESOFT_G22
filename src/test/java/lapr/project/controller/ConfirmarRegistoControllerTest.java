/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
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
public class ConfirmarRegistoControllerTest {
    
    public ConfirmarRegistoControllerTest() {
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
     * Test of getRegistoUtilizadores method, of class ConfirmarRegistoController.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        ConfirmarRegistoController instance = null;
        instance.getRegistoUtilizadores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaNovosRegistos method, of class ConfirmarRegistoController.
     */
    @Test
    public void testGetListaNovosRegistos() {
        System.out.println("getListaNovosRegistos");
        ConfirmarRegistoController instance = null;
        ArrayList<Utilizador> expResult = null;
        ArrayList<Utilizador> result = instance.getListaNovosRegistos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUtilizadorRegistado method, of class ConfirmarRegistoController.
     */
    @Test
    public void testSetUtilizadorRegistado() {
        System.out.println("setUtilizadorRegistado");
        Utilizador u = null;
        ConfirmarRegistoController instance = null;
        instance.setUtilizadorRegistado(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
