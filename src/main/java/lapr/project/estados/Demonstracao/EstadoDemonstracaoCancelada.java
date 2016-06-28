package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoCancelada
 * 
 * @author G29
 */
public class EstadoDemonstracaoCancelada extends EstadoDemonstracao{

    public EstadoDemonstracaoCancelada(Demonstracao demo){
        super(demo);
    }

    @Override
    public boolean isEstadoDemonstracaoCancelada() {
        return true;
    }
}
