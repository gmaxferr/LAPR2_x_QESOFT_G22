package lapr.project.exceptions;

/**
 * Exceção a ser lançada quando o dia é inválido
 * 
 * @author G29
 */
public class DiaInvalidoException extends IllegalArgumentException {

    /**
     * Consturor de objetos do tipo DiaInvalidoException sem parametros
     */
    public DiaInvalidoException() {
        super("Dia é inválido!!");
    }

    /**
     * Consturor de objetos do tipo DiaInvalidoException com o parametro
     * mensagem
     * 
     * @param mensagem mensagem de erro
     */
    public DiaInvalidoException(String mensagem) {
        super(mensagem);
    }

}
