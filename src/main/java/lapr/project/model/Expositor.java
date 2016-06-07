package lapr.project.model;

/**
 * Representação de um Expositor
 *
 * @author Ricardo Osório Ana Leite
 */
public class Expositor {

    private Utilizador utilizador;

    /**
     * Construtor de objectos do tipo Expositor sem parametros
     */
    public Expositor(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve o username do expositor
     *
     * @return username do expositor
     */
    public String getM_strUsername() {
        return this.utilizador.getUsername();
    }
}
