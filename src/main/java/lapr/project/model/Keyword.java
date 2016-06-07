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
    private String m_value;

    /**
     * Construtor por defeito.
     */
    public Keyword() {
        m_value = "";
    }

    /**
     * Construtor com parâmetros.
     *
     * @param keyword - valor da keyword
     */
    public Keyword(String keyword) {
        this.m_value = keyword;
    }

    /**
     * @return Devolve o valor desta keyword
     */
    public String getValue() {
        return m_value;
    }

    /**
     * Modifica o valor desta keyword.
     *
     * @param keyword keyword a atribuir
     */
    public void setValue(String keyword) {
        this.m_value = keyword;
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
                return obj.m_value.equals(this.m_value);
            }
        }
        return false;
    }
}
