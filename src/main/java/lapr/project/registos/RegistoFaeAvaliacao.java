package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoFaeAvaliação
 *
 * @author G29
 */
public class RegistoFaeAvaliacao implements Importable<RegistoFaeAvaliacao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoFaeAvaliacao";

    /**
     * Lista de FaeAvaliação
     */
    private final List<FaeAvaliacao> m_listaFaeAvaliacao;

    /**
     * Construtor de objectos do tipo RegistoFaeAvaliacao sem parâmetros
     */
    public RegistoFaeAvaliacao() {
        this.m_listaFaeAvaliacao = new ArrayList<>();
    }

    /**
     * Devolve o objeto faeDecisao
     *
     * @param usernameFae username do fae
     * @return objeto faeDecisao
     */
    public FaeAvaliacao getObjFaeDecisaoDoFae(String usernameFae) {
        for (FaeAvaliacao faeDecisao : m_listaFaeAvaliacao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFae)) {
                return faeDecisao;
            }
        }
        return null;
    }

    /**
     * Devolve a avaliação de um fae
     *
     * @param usernameFAE username de um fae
     * @return avaliação de um fae
     */
    public Avaliacao getAvaliacaoDoFae(String usernameFAE) {
        for (FaeAvaliacao faeDecisao : m_listaFaeAvaliacao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFAE)) {
                return faeDecisao.getAvaliacao();
            }
        }
        return null;
    }

    /**
     * Adiciona um fae à lista FaeAvaliação
     *
     * @param fae fae a ser adicionado
     */
    public void addFaeAvaliacao(FAE fae) {
        this.m_listaFaeAvaliacao.add(new FaeAvaliacao(fae));
    }

    /**
     * @return Retorna a lista de todas as Avaliações deste registo
     */
    public List<FaeAvaliacao> getListaFaeAvaliacao() {
        return m_listaFaeAvaliacao;
    }

    /**
     * Devolve a lista de todos os fae
     *
     * @return lista de todos os fae
     */
    public List<FAE> getListaTodosFAE() {
        ArrayList<FAE> listaTodosFae = new ArrayList<>();
        for (FaeAvaliacao faeDecisao : m_listaFaeAvaliacao) {
            listaTodosFae.add(faeDecisao.getFaeAssociado());
        }
        return listaTodosFae;
    }

    /**
     * Devolve a lista de utilizadores com papel de fae
     *
     * @return lista de utilizadores com papel de fae
     */
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
    public float getMediaDeTodosOsRatings() {
        int cont = this.m_listaFaeAvaliacao.size();
        float somaMediaRatingsDeCadaFAE = 0;
        for (FaeAvaliacao faeAvaliacao : m_listaFaeAvaliacao) {
            somaMediaRatingsDeCadaFAE += faeAvaliacao.getAvaliacao().getMediaRatings();
        }
        return somaMediaRatingsDeCadaFAE / cont;
    }

    /**
     * Recebe por parametro uma matriz à qual vai ser somada, numa linha os
     * ratings dados pelos FAE guardados em cada Avaliação para uma mesma
     * candidatura. Cada rating em cada posição da linha da matriz.
     *
     * @param matriz metriz no qual vão ser guardados os valores dos ratings
     */
    public void somarRatingsDaCandidaturaAoVetor(float[][] matriz, int pos) {
        for (FaeAvaliacao FaeAvaliacao : this.m_listaFaeAvaliacao) {
            matriz[pos][0] += FaeAvaliacao.getAvaliacao().getRatingConhecimentoSobreOTema();
            matriz[pos][1] += FaeAvaliacao.getAvaliacao().getRatingAdequacaoAExposicao();
            matriz[pos][2] += FaeAvaliacao.getAvaliacao().getRatingAdequacaoAsDemos();
            matriz[pos][3] += FaeAvaliacao.getAvaliacao().getRatingAdequacaoNumConvites();
            matriz[pos][4] += FaeAvaliacao.getAvaliacao().getRatingRecomendacaoGlobal();
        }
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     *
     * @param m_registoUtilizadores registo de utilizadores
     */
    public void fix(RegistoUtilizadores m_registoUtilizadores) {
        for (FaeAvaliacao f : m_listaFaeAvaliacao) {
            f.fix(m_registoUtilizadores);
        }
    }

    @Override
    public RegistoFaeAvaliacao importContentFromXMLNode(Node node) throws ParserConfigurationException {
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
