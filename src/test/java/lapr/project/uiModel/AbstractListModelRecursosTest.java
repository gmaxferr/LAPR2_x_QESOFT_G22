package lapr.project.uiModel;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Recurso;
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
public class AbstractListModelRecursosTest {

    public AbstractListModelRecursosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private AbstractListModelRecursos instance;
    private List<Recurso> listaRecursos;
    private Recurso rec;

    @Before
    public void setUp() {

        listaRecursos = new ArrayList<>();
        rec = new Recurso("rec1");
        listaRecursos.add(rec);
        instance = new AbstractListModelRecursos(listaRecursos);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class AbstractListModelRecursos.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElementAt method, of class AbstractListModelRecursos.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int i = 0;
        String expResult = rec.getNomeRecurso();
        String result = (String) instance.getElementAt(i);
        assertEquals(expResult, result);
    }

}
