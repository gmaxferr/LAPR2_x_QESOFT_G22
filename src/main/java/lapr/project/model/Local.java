package lapr.project.model;

/**
 * Representação de objectos do tipo Local
 *
 * @author Ricardo Osório Ana Leite
 */
public class Local {

    private String m_StrMorada;

    public Local(String nomeLocal) {
        this.m_StrMorada = nomeLocal;
    }

    /**
     *
     * @return
     */
    public String getM_StrMorada() {
        return m_StrMorada;
    }

    /**
     *
     * @param nomeLocal
     */
    public void setM_StrMorada(String nomeLocal) {
        this.m_StrMorada = nomeLocal;
    }

}
