package lapr.project.model;

import java.util.*;

/**
 * Representação de uma lista de produtos.
 *
 * @author G29
 */
public class ListaProdutos {

    /**
     * Lista de produtos.
     */
    List<Produto> m_listaProdutos;

    /**
     * Construtor de objetos do tipo ListaProdutos sem parâmetros
     */
    public ListaProdutos() {
        this.m_listaProdutos = new ArrayList<>();
    }

    /**
     * Devolve a lista de produtos.
     *
     * @return lista de produtos.
     */
    public List<Produto> getListaProdutos() {
        return this.m_listaProdutos;
    }

    /**
     * Devolve o tamanho da lista de produtos.
     *
     * @return tamanho da lista de produtos.
     */
    public int getSize() {
        return this.m_listaProdutos.size();
    }

    /**
     * Devolve a lista de produtos pela posição.
     *
     * @param index posição do produto
     * @return lista de produtos.
     */
    public Produto getProdutoAt(int index) {
        return this.m_listaProdutos.get(index);
    }

    /**
     * Adiciona um produto à lista de produtos.
     *
     * @param nome nome do produto a ser adicionado.
     * @return true caso o produto seja adicionado à lista de produtos. Caso
     * contrário retona false.
     */
    public boolean addProduto(String nome) {
        if (validaProduto(nome)) {
            this.m_listaProdutos.add(new Produto(nome));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida o produto a ser adicionado
     *
     * @param nome nome do produto a ser adicionado.
     * @return true se não encontrar o produto na lista de produtos. Caso
     * contrário retorna false.
     */
    private boolean validaProduto(String nome) {
        for (Produto produto : this.m_listaProdutos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove o produto.
     *
     * @param nome nome do produto a ser removido.
     * @return posição do produto removido.
     */
    public int removeProduto(String nome) {
        int index = localizarProduto(nome);
        this.m_listaProdutos.remove(index);
        return index;
    }

    /**
     * Localiza o produto através do nome.
     *
     * @param nome nome do produto.
     * @return posição do produto a remover. Caso não encontre o produto retorna
     * -1.
     */
    private int localizarProduto(String nome) {
        for (int i = 0; i < this.m_listaProdutos.size(); i++) {
            if (this.m_listaProdutos.get(i).getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

}
