package lapr.project.model;

/**
 *
 * @author Ricardo Catalao
 */
public class AtribuicaoStand {
    
    private Stand m_stand;
    private CandidaturaAExposicao m_cand;
    private boolean m_decisao;

    public AtribuicaoStand(Stand m_stand, CandidaturaAExposicao m_cand, boolean decisao) {
        this.m_stand = m_stand;
        this.m_cand = m_cand;
        this.m_decisao = decisao;
    }

    /**
     * @return the stand
     */
    public Stand getStand() {
        return m_stand;
    }

    /**
     * @param stand the stand to set
     */
    public void setStand(Stand stand) {
        this.m_stand = stand;
    }

    /**
     * @return the cand
     */
    public CandidaturaAExposicao getCand() {
        return m_cand;
    }

    /**
     * @param cand the cand to set
     */
    public void setCand(CandidaturaAExposicao cand) {
        this.m_cand = cand;
    }
    
    /**
     * Devolve a decisão
     * 
     * @return decisão
     */
    public boolean getDecisao(){
        return this.m_decisao;
    }
    
    /**
     * Modifica a decisão
     * 
     * @param decisao nova decisão
     */
    public void setDecisao(boolean decisao){
        this.m_decisao = decisao;
    }

}
