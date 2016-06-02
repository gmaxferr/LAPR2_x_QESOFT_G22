package lapr.project.controller;

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
        m_ru.identificarUtilizador(username);
    }
    
    public String getNomeUtilizador(){
        return u.getM_strNome();
    }
    
    public String getEmailUtilizador(){
        return u.getM_strEmail();
    }
    
    public String getPasswordUtilizador(){
        return u.getM_strPwd();
    }
    
    public void setDadosUtilizador(String nome, String email, String username, String password){
        
        if(m_ru.validaDadosUnicos(username, email)){
        u.setNome(nome);
        u.setEmail(email);
        u.setUsername(username);
        u.setPwd(password);
        }
    }
}
