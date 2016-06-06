package lapr.project.exceptions;

/**
 *
 * @author Ricardo Osorio
 */
public class KeywordsErradasException extends IllegalArgumentException {

    public KeywordsErradasException() {
        super("O número de keywords introduzidas não é válido!");
    }

    public KeywordsErradasException(String mensagem) {
        super(mensagem);
    }
}
