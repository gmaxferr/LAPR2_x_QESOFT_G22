package lapr.project.model;

import lapr.project.registos.RegistoFaeAvaliacao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class AtribuicaoCandidatura {

    private final CandidaturaAExposicao m_candidatura;
    private final RegistoFaeAvaliacao m_rFaeDecisao;

    public AtribuicaoCandidatura(CandidaturaAExposicao candidaturaAExposicao) {
        this.m_candidatura = candidaturaAExposicao;
        this.m_rFaeDecisao = new RegistoFaeAvaliacao();
    }

    public CandidaturaAExposicao getCandidaturaAssociada() {
        return this.m_candidatura;
    }

    public RegistoFaeAvaliacao getRegistoFaeAvaliacao() {
        return this.m_rFaeDecisao;
    }

    public void addFaeAvaliacao(FAE fae) {
        this.m_rFaeDecisao.addFaeAvaliacao(fae);
    }
}
