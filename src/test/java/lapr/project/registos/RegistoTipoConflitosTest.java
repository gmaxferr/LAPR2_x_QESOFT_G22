/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.TipoConflito;
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
public class RegistoTipoConflitosTest {
    
    public RegistoTipoConflitosTest() {
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
     * Test of getListaTipoConflitos method, of class RegistoTipoConflitos.
     */
    @Test
    public void testGetListaTipoConflitos() {
        System.out.println("getListaTipoConflitos");
        RegistoTipoConflitos instance = new RegistoTipoConflitos();
        List<TipoConflito> expResult = null;
        List<TipoConflito> result = instance.getListaTipoConflitos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novoTipoConflito method, of class RegistoTipoConflitos.
     */
    @Test
    public void testNovoTipoConflito() {
        System.out.println("novoTipoConflito");
        RegistoTipoConflitos instance = new RegistoTipoConflitos();
        TipoConflito expResult = null;
        TipoConflito result = instance.novoTipoConflito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaTipoDeConflito method, of class RegistoTipoConflitos.
     */
    @Test
    public void testValidaTipoDeConflito() {
        System.out.println("validaTipoDeConflito");
        TipoConflito tipoConflito = null;
        RegistoTipoConflitos instance = new RegistoTipoConflitos();
        boolean expResult = false;
        boolean result = instance.validaTipoDeConflito(tipoConflito);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class RegistoTipoConflitos.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        TipoConflito tipoConflito = null;
        RegistoTipoConflitos instance = new RegistoTipoConflitos();
        boolean expResult = false;
        boolean result = instance.add(tipoConflito);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
