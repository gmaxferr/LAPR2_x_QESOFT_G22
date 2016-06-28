package lapr.project.exceptions;

/**
 * Exceção a ser lançada quando o numero de keywords introduzidas não é válido
 * 
 * @author G29
 */
public class KeywordsErradasException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo KeywordErradasException sem paramentros
     */
    public KeywordsErradasException() {
        super("O número de keywords introduzidas não é válido!");
    }

    /**
     * Construtor de objetos do tipo KeywordErradasException com o parametro 
     * mensagem
     * 
     * @param mensagem mensagem de erro
     */
    public KeywordsErradasException(String mensagem) {
        super(mensagem);
    }
}
