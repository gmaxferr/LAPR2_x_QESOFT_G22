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
 * @author guima
 */
public class GestorDeExposicoesTest {
    
    public GestorDeExposicoesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private Utilizador u;
    private GestorDeExposicoes instance;
    
    @Before
    public void setUp() {
        u = new Utilizador();
        instance = new GestorDeExposicoes(u);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUtilizador method, of class GestorDeExposicoes.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Utilizador expResult = u;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
    }
    
}
