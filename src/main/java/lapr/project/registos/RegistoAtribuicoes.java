package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoAtribuicoes implements Importable<RegistoAtribuicoes>, Exportable {
    
    public static final String ROOT_ELEMENT_NAME = "RegistoAtribuicoes";

    private List<AtribuicaoCandidatura> m_listaAtribuicao;

    public RegistoAtribuicoes() {
        this.m_listaAtribuicao = new ArrayList<>();
    }

    public List<AtribuicaoCandidatura> getListaAtribuicoes() {
        return this.m_listaAtribuicao;
    }

    public ArrayList getDadosCandidatura(CandidaturaAExposicao c) {
        return c.getDadosCandidatura();
    }

    public boolean validarCandidatura(CandidaturaAExposicao c) {
        return c.validaCandidatura();
    }

    /**
     * Métoto que define nova decisao
     *
     * @param candidaturaAExposicao
     * @param decisao nova decisao
     */
    public void setAvaliacao(CandidaturaAExposicao candidaturaAExposicao, boolean decisao) {
        candidaturaAExposicao.setDecisao(decisao);
    }

    /**
     * Método que valida a decisao da candidatura
     *
     * @return boolean de confirmação de validação
     */
    public boolean validaDecidirCandidatura() {
        return true;
    }

    public void setListaAtribuicao(List<AtribuicaoCandidatura> listaAtribuicao) {
        this.m_listaAtribuicao = listaAtribuicao;
    }

    public ArrayList<AtribuicaoCandidatura> getListaAtribuicoesDoFAE(String usernameFAE) {
        ArrayList<AtribuicaoCandidatura> listaAtrib = new ArrayList<>();
        for (AtribuicaoCandidatura atribuicao : this.m_listaAtribuicao) {
            if (atribuicao.getCandidaturaAssociada().getEstado().isEstadoCandidaturaAtribuida()
                    && atribuicao.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(usernameFAE).getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFAE)) {
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
