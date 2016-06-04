package lapr.project.model;

import lapr.project.registos.RegistoFaeAvaliacao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class Atribuicao {

    private CandidaturaAExposicao candidatura;
    private RegistoFaeAvaliacao rFaeDecisao;

    public Atribuicao(CandidaturaAExposicao candidaturaAExposicao) {
        this.candidatura = candidaturaAExposicao;
        this.rFaeDecisao = new RegistoFaeAvaliacao();
    }

    public CandidaturaAExposicao getCandidaturaAssociada() {
        return this.candidatura;
    }

    public RegistoFaeAvaliacao getRegistoFaeAvaliacao() {
        return this.rFaeDecisao;
    }

    public void addFaeAvaliacao(FAE fae) {
        this.rFaeDecisao.addFaeAvaliacao(fae);
    }
}
