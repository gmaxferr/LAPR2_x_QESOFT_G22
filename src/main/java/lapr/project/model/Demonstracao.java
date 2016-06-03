/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.registos.RegistoRecursos;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class Demonstracao {

    private String descricao;
    private String codigoIdentificacao;
    private RegistoRecursos rrr;

    public Demonstracao() {
        this.rrr = new RegistoRecursos();
    }

    public void setDescricao(String descricaoIntroduzidaPeloUtilizador) {
        this.descricao = descricaoIntroduzidaPeloUtilizador;
    }

    public RegistoRecursos getRegistoRecursosDemo() {
        return this.rrr;
    }

    public String getCodigoIdentificacao() {
        return this.codigoIdentificacao;
    }
}
