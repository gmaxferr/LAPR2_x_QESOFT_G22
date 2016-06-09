package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaAExposicaoCriada implements EstadoCandidaturaAExposicao {

    private CandidaturaAExposicao m_cand;

    public EstadoCandidaturaAExposicaoCriada(CandidaturaAExposicao cand) {
        this.m_cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaInicial() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        if (valida()) {
            this.m_cand.setEstado(new EstadoCandidaturaAExposicaoCriada(this.m_cand));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAvaliada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAceite() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaRejeitada() {
        return false;
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaIncial() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return true;
    }


    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAceite() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaRejeitada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAbertaAtualizacaoConflitos() {
        m_cand.setEstado(new EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos(m_cand));
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaProntaAtribuicoes() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaProntaAtribuicoes() {
        return false;
    }

}
