package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoAtribuicoes {

    private List<AtribuicaoCandidatura> m_listaAtribuicao;

    public RegistoAtribuicoes() {
        this.m_listaAtribuicao = new ArrayList<>();
    }

    public List<AtribuicaoCandidatura> getListaAtribuicoes() {
        return this.m_listaAtribuicao;
    }

    public ArrayList getDadosCandidatura(CandidaturaAExposicao c) {
        return c.getDadosCandidatura();
    }

    public boolean validarCandidatura(CandidaturaAExposicao c) {
        return c.validaCandidatura();
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

    public void setListaAtribuicao(List<AtribuicaoCandidatura> listaAtribuicao) {
        this.m_listaAtribuicao = listaAtribuicao;
    }

    public ArrayList<AtribuicaoCandidatura> getListaAtribuicoesDoFAE(String usernameFAE) {
        ArrayList<AtribuicaoCandidatura> listaAtrib = new ArrayList<>();
        for (AtribuicaoCandidatura atribuicao : this.m_listaAtribuicao) {
            if (atribuicao.getCandidaturaAssociada().getEstado().isEstadoCandidaturaAtribuida() && 
                    atribuicao.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(usernameFAE).getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFAE)) {
                listaAtrib.add(atribuicao);
            }
        }
        return listaAtrib;
    }

}
