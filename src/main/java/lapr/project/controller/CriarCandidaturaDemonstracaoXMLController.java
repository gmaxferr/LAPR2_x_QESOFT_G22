/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.registos.RegistoCandidaturaADemonstracoes;
import org.w3c.dom.Node;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class CriarCandidaturaDemonstracaoXMLController {

    private CandidaturaADemonstracao m_c;
    private Demonstracao m_d;

    public CriarCandidaturaDemonstracaoXMLController(CentroExposicoes ce, String filename, Demonstracao d) throws ParserConfigurationException {
        m_d = d;
        try {
            ImportarXMLController impCtrl = new ImportarXMLController();
            Node node = impCtrl.Import(filename);
            if (node != null) {
                m_c.importContentFromXMLNode(node);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ficheiro não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Adiciona a candidatura ao registo de candidaturas da demonstração
     */
    public void registarCandidatura() {
        RegistoCandidaturaADemonstracoes rcd = m_d.getRegistoCandidaturasADemonstracao();
        m_c.fix();
        rcd.adiciona(m_c);
    }
}
