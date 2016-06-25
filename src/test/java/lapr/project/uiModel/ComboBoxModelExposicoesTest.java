package lapr.project.uiModel;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.utils.Data;
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
public class ComboBoxModelExposicoesTest {

    public ComboBoxModelExposicoesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ComboBoxModelExposicoes instance;
    List<Exposicao> listaExposicoes;
    private Exposicao e;
    private String titulo;
    private String descricao;

    @Before
    public void setUp() {
        titulo = "titulo";
        descricao = "desc";
        e = new Exposicao(titulo, descricao, new Data(2012, 01, 8), new Data(2012, 01, 8), new Data(2012, 01, 8), new Data(2012, 01, 8), new Data(2012, 01, 8),new Data(2012,01,9), new Local("local"), new CentroExposicoes());
        listaExposicoes = new ArrayList<>();
        listaExposicoes.add(e);
        instance = new ComboBoxModelExposicoes(listaExposicoes);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class ComboBoxModelExposicoes.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElementAt method, of class ComboBoxModelExposicoes.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        Object expResult = e.getTitulo();
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelectedItem method, of class ComboBoxModelExposicoes.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Object anItem = e.getTitulo();
        instance.setSelectedItem(anItem);
    }

    /**
     * Test of getSelectedItem method, of class ComboBoxModelExposicoes.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");

        instance.setSelectedItem(e.getTitulo());
        Object expResult = e.getTitulo();
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
    }

}
