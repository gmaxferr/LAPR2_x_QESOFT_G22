package lapr.project.model;

/**
 *
 * @author Ricardo Osorio
 */
public class FaeAvaliacao {

    private FAE FaeAssociado;
    private Avaliacao avaliacao;

    public FaeAvaliacao() {
        this.avaliacao = new Avaliacao();
    }

    public FaeAvaliacao(FAE fae) {
        this.FaeAssociado=fae;
    }

    public FAE getFaeAssociado() {
        return this.FaeAssociado;
    }

    public Avaliacao getAvaliacao() {
        return this.avaliacao;
    }
}
