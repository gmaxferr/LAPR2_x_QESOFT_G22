package lapr.project.utils;

/**
 * Cifra de Transposição em colunas.<!-- -->Permita a encriptação de arrays de
 * caracteres usando uma técnica de transposição em colunas e com auxílio de uma
 * palavra-chave.<!-- -->Esta cifra acrescenta difusão à mensagem.
 *
 * @author G29
 */
public class TransposeCypher {

    /**
     * Retorna um array de inteiros com a posição indexada dos caracteres
     * ordenados do mais pequeno para o maior.<!-- -->Ex: MEGABUCK -> 63401725
     *
     * @param charArray array de caracteres a descobrir a ordem
     * @return Retorna um array de inteiros em que cada posição sabe o lugar em
     * que deve estar, aquando da sua leitura
     */
    public static int[] getOrder(char[] charArray) {
        if (charArray.length > 0) {
            int[] result = new int[charArray.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = -1;
            }
            for (int i = 0; i < charArray.length; i++) {
                int index = 0;
                for (int j = 0; j <= i; j++) {
                    if (j == i) {
                        result[i] = index;
                    } else if (charArray[i] < charArray[j]) {
                        result[j]++;
                    } else {
                        index++;
                    }
                }
            }
            return result;
        } else {
            return new int[]{0};
        }
    }

    /**
     * Recebe como parametro um array de inteiros, cujos números em cada posição
     * indicam o seu lugar, na ordem de leitura, i.e., um array {1, 0, 2} deverá
     * ser lido o 2o elemento primeiro, depois o 1o e por fim o 3o.<!-- -->Este
     * array será então convertido por este método para um array em que cada
     * posição N APONTA para o N-ésimo elemento a ser lido.<!-- -->No caso do
     * array anterior, o resultado seria {1, 0, 2}, pois primeiro vem o 2o,
     * depois o 1o e a seguir o 3o.<!-- -->NOTA: As posições começam-se a contar
     * a partir do 0.
     *
     * @param intArray - Array de inteiros a ser convertido
     * @return - Retorna o resultado da conversão como explicado na descrição do
     * método
     */
    public static int[] convertToMask(int[] intArray) {
        int[] result = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray.length; j++) {
                if (intArray[j] == i) {
                    result[i] = j;
                    continue;
                }
            }
        }
        return result;
    }

    /**
     * Encripta, usando transposição por tabelas, uma mensagem passada como
     * argumento usando uma palavra-passe, também passada como argumento.
     *
     * @param message Mensagem a encriptar
     * @param password Palavra-passe com que encriptar a mensagem
     * @return Retorna a mensagem encriptada com a palavra-passe passada como
     * argumento
     */
    public static char[] encrypt(char[] message, char[] password) {
        char[] pwd;
        if (password.length == 0) {
            pwd = "a".toCharArray();
        } else {
            pwd = password;
        }

        int tableCol = pwd.length;
        int tableLines = message.length / pwd.length + 1;
        char[][] table = new char[tableLines][tableCol];

        int index = 0;
        char fillerChar = '~';
        for (int i = 0; i < tableLines; i++) {
            for (int j = 0; j < tableCol; j++) {
                if (index < message.length) {
                    table[i][j] = message[index];
                    index++;
                } else {
                    table[i][j] = fillerChar;
                }
            }
        }

        int[] order = getOrder(pwd);
        order = convertToMask(order);

        char[] result = new char[tableCol * tableLines];
        index = 0;
        for (int i = 0; i < tableCol; i++) {
            for (int j = 0; j < tableLines; j++) {
                result[index++] = table[j][order[i]];
            }
        }

        return result;
    }

    /**
     * Desencripta, usando transposição por tabelas, uma mensagem passada como
     * argumento usando uma palavra-passe, também passada como argumento.
     *
     * @param message Mensagem a desencriptar
     * @param password Palavra-chave de desencriptação
     * @return Retorna a mensagem desencriptada através da codificação, exceto
     * quando se verificar que a mensagem passada como parametro nao podesse ter
     * sido encriptada com a palavra-passe dada.<!-- -->Nesse caso, e apenas
     * nesse caso, retorna null.
     */
    public static char[] decrypt(char[] message, char[] password) {
        char[] pwd;
        if (password.length == 0) {
            pwd = "a".toCharArray();
        } else {
            pwd = password;
        }

        if (message.length % pwd.length != 0) {
            return null;
        }

        int tableCol = pwd.length;
        int tableLines = message.length / pwd.length;
        char[][] table = new char[tableLines][tableCol];

        int[] order = getOrder(pwd);
        order = convertToMask(order);
        int index = 0;

        for (int i = 0; i < tableCol; i++) {
            for (int j = 0; j < tableLines; j++) {
                table[j][order[i]] = message[index];
                index++;
            }
        }

        char[] uncripted = new char[tableCol * tableLines];
        index = 0;
        for (int i = 0; i < tableLines; i++) {
            for (int j = 0; j < tableCol; j++) {
                uncripted[index++] = table[i][j];
            }
        }

        int len = 0;
        for (int i = uncripted.length - 1; i >= 0; i--) {
            if (uncripted[i] != '~') {
                len = i + 1;
                break;
            }
        }

        char[] result = new char[len];
        System.arraycopy(uncripted, 0, result, 0, len);

        return result;
    }
}
