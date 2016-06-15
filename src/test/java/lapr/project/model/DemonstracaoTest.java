package lapr.project.model;

import java.util.*;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCancelada;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasFechadas;
import lapr.project.registos.*;
import lapr.project.utils.Data;
import org.junit.*;
import static org.junit.Assert.*;

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

    @Before
    public void setUp() {
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
        Demonstracao instance = new Demonstracao("Descricao");
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
        Demonstracao instance = new Demonstracao("Descricao");
        instance.setCodigoIdentificacao("codigo");
        assertEquals("codigo", instance.getCodigoIdentificacao());
    }

    /**
     * Test of getEstadoDemo method, of class Demonstracao.
     */
    @Test
    public void testGetEstadoDemo() {
        System.out.println("getEstadoDemo");
        Demonstracao instance = new Demonstracao("Descricao");
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
        Demonstracao instance = new Demonstracao("Descricao");
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
        Demonstracao instance = new Demonstracao("Descricao");
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
        Demonstracao instance = new Demonstracao("Descricao");
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
        Demonstracao instance = new Demonstracao("Descricao");
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
        Demonstracao instance = new Demonstracao("Descricao");
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
        Demonstracao instance1 = new Demonstracao("Descricao");
        instance1.setCodigoIdentificacao("codigo");
        Demonstracao instance2 = new Demonstracao("Descricao");
        instance2.setCodigoIdentificacao("codigo");
        assertEquals(true, instance1.equals(instance2));
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
        Demonstracao instance = new Demonstracao("Descricao");
        EstadoDemonstracao estado = new EstadoDemonstracaoCandidaturasFechadas(instance);
        instance.setEstado(estado);
        assertEquals(estado, instance.getEstadoDemo());
    }

}
