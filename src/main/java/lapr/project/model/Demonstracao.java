package lapr.project.model;

import java.io.Serializable;

/**
 * Representação de uma demonstração.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class Demonstracao implements Serializable{

    /**
     * Código de identificação da demonstração.
     */
    private String codigoIdentificacao;
    
    /**
     * Descrição da demonstração.
     */
    private String descricao;
    
    /**
     * Registo de recursos da demonstração.
     */
    private RegistoRecursos rr;

    /**
     * Descrição da demonstração por omissão.
     */
    private static final String DESCRICAO_POR_OMISSAO = "Nenhuma descrição definida.";

    /**
     * Prefixo de identificação da demonstração.
     */
    private static final String PREFIXO_IDENTIFICACAO = "Demo_";

    /**
     * Construtor de objetos do tipo Demonstração com os parâmetros demonstração 
     * e o contador das demonstrações.
     * 
     * @param demonstracao demonstração.
     * @param contadorDemonstracoes contador das demonstrações.
     */
    public Demonstracao(Demonstracao demonstracao, int contadorDemonstracoes) {
        this.descricao = demonstracao.descricao;
        this.rr = demonstracao.rr;
        this.codigoIdentificacao = PREFIXO_IDENTIFICACAO + contadorDemonstracoes;
    }

    /**
     * Construtor de objetos do tipo Demonstracao com o parâmetro descrição.
     *
     * @param descricao descrição da demonstração.
     */
    public Demonstracao(String descricao) {
        this.rr = new RegistoRecursos();
        this.descricao = descricao;
    }

    /**
     * Construtor de objetos do tipo Demonstração sem parâmetros.
     */
    public Demonstracao() {
        this.rr = new RegistoRecursos();
        this.descricao = DESCRICAO_POR_OMISSAO;
    }

    /**
     * Devolve o registo de recursos da demonstração.
     * 
     * @return resgisto de recursos da demonstração.
     */
    public RegistoRecursos getRegistoRecursos() {
        return this.rr;
    }

    /**
     * Devolve o código de identificação da demonstração.
     * 
     * @return código de identificação da demonstração.
     */
    public String getCodigoIdentificacao() {
        return this.codigoIdentificacao;
    }
    
    /**
     * Devolve a descrição da demonstração.
     * 
     * @return descrição da demonstração.
     */
    public String getDescricao(){
        return this.descricao;
    }
}
