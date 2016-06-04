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

    private String m_StrDescricao;
    private String m_StrCodigoIdentificacao;
    private RegistoRecursos rrr;

    public Demonstracao(String descricao) {
        this.rrr = new RegistoRecursos();
        this.m_StrDescricao = descricao;
    }

    public String getM_StrDescricao() {
        return this.m_StrDescricao;
    }

    public void setM_StrDescricao(String descricaoIntroduzidaPeloUtilizador) {
        this.m_StrDescricao = descricaoIntroduzidaPeloUtilizador;
    }

    public RegistoRecursos getRegistoRecursosDemo() {
        return this.rrr;
    }

    public String getM_StrCodigoIdentificacao() {
        return this.m_StrCodigoIdentificacao;
    }
}
