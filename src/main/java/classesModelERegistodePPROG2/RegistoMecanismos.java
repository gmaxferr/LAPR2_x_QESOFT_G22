package classesModelERegistodePPROG;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de um regsito de mecanismos.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class RegistoMecanismos implements Serializable {

    /**
     * Lista de mecanismos.
     */
    private List<Mecanismo> listaMec;

    /**
     * Cosntrutor de objetos do tipo registoMecanismos sem parâmetros.
     */
    public RegistoMecanismos() {
        this.listaMec = new ArrayList<>();
    }

    /**
     * Devolve a lista de mecanismos.
     *
     * @return lista de mecanismos.
     */
    public List<Mecanismo> getListaMecanismos() {
        return this.listaMec;
    }

    /**
     * Adiciona um mecanismo à lista de mecanismos.
     *
     * @param mecanismo mecanismo a ser adicionado.
     */
    public void addMecanismo(Mecanismo mecanismo) {
        this.listaMec.add(mecanismo);
    }
}
