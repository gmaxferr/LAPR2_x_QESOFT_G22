package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Representação do EstadoCandidaturaAExposicaoCriada
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoCriada extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoCriada(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        if (valida()) {
            this.m_cand.setEstado(new EstadoCandidaturaAExposicaoCriada(this.m_cand));
            return true;
        } else {
            return false;
        }
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaRemovida() {
        if (valida1()) {
            this.m_cand.setEstado(new EstadoCandidaturaAExposicaoRemovida(this.m_cand));
            return true;
        } else {
            return false;
        }
    }

    private boolean valida1() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }
    
    @Override
    public boolean isEstadoCandidaturaCriada() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaAbertaAtualizacaoConflitos() {
        m_cand.setEstado(new EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos(m_cand));
        return true;
    }
}
