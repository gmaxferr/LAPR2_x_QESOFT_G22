package lapr.project.model;

import java.io.Serializable;

/**
 * Representação de uma avaliação
 *
 * @author Ana Leite e Ricardo Osório
 */
public class Avaliacao implements Serializable {

    /**
     * Decisao da avaliação.
     */
    private boolean decisao;

    /**
     * Justificação da avaliação.
     */
    private String justificacao;

    /**
     * Construtor de objetos do tipo Avaliação sem parâmtros.
     */
    public Avaliacao() {
        this.justificacao = null;
    }

    /**
     * Devolve a decisão da avaliação.
     *
     * @return decisão da avaliação.
     */
    public boolean getDecisao() {
        return decisao;
    }

    /**
     * Devolve a justificação da avaliação.
     *
     * @return justificação da avaliação.
     */
    public String getJustificacao() {
        return justificacao;
    }

    /**
     * Modifica a decisão da avaliação.
     *
     * @param decisao nova decisão da avaliação.
     */
    public void setDecisao(boolean decisao) {
        this.decisao = decisao;
    }

    /**
     * Modifica a justificação da avaliação.
     *
     * @param justificacao nova justificação da avaliação.
     */
    public void setJustificacao(String justificacao) {
        this.justificacao = justificacao;
    }

}
