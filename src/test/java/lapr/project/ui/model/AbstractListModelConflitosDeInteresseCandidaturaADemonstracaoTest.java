package lapr.project.ui.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.ConflitoDeInteresseDemonstracao;
import lapr.project.model.FAE;
import lapr.project.model.TipoConflitoDemonstracao;
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
public class AbstractListModelConflitosDeInteresseCandidaturaADemonstracaoTest {

    public AbstractListModelConflitosDeInteresseCandidaturaADemonstracaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private AbstractListModelConflitosDeInteresseCandidaturaADemonstracao instance;
    private List<ConflitoDeInteresseDemonstracao> listaConflitos;
    private ConflitoDeInteresseDemonstracao conf;

    @Before
    public void setUp() {
        listaConflitos = new ArrayList<ConflitoDeInteresseDemonstracao>();
        conf = new ConflitoDeInteresseDemonstracao(new FAE(new Utilizador()), new CandidaturaADemonstracao("desc","a@b.c"), new TipoConflitoDemonstracao("idTipo"));
        listaConflitos.add(conf);
        instance = new AbstractListModelConflitosDeInteresseCandidaturaADemonstracao(listaConflitos);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class
     * AbstractListModelConflitosDeInteresseCandidaturaADemonstracao.
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
     * AbstractListModelConflitosDeInteresseCandidaturaADemonstracao.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int i = 0;
        String expResult = conf.getCandidatura().getDadosCandidatura();
        String result = instance.getElementAt(i);
        assertEquals(expResult, result);
    }

}
