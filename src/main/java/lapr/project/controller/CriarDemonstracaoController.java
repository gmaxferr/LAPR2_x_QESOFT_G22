package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.estados.*;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author osori
 */
public class CriarDemonstracaoController {

    private RegistoExposicoes m_re;
    private RegistoRecursos m_rr;
    private RegistoDemonstracoes m_rd;
    private CentroExposicoes m_centroExpo;
    private Exposicao m_exposicao;
    private Demonstracao m_demoCriada;
    private RegistoRecursos m_rrr;
    private EstadoExposicao m_estado;
    private EstadoExposicaoCriada m_estadoExposicaoCriada;
    private EstadoExposicaoDemosDefinidasSemFAE m_estadoExposicaoDemosDef;

    public void getRegistoExposicoes() {
        this.m_re = m_centroExpo.getRegistoExposicoes();

    }

    public ArrayList<Exposicao> getListaExposicoesDoOrganizador(String username) {
        //passar parametro username
        return m_re.getlistaExposicoesDoOrganizador();
    }

    public void setExposicao(Exposicao e) {
        this.m_exposicao = e;
    }

    public void getRegistoRecursos() {
        this.m_rr = m_centroExpo.getRegistoRecursos();
    }

    public void novaDemonstracao(String descricaoIntroduzidaPeloUtilizador) {
        this.m_demoCriada = m_rd.novaDemonstracao(descricaoIntroduzidaPeloUtilizador);
    }

    public void getRegistoDemonstracoes() {
        this.m_rd = m_exposicao.getRegistoDemonstracoes();
    }

    public ArrayList<Recurso> getListaDeRecursos() {
        return m_rr.getListaDeRecursos();
    }

    public void setRecurso(Recurso rec) {
        this.m_rrr.setRecurso(rec);
    }

    public void getRegistoRecursosDemo() {
        this.m_rrr = this.m_demoCriada.getRegistoRecursos();
    }

    public void confirma() {
        m_rd.confirma(this.m_demoCriada);
    }

    public void setEstado() {

        m_estado = this.m_exposicao.getEstado();
        if (m_estado instanceof EstadoExposicaoFAEDefinidosSemDemos) {
            m_estadoExposicaoDemosDef.setEstadoCompleta();
        } else if (m_estado instanceof EstadoExposicaoCriada) {
            m_estadoExposicaoCriada.setEstadoDemosDefinidasSemFAE();

        }
    }

}
