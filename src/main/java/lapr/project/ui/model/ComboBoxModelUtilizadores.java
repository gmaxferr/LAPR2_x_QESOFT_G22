package lapr.project.ui.model;

import java.util.ArrayList;
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
    private List<Utilizador> m_listaUtilizadores;

    /**
     * Utilizador selecionado
     */
    private String usernameUtilizadorSelecionado;

    public ComboBoxModelUtilizadores(List<Utilizador> listaUtilizadores) {
        this.usernameUtilizadorSelecionado = null;
        this.m_listaUtilizadores = new ArrayList(listaUtilizadores);
    }

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
        for(Organizador o : m_listaUtilizadores){
            if(o.getUsernameOrganizador().equals((String)anItem)){
                selection = o;
            }
        }
        this.usernameUtilizadorSelecionado = (String) anItem;
>>>>>>> 1225be995dd7ed74242a07ea7c2592dbd6306d84
    }

    /**
     * Devolve o item selecionado
     *
     * @return item selecionado
     */
    @Override
    public Object getSelectedItem() {
<<<<<<< HEAD
        Organizador o = (Organizador) selection;
        m_listaUtilizadores.remove((Organizador)selection);
        return o;
=======
        return this.usernameUtilizadorSelecionado;
>>>>>>> 1225be995dd7ed74242a07ea7c2592dbd6306d84
    }

    @Override
    public Object getElementAt(int index) {
        return this.m_listaUtilizadores.get(index).getUsername();
    }

    public void removerUtilizador(Utilizador utilizador) {
        this.m_listaUtilizadores.remove(utilizador);
    }
}
