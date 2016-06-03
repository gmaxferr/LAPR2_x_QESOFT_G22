package lapr.project.estados;

import classesREMOVIDAS.Exposicao;

/**
 *
 * @author Ana Leite
 */
public class EstadoExposicaoCandidaturasFechadas implements EstadoExposicao {

    private Exposicao exposicao;

    public EstadoExposicaoCandidaturasFechadas(Exposicao exposicao) {
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
        //validação se pode passar para o próximo passo
        if (valida()) {
            this.exposicao.setEstado(new EstadoExposicaoConflitosDetetados(this.exposicao));
            return true;
        } else {
            return false;
        }
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

}
