package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite RicardoOsório
 */
public class EstadoExposicaoCompleta extends EstadoExposicao {

    public EstadoExposicaoCompleta(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoCompleta() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturasAbertas() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasAbertas(this.m_exposicao));
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
    public boolean isEstadoCompleta() {
        return true;
    }

}
