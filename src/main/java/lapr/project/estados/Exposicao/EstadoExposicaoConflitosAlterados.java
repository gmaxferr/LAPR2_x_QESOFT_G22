package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class EstadoExposicaoConflitosAlterados extends EstadoExposicao {

    private Exposicao m_exposicao;

    public EstadoExposicaoConflitosAlterados(Exposicao exposicao) {
        this.m_exposicao = exposicao;
    }

    @Override
    public boolean setEstadoConflitosAlterados() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturasAtribuidas() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasAtribuidas(this.m_exposicao));
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
    public boolean isEstadoConflitosAlterados() {
        return true;
    }

}
