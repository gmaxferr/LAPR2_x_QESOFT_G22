package lapr.project.uiModel;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Expositor;
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
public class ComboBoxModelCandidaturasMostraExpositoresTest {

    public ComboBoxModelCandidaturasMostraExpositoresTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ComboBoxModelCandidaturasMostraExpositores instance;
    List<CandidaturaAExposicao> listaCandidaturas;
    private CandidaturaAExposicao cand;
    private Expositor e;
    private Utilizador u;

    @Before
    public void setUp() {
        u = new Utilizador("a", "b", "Aa.1".toCharArray(), "a@b.c");
        e = new Expositor(u);
        cand = new CandidaturaAExposicao(e);
        listaCandidaturas = new ArrayList<>();
        listaCandidaturas.add(cand);
        instance = new ComboBoxModelCandidaturasMostraExpositores(listaCandidaturas);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class
     * ComboBoxModelCandidaturasMostraExpositores.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElementAt method, of class
     * ComboBoxModelCandidaturasMostraExpositores.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        Object expResult = cand.getEmailExpositor();
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelectedItem method, of class
     * ComboBoxModelCandidaturasMostraExpositores.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Object anItem = cand.getEmailExpositor();
        instance.setSelectedItem(anItem);
    }

    /**
     * Test of getSelectedItem method, of class
     * ComboBoxModelCandidaturasMostraExpositores.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        
        instance.setSelectedItem(cand.getEmailExpositor());
        Object expResult = cand.getEmailExpositor();
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
    }

}
