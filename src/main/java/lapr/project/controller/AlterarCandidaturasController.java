package lapr.project.controller;

import java.util.List;
import lapr.project.estados.EstadoCandidatura;
import lapr.project.estados.EstadoExposicao;
import lapr.project.model.Candidatura;
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
    private EstadoCandidatura estadoCand;
    private Candidatura cand;
    private Expositor expositor;
    

    public AlterarCandidaturasController(RegistoCandidaturas registoCandidaturas) {
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
        estadoCand = cand.getEstadoCandidatura();
        return verificaCandidatura(estadoCand);
    }

    public boolean verificaCandidatura(EstadoCandidatura estado) {
        //verifica se o estado permite executar ese UC
        return true;
    }

    public void getM_RegistoCandidaturas() {
        this.m_rc = exposicao.getRegistoCandidaturas();
    }

    public List<Candidatura> getListaCandidaturas() {
        return m_rc.getListaCandidaturas();
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

    public String getM_strNomeEmpresa() {
        return expositor.getM_strNomeEmpresa();
    }

    public String getM_strMorada() {
        return expositor.getM_strMorada();
    }

    public int getM_intTelemovel() {
        return cand.getM_intTelemovel();
    }

    public float getM_strArea() {
        return cand.getM_floatArea();
    }

    public int getM_intNumConvites() {
        return cand.getM_intNumConvites();
    }

    public void setDadosCandidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, int area, int numConvites) {
        cand.setM_strNomeEmpresa(nomeEmpresa);
        cand.setM_strMorada(moradaEmpresa);
        cand.setM_intTelemovel(telemovel);
        cand.setM_intArea(area);
        cand.setM_intNumConvites(numConvites);
    }
}
