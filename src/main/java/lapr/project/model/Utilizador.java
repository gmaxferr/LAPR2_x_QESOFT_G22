package lapr.project.model;

import crypt.CaesarsCypher;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Representação de um Utilizador
 *
 * @author Ricardo Osório Ana Leite
 */
public class Utilizador implements ApresentavelNaJTable{

    /**
     * Atributo nome de um Utilizador.
     */
    private String m_strNome;

    /**
     * Atributo password de um Utilizador.
     */
    private char[] m_strPwd;

    /**
     * Atributo email de um Utilizador.
     */
    private String m_strEmail;

    /**
     * Atributo username de um utilizador.
     */
    private String m_strUsername;

    /**
     *
     */
    private String m_ID;

    /**
     * Atributo associado ao Utilizador que regista se o registo desse
     * Utilizador já foi confirmado.
     */
    private boolean m_boolConfirmaRegisto;

    /**
     * Lista de utilizadores.
     */
    private ArrayList<Utilizador> m_listaUtilizadores;

    private int nAvaliacoesDesdeSempre;

    /**
     * Construtor de objectos do tipo Utilizador sem parametros
     */
    public Utilizador() {
        this.nAvaliacoesDesdeSempre = 0;
    }

    public Utilizador(String nome, String ID, char[] password, String email) {
        this.nAvaliacoesDesdeSempre = 0;
        this.m_ID = ID;
        this.m_strEmail = email;
        this.m_strPwd = password;
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

    public String getID() {
        return this.m_ID;
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
     * Define um novo valor para variavel boolean que regista se o registo desse
     * Utilizador já foi confirmado
     */
    public void setBoolConfirmaRegisto(boolean m_boolConfirmaRegisto) {
        this.m_boolConfirmaRegisto = m_boolConfirmaRegisto;
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
        m_strPwd = strPwd;
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
        return Arrays.equals(CaesarsCypher.decrypt(m_strPwd, password[0]), password);
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
     * Método que valida o utilizador
     *
     * @param username Username a validar
     * @param email Email a validar
     */
    public void validaUtilizador(String username, String email) {

        if (validarDadosRepetidosOuInvalidos(username, email) == false) {
            username = null;
            email = null;
        }
    }

    /**
     * Método que valida os dados do Utilizador
     *
     * @return true se os dados nao forem repetidos ou inválidos. Caso contrário
     * retorna false
     */
    public boolean validarDadosRepetidosOuInvalidos(String username, String email) {
        ArrayList<Utilizador> list = new ArrayList<>();
        for (Utilizador u : m_listaUtilizadores) {
            if (username.equals(u.getUsername())|| email.equals(u.getEmail())){
                    return false;
            }
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
