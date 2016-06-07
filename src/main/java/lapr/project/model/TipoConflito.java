package lapr.project.model;

/**
 *
 * @author Ricardo Catalão
 */
public class TipoConflito {

    /**
     * Mecanismo de deteção de conflitos.
     */
    MecanismoDetecaoConflito mec;
    
    /**
     * Contrutor por definição.
     */
    public TipoConflito() {
        mec = new MecanismoDetecaoConflito();
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
        return mec;
    }
}
