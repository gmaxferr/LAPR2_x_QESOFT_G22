package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoAtribuicoesCandidaturasExposicao
 *
 * @author G29
 */
public class RegistoAtribuicoesCandidaturasExposicao implements Importable<RegistoAtribuicoesCandidaturasExposicao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoAtribuicoes";

    /**
     * Lista de atribuicaoCandidatura
     */
    private List<AtribuicaoCandidatura> m_listaAtribuicao;

    /**
     * Construtor de objetos do tipo RegistoAtribuicoes sem parâmetros
     */
    public RegistoAtribuicoesCandidaturasExposicao() {
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
    public float[] getMediaRatingsTodasCandidaturasAExposicao() {
        int cont = this.m_listaAtribuicao.size();
        float[] vec = new float[cont];
        int i = 0;

        for (AtribuicaoCandidatura atribuicao : this.m_listaAtribuicao) {
            vec[i] = atribuicao.getRegistoFaeAvaliacao().getMediaDeTodosOsRatingsCandidaturaAExposicao();
            i++;
        }

        return vec;
    }

    /**
     * Devolve uma matriz com as médias dos ratings por critério de cada
     * candidatura. Cada linha da matriz corresponde a uma candidatura e cada
     * coluna à média de um rating especifico. A ordem das candidaturas é mesma
     * pela que estão no registo de candidaturas e a ordem das médias dos
     * ratings é a mesma que é apresentada ao utilizador na UI Avaliar
     * candidaturas
     *
     * @return matriz com as médias dos ratings por critério de cada candidatura
     */
    public float[][] getMediaRatingsPorCriterioDasCandidaturas() {
        float[][] matriz = new float[this.m_listaAtribuicao.size()][5];
        int pos = 0;

        for (AtribuicaoCandidatura atribuicao : this.m_listaAtribuicao) {
            atribuicao.getRegistoFaeAvaliacao().somarRatingsDaCandidaturaAExposicaoAMatriz(matriz, pos);
            pos++;
        }

        return matriz;
    }

    /**
     * Devolve a lista de atribuicaoCandidatura
     *
     * @return lista de atribuicaoCandidatura
     */
    public List<AtribuicaoCandidatura> getListaAtribuicoes() {
        return this.m_listaAtribuicao;
    }

    /**
     * Define uma nova lista de atribuições dos FAE pelas candidaturas
     *
     * @param listaAtribuicao nova lista de atribuições
     */
    public void setListaAtribuicao(List<AtribuicaoCandidatura> listaAtribuicao) {
        this.m_listaAtribuicao = listaAtribuicao;
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

    @Override
    public RegistoAtribuicoesCandidaturasExposicao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document doc = XMLParser.createDocument(node, true);

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

            for (AtribuicaoCandidatura atrCand : this.m_listaAtribuicao) {
                Node n = atrCand.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoAtribuicoesCandidaturasExposicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

}
