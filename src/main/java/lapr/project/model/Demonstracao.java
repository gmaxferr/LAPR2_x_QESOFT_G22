/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.estados.EstadoDemonstracao;
import lapr.project.registos.RegistoRecursos;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class Demonstracao {

    private String m_StrDescricao;
    private String m_StrCodigoIdentificacao;
    private RegistoRecursos m_rrr;
    private EstadoDemonstracao m_estado;

    public Demonstracao(String descricao) {
        this.m_rrr = new RegistoRecursos();
        this.m_StrDescricao = descricao;
    }

    /**
     * 
     * @return descrição da demonstração
     */
    public String getM_StrDescricao() {
        return this.m_StrDescricao;
    }

    /**
     * Permite alterar a descrição da demonstração
     * @param descricaoIntroduzidaPeloUtilizador 
     */
    public void setM_StrDescricao(String descricaoIntroduzidaPeloUtilizador) {
        this.m_StrDescricao = descricaoIntroduzidaPeloUtilizador;
    }

    /**
     * 
     * @return registo dos recursos necessários à demonstração
     */
    public RegistoRecursos getRegistoRecursos() {
        return this.m_rrr;
    }

    /**
     * 
     * @return código da demonstração
     */
    public String getM_StrCodigoIdentificacao() {
        return this.m_StrCodigoIdentificacao;
    }
    
    /**
     * Permite obter o estado atual da demonstração
     * @return estado atual da demonstração
     */
    public EstadoDemonstracao getEstadoDemo(){
        return m_estado;
    }
}
