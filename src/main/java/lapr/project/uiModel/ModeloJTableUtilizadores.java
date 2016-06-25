package lapr.project.uiModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.Utilizador;

/**
 * Representação de um Modelo JTable da Distribuição de FAE
 *
 * @author G29
 */
public class ModeloJTableUtilizadores extends AbstractTableModel {

    /**
     * Lista de utilizadores
     */
    private transient List<Utilizador> listaUsers;

    /**
     * Vetor com o nome, username e email
     */
    private final String[] colunas = {"Nome", "Username", "Email"};

    /**
     * Construtor de objetos do tipo ModeloJTableUtilizadores com o parametro
     * lista de utilizadores
     * 
     * @param listaUsers lista de utilizadores
     */
    public ModeloJTableUtilizadores(List<Utilizador> listaUsers) {
        this.listaUsers = listaUsers;
    }

    /**
     * Construtor de objetos do tipo ModeloJTableUtilizadores sem parametros
     */
    public ModeloJTableUtilizadores() {

    }

    /**
     * Modifica a lista de utilizadore
     * 
     * @param listaFae nova lista de utilizadores
     */
    public void setLista(List<Utilizador> listaFae) {
        this.listaUsers = listaFae;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Devolve o numero de colunas
     * 
     * @param column numero de colunas
     * @return numero de colunas
     */
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    /**
     * Adiciona um utilizador à lista de utilizadore
     * 
     * @param utilizador utilizador a ser adicionado
     */
    public void addUtilizador(Utilizador utilizador) {
        this.listaUsers.add(utilizador);
    }

    /**
     * Devolve o numero de linhas 
     * 
     * @return numero de linhas  
     */
    @Override
    public int getRowCount() {
        if (this.listaUsers == null) {
            return 0;
        }
        return this.listaUsers.size();
    }

    /**
     * Devolve o numero de colunas
     * 
     * @return numero de colunas
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Devolve a posição da linha
     * 
     * @param rowIndex posição da linha
     * @param columnIndex posição da coluna
     * @return posição da linha 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaUsers.get(rowIndex).getNome();
            case 1:
                return this.listaUsers.get(rowIndex).getUsername();
            default:
                return this.listaUsers.get(rowIndex).getEmail();
        }
    }

}
