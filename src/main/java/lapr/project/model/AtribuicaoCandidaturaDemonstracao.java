package lapr.project.model;

import lapr.project.registos.RegistoCandidaturasADemonstracao;
import lapr.project.registos.RegistoFaeAvaliacao;
import lapr.project.registos.RegistoUtilizadores;

/**
 *
 * @author Ana Leite
 */
public class AtribuicaoCandidaturaDemonstracao {

    public static final String ROOT_ELEMENT_NAME = "AtribuicaoCandidaturaDemosntracao";
    
    private CandidaturaADemonstracao m_candidatura;
    
    private RegistoFaeAvaliacao m_rFaeAvaliacao;
    
    public AtribuicaoCandidaturaDemonstracao(CandidaturaADemonstracao candidaturaADemonstracao){
        this.m_candidatura = candidaturaADemonstracao;
        this.m_rFaeAvaliacao = new RegistoFaeAvaliacao();
    }
    
    public CandidaturaADemonstracao getCandidaturaAssociada(){
        return this.m_candidatura;
    }
    
    /**
     * Devolve o registo de FAEAvaliação
     *
     * @return registo de FAEAvaliação
     */
    public RegistoFaeAvaliacao getRegistoFaeAvaliacao() {
        return this.m_rFaeAvaliacao;
    }

    public void addFaeAvaliacao(FAE fae) {
        this.m_rFaeAvaliacao.addFaeAvaliacao(fae);
    }

    public void fix(RegistoCandidaturasADemonstracao m_rce, RegistoUtilizadores m_registoUtilizadores) {
        for (CandidaturaADemonstracao cand : m_rce.getListaCandidaturasADemonstracao()) {
            if (cand.equals(m_candidatura)) {
                m_candidatura = cand;
                break;
            }
        }
        this.m_rFaeAvaliacao.fix(m_registoUtilizadores);
    }


    /**
     * TESTE USE ONLY
     * @param m_rFaeAvaliacao the m_rFaeAvaliacao to set
     */
    public void setRegistoFaeAvaliacao(RegistoFaeAvaliacao m_rFaeAvaliacao) {
        this.m_rFaeAvaliacao = m_rFaeAvaliacao;
    }
}


