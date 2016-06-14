package lapr.project.estados.Exposicao;

import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite
 */
public class EstadoExposicaoCandidaturasAvaliadas extends EstadoExposicao {

    public EstadoExposicaoCandidaturasAvaliadas(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoCandidaturasAvaliadas() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturasDecididas() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasDecididas(this.m_exposicao));
            return true;
        }
        return false;
    }

    /**
     * @return Retorna TRUE se for possível passar para o estado de Candidaturas
     * decididas e FALSE caso contrário
     */
    public boolean valida() {
        for (CandidaturaAExposicao c : this.m_exposicao.getRegistoCandidaturasAExposicao().getListaCandidaturas()) {
            if (!c.getEstado().isEstadoCandidaturaAceite() && !c.getEstado().isEstadoCandidaturaRejeitada()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEstadoCandidaturasAtribuidas() {
        return true;
    }

}
