package lapr.project.registos;

import java.util.ArrayList;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class RegistoOrganizadores {

    private ArrayList<Organizador> m_listaOrganizadores;
    
    /**
     * Método que valida a exposição
     * @param o organozador de exposição
     * @return 
     */
    private boolean validaOrganizador(Organizador o) {
        System.out.println("Exposição: validaOrganizador: " + o.toString());
        return true;
    }

    /**
     * Método que adiciona o organizador à exposição
     * 
     * @param ut utilizador/organizador da exposição 
     */
    public void addOrganizador(Utilizador ut) {
        Organizador o = new Organizador();
        o.setUtilizador(ut);
        if (validaOrganizador(o)) {
            addOrganizador(o);
        }
    }
    
    /**
     * Método que adiciona um organizador à exposição
     * 
     * @param o organizador a ser adicionado
     */
    private void addOrganizador(Organizador o) {
        m_listaOrganizadores.add(o);
    }

    public ArrayList<Organizador> getListaOrganizadores() {
        return this.m_listaOrganizadores;
    }
}
