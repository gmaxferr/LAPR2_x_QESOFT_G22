/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.Calendar;
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

    Data testData1;
    Data testData2;

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
        testData1 = new Data(1997, 12, 1);
        testData2 = new Data(2016, 6, 8);
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
        int expResult = 1997;
        int result = testData1.getAno();
        assertEquals(expResult, result);
        expResult = 2016;
        result = testData2.getAno();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMes method, of class Data.
     */
    @Test
    public void testGetMes() {
        int expResult = 12;
        int result = testData1.getMes();
        assertEquals(expResult, result);
        expResult = 6;
        result = testData2.getMes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDia method, of class Data.
     */
    @Test
    public void testGetDia() {
        System.out.println("getDia");
        int expResult = 1;
        int result = testData1.getDia();
        assertEquals(expResult, result);
        expResult = 8;
        result = testData2.getDia();
        assertEquals(expResult, result);
    }

    /**
     * Test of setData method, of class Data.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        int expAno = 1234;
        int expMes = 12;
        int expDia = 3;
        testData1.setData(1234, 12, 3);
        int ano = testData1.getAno();
        int mes = testData1.getMes();
        int dia = testData1.getDia();
        assertEquals(ano, expAno);
        assertEquals(mes, expMes);
        assertEquals(dia, expDia);
    }

    /**
     * Test of toString method, of class Data.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Segunda-feira, 1 de Dezembro de 1997";
        String result = testData1.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toAnoMesDiaString method, of class Data.
     */
    @Test
    public void testToAnoMesDiaString() {
        System.out.println("toAnoMesDiaString");
        String expResult = "1997/12/01";
        String result = testData1.toAnoMesDiaString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Data.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Data outroObjeto = new Data(1997, 12, 1);
        boolean expResult = true;
        boolean result = testData1.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Data.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Data outraData = new Data(1997, 12, 2);
        int expResult = -1;
        int result = testData1.compareTo(outraData);
        assertEquals(expResult, result);
        outraData = new Data(1997, 12, 1);
        expResult = 0;
        result = testData1.compareTo(outraData);
        assertEquals(expResult, result);
        outraData = new Data(1997, 11, 30);
        expResult = 1;
        result = testData1.compareTo(outraData);
        assertEquals(expResult, result);
    }

    /**
     * Test of diaDaSemana method, of class Data.
     */
    @Test
    public void testDiaDaSemana() {
        System.out.println("diaDaSemana");
        String expResult = "Segunda-feira";
        String result = testData1.diaDaSemana();
        assertEquals(expResult, result);
    }

    /**
     * Test of isMaior method, of class Data.
     */
    @Test
    public void testIsMaior() {
        boolean expResult = true;
        boolean result = testData2.isMaior(testData1);
        assertEquals(expResult, result);
        expResult = false;
        result = testData1.isMaior(testData2);
        assertEquals(expResult, result);
    }

    /**
     * Test of diferenca method, of class Data.
     */
    @Test
    public void testDiferenca_Data() {
        System.out.println("diferenca");
        int expResult = 6764;   //Valor retirado do Google para este teste
        int result = testData1.diferenca(testData2);
        assertEquals(expResult, result);
        result = testData2.diferenca(testData1);
        assertEquals(expResult, result);
    }

    /**
     * Test of diferenca method, of class Data.
     */
    @Test
    public void testDiferenca_3args() {
        System.out.println("diferenca");
        int ano = 2016;
        int mes = 6;
        int dia = 8;
        int expResult = 6764;
        int result = testData1.diferenca(ano, mes, dia);
        assertEquals(expResult, result);
        ano = 1997;
        mes = 12;
        dia = 1;
        expResult = 6764;
        result = testData2.diferenca(ano, mes, dia);
        assertEquals(expResult, result);
    }

    /**
     * Test of isAnoBissexto method, of class Data.
     */
    @Test
    public void testIsAnoBissexto() {
        System.out.println("isAnoBissexto");
        int ano[] = new int[]{2000, 2001, 2002, 2003, 2004};
        boolean expResult[] = new boolean[]{true, false, false, false, true};
        for (int i = 0; i < 5; i++) {
            boolean result = Data.isAnoBissexto(ano[i]);
            assertEquals(expResult[i], result);
        }
    }

    /**
     * Test of dataAtual method, of class Data.
     */
    @Test
    public void testDataAtual() {
        System.out.println("dataAtual");
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;    // janeiro é representado por 0
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        Data expResult = new Data(ano, mes, dia);
        Data result = Data.dataAtual();
        assertEquals(expResult, result);
    }

    /**
     * Test of toDate method, of class Data.
     */
    @Test
    public void testToDate() {
        System.out.println("toDate");
        Data instance = new Data();
        Date expResult = Calendar.getInstance().getTime();
        Date result = instance.toDate();
        assertEquals(expResult, result);
    }

}
