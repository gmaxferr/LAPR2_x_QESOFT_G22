package exceptions;

/**
 * Exceção para lidar com situações em que se necessita a introdução de um
 * e-mail e o mesmo é intergralmente inválido
 *
 * @author Ricardo Catalao
 */
public class InvalidUsernameException extends IllegalArgumentException {

	/**
	 * Construtor por defeito
	 */
	public InvalidUsernameException() {
	}

	/**
	 * Construtor com mensagem
	 *
	 * @param s - Mensagem a passar a esta exceção explicando o erro
	 */
	public InvalidUsernameException(String s) {
		super(s);
	}
}
