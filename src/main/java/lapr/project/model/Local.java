package lapr.project.model;

import java.io.Serializable;

/**
 * Representação de um local.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class Local implements Serializable {

    /**
     * Morada do local.
     */
    private String morada;

    /**
     * Construtor de objetos do tipo Local com o parâmetro morada.
     *
     * @param morada morada do local.
     */
    public Local(String morada) {
        this.morada = morada;
    }

    /**
     * Devolve a morada do local.
     *
     * @return morada do local.
     */
    public String getMorada() {
        return this.morada;
    }

    /**
     * Devolve a descrição textual do local.
     *
     * @return caraterísticas do local.
     */
    @Override
    public String toString() {
        return this.morada;
    }
}
