package lapr.project.controller;

import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;
import lapr.project.model.Produto;
import lapr.project.registos.RegistoCandidaturasAExposicao;

/**
 * Representação do Controller do caso de uso - alterar candidaturas
 *
 * @author Ana Leite
 */
public class AlterarCandidaturaExpoController {

    private RegistoCandidaturasAExposicao m_rc;
    private Exposicao m_exposicao;
    private CandidaturaAExposicao m_cand;
    private String m_username;

    private String novoNomeEmpresa;
    private String novaMoradaEmpresa;
    private String novoTelemovel;
    private String novaArea;
    private String novoNumConvites;

    public AlterarCandidaturaExpoController(Exposicao e, String username) {
        this.m_username = username;
        this.m_exposicao = e;
    }

    /**
     *
     */
    public void getM_RegistoCandidaturas() {
        this.m_rc = m_exposicao.getRegistoCandidaturasAExposicao();
    }

    /**
     * Permite selecionar a candidatura a alterar
     *
     * @param c
     */
    public void setM_CandidaturaSelecionada(CandidaturaAExposicao c) {
        this.m_cand = c;
    }

    /**
     *
     * @return candidaturas do representante logado
     */
    public List<CandidaturaAExposicao> getM_ListaCandidaturasRepresentante() {
        return m_rc.getCandidaturasRepresentante(m_username);
    }

    /**
     *
     * @return nome da empresa
     */
    public String getNomeEmpresa() {
        return m_cand.getNomeEmpresa();
    }

    /**
     *
     * @return morada
     */
    public String getMorada() {
        return m_cand.getMoradaEmpresa();
    }

    /**
     *
     * @return telemovel
     */
    public int getTelemovel() {
        return m_cand.getTelemovel();
    }

    /**
     *
     * @return area
     */
    public float getArea() {
        return m_cand.getArea();
    }

    /**
     *
     * @return numero de convites
     */
    public int getNumConvites() {
        return m_cand.getNumConvites();
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

    /**
     * Cria temporariamente os novos dados a alterar
     *
     * @param nomeEmpresa
     * @param moradaEmpresa
     * @param telemovel
     * @param area
     * @param numConvites
     */
    public void setDadosCandidatura(String nomeEmpresa, String moradaEmpresa, String telemovel, String area, String numConvites) {
        novoNomeEmpresa = nomeEmpresa;
        novaArea = area;
        novaMoradaEmpresa = moradaEmpresa;
        novoNumConvites = numConvites;
        novoTelemovel = telemovel;
    }

    /**
     * Regista as alterções na candidatura
     *
     * @param nomeEmpresa
     * @param moradaEmpresa
     * @param telemovel
     * @param area
     * @param numConvites
     */
    public void alterarCandidatura() {
        m_cand.setNomeEmpresa(novoNomeEmpresa);
        m_cand.setMorada(novaMoradaEmpresa);
        m_cand.setTelemovel(novoTelemovel);
        m_cand.setArea(novaArea);
        m_cand.setNumConvites(novoNumConvites);
    }
}
