package lapr.project.exceptions;

/**
 * Exceção a ser lançada quando o email é inválido
 *
 * @author G29
 */
public class InvalidEmailException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo InvalidEmailException sem parametros
     */
    public InvalidEmailException() {
        super();
    }

    /**
     * Construtor de objetos do tipo InvalidEmailException com o parametro
     * mensagem
     *
     * @param s - Mensagem a ser associada a esta exceção explicando o erro
     */
    public InvalidEmailException(String s) {
        super(s);
    }
}
