/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import crypt.CaesarsCypher;
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
public class CaesarsCypherTest {
    
    public CaesarsCypherTest() {
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
     * Test of encrypt method, of class CaesarsCypher.
     */
    @Test
    public void testEncrypt() {
        System.out.println("encrypt");
        char[] arrChar = null;
        int shifts = 0;
        char[] expResult = null;
        char[] result = CaesarsCypher.encrypt(arrChar, shifts);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrypt method, of class CaesarsCypher.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        char[] arrChar = null;
        int shifts = 0;
        char[] expResult = null;
        char[] result = CaesarsCypher.decrypt(arrChar, shifts);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
