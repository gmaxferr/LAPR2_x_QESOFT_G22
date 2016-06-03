package lapr.project.model;

/**
 * Representação de uma Decisão
 *
 * @author Ana Leite Ricardo Osório
 */
public class Decisao {

    private boolean decisao;

    /**
     * Construtor de objectos do tipo Decisao com o parametro FAE
     *
     */
    public Decisao() {
    }

    /**
     * Construtor de objectos do tipo Utilizador com todos os parametros
     *
     * @param decisao
     */
    public Decisao(boolean decisao) {
        this.decisao = decisao;
    }

    public void setM_bDecisao(boolean decisao) {
        this.decisao = decisao;
    }
}
