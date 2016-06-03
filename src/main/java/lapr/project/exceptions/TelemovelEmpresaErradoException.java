package lapr.project.exceptions;

/**
 * Representa a exceção a ser lançada quando o número de telemóvel (ao criar a
 * candidatura) não é válido
 *
 * @author Ricardo Osório e Ana Leite
 */
public class TelemovelEmpresaErradoException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo TelemovelEmpresaErradoException com a
     * mensagem a ser dado ao utilizador do sistema
     *
     * @param mensagem mensagem de erro
     */
    public TelemovelEmpresaErradoException(String mensagem) {
        super(mensagem);
    }
}
