package lapr.project.model;

/**
 * Representação de um Expositor
 *
 * @author Ricardo Osório Ana Leite
 */
public class Expositor {

    private Utilizador m_utilizador;

    /**
     * Construtor de objectos do tipo Expositor sem parametros
     */
    public Expositor(Utilizador utilizador) {
        this.m_utilizador = utilizador;
    }

    /**
     * Devolve o username do expositor
     *
     * @return username do expositor
     */
    public String getM_strEmail() {
        return this.m_utilizador.getEmail();
    }
}
