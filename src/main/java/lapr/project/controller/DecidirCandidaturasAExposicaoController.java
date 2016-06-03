package lapr.project.controller;

import lapr.project.estados.EstadoCandidaturaAExposicao;

/**
 *
 * @author osori
 */
public class DecidirCandidaturasAExposicaoController {

    private Exposicao exposicaoSelecionada;
    private Candidatura candidaturaSelecionada;
    private RegistoCandidaturas rc;
    private RegistoExposicoes re;
    private CentroExposicoes ce;

    public DecidirCandidaturasAExposicaoController(CentroExposicoes ce) {
        this.ce = ce;
    }

    public void getRegistoExposicoes() {
        this.re = ce.getRegistoExposicoes();
    }

    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAvaliadas() {
        return this.re.getListaExposicoesEstadoCandidaturasAvaliadas();
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicaoSelecionada = exposicao;
    }

    public ArrayList<Candidatura> getListaCandidaturasEstadoAvaliadas() {
        this.rc = this.exposicaoSelecionada.getRegistoCandidaturas();
        return this.rc.getListaCandidaturasEstadoAvaliadas();
    }

    public naosei getDadosEstatisticosGerais() {
        return naosei;
    }

    public void setCandidatura(Candidatura cand) {
        this.candidaturaSelecionada = cand;
    }
    
    public String getNomeEmpresa(){
        return this.candidaturaSelecionada.getNomeEmpresa();
    }
    
    public String getMoradaEmpresa(){
        return this.candidaturaSelecionada.getMoradaEmpresa();
    }
    
    public int getTelemovel(){
        return this.candidaturaSelecionada.getTelemovel();
    }
    
    public int getArea(){
        return this.candidaturaSelecionada.getArea();
    }
    
    public int getNumeroConvites(){
        return this.candidaturaSelecionada.getNumeroConvites();
    }
    
    public naoSei getKeywords(){
        return naoSei;
    }
    
    public void setDecisao(boolean decisao){
        this.candidaturaSelecionada.setDecisao(decisao);
        if(decisao){
            setEstadoCandidaturaAceite();
        }
    }
    
   private void setEstadoCandidaturaAceite(){
       EstadoCandidaturaAExposicao estado=this.candidaturaSelecionada.getEstado();
       estado.setEstadoCandidaturaAceite();
   }
    
    
}
