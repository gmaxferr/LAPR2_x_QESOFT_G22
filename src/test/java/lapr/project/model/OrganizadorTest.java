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
 * @author guima
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

    /**
     * Test of toString method, of class Organizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        String expResult = "Organizador:\n" + "\tUser: " + nome + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of importContentFromXMLNode method, of class Organizador.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;

        Organizador expResult = null;
        Organizador result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);

    }

    /**
     * Test of exportContentToXMLNode method, of class Organizador.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");

        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);

    }

}
