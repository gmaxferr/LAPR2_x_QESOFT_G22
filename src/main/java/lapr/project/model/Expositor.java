package lapr.project.model;

import java.io.Serializable;

/**
 * Representação de um expositor.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class Expositor implements Cargo, Serializable {

    /**
     * Utilizador por detrás do papel de Expositor.
     */
    private Utilizador utilizador;

    /**
     * Construtor de objetos do tipo Expositor recebendo como parâmetro o
     * Utilizador que dá origem a um expositor.
     *
     * @param utilizador utilizador que passa a ser reconhecido como expositor.
     */
    public Expositor(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve o nome do expositor.
     *
     * @return nome do expositor.
     */
    public String getNome() {
        return this.utilizador.getNome();
    }

    /**
     * Devolve o username do expositor.
     *
     * @return username do expositor.
     */
    public String getUsername() {
        return this.utilizador.getUsername();
    }

    /**
     * Devolve o utilizador por detrás do papel de expositor.
     *
     * @return utilizador por detrás do papel de expositor,
     */
    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    /**
     * Devolve a descrição textual do expositor.
     *
     * @return caraterísticas do expositor.
     */
    @Override
    public String toString() {
        return "Exp: " + this.getUsername();
    }

    /**
     * Compara o expositor a outro objecto passado por parâmetro. A comparação
     * entre dois expositores é feita com atenção a todos os atributos destes.
     *
     * @param obj objecto a comparar com o Expositor
     * @return true se o objeto recebido representar um expositor equivalente ao
     * expositor. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }
        Expositor expositor = (Expositor) obj;
        if (expositor.getNome().equalsIgnoreCase(this.getNome())) {
            return true;
        } else {
            return false;
        }
    }

}
