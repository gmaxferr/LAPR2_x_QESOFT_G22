package lapr.project.exceptions;

/**
 * Exceção a ser lançada quando o mes é inválido
 * 
 * @author G29
 */
public class MesInvalidoException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo MesInvalidoException sem parametros
     */
    public MesInvalidoException() {
        super("Mês é inválido!!");
    }
    
    /**
     * Construtor de objetos do tipo MesInvalidoException com o paramentro 
     * mensagem
     * 
     * @param mensagem mensagem de erro
     */
    public MesInvalidoException(String mensagem) {
        super(mensagem);
    }

}
