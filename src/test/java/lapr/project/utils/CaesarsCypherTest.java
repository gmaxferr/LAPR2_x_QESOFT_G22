/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class CaesarsCypherTest {

    public static final String alfabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,:;-";
    
    /**
     * Test of encrypt method, of class CaesarsCypher.
     */
    @Test
    public void testEncrypt() {
        System.out.println("encrypt");
        char[] arrChar = "ABCDEFGHI".toCharArray();
        int shifts = 1;
        char[] expResult = "BCDEFGHIJ".toCharArray();
        char[] result = CaesarsCypher.encrypt(arrChar, shifts, alfabet);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class CaesarsCypher.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        char[] arrChar = "BCDEFGHIJ".toCharArray();
        int shifts = 1;
        char[] expResult = "ABCDEFGHI".toCharArray();
        char[] result = CaesarsCypher.decrypt(arrChar, shifts, alfabet);
        assertArrayEquals(expResult, result);
    }
    
}
