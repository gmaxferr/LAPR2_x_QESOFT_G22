package lapr.project.controller;

import java.io.*;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;
import lapr.project.model.CentroExposicoes;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Node;

/**
 * Representação do controller do UC Exportar XML
 * 
 * @author G29
 */
public class ExportarXMLController {

    /**
     * Exporta a informação do centro de exposições para um ficheiros
     * 
     * @param filename nome completo do ficheiro
     * @param ce centro de exposições
     * @return true se a informação foi exportada. Caso contrário retorna false.
     */
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

    /**
     * Exporta a informação do centro de exposições para um ficheiro e atualiza 
     * o ficheiro
     * 
     * @param filename nome completo do ficheiro
     * @param ce centro de exposições
     * @return true se a informação foi exportada e atualizada. Caso contrário
     * retorna false.
     */
    public boolean exportAndUpdateProperties(String filename, CentroExposicoes ce) {
        if (export(filename, ce)) {
            File properties = new File(CentroExposicoes.PROPERTIES_FILE_LOCATION);
            try {
                Formatter out = new Formatter(properties);
                out.format("saveFileLocation=%s%n", filename);
                out.close();
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ExportarXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
