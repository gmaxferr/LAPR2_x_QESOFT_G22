package lapr.project.exceptions;

/**
 * Exceção a ser lançada quando não há valores suficientes para criar uma 
 * distribuição normal
 * 
 * @author G29
 */
public class InsufficientNumberOfElementsForNormalDistributionException extends IllegalArgumentException {

    /**
     * Construtor de objetos do tipo InsufficientNumberOfElementsForNormalDistributionException
     * sem parametros
     */
    public InsufficientNumberOfElementsForNormalDistributionException() {
        super("Não existem valores suficientes para ser possível criar uma distribuição normal.");
    }
    
    /**
     * Construtor de objetos do tipo InsufficientNumberOfElementsForNormalDistributionException
     * com o paramentro mensagem
     * 
     * @param s mensagem de erro
     */
    public InsufficientNumberOfElementsForNormalDistributionException(String s){
        super(s);
    }
}
