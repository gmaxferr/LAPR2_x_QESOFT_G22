package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class OrganizadorTest {

    public OrganizadorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private Organizador instance;
    private Utilizador u;
    private char[] pass;
    private String username;
    private String nome;
    private String email;

    @Before
    public void setUp() {

        nome = "a";
        username = "b";
        pass = new char[]{'a', 'B', '.', '7'};
        email = "a@2.c";
        u = new Utilizador(nome, username, pass, email);
        instance = new Organizador(u);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUtilizador method, of class Organizador.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");

        Utilizador expResult = u;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUtilizador method, of class Organizador.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");
        instance.setUtilizador(u);
    }

    /**
     * Test of getUsernameOrganizador method, of class Organizador.
     */
    @Test
    public void testGetUsernameOrganizador() {
        System.out.println("getUsernameOrganizador");

        String expResult = username;
        String result = instance.getUsernameOrganizador();
        assertEquals(expResult, result);

    }
}
