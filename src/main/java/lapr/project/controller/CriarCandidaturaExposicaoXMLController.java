package lapr.project.controller;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.*;
import lapr.project.registos.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Representação do controller do UC Criar Candidatura A Exposição XML
 * 
 * @author G29
 */
public class CriarCandidaturaExposicaoXMLController {

    /**
     * Candidatura a exposição
     */
    private CandidaturaAExposicao m_c;
    
    /**
     * Exposição selecionada
     */
    private Exposicao m_e;
    
    /**
     * Centro de exposições
     */
    private CentroExposicoes m_ce;

    /**
     * Contrutor de objetos do tipo CriarCandidaturaExposicaoXMLController com
     * os parametros centro de exposições, exposição e nome do ficheiro
     * 
     * @param ce centro de exposições
     * @param e exposição 
     * @param filename nome do ficheiro
     * @throws ParserConfigurationException 
     */
    public CriarCandidaturaExposicaoXMLController(CentroExposicoes ce, Exposicao e, String filename) throws ParserConfigurationException {
        this.m_ce = ce;
        this.m_e = e;
        try {
            ImportarXMLController impCtrl = new ImportarXMLController();
            Node node = impCtrl.Import(filename);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                this.m_c = new CandidaturaAExposicao(this.m_e, null);
                m_c.importContentFromXMLNode(elem);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ficheiro não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Adiciona a candidatura ao registo de candidaturas da exposição
     * 
     * @param u utilizador
     */
    public void registarCandidatura(Utilizador u) {
        m_c.fix(m_ce.getRegistoUtilizadoresConfirmados(), new RegistoDemonstracoes(true));
        RegistoCandidaturasAExposicao rce = m_e.getRegistoCandidaturasAExposicao();
        m_c.setExpositor(new Expositor(u));
        rce.getListaCandidaturas().add(m_c);
    }

}

