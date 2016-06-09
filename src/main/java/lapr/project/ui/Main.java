package lapr.project.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.KeywordRanking;
import lapr.project.model.MyJFileChooser;
import lapr.project.model.ScoredKeyword;
import lapr.project.utils.FicheiroDados;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author osori
 */
public class Main {

    public static void main(String[] args) {

        KeywordRanking rank = new KeywordRanking();
        for(int i=0; i<20; i++){
            rank.addKeyword(String.valueOf(i), true);
        }
        KeywordRanking rank2 = new KeywordRanking();

        Node node = rank.exportContentToXMLNode();

        XMLParser parser = new XMLParser();
        try {
            parser.writeXMLElementToFile(node, "saveFile.xml");
        } catch (TransformerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Node node2 = parser.readXMLElementFromFile("saveFile.xml");
            rank2.importContentFromXMLNode(node2);
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        MyJFileChooser.personalizarEmPortugues();
        FicheiroDados tratarFicheiro = new FicheiroDados();
        CentroExposicoes centroExposicoes = tratarFicheiro.lerFicheiroBinario(FicheiroDados.NOME_FICHEIRO_BINARIO_PREDEFINICAO);
        if (centroExposicoes == null) {
            centroExposicoes = new CentroExposicoes();
            tratarFicheiro.lerDadosFicheiroTexto(centroExposicoes);
        }

        new LoginGui(centroExposicoes);
    }
}
