package lapr.project.controller;

import java.util.ArrayList;

/**
 * Representação do Controller do caso de uso - confirmar registo de utilizador
 *
 * @author Ricardo Osório Ana Leite
 */
public class ConfirmarRegistoController {

    private RegistoUtilizadores ru;
    private ArrayList<Utilizador> listaUtlNaoRegistados;

    //para testes
    CentroExposicoes centroExpo = new CentroExposicoes();

    public ConfirmarRegistoController() {
        this.listaUtlNaoRegistados = new ArrayList<>();
    }

    /**
     * Devolve a lista de Utilizadores registados sem o seu registo confirmado
     *
     * @return lista de Utilizadores cujo registo não foi confirmado
     */
    public ArrayList<Utilizador> getListaNovosRegistos() {
        listaUtlNaoRegistados = ru.getListaNovosRegistos();
        return listaUtlNaoRegistados;
    }

    /**
     * Método que define o Utilizador definido pelo utilizador a interagir com o
     * sistema
     *
     * @param u Utilizador escolhido
     */
    void setUtilizadorRegistado(Utilizador u) {
        u.setUtilizadorRegistado();
    }

    void getRegistoUtilizadores() {
        ru = centroExpo.getRegistoUtilizadores();
    }

}
