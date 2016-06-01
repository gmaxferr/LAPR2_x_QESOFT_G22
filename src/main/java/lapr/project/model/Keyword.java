package lapr.project.model;

import java.io.Serializable;

/**
 * Keyword.
 *
 * @author Ricardo Catalao
 */
public class Keyword implements Serializable {

    /**
     * Valor da keyword.
     */
    private String value;

    /**
     * Construtor por defeito.
     */
    public Keyword() {
        value = "";
    }

    /**
     * Construtor com parâmetros.
     *
     * @param keyword - valor da keyword
     */
    public Keyword(String keyword) {
        this.value = keyword;
    }

    /**
     * @return Devolve o valor desta keyword
     */
    public String getValue() {
        return value;
    }

    /**
     * Modifica o valor desta keyword.
     *
     * @param keyword keyword a atribuir
     */
    public void setValue(String keyword) {
        this.value = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Keyword) {
            if (o == this) {
                return true;
            } else {
                Keyword obj = (Keyword) o;
                return obj.value.equals(this.value);
            }
        }
        return false;
    }
}
