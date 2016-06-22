package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicaoCandidaturaDemonstracao;
import lapr.project.model.CandidaturaADemonstracao;
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
     * Devolve um vetor em que cada posição contem a média dos Ratings da
     * candidatura na mesma posição guardada no RegistoCandidaturas. Para aceder
     * à média dos ratings da terceira candidatura usar o vec[2].
     *
     * @return vetor com médias dos ratings de cada candidatura
     */
    public float[] getMediaRatingsTodasCandidaturasAsDemonstracoes() {
        int cont = this.m_listaAtribuicao.size();
        float[] vec = new float[cont];
        int i = 0;

        for (AtribuicaoCandidaturaDemonstracao atribuicao : this.m_listaAtribuicao) {
            vec[i] = atribuicao.getRegistoFaeAvaliacao().getMediaRatings();
            i++;
        }

        return vec;
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
    public void fix(RegistoCandidaturasADemonstracoes m_rcd, RegistoUtilizadores m_registoUtilizadores) {
        for (AtribuicaoCandidaturaDemonstracao atr : m_listaAtribuicao) {
            atr.fix(m_rcd, m_registoUtilizadores);
        }
    }

    /**
     * Através das atribuções feitas, procura e cria uma lista de candidaturas de um FAE.
     *
     * @param username - do FAE a procuarar candidaturas
     * @return lista de candidaturas do FAE
     */
    public List<CandidaturaADemonstracao> getListaCandidaturasDoFAE(String username) {
        List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoes = getListaAtribuicoesDoFAE(username);
        List<CandidaturaADemonstracao> listCands = new ArrayList<>();
        for (AtribuicaoCandidaturaDemonstracao a : listaAtribuicoes) {
            listCands.add(a.getCandidaturaAssociada());
        }
        return listCands;
    }

}
