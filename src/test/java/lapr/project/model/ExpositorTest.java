package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
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

    private Expositor instance;
    private Utilizador u;
    private String username;
    private String email;
    private char[] password;
    private String nome;
    
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
        username = "username";
        email = "email@email.com";
        password="password".toCharArray();
        nome = "Nome";
        u = new Utilizador(nome, username, password, email);
        instance = new Expositor(u);
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
        assertEquals("username", instance.getUsername());
    }

    /**
     * Test of getEmail method, of class Expositor.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        assertEquals("email@email.com", instance.getEmail());
    }

    /**
     * Test of getUtilizador method, of class Expositor.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        assertEquals(u, instance.getUtilizador());
    }

    /**
     * Test of setUtilizador method, of class Expositor.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");
        Utilizador u = new Utilizador("Nome", "username", "password".toCharArray(), "email@email.com");
        instance.setUtilizador(u);
        assertEquals(u, instance.getUtilizador());
    }
}
