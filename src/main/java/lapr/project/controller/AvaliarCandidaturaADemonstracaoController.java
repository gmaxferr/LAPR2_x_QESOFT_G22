package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - avaliar candidatura a
 * demonstração
 *
 * @author G29
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
    private RegistoAtribuicoesCandidaturasDemonstracao m_ra;
    
    /**
     * Registo de exposições
     */
    private RegistoExposicoes m_re;

    /**
     * Atribuição escolhida
     */
    private AtribuicaoCandidaturaDemonstracao m_atribuicaoEscolhida;

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
    public AvaliarCandidaturaADemonstracaoController(CentroExposicoes centroExposicoes) {
        this.m_centroExposicoes = centroExposicoes;
    }

    /**
     * Guarda o registo de exposições associado ao centro de exposições atual
     */
    public void getRegistoExposicoes(){
        this.m_re = m_centroExposicoes.getRegistoExposicoes();
    }
    
    /**
     * Devolve a lista de exposições que estejam no estado
     * candidaturasAtribuidas e que o utilizador detenha o cargo de FAE sobre
     * estas
     *
     * @return lista de exposições válidas sobre as quais se pode executar este
     * UC
     */
    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(String usernameFAE) {
        return this.m_re.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(usernameFAE);
    }
    
     /**
     * Modifica a exposição
     *
     * @param exposicao exposição selecionada
     */
    public void setExposicao(Exposicao exposicao) {
        this.m_exposicao = exposicao;
    }
    
    /**
     * Guarda o registo de demonstrações
     */
    public void getRegistoDemonstracoes() {
        this.m_rd = this.m_exposicao.getRegistoDemonstracoes();
    }

    /**
     * Devolve a lista de demonstrações de um fae
     *
     * @param usernameFAE username de um fae
     * @return lista de demonstrações de um fae
     */
    public List<Demonstracao> getListaDemonstracoesEstadoCandidaturasAtribuidas(String usernameFAE) {
        for (FAE fae : m_exposicao.getRegistoFAE().getListaFAE()) {
            if (fae.getUsernameFae().equalsIgnoreCase(usernameFAE)) {
                return m_rd.getListaDemonstracoesEstadoCandidaturasAtribuidas();
            }
        }
        return new ArrayList<>();
    }

    /**
     * Modifica a demonstração
     *
     * @param demonstracao demonstração escolhida
     */
    public void setDemonstracao(Demonstracao demonstracao) {
        this.m_demonstracaoSelecionada = demonstracao;
    }

    /**
     * Guarda o registo de atribuições
     */
    public void getRegistoAtribuicoes() {
        this.m_ra = this.m_exposicao.getRegistoAtribuicoesDemonstracao();
    }

    /**
     * Devolve as candidaturas atribuídas a um fae
     *
     * @param usernameFAE username do fae
     * @return candidaturas atribuídas a um fae
     */
    public ArrayList<AtribuicaoCandidaturaDemonstracao> getListaAtribuicoesDoFAE(String usernameFAE) {
        return this.m_ra.getListaAtribuicoesDoFAEEstadoAtribuidas(usernameFAE);
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
    public void setAtribuicao(AtribuicaoCandidaturaDemonstracao atribuicao) {
        this.m_atribuicaoEscolhida = atribuicao;
    }

    /**
     * Devolve os dados da candidatura
     *
     * @return dados da candidatura
     */
    public String getDadosCandidatura() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getDadosCandidatura();
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
     * Define novos parametros a serem guardados no objecto Avaliação deste FAE
     * sobre a candidatura escolhida 
     * 
     * @param ratingConhecimentoSobreTema inteiro de 0-5 que representa o
     * conhecimento do FAE sobre o tema da candidatura/demonstração
     * @param ratingAdequacaoDadosCandidatura inteiro de 0-5 que representa a 
     * adequação dos dados da candidatura
     * @param ratingRecomendacaoGlobal inteiro de 0-5 que representa a
     * recomendação do FAE para a candidatura
     */
    public void setAvaliacao(int ratingConhecimentoSobreTema,int ratingAdequacaoDadosCandidatura, int ratingRecomendacaoGlobal ){
        this.m_avaliacaoDoFae.setAvaliacaoCandidaturaADemonstracao(ratingConhecimentoSobreTema, ratingAdequacaoDadosCandidatura, ratingRecomendacaoGlobal);
    }
    
    /**
     * Atualiza o estado da candidatura e da demonstração atualmente
     * selecionadas pelo FAE na UI para os estados CandidaturasAvaliadas
     */
    public void setEstadoCandiaturaAvaliada() {
        this.m_estadoCandidatura = this.m_cand.getEstado();
        m_estadoCandidatura.setEstadoCandidaturaADemonstracaoAvaliada();

        this.m_estadoDemonstracao = this.m_demonstracaoSelecionada.getEstadoDemo();
        m_estadoDemonstracao.setEstadoDemonstracaoCandidaturasAvaliadas();
    }
}
