/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.ConflitoDeInteresseDemonstracao;
import lapr.project.model.FAE;
import lapr.project.model.TipoConflitoDemonstracao;
import org.w3c.dom.Node;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class RegistoConflitosDemonstracao {

    public static final String ROOT_ELEMENT_NAME = "RegistoConflitos";

    /**
     * Lista de conflitos de interesse
     */
    private final List<ConflitoDeInteresseDemonstracao> m_listaConflitos;

    /**
     * Construtor de objetos do tipo RegistoConflitos sem parâmetros
     */
    public RegistoConflitosDemonstracao() {
        this.m_listaConflitos = new ArrayList<>();
    }

    /**
     * Cria um conflito entre o FAE e a Candidatura passados como argumentos e
     * regista esse conflito.
     *
     * @param fae - FAE que conflite com uma Candidatura
     * @param cand - Candidatura com que o FAE conflite
     */
    public void criarConflito(FAE fae, CandidaturaADemonstracao cand, TipoConflitoDemonstracao tipoConflito) {
        ConflitoDeInteresseDemonstracao c = new ConflitoDeInteresseDemonstracao(fae, cand, tipoConflito);
        adiciona(c);
    }

    /**
     * Verifica se um conflito é válido, verificando se este já existe ou não.
     *
     * @param fae - FAE em conflito
     * @param cand - Candidatura em conflito
     * @return true se for válido; false caso contrário.
     */
    public boolean valida(FAE fae, CandidaturaADemonstracao cand, TipoConflitoDemonstracao tipo) {
        boolean valido = true;
        for (ConflitoDeInteresseDemonstracao c : m_listaConflitos) {
            if (c.getFae().equals(fae) && c.getCandidatura().equals(cand) && c.getTipo().equals(tipo)) {
                valido = false;
            }
        }
        return valido;
    }

    /**
     * Devolve a lisat de conflitos de interesse
     *
     * @return a lista de conflitos
     */
    public List<ConflitoDeInteresseDemonstracao> getListaConflitos() {
        return m_listaConflitos;
    }

    /**
     * Remove um conflito da lista de conflitos de interesse
     *
     * @param c - Conflito a remover
     */
    public void remove(ConflitoDeInteresseDemonstracao c) {
        m_listaConflitos.remove(c);
    }

    /**
     * Adiciona um conflito da lista de conflitos de interesse
     *
     * @param c - Conflito a remover
     */
    public void adiciona(ConflitoDeInteresseDemonstracao c) {
        m_listaConflitos.add(c);
    }

    @Override
    public RegistoConflitos importContentFromXMLNode(Node node) {

    }

    @Override
    public Node exportContentToXMLNode() {
    }
}
