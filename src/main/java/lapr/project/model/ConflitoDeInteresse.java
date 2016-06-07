package lapr.project.model;

/**
 *
 * @author osori
 */
public class ConflitoDeInteresse {

    private FAE m_fae;
    private CandidaturaAExposicao m_candidatura;

    public ConflitoDeInteresse(FAE fae, CandidaturaAExposicao cand) {
        this.m_fae = fae;
        this.m_candidatura = cand;
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

}
