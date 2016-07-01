package lapr.project.controller;

import java.util.ArrayList;
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

    /**
     * Registo de candidaturas a exposição
     */
    private RegistoCandidaturasAExposicao m_rc;
    
    /**
     * Exposição selecionada
     */
    private Exposicao m_exposicao;
    
    /**
     * Candidatura a exposição
     */
    private CandidaturaAExposicao m_cand;
    
    /**
     * Username do representante
     */
    private String m_username;
    
    /**
     * Novo nome da empresa
     */
    private String novoNomeEmpresa;
    
    /**
     * Nova morada da empresa
     */
    private String novaMoradaEmpresa;
    
    /**
     * Novo telemovel
     */
    private String novoTelemovel;
    
    /**
     * Nova area
     */
    private String novaArea;
    
    /**
     * Novo numero de convites
     */
    private String novoNumConvites;
    
    /**
     * Novas keywords
     */
    private String keywords;
    
    /**
     * Lista de produtos a remover
     */
    private List<Integer> produtosARemover;
    
    /**
     * Lista de produtos a adicionar
     */
    private List<Produto> produtosAAdicionar;
    
    /**
     * Lista de produtos a alterar
     */
    private List<Alteracao> produtosAAlterar;

    /**
     * Constutor de objetos do tipo AlterarCandidaturaExpoController com o
     * parametro username do representante
     * 
     * @param username username do representante
     */
    public AlterarCandidaturaExpoController(String username) {
        produtosAAdicionar=new ArrayList<>();
        this.m_username = username;
        keywords = "";
    }

    /**
     * Modifica a exposição e guarda o registo de candidaturas a exposição
     * 
     * @param e exposição selecionada
     */
    public void setExposicao(Exposicao e) {
        this.m_exposicao = e;
        this.m_rc = m_exposicao.getRegistoCandidaturasAExposicao();
    }

    /**
     * Permite selecionar a candidatura a alterar
     *
     * @param c candidatura a selecionar
     */
    public void setM_CandidaturaSelecionada(CandidaturaAExposicao c) {
        this.m_cand = c;
    }

    /**
     * Devolve a lista de candidaturas do representante
     * 
     * @return lista de candidaturas do representante logado
     */
    public List<CandidaturaAExposicao> getM_ListaCandidaturasRepresentante() {
        return m_rc.getCandidaturasRepresentante(m_username);
    }

    /**
     * Devolve o nome da empresa
     * 
     * @return nome da empresa
     */
    public String getNomeEmpresa() {
        return m_cand.getNomeEmpresa();
    }

    /**
     * Devolve a morada da empresa
     * 
     * @return morada da empresa
     */
    public String getMorada() {
        return m_cand.getMoradaEmpresa();
    }

    /**
     * Devolve o telemovel
     * 
     * @return telemovel
     */
    public int getTelemovel() {
        return m_cand.getTelemovel();
    }
    
    /**
     * Devolve a area
     * 
     * @return area
     */
    public float getArea() {
        return m_cand.getArea();
    }

    /**
     * Devolve o numero de convites
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
     * @param nomeEmpresa novo nome da empresa
     * @param moradaEmpresa nova morada da empresa
     * @param telemovel novo telemovel da empresa
     * @param area nova area da empresa
     * @param numConvites novo numero de convites
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

    /**
     * Modifica as keywords
     * 
     * @param keywords keywords a alterar
     * @throws KeywordsErradasException 
     */
    public void setKeywords(String keywords) throws KeywordsErradasException {
        this.keywords = keywords;
    }

    /**
     * Modifica a lista de demonstrações adicionadas
     * 
     * @param listaDemonstracoesAdicionadas nova lista de demonstrações adicionadas
     */
    public void setListaDemonstracoesCandidatura(List<Demonstracao> listaDemonstracoesAdicionadas) {
        m_cand.getRegistoDemonstracoes().setListaDemonstracoes(listaDemonstracoesAdicionadas);
    }

    /**
     * Representação de uma alteração
     */
    private class Alteracao {

        /**
         * Indice do produto
         */
        int indiceProduto;
        
        /**
         * Novo produto
         */
        String novoProduto;

        /**
         * Construtor de objetos do tipo Alteracao com os parametros indice e 
         * novo nome
         * 
         * @param index indice do produto
         * @param novoNome novo nome do produto
         */
        public Alteracao(int index, String novoNome) {
            indiceProduto = index;
            novoProduto = novoNome;
        }

        /**
         * Devolve o indice do produto
         * 
         * @return indice do produto
         */
        public int getIndiceProduto() {
            return indiceProduto;
        }

        /**
         * Devolve o novo produto
         * 
         * @return novo produto
         */
        public String getNovoProduto() {
            return novoProduto;
        }
    }

}
