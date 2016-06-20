package lapr.project.ui.model;
import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.ListaProdutos;
import lapr.project.model.Produto;

/**
 * Representação de um Modelo Lista de Produtos.
 * 
 * @author Ricardo Osório e Ana Leite
 */
public class ModeloListaProdutos extends AbstractListModel {

    private transient ListaProdutos m_listaProdutos;

    public ModeloListaProdutos() {
        this.m_listaProdutos = new ListaProdutos();
    }
    public ModeloListaProdutos(List<Produto> m_listaProdutos) {
        this.m_listaProdutos = this.m_listaProdutos;
    }

    @Override
    public int getSize() {
        return this.m_listaProdutos.getSize();
    }

    @Override
    public Object getElementAt(int index) {
        return this.m_listaProdutos.getProdutoAt(index).getNome();
    }

    public boolean addProduto(String nome) {
        boolean b = this.m_listaProdutos.addProduto(nome);
        if (b) {
            fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        }
        return b;
    }

    public void removeProduto(String nome) {
        int index = this.m_listaProdutos.removeProduto(nome);
        fireIntervalRemoved(this, index, index);
    }

    public List<Produto> getListaProdutos() {
        return this.m_listaProdutos.getListaProdutos();
    }

}
