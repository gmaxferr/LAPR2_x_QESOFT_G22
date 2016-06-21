package lapr.project.model;

import java.util.*;
import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.*;
import lapr.project.exceptions.InvalidEmailException;
import lapr.project.exceptions.InvalidPasswordException;
import lapr.project.utils.*;
import org.w3c.dom.*;
import lapr.project.utils.Utilitarios;

/**
 * Representação de um Utilizador
 *
 * @author G29
 */
public class Utilizador implements ApresentavelNaJTable, Importable<Utilizador>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "utilizador";

    public static final String SHIFTS_ATTR_NAME = "shifts";
    public static final String KEYWORD_ATTR_NAME = "keyword";
    public static final String IS_GESTOR_ATTR_NAME = "gestor";
    public static final String N_AVALIACOES_ATTR_NAME = "nAvaliacoes";

    public static final String NOME_ELEMENT_NAME = "nome";
    public static final String PASSE_ELEMENT_NAME = "password";
    public static final String USERNAME_ELEMENT_NAME = "username";
    public static final String EMAIL_ELEMENT_NAME = "email";

    // Alfabeto usado no processo de encriptação das palavras-passe
    public static final String PARCIAL_ALFABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,:;-";
    // Alfabeto usado no processo de encriptação do resto da informação pessoal do utilizador
    public static final String COMPLETE_ALFABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,:;-_+*!|\\\"@#£$§%€&/{([)]=}?'»«<>";

    public static final int SHIFTS_MASK = 0x35;

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
     * Keyword usada na encriptação dos dados pessoais do utilizador.
     */
    private String keyword;

    /**
     * Atributo email de um Utilizador.
     */
    private String m_strEmail;

    /**
     * Atributo username de um utilizador.
     */
    private String m_strUsername;

    /**
     * Numero de avaliações que este utilizador já realizou.
     */
    private int nAvaliacoesDesdeSempre;

    private boolean isGestor;

    /**
     * Construtor de objectos do tipo Utilizador sem parametros
     */
    public Utilizador() {
        this.nAvaliacoesDesdeSempre = 0;
        this.isGestor = false;
        this.m_strUsername = "";
        this.m_strEmail = "";
        this.m_strPwd = new char[0];
        this.m_strNome = "";
        this.keyword = "";
    }

    public Utilizador(String nome, String username, char[] password, String email) {
        this();
        this.m_strUsername = username;
        this.m_strEmail = email;
        setPwd(password);
        this.m_strNome = nome;
        this.isGestor = false;
    }

    public Utilizador(String nome, String username, char[] password, String email, String keyword) {
        this();
        this.m_strUsername = username;
        this.m_strEmail = email;
        setPwd(password);
        this.m_strNome = nome;
        this.isGestor = false;
        this.keyword = keyword;
    }

    /**
     * Devolve o atributo nome do utilizador
     *
     * @return nome do utilizador
     */
    public String getNome() {
        return this.m_strNome != null ? this.m_strNome : "";
    }

    /**
     * Devolve a password do utilizador
     *
     * @return password do utilizador
     */
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

    public void setIsGestor(boolean b) {
        this.isGestor = b;
    }

    public boolean isGestor() {
        return this.isGestor;
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
     * @return the randomCaesarShift
     */
    public int getShifts() {
        return randomCaesarShift;
    }

    /**
     * @param shifts the randomCaesarShift to set
     */
    public void setShifts(int shifts) {
        this.randomCaesarShift = shifts;
    }

    /**
     * Define uma nova password de utilizador
     *
     * @param strPwd nova password de utilizador
     */
    public final void setPwd(char[] strPwd) {
        if (strPwd == null) {
            this.m_strPwd = new char[0];
        } else {
            Random r = new Random();
            this.randomCaesarShift = r.nextInt(PARCIAL_ALFABET.length() - 1) + 1; //Para mudar de cada vez que a password é atualizada
            m_strPwd = CaesarsCypher.encrypt(strPwd, this.randomCaesarShift, PARCIAL_ALFABET);
        }
    }

    /**
     * Verifica se uma palavra-passe passada por parâmetro corresponde à que
     * está guardada no sistema.
     *
     * @param password - Password a verificar
     * @return Retorna TRUE se a palavra-passe passada como parâmetro for igual
     * à armazenada no sistema, FALSE caso contrário
     */
    public boolean VerificaCorrespondenciaPassword(char[] password) {
        return Arrays.equals(CaesarsCypher.encrypt(password, this.randomCaesarShift, PARCIAL_ALFABET), this.m_strPwd);
    }

    /**
     * Valida a password: A validação da password é feita da seguinte forma: Uma
     * password tem que conter um número, uma letra minuscula e outra maiusculo
     * (pelo menos), tem que conter pelo menos um sinal de pontuação como ","
     * "." ":" ";" ou "-". Tem ainda um tamanho minimo de 4 caracteres e um
     * máximo de 7.
     *
     * @param password - password a validar
     * @return true se for válida; false caso contrário.
     */
    public boolean validaPassword(char[] password) {
        return Utilitarios.hasLowerCase(password)
                && Utilitarios.hasNumber(password)
                && Utilitarios.hasSinalPontuacao(password)
                && Utilitarios.hasUpperCase(password);
    }

    /**
     * Valida a password atual do utilizador: A validação da password é feita da
     * seguinte forma: Uma password tem que conter um número, uma letra
     * minuscula e outra maiusculo (pelo menos), tem que conter pelo menos um
     * sinal de pontuação como "," "." ":" ";" ou "-". Tem ainda um tamanho
     * minimo de 4 caracteres e um máximo de 7.
     *
     * @return true se for válida; false caso contrário.
     */
    public boolean validaPassword() {
        char[] decryptesPass = CaesarsCypher.decrypt(m_strPwd, randomCaesarShift, PARCIAL_ALFABET);
        return validaPassword(decryptesPass);
    }

    /**
     * Devolve a descrição textual com os atributos de utilizador
     *
     * @return a descrição textual com os atributos de utilizador
     */
    @Override
    public String toString() {
        return this.m_strUsername;
    }

    /**
     * Valida o utilizador (localmente)
     *
     * @param nome nome do utilizador a validar
     * @param password password do utilizador a validar
     * @param username Username do utilizador a validar
     * @param email Email do utilizador a validar
     *
     * @return true se os dados do utilizadores forem válidos (todos os campos
     * estão preenchidos). Caso contrário retorna false.
     */
    public boolean validaDadosDoUtilizador(String nome, char[] password, String username, String email) {
        if (validarDadosRepetidosOuInvalidos(nome, password, username, email)) {
            return true;
        }
        return false;
    }

    /**
     * Valida os dados do Utilizador
     *
     * @param nome nome do utilizador
     * @param password password do utilizador
     * @param username username do utilizador
     * @param email email do utilizador
     *
     * @return true se os dados nao forem repetidos ou inválidos. Caso contrário
     * retorna false
     */
    public boolean validarDadosRepetidosOuInvalidos(String nome, char[] password, String username, String email) {
        try {
            boolean password1 = validaPassword(password);
            boolean email1 = validaEmail(email);
            if (password1 == false || nome.isEmpty() || username.isEmpty() || email1 == false) {
                return false;
            }
            return true;
        } catch (InvalidEmailException | InvalidPasswordException ex) {
            return false;
        }
    }

    /**
     * Para um email ser válido tem que conter, de uma forma simplificada,
     * letras seguido de um "@" com mais letras seguidas, um ponto (".") e mais
     * letras.
     *
     * @param email - email a validar
     * @return true se for válido; false caso contrário.
     */
    public boolean validaEmail(String email) throws InvalidEmailException {
        boolean isValidEmail = false;
        String emailPt = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pt = Pattern.compile(emailPt, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pt.matcher(email);
        isValidEmail = matcher.matches();

        if (isValidEmail) {
            return true;
        } else {
            throw new InvalidEmailException("Email inválido!");
        }

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

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public boolean validaKeyword() {
        if (keyword != null) {
            int keyLen = keyword.length();
            return keyLen >= 4
                    && keyLen <= 7;
        } else {
            return false;
        }
    }

    public boolean isValid() {
        return validaPassword() && validaKeyword();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null
                && obj instanceof Utilizador) {
            Utilizador o = (Utilizador) obj;
            if (this.isGestor == o.isGestor
                    && (this.keyword == null ? o.keyword == null : this.keyword.equals(o.keyword))
                    && this.nAvaliacoesDesdeSempre == o.nAvaliacoesDesdeSempre
                    && (this.m_strEmail == null ? o.m_strEmail == null : this.m_strEmail.equals(o.m_strEmail))
                    && (this.m_strNome == null ? o.m_strNome == null : this.m_strNome.equals(o.m_strNome))
                    && (this.m_strUsername == null ? o.m_strUsername == null : this.m_strUsername.equals(o.m_strUsername))
                    && Arrays.equals(CaesarsCypher.decrypt(this.m_strPwd, this.randomCaesarShift, PARCIAL_ALFABET),
                            CaesarsCypher.decrypt(o.m_strPwd, o.randomCaesarShift, PARCIAL_ALFABET))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.m_strNome);
        hash = 37 * hash + Arrays.hashCode(this.m_strPwd);
        hash = 37 * hash + Objects.hashCode(this.keyword);
        hash = 37 * hash + Objects.hashCode(this.m_strEmail);
        hash = 37 * hash + Objects.hashCode(this.m_strUsername);
        hash = 37 * hash + this.nAvaliacoesDesdeSempre;
        hash = 37 * hash + (this.isGestor ? 1 : 0);
        return hash;
    }

    @Override
    public Utilizador importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        NodeList elementsKeyword = document.getChildNodes();

        Node n = elementsKeyword.item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;
            String input;
            input = elem.getAttribute(N_AVALIACOES_ATTR_NAME);
            if (!input.isEmpty()) {
                this.nAvaliacoesDesdeSempre = Integer.parseInt(input);
            } else {
                this.nAvaliacoesDesdeSempre = 0;
            }
            input = elem.getAttribute(IS_GESTOR_ATTR_NAME);
            if (!input.isEmpty()) {
                this.isGestor = Boolean.parseBoolean(input);
            } else {
                this.isGestor = false;
            }

            input = elem.getAttribute(SHIFTS_ATTR_NAME);
            if (!input.isEmpty()) {
                this.randomCaesarShift = Integer.parseInt(input) ^ SHIFTS_MASK;
            } else {
                this.randomCaesarShift = 0;
            }

            input = elem.getAttribute(KEYWORD_ATTR_NAME);
            if (!input.isEmpty()) {
                this.keyword = String.valueOf(CaesarsCypher.decrypt(input.toCharArray(), randomCaesarShift, COMPLETE_ALFABET));
            } else {
                this.keyword = "";
            }

            String value = elem.getElementsByTagName(NOME_ELEMENT_NAME).item(0).getTextContent();
            value = String.valueOf(TransposeCypher.decrypt(value.toCharArray(), this.keyword.toCharArray()));
            this.m_strNome = String.valueOf(CaesarsCypher.decrypt(value.toCharArray(), randomCaesarShift, COMPLETE_ALFABET));

            value = elem.getElementsByTagName(EMAIL_ELEMENT_NAME).item(0).getTextContent();
            value = String.valueOf(TransposeCypher.decrypt(value.toCharArray(), this.keyword.toCharArray()));
            this.m_strEmail = String.valueOf(CaesarsCypher.decrypt(value.toCharArray(), randomCaesarShift, COMPLETE_ALFABET));

            value = elem.getElementsByTagName(USERNAME_ELEMENT_NAME).item(0).getTextContent();
            value = String.valueOf(TransposeCypher.decrypt(value.toCharArray(), this.keyword.toCharArray()));
            this.m_strUsername = String.valueOf(CaesarsCypher.decrypt(value.toCharArray(), randomCaesarShift, COMPLETE_ALFABET));

            this.m_strPwd = elem.getElementsByTagName(PASSE_ELEMENT_NAME).item(0).getTextContent().toCharArray();
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            elementKeyword.setAttribute(N_AVALIACOES_ATTR_NAME, String.valueOf(this.nAvaliacoesDesdeSempre));
            elementKeyword.setAttribute(SHIFTS_ATTR_NAME, String.valueOf(this.randomCaesarShift ^ SHIFTS_MASK));
            elementKeyword.setAttribute(KEYWORD_ATTR_NAME, String.valueOf(CaesarsCypher.encrypt(this.keyword.toCharArray(), randomCaesarShift, COMPLETE_ALFABET)));
            elementKeyword.setAttribute(IS_GESTOR_ATTR_NAME, String.valueOf(isGestor));

            Element elementValue = document.createElement(NOME_ELEMENT_NAME);
            String value = String.valueOf(CaesarsCypher.encrypt(this.m_strNome.toCharArray(), randomCaesarShift, COMPLETE_ALFABET));
            value = String.valueOf(TransposeCypher.encrypt(value.toCharArray(), this.keyword.toCharArray()));
            elementValue.setTextContent(value);
            elementKeyword.appendChild(elementValue);

            elementValue = document.createElement(EMAIL_ELEMENT_NAME);
            value = String.valueOf(CaesarsCypher.encrypt(this.m_strEmail.toCharArray(), randomCaesarShift, COMPLETE_ALFABET));
            value = String.valueOf(TransposeCypher.encrypt(value.toCharArray(), this.keyword.toCharArray()));
            elementValue.setTextContent(value);
            elementKeyword.appendChild(elementValue);

            elementValue = document.createElement(USERNAME_ELEMENT_NAME);
            value = String.valueOf(CaesarsCypher.encrypt(this.m_strUsername.toCharArray(), randomCaesarShift, COMPLETE_ALFABET));
            value = String.valueOf(TransposeCypher.encrypt(value.toCharArray(), this.keyword.toCharArray()));
            elementValue.setTextContent(value);
            elementKeyword.appendChild(elementValue);

            elementValue = document.createElement(PASSE_ELEMENT_NAME);
            elementValue.setTextContent(String.valueOf(this.m_strPwd));
            elementKeyword.appendChild(elementValue);

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Utilizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
