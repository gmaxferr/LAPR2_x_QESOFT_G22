package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.RegistoUtilizadores;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ricardo Osorio
 */
public class FaeAvaliacao implements Importable<FaeAvaliacao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "FaeAvaliacao";

    private FAE m_FaeAssociado;
    private Avaliacao m_avaliacao;

    public FaeAvaliacao() {
        this.m_avaliacao = new Avaliacao();
    }

    public FaeAvaliacao(FAE fae) {
        this.m_FaeAssociado = fae;
    }

    public FAE getFaeAssociado() {
        return this.m_FaeAssociado;
    }

    public Avaliacao getAvaliacao() {
        return this.m_avaliacao;
    }

    public void fix(RegistoUtilizadores m_registoUtilizadores) {
        for(Utilizador u : m_registoUtilizadores.getListaUtilizadores()){
            if(m_FaeAssociado.getUtilizador().getUsername().equals(u.getUsername())){
                this.m_FaeAssociado.setUtilizador(u);
                break;
            }
        }
    }

    @Override
    public FaeAvaliacao importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.appendChild(document.importNode(node, true));

            NodeList elementsKeyword = document.getChildNodes();

            Node n = elementsKeyword.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_FaeAssociado = new FAE();
                this.m_FaeAssociado.importContentFromXMLNode(elem.getElementsByTagName(FAE.ROOT_ELEMENT_NAME).item(0));
                this.m_avaliacao = new Avaliacao();
                this.m_avaliacao.importContentFromXMLNode(elem.getElementsByTagName(Avaliacao.ROOT_ELEMENT_NAME).item(0));
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FaeAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
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
            document.appendChild(elementBase);

            elementBase.appendChild(document.importNode(this.m_FaeAssociado.exportContentToXMLNode(), true));
            elementBase.appendChild(document.importNode(this.m_avaliacao.exportContentToXMLNode(), true));

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FaeAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
