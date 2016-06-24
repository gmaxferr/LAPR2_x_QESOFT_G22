package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoCandidaturasDecididas
 * 
 * @author G29
 */
public class EstadoDemonstracaoCandidaturasDecididas extends EstadoDemonstracao {

    public EstadoDemonstracaoCandidaturasDecididas(Demonstracao demo) {
        super(demo);
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasDecididas() {
        return true;
    }

}
