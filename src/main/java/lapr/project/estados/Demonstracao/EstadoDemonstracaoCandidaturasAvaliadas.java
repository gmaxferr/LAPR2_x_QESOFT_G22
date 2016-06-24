package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoCandidaturasAvaliadas
 * 
 * @author G29
 */
public class EstadoDemonstracaoCandidaturasAvaliadas extends EstadoDemonstracao {

    public EstadoDemonstracaoCandidaturasAvaliadas(Demonstracao demo) {
        super(demo);
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasDecididas() {
        this.m_demo.setEstado(new EstadoDemonstracaoCandidaturasDecididas(m_demo));
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasAvaliadas() {
        return true;
    }

}
