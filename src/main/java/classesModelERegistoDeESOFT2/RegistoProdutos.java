package classesModelERegistoDeESOFT;

import java.util.ArrayList;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class RegistoProdutos {
    
     /**
     * Atributo produtos a expor de Candidatura
     */
    private ArrayList<Produto> ProdutosExpor;
    
    public RegistoProdutos(){
        ProdutosExpor = new ArrayList<>();
    }
    /**
     * Método que cria um novo produto à Candidatura
     * 
     * @param nome novo produto associado à Candidatura
     * 
     * @return produto criado
     */
    public Produto criarProduto(String nome) {
        Produto produto=new Produto(nome);
        ProdutosExpor.add(produto);
        return produto;
    }
     /**
     * Método que valida e adiciona um novo produto
     * 
     * @param produto produto a ser validado e adicionado
     */
    public void adicionaProduto(Produto produto){
        validaProduto(produto);
        addProduto(produto);
    }
    
    /**
     * Método que adiciona um produto de Candidatura
     * 
     * @param p produto a ser adicionado
     */
    public void addProduto(Produto p) {
        this.ProdutosExpor.add(p);
    }
    
    /**
     * Método que valida produto de Candidatura recebendo-o como parametro
     * 
     * @param produto produto a ser validado
     */
    public void validaProduto(Produto produto) {

        if (validarDadosRepetidosOuInvalidos() == false) {
            //remove os dados introduzidos anteriormente por estarem repetidos ou invalidos
        }

    }
    
    /**
     * Método que valida os dados repetidos pu invalidos de Candidatura
     * 
     * @return boolean com a confirmação da validação
     */
    public boolean validarDadosRepetidosOuInvalidos() {
        return true;
    }
}
