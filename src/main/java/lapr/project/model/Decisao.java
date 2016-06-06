package lapr.project.model;

/**
 * Representação de uma Decisão
 *
 * @author Ana Leite Ricardo Osório
 */
public class Decisao {

    private boolean decisao;

    /**
     * Construtor
     *
     */
    public Decisao() {
        this.decisao = false;
    }

    /**
     * Construtor
     *
     * @param decisao
     */
    public Decisao(boolean decisao) {
        this.decisao = decisao;
    }

    public void setM_bDecisao(boolean decisao) {
        this.decisao = decisao;
    }

    public boolean getM_bDecisao() {
        return this.decisao;
    }
}
