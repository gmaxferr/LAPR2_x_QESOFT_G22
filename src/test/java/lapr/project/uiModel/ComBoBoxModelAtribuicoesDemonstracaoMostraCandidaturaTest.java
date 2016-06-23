package lapr.project.uiModel;

import lapr.project.uiModel.ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicaoCandidaturaDemonstracao;
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
public class ComBoBoxModelAtribuicoesDemonstracaoMostraCandidaturaTest {

    public ComBoBoxModelAtribuicoesDemonstracaoMostraCandidaturaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura instance;
    private AtribuicaoCandidaturaDemonstracao a;
    private CandidaturaADemonstracao cand;
    private List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoes;

    @Before
    public void setUp() {
        listaAtribuicoes = new ArrayList<>();
        cand = new CandidaturaADemonstracao("dados", "email@email.email");
        a = new AtribuicaoCandidaturaDemonstracao(cand);
        listaAtribuicoes.add(a);
        instance = new ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura(listaAtribuicoes);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class
     * ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura.
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
     * ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int i = 0;
        String expResult = a.getCandidaturaAssociada().getDadosCandidatura();
        String result = (String) instance.getElementAt(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelectedItem method, of class
     * ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Object anItem = a.getCandidaturaAssociada().getDadosCandidatura();
        instance.setSelectedItem(anItem);
    }

    /**
     * Test of getSelectedItem method, of class
     * ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        instance.setSelectedItem(a.getCandidaturaAssociada().getDadosCandidatura());
        Object expResult = a.getCandidaturaAssociada().getDadosCandidatura();
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
    }

}
