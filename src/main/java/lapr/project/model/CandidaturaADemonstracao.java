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
 * Representação de uma candidatura a demonstração
 * 
 * @author G29
 */
public class CandidaturaADemonstracao implements Importable<CandidaturaADemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "candidaturaADemonstracao";
    public static final String DADOS_ELEMENT_NAME = "dados";
    public static final String USERNAME_EXPOSITOR_ELEMENT_NAME = "usernameExpositor";
    public static final String ESTADO_ATTR_NAME = "estado";

    /**
     * Não sabemos como é constituida uma candidatura a uma demonstração, por
     * isso optamos apenas por descreve-la com uma string que representa todos
     * os possíveis atributos que esta candidtura possa ter.
     */
    private String m_dados;
    
    /**
     * Email do expositor da candidatura
     */
    private String m_emailExpositor;
    
    /**
     * Demonstração
     */
    private Demonstracao m_demo;
    
    /**
     * Decisão
     */
    private boolean decisao;

    /**
     * Estado candidatura a demonstração
     */
    private EstadoCandidaturaADemonstracao m_estado;

    /**
     * Construtor de objetos do tipo CandidaturaADemonstracao com os parâmetros
     * dados e email
     * @param dados dados da candidatura a demonstracao
     * @param email email do expositor da candidatura
     */
    public CandidaturaADemonstracao(String dados, String email) {
        this.m_dados = dados;
        m_estado = new EstadoCandidaturaADemonstracaoInstanciada(this);
        m_emailExpositor = email;
    }
    
    /**
     * Devolve o código de identificação da demonstração
     * @return 
     */
    public String getCodigoDemo(){
        return m_demo.getCodigoIdentificacao();
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
     * Devolve o email do expositor
     * @return email do expositor
     */
    public String getEmailExpositor() {
        return m_emailExpositor;
    }

    /**
     * Devolve o estado da candidatura a demonstração
     * 
     * @return estado desta candidatura a demonstracao
     */
    public EstadoCandidaturaADemonstracao getEstado() {
        return m_estado;
    }

    /**
     * Modifica a demonstração
     * @param d 
     */
    public void setDemonstracao(Demonstracao d){
        this.m_demo = d;
    }
    
    /**
     * Altera o estado da candidatura
     *
     * @param novoEstado novo estado
     */
    public void setEstado(EstadoCandidaturaADemonstracao novoEstado) {
        m_estado = novoEstado;
    }

    /**
     * Modifica os dados da candidatura
     * 
     * @param novosDados novos dados da candidatura
     */
    public void setDados(String novosDados) {
        m_dados = novosDados;
    }

    
    /**
     * Compara a CandidaturaADemonstração a outro objecto passado por parametro. A comparação
     * entre duas CandidaturaADemonstração é feita com atenção a alguns todos os atributos
     * desta.
     *
     * @param obj objecto a comparar com a CandidaturaADemonstração
     * @return true se o objeto recebido representar uma CandidaturaADemonstração equivalente
     * à CandidaturaADemonstração. Caso contrário, retorna false.
        */
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
    public CandidaturaADemonstracao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        if(node == null){
            return this;
        }
        
        Document doc = XMLParser.createDocument(node, true);

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
                case "prontaAtribuicao":
                    this.m_estado = new EstadoCandidaturaADemonstracaoProntaAAtribuicao(this);
                    break;
                case "atribuida":
                    this.m_estado = new EstadoCandidaturaADemonstracaoAtribuida(this);
                    break;
                case "avaliada":
                    this.m_estado = new EstadoCandidaturaADemonstracaoAvaliada(this);
                    break;
                case "aceite":
                    this.m_estado = new EstadoCandidaturaADemonstracaoAceite(this);
                    break;
                case "recusada":
                    this.m_estado = new EstadoCandidaturaADemonstracaoRecusada(this);
                    break;
                case "removida":
                    this.m_estado = new EstadoCandidaturaADemonstracaoRemovida(this);
                    break;
                default:
                    break;
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
            } else if (this.m_estado.isEstadoCandidaturaADemonstracaoProntaAAtribuicao()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "prontaAtribuicao");
            } else if (this.m_estado.isEstadoCandidaturaADemonstracaoAtribuida()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "atribuida");
            } else if (this.m_estado.isEstadoCandidaturaADemonstracaoAvaliada()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "avaliada");
            } else if (this.m_estado.isEstadoCandidaturaADemonstracaoAceite()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "aceite");
            } else if (this.m_estado.isEstadoCandidaturaADemonstracaoRecusada()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "recusada");
            } else if (this.m_estado.isEstadoCandidaturaADemonstracaoRemovida()) {
                elementRoot.setAttribute(ESTADO_ATTR_NAME, "removida");
            }

            node = elementRoot;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CandidaturaADemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }

    public void setEmailExpositor(String email) {
        this.m_emailExpositor = email;
    }

    /**
     * @return the decisao
     */
    public boolean getDecisao() {
        return decisao;
    }

    /**
     * @param decisao the decisao to set
     */
    public void setDecisao(boolean decisao) {
        this.decisao = decisao;
    }

}
