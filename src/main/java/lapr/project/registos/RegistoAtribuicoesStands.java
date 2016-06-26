package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.AtribuicaoStand;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoAtribuicoesStands
 *
 * @author G29
 */
public class RegistoAtribuicoesStands implements Importable<RegistoAtribuicoesStands>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoAtribuicoesStands";

    /**
     * Lista de atribuições stand
     */
    private List<AtribuicaoStand> m_listaAtribuicoesStand;

    /**
     * Construtor de objetos do tipo RegistoAtribuicoesStands sem parâmetros
     */
    public RegistoAtribuicoesStands() {
        this.m_listaAtribuicoesStand = new ArrayList<>();
    }

    /**
     * Devolve a lista de atribuições stand
     *
     * @return listaAtribuicoesStand
     */
    public List<AtribuicaoStand> getListaAtribuicoesStand() {
        return m_listaAtribuicoesStand;
    }

    /**
     * Modidica a lista de atribuicoes stand
     *
     * @param listaAtribuicoesStand nova listaAtribuicoesStand
     */
    public void setListaAtribuicoesStand(List<AtribuicaoStand> listaAtribuicoesStand) {
        this.m_listaAtribuicoesStand = listaAtribuicoesStand;
    }

    /**
     * Adiciona todas as atribuições passadas como argumento à lista de
     * atribuicoes de stands
     *
     * @param listAtr atribuicoes a ser adicionadas
     */
    public void addAll(List<AtribuicaoStand> listAtr) {
        m_listaAtribuicoesStand.addAll(listAtr);
    }

    /**
     * Devolve a lista de atribuições do stand de um representante
     *
     * @param email email de um representante
     * @return lista de atribuições do stand de um representante
     */
    public List<AtribuicaoStand> getListAtribuicoesStandDoRepresentante(String email) {
        List<AtribuicaoStand> listaAtribuicoesStandRepresentante = new ArrayList<>();
        for (AtribuicaoStand as : m_listaAtribuicoesStand) {
            if (as.getCand().getExpositor().getEmail().equalsIgnoreCase(email)) {
                listaAtribuicoesStandRepresentante.add(as);
            }
        }
        return listaAtribuicoesStandRepresentante;
    }

    @Override
    public RegistoAtribuicoesStands importContentFromXMLNode(Node node) throws ParserConfigurationException {
        if (node == null) {
            return this;
        }
        Document doc = XMLParser.createDocument(node, true);

        Node n = doc.getChildNodes().item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_listaAtribuicoesStand.clear();

            NodeList nList = elem.getElementsByTagName(AtribuicaoStand.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);
                AtribuicaoStand atrStand = new AtribuicaoStand(null, null, false);
                atrStand.importContentFromXMLNode(n2);
                this.m_listaAtribuicoesStand.add(atrStand);
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
            Document document = builder.newDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);

            for (AtribuicaoStand atrStand : this.m_listaAtribuicoesStand) {
                elementBase.appendChild(atrStand.exportContentToXMLNode());
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoAtribuicoesStands.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
