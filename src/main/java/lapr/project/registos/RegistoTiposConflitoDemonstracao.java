package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.TipoConflitoDemonstracao;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author G29
 */
public class RegistoTiposConflitoDemonstracao implements Importable<RegistoTiposConflitoDemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoTipoConflitosDemonstracao";
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
    private final List<TipoConflitoDemonstracao> m_listaTipoConflitos;

    /**
     * Construtor de objetos do tipo RegistoTipoConflitos sem parâmetros
     */
    public RegistoTiposConflitoDemonstracao() {
        numConflitos = 0;
        this.m_listaTipoConflitos = new ArrayList<>();
    }

    /**
     * Devolve a lista de tipos de conflitos
     *
     * @return lista de tipos de conflitos
     */
    public List<TipoConflitoDemonstracao> getListaTipoConflitos() {
        return this.m_listaTipoConflitos;
    }

    /**
     * Cria um novo tipo de conflito
     *
     * @return novo tipo de conflito
     */
    public TipoConflitoDemonstracao novoTipoConflito() {
        return new TipoConflitoDemonstracao(m_prefix + numConflitos++);
    }

    /**
     * Valida um tipo de conflito
     *
     * @param tipoConflito tipo de conflito a validar
     * @return true se a lista de tipo de conflitos não conter o tipo de
     * conflito a validar. Caso contrário retorna false.
     */
    public boolean validaTipoDeConflito(TipoConflitoDemonstracao tipoConflito) {
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
    public boolean add(TipoConflitoDemonstracao tipoConflito) {
        boolean b = validaTipoDeConflito(tipoConflito);
        if (b) {
            m_listaTipoConflitos.add(tipoConflito);
        }
        return b;
    }

    @Override
    public RegistoTiposConflitoDemonstracao importContentFromXMLNode(Node node) {
        try {
            Document doc = XMLParser.createDocument(node, true);

            Node n = doc.getChildNodes().item(0);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_listaTipoConflitos.clear();
                
                NodeList nList = elem.getElementsByTagName(TipoConflitoDemonstracao.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    TipoConflitoDemonstracao tc = new TipoConflitoDemonstracao("");
                    tc.importContentFromXMLNode(n2);
                    this.m_listaTipoConflitos.add(tc);
                }
                
                this.numConflitos = Integer.parseInt(elem.getAttribute(NUM_CONFLITOS_ATTR_NAME));
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoTiposConflitoDemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);

            for (TipoConflitoDemonstracao tc : this.m_listaTipoConflitos) {
                Node n = tc.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }
            
            elementBase.setAttribute(NUM_CONFLITOS_ATTR_NAME, String.valueOf(numConflitos));

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoTiposConflitoDemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
