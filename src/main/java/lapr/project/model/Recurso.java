package lapr.project.model;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class Recurso {

    private String m_nomeRecurso;

    public Recurso(String nomeRecurso) {
        this.m_nomeRecurso = nomeRecurso;
    }

    /**
     * Devolve o nome do recurso
     *
     * @return nome do recurso
     */
    public String getNomeRecurso() {
        return m_nomeRecurso;
    }

    /**
     * Modifica o nome do recurso
     *
     * @param nomeRecurso novo nome do recurso
     */
    public void setNomeRecurso(String nomeRecurso) {
        this.m_nomeRecurso = nomeRecurso;
    }

}
