/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAtribuida;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.FAE;
import lapr.project.model.FaeAvaliacao;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoAtribuicoesCandidaturasExposicao;
import lapr.project.utils.QualidadeFaeCalculo.Media;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class QualidadeFaeCalculoTest {

    CandidaturaAExposicao cand;
    RegistoAtribuicoesCandidaturasExposicao ra;
    Utilizador u1, u2;
    FAE fae1, fae2;

    public QualidadeFaeCalculoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cand = new CandidaturaAExposicao(null, null);
        cand.setEstado(new EstadoCandidaturaAExposicaoAtribuida(cand));
        ra = new RegistoAtribuicoesCandidaturasExposicao();
        u1 = new Utilizador("nome", "username", "SecretCode-123".toCharArray(), "mail@mail.com", "INDIGO");
        u2 = new Utilizador("nome2", "username2", "SecretCode-1234".toCharArray(), "mail2@mail.com", "BLUE");
        fae1 = new FAE(u1);
        fae2 = new FAE(u2);
        for (int i = 0; i < 20; i++) {
            AtribuicaoCandidatura atr = new AtribuicaoCandidatura(cand);
            FaeAvaliacao fAval = new FaeAvaliacao(fae1);
            int v = i < 10 ? 1 : 3;
            fAval.setAvalicao(v, v, v, v, v);
            atr.getRegistoFaeAvaliacao().getListaFaeAvaliacao().add(fAval);
            ra.getListaAtribuicoes().add(atr);
        }
        for (int i = 0; i < 40; i++) {
            AtribuicaoCandidatura atr = new AtribuicaoCandidatura(cand);
            FaeAvaliacao fAval = new FaeAvaliacao(fae2);
            int v = 5;
            fAval.setAvalicao(v, v, v, v, v);
            atr.getRegistoFaeAvaliacao().getListaFaeAvaliacao().add(fAval);
            ra.getListaAtribuicoes().add(atr);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calcMedia method, of class QualidadeFaeCalculo.
     */
    @Test
    public void testCalcMedia() {
        System.out.println("calcMedia");
        QualidadeFaeCalculo instance = new QualidadeFaeCalculo();
        double expResult = 4D;
        double result = instance.calcMedia(cand, ra);
        assertEquals(true, Double.compare(expResult, result) == 0);
    }

    /**
     * Test of calcMediaAndVariance method, of class QualidadeFaeCalculo.
     */
    @Test
    public void testCalcMediaAndVariance() {
        System.out.println("calcMediaAndVariance");
        QualidadeFaeCalculo instance = new QualidadeFaeCalculo();
        instance.calcMedia(cand, ra);
        NormalDistribution distr = instance.calcMediaAndVariance(fae1, ra);
        assertEquals(true, Double.compare(Math.sqrt(5), distr.getMean()) == 0);
        assertEquals(true, Double.compare(Math.sqrt(10 - 4 * Math.sqrt(5)), distr.getStandardDeviation()) == 0);
    }

    /**
     * Test of getListaFAEsWithVarianceOver method, of class
     * QualidadeFaeCalculo.
     */
    @Test
    public void testGetListaFAEsWithVarianceOver() {
        System.out.println("getListaFAEsWithVarianceOver");

        double variancia = 1.0;
        QualidadeFaeCalculo instance = new QualidadeFaeCalculo();

        List<FAE> expResult = new ArrayList<>();
        expResult.add(fae1);

        instance.calcMedia(cand, ra);
        instance.calcMediaAndVariance(fae1, ra);
        List<Media<FAE>> result = instance.getListaFAEsComDesvioPadraoAcimaDe(variancia);

        if (result.size() != expResult.size()) {
            fail("O tamanho das listas é diferente");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Media<FAE> mFae = result.get(i);
                assertEquals(mFae.getObject(), expResult.get(i));
            }
        }
    }

    /**
     * Test of testeHipotese method, of class QualidadeFaeCalculo.
     */
    @Test
    public void testTesteHipotese() {
        System.out.println("testeHipotese");

        double grauConfianca = 0.99;
        QualidadeFaeCalculo instance = new QualidadeFaeCalculo();

        List<FAE> expResult = new ArrayList<>();
        expResult.add(fae1);

        instance.calcMedia(cand, ra);
        instance.calcMediaAndVariance(fae1, ra);
        instance.getListaFAEsComDesvioPadraoAcimaDe(1D);

        List<Media<FAE>> result = instance.testeHipotese(1D, grauConfianca);
        
        if (result.size() != expResult.size()) {
            fail("O tamanho das listas é diferente");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Media<FAE> mFae = result.get(i);
                assertEquals(mFae.getObject(), expResult.get(i));
            }
        }

        expResult.remove(fae1);
        grauConfianca = 1.0;
        result = instance.testeHipotese(1D, grauConfianca);
        assertEquals(expResult, result);
    }

}
