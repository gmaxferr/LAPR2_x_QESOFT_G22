package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoAtribuicoes;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author Ricardo Osorio
 */
public class AvaliarCandidaturaAExposicaoController {
    
    private CentroExposicoes centroExposicoesAtual;
    private final String usernameFAE;
    private RegistoExposicoes re;
    private Exposicao exposicaoSelecionada;
    private RegistoAtribuicoes ra;
    private CandidaturaAExposicao candidaturaEscolhida;
    
    public AvaliarCandidaturaAExposicaoController(CentroExposicoes centroExposicoes, String usernameFAE){
        this.centroExposicoesAtual=centroExposicoes;
        this.usernameFAE=usernameFAE;
    }
    
    public void getRegistoExposicoes(){
        this.re=this.centroExposicoesAtual.getRegistoExposicoes();
    }
    
    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(){
        return this.re.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(this.usernameFAE);
    }
    
    public void setExposicao(Exposicao exposicao){
        this.exposicaoSelecionada=exposicao;
    }
    
    public void getRegistoAtribuicoes(){
        this.ra=this.exposicaoSelecionada.getRegistoAtribuicoes();
    }
    
    public ArrayList<CandidaturaAExposicao> getListaCandidaturasEstadoAtribuidasAoFAE(){
        return this.ra.getListaCandidaturasEstadoAtribuidasAoFAE(this.usernameFAE);
    }
    
    public void setCandidatura(CandidaturaAExposicao candidatura){
        this.candidaturaEscolhida=candidatura;
    }
    
    
}
