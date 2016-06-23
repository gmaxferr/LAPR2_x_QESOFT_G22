/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.model;

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
 * @author guima
 */
public class ModeloJTableUtilizadoresTest {
    
    public ModeloJTableUtilizadoresTest() {
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
     * Test of setLista method, of class ModeloJTableUtilizadores.
     */
    @Test
    public void testSetLista() {
        System.out.println("setLista");
        List<Utilizador> listaFae = null;
        ModeloJTableUtilizadores instance = new ModeloJTableUtilizadores();
        instance.setLista(listaFae);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCellEditable method, of class ModeloJTableUtilizadores.
     */
    @Test
    public void testIsCellEditable() {
        System.out.println("isCellEditable");
        int rowIndex = 0;
        int columnIndex = 0;
        ModeloJTableUtilizadores instance = new ModeloJTableUtilizadores();
        boolean expResult = false;
        boolean result = instance.isCellEditable(rowIndex, columnIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class ModeloJTableUtilizadores.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        ModeloJTableUtilizadores instance = new ModeloJTableUtilizadores();
        String expResult = "";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUtilizador method, of class ModeloJTableUtilizadores.
     */
    @Test
    public void testAddUtilizador() {
        System.out.println("addUtilizador");
        Utilizador utilizador = null;
        ModeloJTableUtilizadores instance = new ModeloJTableUtilizadores();
        instance.addUtilizador(utilizador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowCount method, of class ModeloJTableUtilizadores.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        ModeloJTableUtilizadores instance = new ModeloJTableUtilizadores();
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class ModeloJTableUtilizadores.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        ModeloJTableUtilizadores instance = new ModeloJTableUtilizadores();
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class ModeloJTableUtilizadores.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int rowIndex = 0;
        int columnIndex = 0;
        ModeloJTableUtilizadores instance = new ModeloJTableUtilizadores();
        Object expResult = null;
        Object result = instance.getValueAt(rowIndex, columnIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
