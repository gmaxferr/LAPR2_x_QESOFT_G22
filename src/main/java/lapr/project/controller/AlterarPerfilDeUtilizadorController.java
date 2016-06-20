package lapr.project.controller;

import javax.swing.JOptionPane;
import lapr.project.exceptions.InvalidPasswordException;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoUtilizadores;

/**
 * Representação do Controller do caso de uso - alterar perfil de utilizador
 *
 * @author Ana Leite e Ricardo Osório
 */
public class AlterarPerfilDeUtilizadorController {

    private CentroExposicoes m_ce;
    private RegistoUtilizadores m_ru;
    private Utilizador m_u;

    private String m_email;
    private String m_nome;
    private String m_username;
    private char[] m_password;

    /**
     * Contrutor do controller da UC10 - alterar perfil de utilizador
     *
     * @param centroExposicoes - Centro de Exposições
     */
    public AlterarPerfilDeUtilizadorController(CentroExposicoes centroExposicoes) {
        m_ce = centroExposicoes;
    }

    /**
     * inicializa registo de utilizadores
     */
    public void carregaRegistoUtilizadores() {
        m_ru = m_ce.getRegistoUtilizadoresPendentes();
    }

    /**
     * inicialializa username e utilizador de utilizador e procura utilizador a
     * inicializar com esse username.
     *
     * @param username - username de procura
     */
    public void identificaUtilizador(String username) {
        //devolve null se não encontrar
        setUsername(username);
        m_u = m_ru.identificarUtilizadorPeloUsername(username);
    }

    /**
     * inicializa e retorna nome de utilizador
     *
     * @return nome de utilizador
     */
    public String getNomeUtilizador() {
        m_nome = m_u.getNome();
        return m_nome;
    }

    /**
     * inicializa e retorna email de utilizador
     *
     * @return email de utilizador
     */
    public String getEmailUtilizador() {
        m_email = m_u.getEmail();
        return m_email;
    }

    /**
     * inicializa e retorna password de utilizador
     *
     * @return password de utilizador
     */
    public char[] getPasswordUtilizador() {
        m_password = m_u.getPwd();
        return m_password;
    }

    /**
     * Valida e altera o nome caso este seja validado corretamente.
     *
     * @param nome - novo nome
     * @return true se for válido; false caso contrário.
     */
    public boolean validaNome(String nome) {
        return m_ru.validaNome(nome)  && !nome.isEmpty();
    }

    /**
     * Valida e altera o username caso este seja validado corretamente.
     *
     * @param username - novo username
     * @return true se for válido; false caso contrário.
     */
    public boolean validaUsername(String username) {
        return m_ru.validaUsername(username)  && !username.isEmpty();
    }

    /**
     * Valida e altera o email caso este seja validado corretamente.
     *
     * @param email - novo email
     * @return true se for válido; false caso contrário.
     */
    public boolean validaEmail(String email) {
        return m_ru.validaEmail(email) && !email.isEmpty();

    }

    /**
     * Valida e altera a password caso esta seja validada corretamente.
     *
     * @param password - nova password
     * @return true se for válida; false caso contrário.
     */
    public boolean validaPassword(char[] password) throws InvalidPasswordException {
        return m_u.validaPassword(password);
    }

    /**
     * Armazena o username do utilizador no controller
     *
     * @param username - parametro a armazenar
     */
    public void setUsername(String username) {
        this.m_username = username;
    }

    /**
     * Armazena a Password do utilizador no controller
     *
     * @param password - parametro a armazenar
     */
    public void setPassword(char[] password) {
        this.m_password = password;
    }

    /**
     * Armazena o email do utilizador no controller
     *
     * @param email - parametro a armazenar
     */
    public void setEmail(String email) {
        this.m_email = email;
    }

    /**
     * Armazena o nome do utilizador no controller
     *
     * @param nome - parametro a armazenar
     */
    public void setNome(String nome) {
        this.m_nome = nome;
    }

    /**
     * Regista os dados do utilizador, tornando-os efetivos.
     * @return string com alterações (para expor ao utilizador)
     */
    public String confirmaAlteracoes() {
        String aux = "Alterações Efetuadas:";
        if (validaNome(m_nome)) {
            m_u.setNome(m_nome);
            aux += "\nNome: alterado.";
        } else {
            aux += "\nNome: não alterado.";
        }
        if (validaEmail(m_email)) {
            m_u.setEmail(m_email);
            aux += "\nEmail: alterado.";
        } else {
            aux += "\nEmail: não alterado.";
        }
        if (validaUsername(m_username)) {
            m_u.setUsername(m_username);
            aux += "\nUsername: alterado.";
        } else {
            aux += "\nUsername: não alterado.";
        }
        if (validaPassword(m_password)) {
            m_u.setPwd(m_password);
            aux += "\nPassword: alterada.";
        } else {
            aux += "\nPassword: não alterada.";
        }
        return aux;
    }

}
