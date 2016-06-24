package lapr.project.controller;

import java.util.List;
import lapr.project.exceptions.KeywordsErradasException;
import lapr.project.model.*;
import lapr.project.registos.RegistoCandidaturasAExposicao;

/**
 * Representação do Controller do caso de uso - alterar candidaturas
 *
 * @author G29
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
    private String keywords;
    private List<Integer> produtosARemover;
    private List<Produto> produtosAAdicionar;
    private List<Alteracao> produtosAAlterar;

    public AlterarCandidaturaExpoController(String username) {
        this.m_username = username;
        keywords = "";
    }

    public void setExposicao(Exposicao e) {
        this.m_exposicao = e;
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
        produtosARemover.add(index);
    }

    /**
     * Adiciona produto à candidatura
     *
     * @param p - novo produto
     */
    public void adicionarProduto(Produto p) {
        produtosAAdicionar.add(p);
    }

    /**
     * Edita um produto
     *
     * @param index
     * @param novoProduto
     */
    public void editarProduto(int index, String novoProduto) {
        produtosAAlterar.add(new Alteracao(index, novoProduto));
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
        if (!keywords.isEmpty()) {
            m_cand.setKeywords(keywords);
            try {
                for (Integer i : produtosARemover) {
                    m_cand.removeProduto(i);
                }
            } catch (IllegalArgumentException e) {
            }
            for (Alteracao a : produtosAAlterar) {
                m_cand.editProduto(a.getIndiceProduto(), a.getNovoProduto());
            }
            for (Produto p : produtosAAdicionar) {
                m_cand.addProduto(p);
            }
        }
    }

    public void setKeywords(String keywords) throws KeywordsErradasException {
        this.keywords = keywords;
    }

    public void setListaDemonstracoesCandidatura(List<Demonstracao> listaDemonstracoesAdicionadas) {
        m_cand.getRegistoDemonstracoes().setListaDemonstracoes(listaDemonstracoesAdicionadas);
    }

    private class Alteracao {

        int indiceProduto;
        String novoProduto;

        public Alteracao(int index, String novoNome) {
            indiceProduto = index;
            novoProduto = novoNome;
        }

        public int getIndiceProduto() {
            return indiceProduto;
        }

        public String getNovoProduto() {
            return novoProduto;
        }
    }

}
