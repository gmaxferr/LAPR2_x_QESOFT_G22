/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.Date;
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
public class DataTest {
    
    public DataTest() {
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
     * Test of getAno method, of class Data.
     */
    @Test
    public void testGetAno() {
        System.out.println("getAno");
        Data instance = new Data();
        int expResult = 0;
        int result = instance.getAno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMes method, of class Data.
     */
    @Test
    public void testGetMes() {
        System.out.println("getMes");
        Data instance = new Data();
        int expResult = 0;
        int result = instance.getMes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDia method, of class Data.
     */
    @Test
    public void testGetDia() {
        System.out.println("getDia");
        Data instance = new Data();
        int expResult = 0;
        int result = instance.getDia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class Data.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        int ano = 0;
        int mes = 0;
        int dia = 0;
        Data instance = new Data();
        instance.setData(ano, mes, dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Data.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Data instance = new Data();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toAnoMesDiaString method, of class Data.
     */
    @Test
    public void testToAnoMesDiaString() {
        System.out.println("toAnoMesDiaString");
        Data instance = new Data();
        String expResult = "";
        String result = instance.toAnoMesDiaString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Data.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = null;
        Data instance = new Data();
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Data.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Data outraData = null;
        Data instance = new Data();
        int expResult = 0;
        int result = instance.compareTo(outraData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diaDaSemana method, of class Data.
     */
    @Test
    public void testDiaDaSemana() {
        System.out.println("diaDaSemana");
        Data instance = new Data();
        String expResult = "";
        String result = instance.diaDaSemana();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMaior method, of class Data.
     */
    @Test
    public void testIsMaior() {
        System.out.println("isMaior");
        Data outraData = null;
        Data instance = new Data();
        boolean expResult = false;
        boolean result = instance.isMaior(outraData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diferenca method, of class Data.
     */
    @Test
    public void testDiferenca_Data() {
        System.out.println("diferenca");
        Data outraData = null;
        Data instance = new Data();
        int expResult = 0;
        int result = instance.diferenca(outraData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diferenca method, of class Data.
     */
    @Test
    public void testDiferenca_3args() {
        System.out.println("diferenca");
        int ano = 0;
        int mes = 0;
        int dia = 0;
        Data instance = new Data();
        int expResult = 0;
        int result = instance.diferenca(ano, mes, dia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAnoBissexto method, of class Data.
     */
    @Test
    public void testIsAnoBissexto() {
        System.out.println("isAnoBissexto");
        int ano = 0;
        boolean expResult = false;
        boolean result = Data.isAnoBissexto(ano);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dataAtual method, of class Data.
     */
    @Test
    public void testDataAtual() {
        System.out.println("dataAtual");
        Data expResult = null;
        Data result = Data.dataAtual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toDate method, of class Data.
     */
    @Test
    public void testToDate() {
        System.out.println("toDate");
        Data instance = new Data();
        Date expResult = null;
        Date result = instance.toDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
