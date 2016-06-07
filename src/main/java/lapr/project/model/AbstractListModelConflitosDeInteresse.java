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
public class AbstractListModelConflitosDeInteresse extends AbstractListModel {

    List<ConflitoDeInteresse> listaConflitos;

    public AbstractListModelConflitosDeInteresse(List<ConflitoDeInteresse> listaConflitos) {
        this.listaConflitos = listaConflitos;
    }

    @Override
    public int getSize() {
        return listaConflitos.size();
    }

    @Override
    public Object getElementAt(int i) {
        return listaConflitos.get(i);
    }

}
