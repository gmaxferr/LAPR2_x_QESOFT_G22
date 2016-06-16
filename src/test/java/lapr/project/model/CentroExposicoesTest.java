package lapr.project.model;

import java.util.List;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoExpositores;
import lapr.project.registos.RegistoMecanismos;
import lapr.project.registos.RegistoRecursos;
import lapr.project.registos.RegistoStands;
import lapr.project.registos.RegistoTipoConflitos;
import lapr.project.registos.RegistoUtilizadores;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author guima
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

        RegistoUtilizadores expResult = new RegistoUtilizadores();
        ce.setRegistoUtilizadores(expResult);
        RegistoUtilizadores result = ce.getRegistoUtilizadores();
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
        Node node = null;

        CentroExposicoes expResult = null;
        CentroExposicoes result = ce.importContentFromXMLNode(node);
        assertEquals(expResult, result);

    }

    /**
     * Test of exportContentToXMLNode method, of class CentroExposicoes.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");

        Node expResult = null;
        Node result = ce.exportContentToXMLNode();
        assertEquals(expResult, result);

    }

    /**
     * Test of setRegistoExposicoes method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoExposicoes() {
        System.out.println("setRegistoExposicoes");
        RegistoExposicoes m_registoExposicoes = null;
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoExposicoes(m_registoExposicoes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistoUtilizadores method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoUtilizadores() {
        System.out.println("setRegistoUtilizadores");
        RegistoUtilizadores m_registoUtilizadores = null;
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoUtilizadores(m_registoUtilizadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistoMecanismos method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoMecanismos() {
        System.out.println("setRegistoMecanismos");
        RegistoMecanismos m_registoMecanismos = null;
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoMecanismos(m_registoMecanismos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistoRecursos method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoRecursos() {
        System.out.println("setRegistoRecursos");
        RegistoRecursos m_registoRecursos = null;
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoRecursos(m_registoRecursos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistoTipoConflitos method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoTipoConflitos() {
        System.out.println("setRegistoTipoConflitos");
        RegistoTipoConflitos m_registoTipoConflitos = null;
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoTipoConflitos(m_registoTipoConflitos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistoExpositores method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoExpositores() {
        System.out.println("setRegistoExpositores");
        RegistoExpositores m_registoExpositores = null;
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoExpositores(m_registoExpositores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistoStands method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoStands() {
        System.out.println("setRegistoStands");
        RegistoStands m_rStands = null;
        CentroExposicoes instance = new CentroExposicoes();
        instance.setRegistoStands(m_rStands);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
