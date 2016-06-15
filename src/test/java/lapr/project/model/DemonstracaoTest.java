/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import java.util.TimerTask;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.registos.RegistoCandidaturaADemonstracoes;
import lapr.project.registos.RegistoRecursos;
import lapr.project.utils.Data;
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
     * Test of getDescricao method, of class Demonstracao.
     */
    @Test
    public void testGetDescricao_0args() {
        System.out.println("getDescricao");
        Demonstracao instance = null;
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class Demonstracao.
     */
    @Test
    public void testGetDescricao_String() {
        System.out.println("getDescricao");
        String descricaoIntroduzidaPeloUtilizador = "";
        Demonstracao instance = null;
        instance.getDescricao(descricaoIntroduzidaPeloUtilizador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoRecursosNecessarios method, of class Demonstracao.
     */
    @Test
    public void testGetRegistoRecursosNecessarios() {
        System.out.println("getRegistoRecursosNecessarios");
        Demonstracao instance = null;
        RegistoRecursos expResult = null;
        RegistoRecursos result = instance.getRegistoRecursosNecessarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodigoIdentificacao method, of class Demonstracao.
     */
    @Test
    public void testGetCodigoIdentificacao() {
        System.out.println("getCodigoIdentificacao");
        Demonstracao instance = null;
        String expResult = "";
        String result = instance.getCodigoIdentificacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoDemo method, of class Demonstracao.
     */
    @Test
    public void testGetEstadoDemo() {
        System.out.println("getEstadoDemo");
        Demonstracao instance = null;
        EstadoDemonstracao expResult = null;
        EstadoDemonstracao result = instance.getEstadoDemo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataInicioCand method, of class Demonstracao.
     */
    @Test
    public void testGetDataInicioCand() {
        System.out.println("getDataInicioCand");
        Demonstracao instance = null;
        Data expResult = null;
        Data result = instance.getDataInicioCand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataFimCand method, of class Demonstracao.
     */
    @Test
    public void testGetDataFimCand() {
        System.out.println("getDataFimCand");
        Demonstracao instance = null;
        Data expResult = null;
        Data result = instance.getDataFimCand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigoIdentificacao method, of class Demonstracao.
     */
    @Test
    public void testSetCodigoIdentificacao() {
        System.out.println("setCodigoIdentificacao");
        String m_StrCodigoIdentificacao = "";
        Demonstracao instance = null;
        instance.setCodigoIdentificacao(m_StrCodigoIdentificacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoCandidaturasADemonstracao method, of class Demonstracao.
     */
    @Test
    public void testGetRegistoCandidaturasADemonstracao() {
        System.out.println("getRegistoCandidaturasADemonstracao");
        Demonstracao instance = null;
        RegistoCandidaturaADemonstracoes expResult = null;
        RegistoCandidaturaADemonstracoes result = instance.getRegistoCandidaturasADemonstracao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataInicioCandidaturas method, of class Demonstracao.
     */
    @Test
    public void testSetDataInicioCandidaturas() {
        System.out.println("setDataInicioCandidaturas");
        Data dataInicioCandDemo = null;
        Demonstracao instance = null;
        instance.setDataInicioCandidaturas(dataInicioCandDemo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataFimCandidaturas method, of class Demonstracao.
     */
    @Test
    public void testSetDataFimCandidaturas() {
        System.out.println("setDataFimCandidaturas");
        Data dataFimCandDemo = null;
        Demonstracao instance = null;
        instance.setDataFimCandidaturas(dataFimCandDemo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidaturasDemoExpositor method, of class Demonstracao.
     */
    @Test
    public void testGetCandidaturasDemoExpositor() {
        System.out.println("getCandidaturasDemoExpositor");
        String m_emailExpositor = "";
        Demonstracao instance = null;
        List<CandidaturaADemonstracao> expResult = null;
        List<CandidaturaADemonstracao> result = instance.getCandidaturasDemoExpositor(m_emailExpositor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Demonstracao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Demonstracao instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class Demonstracao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Demonstracao instance = null;
        Demonstracao expResult = null;
        Demonstracao result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Demonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Demonstracao instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of schedule method, of class Demonstracao.
     */
    @Test
    public void testSchedule() {
        System.out.println("schedule");
        TimerTask m_tt = null;
        Data date = null;
        Demonstracao instance = null;
        instance.schedule(m_tt, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaOrganizadores method, of class Demonstracao.
     */
    @Test
    public void testGetListaOrganizadores() {
        System.out.println("getListaOrganizadores");
        Demonstracao instance = null;
        List<Organizador> expResult = null;
        List<Organizador> result = instance.getListaOrganizadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaFAE method, of class Demonstracao.
     */
    @Test
    public void testGetListaFAE() {
        System.out.println("getListaFAE");
        Demonstracao instance = null;
        List<FAE> expResult = null;
        List<FAE> result = instance.getListaFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Demonstracao.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoDemonstracao estado = null;
        Demonstracao instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
