/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.w3c.dom.Node;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class ConflitoDeInteresseDemonstracao {
    public static final String ROOT_ELEMENT_NAME = "ConflitoDeInteresse";

    private FAE m_fae;
    private CandidaturaADemonstracao m_candidatura;
    private TipoConflitoDemonstracao m_tipoConflito;

    public ConflitoDeInteresseDemonstracao(FAE fae, CandidaturaADemonstracao cand, TipoConflitoDemonstracao tipoConflito) {
        this.m_fae = fae;
        this.m_candidatura = cand;
        this.m_tipoConflito = tipoConflito;
    }

    /**
     * @return the m_fae
     */
    public FAE getFae() {
        return m_fae;
    }

    /**
     * @return the m_candidatura
     */
    public CandidaturaADemonstracao getCandidatura() {
        return m_candidatura;
    }

    /**
     *
     * @return tipo deste conflito
     */
    public TipoConflitoDemonstracao getTipo() {
        return this.m_tipoConflito;
    }

    @Override
    public ConflitoDeInteresseDemonstracao importContentFromXMLNode(Node node) {
        
    }

    @Override
    public Node exportContentToXMLNode() {
        
    }
}
