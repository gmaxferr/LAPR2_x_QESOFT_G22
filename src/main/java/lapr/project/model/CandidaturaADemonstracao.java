package lapr.project.model;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.CandidaturaADemonstracao.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author G29
 */
public class CandidaturaADemonstracao implements Importable<CandidaturaADemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "dandidaturaADemonstracao";
    public static final String DADOS_ELEMENT_NAME = "dados";
    public static final String USERNAME_EXPOSITOR_ELEMENT_NAME = "usernameExpositor";
    public static final String ESTADO_ATTR_NAME = "estado";

    /**
     * Não sabemos como é constituida uma candidatura a uma demonstração, por
     * isso optamos apenas por descreve-la com uma string que representa todos
     * os possíveis atributos que esta candidtura possa ter.
     */
    private String m_dados;
    private String m_emailExpositor;

    private EstadoCandidaturaADemonstracao m_estado;

    public CandidaturaADemonstracao(String dados, String email) {
        this.m_dados = dados;
        m_estado = new EstadoCandidaturaADemonstracaoInstanciada(this);
        m_emailExpositor = email;
    }

    /**
     * Devolve os dados da candidatura
     *
     * @return dados da candidatura
     */
    public String getDadosCandidatura() {
        return m_dados;
    }

    /**
     *
     * @return username do expositor
     */
    public String getEmailExpositor() {
        return m_emailExpositor;
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

    /**
     * Altera os dados da candidatura
     */
    public void setDados(String novosDados) {
        m_dados = novosDados;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof CandidaturaADemonstracao) {
            CandidaturaADemonstracao o = (CandidaturaADemonstracao) obj;
            String oDados = o.getDadosCandidatura();
            if (oDados != null && this.m_dados.equals(oDados)) {
                if (this.m_emailExpositor.equals(o.getEmailExpositor())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.m_dados);
        hash = 43 * hash + Objects.hashCode(this.m_emailExpositor);
        return hash;
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
                this.m_emailExpositor = elem.getElementsByTagName(USERNAME_EXPOSITOR_ELEMENT_NAME).item(0).getTextContent();

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
            elem.setTextContent(this.m_emailExpositor);
            elementRoot.appendChild(elem);

            if (this.m_estado.isEstadoCandidaturaADemonstracaoInstanciada()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "instanciada");
            } else if (this.m_estado.isEstadoCandidaturaADemonstracaoCriada()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "criada");
            }

            node = elementRoot;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CandidaturaADemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }

}
