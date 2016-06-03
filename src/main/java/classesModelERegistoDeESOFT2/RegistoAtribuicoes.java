package classesModelERegistoDeESOFT;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoAtribuicoes {

    private List<Atribuicao> listaAtribuicao;
    
    public RegistoAtribuicoes(){
        this.listaAtribuicao=new ArrayList<>();
    }
    
    public ArrayList getDadosCandidatura(Candidatura c) {
        return c.getDadosCandidatura();
    }
    
    public boolean validarCandidatura(Candidatura c) {
        return c.validarCandidatura();
    }
    
    /**
     * Métoto que define nova decisao
     *
     * @param c nova candidatura
     * @param decisao nova decisao
     * @param justificacao nova justificaçao
     */
    public void setDecisao(Candidatura c, String decisao, String justificacao) {
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
