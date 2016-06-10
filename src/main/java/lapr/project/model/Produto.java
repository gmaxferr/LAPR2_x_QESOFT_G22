package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Representação de um produto
 *
 * @author Ricardo Osório Ana Leite
 */
public class Produto implements Importable<Produto>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Produto";
    public static final String NOME_ELEMENT_NAME = "Nome";
    
    /**
     * Atributo m_nome do produto
     */
    private String m_nome;

    /**
     * Construtor de objectos do tipo Produto com parametro m_nome
     *
     * @param nome m_nome do produto
     */
    public Produto(String nome) {
        this.m_nome = nome;
    }

    /**
     * Construtor de objectos do tipo Produto sem parametros
     */
    public Produto() {

    }

    /**
     * Devolve o atributo m_nome de rganizador
     *
     * @return m_nome de organizador;
     */
    public String getNome() {
        return m_nome;
    }

    /**
     * Define um novo m_nome de organizador
     *
     * @param nome novo m_nome de organizador
     */
    public void setNome(String nome) {
        this.m_nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }else{
            if (obj instanceof Produto){
                if(obj == this){
                    return true;
                }
                Produto o = (Produto) obj;
                return o.getNome().equals(this.m_nome);
            }else{
                return false;
            }
        }
    }

    @Override
    public Produto importContentFromXMLNode(Node node) {
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
                this.m_nome = elem.getElementsByTagName(NOME_ELEMENT_NAME).item(0).getTextContent();
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
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

            Element elementProduto = document.createElement(ROOT_ELEMENT_NAME);
            Element elementNome = document.createElement(NOME_ELEMENT_NAME);

            elementNome.setTextContent(this.m_nome);
            elementProduto.appendChild(elementNome);

            document.appendChild(elementProduto);

            node = elementProduto;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
