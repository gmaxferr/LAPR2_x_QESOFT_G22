package lapr.project.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.Utilizador;

/**
 * Representação de um Modelo JTable da Distribuição de FAE
 *
 * @author Ricardo Osório e Ana Leite
 */
public class ModeloJTableUtilizadores extends AbstractTableModel {

    private List<Utilizador> listaUsers;

    private final String[] colunas = {"Nome", "Username", "Email"};

    public ModeloJTableUtilizadores(List<Utilizador> listaUsers) {
        this.listaUsers = listaUsers;
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
        if (this.listaUsers == null) {
            return 0;
        }
        return this.listaUsers.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
            default:
        }
    }

}
