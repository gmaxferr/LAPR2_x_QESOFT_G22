package lapr.project.model;

import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoCriada;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAceite;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAtribuida;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAvaliada;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoInicial;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoNaoAvaliada;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoProntaAtribuicoes;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoRejeitada;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoStandAceite;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoStandRecusado;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoStandsAtribuidos;
import lapr.project.exceptions.*;
import lapr.project.registos.*;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Representação de uma CandidaturaAExposicao
 *
 * @author Ana Leite e Ricardo Osório
 */
public class CandidaturaAExposicao implements Importable<CandidaturaAExposicao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "CandidaturaAExposicao";
    public static final String ESTADO_ATTR_NAME = "Estado";
    public static final String TLM_ELEMENT_NAME = "telemovel";
    public static final String NUM_CONVITES_ELEMENT_NAME = "numConvites";
    public static final String AREA_ELEMENT_NAME = "area";
    public static final String NOME_EMPRESA_ELEMENT_NAME = "nomeEmpresa";
    public static final String MORADA_EMPRESA_ELEMENT_NAME = "moradaEmpresa";
    public static final String KEYWORDS_ELEMENT_NAME = "keywords";

    private EstadoCandidaturaAExposicao m_estado;
    /**
     * Atributo numero de telemovel de CandidaturaAExposicao
     */
    private int m_intTelemovel;

    /**
     * Atributo numero de convites de CandidaturaAExposicao
     */
    private int m_intNumConvites;

    /**
     * Atributo area de CandidaturaAExposicao
     */
    private int m_intArea;

    /**
     *
     */
    private String m_StrNomeEmpresa;

    /**
     *
     */
    private String m_StrMoradaEmpresa;

    /**
     *
     */
    private RegistoProdutos m_rp;

    /**
     *
     */
    private RegistoDemonstracoes m_rd;

    /**
     *
     */
    private Decisao m_decisao;

    /**
     *
     */
    private Expositor m_expositor;

    /**
     *
     */
    private List<Keyword> m_keywords;

    /**
     * Contrutor de Candidatura sem parametros
     *
     * @param expositor
     */
    public CandidaturaAExposicao(Expositor expositor) {
        this.m_expositor = expositor;
        this.m_rp = new RegistoProdutos();
        this.m_rd = new RegistoDemonstracoes();
        this.m_keywords = new ArrayList<>();
        setEstado(new EstadoCandidaturaAExposicaoCriada(this));
    }

    /**
     * Devolve o numero de telemovel de CandidaturaAExposicao
     *
     * @return numero de telemovel de CandidaturaAExposicao
     */
    public int getTelemovel() {
        return m_intTelemovel;
    }

    /**
     * Devolve o numero de convites de CandidaturaAExposicao
     *
     * @return numero de convites de CandidaturaAExposicao
     */
    public int getNumConvites() {
        return m_intNumConvites;
    }

    /**
     * Devolve a area de CandidaturaAExposicao
     *
     * @return area de CandidaturaAExposicao
     */
    public int getArea() {
        return m_intArea;
    }

    /**
     * Devolve o nome da empresa
     *
     * @return nom da empresa
     */
    public String getNomeEmpresa() {
        return this.m_StrNomeEmpresa;
    }

    public String getMoradaEmpresa() {
        return this.m_StrMoradaEmpresa;
    }

    /**
     * Devolve o username do expositor
     *
     * @return username do expositor
     */
    public String getUsernameExpositor() {
        return m_expositor.getM_strEmail();
    }

    /**
     *
     * @return
     */
    public RegistoProdutos getRegistoProdutos() {
        return this.m_rp;
    }

    public RegistoDemonstracoes getRegistoDemonstracoes() {
        return this.m_rd;
    }

    /**
     * Define novo numero de telemovel de CandidaturaAExposicao
     *
     * @param m_intTelemovel novo numero de televovel de CandidaturaAExposicao
     */
    public void setTelemovel(String m_intTelemovel) {
        if (m_intTelemovel.length() != 9) {
            throw new TelemovelEmpresaErradoException("O número de telemóvel da empresa introduzido não é válido!");
        }
        try {
            int intNumeroTelemovel = Integer.parseInt(m_intTelemovel);
            this.m_intTelemovel = intNumeroTelemovel;
        } catch (IllegalArgumentException e) {
            throw new TelemovelEmpresaErradoException("O número de telemóvel da empresa introduzido não é válido!");
        }

    }

    /**
     * Define novo numero de convites de CandidaturaAExposicao
     *
     * @param m_StrNumConvites
     */
    public void setNumConvites(String m_StrNumConvites) throws TelemovelEmpresaErradoException {
        try {
            int intNumConvites = Integer.parseInt(m_StrNumConvites);
            if (intNumConvites < 0) {
                throw new NumeroConvitesErradoException("O número de convites introduzido não é valido!");
            }
            this.m_intNumConvites = intNumConvites;
        } catch (IllegalArgumentException e) {
            throw new NumeroConvitesErradoException("O número de convites introduzido não é valido!");
        }
    }

    /**
     * Define nova area de CandidaturaAExposicao
     *
     * @param m_StrArea
     */
    public void setArea(String m_StrArea) {
        try {
            int intArea = Integer.parseInt(m_StrArea);
            if (intArea < 0) {
                throw new AreaErradaException("A área introduzida não é valida!");
            }
            this.m_intArea = intArea;
        } catch (IllegalArgumentException e) {
            throw new AreaErradaException("A área introduzida não é valida!");
        }
    }

    /**
     * Define novo nome de empresa de candidatura
     *
     * @param nomeEmpresa novo nome de empresa
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.m_StrNomeEmpresa = nomeEmpresa;
    }

    /**
     * Define nova morada de candidatura
     *
     * @param morada nova morada
     */
    public void setMorada(String morada) {
        this.m_StrMoradaEmpresa = morada;
    }

    /**
     * Método que cria um novo produto à CandidaturaAExposicao
     *
     * @param nome novo produto associado à CandidaturaAExposicao
     *
     * @return produto criado
     */
    public Produto criarProduto(String nome) {
        Produto produto = new Produto(nome);
        this.m_rp.addProduto(produto);
        return produto;
    }

    /**
     * Remove produto da candidatura
     *
     * @param index
     */
    public void removeProduto(int index) {
        if (index < m_rp.getListaProdutosAExpor().size()) {
            this.m_rp.getListaProdutosAExpor().remove(index);
        } else {
            throw new IllegalArgumentException("Produto Inválido!");
        }
    }

    /**
     * Edita um produto da candidatura
     *
     * @param index
     * @param novoProduto
     */
    public void editProduto(int index, String novoProduto) {
        if (index < m_rp.getListaProdutosAExpor().size()) {
            Produto temp = this.m_rp.getListaProdutosAExpor().get(index);
            temp.setNome(novoProduto);
        } else {
            throw new IllegalArgumentException("Produto Inválido!");
        }
    }

    /**
     * Método que adiciona um produto de CandidaturaAExposicao
     *
     * @param p produto a ser adicionado
     */
    public void addProduto(Produto p) {
        this.m_rp.addProduto(p);
    }

    /**
     * Devolve um ArrayList com os produtos de CandidaturaAExposicao
     *
     * @return produtos de CandidaturaAExposicao
     */
    public List<Produto> getProdutosExpor() {
        return this.m_rp.getListaProdutosAExpor();
    }

    /**
     * Método que valida o fae de CandidaturaAExposicao
     *
     * @param fae a ser validado
     * @return
     */
    public boolean valida(FAE fae) {
        return true;
    }

    /**
     * Método que valida a decisao
     *
     * @return boolean que confirma validação
     */
    public boolean validaDecisao() {
        return true;
    }

    /**
     * Devolve os dados da candidatura (...)
     *
     * @return dados de CandidaturaAExposicao
     */
    public ArrayList getDadosCandidatura() {
        ArrayList<String> dados = new ArrayList<>();
        return dados;
    }

    /**
     * Define nova decisao e justificação de candidatura
     *
     * @param decisao nova decisao
     */
    public void setDecisao(boolean decisao) {
        this.m_decisao = new Decisao(decisao);
    }

    public Expositor getExpositor() {
        return m_expositor;
    }

    public EstadoCandidaturaAExposicao getEstado() {
        return m_estado;
    }

    public void setEstado(EstadoCandidaturaAExposicao ne) {
        this.m_estado = ne;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof CandidaturaAExposicao) {
            CandidaturaAExposicao cand = (CandidaturaAExposicao) obj;
            if (this.getRegistoProdutos().equals(cand.getRegistoProdutos()) && this.getExpositor().getM_strEmail().equalsIgnoreCase(cand.getExpositor().getM_strEmail())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.m_estado);
        hash = 29 * hash + this.m_intTelemovel;
        hash = 29 * hash + this.m_intNumConvites;
        hash = 29 * hash + this.m_intArea;
        hash = 29 * hash + Objects.hashCode(this.m_StrNomeEmpresa);
        hash = 29 * hash + Objects.hashCode(this.m_StrMoradaEmpresa);
        hash = 29 * hash + Objects.hashCode(this.m_rp);
        hash = 29 * hash + Objects.hashCode(this.m_rd);
        hash = 29 * hash + Objects.hashCode(this.m_decisao);
        hash = 29 * hash + Objects.hashCode(this.m_expositor);
        hash = 29 * hash + Objects.hashCode(this.m_keywords);
        return hash;
    }

    public void setKeywords(String keywords) throws KeywordsErradasException {
        String[] vecKeywords = keywords.split(",");
        if (vecKeywords.length > 5 || vecKeywords.length < 2) {
            throw new KeywordsErradasException("O número de keywords introduzidas não é válido!");
        } else {
            for (String s : vecKeywords) {
                m_keywords.add(new Keyword(s));
            }
        }
    }

    /**
     * Devolve as keywords introduzidas pelo expositor no momento da candidatura
     * na forma de um array de Strings.<!-- -->Estas descrevem os produtos
     * introduzidos.
     *
     * @return keywords que descrevem os produtos associados à candidatura
     */
    public String[] getKeywords() {
        String res[] = new String[m_keywords.size()];
        for (int i = 0; i < m_keywords.size(); i++) {
            res[i] = m_keywords.get(i).getValue();
        }
        return res;
    }

    /**
     * @return Devolva uma lista com as keywords introduzidas pelo expositor no
     * momento da candidatura. Estes descrevem os produtos introduzidos
     */
    public List<Keyword> getListKeyword() {
        return m_keywords;
    }

    public boolean validaCandidatura() {
        return !this.m_StrMoradaEmpresa.trim().equals("")
                && !this.m_StrNomeEmpresa.trim().equals("")
                && !(this.m_expositor == null)
                && !(this.m_intArea == 0)
                && !(this.m_intNumConvites == 0)
                && !(this.m_intTelemovel == 0)
                && !(this.m_keywords.size() < 2)
                && !(this.m_keywords.size() > 5);
    }

    @Override
    public CandidaturaAExposicao importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.appendChild(document.importNode(node, true));

            NodeList elementsKeyword = document.getChildNodes();

            Node n = elementsKeyword.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_StrMoradaEmpresa = elem.getElementsByTagName(MORADA_EMPRESA_ELEMENT_NAME).item(0).getTextContent();
                this.m_StrNomeEmpresa = elem.getElementsByTagName(NOME_EMPRESA_ELEMENT_NAME).item(0).getTextContent();
                this.m_decisao = new Decisao();
                this.m_decisao.importContentFromXMLNode(elem.getElementsByTagName(Decisao.ROOT_ELEMENT_NAME).item(0));
                this.m_expositor.importContentFromXMLNode(elem.getElementsByTagName(Expositor.ROOT_ELEMENT_NAME).item(0));
                this.m_intArea = Integer.parseInt(elem.getElementsByTagName(AREA_ELEMENT_NAME).item(0).getTextContent());
                this.m_intNumConvites = Integer.parseInt(elem.getElementsByTagName(NUM_CONVITES_ELEMENT_NAME).item(0).getTextContent());
                this.m_intTelemovel = Integer.parseInt(elem.getElementsByTagName(TLM_ELEMENT_NAME).item(0).getTextContent());
                Node m = elem.getElementsByTagName(KEYWORDS_ELEMENT_NAME).item(0);
                if (m.getNodeType() == Node.ELEMENT_NODE) {
                    Element m2 = (Element) m;
                    NodeList keywords = m2.getElementsByTagName(Keyword.ROOT_ELEMENT_NAME);
                    this.m_keywords.clear();
                    for (int i = 0; i < keywords.getLength(); i++) {
                        Keyword key = new Keyword();
                        key.importContentFromXMLNode(keywords.item(i));
                        this.m_keywords.add(key);
                    }
                }
                this.m_rd = new RegistoDemonstracoes();
                this.m_rd.importContentFromXMLNode(elem.getElementsByTagName(RegistoDemonstracoes.ROOT_ELEMENT_NAME).item(0));
                this.m_rp = new RegistoProdutos();
                this.m_rp.importContentFromXMLNode(elem.getElementsByTagName(RegistoProdutos.ROOT_ELEMENT_NAME).item(0));

                String estado = elem.getAttribute(ESTADO_ATTR_NAME);
                switch (estado) {
                    case "inicial":
                        this.m_estado = new EstadoCandidaturaAExposicaoInicial(this);
                        break;
                    case "criada":
                        this.m_estado = new EstadoCandidaturaAExposicaoCriada(this);
                        break;
                    case "prontaAtribuicoes":
                        this.m_estado = new EstadoCandidaturaAExposicaoProntaAtribuicoes(this);
                        break;
                    case "atribuida":
                        this.m_estado = new EstadoCandidaturaAExposicaoAtribuida(this);
                        break;
                    case "naoAvaliada":
                        this.m_estado = new EstadoCandidaturaAExposicaoNaoAvaliada(this);
                        break;
                    case "avaliada":
                        this.m_estado = new EstadoCandidaturaAExposicaoAvaliada(this);
                        break;
                    case "rejeitada":
                        this.m_estado = new EstadoCandidaturaAExposicaoRejeitada(this);
                        break;
                    case "aceite":
                        this.m_estado = new EstadoCandidaturaAExposicaoAceite(this);
                        break;
                    case "abertaAtualizacaoConflitos":
                        this.m_estado = new EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos(this);
                        break;
                    case "standsAtribuidos":
                        this.m_estado = new EstadoCandidaturaAExposicaoStandsAtribuidos(this);
                        break;
                    case "standRecusado":
                        this.m_estado = new EstadoCandidaturaAExposicaoStandRecusado(this);
                        break;
                    case "standAceite":
                        this.m_estado = new EstadoCandidaturaAExposicaoStandAceite(this);
                        break;
                    default:
                        break;
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CandidaturaAExposicao.class.getName()).log(Level.SEVERE, null, ex);
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

            Element elementCandAExpo = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementCandAExpo);

            Element child = document.createElement(AREA_ELEMENT_NAME);
            child.setTextContent(String.valueOf(this.m_intArea));
            elementCandAExpo.appendChild(child);

            child = document.createElement(KEYWORDS_ELEMENT_NAME);
            elementCandAExpo.appendChild(child);
            for (Keyword k : m_keywords) {
                Node n = k.exportContentToXMLNode();
                child.appendChild(document.importNode(n, true));
            }

            child = document.createElement(MORADA_EMPRESA_ELEMENT_NAME);
            child.setTextContent(this.m_StrMoradaEmpresa);
            elementCandAExpo.appendChild(child);

            child = document.createElement(NOME_EMPRESA_ELEMENT_NAME);
            child.setTextContent(this.m_StrNomeEmpresa);
            elementCandAExpo.appendChild(child);

            child = document.createElement(NUM_CONVITES_ELEMENT_NAME);
            child.setTextContent(String.valueOf(this.m_intNumConvites));
            elementCandAExpo.appendChild(child);

            child = document.createElement(TLM_ELEMENT_NAME);
            child.setTextContent(String.valueOf(this.m_intTelemovel));
            elementCandAExpo.appendChild(child);

            elementCandAExpo.appendChild(document.importNode(this.m_decisao.exportContentToXMLNode(), true));
            elementCandAExpo.appendChild(document.importNode(this.m_expositor.exportContentToXMLNode(), true));
            elementCandAExpo.appendChild(document.importNode(this.m_rd.exportContentToXMLNode(), true));
            elementCandAExpo.appendChild(document.importNode(this.m_rp.exportContentToXMLNode(), true));

            if (this.m_estado.isEstadoCandidaturaIncial()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "inicial");
            } else if (this.m_estado.isEstadoCandidaturaCriada()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "criada");
            } else if (this.m_estado.isEstadoCandidaturaProntaAtribuicoes()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "prontaAtribuicoes");
            } else if (this.m_estado.isEstadoCandidaturaAtribuida()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "atribuida");
            } else if (this.m_estado.isEstadoCandidaturaNaoAvaliada()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "naoAvaliada");
            } else if (this.m_estado.isEstadoCandidaturaAvaliada()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "avaliada");
            } else if (this.m_estado.isEstadoCandidaturaRejeitada()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "rejeitada");
            } else if (this.m_estado.isEstadoCandidaturaAceite()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "aceite");
            } else if (this.m_estado.isEstadoCandidaturaAbertaAtualizacaoConflitos()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "abertaAtualizacaoConflitos");
            } else if (this.m_estado.isEstadoCandidaturaStandsAtribuidos()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "standsAtribuidos");
            } else if (this.m_estado.isEstadoCandidaturaStandRecusado()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "standRecusado");
            } else if (this.m_estado.isEstadoCandidaturaStandAceite()) {
                elementCandAExpo.setAttribute(ESTADO_ATTR_NAME, "standAceite");
            }

            node = elementCandAExpo;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CandidaturaAExposicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
