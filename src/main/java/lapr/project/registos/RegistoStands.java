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
     * @return lista de stands
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

    public boolean criarStand(String ID, int area) {
        Stand novoStand = new Stand(ID, area);
        if (validarStand(novoStand)) {
            this.m_listaStands.add(novoStand);
            return true;
        }
        return false;
    }

    private boolean validarStand(Stand novoStand) {
        for (Stand stand : m_listaStands) {
            if (novoStand.equals(stand)) {
                return false;
            }
        }
        return true;
    }

}
