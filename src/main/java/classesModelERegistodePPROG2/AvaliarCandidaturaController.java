package classesModelERegistodePPROG;

import java.util.List;
import lapr.project.model.*;

/**
 * Representação do Controller do caso de uso - decidir candidatura.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class AvaliarCandidaturaController {

    /**
     * Registo de atribuições.
     */
    private RegistoAtribuicoes ra;

    /**
     * Registo de exposições.
     */
    private RegistoExposicoes re;

    /**
     * Exposição escolhida.
     */
    private Exposicao exposicaoEscolhida;

    /**
     * Candidatura escolhida.
     */
    private Candidatura candidaturaEscolhida;

    /**
     * Centro de exposições.
     */
    private CentroExposicoes centroExposicoes;

    /**
     * Constrói uma instância de DecidirCandidaturaController recebendo como
     * parâmetro o centro de exposições.
     *
     * @param centroExposicoes centro de exposições.
     */
    public AvaliarCandidaturaController(CentroExposicoes centroExposicoes) {
        this.centroExposicoes = centroExposicoes;
        
    }

    /**
     * Guarda o registo de atribuições.
     */
    public void getRegistoAtribuicoes() {
        this.ra = exposicaoEscolhida.getRegistoAtribuicoes();
    }

    /**
     * Guarda o registo de exposições.
     */
    public void getRegistoExposicoes() {
        this.re = centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista de candidaturas do fae.
     *
     * @param usernameFAE username do fae.
     * @return lista de candidaturas do fae.
     */
    public List<Atribuicao> getListaAtribuicoes(String usernameFAE) {
        return this.ra.getListaAtribuicoesDoFAE(usernameFAE);
    }

    /**
     * Modifica a candidatura.
     *
     * @param candidaturaEscolhida nova candidatura escolhida.
     */
    public void setCandidatura(Candidatura candidaturaEscolhida) {
        this.candidaturaEscolhida = candidaturaEscolhida;
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
     * Devolve a lista de exposições do fae.
     *
     * @param usernameFAE username do fae.
     * @return lisat de exposições do fae.
     */
    public List<Exposicao> getListaExposicoesDoFAE(String usernameFAE) {
        return this.re.getListaExposicoesDoFAE(usernameFAE);
    }

    /**
     * Modifica a decisão da avaliação.
     *
     * @param decisao decisão da avaliação.
     * @param justificacao justificação da avaliação.
     */
    public void setDecisao(boolean decisao, String justificacao) {
        ra.setDecisao(decisao, justificacao);
    }

    /**
     * Valida a decisão.
     */
    public void valida() {
        ra.valida();
    }

    /**
     * Devolve a avaliação do fae.
     *
     * @param atribuicaoEscolhida atribuição escolhida.
     * @param usernameFAE username do fae.
     * @return avaliação do fae.
     */
    public Avaliacao getReferenciaAvaliacaoDesteFAE(Atribuicao atribuicaoEscolhida, String usernameFAE) {
        for (FaeDecisao faeDecisao : atribuicaoEscolhida.getRegistoFaeDecisao().getListaFaeDecisao()) {
            if (faeDecisao.getFAE().getUsername().equalsIgnoreCase(usernameFAE)) {
                return faeDecisao.getAvalicao();
            }
        }
        return null;
    }

}
