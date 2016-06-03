package lapr.project.controller;

import java.util.List;
import lapr.project.exceptions.AreaErradaException;
import lapr.project.exceptions.NumeroConvitesErradoException;
import lapr.project.exceptions.TelemovelEmpresaErradoException;
import lapr.project.model.*;
import lapr.project.registos.RegistoCandidaturas;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoProdutos;

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
    private CandidaturaAExposicao candidaturaCriada;

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
        return this.re.getlistaExposicoesValidas();
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
     * @param expositor
     */
    public void criarCandidatura(Expositor expositor) {
        this.candidaturaCriada = rc.criarCandidatura(expositor);
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
        this.candidaturaCriada.setM_strNomeEmpresa(nomeEmpresa);
        this.candidaturaCriada.setM_strMorada(area);
        this.candidaturaCriada.setM_intTelemovel(telemovelEmpresa);
        this.candidaturaCriada.setM_intArea(area);
        this.candidaturaCriada.setM_intNumConvites(numConvites);
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
        this.candidaturaCriada.getRegistoDemonstracoes().adicionaDemonstracao(demonstracaoEscolhida);
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
     * Modifica a lista de produtos.
     *
     * @param listaProdutos lista de produtos.
     */
    public void setListaProdutosCandidatura(List<Produto> listaProdutos) {
        this.candidaturaCriada.getRegistoProdutos().setListaProdutos(listaProdutos);
    }

}
