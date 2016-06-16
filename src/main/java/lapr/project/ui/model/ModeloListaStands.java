package lapr.project.ui.model;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Stand;

/**
 *
 * @author G29
 */
public class ModeloListaStands extends AbstractListModel {

    private transient List<Stand> listaStands;

    public ModeloListaStands(List<Stand> listaStands) {
        this.listaStands = listaStands;
    }

    @Override
    public int getSize() {
        return this.listaStands.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.listaStands.get(index).getID();
    }

}
