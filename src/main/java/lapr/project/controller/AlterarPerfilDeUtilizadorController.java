package lapr.project.controller;

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

    public AlterarPerfilDeUtilizadorController(CentroExposicoes centroExposicoes) {
        m_ce = centroExposicoes;
    }

    public void getRegistoutilizadores() {
        m_ce.getRegistoUtilizadores();
    }

    public void identificaUtilizador(String username) {
        //devolve null se não encontrar
        setUsername(username);
        m_u = m_ru.identificarUtilizador(username);
    }

    public String getNomeUtilizador() {
        m_nome = m_u.getNome();
        return m_nome;
    }

    public String getEmailUtilizador() {
        m_email = m_u.getEmail();
        return m_email;
    }

    public char[] getPasswordUtilizador() {
        m_password = m_u.getPwd();
        return m_password;
    }

    /**
     * Valida e altera o nome caso este seja validado corretamente.
     * @param nome - novo nome
     * @return true se for válido; false caso contrário.
     */
    public boolean changeNome(String nome) {
        if (m_ru.validaNome(nome)) {
            setNome(nome);
            return true;
        }
        return false;
    }

    /**
     * Valida e altera o username caso este seja validado corretamente.
     * @param username - novo username
     * @return true se for válido; false caso contrário.
     */
    public boolean changeUsername(String username) {
        if (m_ru.validaUsername(username)) {
            setNome(username);
            return true;
        }
        return false;
    }

    /**
     * Valida e altera o email caso este seja validado corretamente.
     * @param email - novo email
     * @return true se for válido; false caso contrário.
     */
    public boolean changeEmail(String email) {
        if (m_ru.validaEmail(email)) {
            setEmail(email);
            return true;
        }
        return false;
    }

    /**
     * Valida e altera a password caso esta seja validada corretamente.
     * @param password - nova password
     * @return true se for válida; false caso contrário.
     */
    public boolean changePassword(char[] password) {
        if (m_u.validaPassword(password)) {
            setPassword(password);
            return true;
        }
        return false;
    }

    /**
     * Armazena o username do utilizador no controller
     * @param username - parametro a armazenar
     */
    private void setUsername(String username) {
        this.m_username = username;
    }

    /**
     * Armazena a Password do utilizador no controller
     * @param password - parametro a armazenar
     */
    private void setPassword(char[] password) {
        this.m_password = password;
    }

    /**
     * Armazena o email do utilizador no controller
     * @param email - parametro a armazenar
     */
    private void setEmail(String email) {
        this.m_email = email;
    }

    /**
     * Armazena o nome do utilizador no controller
     * @param nome - parametro a armazenar
     */
    private void setNome(String nome) {
        this.m_nome = nome;
    }

}
