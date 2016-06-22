package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.AtribuicaoCandidaturaDemonstracao;
import lapr.project.model.CandidaturaAExposicao;
import static lapr.project.registos.RegistoAtribuicoes.ROOT_ELEMENT_NAME;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ana Leite
 */
public class RegistoAtribuicoesDemonstracao implements Importable<RegistoAtribuicoesDemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoAtribuicoes";

    /**
     * Lista de atribuicaoCandidatura
     */
    private List<AtribuicaoCandidaturaDemonstracao> m_listaAtribuicao;

    /**
     * Construtor de objetos do tipo RegistoAtribuicoes sem parâmetros
     */
    public RegistoAtribuicoesDemonstracao() {
        this.m_listaAtribuicao = new ArrayList<>();
    }

    /**
     * Devolve as candidaturas atribuídas a um fae
     *
     * @param usernameFAE username do fae
     * @return candidaturas atribuídas a um fae
     */
    public ArrayList<AtribuicaoCandidaturaDemonstracao> getListaAtribuicoesDoFAE(String usernameFAE) {
        ArrayList<AtribuicaoCandidaturaDemonstracao> listaAtrib = new ArrayList<>();
        for (AtribuicaoCandidaturaDemonstracao atribuicao : this.m_listaAtribuicao) {
            if (atribuicao.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(usernameFAE) != null) {
                listaAtrib.add(atribuicao);
            }
        }
        return listaAtrib;
    }

    /**
     * Devolve as candidaturas atribuídas a um fae que se encontrem no estado
     * atribuidas
     *
     * @param usernameFAE username do fae
     * @return candidaturas atribuídas a um fae
     */
    public ArrayList<AtribuicaoCandidaturaDemonstracao> getListaAtribuicoesDoFAEEstadoAtribuidas(String usernameFAE) {
        ArrayList<AtribuicaoCandidaturaDemonstracao> listaAtrib = new ArrayList<>();
        for (AtribuicaoCandidaturaDemonstracao atribuicao : this.m_listaAtribuicao) {
            if (atribuicao.getCandidaturaAssociada().getEstado().isEstadoCandidaturaADemonstracaoAtribuida()
                    && atribuicao.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(usernameFAE) != null) {
                listaAtrib.add(atribuicao);
            }
        }
        return listaAtrib;
    }

    /**
     * Devolve a lista de atribuicaoCandidatura
     *
     * @return lista de atribuicaoCandidatura
     */
    public List<AtribuicaoCandidaturaDemonstracao> getListaAtribuicoes() {
        return this.m_listaAtribuicao;
    }

    public void setListaAtribuicao(List<AtribuicaoCandidaturaDemonstracao> listaAtribuicao) {
        this.m_listaAtribuicao = listaAtribuicao;
    }

    /**
     * Define nova decisao
     *
     * @param candidaturaAExposicao candidatura
     * @param decisao nova decisao
     */
    public void setAvaliacao(CandidaturaAExposicao candidaturaAExposicao, boolean decisao) {
        candidaturaAExposicao.setDecisao(decisao);
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     *
     * @param m_rcd
     * @param m_registoUtilizadores registo de utilizadores
     */
    public void fix(RegistoCandidaturasADemonstracoes m_rcd, RegistoUtilizadores m_registoUtilizadores) {
        for (AtribuicaoCandidaturaDemonstracao atr : m_listaAtribuicao) {
            atr.fix(m_rcd, m_registoUtilizadores);
        }
    }

    /**
     *
     * @param node
     * @return
     */
    @Override
    public RegistoAtribuicoesDemonstracao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document doc = XMLParser.createDocument(node, true);

        Node n = doc.getChildNodes().item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_listaAtribuicao.clear();

            NodeList nList = elem.getElementsByTagName(AtribuicaoCandidatura.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);
                AtribuicaoCandidaturaDemonstracao atrCand = new AtribuicaoCandidaturaDemonstracao(null);
                atrCand.importContentFromXMLNode(n2);
                this.m_listaAtribuicao.add(atrCand);
            }
        }

        return this;
    }

    /**
     *
     * @return
     */
    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            for (AtribuicaoCandidaturaDemonstracao atrCand : this.m_listaAtribuicao) {
                Node n = atrCand.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoAtribuicoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
