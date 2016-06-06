package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoUtilizadores;


/**
 * Representação do Controller do caso de uso - registar utilizador novo
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistarUtilizadorController {

    private RegistoUtilizadores ru;

    public Utilizador u;

    //para testes
    CentroExposicoes centroExpo = new CentroExposicoes();

    public void novoUtilizador() {
        u = ru.novoUtilizador();
    }
    
    void getRegistoUtilizadores() {
        this.ru = centroExpo.getRegistoUtilizadores();
    }
    
    void setDados(String nome, String email, char[] password) {
        u.setEmail(email);
        u.setNome(nome);
        u.setPwd(password);
        u.validaUtilizador();
    }

    void addUtilizador() {
        ru.addUtilizador(u);
    }

    

}
