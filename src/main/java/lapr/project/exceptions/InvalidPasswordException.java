/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Ricardo Catalao
 */
public class InvalidPasswordException extends IllegalArgumentException {
	/**
	 * Construtor por defeito
	 */
	public InvalidPasswordException() {
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
