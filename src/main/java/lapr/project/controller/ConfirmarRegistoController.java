package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoUtilizadores;

/**
 * Representação do Controller do caso de uso - confirmar registo de utilizador
 *
 * @author Ana Leite
 */
public class ConfirmarRegistoController {

    /**
     * Registo de utilizadores
     */
    private RegistoUtilizadores m_ru;
    
    /**
     * Lista de utilizadores nao registados
     */
    private ArrayList<Utilizador> m_listaUtlNaoRegistados;

    /**
     * Centro de exposições
     */
    CentroExposicoes m_centroExpo;

    /**
     * Constrói uma instância de ConfirmarRegistarController recendo como
     * parâmentro o centro de exposições
     * 
     * @param centroExposicoes centro de exposições
     */
    public ConfirmarRegistoController(CentroExposicoes centroExposicoes) {
        this.m_listaUtlNaoRegistados = new ArrayList<>();
        this.m_centroExpo = centroExposicoes;
    }
    
    /**
     * Guarda o registo de utiliadores
     */
    public void getRegistoUtilizadores() {
        m_ru = m_centroExpo.getRegistoUtilizadores();
    }

    /**
     * Devolve a lista de Utilizadores registados sem o seu registo confirmado
     *
     * @return lista de Utilizadores cujo registo não foi confirmado
     */
    public ArrayList<Utilizador> getListaNovosRegistos() {
        m_listaUtlNaoRegistados = m_ru.getListaNovosRegistos();
        return m_listaUtlNaoRegistados;
    }

    /**
     * Define o Utilizador definido pelo utilizador a interagir com o
     * sistema
     *
     * @param u Utilizador escolhido
     */
    public void setUtilizadorRegistado(Utilizador u) {
        u.setUtilizadorRegistado();
    }

    

}
