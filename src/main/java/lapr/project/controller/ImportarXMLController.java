package lapr.project.controller;

import java.io.*;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Node;

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
    public Node Import(String filename) throws FileNotFoundException {
        Node node = null;
        try {
            XMLParser parser = new XMLParser();
            node = parser.readXMLElementFromFile(filename);
        } catch (ParserConfigurationException | IOException ex) {
            Logger.getLogger(ImportarXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
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
        CentroExposicoes ce = new CentroExposicoes();
        ce.importContentFromXMLNode(Import(filename));

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
