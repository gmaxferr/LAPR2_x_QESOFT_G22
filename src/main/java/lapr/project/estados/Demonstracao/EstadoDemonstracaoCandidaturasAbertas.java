package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoCandidaturasAbertas
 * 
 * @author G29
 */
public class EstadoDemonstracaoCandidaturasAbertas extends EstadoDemonstracao {

    public EstadoDemonstracaoCandidaturasAbertas(Demonstracao demo) {
        super(demo);
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasFechadas() {
        this.m_demo.setEstado(new EstadoDemonstracaoCandidaturasFechadas(m_demo));
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasAbertas() {
        return true;
    }

}
