package lapr.project.model;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.CaesarsCypher;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Representação de um Utilizador
 *
 * @author Ricardo Osório Ana Leite
 */
public class Utilizador implements ApresentavelNaJTable, Importable<Utilizador>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Utilizador";
    public static final String NOME_ELEMENT_NAME = "nome";
    public static final String PASSWD_ELEMENT_NAME = "passwd";
    public static final String USERNAME_ELEMENT_NAME = "username";
    public static final String EMAIL_ELEMENT_NAME = "email";
    public static final String CONFIRM_REGISTO_ATTR_NAME = "registoConfirmado";
    public static final String SHIFTS_ATTR_NAME = "shifts";
    public static final String N_AVALIACOES_ATTR_NAME = "nAvaliacoes";

    public static final String passwordAlfabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,:;-";

    /**
     * Atributo nome de um Utilizador.
     */
    private String m_strNome;

    /**
     * Atributo password de um Utilizador.
     */
    private char[] m_strPwd;

    /**
     * Numero de shifts usados na encriptação da password.
     */
    private int randomCaesarShift;

    /**
     * Atributo email de um Utilizador.
     */
    private String m_strEmail;

    /**
     * Atributo username de um utilizador.
     */
    private String m_strUsername;

    /**
     * Atributo associado ao Utilizador que regista se o registo desse
     * Utilizador já foi confirmado.
     */
    private boolean m_boolConfirmaRegisto;

    /**
     * Numero de avaliações que este utilizador já realizou.
     */
    private int nAvaliacoesDesdeSempre;

    /**
     * Construtor de objectos do tipo Utilizador sem parametros
     */
    public Utilizador() {
        this.nAvaliacoesDesdeSempre = 0;
    }

    public Utilizador(String nome, String username, char[] password, String email) {
        this();
        this.m_strUsername = username;
        this.m_strEmail = email;
        setPwd(password);
        this.m_strNome = nome;
    }

    /**
     * Devolve o valor da variavel boolean que regista se o registo desse
     * Utilizador já foi confirmado ou não
     *
     * @return boolean que representa se o registo desse Utilizador já foi
     * confirmado ou não
     */
    public boolean getBoolConfirmaRegisto() {
        return this.m_boolConfirmaRegisto;
    }

    /**
     * Devolve o atributo nome do utilizador
     *
     * @return nome do utilizador
     */
    public String getNome() {
        return this.m_strNome;
    }

    /**
     * Devolve a password do utilizador
     *
     * @return password do utilizador
     * @deprecated Este método é considerado inseguro. Para validar uma
     * password, usar {@link #isValidPassword(char[])}
     */
    @Deprecated
    public char[] getPwd() {
        //fazer toString? depende se for um get para ser usado na UI
        return this.m_strPwd;
    }

    /**
     * Devolve o email do utilizador
     *
     * @return email do utilizador
     */
    public String getEmail() {
        return this.m_strEmail;
    }

    /**
     * Devolve o username do utilizador
     *
     * @return username do utilizador
     */
    public String getUsername() {
        return m_strUsername;
    }

    /**
     * Confirma o registo do utilizador. Processo necessário para que o
     * Utilizador possa ser atribuido a cargos dentro do centro de exposições
     */
    public void confirmarRegistoDoUtilizador() {
        this.m_boolConfirmaRegisto = true;
    }

    /**
     * Define um novo nome de utilizador
     *
     * @param strNome novo nome utilizador
     */
    public void setNome(String strNome) {
        m_strNome = strNome;
    }

    /**
     * Define um novo email de utilizador
     *
     * @param strEmail novo email de utilizador
     */
    public void setEmail(String strEmail) {
        this.m_strEmail = strEmail;
    }

    /**
     * Define um novo username de utiliador
     *
     * @param username novo username de utilizador
     */
    public void setUsername(String username) {
        this.m_strUsername = username;
    }

    /**
     * Define uma nova password de utilizador
     *
     * @param strPwd nova password de utilizador
     */
    public void setPwd(char[] strPwd) {
        Random r = new Random();
        randomCaesarShift = r.nextInt(passwordAlfabet.length() - 1) + 1; //Para mudar de cada vez que a password é atualizada
        m_strPwd = CaesarsCypher.encrypt(strPwd, randomCaesarShift, passwordAlfabet);
    }

    /**
     * Altera a variavel boolean da confirmação de registo do utilizador
     */
    public void setUtilizadorRegistado() {
        this.m_boolConfirmaRegisto = true;
    }

    /**
     * Método que mostra ao utilizador os dados introduzidos
     *
     * @return um boolean, true
     */
    public boolean valida() {
        System.out.println("Utilizador: valida: " + this.toString());
        return true;
    }

    /**
     * Verifica se uma palavra-passe passada por parâmetro corresponde à que
     * está guardada no sistema.
     *
     * @param password - Password a verificar
     * @return Retorna TRUE se a palavra-passe passada como parâmetro for igual
     * à armazenada no sistema, FALSE caso contrário
     */
    public boolean isValidPassword(char[] password) {
        return Arrays.equals(CaesarsCypher.decrypt(m_strPwd, randomCaesarShift, passwordAlfabet), password);
    }

    /**
     * Devolve a descrição textual com os atributos de utilizador
     *
     * @return a descrição textual com os atributos de utilizador
     */
    @Override
    public String toString() {
        String str = "Utilizador:\n";
        str += "\tNome: " + this.m_strNome + "\n";
        str += "\tPwd: " + this.m_strPwd + "\n";
        str += "\tEmail: " + this.m_strEmail + "\n";

        return str;
    }

    /**
     * Valida o utilizador
     *
     * @param username Username a validar
     * @param email Email a validar
     */
    public boolean validaUtilizador(String nome, char[] password, String username, String email) {

        if (validarDadosRepetidosOuInvalidos(nome, password, username, email) == false) {
            return false;
        }
        return true;
    }

    /**
     * Valida os dados do Utilizador
     *
     * @return true se os dados nao forem repetidos ou inválidos. Caso contrário
     * retorna false
     */
    public boolean validarDadosRepetidosOuInvalidos(String nome, char[] password, String username, String email) {
        if (username.equals("") || password.toString().trim().equals("") || username.equals("") || email.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * @return the nAvaliacoesDesdeSempre
     */
    public int getnAvaliacoesDesdeSempre() {
        return nAvaliacoesDesdeSempre;
    }

    /**
     * @param nAvaliacoesDesdeSempre the nAvaliacoesDesdeSempre to set
     */
    public void setnAvaliacoesDesdeSempre(int nAvaliacoesDesdeSempre) {
        this.nAvaliacoesDesdeSempre = nAvaliacoesDesdeSempre;
    }

    @Override
    public Utilizador importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.appendChild(document.importNode(node, true));

            NodeList elementsKeyword = document.getChildNodes();

            Node n = elementsKeyword.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.nAvaliacoesDesdeSempre = Integer.parseInt(elem.getAttribute(N_AVALIACOES_ATTR_NAME));
                this.randomCaesarShift = Integer.parseInt(elem.getAttribute(SHIFTS_ATTR_NAME));
                this.m_boolConfirmaRegisto = Boolean.getBoolean(elem.getAttribute(CONFIRM_REGISTO_ATTR_NAME));
                this.m_strNome = elem.getElementsByTagName(NOME_ELEMENT_NAME).item(0).getTextContent();
                this.m_strEmail = elem.getElementsByTagName(EMAIL_ELEMENT_NAME).item(0).getTextContent();
                this.m_strUsername = elem.getElementsByTagName(USERNAME_ELEMENT_NAME).item(0).getTextContent();
                this.m_strPwd = elem.getElementsByTagName(PASSWD_ELEMENT_NAME).item(0).getTextContent().toCharArray();
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Keyword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            Element elementValue = document.createElement(NOME_ELEMENT_NAME);
            elementValue.setTextContent(this.m_strNome);
            elementKeyword.appendChild(elementValue);

            elementValue = document.createElement(EMAIL_ELEMENT_NAME);
            elementValue.setTextContent(this.m_strEmail);
            elementKeyword.appendChild(elementValue);

            elementValue = document.createElement(USERNAME_ELEMENT_NAME);
            elementValue.setTextContent(this.m_strUsername);
            elementKeyword.appendChild(elementValue);

            elementValue = document.createElement(PASSWD_ELEMENT_NAME);
            elementValue.setTextContent(String.valueOf(this.m_strPwd));
            elementKeyword.appendChild(elementValue);

            elementKeyword.setAttribute(CONFIRM_REGISTO_ATTR_NAME, String.valueOf(this.m_boolConfirmaRegisto));
            elementKeyword.setAttribute(N_AVALIACOES_ATTR_NAME, String.valueOf(this.nAvaliacoesDesdeSempre));
            elementKeyword.setAttribute(SHIFTS_ATTR_NAME, String.valueOf(this.randomCaesarShift));

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Keyword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
