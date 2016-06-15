/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ana
 */
public class EstadoDemonstracaoCandidaturasDecididasTest {

    private Demonstracao d;
    private EstadoDemonstracaoCandidaturasDecididas instance;
    private String descricao;

    public EstadoDemonstracaoCandidaturasDecididasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        d = new Demonstracao(descricao);
        d.setEstado(instance);
        instance = new EstadoDemonstracaoCandidaturasDecididas(d);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasDecididas method, 
     * of class EstadoDemonstracaoCandidaturasDecididas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasDecididas() {
        System.out.println("setEstadoDemonstracaoCandidaturasDecididas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasDecididas method, of class
     * EstadoDemonstracaoCandidaturasDecididas.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasDecididas() {
        System.out.println("isEstadoDemonstracaoCandidaturasDecididas");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracaoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

}
