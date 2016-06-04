package lapr.project.controller;

import java.util.List;
import lapr.project.estados.EstadoExposicao;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.registos.RegistoCandidaturasAExposicao;

/**
 * Representação do Controller do caso de uso - alterar candidaturas
 *
 * @author Ana Leite
 */
public class AlterarCandidaturasController {

    private RegistoCandidaturasAExposicao m_rc;
    private Exposicao exposicao;
    private EstadoExposicao estadoExpo;
    private EstadoCandidaturaAExposicao estadoCand;
    private CandidaturaAExposicao cand;
    private Expositor expositor;

    public AlterarCandidaturasController(RegistoCandidaturasAExposicao registoCandidaturas) {
        m_rc = registoCandidaturas;
    }

    public boolean getM_EstadoExposicao() {
        estadoExpo = exposicao.getEstado();
        return verificaEstadoExposicao(estadoExpo);
    }

    public boolean verificaEstadoExposicao(EstadoExposicao estado) {
        //Verifica se o estado permite executar este UC
        return true;
    }

    public boolean getEstadoCandidatura() {
        estadoCand = cand.getEstado();
        return verificaCandidatura(estadoCand);
    }

    public boolean verificaCandidatura(EstadoCandidaturaAExposicao estado) {
        //verifica se o estado permite executar ese UC
        return true;
    }

    public void getM_RegistoCandidaturas() {
        this.m_rc = exposicao.getRegistoCandidaturas();
    }

    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return m_rc.getListaCandidaturasAExposicao();
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

    public String getM_strNomeEmpresa() {
        return cand.getM_StrNomeEmpresa();
    }

    public String getM_strMorada() {
        return cand.getM_StrMoradaEmpresa();
    }

    public int getM_intTelemovel() {
        return cand.getM_intTelemovel();
    }

    public float getM_strArea() {
        return cand.getM_intArea();
    }

    public int getM_intNumConvites() {
        return cand.getM_intNumConvites();
    }

    public void setDadosCandidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, int area, int numConvites) {
        cand.setM_strNomeEmpresa(nomeEmpresa);
        cand.setM_strMorada(moradaEmpresa);
        cand.setM_intTelemovel(nomeEmpresa);
        cand.setM_intArea(moradaEmpresa);
        cand.setM_intNumConvites(moradaEmpresa);
    }
}
