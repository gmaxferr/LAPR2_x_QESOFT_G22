package lapr.project.model;

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
public class MecanismoTest {
    
    public MecanismoTest() {
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
     * Test of getNome method, of class Mecanismo.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Mecanismo instance = new MecanismoImpl();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescricao method, of class Mecanismo.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Mecanismo instance = new MecanismoImpl();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    public class MecanismoImpl implements Mecanismo {

        public String getNome() {
            return "";
        }

        public String getDescricao() {
            return "";
        }
    }
    
}
