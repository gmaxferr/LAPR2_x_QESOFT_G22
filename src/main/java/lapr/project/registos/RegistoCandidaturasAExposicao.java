package lapr.project.registos;

import java.util.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoCandidaturasAExposicao
 *
 * @author G29
 */
public class RegistoCandidaturasAExposicao implements Importable<RegistoCandidaturasAExposicao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoCandidaturas";

    public final Exposicao e;

    /**
     * Lista de candidaturas a exposição
     */
    private final List<CandidaturaAExposicao> m_listaCandidaturas;

    /**
     * Construtor de objetos do tipo RegistoCandidaturaAExposicao sem parâmetros
     */
    public RegistoCandidaturasAExposicao(Exposicao e) {
        this.m_listaCandidaturas = new ArrayList<>();
        this.e = e;
    }

    /**
     * Devolve a lista de candidatuas à exposição
     *
     * @return lista de candidatuas à exposição
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        correctList();
        return m_listaCandidaturas;
    }

    /**
     * Cria uma nova candidatura recebendo como parametro o utilizador que a
     * cria - Expositor.
     *
     * @param utilizador utilizador que cria a candidatura
     * @return nova candidatura
     */
    public CandidaturaAExposicao criarCandidatura(Utilizador utilizador) {
        return new CandidaturaAExposicao(this.e, new Expositor(utilizador));
    }

    /**
     * Regista candidatura
     *
     * @param candidaturaAExposicao candidatura
     * @return true se a candidatura for registada. Caso contrário retorna false
     */
    public boolean registaCandidatura(CandidaturaAExposicao candidaturaAExposicao) {
        boolean b = validaCandidatura(candidaturaAExposicao);
        if (b) {
            this.getListaCandidaturas().add(candidaturaAExposicao);
        }
        return b;
    }

    /**
     * Valida uma candidatura passada por parametro. Verifica se existe outra
     * candidatura neste registo de candidaturas igual. Duas candidaturas são
     * consideradas iguais quando o expositor é o mesmo e em ambas foram decidos
     * expor os mesmos produtos.
     *
     * @param candidaturaNova candidatura a ser adicionada
     * @return true se a candidatura for válida para ser adicionada a este
     * registo de candidaturas, caso contrário false
     */
    private boolean validaCandidatura(CandidaturaAExposicao candidaturaNova) {
        for (CandidaturaAExposicao candidatura : getListaCandidaturas()) {
            if (candidatura.equals(candidaturaNova)) {
                return false;
            }
        }
        return true;

    }

    /**
     * Remove uma candidatura do registo
     *
     * @param c - candidatura a remover
     */
    public void removeCandidatura(CandidaturaAExposicao c) {
        getListaCandidaturas().remove(c);
    }

    /**
     * Devolve a lista de candidaturas de um representante
     *
     * @param email email do representante
     * @return lista de candidaturas de um representante
     */
    public List<CandidaturaAExposicao> getCandidaturasRepresentante(String email) {
        List<CandidaturaAExposicao> candidaturasRepLst = new ArrayList<>();
        for (CandidaturaAExposicao c : getListaCandidaturas()) {
            if (c.getEmailExpositor().equals(email)) {
                candidaturasRepLst.add(c);
            }
        }
        return candidaturasRepLst;
    }

    /**
     * Devolve a lista de candidaturas aceites a uma exposição
     *
     * @return lista de candidaturas aceites a uma exposição
     */
    public List<CandidaturaAExposicao> getListaCandidaturasAceites() {
        List<CandidaturaAExposicao> listCand = new ArrayList<>();
        for (CandidaturaAExposicao cand : getListaCandidaturas()) {
            EstadoCandidaturaAExposicao state = cand.getEstado();
            if (state.isEstadoCandidaturaAceite()) {
                listCand.add(cand);
            }
        }
        return listCand;
    }

    /**
     * Devolve a percentagem de candidaturas à exposição aceite do representente
     * cujo username é passado por parametro.
     *
     * @param emailExpositor username do Expositor
     * @return percentagem de candidaturas do representante à exposição aceites.
     * Se não houveram candidaturas então devolve 0
     */
    public float getPercentagemCandidaturasAceites(String emailExpositor) {
        List<CandidaturaAExposicao> listaCandidaturasDoExpositor = getCandidaturasRepresentante(emailExpositor);
        int cont = listaCandidaturasDoExpositor.size();
        float candAceites = 0;
        for (CandidaturaAExposicao candidatura : listaCandidaturasDoExpositor) {
            if (candidatura.getEstado().isEstadoCandidaturaAceite()) {
                candAceites++;
            }
        }
        if (cont != 0) {
            return (candAceites / cont) * 100;
        } else {
            return 0;
        }
    }

    /**
     * Verifica se existem candidaturas sem referência à exposição dentro da
     * lista de candidaturas e, se não tiver, define essa variável.
     */
    public void correctList() {
        for (CandidaturaAExposicao cand : this.m_listaCandidaturas) {
            cand.setExposicao(e);   //Caso não tenham exposição ou a variável tenha sido inicializada a null
        }
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     *
     * @param m_registoUtilizadores registo de utilizadores
     * @param m_rd registo de demonstrações
     */
    public void fix(RegistoUtilizadores m_registoUtilizadores, RegistoDemonstracoes m_rd) {
        for (CandidaturaAExposicao c : getListaCandidaturas()) {
            c.fix(m_registoUtilizadores, m_rd);
        }
    }

    @Override
    public RegistoCandidaturasAExposicao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document doc = XMLParser.createDocument(node, true);

        Node n = doc.getChildNodes().item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.getListaCandidaturas().clear();

            NodeList nList = elem.getElementsByTagName(CandidaturaAExposicao.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);
                CandidaturaAExposicao cand = new CandidaturaAExposicao(this.e, null);
                cand.importContentFromXMLNode(n2);
                getListaCandidaturas().add(cand);
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

            for (CandidaturaAExposicao cand : getListaCandidaturas()) {
                Node n = cand.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoCandidaturasAExposicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

    public List<CandidaturaAExposicao> getListaCandidaturasEstadoProntaAtribuicoes() {
        List<CandidaturaAExposicao> listCand = new ArrayList<>();
        for (CandidaturaAExposicao cand : getListaCandidaturas()) {
            EstadoCandidaturaAExposicao state = cand.getEstado();
            if (state.isEstadoCandidaturaProntaAtribuicoes()) {
                listCand.add(cand);
            }
        }
        return listCand;
    }
}
