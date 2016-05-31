package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de um registo de candidaturas.
 * 
 * @author Ana Leite e Ricardo Osório
 */
public class RegistoCandidaturas implements Serializable{

    /**
     * Lista de candidaturas.
     */
    private List<Candidatura> listaCandidaturas;

    /**
     * Construtor de objetos do tipo RegistoCandidaturas sem parâmetros.
     */
    public RegistoCandidaturas() {
        this.listaCandidaturas = new ArrayList<>();
    }

     /**
     * Devolve a lista de candidatuas.
     * 
     * @return lista de candidatuas.
     */
    public List<Candidatura> getListaCandidaturas() {
        return this.listaCandidaturas;
    }

    /**
     * Cria uma nova candidatura.
     * 
     * @param usernameExpositor username do expositor da candidatura.
     * @return candidatura criada.
     */
    public Candidatura criarCandidatura(String usernameExpositor) {
        return new Candidatura(usernameExpositor);
    }

    /**
     * Regista a candidatura criada.
     * 
     * @param candidaturaCriada candidatura criada.
     */
    public boolean registaCandidatura(Candidatura candidaturaCriada) {
        boolean b=validaCandidatura(candidaturaCriada);
        if ( b== true) {
             this.listaCandidaturas.add(candidaturaCriada);
        }
        return b;
    }


    /**
     * Valida a candidatura criada.
     * 
     * @param candidaturaCriada candidatura criada.
     * 
     * @return true se não encontrar a candidatura na lista de candidaturas. 
     * Caso contrário retorna false.
     */
    private boolean validaCandidatura(Candidatura candidaturaCriada) {
        for (Candidatura candidatura : this.listaCandidaturas) {
            if(candidaturaCriada.equals(candidatura))
                return false;
        }
        return true;
    }
    
    

}
