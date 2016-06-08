/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.EstadoDemonstracao;
import lapr.project.registos.RegistoRecursos;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class Demonstracao {

    private String m_StrDescricao;
    private String m_StrCodigoIdentificacao;
    private RegistoRecursos rc;
    private EstadoDemonstracao m_estado;

    public Demonstracao(String descricao) {
        this.rc = new RegistoRecursos();
        this.m_StrDescricao = descricao;
    }

    /**
     * 
     * @return descrição da demonstração
     */
    public String getDescricao() {
        return this.m_StrDescricao;
    }

    /**
     * Permite alterar a descrição da demonstração
     * @param descricaoIntroduzidaPeloUtilizador 
     */
    public void getDescricao(String descricaoIntroduzidaPeloUtilizador) {
        this.m_StrDescricao = descricaoIntroduzidaPeloUtilizador;
    }

    /**
     * 
     * @return registo dos recursos necessários à demonstração
     */
    public RegistoRecursos getRegistoRecursosNecessarios() {
        return this.rc;
    }

    /**
     * 
     * @return código da demonstração
     */
    public String getCodigoIdentificacao() {
        return this.m_StrCodigoIdentificacao;
    }
    
    /**
     * Permite obter o estado atual da demonstração
     * @return estado atual da demonstração
     */
    public EstadoDemonstracao getEstadoDemo(){
        return m_estado;
    }

    /**
     * @param m_StrCodigoIdentificacao the m_StrCodigoIdentificacao to set
     */
    public void setCodigoIdentificacao(String m_StrCodigoIdentificacao) {
        this.m_StrCodigoIdentificacao = m_StrCodigoIdentificacao;
    }
}
