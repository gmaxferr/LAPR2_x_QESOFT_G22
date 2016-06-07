package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicoesCandidatura;
import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoAtribuicoes {

    private List<AtribuicoesCandidatura> m_listaAtribuicao;

    public RegistoAtribuicoes() {
        this.m_listaAtribuicao = new ArrayList<>();
    }

    public List<AtribuicoesCandidatura> getListaAtribuicoes() {
        return this.m_listaAtribuicao;
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
     * @param candidaturaAExposicao
     * @param decisao nova decisao
     */
    public void setAvaliacao(CandidaturaAExposicao candidaturaAExposicao, boolean decisao) {
        candidaturaAExposicao.setDecisao(decisao);
    }

    /**
     * Método que valida a decisao da candidatura
     *
     * @return boolean de confirmação de validação
     */
    public boolean validaDecidirCandidatura() {
        return true;
    }

    public void setListaAtribuicao(List<AtribuicoesCandidatura> listaAtribuicao) {
        this.m_listaAtribuicao = listaAtribuicao;
    }

    public ArrayList<AtribuicoesCandidatura> getListaAtribuicoesDoFAE(String usernameFAE) {
        ArrayList<AtribuicoesCandidatura> listaAtrib = new ArrayList<>();
        for (AtribuicoesCandidatura atribuicao : this.m_listaAtribuicao) {
            if (atribuicao.getCandidaturaAssociada().getEstado().isEstadoCandidaturaAtribuida() && 
                    atribuicao.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(usernameFAE).getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFAE)) {
                listaAtrib.add(atribuicao);
            }
        }
        return listaAtrib;
    }

}
