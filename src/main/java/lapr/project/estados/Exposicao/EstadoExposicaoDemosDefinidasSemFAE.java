package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class EstadoExposicaoDemosDefinidasSemFAE extends EstadoExposicao {

    public EstadoExposicaoDemosDefinidasSemFAE(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoDemosDefinidasSemFAE() {
        return true;
    }

    @Override
    public boolean setEstadoCompleta() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCompleta(this.m_exposicao));
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
    public boolean isEstadoDemosDefinidasSemFAE() {
        return true;
    }

}
