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
public class EstadoExposicaoConflitosAlteradosTest {
    
    public EstadoExposicaoConflitosAlteradosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private EstadoExposicaoConflitosAlterados instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoConflitosAlterados(e);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoConflitosAlterados method, of class EstadoExposicaoConflitosAlterados.
     */
    @Test
    public void testSetEstadoConflitosAlterados() {
        System.out.println("setEstadoConflitosAlterados");
        boolean expResult = false;
        boolean result = instance.setEstadoConflitosAlterados();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasAtribuidas method, of class EstadoExposicaoConflitosAlterados.
     */
    @Test
    public void testSetEstadoCandidaturasAtribuidas() {
        System.out.println("setEstadoCandidaturasAtribuidas");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoConflitosAlterados method, of class EstadoExposicaoConflitosAlterados.
     */
    @Test
    public void testIsEstadoConflitosAlterados() {
        System.out.println("isEstadoConflitosAlterados");
        boolean expResult = true;
        boolean result = instance.isEstadoConflitosAlterados();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of valida method, of class EstadoExposicaoConflitosAlterados.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }
    
    
    
}
