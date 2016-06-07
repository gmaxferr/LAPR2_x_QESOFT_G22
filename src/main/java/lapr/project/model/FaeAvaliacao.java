package lapr.project.model;

/**
 *
 * @author Ricardo Osorio
 */
public class FaeAvaliacao {

    private FAE m_FaeAssociado;
    private Avaliacao m_avaliacao;

    public FaeAvaliacao() {
        this.m_avaliacao = new Avaliacao();
    }

    public FaeAvaliacao(FAE fae) {
        this.m_FaeAssociado=fae;
    }

    public FAE getFaeAssociado() {
        return this.m_FaeAssociado;
    }

    public Avaliacao getAvaliacao() {
        return this.m_avaliacao;
    }
}
