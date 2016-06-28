package lapr.project.exceptions;

/**
 * Exceção a ser lançada quando o username introduzido é inválido
 *
 * @author G29
 */
public class InvalidUsernameException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo InvalidUsernameException sem parametros
     */
    public InvalidUsernameException() {
        super();
    }

    /**
     * Construtor de objetos do tipo InvalidUsernameException com o paramentro
     * mensagme
     *
     * @param s - Mensagem a passar a esta exceção explicando o erro
     */
    public InvalidUsernameException(String s) {
        super(s);
    }
}
