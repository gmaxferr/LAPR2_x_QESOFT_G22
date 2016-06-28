package lapr.project.controller;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.*;
import lapr.project.registos.RegistoCandidaturasADemonstracao;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Representação do controller do UC Criar Candidatura A Demonstração XML
 * 
 * @author G29
 */
public class CriarCandidaturaDemonstracaoXMLController {

    /**
     * Candidatura a demonstração
     */
    private CandidaturaADemonstracao m_c;
    
    /**
     * Demonstração selecionada
     */
    private Demonstracao m_d;

    /**
     * Contrutor de objetos do tipo CriarCandidaturaDemonstracaoXMLController com
     * os parametros centro de exposições, nome do ficheiro e demonstração
     * 
     * @param ce centro de exposições
     * @param filename nome do ficheiro
     * @param d demonstração
     * @throws ParserConfigurationException 
     */
    public CriarCandidaturaDemonstracaoXMLController(CentroExposicoes ce, String filename, Demonstracao d) throws ParserConfigurationException {
        m_d = d;
        try {
            ImportarXMLController impCtrl = new ImportarXMLController();
            Node node = impCtrl.Import(filename);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                this.m_c = new CandidaturaADemonstracao("", "");
                m_c.importContentFromXMLNode(elem);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ficheiro não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Adiciona a candidatura ao registo de candidaturas da demonstração
     * 
     * @param email email do representante
     */
    public void registarCandidatura(String email) {
        RegistoCandidaturasADemonstracao rcd = m_d.getRegistoCandidaturasADemonstracao();
        m_c.setEmailExpositor(email);
        rcd.adiciona(m_c);
    }
}
