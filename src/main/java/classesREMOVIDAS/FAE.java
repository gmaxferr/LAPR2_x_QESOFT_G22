package classesREMOVIDAS;

import java.io.Serializable;

/**
 * Representação de um FAE.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class FAE implements Cargo, Serializable, Comparable {

    /**
     * Utilizador por detrás do papel de FAE.
     */
    private Utilizador utilizador;

    /**
     * Experiência do fae nesta posição
     */
    private int experiencia;

    /**
     * Construtor de objetos do tipo FAE recebendo como parâmetro o Utilizador
     * que dá origem a um fae.
     *
     * @param utilizador Utilizador que passa a ser reconhecido como FAE
     * @param experiencia Experiência do fae nesta posição
     */
    public FAE(Utilizador utilizador, int experiencia) {
        this.utilizador = utilizador;
        this.experiencia = experiencia;
    }

    /**
     * Devolve o utilizador por detrás do papel de FAE.
     *
     * @return Utilizador por detrás do papel de FAE.
     */
    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    /**
     * Devolve o username do utilizador.
     *
     * @return username do utilizador.
     */
    public String getUsername() {
        return this.getUtilizador().getUsername();
    }

    /**
     * Retorna a experiência que o FAE tem neste cargo
     *
     * @return experiência do FAE
     */
    public int getExperiencia() {
        return this.experiencia;
    }

    /**
     * Devolve a descrição textual do fae.
     *
     * @return caraterísticas do fae.
     */
    @Override
    public String toString() {
        return "Fae: " + this.getUtilizador().getUsername();
    }

    /**
     * Compara o FAE a outro objecto passado por parâmetro. A comparação entre
     * dois FAE é feita com atenção a todos os atributos destes.
     *
     * @param obj objecto a comparar com o FAE
     * @return true se o objeto recebido representar um fae equivalente ao fae.
     * Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }
        FAE fae = (FAE) obj;
        if (this.getUtilizador().equals(fae.getUtilizador())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * CompareTo a ser usado quando for preciso ordenar um contentor de FAE pela
     * sua experiência
     *
     * @param faeComparar FAE a comparar
     * @return -1 se o FAE recebido tiver menos experiência, 1 se tiver mais
     * experiência ou 0 se ambos tiverem a mesma experiência.
     */
    @Override
    public int compareTo(Object faeComparar) {
        FAE fae = (FAE) faeComparar;
        if (this.experiencia > fae.experiencia) {
            return -1;
        } else if (this.experiencia < fae.experiencia) {
            return 1;
        } else {
            return 0;
        }
    }

}
