package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.Demonstracao.*;
import lapr.project.registos.*;
import lapr.project.utils.Data;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class DemonstracaoTest {

    public DemonstracaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private Demonstracao instance;
    private Demonstracao instance1;
    private String descricao;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        descricao = "desc";
        instance = new Demonstracao(descricao, e);
        instance1 = new Demonstracao(descricao, e);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setDescricao method, of class Demonstracao.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        instance.setDescricao("Descricao");
        assertEquals("Descricao", instance.getDescricao());
    }

    /**
     * Test of getRegistoRecursosNecessarios method, of class Demonstracao.
     */
    @Test
    public void testGetRegistoRecursosNecessarios() {
        System.out.println("getRegistoRecursosNecessarios");

    }

    /**
     * Test of getCodigoIdentificacao method, of class Demonstracao.
     */
    @Test
    public void testGetCodigoIdentificacao() {
        System.out.println("getCodigoIdentificacao");
        instance.setCodigoIdentificacao("codigo");
        assertEquals("codigo", instance.getCodigoIdentificacao());
    }

    /**
     * Test of getEstadoDemo method, of class Demonstracao.
     */
    @Test
    public void testGetEstadoDemo() {
        System.out.println("getEstadoDemo");
        EstadoDemonstracao estado = new EstadoDemonstracaoCancelada(instance);
        instance.setEstado(estado);
        assertEquals(estado, instance.getEstadoDemo());
    }

    /**
     * Test of getDataInicioCand method, of class Demonstracao.
     */
    @Test
    public void testGetDataInicioCand() {
        System.out.println("getDataInicioCand");
        Data data = new Data(1996, 5, 25);
        instance.setDataInicioCandidaturas(data);
        assertEquals(data, instance.getDataInicioCand());
    }

    /**
     * Test of getDataFimCand method, of class Demonstracao.
     */
    @Test
    public void testGetDataFimCand() {
        System.out.println("getDataFimCand");
        Data data = new Data(1996, 5, 25);
        instance.setDataFimCandidaturas(data);
        assertEquals(data, instance.getDataFimCand());
    }

    /**
     * Test of setCodigoIdentificacao method, of class Demonstracao.
     */
    @Test
    public void testSetCodigoIdentificacao() {
        System.out.println("setCodigoIdentificacao");
        instance.setCodigoIdentificacao("novoCodigo");
        assertEquals("novoCodigo", instance.getCodigoIdentificacao());
    }

    /**
     * Test of getRegistoCandidaturasADemonstracao method, of class
     * Demonstracao.
     */
    @Test
    public void testGetRegistoCandidaturasADemonstracao() {
        System.out.println("getRegistoCandidaturasADemonstracao");

    }

    /**
     * Test of setDataInicioCandidaturas method, of class Demonstracao.
     */
    @Test
    public void testSetDataInicioCandidaturas() {
        System.out.println("setDataInicioCandidaturas");
        Data data = new Data(1996, 5, 25);
        instance.setDataInicioCandidaturas(data);
        assertEquals(data, instance.getDataInicioCand());
    }

    /**
     * Test of setDataFimCandidaturas method, of class Demonstracao.
     */
    @Test
    public void testSetDataFimCandidaturas() {
        System.out.println("setDataFimCandidaturas");
        Data data = new Data(1996, 5, 25);
        instance.setDataFimCandidaturas(data);
        assertEquals(data, instance.getDataFimCand());
    }

    /**
     * Test of getCandidaturasDemoExpositor method, of class Demonstracao.
     */
    @Test
    public void testGetCandidaturasDemoExpositor() {
        System.out.println("getCandidaturasDemoExpositor");

    }

    /**
     * Test of equals method, of class Demonstracao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        instance.setCodigoIdentificacao("codigo");
        instance1.setCodigoIdentificacao("codigo");
        assertEquals(true, instance.equals(instance1));
    }

    /**
     * Test of schedule method, of class Demonstracao.
     */
    @Test
    public void testSchedule() {
        System.out.println("schedule");

    }

    /**
     * Test of getListaOrganizadores method, of class Demonstracao.
     */
    @Test
    public void testGetListaOrganizadores() {
        System.out.println("getListaOrganizadores");

    }

    /**
     * Test of getListaFAE method, of class Demonstracao.
     */
    @Test
    public void testGetListaFAE() {
        System.out.println("getListaFAE");

    }

    /**
     * Test of setEstado method, of class Demonstracao.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoDemonstracao estado = new EstadoDemonstracaoCandidaturasFechadas(instance);
        instance.setEstado(estado);
        assertEquals(estado, instance.getEstadoDemo());
    }

    /**
     * Test of getRegistoCandidaturasADemonstracaoRemovidas method, of class
     * Demonstracao.
     */
    @Test
    public void testGetRegistoCandidaturasADemonstracaoRemovidas() {
        System.out.println("getRegistoCandidaturasADemonstracaoRemovidas");
        RegistoCandidaturasADemonstracaoRemovidas expResult = instance.getRegistoCandidaturasADemonstracaoRemovidas();
        RegistoCandidaturasADemonstracaoRemovidas result = instance.getRegistoCandidaturasADemonstracaoRemovidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataFimDetecaoConflitos method, of class Demonstracao.
     */
    @Test
    public void testSetDataFimDetecaoConflitos() {
        System.out.println("setDataFimDetecaoConflitos");
        Data dataFimDetecaoConflitos = new Data(2018, 12, 5);
        instance.setDataFimDetecaoConflitos(dataFimDetecaoConflitos);
        assertEquals(dataFimDetecaoConflitos, instance.getDataFimDetecaoConflitos());
    }

    /**
     * Test of hashCode method, of class Demonstracao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Demonstracao testDemo = instance1;
        int expResult = testDemo.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataFimDetecaoConflitos method, of class Demonstracao.
     */
    @Test
    public void testGetDataFimDetecaoConflitos() {
        System.out.println("getDataFimDetecaoConflitos");
        Data expResult = new Data(2018, 12, 7);
        instance.setDataFimDetecaoConflitos(expResult);
        Data result = instance.getDataFimDetecaoConflitos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescricao method, of class Demonstracao.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "Descricao2";
        instance.setDescricao(descricao);
        boolean expResult = true;
        boolean result = instance.getDescricao().equals(descricao);
        assertEquals(expResult, result);
    }

    /**
     * Test of getExpo method, of class Demonstracao.
     */
    @Test
    public void testGetExpo() {
        System.out.println("getExpo");
        Exposicao expResult = e;
        Exposicao result = instance.getExpo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExpo method, of class Demonstracao.
     */
    @Test
    public void testSetExpo() {
        System.out.println("setExpo");
        Exposicao expResult = new Exposicao(null);
        instance.setExpo(expResult);
        Exposicao result = instance.getExpo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoConflitosDemonstracao method, of class Demonstracao.
     */
    @Test
    public void testGetRegistoConflitosDemonstracao() {
        System.out.println("getRegistoConflitosDemonstracao");
        RegistoConflitosDemonstracao expResult = instance.getRegistoConflitosDemonstracao();
        RegistoConflitosDemonstracao result = instance.getRegistoConflitosDemonstracao();
        assertEquals(expResult, result);
    }

    /**
     * Test of fix method, of class Demonstracao.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoOrganizadores ro = new RegistoOrganizadores();
        RegistoUtilizadores ru = new RegistoUtilizadores("tag");
        Exposicao e = new Exposicao(ce);
        RegistoCandidaturasAExposicao rCand = new RegistoCandidaturasAExposicao(e);
        instance.fix(rCand, e, ru);
    }

    /**
     * Test of importContentFromXMLNode method, of class Demonstracao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Demonstracao expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        Demonstracao result = instance;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Demonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Demonstracao expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        Demonstracao result = instance;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
    }
}
