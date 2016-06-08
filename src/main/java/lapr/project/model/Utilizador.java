package lapr.project.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import lapr.project.utils.CaesarsCypher;

/**
 * Representação de um Utilizador
 *
 * @author Ricardo Osório Ana Leite
 */
public class Utilizador implements ApresentavelNaJTable {

    /**
     * Atributo nome de um Utilizador.
     */
    private String m_strNome;

    /**
     * Atributo password de um Utilizador.
     */
    private char[] m_strPwd;

    /**
     * Numero de shifts usados na encriptação da password, entre 1 e
     * 255.<!-- -->Nota: 0 e 256 não ia alterar o original por isso não faz
     * sentido usar esses 2 valores.
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
        randomCaesarShift = r.nextInt(254) + 1; //Para mudar de cada vez que a password é atualizada
        m_strPwd = CaesarsCypher.encrypt(strPwd, randomCaesarShift);
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
        return Arrays.equals(CaesarsCypher.decrypt(m_strPwd, randomCaesarShift), password);
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

}
