package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.*;

/**
 * Representação de uma ComboBoxModel de utilizadores
 *
 * @author G29
 */
public class ComboBoxModelUtilizadores extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de utilizadores
     */
    private transient List<Utilizador> m_listaUtilizadores;

    /**
     * Utilizador selecionado
     */
    private String usernameUtilizadorSelecionado;

    /**
     * Construtor de objetos do tipo ComboBoxModelUtilizadores com o parametro
     * lista de utilizadore
     * 
     * @param listaUtilizadores lista de utilizadore
     */
    public ComboBoxModelUtilizadores(List<Utilizador> listaUtilizadores) {
        this.usernameUtilizadorSelecionado = null;
        this.m_listaUtilizadores = listaUtilizadores;
    }

    /**
     * Adiciona um utilizador novo à lista de utilizadores
     * 
     * @param utilizadorNovo novo utilizador a ser adicionado
     */
    public void adicionarUtilizador(Utilizador utilizadorNovo) {
        this.m_listaUtilizadores.add(utilizadorNovo);
    }

    /**
     * Devolve o tamanho da lista de utilizadores
     *
     * @return tamanho da lista de utilizadores
     */
    @Override
    public int getSize() {
        return this.m_listaUtilizadores.size();
    }

    /**
     * Define o item selecionado
     *
     * @param anItem item selecionado
     */
    @Override
    public void setSelectedItem(Object anItem) {

        this.usernameUtilizadorSelecionado = (String) anItem;

    }

    /**
     * Devolve o item selecionado
     *
     * @return item selecionado
     */
    @Override
    public Object getSelectedItem() {

        return this.usernameUtilizadorSelecionado;

    }

    /**
     * Devolve um utilizador
     *
     * @param index posição do utilizador
     * @return utilizador
     */

    @Override
    public Object getElementAt(int index) {
        return this.m_listaUtilizadores.get(index).getUsername();
    }

    /**
     * Remove um utilizador da lista de utilizadore
     * 
     * @param utilizador utilizador a ser removido
     */
    public void removerUtilizador(Utilizador utilizador) {
        this.m_listaUtilizadores.remove(utilizador);
    }
}
