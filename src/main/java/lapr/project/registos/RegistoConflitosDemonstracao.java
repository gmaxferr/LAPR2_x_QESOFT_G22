package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um Registo de Conflitos Demonstração
 * 
 * @author G29
 */
public class RegistoConflitosDemonstracao implements Importable<RegistoConflitosDemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoConflitosDemonstracao";

    /**
     * Lista de conflitos de interesse
     */
    private final List<ConflitoDeInteresseDemonstracao> m_listaConflitos;

    /**
     * Construtor de objetos do tipo RegistoConflitosDemonstracao sem parâmetros
     */
    public RegistoConflitosDemonstracao() {
        this.m_listaConflitos = new ArrayList<>();
    }

    /**
     * Cria um conflito entre o FAE e a Candidatura passados como argumentos e
     * regista esse conflito.
     *
     * @param fae - FAE que conflite com uma Candidatura
     * @param cand - Candidatura com que o FAE conflite
     * @param tipoConflito - tipo de conflito da demonstração
     */
    public void criarConflito(FAE fae, CandidaturaADemonstracao cand, TipoConflitoDemonstracao tipoConflito) {
        ConflitoDeInteresseDemonstracao c = new ConflitoDeInteresseDemonstracao(fae, cand, tipoConflito);
        adiciona(c);
    }

    /**
     * Verifica se um conflito é válido, verificando se este já existe ou não.
     *
     * @param fae - FAE em conflito
     * @param cand - Candidatura em conflito
     * @param tipo - tipo de conflito da demonstração
     * @return true se for válido; false caso contrário.
     */
    public boolean valida(FAE fae, CandidaturaADemonstracao cand, TipoConflitoDemonstracao tipo) {
        boolean valido = true;
        for (ConflitoDeInteresseDemonstracao c : m_listaConflitos) {
            if (c.getFae().equals(fae) && c.getCandidatura().equals(cand) && c.getTipo().equals(tipo)) {
                valido = false;
            }
        }
        return valido;
    }

    /**
     * Devolve a lisat de conflitos de interesse
     *
     * @return a lista de conflitos de interesse
     */
    public List<ConflitoDeInteresseDemonstracao> getListaConflitos() {
        return m_listaConflitos;
    }

    /**
     * Remove um conflito da lista de conflitos de interesse
     *
     * @param c - Conflito a remover
     */
    public void remove(ConflitoDeInteresseDemonstracao c) {
        m_listaConflitos.remove(c);
    }

    /**
     * Adiciona um conflito da lista de conflitos de interesse
     *
     * @param c - Conflito a remover
     */
    public void adiciona(ConflitoDeInteresseDemonstracao c) {
        m_listaConflitos.add(c);
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     *
     * @param rc registo de candidaturas a exposição
     */
    public void fix(RegistoCandidaturasAExposicao rc) {
        for (ConflitoDeInteresseDemonstracao conf : m_listaConflitos) {
            conf.fix(rc);
        }
    }

    @Override
    public RegistoConflitosDemonstracao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document doc = XMLParser.createDocument(node, true);

        Node n = doc.getChildNodes().item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_listaConflitos.clear();

            NodeList nList = elem.getElementsByTagName(ConflitoDeInteresse.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);
                ConflitoDeInteresseDemonstracao conflito = new ConflitoDeInteresseDemonstracao(null, null, null);
                conflito.importContentFromXMLNode(n2);
                m_listaConflitos.add(conflito);
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

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            for (ConflitoDeInteresseDemonstracao conf : m_listaConflitos) {
                Node n = conf.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoConflitosDemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
