package lapr.project.model;

/**
 * Representação de uma Decisão
 *
 * @author Ana Leite Ricardo Osório
 */
public class Decisao {

    private boolean m_decisao;

    /**
     * Construtor
     *
     */
    public Decisao() {
        this.m_decisao = false;
    }

    /**
     * Construtor
     *
     * @param decisao
     */
    public Decisao(boolean decisao) {
        this.m_decisao = decisao;
    }

    public void setM_bDecisao(boolean decisao) {
        this.m_decisao = decisao;
    }

    public boolean getM_bDecisao() {
        return this.m_decisao;
    }
}
