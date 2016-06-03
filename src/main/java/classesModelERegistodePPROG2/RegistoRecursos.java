package classesModelERegistodePPROG;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import classesModelERegistodePPROG.Recurso;

/**
 * Rpresentação de um registo de recursos.
 * 
 * @author Ricardo Osório e Ana Leite
 */
public class RegistoRecursos implements Serializable{

    /**
     * Lista de recursos.
     */
    private List<Recurso> listaRecursos;

    /**
     * Construtor de objetos do tipo RegistoRecursos sem parâmetros.
     */
    public RegistoRecursos() {
        this.listaRecursos = new ArrayList<>();
    }

    /**
     * Devolve a lista de recursos.
     *
     * @return lista de recursos.
     */
    public List<Recurso> getListaRecursos() {
        return this.listaRecursos;
    }

    /**
     * Adiciona um recurso à lista de recursos.
     *
     * @param recurso recurso para adicionar.
     */
    public void addRecurso(Recurso recurso) {
        if (valida(recurso)) {
            this.listaRecursos.add(recurso);
        }
    }

    /**
     * Valida o recurso.
     * 
     * @param novoRecurso recurso a ser validado
     * @return true se não encontrar o recurso na lista de recursos.
     * Caso contrário retorna false.
     */
    private boolean valida(Recurso novoRecurso) {
        for (Recurso recurso : this.listaRecursos) {
            if (novoRecurso.equals(recurso)) {
                return false;
            }
        }
        return true;
    }

}
