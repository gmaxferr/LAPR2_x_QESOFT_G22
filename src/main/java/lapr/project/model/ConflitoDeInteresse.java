package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um conflito de interesse
 * 
 * @author G29
 */
public class ConflitoDeInteresse implements Importable<ConflitoDeInteresse>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "ConflitoDeInteresse";

    /**
     * Fae
     */
    private FAE m_fae;
    
    /**
     * Candidatura a exposição
     */
    private CandidaturaAExposicao m_candidatura;
    
    /**
     * Tipo de conflito
     */
    private TipoConflito m_tipoConflito;

    /**
     * Contrutor de objetos do tipo ConflitoDeInteresse com os parâmetros
     * candidatura a exposição e tipo de conflito
     * 
     * @param fae fae
     * @param cand candidatura a exposição
     * @param tipoConflito tipo de conflito
     */
    public ConflitoDeInteresse(FAE fae, CandidaturaAExposicao cand, TipoConflito tipoConflito) {
        this.m_fae = fae;
        this.m_candidatura = cand;
        this.m_tipoConflito = tipoConflito;
    }

    /**
     * Devolve o fae
     * @return fae
     */
    public FAE getFae() {
        return m_fae;
    }

    /**
     * Devolve a candidatura a exposição 
     * 
     * @return candidatura a exposição 
     */
    public CandidaturaAExposicao getCandidatura() {
        return m_candidatura;
    }

    /**
     * Devolve o tipo de conflito
     * 
     * @return tipo deste conflito
     */
    public TipoConflito getTipo() {
        return this.m_tipoConflito;
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     * 
     * @param rc registo candidaturas a exposição
     */
    public void fix(RegistoCandidaturasAExposicao rc) {
        for (CandidaturaAExposicao cand : rc.getListaCandidaturas()) {
            if (this.m_candidatura.equals(cand)) {
                this.m_candidatura = cand;
                break;
            }
        }
    }

    @Override
    public ConflitoDeInteresse importContentFromXMLNode(Node node) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        doc.appendChild(doc.importNode(node, true));

        Node n = doc.getChildNodes().item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_fae = new FAE();
            this.m_fae.importContentFromXMLNode(elem.getElementsByTagName(FAE.ROOT_ELEMENT_NAME).item(0));
            this.m_tipoConflito = new TipoConflito("");
            this.m_tipoConflito.importContentFromXMLNode(elem.getElementsByTagName(TipoConflito.ROOT_ELEMENT_NAME).item(0));

            NodeList nList = elem.getElementsByTagName(Keyword.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);
                Keyword key = new Keyword();
                key.importContentFromXMLNode(n2);
                this.m_candidatura.getListKeyword().add(key);
            }
        }

        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);

            elementBase.appendChild(document.importNode(this.m_fae.exportContentToXMLNode(), true));
            elementBase.appendChild(document.importNode(this.m_tipoConflito.exportContentToXMLNode(), true));

            elementBase.appendChild(document.importNode(this.m_candidatura.getExpositor().exportContentToXMLNode(), true));

            for (Keyword k : this.m_candidatura.getListKeyword()) {
                elementBase.appendChild(document.importNode(k.exportContentToXMLNode(), true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ConflitoDeInteresse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
