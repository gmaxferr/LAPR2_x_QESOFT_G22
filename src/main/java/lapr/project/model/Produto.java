package lapr.project.model;

/**
 * Representação de um produto
 *
 * @author Ricardo Osório Ana Leite
 */
public class Produto {

    /**
     * Atributo m_nome do produto
     */
    private String m_nome;

    /**
     * Construtor de objectos do tipo Produto com parametro m_nome
     *
     * @param nome m_nome do produto
     */
    public Produto(String nome) {
        this.m_nome = nome;
    }

    /**
     * Construtor de objectos do tipo Produto sem parametros
     */
    public Produto() {

    }

    /**
     * Devolve o atributo m_nome de rganizador
     * 
     * @return m_nome de organizador;
     */
    public String getNome() {
        return m_nome;
    }
    
    /**
     * Define um novo m_nome de organizador
     * 
     * @param nome novo m_nome de organizador
     */
    public void setNome(String nome) {
        this.m_nome = nome;
    }
}
