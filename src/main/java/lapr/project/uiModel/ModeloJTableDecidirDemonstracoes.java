package lapr.project.uiModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.Demonstracao;

/**
 * Representação de um ModeloJTableDecidirDemonstracoes
 * 
 * @author G29
 */
public class ModeloJTableDecidirDemonstracoes extends AbstractTableModel {

    /**
     * Lista de demonstrações
     */
    private transient List<Demonstracao> listaDemos;
    
    /**
     * Vetor de decisões
     */
    private final boolean[] decisoes;
    
    /**
     * Vetor do cabeçalho
     */
    private final String[] cabecalho = {"Demonstração", "Demonstrações confirmadas"};

    /**
     * Construtor de objetos do tipo ModeloJTableDecidirDemonstracoes com os 
     * paramentros lista de demosntrações e o vetor das decisões
     * 
     * @param lstDemos lista de demosntrações
     * @param decisoes vetor das decisões
     */
    public ModeloJTableDecidirDemonstracoes(List<Demonstracao> lstDemos, boolean[] decisoes) {
        this.listaDemos = lstDemos;
        this.decisoes = decisoes;
    }

    /**
     * Verifica o tamnho da coluna
     * 
     * @param rowIndex numero da linha
     * @param columnIndex numero da coluna
     * @return true se o tamanho da coluna for igual a 1.Caso contrário retorna 
     * false
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devolve o tamnaho da lista de demonstrações
     * 
     * @return tamnaho da lista de demonstrações
     */
    @Override
    public int getRowCount() {
        if (this.listaDemos == null) {
            return 0;
        }
        return this.listaDemos.size();
    }

    /**
     * Devolve o tamanho do cabeçalho
     * 
     * @return tamanho do cabeçalho
     */
    @Override
    public int getColumnCount() {
        return cabecalho.length;
    }

    /**
     * Retorna algo dependendo do numero da coluna
     * 
     * @param rowIndex numero da linha
     * @param columnIndex numero da coluna
     * @return algo dependendo do numero da coluna (to String da lista de 
     * demonstrações ou o vetor das decisões)
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaDemos.toString();
            case 1:
                return this.decisoes;
            default:
                return null;
        }
    }

}
