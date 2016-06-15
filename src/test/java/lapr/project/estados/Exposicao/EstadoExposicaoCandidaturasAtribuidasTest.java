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
public class EstadoExposicaoCandidaturasAtribuidasTest {

    public EstadoExposicaoCandidaturasAtribuidasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private EstadoExposicaoCandidaturasAtribuidas instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        instance = new EstadoExposicaoCandidaturasAtribuidas(e);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturasAtribuidas method, of class
     * EstadoExposicaoCandidaturasAtribuidas.
     */
    @Test
    public void testSetEstadoCandidaturasAtribuidas() {
        System.out.println("setEstadoCandidaturasAtribuidas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasAvaliadas method, of class
     * EstadoExposicaoCandidaturasAtribuidas.
     */
    @Test
    public void testSetEstadoCandidaturasAvaliadas() {
        System.out.println("setEstadoCandidaturasAvaliadas");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturasAvaliadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasAtribuidas method, of class
     * EstadoExposicaoCandidaturasAtribuidas.
     */
    @Test
    public void testIsEstadoCandidaturasAtribuidas() {
        System.out.println("isEstadoCandidaturasAtribuidas");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }

}
