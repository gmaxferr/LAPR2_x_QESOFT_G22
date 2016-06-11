/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class UtilitariosTest {
    
    CentroExposicoes ce;
    Utilizador u;
    
    public UtilitariosTest() {
    }
    
    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        u = new Utilizador("Nome", "username", "secretcode".toCharArray(), "mail");
        ce.getRegistoUtilizadores().getListaUtilizadores().add(u);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of autenticacao method, of class Utilitarios.
     */
    @Test
    public void testAutenticacao() {
        System.out.println("autenticacao");
        String username1 = "username";
        char[] password1 = "secretcode".toCharArray();
        String username2 = "username2";
        char[] password2 = "secretcode2".toCharArray();
        Utilizador expResult = u;
        Utilizador result = Utilitarios.autenticacao(username1, password1, ce);
        assertEquals(expResult, result);
        expResult = null;
        result = Utilitarios.autenticacao(username1, password2, ce);
        assertEquals(expResult, result);
        expResult = null;
        result = Utilitarios.autenticacao(username2, password1, ce);
        assertEquals(expResult, result);
        expResult = null;
        result = Utilitarios.autenticacao(username2, password2, ce);
        assertEquals(expResult, result);
    }
}
