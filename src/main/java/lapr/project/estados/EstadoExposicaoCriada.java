package lapr.project.estados;

import lapr.project.model.Exposicao;


/**
 *
 * @author Ana Leite RicardoOsório
 */
public class EstadoExposicaoCriada implements EstadoExposicao {

    private Exposicao exposicao;

    public EstadoExposicaoCriada(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

    @Override
    public boolean setEstadoCriada() {
        return false;
    }

    @Override
    public boolean setEstadoFAEDefinidosSemDemos() {
        if (valida()) {
            this.exposicao.setEstado(new EstadoExposicaoFAEDefinidosSemDemos(this.exposicao));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setEstadoDemosDefinidasSemFAE() {
        if (valida()) {
            this.exposicao.setEstado(new EstadoExposicaoDemosDefinidasSemFAE(this.exposicao));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setEstadoCompleta() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasFechadas() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return true;
    }

    @Override
    public boolean setEstadoConflitosAlterados() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAtribuidas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAvaliadas() {
        return false;
    }
    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoCriada() {
        return true;
    }

    @Override
    public boolean isEstadoFAEDefinidosSemDemos() {
         return false;
    }

    @Override
    public boolean isEstadoDemosDefinidasSemFAE() {
         return false;
    }

    @Override
    public boolean isEstadoCompleta() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasFechadas() {
         return false;
    }

    @Override
    public boolean isEstadoConflitosDetetados() {
         return false;
    }

    @Override
    public boolean isEstadoConflitosAlterados() {
         return false;
    }

    @Override
    public boolean isEstadoCandidaturasAtribuidas() {
         return false;
    }

    @Override
    public boolean isEstadoCandidaturasAvaliadas() {
         return false;
    }

}
