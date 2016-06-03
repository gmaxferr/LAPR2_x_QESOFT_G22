package lapr.project.model;

/**
 * Representação de um Organizador
 *
 * @author Ricardo Osório Ana Leite
 */
public class Organizador {

    /**
     * Atributo utilizador de organizador
     */
    private Utilizador m_Utilizador;

    /**
     * Construtor de organizador sem parametros
     */
    public Organizador() {
    }

    /**
     * Devolve o utilizador de organizador
     *
     * @return utilizador de organizador
     */
    public Utilizador getUtilizador() {
        return m_Utilizador;
    }

    /**
     * Define novo utilizador de organizador
     *
     * @param u novo utilizador
     */
    public void setUtilizador(Utilizador u) {
        this.m_Utilizador = u;
    }

    /**
     * Devolve uma descrição textual do objeto Organizador, isto é, com os seus
     * atributos
     *
     * @return descrição textual do objeto Organizador
     */
    @Override
    public String toString() {
        String str = "Organizador:\n";
        str += "\tUser: " + this.m_Utilizador.getM_strNome() + "\n";

        return str;
    }
}
