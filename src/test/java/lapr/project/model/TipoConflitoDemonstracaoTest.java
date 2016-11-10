package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
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
public class TipoConflitoDemonstracaoTest {
    
    private TipoConflitoDemonstracao instance;
    private String ID = "id";
    
    public TipoConflitoDemonstracaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new TipoConflitoDemonstracao(ID);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDadosTipoConflito method, of class TipoConflitoDemonstracao.
     */
    @Test
    public void testSetDadosTipoConflito() {
        System.out.println("setDadosTipoConflito");
        String tipoConflito = "dados";
        instance.setDadosTipoConflito(tipoConflito);
    }

    /**
     * Test of getMecanismoDetecaoConflito method, of class TipoConflitoDemonstracao.
     */
    @Test
    public void testGetMecanismoDetecaoConflito() {
        System.out.println("getMecanismoDetecaoConflito");
        MecanismoDetecaoConflitoDemonstracao expResult = new MecanismoDetecaoConflitoDemonstracao(instance);
        instance.setMecanismo(expResult);
        MecanismoDetecaoConflitoDemonstracao result = instance.getMecanismoDetecaoConflito();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMecanismo method, of class TipoConflitoDemonstracao.
     */
    @Test
    public void testSetMecanismo() {
        System.out.println("setMecanismo");
        MecanismoDetecaoConflitoDemonstracao m_mec = new MecanismoDetecaoConflitoDemonstracao(instance);
        instance.setMecanismo(m_mec);
    }

    /**
     * Test of importContentFromXMLNode method, of class TipoConflitoDemonstracao.
     */
    @Test
    public void testImportContentFromXMLNode() throws Exception {
        System.out.println("importContentFromXMLNode");
        Node node = instance.exportContentToXMLNode();
        TipoConflitoDemonstracao expResult = instance;
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        TipoConflitoDemonstracao result = instance;
        assertEquals(expResult, result);
    }

    

    /**
     * Test of exportContentToXMLNode method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node node = instance.exportContentToXMLNode();
        TipoConflitoDemonstracao expResult = instance;
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        TipoConflitoDemonstracao result = instance;
        assertEquals(expResult, result);
    }
}
