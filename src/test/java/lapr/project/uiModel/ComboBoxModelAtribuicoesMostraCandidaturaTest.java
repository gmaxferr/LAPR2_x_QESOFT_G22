package lapr.project.uiModel;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicaoCandidatura;
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
public class ComboBoxModelAtribuicoesMostraCandidaturaTest {

    public ComboBoxModelAtribuicoesMostraCandidaturaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ComboBoxModelAtribuicoesMostraCandidatura instance;
    private AtribuicaoCandidatura a;
    private CandidaturaAExposicao cand;
    private List<AtribuicaoCandidatura> listaAtribuicoes;

    @Before
    public void setUp() {
        listaAtribuicoes = new ArrayList<>();
        cand = new CandidaturaAExposicao(new Expositor(new Utilizador()));
        a = new AtribuicaoCandidatura(cand);
        listaAtribuicoes.add(a);
        instance = new ComboBoxModelAtribuicoesMostraCandidatura(listaAtribuicoes);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class
     * ComboBoxModelAtribuicoesMostraCandidatura.
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
     * ComboBoxModelAtribuicoesMostraCandidatura.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int i = 0;
        String expResult = a.getCandidaturaAssociada().getNomeEmpresa() + "; " + a.getCandidaturaAssociada().getUsernameExpositor();
        String result = (String) instance.getElementAt(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelectedItem method, of class
     * ComboBoxModelAtribuicoesMostraCandidatura.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Object anItem = a.getCandidaturaAssociada().getNomeEmpresa() + "; " + a.getCandidaturaAssociada().getUsernameExpositor();
        instance.setSelectedItem(anItem);
    }
    /**
     * Test of getSelectedItem method, of class
     * ComboBoxModelAtribuicoesMostraCandidatura.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        instance.setSelectedItem(a.getCandidaturaAssociada().getNomeEmpresa() + "; " + a.getCandidaturaAssociada().getUsernameExpositor());
        Object expResult = a.getCandidaturaAssociada().getNomeEmpresa() + "; " + a.getCandidaturaAssociada().getUsernameExpositor();
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
    }


}
