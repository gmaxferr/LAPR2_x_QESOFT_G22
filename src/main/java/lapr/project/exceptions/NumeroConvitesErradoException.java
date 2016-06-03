package lapr.project.exceptions;

/**
 * Exceção a ser lançada quando o número de convites (ao criar a candidatura)
 * não é válido
 *
 * @author Ricardo Osório e Ana Leite
 */
public class NumeroConvitesErradoException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo NumeroConvitesErradoException com a
     * mensagem a ser dado ao utilizador do sistema
     *
     * @param mensagem mensagem de erro.
     */
    public NumeroConvitesErradoException(String mensagem) {
        super(mensagem);
    }
}