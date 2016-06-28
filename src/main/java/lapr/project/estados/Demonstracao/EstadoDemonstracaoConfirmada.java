package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoConfirmada
 * 
 * @author G29
 */
public class EstadoDemonstracaoConfirmada extends EstadoDemonstracao {

    public EstadoDemonstracaoConfirmada(Demonstracao demo) {
        super(demo);
    }

    @Override
    public boolean setEstadoDemonstracaoDatasDefinidas() {
        if (valida()) {
            this.m_demo.setEstado(new EstadoDemonstracaoDatasDefinidas(m_demo));
            return true;
        }
        return false;
    }

    private boolean valida() {
        //TODO
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoConfirmada() {
        return true;
    }

}
