package lapr.project.uiModel;

import lapr.project.uiModel.ComboBoxModelCandidaturaAExposicao;
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
 * @author guilherme
 */
public class ComboBoxModelCandidaturaAExposicaoTest {

    public ComboBoxModelCandidaturaAExposicaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ComboBoxModelCandidaturaAExposicao instance;
    private CandidaturaAExposicao cand;
    private List<CandidaturaAExposicao> listaCandidaturas;

    @Before
    public void setUp() {
        listaCandidaturas = new ArrayList<>();
        cand = new CandidaturaAExposicao(new Expositor(new Utilizador()));
        listaCandidaturas.add(cand);
        instance = new ComboBoxModelCandidaturaAExposicao(listaCandidaturas);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class ComboBoxModelCandidaturaAExposicao.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElementAt method, of class ComboBoxModelCandidaturaAExposicao.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int i = 0;
        CandidaturaAExposicao expResult = cand;
        CandidaturaAExposicao result = (CandidaturaAExposicao) instance.getElementAt(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelectedItem method, of class
     * ComboBoxModelCandidaturaAExposicao.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        CandidaturaAExposicao anItem = cand;
        instance.setSelectedItem(anItem);
    }

    /**
     * Test of getSelectedItem method, of class
     * ComboBoxModelCandidaturaAExposicao.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        instance.setSelectedItem(cand);
        CandidaturaAExposicao expResult = (CandidaturaAExposicao) cand;
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
    }

}
