package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Atribuicao;
import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoAtribuicoes {

    private List<Atribuicao> listaAtribuicao;
    
    public RegistoAtribuicoes(){
        this.listaAtribuicao=new ArrayList<>();
    }
    
    public ArrayList getDadosCandidatura(CandidaturaAExposicao c) {
        return c.getDadosCandidatura();
    }
    
    public boolean validarCandidatura(CandidaturaAExposicao c) {
        return c.validarCandidatura();
    }
    
    /**
     * Métoto que define nova decisao
     *
     * @param c nova candidatura
     * @param decisao nova decisao
     * @param justificacao nova justificaçao
     */
    public void setDecisao(CandidaturaAExposicao c, String decisao, String justificacao) {
        c.setDecisao(decisao, justificacao);
    }
    
    /**
     * Método que valida a decisao da candidatura
     *
     * @return boolean de confirmação de validação
     */
    public boolean validaDecidirCandidatura() {
        return true;
    }

    public void setListaAtribuicao(List<Atribuicao> listaAtribuicao) {
        this.listaAtribuicao=listaAtribuicao;
    }

}
