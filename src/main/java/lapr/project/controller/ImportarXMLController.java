package lapr.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.CentroExposicoes;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author G29
 */
public class ImportarXMLController {

    /**
     * Importa a informação de um ficheiro para um Centro de Exposições.
     *
     * @param filename Nome completo do ficheiro
     * @return Centro de Exposicoes com informação carregada a partir do
     * ficheiro
     * @throws FileNotFoundException
     */
    public CentroExposicoes Import(String filename) throws FileNotFoundException {
        CentroExposicoes ce = null;

        try {
            XMLParser parser = new XMLParser();
            Node node = parser.readXMLElementFromFile(filename);
            if (node != null) {
                ce = new CentroExposicoes();
                ce.importContentFromXMLNode(node);
            }
        } catch (ParserConfigurationException | IOException ex) {
            Logger.getLogger(ImportarXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ce;
    }

    /**
     * Importa a informação de um ficheiro para um Centro de Exposições e
     * atualiza o ficheiro propriedades.
     *
     * @param filename Nome completo do ficheiro
     * @return Centro de Exposicoes com informação carregada a partir do
     * ficheiro
     * @throws FileNotFoundException
     */
    public CentroExposicoes importAndUpdateProperties(String filename) throws FileNotFoundException {
        CentroExposicoes ce = Import(filename);
        if (ce != null) {
            File properties = new File(CentroExposicoes.PROPERTIES_FILE_LOCATION);
            try {
                Formatter out = new Formatter(properties);
                out.format("saveFileLocation=%s%n", filename);
                out.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ExportarXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ce;
    }
}
