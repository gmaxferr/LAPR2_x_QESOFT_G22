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
    private Exposicao m_exposicao;
    private EstadoExposicao m_estadoExpo;
    private EstadoCandidaturaAExposicao m_estadoCand;
    private CandidaturaAExposicao m_cand;
    private Expositor m_expositor;
    private String m_username;

    public AlterarCandidaturasController(RegistoCandidaturasAExposicao registoCandidaturas, String username) {
        m_rc = registoCandidaturas;
        this.m_username = username;
    }

    public boolean getM_EstadoExposicao() {
        m_estadoExpo = m_exposicao.getEstado();
        return verificaEstadoExposicao(m_estadoExpo);
    }

    public boolean verificaEstadoExposicao(EstadoExposicao estado) {
        //Verifica se o estado permite executar este UC
        return true;
    }

    public boolean getEstadoCandidatura() {
        m_estadoCand = m_cand.getEstado();
        return verificaCandidatura(m_estadoCand);
    }

    public boolean verificaCandidatura(EstadoCandidaturaAExposicao estado) {
        //verifica se o estado permite executar ese UC
        return true;
    }

    public void getM_RegistoCandidaturas() {
        this.m_rc = m_exposicao.getRegistoCandidaturasAExposicao();
    }

    public List<CandidaturaAExposicao> getExposRepresentante() {
        return m_rc.getCandidaturasRepresentante(m_username);
    }

    public void setExposicao(Exposicao m_exposicao) {
        this.m_exposicao = m_exposicao;
    }

    public String getNomeEmpresa() {
        return m_cand.getM_StrNomeEmpresa();
    }

    public String getMorada() {
        return m_cand.getM_StrMoradaEmpresa();
    }

    public int getTelemovel() {
        return m_cand.getM_intTelemovel();
    }

    public float getArea() {
        return m_cand.getM_intArea();
    }

    public int getNumConvites() {
        return m_cand.getM_intNumConvites();
    }

    /**
     * Remove produto da candidatura
     *
     * @param index - índice do produto a remover
     */
    public void removerProduto(int index) {
        try {
            m_cand.removeProduto(index);
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Adiciona produto à candidatura
     *
     * @param p - novo produto
     */
    public void adicionarProduto(Produto p) {
        m_cand.addProduto(p);
    }

    /**
     * Edita um produto
     *
     * @param index
     * @param novoProduto
     */
    public void editarProduto(int index, String novoProduto) {
        m_cand.editProduto(index, novoProduto);
    }
    
    public void setDadosCandidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, int area, int numConvites) {
        m_cand.setM_strNomeEmpresa(nomeEmpresa);
        m_cand.setM_strMorada(moradaEmpresa);
        m_cand.setM_intTelemovel(nomeEmpresa);
        m_cand.setM_intArea(moradaEmpresa);
        m_cand.setM_intNumConvites(moradaEmpresa);
    }
}
