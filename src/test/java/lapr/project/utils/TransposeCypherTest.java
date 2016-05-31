/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

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
public class TransposeCypherTest {

    public TransposeCypherTest() {
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
     * Test of getOrder method, of class TransposeCypher.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        char[] passwd = "MEGABUCK".toCharArray();
        int[] expResult = new int[]{6, 3, 4, 0, 1, 7, 2, 5};
        int[] result = TransposeCypher.getOrder(passwd);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of convertToMask method, of class TransposeCypher.
     */
    @Test
    public void testConvertToMask() {
        System.out.println("convertToMask");
        int[] intArray = new int[]{6, 3, 4, 0, 1, 7, 2, 5};
        int[] expResult = new int[]{3, 4, 6, 1, 2, 7, 0, 5};
        int[] result = TransposeCypher.convertToMask(intArray);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of encrypt method, of class TransposeCypher.
     */
    @Test
    public void testEncrypt() {
        System.out.println("encrypt");
        char[] message = "pleasetransferonemilliondollarstomyswissbankaccountsixtwotwo".toCharArray();
        char[] passwd = "MEGABUCK".toCharArray();
        char[] expResult = "afllsksoselawaiatoossctclnmomantesilyntwrnntsowdpaedobuoeriricxb".toCharArray();
        char[] result = TransposeCypher.encrypt(message, passwd);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class TransposeCypher.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        char[] message = "afllsksoselawaiatoossctclnmomantesilyntwrnntsowdpaedobuoeriricxb".toCharArray();
        char[] passwd = "MEGABUCK".toCharArray();
        char[] expResult = "pleasetransferonemilliondollarstomyswissbankaccountsixtwotwoabcd".toCharArray();
        char[] result = TransposeCypher.decrypt(message, passwd);
        assertArrayEquals(expResult, result);
    }

}
