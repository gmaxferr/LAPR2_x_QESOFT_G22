package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite
 */
public class EstadoExposicaoCandidaturasAtribuidas extends EstadoExposicao {

    public EstadoExposicaoCandidaturasAtribuidas(Exposicao exposicao) {
        super(exposicao);
    }


    @Override
    public boolean setEstadoCandidaturasAvaliadas() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasAvaliadas(this.m_exposicao));
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
    public boolean isEstadoCandidaturasAtribuidas() {
        return true;
    }

}
