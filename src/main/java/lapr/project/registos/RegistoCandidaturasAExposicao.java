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

    public static final String ROOT_ELEMENT_NAME = "RegistoCandidaturasAExposicao";

    /**
     * Lista de candidaturas
     */
    private List<CandidaturaAExposicao> m_listaCandidaturas;

    public RegistoCandidaturasAExposicao() {
        this.m_listaCandidaturas = new ArrayList<>();
    }

    /**
     * Devolve a lista de candidatuas à exposição
     *
     * @return lista de candidatuas à exposição
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return this.m_listaCandidaturas;
    }

    /**
     * Cria uma nova candidatura recebendo como parametro o utilizador que a
     * cria - Expositor.
     *
     * @param utilizador utilizador que cria a candidatura
     * @return nova candidatura
     */
    public CandidaturaAExposicao criarCandidatura(Utilizador utilizador) {
        return new CandidaturaAExposicao(new Expositor(utilizador));
    }

    /**
     * Valida dados da candidatura
     *
     * @param c candidatura
     *
     * @return true se a candidatura for válida. Caso contrário retorna false
     */
    public boolean validarDadosCandidatura(CandidaturaAExposicao c) {
        for (CandidaturaAExposicao candidatura : this.m_listaCandidaturas) {
            if (c.equals(candidatura)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Regista candidatura
     *
     * @param candidaturaAExposicao candidatura
     * @return true se a candidatura for registada. Caso contrário retorna false
     */
    public boolean registaCandidatura(CandidaturaAExposicao candidaturaAExposicao) {
        boolean b = validaCandidatua(candidaturaAExposicao);
        if (b) {
            this.m_listaCandidaturas.add(candidaturaAExposicao);
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
    public boolean validaCandidatua(CandidaturaAExposicao candidaturaNova) {
        for (CandidaturaAExposicao candidatura : m_listaCandidaturas) {
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
        m_listaCandidaturas.remove(c);
    }

    /**
     * Devolve a lista de candidaturas de um representante
     *
     * @param username username do representante
     * @return lista de candidaturas de um representante
     */
    public List<CandidaturaAExposicao> getCandidaturasRepresentante(String username) {
        List<CandidaturaAExposicao> candidaturasRepLst = new ArrayList<>();
        for (CandidaturaAExposicao c : m_listaCandidaturas) {
            if (c.getUsernameExpositor().equals(username)) {
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
        for (CandidaturaAExposicao cand : m_listaCandidaturas) {
            EstadoCandidaturaAExposicao state = cand.getEstado();
            if (state.isEstadoCandidaturaAceite()) {
                listCand.add(cand);
            }
        }
        return listCand;
    }

    /**
     * Devolve a percentagem de candidaturas à exposição aceites.
     *
     * @return percentagem de candidaturas à exposição acites. Se não houveram
     * candidaturas então devolve 0;
     */
    public float getPercentagemCandidaturasAceites() {
        int cont = this.m_listaCandidaturas.size();
        float candAceites = 0;
        for (CandidaturaAExposicao candidatura : m_listaCandidaturas) {
            if (candidatura.getEstado().isEstadoCandidaturaAceite()) {
                candAceites++;
            }
        }
        if (cont != 0) {
            return candAceites / cont;
        } else {
            return 0;
        }
    }

    public void fix(RegistoUtilizadores m_registoUtilizadores, RegistoDemonstracoes m_rd) {
        for (CandidaturaAExposicao c : m_listaCandidaturas) {
            c.fix(m_registoUtilizadores, m_rd);
        }
    }

    @Override
    public RegistoCandidaturasAExposicao importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_listaCandidaturas.clear();

                NodeList nList = elem.getElementsByTagName(CandidaturaAExposicao.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    CandidaturaAExposicao cand = new CandidaturaAExposicao(null);
                    cand.importContentFromXMLNode(n2);
                    m_listaCandidaturas.add(cand);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoCandidaturasAExposicao.class.getName()).log(Level.SEVERE, null, ex);
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

            for (CandidaturaAExposicao cand : m_listaCandidaturas) {
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
}
