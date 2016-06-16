/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
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
public class DefinirTipoConflitoControllerTest {

    public DefinirTipoConflitoControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private DefinirTipoConflitoController instance;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        instance = new DefinirTipoConflitoController(ce);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of novoTipoConflito method, of class DefinirTipoConflitoController.
     */
    @Test
    public void testNovoTipoConflito() {
        System.out.println("novoTipoConflito");
        instance.novoTipoConflito();
    }

    /**
     * Test of setDadosTipoConflito method, of class
     * DefinirTipoConflitoController.
     */
    @Test
    public void testSetDadosTipoConflito() {
        System.out.println("setDadosTipoConflito");
        instance.novoTipoConflito();
        String tipoConflito = "tipo1";
        instance.setDadosTipoConflito(tipoConflito);
    }

    /**
     * Test of registaTipoConflito method, of class
     * DefinirTipoConflitoController.
     */
    @Test
    public void testRegistaTipoConflito() {
        System.out.println("registaTipoConflito");
        instance.novoTipoConflito();
        String tipoConflito = "tipo1";
        instance.setDadosTipoConflito(tipoConflito);
        boolean expResult = true;
        boolean result = instance.registaTipoConflito();
        assertEquals(expResult, result);
    }

}
