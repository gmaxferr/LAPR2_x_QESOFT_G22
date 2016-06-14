package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Mecanismo;

/**
 * Representação de um registo de mecanismos
 * 
 * @author Ricardo Osório Ana Leite
 */
public class RegistoMecanismos {

    /**
     * Lista de mecanismos
     */
    private List<Mecanismo> listaMecanismo;

    /**
     * Construtor de objetos do tipo RegistoMecanismos sem parametros
     */
    public RegistoMecanismos() {
        this.listaMecanismo = new ArrayList<>();
    }

    /**
     * Devolve a lista de mecanismos
     * 
     * @return lista de mecanismos
     */
    public List<Mecanismo> getListaMecanismos() {
        return this.listaMecanismo;
    }

    /**
     * Adiciona um mecanismo à lista de mecanismos.
     *
     * @param mecanismo mecanismo a ser adicionado.
     */
    public void addMecanismo(Mecanismo mecanismo) {
        this.listaMecanismo.add(mecanismo);
    }
}
