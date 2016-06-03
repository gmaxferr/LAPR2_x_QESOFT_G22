/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesModelERegistoDeESOFT;

import java.util.ArrayList;

/**
 *
 * @author Ana Leite
 */
public class RegistoRecursos {

    private ArrayList<Recurso> listaRecursos;

    /**
     *
     */
    public RegistoRecursos() {
        this.listaRecursos = new ArrayList<>();
    }

    /**
     * Método que cria um recurso
     *
     * @param nome nome do recurso a ser criadp
     * @return novo recurso
     */
    public Recurso criarRecurso(String nome) {
        if (validarRecurso() == true) {
            Recurso recurso = new Recurso(nome);
            recurso.setNomeRecurso(nome);
            return recurso;
        }
        return null;
    }

    /**
     * Valida o nome do recurso
     *
     * @return
     */
    private boolean validarRecurso() {
        return true;
    }

    ArrayList<Recurso> getListaDeRecursos() {
        return this.listaRecursos;
    }

    void setRecurso(Recurso rec) {
        if (valida() == true) {
            addRecurso(rec);
        } else {
            //avisa o utilizador para o facto de o recurso não ser válido
        }
    }

    public boolean valida() {
        //validação global
        return true;
    }

    private void addRecurso(Recurso rec) {
        this.listaRecursos.add(rec);
    }

}
