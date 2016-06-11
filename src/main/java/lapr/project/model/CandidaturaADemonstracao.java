package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracaoCriada;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracaoInstanciada;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author guima
 */
public class CandidaturaADemonstracao implements Importable<CandidaturaADemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "CandidaturaADemonstracao";
    public static final String DADOS_ELEMENT_NAME = "Dados";
    public static final String USERNAME_EXPOSITOR_ELEMENT_NAME = "UsernameExpositor";
    public static final String ESTADO_ATTR_NAME = "estado";

    /**
     * Não sabemos como é constituida uma candidatura a uma demonstração, por
     * isso optamos apenas por descreve-la com uma string que representa todos
     * os possíveis atributos que esta candidtura possa ter.
     */
    private String m_dados;
    private String m_usernameExpositor;

    private EstadoCandidaturaADemonstracao m_estado;

    public CandidaturaADemonstracao(String dados, String username) {
        this.m_dados = dados;
        m_estado = new EstadoCandidaturaADemonstracaoInstanciada(this);
        m_usernameExpositor = username;
    }

    /**
     *
     * @return dados da candidatura
     */
    public String getM_dadosCandidatura() {
        return m_dados;
    }

    /**
     *
     * @return username do expositor
     */
    public String getM_usernameExpositor() {
        return m_usernameExpositor;
    }

    /**
     * @return estado desta candidatura a demonstracao
     */
    public EstadoCandidaturaADemonstracao getEstado() {
        return m_estado;
    }

    /**
     * Altera o estado da candidatura
     *
     * @param novoEstado
     */
    public void setEstado(EstadoCandidaturaADemonstracao novoEstado) {
        m_estado = novoEstado;
    }

    @Override
    public CandidaturaADemonstracao importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            doc.appendChild(doc.importNode(node, true));

            NodeList nodeList = doc.getChildNodes();

            Node n = nodeList.item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.m_dados = elem.getElementsByTagName(DADOS_ELEMENT_NAME).item(0).getTextContent();
                this.m_usernameExpositor = elem.getElementsByTagName(USERNAME_EXPOSITOR_ELEMENT_NAME).item(0).getTextContent();

                String estado = elem.getAttribute(ESTADO_ATTR_NAME);
                switch (estado) {
                    case "instanciada":
                        this.m_estado = new EstadoCandidaturaADemonstracaoInstanciada(this);
                        break;
                    case "criada":
                        this.m_estado = new EstadoCandidaturaADemonstracaoCriada(this);
                        break;
                    default:
                        break;
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CandidaturaADemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element elementRoot = doc.createElement(ROOT_ELEMENT_NAME);
            doc.appendChild(elementRoot);

            Element elem = doc.createElement(DADOS_ELEMENT_NAME);
            elem.setTextContent(this.m_dados);
            elementRoot.appendChild(elem);

            elem = doc.createElement(USERNAME_EXPOSITOR_ELEMENT_NAME);
            elem.setTextContent(this.m_usernameExpositor);
            elementRoot.appendChild(elem);

            if (this.m_estado.isEstadoCandidaturaInstanciada()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "instanciada");
            } else if (this.m_estado.isEstadoCandidaturaCriada()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "criada");
            }

            node = elementRoot;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CandidaturaADemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }
}
