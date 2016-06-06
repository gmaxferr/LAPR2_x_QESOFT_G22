package lapr.project.model;

/**
 *
 * @author Ricardo Osorio
 */
public class Avaliacao {

    private ratings ratings;
    private boolean avaliacao;
    private String justificacao;

    public Avaliacao() {

    }

    public boolean verificaAvaliacaoJaTomada() {
        if (!this.justificacao.isEmpty()) {
            return true;
        }
        return false;
    }
}
