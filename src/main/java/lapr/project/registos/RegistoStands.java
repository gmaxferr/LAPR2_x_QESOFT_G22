package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Stand;

/**
 *
 * @author Ricardo Catalao
 */
public class RegistoStands {
    
    private final List<Stand> m_listaStands;

    public RegistoStands() {
        this.m_listaStands = new ArrayList<>();
    }

    /**
     * @return Retorna a lista de stands
     */
    public List<Stand> getListaStands() {
        return m_listaStands;
    }

    /**
     * @param stand O Stand a adicionar à lista
     */
    public void addStand(Stand stand) {
        this.m_listaStands.add(stand);
    }
    
}
