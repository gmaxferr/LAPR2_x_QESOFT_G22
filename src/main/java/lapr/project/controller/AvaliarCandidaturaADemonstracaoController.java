package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.Avaliacao;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoAtribuicoes;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoFaeAvaliacao;

/**
 * Representação do Controller do caso de uso - avaliar candidatura a demonstração
 * 
 * @author Ana Leite
 */
public class AvaliarCandidaturaADemonstracaoController {

    /**
     * Centro de exposições
     */
    private CentroExposicoes m_centroExposicoes;
    
    /**
     * Registo de demonstrações
     */
    private RegistoDemonstracoes m_rd;
    
    /**
     * Exposição
     */
    private Exposicao m_exposicao;
    
    /**
     * Demonstração selecionada
     */
    private Demonstracao m_demonstracaoSelecionada;
    
    /**
     * Registo de atribuições
     */
    private RegistoAtribuicoes m_ra;
    
    /**
     * Atribuição escolhida
     */
    private AtribuicaoCandidatura m_atribuicaoEscolhida;
    
    /**
     * Avaliação do fae
     */
    private Avaliacao m_avaliacaoDoFae;
    
    /**
     * Registo FAEAvaliação
     */
    private RegistoFaeAvaliacao m_rFaeAvalicao;
    
    /**
     * Candidatura a demonstração
     */
    private CandidaturaADemonstracao m_cand;
    
     /**
     * Estado candidatura a demonstração
     */
    private EstadoCandidaturaADemonstracao m_estadoCandidatura;
    
     /**
     * Estado Demonstração
     */
    private EstadoDemonstracao m_estadoDemonstracao;
 
    /**
     * Constrói uma instância de AvaliarCandidaturaADemonstracaoController 
     * recebendo como parâmetro o centro de exposições
     * 
     * @param centroExposicoes centro de exposições
     */
    public AvaliarCandidaturaADemonstracaoController(CentroExposicoes centroExposicoes){
        this.m_centroExposicoes = centroExposicoes;
    }
    
    /**
     * Guarda o registo de demonstrações
     */
    public void getRegistoDemonstracoes(){
        this.m_rd = this.m_exposicao.getRegistoDemonstracoes();
    }
    
    /**
     * Devolve a lista de demonstrações de um fae
     * 
     * @param usernameFAE username de um fae
     * @return lista de demonstrações de um fae
     */
    public List<Demonstracao> getListaDemonstracoesEstadoCandidaturaAtribuidaDoFae(String usernameFAE){
        return m_rd.getListaDemonstracoesEstadoCandidaturaAtribuidaDoFae(usernameFAE);
    }
    
    /**
     * Modifica a demonstração
     * 
     * @param demonstracao demonstração escolhida
     */
    public void setDemonstracao(Demonstracao demonstracao){
        this.m_demonstracaoSelecionada = demonstracao;
    }
    
    /**
     * Guarda o registo de atribuições
     */
    public void getRegistoAtribuicoes() {
        this.m_ra = this.m_exposicao.getRegistoAtribuicoes();
    }

    /**
     * Devolve as candidaturas atribuídas a um fae
     * 
     * @param usernameFAE username do fae
     * @return candidaturas atribuídas a um fae
     */
    public ArrayList<AtribuicaoCandidatura> getListaAtribuicoesDoAE(String usernameFAE) {
        return this.m_ra.getListaAtribuicoesDoFAE(usernameFAE);
    }
    
    /**
     * Guarda o registo FAEAvaliação
     */
    public void getRegistoFaeAvalicao() {
        this.m_rFaeAvalicao = this.m_atribuicaoEscolhida.getRegistoFaeAvaliacao();
    }

    /**
     * Modifica a atribuição
     * 
     * @param atribuicao atribuição escolhida
     */
    public void setAtribuicao(AtribuicaoCandidatura atribuicao) {
        this.m_atribuicaoEscolhida = atribuicao;
    }
    
    /**
     * Devolve os dados da candidatura
     * 
     * @return dados da candidatura
     */
    public String getDadosCandidatura(){
        return m_cand.getDadosCandidatura();
    }
    
    /**
     * Devolve a avaliação de um fae
     * 
     * @param usernameFAE username do fae
     * @return avaliação de um fae
     */
    public Avaliacao getAvaliacaoDoFae(String usernameFAE) {
        this.m_avaliacaoDoFae = this.m_atribuicaoEscolhida.getRegistoFaeAvaliacao().getAvaliacaoDoFae(usernameFAE);
        return this.m_avaliacaoDoFae;
    }

    /**
     * Verifica se a avalição já foi tomada
     * 
     * @return true se a avaliação foi tomada. Caso contrário retorna false.
     */
    public boolean verificaAvalicaoJaTomada() {
        return this.m_avaliacaoDoFae.verificaAvaliacaoJaTomada();
    }

    /**
     * Devolve a avaliação do fae
     * 
     * @return avaliação do fae
     */
    public boolean getAvaliacao() {
        return this.m_avaliacaoDoFae.getAvaliacao();
    }

    /**
     * Devolve a justificação do fae
     * 
     * @return justificação do fae
     */
    public String getJustificacao() {
        return this.m_avaliacaoDoFae.getJustificacao();
    }
    
    /**
     * Modifica a avaliação e a justificação
     * 
     * @param avaliacao avaliação
     * @param justificacao justificação
     */
    public void setAvalicaoParaDemonstracao(boolean avaliacao, String justificacao){
        this.m_avaliacaoDoFae.setAvalicaoParaDemonstracao(avaliacao, justificacao);
    }
    /**
     * Atualiza o estado da candidatura e da demonstração atualmente selecionadas
     * pelo FAE na UI para os estados CandidaturasAvaliadas
     */
    public void setEstadoCandiaturaAvaliada(){
        this.m_estadoCandidatura = this.m_cand.getEstado();
        m_estadoCandidatura.setEstadoCandidaturaADemonstracaoAvaliada();
        
        this.m_estadoDemonstracao = this.m_demonstracaoSelecionada.getEstadoDemo();
        m_estadoDemonstracao.setEstadoDemonstracaoCandidaturasAvaliadas();
    }
}
