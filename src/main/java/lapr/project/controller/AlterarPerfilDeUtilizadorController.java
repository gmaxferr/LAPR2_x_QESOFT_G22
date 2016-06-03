package lapr.project.controller;

import classesModelERegistodePPROG.CentroExposicoes;
import classesModelERegistodePPROG.Utilizador;
import classesModelERegistodePPROG.RegistoUtilizadores;

/**
 * Representação do Controller do caso de uso - alterar perfil de utilizador
 * 
 * @author Ana Leite e Ricardo Osório
 */
public class AlterarPerfilDeUtilizadorController {
        
    private CentroExposicoes m_centro_exposicoes;
    private RegistoUtilizadores m_ru;
    Utilizador u;
    
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
        u = m_ru.identificarUtilizador(username);
    }
    
    public String getNomeUtilizador(){
        return u.getNome();
    }
    
    public String getEmailUtilizador(){
        return u.getE_mail();
    }
    
    public String getPasswordUtilizador(){
        return u.getPassword();
    }
    
    public void setDadosUtilizador(String nome, String email, String username, String password){
        
        if(m_ru.validaDadosUnicos(username, email)){
        u.setNome(nome);
        u.setE_mail(email);
        u.setUsername(username);
        u.setPassword(password.toCharArray());
        }
    }
}
