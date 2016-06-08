/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import lapr.project.model.CentroExposicoes;
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
public class FicheiroDadosTest {
    
    public FicheiroDadosTest() {
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
     * Test of lerFicheiroBinario method, of class FicheiroDados.
     */
    @Test
    public void testLerFicheiroBinario() {
        System.out.println("lerFicheiroBinario");
        String nomeFicheiro = "";
        FicheiroDados instance = new FicheiroDados();
        CentroExposicoes expResult = null;
        CentroExposicoes result = instance.lerFicheiroBinario(nomeFicheiro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarFicheiroBinario method, of class FicheiroDados.
     */
    @Test
    public void testGuardarFicheiroBinario() {
        System.out.println("guardarFicheiroBinario");
        String nomeFicheiro = "";
        CentroExposicoes centroExposicoes = null;
        FicheiroDados instance = new FicheiroDados();
        boolean expResult = false;
        boolean result = instance.guardarFicheiroBinario(nomeFicheiro, centroExposicoes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lerDadosFicheiroTexto method, of class FicheiroDados.
     */
    @Test
    public void testLerDadosFicheiroTexto() {
        System.out.println("lerDadosFicheiroTexto");
        CentroExposicoes centroExposicoes = null;
        FicheiroDados instance = new FicheiroDados();
        instance.lerDadosFicheiroTexto(centroExposicoes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
