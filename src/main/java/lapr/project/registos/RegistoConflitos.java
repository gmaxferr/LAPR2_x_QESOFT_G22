package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoConflitos
 * 
 * @author G29
 */
public class RegistoConflitos implements Importable<RegistoConflitos>, Exportable {
    
    public static final String ROOT_ELEMENT_NAME = "registoConflitos";

    /**
     * Lista de conflitos de interesse
     */
    private final List<ConflitoDeInteresse> m_listaConflitos;

    /**
     * Construtor de objetos do tipo RegistoConflitos sem parâmetros
     */
    public RegistoConflitos() {
        this.m_listaConflitos = new ArrayList<>();
    }

    /**
     * Cria um conflito entre o FAE e a Candidatura passados como argumentos e
     * regista esse conflito.
     *
     * @param fae - FAE que conflite com uma Candidatura
     * @param cand - Candidatura com que o FAE conflite
     */
    public void criarConflito(FAE fae, CandidaturaAExposicao cand, TipoConflito tipoConflito) {
        ConflitoDeInteresse c = new ConflitoDeInteresse(fae, cand, tipoConflito);
        adiciona(c);
    }

    /**
     * Verifica se um conflito é válido, verificando se este já existe ou não.
     *
     * @param fae - FAE em conflito
     * @param cand - Candidatura em conflito
     * @return true se for válido; false caso contrário.
     */
    public boolean valida(FAE fae, CandidaturaAExposicao cand, TipoConflito tipo) {
        boolean valido = true;
        for (ConflitoDeInteresse c : m_listaConflitos) {
            if (c.getFae().equals(fae) && c.getCandidatura().equals(cand) && c.getTipo().equals(tipo)) {
                valido = false;
            }
        }
        return valido;
    }

    /**
     * Devolve a lisat de conflitos de interesse
     * 
     * @return a lista de conflitos
     */
    public List<ConflitoDeInteresse> getListaConflitos() {
        return m_listaConflitos;
    }

    /**
     * Remove um conflito da lista de conflitos de interesse
     *
     * @param c - Conflito a remover
     */
    public void remove(ConflitoDeInteresse c) {
        m_listaConflitos.remove(c);
    }

    /**
     * Adiciona um conflito da lista de conflitos de interesse
     *
     * @param c - Conflito a remover
     */
    public void adiciona(ConflitoDeInteresse c) {
        m_listaConflitos.add(c);
    }

    @Override
    public RegistoConflitos importContentFromXMLNode(Node node) {
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
                
                this.m_listaConflitos.clear();
                
                NodeList nList = elem.getElementsByTagName(ConflitoDeInteresse.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    ConflitoDeInteresse conflito = new ConflitoDeInteresse(null, null, null);
                    conflito.importContentFromXMLNode(n2);
                    m_listaConflitos.add(conflito);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoConflitos.class.getName()).log(Level.SEVERE, null, ex);
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

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            for (ConflitoDeInteresse conf : m_listaConflitos) {
                Node n = conf.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoConflitos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
