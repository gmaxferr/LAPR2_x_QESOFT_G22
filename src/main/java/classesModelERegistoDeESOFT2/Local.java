package classesModelERegistoDeESOFT;

/**
 * Representação de objectos do tipo Local
 *
 * @author Ricardo Osório Ana Leite
 */
public class Local {

    private String nomeLocal;

    public Local(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    /**
     *
     * @return
     */
    public String getNomeLocal() {
        return nomeLocal;
    }

    /**
     *
     * @param nomeLocal
     */
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

}
