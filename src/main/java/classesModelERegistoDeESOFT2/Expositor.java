package classesModelERegistoDeESOFT;

/**
 * Representação de um Expositor
 *
 * @author Ricardo Osório Ana Leite
 */
public class Expositor {

    private String m_strNomeEmpresa;
    private String m_strMorada;

    /**
     * Construtor de objectos do tipo Expositor sem parametros
     */
    public Expositor() {
    }

    /**
     * Construtor de objectos do tipo Expositor com parametros
     *
     * @param nomeEmpresa nome da empresa
     * @param morada morada da empresa
     */
    public Expositor(String nomeEmpresa, String morada) {
        this.m_strNomeEmpresa = nomeEmpresa;
        this.m_strMorada = morada;
    }

    /**
     * Devolve o nome da empresa do expositor
     *
     * @return nome da empresa
     */
    public String getM_strNomeEmpresa() {
        return m_strNomeEmpresa;
    }

    /**
     * Devolve a morada da empresa do expositor
     *
     * @return morada da empresa
     */
    public String getM_strMorada() {
        return m_strMorada;
    }

    /**
     * Define um novo nome para a empresa do expositor
     *
     * @param m_strNomeEmpresa novo nome da empresa
     */
    public void setM_strNomeEmpresa(String m_strNomeEmpresa) {
        this.m_strNomeEmpresa = m_strNomeEmpresa;
    }

    /**
     * Define uma nova morada para a empresa do expositor
     *
     * @param m_strMorada nova morada da empresa
     */
    public void setM_strMorada(String m_strMorada) {
        this.m_strMorada = m_strMorada;
    }

    /**
     * Devolve uma descrisão do Expositor. Isto é, dos seus atributo que o
     * caracterizam.
     *
     * @return descrição do expositor
     */
    public String toString() {
        String str = "Expositor:\n";
        str += "\tNome da Empresa: " + this.m_strNomeEmpresa + "\n";
        str += "\tMorada " + this.m_strMorada + "\n";

        return str;
    }
}
