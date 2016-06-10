/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;
import lapr.project.model.CentroExposicoes;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Node;

/**
 *
 * @author Ricardo Catalao
 */
public class ExportarXMLController {

    public boolean export(String filename, CentroExposicoes ce) {
        try {
            Node node = ce.exportContentToXMLNode();
            XMLParser parser = new XMLParser();
            parser.writeXMLElementToFile(node, filename);
            return true;
        } catch (TransformerException ex) {
            Logger.getLogger(ExportarXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
