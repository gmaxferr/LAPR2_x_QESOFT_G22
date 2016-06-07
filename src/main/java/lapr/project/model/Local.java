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
    public String getMorada() {
        return m_StrMorada;
    }

    /**
     *
     * @param nomeLocal
     */
    public void setMorada(String nomeLocal) {
        this.m_StrMorada = nomeLocal;
    }

}
