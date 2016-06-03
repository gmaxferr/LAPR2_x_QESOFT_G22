package classesModelERegistoDeESOFT;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class Recurso {

    private String nomeRecurso;

    public Recurso(String nomeRecurso) {
        this.nomeRecurso = nomeRecurso;
    }

    /**
     * Devolve o nome do recurso
     *
     * @return nome do recurso
     */
    public String getNomeRecurso() {
        return nomeRecurso;
    }

    /**
     * Modifica o nome do recurso
     *
     * @param nomeRecurso novo nome do recurso
     */
    public void setNomeRecurso(String nomeRecurso) {
        this.nomeRecurso = nomeRecurso;
    }

}
