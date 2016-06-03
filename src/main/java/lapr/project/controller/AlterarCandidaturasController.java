package lapr.project.controller;

import java.util.List;
import lapr.project.estados.EstadoExposicao;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.registos.RegistoCandidaturas;

/**
 * Representação do Controller do caso de uso - alterar candidaturas
 *
 * @author Ana Leite
 */
public class AlterarCandidaturasController {

    private RegistoCandidaturas m_rc;
    private Exposicao exposicao;
    private EstadoExposicao estadoExpo;
    private EstadoCandidaturaAExposicao estadoCand;
    private CandidaturaAExposicao cand;
    private Expositor expositor;

    public AlterarCandidaturasController(RegistoCandidaturas registoCandidaturas) {
        m_rc = registoCandidaturas;
    }

    public boolean getM_EstadoExposicao() {
        estadoExpo = exposicao.getEstadoExposicao();
        return verificaEstadoExposicao(estadoExpo);
    }

    public boolean verificaEstadoExposicao(EstadoExposicao estado) {
        //Verifica se o estado permite executar este UC
        return true;
    }

    public boolean getEstadoCandidatura() {
        estadoCand = cand.getEstadoCandidatura();
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
        return m_rc.getListaCandidaturas();
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

    public String getM_strNomeEmpresa() {
        return cand.getM_NomeEmpresa();
    }

    public String getM_strMorada() {
        return cand.getM_MoradaEmpresa();
    }

    public int getM_intTelemovel() {
        return cand.getM_NumeroTelemovel();
    }

    public float getM_strArea() {
        return cand.getM_Area();
    }

    public int getM_intNumConvites() {
        return cand.getM_NumConvites();
    }

    public void setDadosCandidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, int area, int numConvites) {
        cand.setM_NomeEmpresa(nomeEmpresa);
        cand.setM_MoradaEmpresa(moradaEmpresa);
        cand.setM_TelemovelEmpresa(telemovel);
        cand.setM_Area(area);
        cand.setM_NumConvites(numConvites);
    }
}
