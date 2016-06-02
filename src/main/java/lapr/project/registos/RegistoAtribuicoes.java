package lapr.project.registos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de um Registo de Atribuições
 *
 * @author Ana Leite Ricardo Osório
 */
public class RegistoAtribuicoes implements Serializable{

    /**
     * Lista de atribuições.
     */
    private List<Atribuicao> listaAtribuicoes;

    /**
     * Avaliação.
     */
    private Avaliacao a;

    /**
     * Construtor de objectos do tipo RegistoAtribuicoes sem parâmetros.
     */
    public RegistoAtribuicoes() {
        this.listaAtribuicoes = new ArrayList<>();
    }

    /**
     * Regista a distribuição de candidaturas pelos fae.
     *
     * @param listaAtribuicoesGeradas lista atribuições geradas.
     */
    public void registaAtribuicao(List<Atribuicao> listaAtribuicoesGeradas) {
        this.listaAtribuicoes = listaAtribuicoesGeradas;
    }

    /**
     * Devolve a lista de atribuições.
     * 
     * @param usernameFAE username do fae.
     * @return lista deatribuições.
     */
    public List<Atribuicao> getListaAtribuicoesDoFAE(String usernameFAE) {
        List<Atribuicao> lista = new ArrayList<>();
        for (Atribuicao atribuicao : this.listaAtribuicoes) {
            for (FAE fae : atribuicao.getRegistoFaeDecisao().getListaFAE()) {
                if (fae.getUsername().equalsIgnoreCase(usernameFAE)) {
                    lista.add(atribuicao);
                }
            }
        }
        return lista;
    }

    /**
     * Retona a lista de candidaturas de um fae.
     *
     * @param username username do fae.
     *
     * @return lista de candidaturas de um fae.
     */
    public List<Atribuicao> getListaCandidaturasDoFAE(String username) {
        List<Atribuicao> lista = new ArrayList<>();
        for (Atribuicao a : this.listaAtribuicoes) {
            lista.add(a);
        }
        return lista;
    }
    
    /**
     * Altera a decisão e a justificação
     *
     * @param decisao nova decisão.
     * @param justificacao nova justificação.
     */
    public void setDecisao(boolean decisao, String justificacao) {
        a.setDecisao(decisao);
        a.setJustificacao(justificacao);
    }

    /**
     * Valida a decisão.
     *
     * @return validação da decisão.
     */
    public boolean valida() {
        if (a.getJustificacao() == null) {
            return true;
        }
        return false;
    }

    /**
     * Adiciona atribuições à lista de aribuições.
     *
     * @param atribuicao atribuição.
     */
    public void adicionaAtribuicoes(Atribuicao atribuicao) {
        this.listaAtribuicoes.add(atribuicao);
    }
}
