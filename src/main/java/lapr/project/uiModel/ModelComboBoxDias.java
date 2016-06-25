package lapr.project.uiModel;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Representação de um ModelComboBoxDias
 * 
 * @author G29
 */
public class ModelComboBoxDias extends AbstractListModel implements ComboBoxModel {
    
    /**
     * Vetor que representa 28 dias
     */
    int[] dias_28 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
    
    /**
     * Vetor que representa 29 dias
     */
    int[] dias_29 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    
    /**
     * Vetor que representa 30 dias
     */
    int[] dias_30 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    
    /**
     * Vetor que representa 31 dias
     */
    int[] dias_31 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

    /**
     * Objeto selecionado
     */
    private transient Object selectedItem;
    
    /**
     * Opção
     */
    private int opcao;

    /**
     * Construtor de objetos do tipo ModelComboBoxDias com o parametro opção
     * 
     * @param opcao opção
     */
    public ModelComboBoxDias(int opcao) {
        this.opcao = opcao;
    }

    /**
     * Devolve o tamanho dos vetores que representam dias dependendo da opção selecionda
     * 
     * @return tamanho dos vetores que representam dias dependendo da opção selecionda
     */
    @Override
    public int getSize() {
        switch (this.opcao) {
            case 28:
                return dias_28.length;
            case 29:
                return dias_29.length;
            case 30:
                return dias_30.length;
            case 31:
                return dias_31.length;
            default:
                return 31;
        }
    }

    /**
     * Devolve um elemento dos vetores que representam dias dependendo da opção 
     * selecionada
     * 
     * @param index posição do elemento
     * @return elemento dos vetores que representam dias dependendo da opção 
     * selecionada
     */
    @Override
    public Object getElementAt(int index) {
        switch (this.opcao) {
            case 28:
                return dias_28[index];
            case 29:
                return dias_29[index];
            case 30:
                return dias_30[index];
            case 31:
                return dias_31[index];
            default:
                return null;
        }
    }

    /**
     * Modifica o item selecionado
     * 
     * @param anItem item selecionado
     */
    @Override
    public void setSelectedItem(Object anItem) {
        switch (this.opcao) {
            case 28:
                selectedItem = (Integer) anItem;
            case 29:
                selectedItem = (Integer) anItem;
            case 30:
                selectedItem = (Integer) anItem;
            case 31:
                selectedItem = (Integer) anItem;
            default:

        }
    }

    /**
     * Devolve o item selecionado
     * 
     * @return item selecionado
     */
    @Override
    public Object getSelectedItem() {
        switch (this.opcao) {
            case 28:
                return selectedItem;
            case 29:
                return selectedItem;
            case 30:
                return selectedItem;
            case 31:
                return selectedItem;
            default:
                return null;
        }
    }
}
