package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Exposicao;

/**
 * Representação de um ModeloListExposicao
 * 
 * @author G29
 */
public class ModeloListExposicao extends AbstractListModel {

    /**
     * Lista de exposições
     */
    private transient List<Exposicao> listExpo;

    /**
     * Adiciona uma lista 
     * @param l lista a adicionar
     */
    public void add(List<Exposicao> l) {
        listExpo.addAll(l);
    }

    /**
     * Devolve o tamanho da lista de exposições
     * 
     * @return tamanho da lista de exposições
     */
    @Override
    public int getSize() {
        return listExpo.size();
    }

    /**
     * Devolve uma exposição
     * 
     * @param i posição da exposição
     * @return exposição na posição i da lista
     */
    @Override
    public Object getElementAt(int i) {
        return listExpo.get(i);
    }

}
