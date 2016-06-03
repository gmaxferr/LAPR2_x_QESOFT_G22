package lapr.project.model;

/**
 * Representação de uma Decisão
 *
 * @author Ana Leite Ricardo Osório
 */
public class Decisao {

    /**
     * Atributo fae associado
     */
    private FAE m_faeFAEAssociado;

    /**
     * Atributo decisao;
     */
    private String m_strDecisao;

    /**
     * Atributo justificação
     */
    private String m_strJustificacao;

    /**
     * Construtor de objectos do tipo Decisao com o parametro FAE
     *
     * @param fae fae associado à decisao
     */
    public Decisao(FAE fae) {
        this.m_faeFAEAssociado = fae;
    }

    /**
     * Construtor de objectos do tipo Utilizador com todos os parametros
     *
     * @param decisao decisao feita pelo fae
     * @param justificacao justificação feita pelo fae
     * @param fae fae que faz a decisao e a justificacao
     */
    public Decisao(String decisao, String justificacao, FAE fae) {
        this.m_strDecisao = decisao;
        this.m_strJustificacao = justificacao;
        this.m_faeFAEAssociado = fae;
    }

    /**
     * Devolve o atributo fae associado de decisão
     *
     * @return fae associado
     */
    public FAE getM_faeFAEAssociado() {
        return m_faeFAEAssociado;
    }

    /**
     * Devolve o atributo decisão de decisão
     *
     * @return decisao
     */
    public String getM_strDecisao() {
        return m_strDecisao;
    }

    /**
     * Devolve o atributo justificação de decisão
     *
     * @return justificacao
     */
    public String getM_strJustificacao() {
        return m_strJustificacao;
    }

    /**
     * Define um novo fae associado de decisao
     *
     * @param m_faeFAEAssociado novo fae associado
     */
    public void setM_faeFAEAssociado(FAE m_faeFAEAssociado) {
        this.m_faeFAEAssociado = m_faeFAEAssociado;
    }

    /**
     * Define uma nova decisão de decisão
     *
     * @param m_strDecisao nova decisão
     */
    public void setM_strDecisao(String m_strDecisao) {
        this.m_strDecisao = m_strDecisao;
    }

    /**
     * Define uma nova justificação de decisão
     *
     * @param m_strJustificacao nova justificação
     */
    public void setM_strJustificacao(String m_strJustificacao) {
        this.m_strJustificacao = m_strJustificacao;
    }
}
