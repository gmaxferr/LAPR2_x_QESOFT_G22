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
 * @author guima
 */
public class EstadoDemonstracaoTest {
    
    public EstadoDemonstracaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private EstadoDemonstracao instance;
    
    @Before
    public void setUp() {
        Demonstracao demo = new Demonstracao();
        instance = new EstadoDemonstracao(demo) {
        };
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoPendente method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoPendente() {
        System.out.println("setEstadoDemonstracaoPendente");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoPendente();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoConfirmada method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoConfirmada() {
        System.out.println("setEstadoDemonstracaoConfirmada");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoConfirmada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCancelada method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoCancelada() {
        System.out.println("setEstadoDemonstracaoCancelada");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCancelada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoDatasDefinidas method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoDatasDefinidas() {
        System.out.println("setEstadoDemonstracaoDatasDefinidas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoDatasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasAtribuidas method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasAtribuidas() {
        System.out.println("setEstadoDemonstracaoCandidaturasAtribuidas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasAvaliadas method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasAvaliadas() {
        System.out.println("setEstadoDemonstracaoCandidaturasAvaliadas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasAvaliadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasDecididas method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasDecididas() {
        System.out.println("setEstadoDemonstracaoCandidaturasDecididas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasAbertas method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasAbertas() {
        System.out.println("setEstadoDemonstracaoCandidaturasAbertas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasFechadas method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasFechadas() {
        System.out.println("setEstadoDemonstracaoCandidaturasFechadas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasFechadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoConflitosDetetados method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoConflitosDetetados() {
        System.out.println("setEstadoDemonstracaoConflitosDetetados");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoConflitosDetetados();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoConflitosAlterados method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoConflitosAlterados() {
        System.out.println("setEstadoDemonstracaoConflitosAlterados");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoConflitosAlterados();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoPendente method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoPendente() {
        System.out.println("isEstadoDemonstracaoPendente");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoPendente();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoConfirmada method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoConfirmada() {
        System.out.println("isEstadoDemonstracaoConfirmada");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoConfirmada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCancelada method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoCancelada() {
        System.out.println("isEstadoDemonstracaoCancelada");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoCancelada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoDatasDefinidas method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoDatasDefinidas() {
        System.out.println("isEstadoDemonstracaoDatasDefinidas");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoDatasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasAtribuidas method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasAtribuidas() {
        System.out.println("isEstadoDemonstracaoCandidaturasAtribuidas");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasAvaliadas method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasAvaliadas() {
        System.out.println("isEstadoDemonstracaoCandidaturasAvaliadas");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoCandidaturasAvaliadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasDecididas method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasDecididas() {
        System.out.println("isEstadoDemonstracaoCandidaturasDecididas");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasAbertas method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasAbertas() {
        System.out.println("isEstadoDemonstracaoCandidaturasAbertas");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasFechadas method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasFechadas() {
        System.out.println("isEstadoDemonstracaoCandidaturasFechadas");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoCandidaturasFechadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoConflitosDetetados method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoConflitosDetetados() {
        System.out.println("isEstadoDemonstracaoConflitosDetetados");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoConflitosDetetados();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoConflitosAlterados method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoConflitosAlterados() {
        System.out.println("isEstadoDemonstracaoConflitosAlterados");
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoConflitosAlterados();
        assertEquals(expResult, result);
    }

    public class EstadoDemonstracaoImpl extends EstadoDemonstracao {

        public EstadoDemonstracaoImpl() {
            super(null);
        }
    }
    
}
