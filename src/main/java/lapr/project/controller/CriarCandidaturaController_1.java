package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.registos.RegistoCandidaturas;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoProdutos;

/**
 * Representação do Controller do caso de uso - criar candidatura
 *
 * @author Ana Leite Ricardo Osório
 */
public class CriarCandidaturaController_1 {

    //Este programa nao tem implementação suficiente para interagir com o utilizador. Estes parametros foram assumidos para nao criar erros de compilação do java
    private final CentroExposicoes m_centro_exposicoes;

    private final RegistoExposicoes m_re;

    private final RegistoCandidaturas m_rc;

    private final RegistoProdutos m_rp;

    private final RegistoDemonstracoes m_rd;

    Exposicao expo1 = new Exposicao();
    Expositor expositor = new Expositor();

    Exposicao exposiçãoSelecionada;
    Candidatura c;
    Expositor ex;
    Exposicao exposicao;
    private EstadoExposicao estadoExpo;

    public static Exposicao e;
    public static ArrayList<Exposicao> listExpo = new ArrayList<>();
    public static ArrayList<Demonstracao> listDemonst = new ArrayList<>();

    public CriarCandidaturaController_1(CentroExposicoes centro_exposicoes, RegistoExposicoes registoExposicoes, RegistoCandidaturas registoCandidaturas, RegistoProdutos registoProdutos, RegistoDemonstracoes registoDemostracoes) {
        m_centro_exposicoes = centro_exposicoes;
        m_re = registoExposicoes;
        m_rc = registoCandidaturas;
        m_rp = registoProdutos;
        m_rd = registoDemostracoes;
    }

    public boolean getEstadoExposicao(){
        estadoExpo = exposicao.getEstadoExposicao();
        return verificaEstado(estadoExpo);
    }
    
    public boolean verificaEstado(EstadoExposicao estado){
        //Verifica se o estado permite executar este UC
        return true;
    }
    
    public void getRegistoExposicoes() {
        m_centro_exposicoes.getRegistoExposicoes();
    }

    public void getRegistoCandidaturas() {
        e.getRegistoCandidaturas();
    }

    public void getRegistoProdutos() {
        c.getRp();
    }

    public void getRegistoDemostracoes() {
        e.getRd();
    }

    /**
     * Devolve a lista de Exposições
     *
     * @return lista de Exposições
     */
    public ArrayList<Exposicao> getlistaExposicoesValidas() {
        listExpo = m_re.getlistaExposicoesValidas();
        return listExpo;
    }

    /**
     * Método que guarda a exposição escolhida pelo utilizador
     *
     * @param exposicao exposição escolhida
     */
    public void setExposicao(Exposicao exposicao) {
        e = exposicao;
    }

    /**
     * Método que cria uma nova candidatura chamando o método criarCandidatura
     * da exposição selecionada
     *
     * @param e exposição selcionada
     *
     * @return nova candidatura
     */
    public Candidatura criarCandidatura(Exposicao e) {
        Candidatura c = m_rc.criarCandidatura();
        return c;
    }

    /**
     * Chama o método validarDadosCandidatura
     *
     * @param c candidatura a ser validada
     */
    public void validarDadosCandidatura(Candidatura c) {
        m_rc.validarDadosCandidatura(c);
    }

    /**
     * Método que apresenta os dados da candidatura
     *
     * @param nomeEmpresa nome da empresa da candidatura
     * @param morada morada da candidatura
     * @param telemovel numero de telemovel da candidatura
     * @param area area pretendida da candidatura
     * @param produtosExpor produtos a expor da candidatura
     * @param numConvites nuemero de convites da candidatura
     */
    public void setDados(String nomeEmpresa, String morada, int telemovel, float area, Produto produtosExpor, int numConvites) {
        c.setM_strNomeEmpresa(nomeEmpresa);
        c.setM_strMorada(morada);
        c.setM_intTelemovel(telemovel);
        c.setM_intArea(area);
        c.setM_intNumConvites(numConvites);
        c.validarCandidatura();
    }

    /**
     * Método que adiciona um novo produto à candidatura
     *
     * @param nomeProduto
     */
    public void addProduto(String nomeProduto) {
        Produto produto = m_rp.criarProduto(nomeProduto);
        m_rp.adicionaProduto(produto);
    }

    /**
     * Devolve a lista de Exposições
     *
     * @return lista de Exposições
     */
    public ArrayList<Demonstracao> getlistaDemostracoes() {
        listDemonst = m_rd.getlistaDemonstracoes();
        return listDemonst;
    }

    public void adicionaDemontracao(Demonstracao demonstracao) {
        m_rd.adicionaDemostracao(demonstracao);
    }

    /**
     * Método que regista a nova candidatura associada a uma exposição
     *
     * @param c candidatura a ser registada
     */
    public void registaCandidatura(Candidatura c) {
        m_rc.registaCandidatura(c);
    }
}
