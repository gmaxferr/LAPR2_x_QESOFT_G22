package lapr.project.model;

import java.io.Serializable;

/**
 * Representação de um contentor que guarda um fae e a decisão tomada por este
 * referente a uma única candidatura.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class FaeDecisao implements Serializable {

    /**
     * FAE
     */
    private FAE fae;

    /**
     * Avaliação do FAE
     */
    private Avaliacao avaliacao;

    /**
     * Construtor de objetos do tipo FaeDecisão recebendo como parametro o FAE.
     * A avaliação é inicializada automaticamente
     *
     * @param fae FAE
     */
    public FaeDecisao(FAE fae) {
        this.fae = fae;
        this.avaliacao = new Avaliacao();
    }

    /**
     * Devolve o FAE associado a este objecto
     *
     * @return FAE associado a este objecto
     */
    public FAE getFAE() {
        return this.fae;
    }

    /**
     * Fevolve a avaliação feita pelo FAE
     *
     * @return avaliação
     */
    public Avaliacao getAvalicao() {
        return this.avaliacao;
    }

}
