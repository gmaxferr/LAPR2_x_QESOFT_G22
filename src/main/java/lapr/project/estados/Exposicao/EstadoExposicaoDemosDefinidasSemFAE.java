package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class EstadoExposicaoDemosDefinidasSemFAE extends EstadoExposicao {

    private Exposicao m_exposicao;

    public EstadoExposicaoDemosDefinidasSemFAE(Exposicao exposicao) {
        this.m_exposicao = exposicao;
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
