package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 * Representação do EstadoExposicaoCandidaturasFechadas
 * 
 * @author G29
 */
public class EstadoExposicaoCandidaturasFechadas extends EstadoExposicao {

    public EstadoExposicaoCandidaturasFechadas(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        //validação se pode passar para o próximo passo
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoConflitosDetetados(this.m_exposicao));
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
    public boolean isEstadoCandidaturasFechadas() {
        return true;
    }
}
