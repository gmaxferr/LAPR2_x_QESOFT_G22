package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Avaliacao;
import lapr.project.model.FAE;
import lapr.project.model.FaeAvaliacao;
import lapr.project.model.Utilizador;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ricardo Osorio
 */
public class RegistoFaeAvaliacao implements Importable<RegistoFaeAvaliacao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoFaeAvaliacao";
    
    private List<FaeAvaliacao> m_listaFaeAvaliacao;

    public RegistoFaeAvaliacao() {
        this.m_listaFaeAvaliacao = new ArrayList<>();
    }

    public FaeAvaliacao getObjFaeDecisaoDoFae(String usernameFae) {
        for (FaeAvaliacao faeDecisao : m_listaFaeAvaliacao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFae)) {
                return faeDecisao;
            }
        }
        return null;
    }

    public Avaliacao getAvaliacaoDoFae(String usernameFAE) {
        for (FaeAvaliacao faeDecisao : m_listaFaeAvaliacao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFAE)) {
                return faeDecisao.getAvaliacao();
            }
        }
        return null;
    }

    public void addFaeAvaliacao(FAE fae) {
        this.m_listaFaeAvaliacao.add(new FaeAvaliacao(fae));
    }

    public List<FAE> getListaTodosFAE() {
        ArrayList<FAE> listaTodosFae = new ArrayList<>();
        for (FaeAvaliacao faeDecisao : m_listaFaeAvaliacao) {
            listaTodosFae.add(faeDecisao.getFaeAssociado());
        }
        return listaTodosFae;
    }

    public List<Utilizador> getListaUtilizadoresAssociadoAosFAE() {
        List<Utilizador> listaUtilizadoresAssociadoAosFAE = new ArrayList<>();
        for (FaeAvaliacao faeAvaliacao : this.m_listaFaeAvaliacao) {
            listaUtilizadoresAssociadoAosFAE.add(faeAvaliacao.getFaeAssociado().getUtilizador());
        }
        return listaUtilizadoresAssociadoAosFAE;
    }

    /**
     * Devolve a média dos ratings de todas as avaliações feitas pelos FAE neste
     * registo.
     *
     * @return média dos ratings de todas as avaliações feitas pelos FAE neste
     * registo
     */
    public float getMediaRatings() {
        int cont = this.m_listaFaeAvaliacao.size();
        float somaMediaRatingsDeCadaFAE = 0;
        for (FaeAvaliacao faeAvaliacao : m_listaFaeAvaliacao) {
            somaMediaRatingsDeCadaFAE += faeAvaliacao.getAvaliacao().getMediaRatings();
        }
        return somaMediaRatingsDeCadaFAE / cont;
    }
    
    @Override
    public RegistoFaeAvaliacao importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_listaFaeAvaliacao.clear();

                NodeList nList = elem.getElementsByTagName(FaeAvaliacao.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    FaeAvaliacao faeAvaliacao = new FaeAvaliacao();
                    faeAvaliacao.importContentFromXMLNode(n2);
                    this.m_listaFaeAvaliacao.add(faeAvaliacao);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoFaeAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
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

            for (FaeAvaliacao faeAvaliacao : this.m_listaFaeAvaliacao) {
                Node n = faeAvaliacao.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoFaeAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
