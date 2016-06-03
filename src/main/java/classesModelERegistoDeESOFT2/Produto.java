package classesModelERegistoDeESOFT;

/**
 * Representação de um produto
 *
 * @author Ricardo Osório Ana Leite
 */
public class Produto {

    /**
     * Atributo nome do produto
     */
    private String nome;

    /**
     * Construtor de objectos do tipo Produto com parametro nome
     *
     * @param nome nome do produto
     */
    public Produto(String nome) {
        this.nome = nome;
    }

    /**
     * Construtor de objectos do tipo Produto sem parametros
     */
    public Produto() {

    }

    /**
     * Devolve o atributo nome de rganizador
     * 
     * @return nome de organizador;
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define um novo nome de organizador
     * 
     * @param nome novo nome de organizador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
