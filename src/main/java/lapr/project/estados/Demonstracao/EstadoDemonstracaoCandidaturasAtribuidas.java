package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoCandidaturasAtribuidas
 * 
 * @author G29
 */
public class EstadoDemonstracaoCandidaturasAtribuidas extends EstadoDemonstracao {

    public EstadoDemonstracaoCandidaturasAtribuidas(Demonstracao demo) {
        super(demo);
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAvaliadas() {
        if (valida()) {
            m_demo.setEstado(new EstadoDemonstracaoCandidaturasAvaliadas(m_demo));
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
    public boolean isEstadoDemonstracaoCandidaturasAtribuidas() {
        return true;
    }

}
