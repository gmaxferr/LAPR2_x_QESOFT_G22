package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class ConflitoDeInteresseDemonstracaoTest {

    private ConflitoDeInteresseDemonstracao instance;
    private FAE fae;
    private CandidaturaADemonstracao cand;
    private TipoConflitoDemonstracao tipoConflito;

    public ConflitoDeInteresseDemonstracaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fae = new FAE();
        cand = new CandidaturaADemonstracao("dados", "email");
        tipoConflito = new TipoConflitoDemonstracao("ID");
        instance = new ConflitoDeInteresseDemonstracao(fae, cand, tipoConflito);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFae method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testGetFae() {
        System.out.println("getFae");
        FAE expResult = fae;
        FAE result = instance.getFae();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCandidatura method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testGetCandidatura() {
        System.out.println("getCandidatura");
        CandidaturaADemonstracao expResult = cand;
        CandidaturaADemonstracao result = instance.getCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipo method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        TipoConflitoDemonstracao expResult = tipoConflito;
        TipoConflitoDemonstracao result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of fix method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoCandidaturasAExposicao rc = new RegistoCandidaturasAExposicao(new Exposicao(new CentroExposicoes()));
        instance.fix(rc);
    }
}
