/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author guima
 */
public class AbstractListModelRecursos extends AbstractListModel {

    List<Recurso> m_listaRecursos;

    public AbstractListModelRecursos(List<Recurso> listaRecursos) {
        this.m_listaRecursos = listaRecursos;
    }

    @Override
    public int getSize() {
        return m_listaRecursos.size();
    }

    @Override
    public Object getElementAt(int i) {
        return m_listaRecursos.get(i);
    }

}
