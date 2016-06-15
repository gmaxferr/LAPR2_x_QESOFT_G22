package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class EstadoDemonstracaoCandidaturasFechadas extends EstadoDemonstracao {

    public EstadoDemonstracaoCandidaturasFechadas(Demonstracao demo) {
        super(demo);
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAtribuidas() {
        if (valida()) {
            m_demo.setEstado(new EstadoDemonstracaoCandidaturasAtribuidas(m_demo));
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
    public boolean isEstadoDemonstracaoCandidaturasFechadas() {
        return true;
    }

}
