package lapr.project.utils;

import lapr.project.model.*;
import java.util.*;

/**
 *
 * @author j040_
 */
public class Utilitarios {

    /**
     * Autentica o utilizador sabendo o username e a password e depois disso
     * estar concluido, limpa todos os caracteres da password, colocando todos
     * os valores a 0, para uma maior segurança.
     *
     * @param username Username do utilizador a autenticar
     * @param password Password do utilizador a autenticar
     * @param centroExposicoes
     * @return Retorna o username cujo username e password correspondem com
     * aqueles passados como argumentos, ou null caso nao se encontre um
     * utilizador no sistema com essa informação
     */
    public static Utilizador autenticacao(String username, char[] password, CentroExposicoes centroExposicoes) {
        List<Utilizador> userList = centroExposicoes.getRegistoUtilizadores().getListaUtilizadores();
        Utilizador utilizador = null;
        for (Utilizador user : userList) {
            if (user.getStrUsername().equals(username)) {
                if (user.isValidPassword(password)) {
                    utilizador = user;
                }
                break;
            }
        }
        for (int i = 0; i < password.length; i++) {
            password[i] = 0;
        }
        return utilizador;
    }
    
}
