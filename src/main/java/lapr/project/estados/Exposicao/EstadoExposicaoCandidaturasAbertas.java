package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class EstadoExposicaoCandidaturasAbertas extends EstadoExposicao {

    public EstadoExposicaoCandidaturasAbertas(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoCandidaturasAbertas() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturasFechadas() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasFechadas(this.m_exposicao));
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
    public boolean isEstadoCandidaturasAbertas() {
        return true;
    }
}
