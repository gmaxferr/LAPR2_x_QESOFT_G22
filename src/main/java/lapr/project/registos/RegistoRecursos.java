/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Recurso;

/**
 *
 * @author Ana Leite
 */
public class RegistoRecursos {

    private List<Recurso> m_listaRecursosNecessarios;

    /**
     *
     */
    public RegistoRecursos() {
        this.m_listaRecursosNecessarios = new ArrayList<>();
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

    public List<Recurso> getListaDeRecursos() {
        return this.m_listaRecursosNecessarios;
    }

    public void setRecurso(Recurso rec) {
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
        this.m_listaRecursosNecessarios.add(rec);
    }

    /**
     * @param listaRecursosNecessarios
     */
    public void setListaRecursosNecessarios(List<Recurso> listaRecursosNecessarios) {
        this.m_listaRecursosNecessarios = listaRecursosNecessarios;
    }

}
