/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr.project.model;

/**
 *
 * @author Ana Leite
 */
public class DecisaoStand {

    /**
     * Decisao do representante
     */
    private boolean m_decisao;
    
    /**
     * Construtor de objetos do tipo DecisaoStand sem parâmetros
     */
    public DecisaoStand(){
    }
    
    /**
     * Devolve a decisão
     * 
     * @return decisão
     */
    public boolean getDecisao(){
        return this.m_decisao;
    }
    
    /**
     * Modifica a decisão
     * 
     * @param decisao nova decisão
     */
    public void setDecisao(boolean decisao){
        this.m_decisao = decisao;
    }
}
