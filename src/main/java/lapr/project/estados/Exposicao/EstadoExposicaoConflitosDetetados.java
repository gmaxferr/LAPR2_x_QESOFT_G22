package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class EstadoExposicaoConflitosDetetados extends EstadoExposicao {

    public EstadoExposicaoConflitosDetetados(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return true;
    }

    @Override
    public boolean setEstadoConflitosAlterados() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoConflitosAlterados(this.m_exposicao));
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
    public boolean isEstadoConflitosDetetados() {
        return true;
    }

}
