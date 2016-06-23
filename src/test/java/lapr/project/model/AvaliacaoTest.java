package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class AvaliacaoTest {

    public AvaliacaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setAvaliacaoCandidaturaAExposicao method, of class Avaliacao.
     */
    @Test
    public void testSetAvalicao() {
        System.out.println("setAvalicao");
        Avaliacao instance = new Avaliacao();
        instance.setAvaliacaoCandidaturaAExposicao(0, 1, 2, 3, 4);

        assertEquals(true, instance.getRatingConhecimentoSobreOTema() == 0
                && instance.getRatingAdequacaoAExposicao() == 1
                && instance.getRatingAdequacaoAsDemos() == 2
                && instance.getRatingAdequacaoNumConvites() == 3
                && instance.getRatingRecomendacaoGlobal() == 4);
    }

    /**
     * Test of getRatingConhecimentoSobreOTema method, of class Avaliacao.
     */
    @Test
    public void testGetRatingConhecimentoSobreOTema() {
        System.out.println("getRatingConhecimentoSobreOTema");
        Avaliacao instance = new Avaliacao();
        instance.setAvaliacaoCandidaturaAExposicao(1, 0, 0, 0, 0);
        assertEquals(1, instance.getRatingConhecimentoSobreOTema());
    }

    /**
     * Test of getRatingAdequacaoAExposicao method, of class Avaliacao.
     */
    @Test
    public void testGetRatingAdequacaoAExposicao() {
        System.out.println("getRatingAdequacaoAExposicao");
        Avaliacao instance = new Avaliacao();
        instance.setAvaliacaoCandidaturaAExposicao(0, 1, 0, 0, 0);
        assertEquals(1, instance.getRatingAdequacaoAExposicao());
    }

    /**
     * Test of getRatingAdequacaoAsDemos method, of class Avaliacao.
     */
    @Test
    public void testGetRatingAdequacaoAsDemos() {
        System.out.println("getRatingAdequacaoAsDemos");
        Avaliacao instance = new Avaliacao();
        instance.setAvaliacaoCandidaturaAExposicao(0, 0, 1, 0, 0);
        assertEquals(1, instance.getRatingAdequacaoAsDemos());
    }

    /**
     * Test of getRatingAdequacaoNumConvites method, of class Avaliacao.
     */
    @Test
    public void testGetRatingAdequacaoNumConvites() {
        System.out.println("getRatingAdequacaoNumConvites");
        Avaliacao instance = new Avaliacao();
        instance.setAvaliacaoCandidaturaAExposicao(0, 0, 0, 1, 0);
        assertEquals(1, instance.getRatingAdequacaoNumConvites());
    }

    /**
     * Test of getRatingRecomendacaoGlobal method, of class Avaliacao.
     */
    @Test
    public void testGetRatingRecomendacaoGlobal() {
        System.out.println("getRatingRecomendacaoGlobal");
        Avaliacao instance = new Avaliacao();
        instance.setAvaliacaoCandidaturaAExposicao(0, 0, 0, 0, 1);
        assertEquals(1, instance.getRatingRecomendacaoGlobal());
    }

    /**
     * Test of getMediaRatingsCandidaturaAExposicao method, of class Avaliacao.
     */
    @Test
    public void testGetMediaRatings() {
        System.out.println("getMediaRatings");
        Avaliacao instance = new Avaliacao();
        instance.setAvaliacaoCandidaturaAExposicao(1, 2, 3, 4, 5);
        assertEquals(3f, instance.getMediaRatingsCandidaturaAExposicao(), 0.1f);
    }

    /**
     * Test of importContentFromXMLNode method, of class Avaliacao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Avaliacao instance = new Avaliacao();
        Node node = instance.exportContentToXMLNode();
        Avaliacao expResult = new Avaliacao();
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        Avaliacao result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Avaliacao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Avaliacao instance = new Avaliacao();
        Node node = instance.exportContentToXMLNode();
        Avaliacao expResult = new Avaliacao();
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        Avaliacao result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Avaliacao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Avaliacao obj = new Avaliacao();
        Avaliacao instance = new Avaliacao();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Avaliacao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Avaliacao obj = new Avaliacao();
        Avaliacao instance = new Avaliacao();
        int expResult = obj.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
}
