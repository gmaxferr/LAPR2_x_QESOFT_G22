/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.List;
import javax.swing.AbstractListModel;
import classesModelERegistodePPROG.Exposicao;

/**
 *
 * @author guima
 */
public class ModeloListExposicao extends AbstractListModel {

    private List<Exposicao> listExpo;

    public void add(List<Exposicao> l) {
        listExpo.addAll(l);
    }

    @Override
    public int getSize() {
        return listExpo.size();
    }

    @Override
    public Object getElementAt(int i) {
        return listExpo.get(i);
    }

}
