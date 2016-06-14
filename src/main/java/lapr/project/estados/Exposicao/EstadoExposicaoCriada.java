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
    public boolean setEstadoFAEDefinidosSemDemos() {
            this.m_exposicao.setEstado(new EstadoExposicaoFAEDefinidosSemDemos(this.m_exposicao));
            return true;
    }

    @Override
    public boolean setEstadoDemosDefinidasSemFAE() {
        this.m_exposicao.setEstado(new EstadoExposicaoDemosDefinidasSemFAE(this.m_exposicao));
        return true;
    }

    @Override
    public boolean isEstadoCriada() {
        return true;
    }

}
