/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoDemonstracoes;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class CriarCandidaturaExposicaoXMLController {

    private CandidaturaAExposicao m_c;
    private Exposicao m_e;
    private CentroExposicoes m_ce;

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
     * Adiciona a candidatura ao registo de candidaturas da demonstração
     */
    public void registarCandidatura(Utilizador u) {
        m_c.fix(m_ce.getRegistoUtilizadoresConfirmados(), new RegistoDemonstracoes(true));
        RegistoCandidaturasAExposicao rce = m_e.getRegistoCandidaturasAExposicao();
        m_c.setExpositor(new Expositor(u));
        rce.getListaCandidaturas().add(m_c);
    }

}

