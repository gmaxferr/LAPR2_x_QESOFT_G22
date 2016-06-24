package lapr.project.exceptions;

/**
 * Representa a exceção a ser lançada quando a área (ao criar candidatura) não é
 * válida
 *
 * @author RG29
 */
public class AreaErradaException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo AreaErradaException com a mensagem a ser
     * dado ao utilizador do sistema
     *
     * @param mensagem mensagem de erro.
     */
    public AreaErradaException(String mensagem) {
        super(mensagem);
    }
}