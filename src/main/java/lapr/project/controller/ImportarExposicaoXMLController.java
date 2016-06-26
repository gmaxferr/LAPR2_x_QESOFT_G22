/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Ricardo Catalao
 */
public class ImportarExposicaoXMLController {

    private Exposicao m_e;
    
    private CentroExposicoes m_ce;
    
    public ImportarExposicaoXMLController(CentroExposicoes ce, String filename) throws ParserConfigurationException {
        this.m_ce = ce;
        try {
            ImportarXMLController impCtrl = new ImportarXMLController();
            Node node = impCtrl.Import(filename);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                this.m_e = new Exposicao(ce);
                m_e.importContentFromXMLNode(node);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ficheiro não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void registarExposicao(){
        m_e.fix(m_ce.getRegistoRecursos(), m_ce.getRegistoTiposConflitos(), m_ce.getRegistoUtilizadoresConfirmados());
        m_ce.getRegistoExposicoes().getListaExposicoes().add(m_e);
    }

}
