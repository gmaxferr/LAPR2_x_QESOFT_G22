package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoDatasDefinidas
 * 
 * @author G29
 */
public class EstadoDemonstracaoDatasDefinidas extends EstadoDemonstracao {

    public EstadoDemonstracaoDatasDefinidas(Demonstracao m_demo) {
        super(m_demo);
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAbertas() {
        this.m_demo.setEstado(new EstadoDemonstracaoCandidaturasAbertas(m_demo));
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoDatasDefinidas() {
        return true;
    }

}
