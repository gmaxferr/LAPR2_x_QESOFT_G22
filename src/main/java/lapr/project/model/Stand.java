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
    
    public static final String ROOT_ELEMENT_NAME = "Stand";
    
    public static final String ID_ELEMENT_NAME = "Id";
    public static final String AREA_ELEMENT_NAME = "Area";

    private String m_ID;
    private int m_area;

    public Stand(String m_ID, int m_area) {
        this.m_ID = m_ID;
        this.m_area = m_area;
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
    public void setM_area(int area) {
        this.m_area = area;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Stand) {
            Stand stand = (Stand) obj;
            if (this.m_ID.equals(stand.getID())) {
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
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.appendChild(document.importNode(node, true));

            NodeList elementsKeyword = document.getChildNodes();

            Node n = elementsKeyword.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_ID = elem.getElementsByTagName(ID_ELEMENT_NAME).item(0).getTextContent();
                this.m_area = Integer.parseInt(elem.getElementsByTagName(ID_ELEMENT_NAME).item(0).getTextContent());
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
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementBase);
            
            Element elemChild = document.createElement(ID_ELEMENT_NAME);
            elemChild.setTextContent(this.m_ID);
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(AREA_ELEMENT_NAME);
            elemChild.setTextContent(String.valueOf(this.m_area));
            elementBase.appendChild(elemChild);
            
            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Stand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
