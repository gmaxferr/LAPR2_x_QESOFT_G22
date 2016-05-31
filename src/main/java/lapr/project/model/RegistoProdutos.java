package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de um registo de produtos.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class RegistoProdutos implements Serializable {

    /**
     * Lista de produtos
     */
    private List<Produto> listaProdutos;

    /**
     * Contrutor de objetos do tipo RegistoProdutos sem parâmetros.
     */
    public RegistoProdutos() {
        this.listaProdutos = new ArrayList<>();
    }

    /**
     * Modifica a lista de produtos.
     *
     * @param listaProdutos lista de produtos.
     */
    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    /**
     * Devolve a lista de produtos
     *
     * @return lista de produtos
     */
    public List<Produto> getListaProdutos() {
        return this.listaProdutos;
    }

    /**
     * Cria e devolve um objecto do tipo Produto.
     *
     * @param nome nome do produto a ser criado.
     *
     * @return novo produto criado.
     */
    public Produto criarProduto(String nome) {
        return new Produto(nome);
    }

    /**
     * Adiciona um produto à lista de produtos se este for válido.
     *
     * @param produto produto a ser adicionado à lista de produtos.
     * @return true se adicionar o produto à lista de produtos. Caso contrário
     * retorna false.
     */
    public boolean adicionaProduto(Produto produto) {
        boolean b = validarProduto(produto);
        if (b == true) {
            this.listaProdutos.add(produto);
        }
        return b;
    }

    /**
     * Valida um produto.
     *
     * @param produtoCriado produto a validar.
     * @return true se não encontrar o produto na lista de produtos. Caso
     * contrário retorna false.
     */
    private boolean validarProduto(Produto produtoCriado) {
        for (Produto produto : this.listaProdutos) {
            if (produtoCriado.equals(produto)) {
                return false;
            }
        }
        return true;
    }

}
