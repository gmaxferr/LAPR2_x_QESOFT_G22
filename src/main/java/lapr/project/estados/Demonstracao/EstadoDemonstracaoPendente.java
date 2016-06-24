package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoPendente
 * 
 * @author G29
 */
public class EstadoDemonstracaoPendente extends EstadoDemonstracao {

    public EstadoDemonstracaoPendente(Demonstracao demo) {
        super(demo);
    }

    @Override
    public boolean setEstadoDemonstracaoConfirmada() {
        this.m_demo.setEstado(new EstadoDemonstracaoConfirmada(m_demo));
        return true;
    }

    @Override
    public boolean setEstadoDemonstracaoCancelada() {
        this.m_demo.setEstado(new EstadoDemonstracaoCancelada(m_demo));
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoPendente() {
        return true;
    }

}
