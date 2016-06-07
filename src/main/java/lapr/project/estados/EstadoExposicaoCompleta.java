package lapr.project.estados;

import lapr.project.model.Exposicao;


/**
 *
 * @author Ana Leite RicardoOsório
 */
public class EstadoExposicaoCompleta implements EstadoExposicao {

    private Exposicao m_exposicao;

    public EstadoExposicaoCompleta(Exposicao exposicao) {
        this.m_exposicao = exposicao;
    }

    @Override
    public boolean setEstadoCriada() {
        return false;
    }

    @Override
    public boolean setEstadoFAEDefinidosSemDemos() {
        return false;
    }

    @Override
    public boolean setEstadoDemosDefinidasSemFAE() {
        return false;
    }

    @Override
    public boolean setEstadoCompleta() {
        return false;
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

    @Override
    public boolean setEstadoCandidaturasFechadas() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return false;
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
        return false;
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
        return true;
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
