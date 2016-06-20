package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author osori
 */
public class ConflitoDeInteresse implements Importable<ConflitoDeInteresse>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "ConflitoDeInteresse";

    private FAE m_fae;
    private CandidaturaAExposicao m_candidatura;
    private TipoConflito m_tipoConflito;

    public ConflitoDeInteresse(FAE fae, CandidaturaAExposicao cand, TipoConflito tipoConflito) {
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
    public CandidaturaAExposicao getCandidatura() {
        return m_candidatura;
    }

    /**
     *
     * @return tipo deste conflito
     */
    public TipoConflito getTipo() {
        return this.m_tipoConflito;
    }
    
    public void fix(RegistoCandidaturasAExposicao rc){
        for(CandidaturaAExposicao cand : rc.getListaCandidaturas()){
            if(this.m_candidatura.equals(cand)){
                this.m_candidatura = cand;
                break;
            }
        }
    }

    @Override
    public ConflitoDeInteresse importContentFromXMLNode(Node node) {
        try {
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
                Expositor expositor = new Expositor(null);
                expositor.importContentFromXMLNode(elem.getElementsByTagName(Expositor.ROOT_ELEMENT_NAME).item(0));
                
                this.m_candidatura.setExpositor(expositor);
                NodeList nList = elem.getElementsByTagName(Keyword.ROOT_ELEMENT_NAME);
                for(int i=0; i<nList.getLength(); i++){
                    Node n2 = nList.item(i);
                    Keyword key = new Keyword();
                    key.importContentFromXMLNode(n2);
                    this.m_candidatura.getListKeyword().add(key);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ConflitoDeInteresse.class.getName()).log(Level.SEVERE, null, ex);
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
            
            for(Keyword k : this.m_candidatura.getListKeyword()){
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
