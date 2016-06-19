/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class ConflitoDeInteresseDemonstracao implements Importable<ConflitoDeInteresseDemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "ConflitoDeInteresseDemonstracao";

    private FAE m_fae;
    private CandidaturaADemonstracao m_candidatura;
    private TipoConflitoDemonstracao m_tipoConflito;

    public ConflitoDeInteresseDemonstracao(FAE fae, CandidaturaADemonstracao cand, TipoConflitoDemonstracao tipoConflito) {
        this.m_fae = fae;
        this.m_candidatura = cand;
        this.m_tipoConflito = tipoConflito;
    }

    /**
     * @return the m_fae
     */
    public FAE getFae() {
        return m_fae;
    }

    /**
     * @return the m_candidatura
     */
    public CandidaturaADemonstracao getCandidatura() {
        return m_candidatura;
    }

    /**
     *
     * @return tipo deste conflito
     */
    public TipoConflitoDemonstracao getTipo() {
        return this.m_tipoConflito;
    }

    public void fix(RegistoCandidaturasAExposicao rc) {
        for (CandidaturaAExposicao cand : rc.getListaCandidaturas()) {
            for (Demonstracao demo : cand.getRegistoDemonstracoes().getListaDemonstracoes()) {
                for (CandidaturaADemonstracao cand2 : demo.getRegistoCandidaturasADemonstracao().getListaCandidaturasADemonstracao()) {
                    if (this.m_candidatura.equals(cand2)) {
                        this.m_candidatura = cand2;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public ConflitoDeInteresseDemonstracao importContentFromXMLNode(Node node) {
        try {
            Document doc = XMLParser.createDocument(node, true);

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_fae = new FAE();
                this.m_fae.importContentFromXMLNode(elem.getElementsByTagName(FAE.ROOT_ELEMENT_NAME).item(0));
                this.m_tipoConflito = new TipoConflitoDemonstracao("");
                this.m_tipoConflito.importContentFromXMLNode(elem.getElementsByTagName(TipoConflitoDemonstracao.ROOT_ELEMENT_NAME).item(0));
                Expositor expositor = new Expositor(null);
                expositor.importContentFromXMLNode(elem.getElementsByTagName(Expositor.ROOT_ELEMENT_NAME).item(0));
                this.m_candidatura = new CandidaturaADemonstracao(null, null);
                this.m_candidatura.importContentFromXMLNode(elem.getElementsByTagName(CandidaturaADemonstracao.ROOT_ELEMENT_NAME).item(0));
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ConflitoDeInteresseDemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);

            elementBase.appendChild(document.importNode(this.m_fae.exportContentToXMLNode(), true));
            elementBase.appendChild(document.importNode(this.m_tipoConflito.exportContentToXMLNode(), true));
            elementBase.appendChild(document.importNode(this.m_candidatura.exportContentToXMLNode(), true));

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ConflitoDeInteresseDemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
