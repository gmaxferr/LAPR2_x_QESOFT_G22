package lapr.project.uiModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.*;

/**
 * Representação de um ModeloJListUtilizadores
 * 
 * @author G29
 */
public class ModeloJListUtilizadores extends AbstractListModel {

    /**
     * Lista de utilizadores
     */
    private transient List<Utilizador> m_listaUtilizadores;

    /**
     * Construtor de objetos do tipo ModeloJListUtilizadores sem parametros
     */
    public ModeloJListUtilizadores() {
        this.m_listaUtilizadores = new ArrayList<>();
    }

    /**
     * Adiciona um utilizador à lista de utilizadores
     * 
     * @param utilizadorNovo utilizador a adicionar
     */
    public void adicionarUtilizador(Utilizador utilizadorNovo) {
        this.m_listaUtilizadores.add(utilizadorNovo);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    }

    /**
     * Remove um utilizador da lista de utilizadores
     * 
     * @param utilizador utilizador a remover
     * @param index posição
     */
    public void removerUtilizador(Utilizador utilizador, int index) {
        this.m_listaUtilizadores.remove(utilizador);
        fireIntervalRemoved(this, index, index);
    }

    /**
     * Altera a lista de utilizadores a serem mostrados na lista
     *
     * @param listaUtilizadores nova lista de utilizadores
     */
    public void setList(List<Utilizador> listaUtilizadores) {
        this.m_listaUtilizadores = listaUtilizadores;
    }

    /**
     * Devolve a lista de utilizadores
     * 
     * @return lista de utilizadores
     */
    public List<Utilizador> getListaDeUtilizadoresAdicionados() {
        return this.m_listaUtilizadores;
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
     * Devolve um utilizador
     * 
     * @param index posição do utilizador
     * @return utilizador na posição index da lista de utilizadores
     */
    @Override
    public Object getElementAt(int index) {
        return this.m_listaUtilizadores.get(index).getUsername();
    }

}
