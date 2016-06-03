package classesModelERegistodePPROG;

import java.io.Serializable;

/**
 * Representação de um Organizador.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class Organizador implements Cargo, Serializable {

    /**
     * Utilizador por detrás do papel de organizador, a partir do qual é criado
     * o organizador.
     */
    private Utilizador utilizador;

    /**
     * Construtor de objetos do tipo Organizador recebendo o utilizador a ser
     * promovido a este papel.
     *
     * @param utilizador utilizador a partir do qual é criado o organizador.
     */
    public Organizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve o username do organizador.
     *
     * @return username do organizador.
     */
    public String getUsername() {
        return this.utilizador.getUsername();
    }

    /**
     * Devolve o utilizador por detrás do papel de Organizador.
     *
     * @return utilizador associado a este papel.
     */
    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    /**
     * Devolve a descrição textual do organizador.
     *
     * @return caraterísticas do organizador.
     */
    @Override
    public String toString() {
        return "Org: " + this.getUsername();
    }

    /**
     * Compara o organizador a outro objecto passado por parametro. A comparação
     * entre dois organizadores é feita com atenção a todos os atributos destes.
     *
     * @param obj objecto a comparar com o organizador.
     * @return true se o objeto recebido representar um organizador equivalente
     * ao organizador. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }
        Organizador o = (Organizador) obj;
        if (this.getUtilizador().equals(o.getUtilizador())) {
            return true;
        } else {
            return false;
        }
    }
}
