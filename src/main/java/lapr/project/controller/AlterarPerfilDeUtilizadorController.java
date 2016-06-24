package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.registos.RegistoUtilizadores;

/**
 * Representação do Controller do caso de uso - alterar perfil de utilizador
 *
 * @author G29
 */
public class AlterarPerfilDeUtilizadorController {

    /**
     * Centro de exposições
     */
    private CentroExposicoes m_ce;
    
    /**
     * Registo de utilizadores
     */
    private RegistoUtilizadores m_ru;
    
    /**
     * Utilizador
     */
    private Utilizador m_u;

    /**
     * Email do utilizador
     */
    private String m_email;
    
    /**
     * Nome do utilizador
     */
    private String m_nome;
    
    /**
     * Username do utilizador
     */
    private String m_username;
    
    /**
     * Password do utilizador
     */
    private char[] m_password;

    /**
     * Contrutor de objetos do tipo AlterarPerfilDeUtilizadorController com o 
     * parametro centro de exposições
     *
     * @param centroExposicoes - Centro de Exposições
     */
    public AlterarPerfilDeUtilizadorController(CentroExposicoes centroExposicoes) {
        m_ce = centroExposicoes;
    }

    /**
     * Guarda o registo de utilizadores
     */
    public void carregaRegistoUtilizadores() {
        m_ru = m_ce.getRegistoUtilizadoresConfirmados();
    }

    /**
     * Inicializa o utilizador através da procura do utilizador com o username 
     * passado por parametro
     *
     * @param username - username de procura
     */
    public void identificaUtilizador(String username) {
        //devolve null se não encontrar
        m_u = m_ru.identificarUtilizadorPeloUsername(username);
    }

    /**
     * Inicializa e retorna nome de utilizador
     *
     * @return nome de utilizador
     */
    public String getNomeUtilizador() {
        m_nome = m_u.getNome();
        return m_nome;
    }

    /**
     * Inicializa e retorna email de utilizador
     *
     * @return email de utilizador
     */
    public String getEmailUtilizador() {
        m_email = m_u.getEmail();
        return m_email;
    }

    /**
     * Retorna password de utilizador, transformando-a numa String
     *
     * @return password de utilizador
     */
    public String getPasswordUtilizador() {
        m_password = m_u.getPwd();
        String aux = "";
        for(char c: m_password){
            aux += c;
        }
        return aux;
    }

    /**
     * Armazena o username do utilizador no controller
     *
     * @param username - username armazenar
     */
    public void setUsername(String username) {
        this.m_username = username;
    }

    /**
     * Armazena a Password do utilizador no controller
     *
     * @param password - password a armazenar
     */
    public void setPassword(char[] password) {
        this.m_password = password;
    }

    /**
     * Armazena o email do utilizador no controller
     *
     * @param email - email a armazenar
     */
    public void setEmail(String email) {
        this.m_email = email;
    }

    /**
     * Armazena o nome do utilizador no controller
     *
     * @param nome - nome a armazenar
     */
    public void setNome(String nome) {
        this.m_nome = nome;
    }

    /**
     * Regista os dados do utilizador, tornando-os efetivos.
     * 
     * @return string com alterações (para expor ao utilizador)
     */
    public String confirmaAlteracoes() {
        String aux = "Alterações Efetuadas:";
        if (m_ru.validaNome(m_nome)) {
            m_u.setNome(m_nome);
            aux += "\nNome: alterado.";
        } else {
            aux += "\nNome: não alterado.";
        }
        if (m_ru.validaEmail(m_email)) {
            m_u.setEmail(m_email);
            aux += "\nEmail: alterado.";
        } else {
            aux += "\nEmail: não alterado.";
        }
        if (m_ru.validaUsername(m_username)) {
            m_u.setUsername(m_username);
            aux += "\nUsername: alterado.";
        } else {
            aux += "\nUsername: não alterado.";
        }
        if (m_u.validaPassword(m_password)) {
            m_u.setPwd(m_password);
            aux += "\nPassword: alterada.";
        } else {
            aux += "\nPassword: não alterada.";
        }
        return aux;
    }

}
