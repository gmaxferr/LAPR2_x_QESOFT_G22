package lapr.project.exceptions;

/**
 * Representa a exceção a ser lançada quando o dia é inválido 
 * 
 * @author G29
 */
public class TempoInvalidoException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo TempoInvalidoException sem paramentros
     */
    public TempoInvalidoException() {
        super("Dia é inválido!!");
    }

    /**
     * Construtor de objetos do tipo TempoInvalidoException com o parametro 
     * mensagem
     * 
     * @param mensagem mensagem de erro
     */
    public TempoInvalidoException(String mensagem) {
        super(mensagem);
    }

}
