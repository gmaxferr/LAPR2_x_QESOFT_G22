package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite RicardoOsório
 */
public class EstadoExposicaoCriada extends EstadoExposicao {

    public EstadoExposicaoCriada(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoCriada() {
        return true;
    }

    @Override
    public boolean setEstadoFAEDefinidosSemDemos() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoFAEDefinidosSemDemos(this.m_exposicao));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setEstadoDemosDefinidasSemFAE() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoDemosDefinidasSemFAE(this.m_exposicao));
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
    public boolean isEstadoCriada() {
        return true;
    }

}
