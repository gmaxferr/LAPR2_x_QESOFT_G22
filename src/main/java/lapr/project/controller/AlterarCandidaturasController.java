package lapr.project.controller;

import java.util.List;
import lapr.project.estados.EstadoExposicao;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.model.Produto;
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
    private String username;

    public AlterarCandidaturasController(RegistoCandidaturasAExposicao registoCandidaturas, String username) {
        m_rc = registoCandidaturas;
        this.username = username;
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
        this.m_rc = exposicao.getRegistoCandidaturasAExposicao();
    }

    public List<CandidaturaAExposicao> getExposRepresentante() {
        return m_rc.getCandidaturasRepresentante(username);
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

    /**
     * Remove produto da candidatura
     *
     * @param index - índice do produto a remover
     */
    public void removerProduto(int index) {
        try {
            cand.removeProduto(index);
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Adiciona produto à candidatura
     *
     * @param p - novo produto
     */
    public void adicionarProduto(Produto p) {
        cand.addProduto(p);
    }

    /**
     * Edita um produto
     *
     * @param index
     * @param novoProduto
     */
    public void editarProduto(int index, String novoProduto) {
        cand.editProduto(index, novoProduto);
    }
    
    public void setDadosCandidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, int area, int numConvites) {
        cand.setM_strNomeEmpresa(nomeEmpresa);
        cand.setM_strMorada(moradaEmpresa);
        cand.setM_intTelemovel(nomeEmpresa);
        cand.setM_intArea(moradaEmpresa);
        cand.setM_intNumConvites(moradaEmpresa);
    }
}
