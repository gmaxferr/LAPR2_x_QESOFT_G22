package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import lapr.project.exceptions.InvalidEmailException;
import lapr.project.utils.CaesarsCypher;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class UtilizadorTest {

    public UtilizadorTest() {
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
     * Test of getNome method, of class Utilizador.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Utilizador instance = new Utilizador();
        instance.setNome("Nome do Utilizador");
        String expResult = "Nome do Utilizador";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPwd method, of class Utilizador.
     */
    @Test
    public void testGetPwd() {
        System.out.println("getPwd");
        Utilizador instance = new Utilizador();
        instance.setPwd("secret".toCharArray());
        char[] expResult = CaesarsCypher.encrypt("secret".toCharArray(), instance.getShifts(), Utilizador.PARCIAL_ALFABET);
        char[] result = instance.getPwd();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Utilizador.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Utilizador instance = new Utilizador();
        instance.setEmail("mail@mail.com");
        String expResult = "mail@mail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsGestor method, of class Utilizador.
     */
    @Test
    public void testSetIsGestor() {
        System.out.println("setIsGestor");
        Utilizador instance = new Utilizador();
        assertEquals(false, instance.isGestor());
        instance.setIsGestor(true);
        assertEquals(true, instance.isGestor());
    }

    /**
     * Test of isGestor method, of class Utilizador.
     */
    @Test
    public void testIsGestor() {
        System.out.println("isGestor");
        Utilizador instance = new Utilizador();
        assertEquals(false, instance.isGestor());
        instance.setIsGestor(true);
        assertEquals(true, instance.isGestor());
    }

    /**
     * Test of getUsername method, of class Utilizador.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Utilizador instance = new Utilizador();
        instance.setUsername("userName1");
        String expResult = "userName1";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }


    /**
     * Test of setNome method, of class Utilizador.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String strNome = "Mike";
        Utilizador instance = new Utilizador();
        instance.setNome(strNome);
        assertEquals(strNome, instance.getNome());
    }

    /**
     * Test of setEmail method, of class Utilizador.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String strEmail = "newMail";
        Utilizador instance = new Utilizador();
        instance.setEmail(strEmail);
        assertEquals(strEmail, instance.getEmail());
    }

    /**
     * Test of setUsername method, of class Utilizador.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "newUsername";
        Utilizador instance = new Utilizador();
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of setPwd method, of class Utilizador.
     */
    @Test
    public void testSetPwd() {
        System.out.println("setPwd");
        char[] strPwd = "secret".toCharArray();
        Utilizador instance = new Utilizador();
        instance.setPwd(strPwd);
        Assert.assertArrayEquals(instance.getPwd(), CaesarsCypher.encrypt(strPwd, instance.getShifts(), Utilizador.PARCIAL_ALFABET));
    }

    /**
     * Test of VerificaCorrespondenciaPassword method, of class Utilizador.
     */
    @Test
    public void testVerificaCorrespondenciaPassword() {
        System.out.println("VerificaCorrespondenciaPassword");
        char[] password = "secretCode".toCharArray();
        Utilizador instance = new Utilizador();
        instance.setPwd(password);
        boolean expResult = true;
        boolean result = instance.VerificaCorrespondenciaPassword(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaPassword method, of class Utilizador.
     */
    @Test
    public void testValidaPassword_charArr() {
        System.out.println("validaPassword");
        char[] password = "secretCode-123".toCharArray();
        Utilizador instance = new Utilizador();
        boolean expResult = true;
        boolean result = instance.validaPassword(password);
        assertEquals(expResult, result);

        expResult = false;

        password = "SECRETCODE-123".toCharArray();
        result = instance.validaPassword(password);
        assertEquals(expResult, result);

        password = "secretCode-;".toCharArray();
        result = instance.validaPassword(password);
        assertEquals(expResult, result);

        password = "secretCode123".toCharArray();
        result = instance.validaPassword(password);
        assertEquals(expResult, result);

        password = "secretcode-123".toCharArray();
        result = instance.validaPassword(password);
        assertEquals(expResult, result);
        
        expResult = true;
        password = "Secretcode-123".toCharArray();
        result = instance.validaPassword(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaPassword method, of class Utilizador.
     */
    @Test
    public void testValidaPassword_0args() {
        System.out.println("validaPassword");
        char[] password = "secretCode".toCharArray();
        Utilizador instance = new Utilizador();
        instance.setPwd(password);
        boolean expResult = false;
        boolean result = instance.validaPassword();
        assertEquals(expResult, result);

        password = "secretCode-123".toCharArray();
        instance.setPwd(password);
        expResult = true;
        result = instance.validaPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Utilizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Utilizador instance = new Utilizador();
        String username = "userName";
        instance.setUsername(username);
        String expResult = username;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaDadosDoUtilizador method, of class Utilizador.
     */
    @Test
    public void testValidaDadosDoUtilizador() {
        System.out.println("validaDadosDoUtilizador");
        Utilizador instance = new Utilizador();
        boolean expResult = true;
        boolean result = instance.validaDadosDoUtilizador("Nome", "secretCode-123".toCharArray(), "userName", "valid@mail.com");
        assertEquals(expResult, result);

        expResult = false;
        result = instance.validaDadosDoUtilizador("", "secretCode-123".toCharArray(), "userName", "valid@mail.com");
        assertEquals(expResult, result);

        expResult = false;
        result = instance.validaDadosDoUtilizador("Nome", "secretCode".toCharArray(), "userName", "valid@mail.com");
        assertEquals(expResult, result);

        expResult = false;
        result = instance.validaDadosDoUtilizador("Nome", "secretCode-123".toCharArray(), "", "valid@mail.com");
        assertEquals(expResult, result);

        expResult = false;
        result = instance.validaDadosDoUtilizador("Nome", "secretCode-123".toCharArray(), "userName", "invalid@mail");
        assertEquals(expResult, result);
    }

    /**
     * Test of validarDadosRepetidosOuInvalidos method, of class Utilizador.
     */
    @Test
    public void testValidarDadosRepetidosOuInvalidos() {
        System.out.println("validarDadosRepetidosOuInvalidos");
        Utilizador instance = new Utilizador();
        boolean expResult = true;
        boolean result = instance.validarDadosRepetidosOuInvalidos("Nome", "secretCode-123".toCharArray(), "userName", "valid@mail.com");
        assertEquals(expResult, result);

        expResult = false;
        result = instance.validarDadosRepetidosOuInvalidos("", "secretCode-123".toCharArray(), "userName", "valid@mail.com");
        assertEquals(expResult, result);

        expResult = false;
        result = instance.validarDadosRepetidosOuInvalidos("Nome", "secretCode".toCharArray(), "userName", "valid@mail.com");
        assertEquals(expResult, result);

        expResult = false;
        result = instance.validarDadosRepetidosOuInvalidos("Nome", "secretCode-123".toCharArray(), "", "valid@mail.com");
        assertEquals(expResult, result);

        expResult = false;
        result = instance.validarDadosRepetidosOuInvalidos("Nome", "secretCode-123".toCharArray(), "userName", "invalid@mail");
        assertEquals(expResult, result);
    }

    /**
     * Test of validaEmail method, of class Utilizador.
     */
    @Test
    public void testValidaEmail() {
        System.out.println("validaEmail");
        Utilizador instance = new Utilizador();
        String email = "";
        boolean expResult = false;
        boolean result;
        try {
            result = instance.validaEmail(email);
        } catch (InvalidEmailException ex) {
            result = false;
        }
        assertEquals(expResult, result);

        email = "valid@mail.com";
        expResult = true;
        try {
            result = instance.validaEmail(email);
        } catch (InvalidEmailException ex) {
            result = false;
        }
        assertEquals(expResult, result);

        email = "invalid@mail";
        expResult = false;
        try {
            result = instance.validaEmail(email);
        } catch (InvalidEmailException ex) {
            result = false;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of getnAvaliacoesDesdeSempre method, of class Utilizador.
     */
    @Test
    public void testGetnAvaliacoesDesdeSempre() {
        System.out.println("getnAvaliacoesDesdeSempre");
        Utilizador instance = new Utilizador();
        int expResult = 0;
        int result = instance.getnAvaliacoesDesdeSempre();
        assertEquals(expResult, result);

        instance.setnAvaliacoesDesdeSempre(10);

        expResult = 10;
        result = instance.getnAvaliacoesDesdeSempre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setnAvaliacoesDesdeSempre method, of class Utilizador.
     */
    @Test
    public void testSetnAvaliacoesDesdeSempre() {
        System.out.println("setnAvaliacoesDesdeSempre");
        Utilizador instance = new Utilizador();
        int expResult = 0;
        int result = instance.getnAvaliacoesDesdeSempre();
        assertEquals(expResult, result);

        instance.setnAvaliacoesDesdeSempre(10);

        expResult = 10;
        result = instance.getnAvaliacoesDesdeSempre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKeyword method, of class Utilizador.
     */
    @Test
    public void testGetKeyword() {
        System.out.println("getKeyword");
        Utilizador instance = new Utilizador();
        instance.setKeyword("keyword");
        String expResult = "keyword";
        String result = instance.getKeyword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKeyword method, of class Utilizador.
     */
    @Test
    public void testSetKeyword() {
        System.out.println("setKeyword");
        Utilizador instance = new Utilizador();
        instance.setKeyword("keyword");
        String expResult = "keyword";
        String result = instance.getKeyword();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaKeyword method, of class Utilizador.
     */
    @Test
    public void testValidaKeyword() {
        System.out.println("validaKeyword");
        Utilizador instance = new Utilizador();
        String keyword = "invalidKeyword";
        instance.setKeyword(keyword);
        boolean expResult = false;
        boolean result = instance.validaKeyword();
        assertEquals(expResult, result);

        keyword = "valid";
        instance.setKeyword(keyword);
        expResult = true;
        result = instance.validaKeyword();
        assertEquals(expResult, result);

        keyword = "123";
        instance.setKeyword(keyword);
        expResult = false;
        result = instance.validaKeyword();
        assertEquals(expResult, result);

        keyword = null;
        instance.setKeyword(keyword);
        result = instance.validaKeyword();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, of class Utilizador.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        Utilizador instance = new Utilizador();
        instance.setPwd("secretCode-123".toCharArray());
        instance.setKeyword("keyword");
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);

        instance.setPwd("secretCode".toCharArray());
        expResult = false;
        result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShifts method, of class Utilizador.
     */
    @Test
    public void testGetShifts() {
        System.out.println("getShifts");
        Utilizador instance = new Utilizador();
        instance.setPwd("secret".toCharArray());
        int expResult = instance.getShifts();
        int result = instance.getShifts();
        assertEquals(expResult, result);    //Visto que é calculado a partir de um random
    }

    /**
     * Test of setShifts method, of class Utilizador.
     */
    @Test
    public void testSetShifts() {
        System.out.println("setShifts");
        int shifts = 3;
        Utilizador instance = new Utilizador();
        instance.setShifts(shifts);
        assertEquals(shifts, instance.getShifts());
    }

    /**
     * Test of importContentFromXMLNode method, of class Utilizador.
     */
    @Test
    public void testImportContentFromXMLNode() throws ParserConfigurationException {
        System.out.println("importContentFromXMLNode");
        Utilizador expResult = new Utilizador();
        Node node = expResult.exportContentToXMLNode();
        Utilizador result = new Utilizador();
        result.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Utilizador.
     */
    @Test
    public void testExportContentToXMLNode() throws ParserConfigurationException {
        System.out.println("exportContentToXMLNode");
        Utilizador expResult = new Utilizador();
        Node node = expResult.exportContentToXMLNode();
        Utilizador result = new Utilizador();
        result.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Utilizador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Utilizador obj = new Utilizador();
        Utilizador instance = new Utilizador();

        boolean expResult = false;
        boolean result = instance.equals(null);
        assertEquals(expResult, result);

        String keyword = "INDIGO";
        String mail = "mail@mail.com";
        String nome = "nome";
        String username = "username";
        char[] passe = "secret".toCharArray();

        for (int i = 0; i < Math.pow(2, 7); i++) {
            instance.setIsGestor((i & 0x01) > 0);
            instance.setKeyword((i & 0x02) > 0 ? keyword : null);
            instance.setEmail((i & 0x04) > 0 ? mail : null);
            instance.setNome((i & 0x08) > 0 ? nome : null);
            instance.setUsername((i & 0x10) > 0 ? username : null);
            instance.setPwd((i & 0x20) > 0 ? passe : null);
            instance.setnAvaliacoesDesdeSempre((i & 0x40) > 0 ? 1 : 0);
            obj = new Utilizador();
            for (int j = 0; j < Math.pow(2, 7); j++) {
                obj.setIsGestor((j & 0x01) > 0);
                obj.setKeyword((j & 0x02) > 0 ? keyword : null);
                obj.setEmail((j & 0x04) > 0 ? mail : null);
                obj.setNome((j & 0x08) > 0 ? nome : null);
                obj.setUsername((j & 0x10) > 0 ? username : null);
                obj.setPwd((j & 0x20) > 0 ? passe : null);
                obj.setnAvaliacoesDesdeSempre((j & 0x40) > 0 ? 1 : 0);

                expResult = i == j;
                result = instance.equals(obj);
                assertEquals(expResult, result);
            }
        }

    }

    /**
     * Test of hashCode method, of class Utilizador.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Utilizador obj = new Utilizador();
        Utilizador instance = new Utilizador();
        int expResult = obj.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);

        obj.setIsGestor(true);
        instance.setIsGestor(true);
        expResult = obj.hashCode();
        result = instance.hashCode();
        assertEquals(expResult, result);
    }
}
