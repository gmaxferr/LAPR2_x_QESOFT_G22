package lapr.project.uiModel;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;
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
public class ComboBoxModelFaeTest {

    public ComboBoxModelFaeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ComboBoxModelFae instance;
    List<FAE> listaFAEs;
    private FAE fae;
    private Utilizador u;
    @Before
    public void setUp() {
        u = new Utilizador("nome", "username", "password".toCharArray(), "email");
        fae = new FAE(u);
        listaFAEs = new ArrayList<>();
        listaFAEs.add(fae);
        instance = new ComboBoxModelFae(listaFAEs);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class ComboBoxModelFae.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElementAt method, of class ComboBoxModelFae.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        Object expResult = fae;
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelectedItem method, of class ComboBoxModelFae.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Object anItem = fae.toString();
        instance.setSelectedItem(anItem);
    }

    /**
     * Test of getSelectedItem method, of class ComboBoxModelFae.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");

        instance.setSelectedItem(fae.toString());
        Object expResult = fae.toString();
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
    }

}
