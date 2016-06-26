package lapr.project.uiModel;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
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
public class AbstractListModelDemonstracoesTest {

    public AbstractListModelDemonstracoesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private AbstractListModelDemonstracoes instance;
    private List<Demonstracao> listaDemonstracoes;
    private Demonstracao demo;

    @Before
    public void setUp() {

        listaDemonstracoes = new ArrayList<>();
        demo = new Demonstracao();
        listaDemonstracoes.add(demo);
        instance = new AbstractListModelDemonstracoes(listaDemonstracoes);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class AbstractListModelDemonstracoes.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElementAt method, of class AbstractListModelDemonstracoes.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int i = 0;
        Demonstracao expResult = demo;
        Demonstracao result = (Demonstracao) instance.getElementAt(i);
        assertEquals(expResult, result);
    }

}
