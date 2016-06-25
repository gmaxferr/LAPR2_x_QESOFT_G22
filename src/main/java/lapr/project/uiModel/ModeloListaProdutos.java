package lapr.project.uiModel;
import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.ListaProdutos;
import lapr.project.model.Produto;

/**
 * Representação de um Modelo Lista de Produtos.
 * 
 * @author G29
 */
public class ModeloListaProdutos extends AbstractListModel {

    /**
     * Lista de produtos
     */
    private transient ListaProdutos m_listaProdutos;

    /**
     * Construtor de obejtos do tipo ModeloListaProdutos sem parametros
     */
    public ModeloListaProdutos() {
        this.m_listaProdutos = new ListaProdutos();
    }
    
    /**
     * Construtor de obejtos do tipo ModeloListaProdutos com o parametros
     * lista de produtos
     * 
     * @param listaProdutos lista de produtos
     */
    public ModeloListaProdutos(ListaProdutos listaProdutos) {
        this.m_listaProdutos = listaProdutos;
    }

    /**
     * Devolve o tamanho da lista de produtos
     * 
     * @return      * Devolve o tamanho da lista de produtos     * @return 

     */
    @Override
    public int getSize() {
        return this.m_listaProdutos.getSize();
    }

    /**
     * Devolve um produto
     * 
     * @param index posição do produto
     * @return produto na posição index da lista
     */
    @Override
    public Object getElementAt(int index) {
        return this.m_listaProdutos.getProdutoAt(index).getNome();
    }

    /**
     * Adiciona um produto à lista de produtos
     * 
     * @param nome nome do produto a adicionar
     * @return true se o produto foi adicionado. Caso contrário retorna false
     */
    public boolean addProduto(String nome) {
        boolean b = this.m_listaProdutos.addProduto(nome);
        if (b) {
            fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        }
        return b;
    }

    /**
     * Remove um produto da lista de produtos
     * @param nome nome do produto a remover
     */
    public void removeProduto(String nome) {
        int index = this.m_listaProdutos.removeProduto(nome);
        fireIntervalRemoved(this, index, index);
    }

    /**
     * Devolve a lista de produtos
     * 
     * @return lista de produtos
     */
    public List<Produto> getListaProdutos() {
        return this.m_listaProdutos.getListaProdutos();
    }

}
