package classesModelERegistodePPROG;

import java.io.Serializable;

/**
 * Representação de um recurso usado pelas demonstrações permitindo o seu
 * funcionamento.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class Recurso implements Serializable {

    /**
     * Nome do recurso
     */
    private String nome;

    /**
     * Construtor de objetos do tipo Recurso com o parâmetro nome.
     *
     * @param nome nome do novo recurso
     */
    public Recurso(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o nome do recurso.
     *
     * @return nome do recurso.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Compara o recurso a outro objecto passado por parâmetro. A comparação
     * entre dois recursos é feita com atenção a todos os atributos destes.
     *
     * @param obj objeto a comparar com o recurso.
     * @return true se o objeto recebido representar um recurso equivalente ao
     * recurso. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }
        Recurso novoRecurso = (Recurso) obj;
        if (novoRecurso.getNome().equalsIgnoreCase(this.getNome())) {
            return true;
        } else {
            return false;
        }
    }

}
