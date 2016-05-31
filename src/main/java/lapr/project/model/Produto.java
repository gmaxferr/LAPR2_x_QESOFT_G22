package lapr.project.model;

import java.io.Serializable;

/**
 * Representação de um Produto a ser exposto numa exposição por uma empresa.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class Produto implements Serializable {

    /**
     * Nome do produto
     */
    private String nome;

    /**
     * Construtor de objetos do tipo Produto com o parametro nome.
     *
     * @param nome nome do produto.
     */
    public Produto(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o nome do produto
     *
     * @return nome do produto
     */
    public String getNome() {
        return nome;
    }

}
