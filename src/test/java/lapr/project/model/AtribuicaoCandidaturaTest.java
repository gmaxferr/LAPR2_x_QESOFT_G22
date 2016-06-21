/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.registos.RegistoCandidaturasAExposicao;
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
 * @author guima
 */
public class AtribuicaoCandidaturaTest {

    public AtribuicaoCandidaturaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private AtribuicaoCandidatura instance;
    private FAE fae;
    private Utilizador u;
    private CandidaturaAExposicao cand;
    private CentroExposicoes ce;
    private Exposicao e;
    private RegistoFaeAvaliacao reg;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        reg = new RegistoFaeAvaliacao();
        u = new Utilizador("nome", "username", new char[]{'A', 'a', '.', '1'}, "a@b.c");
        fae = new FAE(u);
        e = new Exposicao(ce);
        cand = new CandidaturaAExposicao(e, new Expositor(u));
        instance = new AtribuicaoCandidatura(cand);
        instance.setRegistoFaeAvaliacao(reg);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCandidaturaAssociada method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testGetCandidaturaAssociada() {
        System.out.println("getCandidaturaAssociada");
        CandidaturaAExposicao expResult = cand;
        CandidaturaAExposicao result = instance.getCandidaturaAssociada();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoFaeAvaliacao method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testGetRegistoFaeAvaliacao() {
        System.out.println("getRegistoFaeAvaliacao");
        RegistoFaeAvaliacao expResult = reg;
        RegistoFaeAvaliacao result = instance.getRegistoFaeAvaliacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFaeAvaliacao method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testAddFaeAvaliacao() {
        System.out.println("addFaeAvaliacao");
        instance.addFaeAvaliacao(fae);
    }

    /**
     * Test of fix method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoCandidaturasAExposicao m_rce = new RegistoCandidaturasAExposicao(e);
        RegistoUtilizadores m_registoUtilizadores = new RegistoUtilizadores("reg");
        instance.fix(m_rce, m_registoUtilizadores);
    }

    /**
     * Test of importContentFromXMLNode method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        AtribuicaoCandidatura expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        AtribuicaoCandidatura result = instance;
        result.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("importContentFromXMLNode");
        AtribuicaoCandidatura expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        AtribuicaoCandidatura result = instance;
        result.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }

}
