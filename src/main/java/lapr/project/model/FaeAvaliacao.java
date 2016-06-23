package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.registos.RegistoUtilizadores;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Classe que representa a ligação criada entre um FAE e a Candidatura que lhe
 * for atribuida para este avaliar
 *
 * @author G29
 */
public class FaeAvaliacao implements Importable<FaeAvaliacao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "FaeAvaliacao";

    /**
     * FAE designado para avaliar
     */
    private FAE m_FaeAssociado;

    /**
     * Avaliação do FAE
     */
    private Avaliacao m_avaliacao;

    /**
     * Construtor sem parametros
     */
    public FaeAvaliacao() {
        this.m_avaliacao = new Avaliacao();
    }

    /**
     * Construtor que recebe por parametro o FAE designado
     *
     * @param fae fae designado na atribuição
     */
    public FaeAvaliacao(FAE fae) {
        this();
        this.m_FaeAssociado = fae;
    }

    /**
     * Devolve o FAE designado para avaliar esta 
     *
     * @return Fae designado
     */
    public FAE getFaeAssociado() {
        return this.m_FaeAssociado;
    }

    /**
     * Devolve a avaliação
     * 
     * @return 
     */
    public Avaliacao getAvaliacao() {
        return this.m_avaliacao;
    }

    public void setAvaliacao(Avaliacao aval) {
        this.m_avaliacao = aval;
    }

    public void setAvalicao(int rat1, int rat2, int rat3, int rat4, int rat5) {
        this.m_avaliacao.setAvaliacaoCandidaturaAExposicao(rat1, rat2, rat3, rat4, rat5);
    }

    public void fix(RegistoUtilizadores m_registoUtilizadores) {
        for (Utilizador u : m_registoUtilizadores.getListaUtilizadores()) {
            if (m_FaeAssociado.getUtilizador().getUsername().equals(u.getUsername())) {
                this.m_FaeAssociado.setUtilizador(u);
                break;
            }
        }
    }

    @Override
    public FaeAvaliacao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        NodeList elementsKeyword = document.getChildNodes();

        Node n = elementsKeyword.item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_FaeAssociado = new FAE();
            this.m_FaeAssociado.importContentFromXMLNode(elem.getElementsByTagName(FAE.ROOT_ELEMENT_NAME).item(0));
            this.m_avaliacao = new Avaliacao();
            this.m_avaliacao.importContentFromXMLNode(elem.getElementsByTagName(Avaliacao.ROOT_ELEMENT_NAME).item(0));
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

            elementBase.appendChild(document.importNode(this.m_FaeAssociado.exportContentToXMLNode(), true));
            elementBase.appendChild(document.importNode(this.m_avaliacao.exportContentToXMLNode(), true));

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FaeAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
