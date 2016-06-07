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
        
    private CentroExposicoes m_centro_exposicoes;
    private RegistoUtilizadores m_ru;
    private Utilizador m_u;
    
    public AlterarPerfilDeUtilizadorController(CentroExposicoes centroExposicoes, RegistoUtilizadores registoUtilizadores){
        m_centro_exposicoes = centroExposicoes;
        m_ru = registoUtilizadores;
}

    public void getM_ru() {
       m_centro_exposicoes.getRegistoUtilizadores();
    }
    
    public void identificaUtilizador() {
        m_centro_exposicoes.getRegistoUtilizadores();
    }
    
    public void identificaUtilizador(String username){
        //devolve null se não encontrar
        m_u = m_ru.identificarUtilizador(username);
    }
    
    public String getNomeUtilizador(){
        return m_u.getStrNome();
    }
    
    public String getEmailUtilizador(){
        return m_u.getStrEmail();
    }
    
    public char[] getPasswordUtilizador(){
        return m_u.getM_StrPwd();
    }
    
    public void setDadosUtilizador(String nome, String email, String username, String password){
        
        if(m_ru.validaDadosUnicos(username, email)){
        m_u.setNome(nome);
        m_u.setEmail(email);
        m_u.setUsername(username);
        m_u.setPwd(password.toCharArray());
        }
    }
}
