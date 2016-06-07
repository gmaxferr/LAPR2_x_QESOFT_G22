package lapr.project.model;

/**
 *
 * @author osori
 */
public class ConflitoDeInteresse {

    private FAE m_fae;
    private CandidaturaAExposicao m_candidatura;
    private TipoConflito m_tipoConflito;

    public ConflitoDeInteresse(FAE fae, CandidaturaAExposicao cand, TipoConflito tipoConflito) {
        this.m_fae = fae;
        this.m_candidatura = cand;
        this.m_tipoConflito = tipoConflito;
    }

    /**
     * @return the m_fae
     */
    public FAE getFae() {
        return m_fae;
    }

    /**
     * @return the m_candidatura
     */
    public CandidaturaAExposicao getCandidatura() {
        return m_candidatura;
    }

    /**
     *
     * @return tipo deste conflito
     */
    public TipoConflito getTipo() {
        return this.m_tipoConflito;
    }

}
