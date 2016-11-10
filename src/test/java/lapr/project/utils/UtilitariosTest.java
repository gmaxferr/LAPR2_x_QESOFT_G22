package lapr.project.utils;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author G29
 */
public class UtilitariosTest {
    
    CentroExposicoes ce;
    Utilizador u;
    
    public UtilitariosTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        u = new Utilizador("Nome", "username", "secretcode".toCharArray(), "mail");
        ce.getRegistoUtilizadoresPendentes().getListaUtilizadores().add(u);
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

    /**
     * Test of hasNumber method, of class Utilitarios.
     */
    @Test
    public void testHasNumber() {
        System.out.println("hasNumber");
        char[] password = "saoiengoseOPAONVAEo-.,:;".toCharArray();
        boolean expResult = false;
        boolean result = Utilitarios.hasNumber(password);
        assertEquals(expResult, result);

        password = "saoiengoseOPAO0NVAEo-.,:;".toCharArray();
        expResult = true;
        result = Utilitarios.hasNumber(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasUpperCase method, of class Utilitarios.
     */
    @Test
    public void testHasUpperCase() {
        System.out.println("hasUpperCase");
        
        char[] password = "saoiengose02347237340o-.,:;".toCharArray();
        boolean expResult = false;
        boolean result = Utilitarios.hasUpperCase(password);
        assertEquals(expResult, result);

        password = "saoiengose0234723O7340o-.,:;".toCharArray();
        expResult = true;
        result = Utilitarios.hasUpperCase(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasLowerCase method, of class Utilitarios.
     */
    @Test
    public void testHasLowerCase() {
        System.out.println("hasLowerCase");
        
        char[] password = "AOIJGNOAIMIUSFA02347237340-.,:;".toCharArray();
        boolean expResult = false;
        boolean result = Utilitarios.hasLowerCase(password);
        assertEquals(expResult, result);

        password = "AOIJGNOAIMIUSFA02347237340o-.,:;".toCharArray();
        expResult = true;
        result = Utilitarios.hasLowerCase(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasSinalPontuacao method, of class Utilitarios.
     */
    @Test
    public void testHasSinalPontuacao() {
        System.out.println("hasSinalPontuacao");
        
        char[] password = "AOIJGNOAIMIUSFA02347237340".toCharArray();
        boolean expResult = false;
        boolean result = Utilitarios.hasSinalPontuacao(password);
        assertEquals(expResult, result);

        password = "AOIJGNOAIMIUSFA-02347237340".toCharArray();
        expResult = true;
        result = Utilitarios.hasSinalPontuacao(password);
        assertEquals(expResult, result);
    }
}
