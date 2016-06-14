package lapr.project.exceptions;

/**
 * Exceção para lidar com situações em que se necessita a introdução de um
 * e-mail e o mesmo é intergralmente inválido
 *
 * @author Ricardo Catalao
 */
public class InvalidEmailException extends IllegalArgumentException {

	/**
	 * Construtor por defeito
	 */
	public InvalidEmailException() {
            super();
	}

	/**
	 * Construtor com mensagem
	 *
	 * @param s - Mensagem a ser associada a esta exceção explicando o erro
	 */
	public InvalidEmailException(String s) {
		super(s);
	}
}
