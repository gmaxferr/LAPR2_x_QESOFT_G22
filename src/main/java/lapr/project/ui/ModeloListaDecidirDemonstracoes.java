/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.Demonstracao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class ModeloListaDecidirDemonstracoes extends AbstractTableModel {

    private List<Demonstracao> listaDemos;
    private final boolean[] decisoes;
    private final String[] cabecalho = {"Demonstração", "Demonstrações confirmadas"};

    public ModeloListaDecidirDemonstracoes(List<Demonstracao> lstDemos, boolean[] decisoes) {
        this.listaDemos = lstDemos;
        this.decisoes = decisoes;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getRowCount() {
        if (this.listaDemos == null) {
            return 0;
        }
        return this.listaDemos.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho.length;
    }

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
