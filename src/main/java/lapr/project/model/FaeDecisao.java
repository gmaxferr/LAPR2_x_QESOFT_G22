package lapr.project.model;

/**
 *
 * @author Ricardo Osorio
 */
public class FaeDecisao {

    private FAE FaeAssociado;
    private Avaliacao avaliacao;

    public FaeDecisao() {
        this.avaliacao = new Avaliacao();
    }

    public FaeDecisao(FAE fae) {
        this.FaeAssociado=fae;
    }

    public FAE getFaeAssociado() {
        return this.FaeAssociado;
    }

    public Avaliacao getAvaliacao() {
        return this.avaliacao;
    }
}
