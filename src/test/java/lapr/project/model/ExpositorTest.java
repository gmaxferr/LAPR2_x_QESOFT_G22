package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * Test of importContentFromXMLNode method, of class Expositor.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Expositor instance = null;
        Expositor expResult = null;
        Expositor result;
        try {
            result = instance.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Expositor.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Expositor instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
