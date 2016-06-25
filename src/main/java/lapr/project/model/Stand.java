package lapr.project.model;

import java.util.Objects;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um Stand
 * 
 * @author G29
 */
public class Stand implements Importable<Stand>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "stand";

    public static final String ID_ATTR_NAME = "id";
    public static final String AREA_ATTR_NAME = "area";
    public static final String DESCR_ELEMENT_NAME = "descricao";

    /**
     * ID do stand
     */
    private String m_ID;
    
    /**
     * Area do stand
     */
    private int m_area;
    
    /**
     * Descrição do stand
     */
    private String m_descricao;

    /**
     * Construtor de objetos do tipo Stand com os parametros ID, area e descrição
     * 
     * @param m_ID ID do stand
     * @param m_area area do Stand
     * @param descricao descricao do Stand
     */
    public Stand(String m_ID, int m_area, String descricao) {
        this.m_ID = m_ID;
        this.m_area = m_area;
        this.m_descricao = descricao;
    }

    /**
     * Devolve o ID do stand
     * @return the ID
     */
    public String getID() {
        return m_ID;
    }

    /**
     * Modifica o ID do stand
     * @param ID novo ID do stand
     */
    public void setID(String ID) {
        this.m_ID = ID;
    }

    /**
     * Devolve a area do stand
     * @return area do stand
     */
    public int getArea() {
        return m_area;
    }

    /**
     * Modifica a area do stand
     * 
     * @param area nova area do stand
     */
    public void setArea(int area) {
        this.m_area = area;
    }

    /**
     * Devolve a descrição deste stand
     * 
     * @return descrição deste stand
     */
    public String getDescricao() {
        return m_descricao;
    }

    /**
     * Modifica a descrição para este Stand
     *
     * @param descricao nova descricao do stand
     */
    public void setDescricao(String descricao) {
        this.m_descricao = descricao;
    }

    /**
     * Devolve as carateristicas do stand (ID)
     * 
     * @return carateristicas do stand (ID)
     */
    @Override
    public String toString() {
        return this.m_ID;
    }

    /**
     * Compara o stand a outro objecto passado por parametro. A comparação
     * entre dois stands é feita com atenção a alguns todos os atributos
     * desta.
     *
     * @param obj objecto a comparar com o stand
     * @return true se o objeto recebido representar um stand equivalente
     * ao stand. Caso contrário, retorna false.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Stand) {
            Stand stand = (Stand) obj;
            if (this.m_ID.equals(stand.getID()) && this.m_area == ((Stand) obj).getArea()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.m_ID);
        hash = 11 * hash + this.m_area;
        return hash;
    }

    @Override
    public Stand importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        NodeList elementsKeyword = document.getChildNodes();

        Node n = elementsKeyword.item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_ID = elem.getAttribute(ID_ATTR_NAME);
            String input = elem.getAttribute(AREA_ATTR_NAME);
            if (!input.isEmpty()) {
                this.m_area = Integer.parseInt(input);
            }
            this.m_descricao = elem.getElementsByTagName(DESCR_ELEMENT_NAME).item(0).getTextContent();
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementBase);

            elementBase.setAttribute(ID_ATTR_NAME, m_ID);
            elementBase.setAttribute(AREA_ATTR_NAME, String.valueOf(m_area));

            Element elemChild = document.createElement(DESCR_ELEMENT_NAME);
            elemChild.setTextContent(m_descricao);
            elementBase.appendChild(elemChild);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Stand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
