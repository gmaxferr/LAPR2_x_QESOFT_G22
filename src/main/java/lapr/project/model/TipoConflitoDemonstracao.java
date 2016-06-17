/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Node;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class TipoConflitoDemonstracao implements Importable<TipoConflito>, Exportable{
    public static final String ROOT_ELEMENT_NAME = "TipoConflito";
    public static final String ID_ATTR_NAME = "ID";

    private String ID;

    /**
     * Mecanismo de deteção de conflitos.
     */
    private MecanismoDetecaoConflitoDemonstracao m_mec;

    /**
     * Contrutor por definição.
     */
    public TipoConflitoDemonstracao(String ID) {
        m_mec = new MecanismoDetecaoConflitoDemonstracao(this);
        this.ID = ID;
    }

    /**
     * Define os dados para este tipo de conflitos.
     */
    public void setDadosTipoConflito(String tipoConflito) {
        this.ID = tipoConflito;
    }

    /**
     * @return Retorna o mecanismo de detação deste tipos de conflito
     */
    public MecanismoDetecaoConflitoDemonstracao getMecanismoDetecaoConflito() {
        return m_mec;
    }

    @Override
    public TipoConflitoDemonstracao importContentFromXMLNode(Node node) {
        
    }

    /**
     * @param m_mec the m_mec to set
     */
    public void setMecanismo(MecanismoDetecaoConflitoDemonstracao m_mec) {
        this.m_mec = m_mec;
    }
}
