package lapr.project.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G29
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
        char[] expResult = ("afllsksoselawai~toossct~lnmomantesilyntwrnntsow~paedobuoeriricx~").toCharArray();
        char[] result = TransposeCypher.encrypt(message, passwd);
        System.out.println(String.valueOf(result));
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class TransposeCypher.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        char[] message = ("afllsksoselawai~toossct~lnmomantesilyntwrnntsow~paedobuoeriricx~").toCharArray();
        char[] passwd = "MEGABUCK".toCharArray();
        char[] expResult = "pleasetransferonemilliondollarstomyswissbankaccountsixtwotwo".toCharArray();
        char[] result = TransposeCypher.decrypt(message, passwd);
        System.out.println(String.valueOf(result));
        assertArrayEquals(expResult, result);
    }

}
