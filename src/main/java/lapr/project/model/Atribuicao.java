package lapr.project.model;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class Atribuicao {

    private CandidaturaAExposicao candidatura;
    private FAE fae;
    private boolean decisao;

    public Atribuicao(CandidaturaAExposicao candidaturaAExposicao, FAE fae) {
        this.candidatura = candidaturaAExposicao;
        this.fae = fae;
    }
    
    public CandidaturaAExposicao getCandidaturaAssociada(){
        return this.candidatura;
    }

    public FAE getFAEAssociado() {
        return this.fae;
    }
}
