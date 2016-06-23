package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.registos.RegistoUtilizadores;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author G29
 */
public class AlterarPerfilDeUtilizadorControllerTest {

    private AlterarPerfilDeUtilizadorController instance;
    private CentroExposicoes ce;
    private Utilizador u;
    private RegistoUtilizadores ru;
    private final String nome = "nome";
    private final String email = "112sss@aaa444.ccc888";
    private final String username = "username";
    private final char[] password = {'A', '.', 'c', '1', 'e'};

    public AlterarPerfilDeUtilizadorControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        instance = new AlterarPerfilDeUtilizadorController(ce);
        u = new Utilizador();
        u.setNome(nome);
        u.setUsername(username);
        u.setPwd(password);
        u.setEmail(email);
        ce.getRegistoUtilizadoresConfirmados().getListaUtilizadores().add(u);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of carregaRegistoUtilizadores method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testCarregaRegistoUtilizadores() {
        System.out.println("carregaRegistoUtilizadores");
        instance.carregaRegistoUtilizadores();
    }

    /**
     * Test of identificaUtilizador method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testIdentificaUtilizador() {
        System.out.println("identificaUtilizador");
        String username = "username";
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador(username);
    }

    /**
     * Test of getNomeUtilizador method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetNomeUtilizador() {
        System.out.println("getNomeUtilizador");
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");
        String expResult = "nome";
        String result = instance.getNomeUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailUtilizador method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetEmailUtilizador() {
        System.out.println("getEmailUtilizador");
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");
        String expResult = email;
        String result = instance.getEmailUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPasswordUtilizador method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetPasswordUtilizador() {
        System.out.println("getPasswordUtilizador");
        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");
        boolean expResult = true;
        boolean result = u.VerificaCorrespondenciaPassword(password);
        assertEquals(expResult, result);
    }

 
    /**
     * Test of confirmaAlteracoes method, of class
     * AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testConfirmaAlteracoes() {
        System.out.println("confirmaAlteracoes");

        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");

        instance.setEmail("1150@snc.cx");
        instance.setNome("sss");
        instance.setUsername("user");
        char[] pass = {'a', 'B', '.', '1', 'r', 'Q'};
        instance.setPassword(pass);
        String resultString = instance.confirmaAlteracoes();
        int result = resultString.length();
        String expResultString = "Alterações Efetuadas:\nNome: alterado.\nEmail: alterado.\nUsername: alterado.\nPassword: alterada.";
        int expResult = expResultString.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testSetUsername() {

        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");

        System.out.println("setUsername");
        String username = "usernameTestar";
        instance.setUsername(username);
    }

    /**
     * Test of setPassword method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testSetPassword() {

        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");

        System.out.println("setPassword");
        char[] password = {'A', 'a', '.', '1'};
        instance.setPassword(password);
    }

    /**
     * Test of setEmail method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testSetEmail() {

        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");

        System.out.println("setEmail");
        String email = "email@email.email";
        instance.setEmail(email);
    }

    /**
     * Test of setNome method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testSetNome() {

        instance.carregaRegistoUtilizadores();
        instance.identificaUtilizador("username");

        System.out.println("setNome");
        String nome = "nome";
        instance.setNome(nome);
    }

}
