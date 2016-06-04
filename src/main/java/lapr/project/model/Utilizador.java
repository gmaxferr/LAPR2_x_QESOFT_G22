package lapr.project.model;

/**
 * Representação de um Utilizador
 *
 * @author Ricardo Osório Ana Leite
 */
public class Utilizador {

    /**
     * Atributo nome de um Utilizador
     */
    private String m_strNome;

    /**
     * Atributo password de um Utilizador
     */
    private char[] m_strPwd;

    /**
     * Atributo email de um Utilizador
     */
    private String m_strEmail;

    /**
     * Atributo username de um utilizador
     */
    private String m_strUsername;

    private String ID;

    /**
     * Atributo associado ao Utilizador que regista se o registo desse
     * Utilizador já foi confirmado
     */
    private boolean m_boolConfirmaRegisto;

    /**
     * Construtor de objectos do tipo Utilizador sem parametros
     */
    public Utilizador() {
    }

    public Utilizador(String nome, String ID, char[] password, String email) {
        this.ID = ID;
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
    public boolean getM_boolConfirmaRegisto() {
        return this.m_boolConfirmaRegisto;
    }

    /**
     * Devolve o atributo nome do utilizador
     *
     * @return nome do utilizador
     */
    public String getM_strNome() {
        return this.m_strNome;
    }

    /**
     * Devolve a password do utilizador
     *
     * @return password do utilizador
     */
    public char[] getM_strPwd() {
        //fazer toString? depende se for um get para ser usado na UI
        return this.m_strPwd;
    }

    /**
     * Devolve o email do utilizador
     *
     * @return email do utilizador
     */
    public String getM_strEmail() {
        return this.m_strEmail;
    }

    public String getID() {
        return this.ID;
    }

    /**
     * Define um novo valor para variavel boolean que regista se o registo desse
     * Utilizador já foi confirmado
     */
    public void setM_boolConfirmaRegisto(boolean m_boolConfirmaRegisto) {
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
     */
    public void validaUtilizador() {
        //validação local dos dados
        if (validarDadosRepetidosOuInvalidos() == false) {
            //remove os dados introduzidos anteriormente por estarem repetidos ou invalidos
        }
    }

    /**
     * Método que valida os dados do Utilizador
     *
     * @return
     */
    public boolean validarDadosRepetidosOuInvalidos() {
        return true;
    }

    public String getM_StrUsername() {
        return m_strUsername;
    }

}
