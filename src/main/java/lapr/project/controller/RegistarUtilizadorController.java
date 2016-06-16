package lapr.project.controller;

import lapr.project.exceptions.InvalidEmailException;
import lapr.project.exceptions.InvalidPasswordException;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoUtilizadores;


/**
 * Representação do Controller do caso de uso - registar utilizador novo
 *
 * @author Ana Leite 
*/
public class RegistarUtilizadorController {

    /**
     * Registo de Utilizadores
     */
    private RegistoUtilizadores m_ru;

    /**
     * Utilizador
     */
    private Utilizador m_utilizador;

    /**
     * Centro de exposições
     */
    private CentroExposicoes m_centroExpo;
    
    /**
     * Constrói uma instância de RegistarUtilizadorController recendo como
     * parâmentro o centro de exposições
     * 
     * @param centroExposicoes centro de exposições
     */
    public RegistarUtilizadorController(CentroExposicoes centroExposicoes){
        this.m_centroExpo = centroExposicoes;
    }
    
    /**
     * Guarda o registo de utilizadores
     */
    public void getRegistoUtilizadores() {
        this.m_ru = m_centroExpo.getRegistoUtilizadores();
    }
    
    /**
     * Cria um novo utilizador
     * 
     * @return novo utilizador 
     */
    public Utilizador novoUtilizador() {
       m_utilizador = m_ru.novoUtilizador();
       return m_utilizador;
    }
    
    /**
    * Modifica os dados do utilizador
    * 
    * @param nome nome do utilizador
    * @param email email do utilizador
    * @param password password do utilizador
    * @param username username do utilizador
    */
    public void setDadosDoUtilizador(String nome, String email, char[] password, String username, String keyword) {
        m_utilizador.setEmail(email);
        m_utilizador.setNome(nome);
        m_utilizador.setPwd(password);
        m_utilizador.setUsername(username);
        m_utilizador.setKeyword(keyword);
    }
    
    /**
     * Valida os dados introduzidos do utilizador 
     * 
     * @param nome nome do utilizador   
     * @param email email do utilizador
     * @param password password do utilizador
     * @param username username do utilizador
     * @return true se os dados introduzidos forem todos válidos. Caso contrário
     * retorna false.
     * @throws InvalidPasswordException 
     * @throws InvalidEmailException 
     */
    public boolean validaDadosDoUtilizador(String nome, String email, char[] password, String username) throws InvalidPasswordException, InvalidEmailException {
       return m_utilizador.validaDadosDoUtilizador(nome, password, username, email);
    }

    /**
     * Adiciona o utilizador ao registo de utilizadores
     * 
     * @param u utilizador a ser adicionado
     * @return true se o utilizador foi adicionado.Caso contrário retorna false.
     */
    public boolean addUtilizador(Utilizador u) throws InvalidPasswordException {
       return m_ru.addUtilizador(u);
    }

    
}
