package lapr.project.ui.model;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.Organizador;

/**
 * Representação de uma ComboBoxModel de utilizadores
 * 
 * @author Ana Leite
 */
public class ComboBoxModelUtilizadores extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de utilizadores
     */
    private List<Organizador> m_listaUtilizadores;
    
    /**
     * Objeto selecionado
     */
    private Object selection;
    
    public ComboBoxModelUtilizadores(List<Organizador> listaUtilizadores){
        this.selection = null;
        this.m_listaUtilizadores = listaUtilizadores;
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
    }

    /**
     * Devolve o item selecionado
     * 
     * @return item selecionado
     */
    @Override
    public Object getSelectedItem() {
        Organizador o = (Organizador) selection;
        m_listaUtilizadores.remove((Organizador)selection);
        return o;
    }

    @Override
    public Object getElementAt(int index) {
        return m_listaUtilizadores.get(index).getUtilizador().getUsername();
    }

}
