package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Produto;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class RegistoProdutos {

    /**
     * Atributo produtos a expor de Candidatura
     */
    private List<Produto> m_ProdutosExpor;

    public RegistoProdutos() {
        m_ProdutosExpor = new ArrayList<>();
    }

    public List<Produto> getListaProdutosAExpor() {
        return this.m_ProdutosExpor;
    }

    @Override
    public String toString() {
        String str = "";
        for (Produto produto : this.m_ProdutosExpor) {
            str += produto.getNome() + "\n";
        }
        return str;
    }

    /**
     * Método que cria um novo produto à Candidatura
     *
     * @param nome novo produto associado à Candidatura
     *
     * @return produto criado
     */
    public Produto criarProduto(String nome) {
        Produto produto = new Produto(nome);
        m_ProdutosExpor.add(produto);
        return produto;
    }

    /**
     * Método que valida e adiciona um novo produto
     *
     * @param produto produto a ser validado e adicionado
     */
    public boolean adicionaProduto(Produto produto) {
        boolean b = validaProduto(produto);
        if (b) {
            addProduto(produto);
        }
        return b;
    }

    /**
     * Método que adiciona um produto de Candidatura
     *
     * @param p produto a ser adicionado
     */
    public void addProduto(Produto p) {
        this.m_ProdutosExpor.add(p);
    }

    /**
     * Método que valida produto de Candidatura recebendo-o como parametro
     *
     * @param produto produto a ser validado
     */
    public boolean validaProduto(Produto produto) {

        //valida produto
        return true;
    }

    /**
     * Método que valida os dados repetidos pu invalidos de Candidatura
     *
     * @return boolean com a confirmação da validação
     */
    public boolean validarDadosRepetidosOuInvalidos() {
        return true;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.m_ProdutosExpor = listaProdutos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }
        RegistoProdutos rp = (RegistoProdutos) obj;
        return this.getListaProdutosAExpor().containsAll(rp.getListaProdutosAExpor());
    }
}
