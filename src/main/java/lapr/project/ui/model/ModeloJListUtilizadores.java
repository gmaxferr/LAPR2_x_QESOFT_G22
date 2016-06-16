/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.*;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class ModeloJListUtilizadores extends AbstractListModel {

    private transient List<Utilizador> m_listaUtilizadores;

    public ModeloJListUtilizadores() {
        this.m_listaUtilizadores = new ArrayList<>();
    }

    public void adicionarUtilizador(Utilizador utilizadorNovo) {
        this.m_listaUtilizadores.add(utilizadorNovo);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    }

    public void removerUtilizador(Utilizador utilizador, int index) {
        this.m_listaUtilizadores.remove(utilizador);
        fireIntervalRemoved(this, index, index);
    }

    /**
     * Altera a lista de utilizadores a serem mostrados na lista
     *
     * @param listaUtilizadores
     */
    public void setList(List<Utilizador> listaUtilizadores) {
        this.m_listaUtilizadores = listaUtilizadores;
    }

    public List<Utilizador> getListaDeUtilizadoresAdicionados() {
        return this.m_listaUtilizadores;
    }

    @Override
    public int getSize() {
        return this.m_listaUtilizadores.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.m_listaUtilizadores.get(index).getUsername();
    }

}
