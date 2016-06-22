package lapr.project.controller;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.*;
import lapr.project.registos.RegistoCandidaturasADemonstracao;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class CriarCandidaturaDemonstracaoXMLController {

    private CandidaturaADemonstracao m_c;
    private Demonstracao m_d;

    public CriarCandidaturaDemonstracaoXMLController(CentroExposicoes ce, String filename, Demonstracao d) throws ParserConfigurationException {
        m_d = d;
        try {
            ImportarXMLController impCtrl = new ImportarXMLController();
            Node node = impCtrl.Import(filename);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                Node n2 = elem.getElementsByTagName(CandidaturaADemonstracao.ROOT_ELEMENT_NAME).item(0);
                CandidaturaADemonstracao m_c = new CandidaturaADemonstracao("", "");
                m_c.importContentFromXMLNode(n2);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ficheiro não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Adiciona a candidatura ao registo de candidaturas da demonstração
     */
    public void registarCandidatura(String email) {
        RegistoCandidaturasADemonstracao rcd = m_d.getRegistoCandidaturasADemonstracao();
        m_c.setEmailExpositor(email);
        rcd.adiciona(m_c);
    }
}
