package lapr.project.exceptions;

/**
 *
 * @author Ricardo Catalao
 */
public class InvalidPasswordException extends IllegalArgumentException {
	/**
	 * Construtor por defeito
	 */
	public InvalidPasswordException() {
            super();
	}

	/**
	 * Construtor com mensagem
	 *
	 * @param s - Mensagem a passar a esta exceção explicando o erro
	 */
	public InvalidPasswordException(String s) {
		super(s);
	}
}
