package lapr.project.model;

/**
 *
 * @author Ricardo Catalão
 */
public class TipoConflito {

    /**
     * Mecanismo de deteção de conflitos.
     */
    private MecanismoDetecaoConflito m_mec;
    
    /**
     * Contrutor por definição.
     */
    public TipoConflito() {
        m_mec = new MecanismoDetecaoConflito(this);
    }
    
    /**
     * Define os dados para este tipo de conflitos.
     */
    public void setDadosTipoConflito() {
        throw new UnsupportedOperationException("Não sabemos que tipo de dados compõem um tipo de conflito.");
    }

    /**
     * @return Retorna o mecanismo de detação deste tipos de conflito
     */
    public MecanismoDetecaoConflito getMecanismoDetecaoConflito() {
        return m_mec;
    }
}
