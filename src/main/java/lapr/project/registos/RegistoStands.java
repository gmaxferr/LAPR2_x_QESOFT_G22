package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.exceptions.AreaErradaException;
import lapr.project.model.Stand;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um registo de stands.
 *
 * @author G29
 */
public class RegistoStands implements Importable<RegistoStands>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "stands";

    /**
     * Lista de Stands
     */
    private final List<Stand> m_listaStands;

    /**
     * Construtor de objetos do tipo RegistoStands sem parâmetros
     */
    public RegistoStands() {
        this.m_listaStands = new ArrayList<>();
    }

    /**
     * Devolve a lista de stands
     *
     * @return lista de stands
     */
    public List<Stand> getListaStands() {
        return m_listaStands;
    }

    /**
     * Adiciona um stand à lista de stands
     *
     * @param stand stand a adicionar à lista
     */
    public void addStand(Stand stand) {
        this.m_listaStands.add(stand);
    }

    /**
     * Cria um novo stand.
     *
     * @param ID ID do novo stand
     * @param area area do novo stand
     * @param descricao descricao no novo stand
     * @return true se o stand for adicionado à lista de stands. Caso contrário
     * retorna false.
     * @throws AreaErradaException
     */
    public boolean criarStand(String ID, String area, String descricao) throws AreaErradaException {
        try {
            int areaDoStand = Integer.parseInt(area);
            if (areaDoStand < 0) {
                throw new AreaErradaException("A área introduzida não é válida!");
            }
            Stand novoStand = new Stand(ID, areaDoStand, descricao);
            if (validarStand(novoStand)) {
                this.m_listaStands.add(novoStand);
                return true;
            }
            return false;
        } catch (IllegalArgumentException expection) {
            throw new AreaErradaException("A área introduzida não é válida!");
        }

    }

    /**
     * Valida o stand, verificando se já existe na lista de stands
     *
     * @param novoStand stand a validar
     * @return true se o stand não existir na lista de stands. Caso contrário
     * retorna false.
     */
    private boolean validarStand(Stand novoStand) {
        for (Stand stand : m_listaStands) {
            if (novoStand.equals(stand)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public RegistoStands importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_listaStands.clear();

                NodeList nList = elem.getElementsByTagName(Stand.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    Stand stand = new Stand("", 0, "");
                    stand.importContentFromXMLNode(n2);
                    this.m_listaStands.add(stand);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoStands.class.getName()).log(Level.SEVERE, null, ex);
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

            for (Stand stand : this.m_listaStands) {
                Node n = stand.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoStands.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
