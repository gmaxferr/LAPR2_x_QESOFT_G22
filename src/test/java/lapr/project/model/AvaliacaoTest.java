package lapr.project.model;

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
     * Test of verificaAvaliacaoJaTomada method, of class Avaliacao.
     */
    @Test
    public void testVerificaAvaliacaoJaTomada() {
        System.out.println("verificaAvaliacaoJaTomada");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "fgfg", 0, 0, 0, 0, 0);

        assertEquals(true, instance.verificaAvaliacaoJaTomada());
    }

    /**
     * Test of setAvalicao method, of class Avaliacao.
     */
    @Test
    public void testSetAvalicao() {
        System.out.println("setAvalicao");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "just", 0, 1, 2, 3, 4);

        assertEquals(true, instance.getAvaliacao() == true
                && instance.getJustificacao().equalsIgnoreCase("just")
                && instance.getRatingConhecimentoSobreOTema() == 0
                && instance.getRatingAdequacaoAExposicao() == 1
                && instance.getRatingAdequacaoAsDemos() == 2
                && instance.getRatingAdequacaoNumConvites() == 3
                && instance.getRatingRecomendacaoGlobal() == 4);
    }

    /**
     * Test of setAvalicaoParaDemonstracao method, of class Avaliacao.
     */
    @Test
    public void testSetAvalicaoParaDemonstracao() {
        System.out.println("setAvalicaoParaDemonstracao");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicaoParaDemonstracao(true, "just");
        assertEquals(true, instance.getAvaliacao() == true && instance.getJustificacao().equalsIgnoreCase("just"));
    }

    /**
     * Test of getAvaliacao method, of class Avaliacao.
     */
    @Test
    public void testGetAvaliacao() {
        System.out.println("getAvaliacao");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "just", 0, 0, 0, 0, 0);
        assertEquals(true, instance.getAvaliacao());
    }

    /**
     * Test of getJustificacao method, of class Avaliacao.
     */
    @Test
    public void testGetJustificacao() {
        System.out.println("getJustificacao");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "just", 0, 0, 0, 0, 0);
        assertEquals("just", instance.getJustificacao());
    }

    /**
     * Test of getRatingConhecimentoSobreOTema method, of class Avaliacao.
     */
    @Test
    public void testGetRatingConhecimentoSobreOTema() {
        System.out.println("getRatingConhecimentoSobreOTema");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "just", 1, 0, 0, 0, 0);
        assertEquals(1, instance.getRatingConhecimentoSobreOTema());
    }

    /**
     * Test of getRatingAdequacaoAExposicao method, of class Avaliacao.
     */
    @Test
    public void testGetRatingAdequacaoAExposicao() {
        System.out.println("getRatingAdequacaoAExposicao");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "just", 0, 1, 0, 0, 0);
        assertEquals(1, instance.getRatingAdequacaoAExposicao());
    }

    /**
     * Test of getRatingAdequacaoAsDemos method, of class Avaliacao.
     */
    @Test
    public void testGetRatingAdequacaoAsDemos() {
        System.out.println("getRatingAdequacaoAsDemos");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "just", 0, 0, 1, 0, 0);
        assertEquals(1, instance.getRatingAdequacaoAsDemos());
    }

    /**
     * Test of getRatingAdequacaoNumConvites method, of class Avaliacao.
     */
    @Test
    public void testGetRatingAdequacaoNumConvites() {
        System.out.println("getRatingAdequacaoNumConvites");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "just", 0, 0, 0, 1, 0);
        assertEquals(1, instance.getRatingAdequacaoNumConvites());
    }

    /**
     * Test of getRatingRecomendacaoGlobal method, of class Avaliacao.
     */
    @Test
    public void testGetRatingRecomendacaoGlobal() {
        System.out.println("getRatingRecomendacaoGlobal");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "just", 0, 0, 0, 0, 1);
        assertEquals(1, instance.getRatingRecomendacaoGlobal());
    }

    /**
     * Test of getMediaRatings method, of class Avaliacao.
     */
    @Test
    public void testGetMediaRatings() {
        System.out.println("getMediaRatings");
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(true, "just", 1, 2, 3, 4, 5);
        assertEquals(2f, instance.getMediaRatings());
    }
}
