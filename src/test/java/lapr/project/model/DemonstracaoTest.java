/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.estados.EstadoDemonstracao;
import lapr.project.registos.RegistoRecursos;
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
     * Test of getM_StrDescricao method, of class Demonstracao.
     */
    @Test
    public void testGetM_StrDescricao() {
        System.out.println("getM_StrDescricao");
        Demonstracao instance = null;
        String expResult = "";
        String result = instance.getM_StrDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setM_StrDescricao method, of class Demonstracao.
     */
    @Test
    public void testSetM_StrDescricao() {
        System.out.println("setM_StrDescricao");
        String descricaoIntroduzidaPeloUtilizador = "";
        Demonstracao instance = null;
        instance.setM_StrDescricao(descricaoIntroduzidaPeloUtilizador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoRecursos method, of class Demonstracao.
     */
    @Test
    public void testGetRegistoRecursos() {
        System.out.println("getRegistoRecursos");
        Demonstracao instance = null;
        RegistoRecursos expResult = null;
        RegistoRecursos result = instance.getRegistoRecursos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getM_StrCodigoIdentificacao method, of class Demonstracao.
     */
    @Test
    public void testGetM_StrCodigoIdentificacao() {
        System.out.println("getM_StrCodigoIdentificacao");
        Demonstracao instance = null;
        String expResult = "";
        String result = instance.getM_StrCodigoIdentificacao();
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
    
}
