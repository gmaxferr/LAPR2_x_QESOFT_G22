package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoAtribuicoes
 *
 * @author G29
 */
public class RegistoAtribuicoes implements Importable<RegistoAtribuicoes>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoAtribuicoes";

    /**
     * Lista de atribuicaoCandidatura
     */
    private List<AtribuicaoCandidatura> m_listaAtribuicao;

    /**
     * Construtor de objetos do tipo RegistoAtribuicoes sem parâmetros
     */
    public RegistoAtribuicoes() {
        this.m_listaAtribuicao = new ArrayList<>();
    }

    /**
     * Devolve as candidaturas atribuídas a um fae
     *
     * @param usernameFAE username do fae
     * @return candidaturas atribuídas a um fae
     */
    public ArrayList<AtribuicaoCandidatura> getListaAtribuicoesDoFAE(String usernameFAE) {
        ArrayList<AtribuicaoCandidatura> listaAtrib = new ArrayList<>();
        for (AtribuicaoCandidatura atribuicao : this.m_listaAtribuicao) {
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
    public ArrayList<AtribuicaoCandidatura> getListaAtribuicoesDoFAEEstadoAtribuidas(String usernameFAE) {
        ArrayList<AtribuicaoCandidatura> listaAtrib = new ArrayList<>();
        for (AtribuicaoCandidatura atribuicao : this.m_listaAtribuicao) {
            if (atribuicao.getCandidaturaAssociada().getEstado().isEstadoCandidaturaAtribuida()
                    && atribuicao.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(usernameFAE) != null) {
                listaAtrib.add(atribuicao);
            }
        }
        return listaAtrib;
    }

    /**
     * Devolve um vetor em que cada posição contem a média dos Ratings da
     * candidatura na mesma posição guardada no RegistoCandidaturas. Para aceder
     * à média dos ratings da terceira candidatura usar o vec[2].
     *
     * @return vetor com médias dos ratings de cada candidatura
     */
    public float[] getMediaRatingsTodasCandidaturas() {
        int cont = this.m_listaAtribuicao.size();
        float[] vec = new float[cont];
        for (int i = 0; i < cont; i++) {
            for (AtribuicaoCandidatura atribuicao : this.m_listaAtribuicao) {
                vec[i] = atribuicao.getRegistoFaeAvaliacao().getMediaRatings();
            }
        }
        return vec;
    }

    /**
     * Devolve a lista de atribuicaoCandidatura
     *
     * @return lista de atribuicaoCandidatura
     */
    public List<AtribuicaoCandidatura> getListaAtribuicoes() {
        return this.m_listaAtribuicao;
    }

    public void setListaAtribuicao(List<AtribuicaoCandidatura> listaAtribuicao) {
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
     * Valida a candidatura
     *
     * @param c candidatura
     * @return true se a candidatura for validada. Caso contrário retorna false
     */
    public boolean validarCandidatura(CandidaturaAExposicao c) {
        return c.validaCandidatura();
    }

    /**
     * Valida a decisao da candidatura
     *
     * @return true
     */
    public boolean validaDecidirCandidatura() {
        return true;
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     *
     * @param m_rce registo candidaturas a exposição
     * @param m_registoUtilizadores registo de utilizadores
     */
    public void fix(RegistoCandidaturasAExposicao m_rce, RegistoUtilizadores m_registoUtilizadores) {
        for (AtribuicaoCandidatura atr : m_listaAtribuicao) {
            atr.fix(m_rce, m_registoUtilizadores);
        }
    }

    /**
     *
     * @param node
     * @return
     */
    @Override
    public RegistoAtribuicoes importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_listaAtribuicao.clear();

                NodeList nList = elem.getElementsByTagName(AtribuicaoCandidatura.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    AtribuicaoCandidatura atrCand = new AtribuicaoCandidatura(null);
                    atrCand.importContentFromXMLNode(n2);
                    this.m_listaAtribuicao.add(atrCand);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoAtribuicoes.class.getName()).log(Level.SEVERE, null, ex);
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

            for (AtribuicaoCandidatura atrCand : this.m_listaAtribuicao) {
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
