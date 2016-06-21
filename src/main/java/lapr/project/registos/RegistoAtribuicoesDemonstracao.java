package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicaoCandidaturaDemonstracao;
import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ana Leite
 */
public class RegistoAtribuicoesDemonstracao {

    public static final String ROOT_ELEMENT_NAME = "registoAtribuicoes";

    /**
     * Lista de atribuicaoCandidatura
     */
    private List<AtribuicaoCandidaturaDemonstracao> m_listaAtribuicao;

    /**
     * Construtor de objetos do tipo RegistoAtribuicoes sem parâmetros
     */
    public RegistoAtribuicoesDemonstracao() {
        this.m_listaAtribuicao = new ArrayList<>();
    }

    /**
     * Devolve as candidaturas atribuídas a um fae
     *
     * @param usernameFAE username do fae
     * @return candidaturas atribuídas a um fae
     */
    public ArrayList<AtribuicaoCandidaturaDemonstracao> getListaAtribuicoesDoFAE(String usernameFAE) {
        ArrayList<AtribuicaoCandidaturaDemonstracao> listaAtrib = new ArrayList<>();
        for (AtribuicaoCandidaturaDemonstracao atribuicao : this.m_listaAtribuicao) {
            if (atribuicao.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(usernameFAE) != null) {
                listaAtrib.add(atribuicao);
            }
        }
        return listaAtrib;
    }

    /**
     * Devolve as candidaturas atribuídas a um fae que se encontrem no estado
     * atribuidas
     *
     * @param usernameFAE username do fae
     * @return candidaturas atribuídas a um fae
     */
    public ArrayList<AtribuicaoCandidaturaDemonstracao> getListaAtribuicoesDoFAEEstadoAtribuidas(String usernameFAE) {
        ArrayList<AtribuicaoCandidaturaDemonstracao> listaAtrib = new ArrayList<>();
        for (AtribuicaoCandidaturaDemonstracao atribuicao : this.m_listaAtribuicao) {
            if (atribuicao.getCandidaturaAssociada().getEstado().isEstadoCandidaturaADemonstracaoAtribuida()
                    && atribuicao.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(usernameFAE) != null) {
                listaAtrib.add(atribuicao);
            }
        }
        return listaAtrib;
    }
    
    /**
     * Devolve a lista de atribuicaoCandidatura
     *
     * @return lista de atribuicaoCandidatura
     */
    public List<AtribuicaoCandidaturaDemonstracao> getListaAtribuicoes() {
        return this.m_listaAtribuicao;
    }

    public void setListaAtribuicao(List<AtribuicaoCandidaturaDemonstracao> listaAtribuicao) {
        this.m_listaAtribuicao = listaAtribuicao;
    }

    /**
     * Define nova decisao
     *
     * @param candidaturaAExposicao candidatura
     * @param decisao nova decisao
     */
    public void setAvaliacao(CandidaturaAExposicao candidaturaAExposicao, boolean decisao) {
        candidaturaAExposicao.setDecisao(decisao);
    }
    
     /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     *
     * @param m_rcd
     * @param m_registoUtilizadores registo de utilizadores
     */
    public void fix(RegistoCandidaturaADemonstracoes m_rcd, RegistoUtilizadores m_registoUtilizadores) {
        for (AtribuicaoCandidaturaDemonstracao atr : m_listaAtribuicao) {
            atr.fix(m_rcd, m_registoUtilizadores);
        }
    }
}

