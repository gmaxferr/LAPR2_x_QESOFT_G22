package lapr.project.controller;

import java.util.List;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.exceptions.*;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Controller do caso de uso - criar candidatura.
 *
 * @author G29
 */
public class CriarCandidaturaAExposicaoController {

    /**
     * Registo de exposições.
     */
    private RegistoExposicoes m_re;

    /**
     * Registo de candidaturas.
     */
    private RegistoCandidaturasAExposicao m_rc;

    /**
     * Registo de produtos.
     */
    private RegistoProdutos m_rp;

    /**
     * Registo de demonstrações.
     */
    private RegistoDemonstracoes m_rd;

    /**
     * Exposição escolhida pelo utilizador
     */
    private Exposicao m_exposicaoEscolhida;

    /**
     * Candidatura criada no processo. Funciona como uma candidatura temporária
     */
    private CandidaturaAExposicao m_candidaturaCriada;

    /**
     * Centro de exposições.
     */
    private CentroExposicoes m_centroExposicoes;

    /**
     * Estado da candidatura
     */
    private EstadoCandidaturaAExposicao m_estadoCandidatura;

    /**
     * Constrói uma instância de CriarCandidaturaController recebendo como
     * parâmetro o centro de exposições.
     *
     * @param centroExposicoes centro de exposições
     */
    public CriarCandidaturaAExposicaoController(CentroExposicoes centroExposicoes) {
        this.m_centroExposicoes = centroExposicoes;
    }

    /**
     * Guarda o registo de exposições.
     */
    public void getRegistoExposicoes() {
        this.m_re = m_centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista de Exposições.
     *
     * @return lista de Exposições
     */
    public List<Exposicao> getListaExposicoesEstadoCandidaturasAbertas() {
        return this.m_re.getlistaExposicoesEstadoCandidaturasAbertas();
    }

    /**
     * Modifica a exposição.
     *
     * @param exposicaoEscolhida nova exposição escolhida.
     */
    public void setExposicao(Exposicao exposicaoEscolhida) {
        this.m_exposicaoEscolhida = exposicaoEscolhida;
    }

    /**
     * Guarda o registo de candidaturas.
     */
    public void getRegistoCandidaturas() {
        this.m_rc = m_exposicaoEscolhida.getRegistoCandidaturasAExposicao();
    }

    /**
     * Cria uma nova candidatura para uma exposição.
     *
     * @param expositor
     */
    public void criarCandidatura(Expositor expositor) {
        this.m_candidaturaCriada = m_rc.criarCandidatura(expositor);
    }

    /**
     * Mofica os dados de uma candidatura.
     *
     * @param nomeEmpresa nome da empresa
     * @param moradaEmpresa morada da empresa
     * @param telemovelEmpresa número de telemovel da empresa
     * @param area area necessária para a exposição
     * @param numConvites numero de convites pretendidos
     */
    public void setDados(String nomeEmpresa, String moradaEmpresa, String telemovelEmpresa, String area, String numConvites) throws TelemovelEmpresaErradoException, AreaErradaException, NumeroConvitesErradoException {
        this.m_candidaturaCriada.setNomeEmpresa(nomeEmpresa);
        this.m_candidaturaCriada.setMorada(area);
        this.m_candidaturaCriada.setTelemovel(telemovelEmpresa);
        this.m_candidaturaCriada.setArea(area);
        this.m_candidaturaCriada.setNumConvites(numConvites);
    }

    /**
     * Guarda o registo de produtos.
     */
    public void getRegistoProduto() {
        this.m_rp = m_candidaturaCriada.getRegistoProdutos();
    }

    /**
     * Adiciona um produto.
     *
     * @param nome nome do produto
     *
     * @return boolean que indica se foi ou não criado (true - foi criado)
     */
    public boolean addProduto(String nome) {
        Produto produtoCriado = this.m_rp.criarProduto(nome);
        boolean b = this.m_rp.adicionaProduto(produtoCriado);
        return b;
    }

    /**
     * Guarda o registo de demonstrações.
     */
    public void getRegistoDemonstracoes() {
        this.m_rd = m_exposicaoEscolhida.getRegistoDemonstracoes();
    }

    /**
     * Devolve a lista de demostrações.
     *
     * @return lista de demostrações.
     */
    public List<Demonstracao> getListaDemonstracoes() {
        return this.m_rd.getListaDemonstracoes();
    }

    /**
     * Adiciona a demostração escolhida.
     *
     * @param demonstracaoEscolhida demostração escolhida.
     */
    public void adicionaDemonstracao(Demonstracao demonstracaoEscolhida) {
        this.m_candidaturaCriada.getRegistoDemonstracoes().adicionaDemonstracao(demonstracaoEscolhida);
    }

    /**
     * Regista a candidatura.
     *
     * @return boolean que indica se foi ou não criada. (true - foi criada)
     */
    public boolean registaCandidatura() {
        boolean b = m_rc.registaCandidatura(this.m_candidaturaCriada);
        if (b) {
            setEstadoCandidaturaAExposicaoCriada();
        }
        return b;
    }

    /**
     * Modifica a lista de produtos.
     *
     * @param listaProdutos lista de produtos.
     */
    public void setListaProdutosCandidatura(List<Produto> listaProdutos) {
        this.m_candidaturaCriada.getRegistoProdutos().setListaProdutos(listaProdutos);
    }

    public void setListaDemonstracoesCandidatura(List<Demonstracao> listaDemonstracoes) {
        this.m_candidaturaCriada.getRegistoDemonstracoes().setListaDemonstracoes(listaDemonstracoes);
    }

    public void setEstadoCandidaturaAExposicaoCriada() {
        this.m_estadoCandidatura.setEstadoCandidaturaCriada();
    }

    public boolean validarDadosCandidatura() {
        return this.m_rc.validarDadosCandidatura(this.m_candidaturaCriada);
    }

    public void setKeywords(String keywords) throws KeywordsErradasException {
        this.m_candidaturaCriada.setKeywords(keywords);
    }

}
