package lapr.project.controller;

import classesREMOVIDAS.CentroExposicoes;
import classesREMOVIDAS.Utilizador;
import classesREMOVIDAS.RegistoUtilizadores;

/**
 * Representação do Controller do caso de uso - registar utilizador novo
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistarUtilizadorController {

    private RegistoUtilizadores ru;

    public static Utilizador u;

    //para testes
    CentroExposicoes centroExpo = new CentroExposicoes();

    public void novoUtilizador() {
        u = ru.novoUtilizador();
    }
    
    void getRegistoUtilizadores() {
        this.ru = centroExpo.getRegistoUtilizadores();
    }
    
    void setDados(String nome, String email, String password) {
        u.setEmail(email);
        u.setNome(nome);
        u.setPwd(password);
        u.validaUtilizador();
    }

    void addUtilizador() {
        ru.addUtilizador(u);
    }

    

}
