package lapr.project.estados;

import classesREMOVIDAS.Exposicao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class EstadoExposicaoConflitosAlterados implements EstadoExposicao {

    private Exposicao exposicao;

    public EstadoExposicaoConflitosAlterados(Exposicao exposicao) {
        this.exposicao = exposicao;
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
        if (valida()) {
            this.exposicao.setEstado(new EstadoExposicaoCandidaturasAtribuidas(this.exposicao));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setEstadoCandidaturasAvaliadas() {
        return false;
    }
    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

}
