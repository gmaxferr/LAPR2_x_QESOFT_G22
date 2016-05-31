package lapr.project.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.FAE;

/**
 * Representação de um Modelo JTable da Distribuição de FAE
 *
 * @author Ricardo Osório e Ana Leite
 */
public class ModeloJTableDistribuicaoFAE extends AbstractTableModel {

    private List<FAE> listaFAE;

    private final String[] colunas = {"Nome", "Username", "Email"};

    public ModeloJTableDistribuicaoFAE() {
    }

    public void setLista(List<FAE> listaFAE) {
        this.listaFAE = listaFAE;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        if (this.listaFAE == null) {
            return 0;
        }
        return this.listaFAE.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaFAE.get(rowIndex).getUtilizador().getNome();
            case 1:
                return this.listaFAE.get(rowIndex).getUtilizador().getUsername();
            default:
                return this.listaFAE.get(rowIndex).getUtilizador().getEmail();
        }
    }

}
