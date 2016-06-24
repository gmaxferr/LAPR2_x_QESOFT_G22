package lapr.project.exceptions;

/**
 * Exceção a ser lançada quando a password é inválida
 *
 * @author G29
 */
public class InvalidPasswordException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo InvalidPasswordException sem parametros
     */
    public InvalidPasswordException() {
        super();
    }

    /**
     * Construtor de objetos do tipo InvalidPasswordException com o parametro
     * mensagem
     *
     * @param s - Mensagem a passar a esta exceção explicando o erro
     */
    public InvalidPasswordException(String s) {
        super(s);
    }
}
