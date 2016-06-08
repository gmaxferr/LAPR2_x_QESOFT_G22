/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
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
public class RegistoUtilizadoresTest {
    
    public RegistoUtilizadoresTest() {
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
     * Test of identificarUtilizadorPeloUsername method, of class RegistoUtilizadores.
     */
    @Test
    public void testIdentificarUtilizadorPeloUsername() {
        System.out.println("identificarUtilizadorPeloUsername");
        String id = "";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = null;
        Utilizador result = instance.identificarUtilizadorPeloUsername(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaUtilizadorPeloID method, of class RegistoUtilizadores.
     */
    @Test
    public void testValidaUtilizadorPeloID() {
        System.out.println("validaUtilizadorPeloID");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = false;
        boolean result = instance.validaUtilizadorPeloID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaUtilizadores method, of class RegistoUtilizadores.
     */
    @Test
    public void testGetListaUtilizadores() {
        System.out.println("getListaUtilizadores");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        List<Utilizador> expResult = null;
        List<Utilizador> result = instance.getListaUtilizadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        String id = "";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = null;
        Utilizador result = instance.getUtilizador(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of identificarUtilizadorPeloId method, of class RegistoUtilizadores.
     */
    @Test
    public void testIdentificarUtilizadorPeloId() {
        System.out.println("identificarUtilizadorPeloId");
        String id = "";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = false;
        boolean result = instance.identificarUtilizadorPeloId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novoUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testNovoUtilizador() {
        System.out.println("novoUtilizador");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = null;
        Utilizador result = instance.novoUtilizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testAddUtilizador() {
        System.out.println("addUtilizador");
        Utilizador u = null;
        RegistoUtilizadores instance = new RegistoUtilizadores();
        instance.addUtilizador(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaNovosRegistos method, of class RegistoUtilizadores.
     */
    @Test
    public void testGetListaNovosRegistos() {
        System.out.println("getListaNovosRegistos");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        ArrayList<Utilizador> expResult = null;
        ArrayList<Utilizador> result = instance.getListaNovosRegistos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of identificarUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testIdentificarUtilizador() {
        System.out.println("identificarUtilizador");
        String username = "";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = null;
        Utilizador result = instance.identificarUtilizador(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaDadosUnicos method, of class RegistoUtilizadores.
     */
    @Test
    public void testValidaDadosUnicos() {
        System.out.println("validaDadosUnicos");
        String username = "";
        String email = "";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = false;
        boolean result = instance.validaDadosUnicos(username, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
