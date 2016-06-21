package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.TipoConflito;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um Registo Tipo de Conflitos
 * 
 * @author G29
 */
public class RegistoTipoConflitos implements Importable<RegistoTipoConflitos>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoTipoConflitos";
    public static final String NUM_CONFLITOS_ATTR_NAME = "numConflitos";
    
    /**
     * Contador de numero de conflitos
     */
    private int numConflitos = 0;
    
    /**
     * Prefixo de um tipo de conflito
     */
    private static final String m_prefix = "TC-";
    
    /**
     * Lista de tipos de conflito
     */
    private final List<TipoConflito> m_listaTipoConflitos;

    /**
     * Construtor de objetos do tipo RegistoTipoConflitos sem parâmetros
     */
    public RegistoTipoConflitos() {
        numConflitos = 0;
        this.m_listaTipoConflitos = new ArrayList<>();
    }

    /**
     * Devolve a lista de tipos de conflitos
     * 
     * @return lista de tipos de conflitos
     */
    public List<TipoConflito> getListaTipoConflitos() {
        return this.m_listaTipoConflitos;
    }

    /**
     * Cria um novo tipo de conflito
     * 
     * @return novo tipo de conflito
     */
    public TipoConflito novoTipoConflito() {
        return new TipoConflito(m_prefix + numConflitos++);
    }

    /**
     * Valida um tipo de conflito
     * 
     * @param tipoConflito tipo de conflito a validar
     * @return true se a lista de tipo de conflitos não conter o tipo de conflito
     * a validar. Caso contrário retorna false.
     */
    public boolean validaTipoDeConflito(TipoConflito tipoConflito) {
        return !m_listaTipoConflitos.contains(tipoConflito);
    }

    /**
     * Adiciona um tipo de conflito
     * 
     * @param tipoConflito tipo de conflito a ser adicionado
     * 
     * @return true se o tipo de conflito foi adicionado à lista de tipos de
     * conflito. Caso contrário retorna false.
     */
    public boolean add(TipoConflito tipoConflito) {
        boolean b = validaTipoDeConflito(tipoConflito);
        if (b) {
            m_listaTipoConflitos.add(tipoConflito);
        }
        return b;
    }

    @Override
    public RegistoTipoConflitos importContentFromXMLNode(Node node) {
        if(node == null){
            return this;
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_listaTipoConflitos.clear();
                
                NodeList nList = elem.getElementsByTagName(TipoConflito.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    TipoConflito tc = new TipoConflito("");
                    tc.importContentFromXMLNode(n2);
                    this.m_listaTipoConflitos.add(tc);
                }
                
                this.numConflitos = Integer.parseInt(elem.getAttribute(NUM_CONFLITOS_ATTR_NAME));
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoTipoConflitos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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

            for (TipoConflito tc : this.m_listaTipoConflitos) {
                Node n = tc.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }
            
            elementBase.setAttribute(NUM_CONFLITOS_ATTR_NAME, String.valueOf(numConflitos));

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoTipoConflitos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
