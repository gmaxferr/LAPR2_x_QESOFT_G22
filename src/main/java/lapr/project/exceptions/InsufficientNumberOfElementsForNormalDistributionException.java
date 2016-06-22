package lapr.project.exceptions;

/**
 *
 * @author Ricardo Catalao
 */
public class InsufficientNumberOfElementsForNormalDistributionException extends IllegalArgumentException {

    public InsufficientNumberOfElementsForNormalDistributionException() {
        super("Não existem valores suficientes para ser possível criar uma distribuição normal.");
    }
    
    public InsufficientNumberOfElementsForNormalDistributionException(String s){
        super(s);
    }
}
