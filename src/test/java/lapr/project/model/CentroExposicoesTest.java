package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class CentroExposicoesTest {

    public CentroExposicoesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private CentroExposicoes ce;
    private Utilizador uOrg;
    private Utilizador uFAE;
    private FAE fae;
    private Organizador org;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        uOrg = new Utilizador("a", "b", new char[]{'a', 'A', '.', '6'}, "1@2.3");
        org = new Organizador(uOrg);
        uFAE = new Utilizador("a1", "b1", new char[]{'a', 'A', '.', '8'}, "a@2.3");
        fae = new FAE(uFAE);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        RegistoExposicoes expResult = new RegistoExposicoes(ce);
        ce.setRegistoExposicoes(expResult);
        RegistoExposicoes result = ce.getRegistoExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoExpositores method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoExpositores() {
        System.out.println("getRegistoExpositores");

        RegistoExpositores expResult = new RegistoExpositores();
        ce.setRegistoExpositores(expResult);
        RegistoExpositores result = ce.getRegistoExpositores();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoUtilizadores method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");

        RegistoUtilizadores expResult = new RegistoUtilizadores("");
        ce.setRegistoUtilizadoresPendentes(expResult);
        RegistoUtilizadores result = ce.getRegistoUtilizadoresPendentes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoMecanismos method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoMecanismos() {
        System.out.println("getRegistoMecanismos");

        RegistoMecanismos expResult = new RegistoMecanismos();
        ce.setRegistoMecanismos(expResult);
        RegistoMecanismos result = ce.getRegistoMecanismos();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoRecursos method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoRecursos() {
        System.out.println("getRegistoRecursos");

        RegistoRecursos expResult = new RegistoRecursos();
        ce.setRegistoRecursos(expResult);
        RegistoRecursos result = ce.getRegistoRecursos();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoTiposConflitos method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoTiposConflitos() {
        System.out.println("getRegistoTiposConflitos");

        RegistoTipoConflitos expResult = new RegistoTipoConflitos();
        ce.setRegistoTipoConflitos(expResult);
        RegistoTipoConflitos result = ce.getRegistoTiposConflitos();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoStands method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoStands() {
        System.out.println("getRegistoStands");

        RegistoStands expResult = new RegistoStands();
        ce.setRegistoStands(expResult);
        RegistoStands result = ce.getRegistoStands();
        assertEquals(expResult, result);

    }

    /**
     * Test of isFae method, of class CentroExposicoes.
     */
    @Test
    public void testIsFae() {
        System.out.println("isFae");
        Exposicao e = new Exposicao(ce);
        e.getRegistoFAE().getListaFAE().add(fae);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        boolean expResult = true;
        boolean result = ce.isFae(uFAE);
        assertEquals(expResult, result);

    }

    /**
     * Test of isExpositor method, of class CentroExposicoes.
     */
    @Test
    public void testIsExpositor() {
        System.out.println("isExpositor");
        Utilizador utilizador = null;

        boolean expResult = false;
        boolean result = ce.isExpositor(utilizador);
        assertEquals(expResult, result);

    }

    /**
     * Test of isOrganizador method, of class CentroExposicoes.
     */
    @Test
    public void testIsOrganizador() {
        System.out.println("isOrganizador");
        Exposicao e = new Exposicao(ce);
        e.getRegistoOrganizadores().getListaOrganizadores().add(org);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        boolean expResult = true;
        boolean result = ce.isOrganizador(uOrg);
        assertEquals(expResult, result);

    }

    /**
     * Test of importContentFromXMLNode method, of class CentroExposicoes.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        CentroExposicoes expResult = ce;
        Node node = expResult.exportContentToXMLNode();
        CentroExposicoes result = ce;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);

    }

    /**
     * Test of exportContentToXMLNode method, of class CentroExposicoes.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        CentroExposicoes expResult = ce;
        Node node = expResult.exportContentToXMLNode();
        CentroExposicoes result = ce;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegistoExposicoes method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoExposicoes() {
        System.out.println("setRegistoExposicoes");
        RegistoExposicoes m_registoExposicoes = new RegistoExposicoes(ce);
        ce.setRegistoExposicoes(m_registoExposicoes);
    }

    /**
     * Test of setRegistoUtilizadores method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoUtilizadores() {
        System.out.println("setRegistoUtilizadores");
        RegistoUtilizadores m_registoUtilizadores = new RegistoUtilizadores("tag");
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoUtilizadoresPendentes(m_registoUtilizadores);
    }

    /**
     * Test of setRegistoMecanismos method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoMecanismos() {
        System.out.println("setRegistoMecanismos");
        RegistoMecanismos m_registoMecanismos = new RegistoMecanismos();
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoMecanismos(m_registoMecanismos);
    }

    /**
     * Test of setRegistoRecursos method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoRecursos() {
        System.out.println("setRegistoRecursos");
        RegistoRecursos m_registoRecursos = new RegistoRecursos();
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoRecursos(m_registoRecursos);
    }

    /**
     * Test of setRegistoTipoConflitos method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoTipoConflitos() {
        System.out.println("setRegistoTipoConflitos");
        RegistoTipoConflitos m_registoTipoConflitos = new RegistoTipoConflitos();
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoTipoConflitos(m_registoTipoConflitos);
    }

    /**
     * Test of setRegistoExpositores method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoExpositores() {
        System.out.println("setRegistoExpositores");
        RegistoExpositores m_registoExpositores = new RegistoExpositores();
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoExpositores(m_registoExpositores);
    }

    /**
     * Test of setRegistoStands method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoStands() {
        System.out.println("setRegistoStands");
        RegistoStands m_rStands = new RegistoStands();
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoStands(m_rStands);
    }

}
