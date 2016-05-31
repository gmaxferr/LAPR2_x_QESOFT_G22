package lapr.project.model;

import java.io.Serializable;

/**
 * Representação de uma atribuição
 *
 * @author Ana Leite e Ricardo Osório
 */
public class Atribuicao implements Serializable {

    /**
     * Registo de FaeDecisão da atribuição.
     */
    private RegistoFaeDecisao registoFaeDecisao;

    /**
     * Candidatura da atribuição.
     */
    private Candidatura cand;

    /**
     * Construtor de objectos do tipo Atribuição sem parâmetros.
     */
    public Atribuicao() {
        this.registoFaeDecisao = new RegistoFaeDecisao();
    }

    /**
     * Devolve a candidatura da atribuição.
     *
     * @return candidatura da atribuição.
     */
    public Candidatura getCand() {
        return cand;
    }

    /**
     * Devolve o registo de FaeDecisão da atribuição.
     *
     * @return registo de FaeDecisão da atribuição.
     */
    public RegistoFaeDecisao getRegistoFaeDecisao() {
        return this.registoFaeDecisao;
    }

    /**
     * Modifica a candidatura da atribuição.
     *
     * @param cand nova candidatura da atribuição.
     */
    public void setCandidatura(Candidatura cand) {
        this.cand = cand;
    }

    /**
     * Adiciona um fae ao registo de FaeDecisão da atribuição.
     *
     * @param fae fae adicionado ao registo de FaeDecisao da atribuição.
     */
    public void addFAE(FAE fae) {
        this.registoFaeDecisao.addFaeDecisao(fae);
    }

}
