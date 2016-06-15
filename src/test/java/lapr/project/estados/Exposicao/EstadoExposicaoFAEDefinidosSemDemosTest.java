/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Exposicao;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
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
public class EstadoExposicaoFAEDefinidosSemDemosTest {

    public EstadoExposicaoFAEDefinidosSemDemosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private EstadoExposicaoFAEDefinidosSemDemos instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoFAEDefinidosSemDemos(e);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoFAEDefinidosSemDemos method, of class
     * EstadoExposicaoFAEDefinidosSemDemos.
     */
    @Test
    public void testSetEstadoFAEDefinidosSemDemos() {
        System.out.println("setEstadoFAEDefinidosSemDemos");
        boolean expResult = false;
        boolean result = instance.setEstadoFAEDefinidosSemDemos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemosDefinidasSemFAE method, of class
     * EstadoExposicaoFAEDefinidosSemDemos.
     */
    @Test
    public void testSetEstadoDemosDefinidasSemFAE() {
        System.out.println("setEstadoDemosDefinidasSemFAE");
        boolean expResult = true;
        boolean result = instance.setEstadoDemosDefinidasSemFAE();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCompleta method, of class
     * EstadoExposicaoFAEDefinidosSemDemos.
     */
    @Test
    public void testSetEstadoCompleta() {
        System.out.println("setEstadoCompleta");
        boolean expResult = true;
        boolean result = instance.setEstadoCompleta();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoFAEDefinidosSemDemos method, of class
     * EstadoExposicaoFAEDefinidosSemDemos.
     */
    @Test
    public void testIsEstadoFAEDefinidosSemDemos() {
        System.out.println("isEstadoFAEDefinidosSemDemos");
        boolean expResult = true;
        boolean result = instance.isEstadoFAEDefinidosSemDemos();
        assertEquals(expResult, result);
    }

}
