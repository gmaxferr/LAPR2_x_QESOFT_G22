package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.RegistoUtilizadores;

/**
 * Representação do Controller do caso de uso - confirmar registo de utilizador
 *
 * @author G29
 */
public class ConfirmarRegistoController {

    /**
     * Registo de utilizadores (pendentes)
     */
    private RegistoUtilizadores m_rup;
    
    /**
     * Regsito Utilizadores (confirmados)
     */
    private RegistoUtilizadores m_ruc;
    
    /**
     * Lista de utilizadores nao registados
     */
    private List<Utilizador> m_listaUtlNaoRegistados;

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
        this.m_ruc = new RegistoUtilizadores("");
        this.m_rup = new RegistoUtilizadores("");
    }
    
    /**
     * Guarda o registo de utiliadores
     */
    public void getRegistoUtilizadores() {
        m_rup = m_centroExpo.getRegistoUtilizadoresPendentes();
        m_ruc = m_centroExpo.getRegistoUtilizadoresConfirmados();
    }

    /**
     * Devolve a lista de Utilizadores registados sem o seu registo confirmado
     *
     * @return lista de Utilizadores cujo registo não foi confirmado
     */
    public List<Utilizador> getListaNovosRegistos() {
        m_listaUtlNaoRegistados = m_rup.getListaUtilizadores();
        return m_listaUtlNaoRegistados;
    }

    /**
     * Confirma o registo de um utilizador e adiciona-o ao registo de 
     * utilizadores (confirmado) 
     *
     * @param u Utilizador escolhido
     */
    public void setUtilizadorRegistado(Utilizador u) {
        m_rup.getListaUtilizadores().remove(u);
        m_ruc.getListaUtilizadores().add(u);
    }
}
