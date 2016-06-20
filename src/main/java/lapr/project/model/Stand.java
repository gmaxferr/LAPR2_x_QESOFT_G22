package lapr.project.model;

import java.util.Objects;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author Ricardo Catalao
 */
public class Stand implements Importable<Stand>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "stand";

    public static final String ID_ATTR_NAME = "id";
    public static final String AREA_ATTR_NAME = "area";
    public static final String DESCR_ELEMENT_NAME = "descricao";

    private String m_ID;
    private int m_area;
    private String m_descricao;

    public Stand(String m_ID, int m_area, String descricao) {
        this.m_ID = m_ID;
        this.m_area = m_area;
        this.m_descricao = descricao;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return m_ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.m_ID = ID;
    }

    /**
     * @return the area
     */
    public int getArea() {
        return m_area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(int area) {
        this.m_area = area;
    }

    /**
     * @return Devolve a descrição deste stand
     */
    public String getDescricao() {
        return m_descricao;
    }

    /**
     * Define uma descrição para este Stand
     *
     * @param descricao nova descricao do stand
     */
    public void setDescricao(String descricao) {
        this.m_descricao = descricao;
    }

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
    public Stand importContentFromXMLNode(Node node) {
        try {
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
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Stand.class.getName()).log(Level.SEVERE, null, ex);
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
