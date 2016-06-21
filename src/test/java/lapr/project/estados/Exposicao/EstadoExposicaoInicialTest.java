/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Exposicao;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guima
 */
public class EstadoExposicaoInicialTest {
    
    public EstadoExposicaoInicialTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private EstadoExposicaoInicial instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        e.setTitulo("Titulo");
        e.setDataInicioCandDemo(new Data(2016,06,19));
        e.setDataAberturaSubCand(new Data(2016,06,20));
        e.setDataEncerramentoSubCand(new Data(2016,8,18));
        e.setDescricao("descrição");
        e.setPeriodo(new Data(2016,9,15), new Data(2016,9,28));
        e.setDataFimDetecaoConflitos(new Data(2016,6,21));
        e.setLocal(new Local("local"));

        instance = new EstadoExposicaoInicial(e, ce);
    }

    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCriada method, of class EstadoExposicaoInicial.
     */
    @Test
    public void testSetEstadoCriada() {
        System.out.println("setEstadoCriada");
        boolean expResult = true;
        boolean result = instance.setEstadoCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoInicial method, of class EstadoExposicaoInicial.
     */
    @Test
    public void testIsEstadoInicial() {
        System.out.println("isEstadoInicial");
        boolean expResult = true;
        boolean result = instance.isEstadoInicial();
        assertEquals(expResult, result);
    }
    
}
