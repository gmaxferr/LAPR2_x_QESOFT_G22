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
public class EstadoDemonstracaoCandidaturasAbertasTest {
    
    private Demonstracao d;
    private EstadoDemonstracaoCandidaturasAbertas instance;
    private String descricao;
    
    public EstadoDemonstracaoCandidaturasAbertasTest() {
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
        instance = new EstadoDemonstracaoCandidaturasAbertas(d);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasAbertas method, of 
     * class EstadoDemonstracaoCandidaturasAbertas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasAbertas() {
        System.out.println("setEstadoDemonstracaoCandidaturasAbertas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasFechadas method, of 
     * class EstadoDemonstracaoCandidaturasAbertas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasFechadas() {
        System.out.println("setEstadoDemonstracaoCandidaturasFechadas");
        boolean expResult = true;
        boolean result = instance.setEstadoDemonstracaoCandidaturasFechadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasAbertas method, of 
     * class EstadoDemonstracaoCandidaturasAbertas.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasAbertas() {
        System.out.println("isEstadoDemonstracaoCandidaturasAbertas");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracaoCandidaturasAbertas();
        assertEquals(expResult, result);
    }
    
}
