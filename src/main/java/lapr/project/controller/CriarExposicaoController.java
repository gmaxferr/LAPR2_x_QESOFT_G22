package lapr.project.controller;

import lapr.project.estados.Exposicao.EstadoExposicao;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;
import lapr.project.utils.Data;

/**
 * Representação do Controller do caso de uso - criar exposição
 *
 * @author Ana Leite e Ricardo Osório
 */
public class CriarExposicaoController {

    private final CentroExposicoes m_centro_exposicoes;

    private final RegistoExposicoes m_re;

    private final RegistoUtilizadores m_ru;

    private final RegistoOrganizadores m_ro;

    private Exposicao m_exposicao;

    private EstadoExposicao m_estadoExposicao;

    public CriarExposicaoController(CentroExposicoes centro_exposicoes, RegistoExposicoes registoExposicoes, RegistoUtilizadores registoUtilizadores, RegistoOrganizadores registoOrganizadores) {
        m_centro_exposicoes = centro_exposicoes;
        m_re = registoExposicoes;
        m_ru = registoUtilizadores;
        m_ro = registoOrganizadores;
    }

    public void getRegistoExposicao() {
        m_centro_exposicoes.getRegistoExposicoes();
    }

    public void getRegistoUtilizadores() {
        m_centro_exposicoes.getRegistoUtilizadores();
    }

    /**
     * Cria uma nova exposição
     */
    public void novaExposicao() {
        m_exposicao = m_re.novaExposicao();
    }

    /**
     * Devolve uma lista com todos os utilizadores
     *
     * @return lista de todos os utilizadores
     */
    public List<Utilizador> getListaUtilizadores() {
        return m_ru.getListaUtilizadores();
    }

    /**
     * Define os dados da exposição
     *
     * @param strTitulo Titulo da exposição
     * @param strDescricao Descrição da exposição
     * @param dataInicio
     * @param dataFim
     * @param dataAberturaSubCand
     * @param dataEncerramentoSubCand
     * @param dataFimDetecaoConflitos
     * @param strLocal Local de realização da exposição
     * @param lstUtz Lista de utilizadores associados à exposição
     * @return o objecto Exposição criado com estes parametros ou null se não
     * foi possivel criar com esses parametros
     */
    public Exposicao setDados(String strTitulo, String strDescricao, Data dataInicio, Data dataFim, Data dataAberturaSubCand, Data dataEncerramentoSubCand, Data dataFimDetecaoConflitos, Local strLocal, List<Utilizador> lstUtz) {
        m_exposicao.setTitulo(strTitulo);
        m_exposicao.setDescricao(strDescricao);
        m_exposicao.setPeriodo(dataInicio, dataFim);
        m_exposicao.setDataAberturaSubCand(dataAberturaSubCand);
        m_exposicao.setDataEncerramentoSubCand(dataAberturaSubCand);
        m_exposicao.setDataFimDetecaoConflitos(dataFimDetecaoConflitos);
        m_exposicao.setLocal(strLocal);

        for (Utilizador u : lstUtz) {
            m_ro.addOrganizador(u);
        }

        if (m_re.validaExposicao(m_exposicao)) {
            return m_exposicao;
        } else {
            return null;
        }
    }
    /**
     * Devolve um boolean que representa o sucesso da operação que é registar
     * uma nova exposição
     *
     * @return boolean que representa o sucesso da operação que é registar uma
     * nova exposição
     */
    public boolean registaExposicao() {

        return m_re.registaExposicao(m_exposicao);

    }
    
    /**
     * Adiciona novo organizador à exposição
     * @param id - identificação do organizador
     * @return true se o organizador é valido e foi adicionado ou false caso contrário
     */
    public boolean addOrganizador(String id){
        Utilizador utilizador = m_ru.identificarUtilizadorPeloUsername(id);
        if(m_exposicao.addOrganizador(utilizador)){
            return true;
        }else{
            return false;
        }
    }

    public void setEstadoCriada() {
        this.m_estadoExposicao = this.m_exposicao.getEstado();
        m_estadoExposicao.setEstadoCriada();
    }

}
