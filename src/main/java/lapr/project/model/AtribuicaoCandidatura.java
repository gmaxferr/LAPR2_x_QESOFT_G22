package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de uma atribuição candidatura (a exposição)
 * 
 * @author G29
 */
public class AtribuicaoCandidatura implements Importable<AtribuicaoCandidatura>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "AtribuicaoCandidatura";

    /**
     * Candidatura a exposição
     */
    private CandidaturaAExposicao m_candidatura;
    
    /**
     * Registo FaeAvaliação
     */
    private RegistoFaeAvaliacao m_rFaeAvaliacao;

    /**
     * Construtor de objetos do tipo AtribuicaoCandidatura com o parâmetro
     * candidatura a exposição
     * 
     * @param candidaturaAExposicao candidatura a exposição
     */
    public AtribuicaoCandidatura(CandidaturaAExposicao candidaturaAExposicao) {
        this.m_candidatura = candidaturaAExposicao;
        this.m_rFaeAvaliacao = new RegistoFaeAvaliacao();
    }

    /**
     * Devolve a candidatura a exposição
     * 
     * @return candidatura a exposição
     */
    public CandidaturaAExposicao getCandidaturaAssociada() {
        return this.m_candidatura;
    }

    /**
     * Devolve o registo de FAEAvaliação
     *
     * @return registo de FAEAvaliação
     */
    public RegistoFaeAvaliacao getRegistoFaeAvaliacao() {
        return this.m_rFaeAvaliacao;
    }

    /**
     * Adiciona um fae ao registo de FaeAvaliação
     * 
     * @param fae fae a ser adicionado ao registo 
     */
    public void addFaeAvaliacao(FAE fae) {
        this.m_rFaeAvaliacao.addFaeAvaliacao(fae);
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     * 
     * @param m_rce registo de candidaturas a exposição
     * @param m_registoUtilizadores registo de utilizadores
     */
    public void fix(RegistoCandidaturasAExposicao m_rce, RegistoUtilizadores m_registoUtilizadores) {
        for (CandidaturaAExposicao cand : m_rce.getListaCandidaturas()) {
            if (cand.equals(m_candidatura)) {
                m_candidatura = cand;
                break;
            }
        }
        this.m_rFaeAvaliacao.fix(m_registoUtilizadores);
    }

    @Override
    public AtribuicaoCandidatura importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        Node n = document.getChildNodes().item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            Expositor expositor = new Expositor(null);
            expositor.importContentFromXMLNode(elem.getElementsByTagName(Expositor.ROOT_ELEMENT_NAME).item(0));

            this.m_candidatura = new CandidaturaAExposicao(expositor);
            NodeList nList = elem.getElementsByTagName(Produto.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);
                Produto prod = new Produto();
                prod.importContentFromXMLNode(n2);
                this.m_candidatura.getProdutosExpor().add(prod);
            }
            this.m_candidatura.setNomeEmpresa(elem.getElementsByTagName(CandidaturaAExposicao.NOME_EMPRESA_ELEMENT_NAME).item(0).getTextContent());

            this.m_rFaeAvaliacao = new RegistoFaeAvaliacao();
            this.m_rFaeAvaliacao.importContentFromXMLNode(elem.getElementsByTagName(RegistoFaeAvaliacao.ROOT_ELEMENT_NAME).item(0));
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elemBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elemBase);
            
            Element elemChild = document.createElement(CandidaturaAExposicao.NOME_EMPRESA_ELEMENT_NAME);
            elemChild.setTextContent(this.m_candidatura.getNomeEmpresa());
            elemBase.appendChild(elemChild);

            Expositor expositor = this.m_candidatura.getExpositor();
            if (expositor != null) {
                elemBase.appendChild(document.importNode(expositor.exportContentToXMLNode(), true));
            }
            for (Produto prod : this.m_candidatura.getProdutosExpor()) {
                elemBase.appendChild(document.importNode(prod.exportContentToXMLNode(), true));
            }
            elemBase.appendChild(document.importNode(this.m_rFaeAvaliacao.exportContentToXMLNode(), true));

            node = elemBase;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtribuicaoCandidatura.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }

    /**
     * TESTE USE ONLY
     *
     * @param m_rFaeAvaliacao the m_rFaeAvaliacao to set
     */
    public void setRegistoFaeAvaliacao(RegistoFaeAvaliacao m_rFaeAvaliacao) {
        this.m_rFaeAvaliacao = m_rFaeAvaliacao;
    }
}
