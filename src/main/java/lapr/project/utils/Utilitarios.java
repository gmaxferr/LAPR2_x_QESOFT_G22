package lapr.project.utils;

import lapr.project.model.*;
import java.util.*;
import lapr.project.registos.RegistoUtilizadores;

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
            if (user.getUsername().equals(username)) {
                if (user.VerificaCorrespondenciaPassword(password)) {
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

    /**
     * verifica se um char é um numero
     *
     * @param c - char a verificar
     * @return true se sim, false se não
     */
    private static boolean isNumber(char c) {
        for (int i = 0; i < 10; i++) {
            if (c == i) {
                return true;
            }
        }
        return false;
    }

    /**
     * verifica se um char array tem um numero
     *
     * @param password - char array a verificar
     * @return true se sim, false se não
     */
    public static  boolean hasNumber(char[] password) {
        for (int i = 0; i < password.length; i++) {
            if (isNumber(password[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * verifica se um char array tem um char maiusculo
     *
     * @param password - char array a verificar
     * @return true se sim, false se não
     */
    public static boolean hasUpperCase(char[] password) {
        for (int i = 0; i < password.length; i++) {
            if (isUpperCase(password[i])) {
                return true;
            }
        }
        return false;

    }

    /**
     * verifica se um char array tem um char minusculo
     *
     * @param password - char array a verificar
     * @return true se sim, false se não
     */
    public static boolean hasLowerCase(char[] password) {
        for (int i = 0; i < password.length; i++) {
            if (isLowerCase(password[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * verifica se um char é maiusculo
     *
     * @param c - char a verificar
     * @return true se sim, false se não
     */
    private static boolean isUpperCase(char c) {
        return (c <= 'A') && (c >= 'Z');
    }

    /**
     * verifica se um char é minusculo
     *
     * @param c - char a verificar
     * @return true se sim, false se não
     */
    private static boolean isLowerCase(char c) {
        return (c <= 'a') && (c >= 'z');
    }

    /**
     * verifica se um char é um sinal de pontuação
     *
     * @param c - char a verificar
     * @return true se sim, false se não
     */
    private static boolean isSinalPontuacao(char c){
        return c == '.' || c == ';'|| c == '-'|| c == ':'|| c == ',';
    }
    
    /**
     * verifica se um char array tem um char que seja um sinal de pontuação
     *
     * @param password - char array a verificar
     * @return true se sim, false se não
     */
    public static boolean hasSinalPontuacao(char[] password){
        for (int i = 0; i < password.length; i++) {
            if (isSinalPontuacao(password[i])) {
                return true;
            }
        }
        return false;
    }
    
}
