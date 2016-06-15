package lapr.project.ui;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.ui.JFrameRegistarExpoUI.PossivelOrganizador;

/**
 * Representação de uma ComboBoxModel de utilizadores
 * 
 * @author Ana Leite
 */
public class ComboBoxModelUtilizadores extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de utilizadores
     */
    private List<PossivelOrganizador> m_listaUtilizadores;
    
    /**
     * Objeto selecionado
     */
    private String selection;
    
    public ComboBoxModelUtilizadores(List<PossivelOrganizador> listaUtilizadores){
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
     * Devolve um utilizador
     * 
     * @param index posição do utilizador
     * 
     * @return posição do utilizador
     */
    @Override
    public Object getElementAt(int index) {
        return this.m_listaUtilizadores.get(index).getOrganizador().getUtilizador();
    }

    /**
     * Define o item selecionado
     * 
     * @param anItem item selecionado
     */
    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    /**
     * Devolve o item selecionado
     * 
     * @return item selecionado
     */
    @Override
    public Object getSelectedItem() {
        return selection;
    }

}
