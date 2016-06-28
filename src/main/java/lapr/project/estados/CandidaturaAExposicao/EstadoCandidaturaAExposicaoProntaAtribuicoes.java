package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Representação do EstadoCandidaturaAExposicaoProntaAtribuicoes
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoProntaAtribuicoes extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoProntaAtribuicoes(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        m_cand.setEstado(new EstadoCandidaturaAExposicaoAtribuida(m_cand));
        return true;
    }


    @Override
    public boolean isEstadoCandidaturaProntaAtribuicoes() {
        return true;
    }

}
