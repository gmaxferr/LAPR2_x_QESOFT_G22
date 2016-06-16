package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class EstadoExposicaoConflitosAlterados extends EstadoExposicao {

    public EstadoExposicaoConflitosAlterados(Exposicao exposicao) {
        super(exposicao);
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

    public boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoConflitosAlterados() {
        return true;
    }

}
