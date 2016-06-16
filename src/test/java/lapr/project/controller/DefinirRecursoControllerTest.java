/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Recurso;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guilherme
 */
public class DefinirRecursoControllerTest {

    public DefinirRecursoControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private DefinirRecursoController instance;
    private CentroExposicoes ce;
    private Recurso rec1;
    private Recurso rec2;
    private Recurso rec3;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        rec1 = new Recurso("Rec1");
        rec2 = new Recurso("Rec2");
        rec3 = new Recurso("Rec3");
        ce.getRegistoRecursos().getListaDeRecursos().add(rec1);
        ce.getRegistoRecursos().getListaDeRecursos().add(rec2);
        ce.getRegistoRecursos().getListaDeRecursos().add(rec3);
        instance = new DefinirRecursoController(ce);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getListaRecursos method, of class DefinirRecursoController.
     */
    @Test
    public void testGetListaRecursos() {
        System.out.println("getListaRecursos");
        List<Recurso> expResult = new ArrayList<Recurso>();
        expResult.add(rec1);
        expResult.add(rec2);
        expResult.add(rec3);
        List<Recurso> result = instance.getListaRecursos();
        assertEquals(expResult, result);
    }

    /**
     * Test of criarRecurso method, of class DefinirRecursoController.
     */
    @Test
    public void testCriarRecurso() {
        System.out.println("criarRecurso");
        instance.getListaRecursos();
        String nome = "Rec4";
        boolean expResult = true;
        boolean result = instance.criarRecurso(nome);
        assertEquals(expResult, result);
        
        boolean expResult2 = false;
        boolean result2 = instance.criarRecurso(nome);
        assertEquals(expResult2, result2);
    }

}
