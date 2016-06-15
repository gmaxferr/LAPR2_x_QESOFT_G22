package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class ExpositorTest {

    public ExpositorTest() {
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
     * Test of getM_strUsername method, of class Expositor.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getM_strUsername");
        Utilizador u = new Utilizador("Nome", "username", "password".toCharArray(), "email@email.com");
        Expositor instance = new Expositor(u);
        assertEquals("username", instance.getUsername());
    }

    /**
     * Test of getEmail method, of class Expositor.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Utilizador u = new Utilizador("Nome", "username", "password".toCharArray(), "email@email.com");
        Expositor instance = new Expositor(u);
        assertEquals("email@email.com", instance.getEmail());
    }

    /**
     * Test of getUtilizador method, of class Expositor.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Utilizador u = new Utilizador("Nome", "username", "password".toCharArray(), "email@email.com");
        Expositor instance = new Expositor(u);
        assertEquals(u, instance.getUtilizador());
    }

    /**
     * Test of setUtilizador method, of class Expositor.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");
        Utilizador u = new Utilizador("Nome", "username", "password".toCharArray(), "email@email.com");
        Expositor instance = new Expositor(u);
        Utilizador u2 = new Utilizador("nome", "username2", "password".toCharArray(), "email2@email.pt");
        instance.setUtilizador(u2);
        assertEquals(u2, instance.getUtilizador());
    }
}
