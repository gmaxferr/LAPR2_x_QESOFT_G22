package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ricardo Catalao
 */
public class EstadoExposicaoCandidaturasDecididas implements EstadoExposicao {

    private final Exposicao m_exposicao;

    public EstadoExposicaoCandidaturasDecididas(Exposicao exposicao) {
        this.m_exposicao = exposicao;
        m_exposicao.getKeywordRanking().setReady();
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
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAvaliadas() {
        return false;
    }

    @Override
    public boolean setEstadoStandsAtribuidos() {
        if(valida()){
            this.m_exposicao.setEstado(new EstadoExposicaoStandsAtribuidos(m_exposicao));
            return true;
        }
        return false;
    }
    
    public boolean valida(){
        // TODO
        return true;
    }

    @Override
    public boolean setEstadoDemonstracoesDecididas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoAbertas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoFechadas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasDecididas() {
        return false;
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

    @Override
    public boolean isEstadoStandsAtribuidos() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracoesDecididas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasDemonstracaoAbertas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasDemonstracaoFechadas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasDecididas() {
        return true;
    }

}