package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Ricardo Catalao
 */
public class ComboBoxModelStandart<T> extends AbstractListModel implements ComboBoxModel {

    private transient List<T> list;

    private T selectedItem;
    
    public ComboBoxModelStandart(List<T> initialList){
        this.list = initialList;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem = (T)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}
