package lapr.project.controller;

import lapr.project.excecoes.AreaErradaException;
import lapr.project.excecoes.NumeroConvitesErradoException;
import lapr.project.excecoes.TelemovelEmpresaErradoException;
import java.util.List;
import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Produto;
import lapr.project.model.RegistoCandidaturas;
import lapr.project.model.RegistoDemonstracoes;
import lapr.project.model.RegistoExposicoes;
import lapr.project.model.RegistoProdutos;

/**
 * Representação do Controller do caso de uso - criar candidatura.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class CriarCandidaturaController {

    /**
     * Registo de exposições.
     */
    private RegistoExposicoes re;

    /**
     * Registo de candidaturas.
     */
    private RegistoCandidaturas rc;

    /**
     * Registo de produtos.
     */
    private RegistoProdutos rp;

    /**
     * Registo de demonstrações.
     */
    private RegistoDemonstracoes rd;

     /**
     * Exposição escolhida.
     */
    private Exposicao exposicaoEscolhida;

    /**
     * Candidatura criada.
     */
    private Candidatura candidaturaCriada;
    
    /**
     * Centro de exposições.
     */
    private CentroExposicoes centroExposicoes;

    /**
     * Constrói uma instância de CriarCandidaturaController recebendo como
     * parâmetro o centro de exposições.
     *
     * @param centroExposicoes centro de exposições
     */
    public CriarCandidaturaController(CentroExposicoes centroExposicoes) {
        this.centroExposicoes = centroExposicoes;
    }

    /**
     * Guarda o registo de exposições.
     */
    public void getRegistoExposicoes() {
        this.re = centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista de Exposições.
     *
     * @return lista de Exposições
     */
    public List<Exposicao> getListaExposicoes() {
        return this.re.getListaExposicoes();
    }

    /**
     * Modifica a exposição.
     *
     * @param exposicaoEscolhida nova exposição escolhida.
     */
    public void setExposicao(Exposicao exposicaoEscolhida) {
        this.exposicaoEscolhida = exposicaoEscolhida;
    }

    /**
     * Guarda o registo de candidaturas.
     */
    public void getRegistoCandidaturas() {
        this.rc = exposicaoEscolhida.getRegistoCandidaturas();
    }

    /**
     * Cria uma nova candidatura para uma exposição.
     * 
     * @param usernameExpositor username do expositor da candidatura.
     */
    public void criarCandidatura(String usernameExpositor) {
        this.candidaturaCriada = rc.criarCandidatura(usernameExpositor);
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
        this.candidaturaCriada.setNomeEmpresa(nomeEmpresa);
        this.candidaturaCriada.setMoradaEmpresa(moradaEmpresa);
        this.candidaturaCriada.setTelemovelEmpresa(telemovelEmpresa);
        this.candidaturaCriada.setArea(area);
        this.candidaturaCriada.setNumConvites(numConvites);
    }

    /**
     * Guarda o registo de produtos.
     */
    public void getRegistoProduto() {
        this.rp = candidaturaCriada.getRegistoProdutos();
    }

    /**
     * Adiciona um produto.
     *
     * @param nome nome do produto
     * 
     * @return boolean que indica se foi ou não criado (true - foi criado)
     */
    public boolean addProduto(String nome) {
        Produto produtoCriado = this.rp.criarProduto(nome);
        boolean b = this.rp.adicionaProduto(produtoCriado);
        return b;
    }

    /**
     * Guarda o registo de demonstrações.
     */
    public void getRegistoDemonstracoes() {
        this.rd = exposicaoEscolhida.getRegistoDemonstracoes();
    }

    /**
     * Devolve a lista de demostrações.
     *
     * @return lista de demostrações.
     */
    public List<Demonstracao> getListaDemonstracoes() {
        return this.rd.getListaDemonstracoes();
    }

    /**
     * Adiciona a demostração escolhida.
     *
     * @param demonstracaoEscolhida demostração escolhida.
     */
    public void adicionarDemonstracao(Demonstracao demonstracaoEscolhida) {
        this.candidaturaCriada.getRegistoDemonstracoes().adicionarDemonstracao(demonstracaoEscolhida);
    }

    /**
     * Regista a candidatura.
     * 
     * @return boolean que indica se foi ou não criada. (true - foi criada)
     */
    public boolean registaCandidatura() {
        boolean b = rc.registaCandidatura(this.candidaturaCriada);
        return b;
    }

    /**
     * Remove uma demonstração.
     * 
     * @param selectedValue identificação da demonstração.
     */
    public void removerDemonstracao(Object selectedValue) {
        String demoIdentificacao = (String) selectedValue;
        this.candidaturaCriada.getRegistoDemonstracoes().removerDemonstracao(demoIdentificacao);
    }

    /**
     * Atualiza as demonstrações da candidatura criada.
     * 
     * @param listaDemonstracoesAdicionadas lista de demonstrações adicionadas à candidatura.
     */
    public void atualizarListaDemonstracoesCandidatura(List<Demonstracao> listaDemonstracoesAdicionadas) {
        this.candidaturaCriada.getRegistoDemonstracoes().setListaDemonstracoes(listaDemonstracoesAdicionadas);
    }

    /**
     * Modifica a lista de produtos.
     * 
     * @param listaProdutos lista de produtos.
     */
    public void setListaProdutosCandidatura(List<Produto> listaProdutos) {
        this.candidaturaCriada.getRegistoProdutos().setListaProdutos(listaProdutos);
    }

}
