package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.EstadoCandidaturaAExposicaoAtribuida;
import lapr.project.estados.EstadoCandidaturaAExposicao;

/**
 * Representação do Controller do caso de uso - decidir candidatura
 *
 * @author Ricardo Osório Ana Leite
 */
public class DecidirCandidaturaController {

    Exposicao e = new Exposicao();
    RegistoAtribuicoes ra;
    public static List<Candidatura> listaCand = new ArrayList<>();
    Candidatura candidatura;
    EstadoCandidaturaAExposicao estadoCand;
    public EstadoCandidaturaAExposicaoAtribuida estadoCandidaturaAtribuida;
    

    public boolean getEstado(){
        estadoCand = candidatura.getEstadoCandidatura();
        return verificaEstado(estadoCand);
    }
    
    public boolean verificaEstado(EstadoCandidaturaAExposicao estado){
        //Verifica se o estdo permite executar este UC
        return true;
    }
    
    public void getM_RegistoAtribuicoes() {
        this.ra = e.getRa();
    }
    
    /**
     * Devolve a lista de candidatura de fae
     *
     * @return lista de candidaturas de fae
     */
    public List<Candidatura> getListaCandidaturaDoFAE() {
        listaCand = this.e.getListaCandidaturas();
        return listaCand;
    }

    public void setExposicao(Exposicao exposicao) {
        this.e = exposicao;
    }
    
    /**
     * Devolde os dados da candidatura selecionada
     *
     * @param c candidatura
     *
     * @return dados da candidatura selecionada
     */
    public ArrayList getDadosCandidatura(Candidatura c) {
        return ra.getDadosCandidatura(c);
    }

    /**
     * Chama o método validarCandidatura da exposição selecionada
     *
     * @param c candidatura a ser validada
     */
    public void validarCandidatura(Candidatura c) {
        ra.validarCandidatura(c);
    }

    /**
     * Chama o método setDecisao da exposição selecionada
     *
     * @param c candidatura
     * @param Decisao decisao
     * @param justificacao justificacao
     */
    public void setDecisao(Candidatura c, String Decisao, String justificacao) {
        ra.setDecisao(c, Decisao, justificacao);
    }

    /**
     * Chama o método validaDecidirCandidatura da exposição selecionada
     */
    public void valida() {
        ra.validaDecidirCandidatura();
    }

    public void setEstadoCandidaturaAvaliada(){
            this.estadoCand = candidatura.getEstadoCandidatura();
            estadoCandidaturaAtribuida.setEstadoCandidaturaAvaliada();
                    }
}
