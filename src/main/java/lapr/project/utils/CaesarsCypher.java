package lapr.project.utils;

/**
 * Cifra de César: Permite codificar ou descodificar arrays de caracteres usando
 * o algoritmo de César.<!-- -->Para não ser possível visualizar a password real
 * de um utilizador tendo accesso ao local da memoria onde esta se encontra
 * guardada, utiliza-mos um processo de encriptação que permite armazenar dita
 * password encriptada, dificultando a visuaçização da password real através do
 * ficheiro onde está guardado.
 *
 * @author Ricardo Catalao
 */
public final class CaesarsCypher {

    private CaesarsCypher() {
    }

    /**
     * Encripta um array de caracteres usando a cifra de César.<!-- -->Cada
     * caracter é deslocado n {@code shifts} para a direita e, caso isso exceda
     * o valor máximo de um char, que é 255, toma em vez o valor desse excesso.
     *
     * @param arrChar Array de caracteres a encriptar
     * @param shifts Numero de casas a deslocar cada caracter
     * @param alfabet Alfabeto a ser usado na encriptação
     * @return Retorna o array de caracteres que resulta da encriptação
     */
    public static char[] encrypt(char[] arrChar, int shifts, String alfabet) {
        int size = arrChar.length;
        char[] result = new char[size];
        for (int i = 0; i < size; i++) {
            int indexOf = alfabet.indexOf(arrChar[i]);
            if (indexOf != -1) {    //Para o raro caso de haver caracteres esquesitos
                result[i] = (char) (alfabet.charAt((indexOf + shifts) % alfabet.length()));
            } else {
                result[i] = arrChar[i];
            }
        }
        return result;
    }

    /**
     * Encripta um array de caracteres usando a cifra de César.<!-- -->Cada
     * caracter é deslocado n {@code shifts} para a esquerda e, caso o resultado
     * obtido seja menor que 0, é-lhe acrescentado o valor de 256, que é o
     * tamanho da gama de valores de um caracter.
     *
     * @param arrChar Array de caracteres a encriptar
     * @param shifts Numero de casas a deslocar cada caracter
     * @param alfabet Alfabeto a ser usado na decriptação
     * @return Retorna o array de caracteres que resulta da desencriptação
     */
    public static char[] decrypt(char[] arrChar, int shifts, String alfabet) {
        int size = arrChar.length;
        char[] result = new char[size];
        for (int i = 0; i < size; i++) {
            int indexOf = alfabet.indexOf(arrChar[i]);
            if (indexOf != -1) {    //Para o raro caso de haver caracteres esquesitos
                result[i] = alfabet.charAt((indexOf + alfabet.length() - shifts) % alfabet.length());
            } else {
                result[i] = arrChar[i];
            }
        }
        return result;
    }
}
