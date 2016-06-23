package lapr.project.uiModel;

import lapr.project.uiModel.ComboBoxModelCandidaturaADemonstracao;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;
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
public class ComboBoxModelCandidaturaADemonstracaoTest {

    public ComboBoxModelCandidaturaADemonstracaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ComboBoxModelCandidaturaADemonstracao instance;
    private CandidaturaADemonstracao cand;
    private List<CandidaturaADemonstracao> listaCandidaturas;

    @Before
    public void setUp() {
        listaCandidaturas = new ArrayList<>();
        cand = new CandidaturaADemonstracao("dados", "email");
        listaCandidaturas.add(cand);
        instance = new ComboBoxModelCandidaturaADemonstracao(listaCandidaturas);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class ComboBoxModelCandidaturaADemonstracao.
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
     * ComboBoxModelCandidaturaADemonstracao.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int i = 0;
        CandidaturaADemonstracao expResult = cand;
        CandidaturaADemonstracao result = (CandidaturaADemonstracao) instance.getElementAt(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelectedItem method, of class
     * ComboBoxModelCandidaturaADemonstracao.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        CandidaturaADemonstracao anItem = cand;
        instance.setSelectedItem(anItem);
    }

    /**
     * Test of getSelectedItem method, of class
     * ComboBoxModelCandidaturaADemonstracao.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        instance.setSelectedItem(cand);
        CandidaturaADemonstracao expResult = (CandidaturaADemonstracao) cand;
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
    }

}
