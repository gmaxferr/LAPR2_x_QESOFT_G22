package lapr.project.controller;

import java.util.List;
import lapr.project.estados.EstadoExposicao;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoOrganizadores;
import lapr.project.registos.RegistoUtilizadores;

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
    
    private EstadoExposicao estadoExposicao;
    
    private EstadoCandidaturaAExposicao estadoCandidatura;

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
     * @param strDataInicio Data de início da exposição
     * @param strDataFim Data de fim da exposição
     * @param strLocal Local de realização da exposição
     * @param lstUtz Lista de utilizadores associados à exposição
     * @return o objecto Exposição criado com estes parametros ou null se não
     * foi possivel criar com esses parametros
     */
    public Exposicao setDados(String strTitulo, String strDescricao, String strDataInicio, String strDataFim, Local strLocal, List<Utilizador> lstUtz) {
        m_exposicao.setTitulo(strTitulo);
        m_exposicao.setDescricao(strDescricao);
        m_exposicao.setPeriodo(strDataInicio, strDataFim);
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

    public boolean setID(String id) {
        return m_ru.identificarUtilizadorPeloId(id);
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

    public void setEstadoCriada() {
        this.estadoExposicao=this.m_exposicao.getEstado();
        estadoExposicao.setEstadoCriada();
    }

    public void setEstadoCandidaturasAbertas() {
        this.m_re.setEstadoCandidaturasAbertas(m_exposicao);
    }

    public void setEstadoCandidaturasFechadas() {
        this.m_re.setEstadoCandidaturasFechadas(m_exposicao);
    }

    public void setEstadoConflitosDetetados() {
        this.m_re.setEstadoExposicaoConflitosDetetados(m_exposicao);
    }
}
