package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.RegistoCandidaturasADemonstracao;
import lapr.project.registos.RegistoFaeAvaliacao;
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
 * @author G29
 */
public class AtribuicaoCandidaturaDemonstracaoTest {

    private AtribuicaoCandidaturaDemonstracao instance;
    private CandidaturaADemonstracao candDemo1;
    private RegistoCandidaturasADemonstracao m_rcd;
    private RegistoUtilizadores m_ru;
    private Utilizador user1;
    private Utilizador expositor;

    public AtribuicaoCandidaturaDemonstracaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        user1 = new Utilizador("nome", "username", "password".toCharArray(), "mail");
        expositor = new Utilizador("nome2", "username2", "password2".toCharArray(), "mail2");
        m_ru = new RegistoUtilizadores("");
        m_ru.addUtilizador(user1);
        m_ru.addUtilizador(expositor);
        candDemo1 = new CandidaturaADemonstracao("dados", "mail2");
        m_rcd = new RegistoCandidaturasADemonstracao();
        m_rcd.getListaCandidaturasADemonstracao().add(candDemo1);
        instance = new AtribuicaoCandidaturaDemonstracao(candDemo1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCandidaturaAssociada method, of class
     * AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testGetCandidaturaAssociada() {
        System.out.println("getCandidaturaAssociada");
        CandidaturaADemonstracao expResult = candDemo1;
        CandidaturaADemonstracao result = instance.getCandidaturaAssociada();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoFaeAvaliacao method, of class
     * AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testGetRegistoFaeAvaliacao() {
        System.out.println("getRegistoFaeAvaliacao");
        RegistoFaeAvaliacao expResult = instance.getRegistoFaeAvaliacao();
        RegistoFaeAvaliacao result = instance.getRegistoFaeAvaliacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFaeAvaliacao method, of class
     * AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testAddFaeAvaliacao() {
        System.out.println("addFaeAvaliacao");
        FAE fae = new FAE(user1);
        instance.addFaeAvaliacao(fae);
        assertEquals(instance.getRegistoFaeAvaliacao().getListaFaeAvaliacao().get(0).getFaeAssociado(), fae);
    }

    /**
     * Test of fix method, of class AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        Node node = instance.exportContentToXMLNode();
        AtribuicaoCandidaturaDemonstracao expResult = new AtribuicaoCandidaturaDemonstracao(null);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        expResult.fix(m_rcd, m_ru);
        boolean result = instance.equals(expResult);
        assertEquals(true, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class
     * AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testImportContentFromXMLNode() throws Exception {
        System.out.println("importContentFromXMLNode");
        Node node = instance.exportContentToXMLNode();
        AtribuicaoCandidaturaDemonstracao expResult = new AtribuicaoCandidaturaDemonstracao(null);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        expResult.fix(m_rcd, m_ru);
        boolean result = instance.equals(expResult);
        assertEquals(true, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class
     * AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node node = instance.exportContentToXMLNode();
        AtribuicaoCandidaturaDemonstracao expResult = new AtribuicaoCandidaturaDemonstracao(null);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        expResult.fix(m_rcd, m_ru);
        boolean result = instance.equals(expResult);
        assertEquals(true, result);
    }

}
