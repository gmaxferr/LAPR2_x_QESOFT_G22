/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.CentroExposicoes;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Ricardo Catalao
 */
public class ImportarXMLController {
    
    public CentroExposicoes Import(String filename){
        CentroExposicoes ce = null;
        
        try {
            XMLParser parser = new XMLParser();
            Node node = parser.readXMLElementFromFile(filename);
            ce = new CentroExposicoes();
            ce.importContentFromXMLNode(node);
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            Logger.getLogger(ImportarXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ce;
    }
    
}
