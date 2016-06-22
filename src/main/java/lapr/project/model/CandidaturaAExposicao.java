package lapr.project.model;

import lapr.project.estados.CandidaturaAExposicao.*;
import java.util.*;
import java.util.Objects;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.exceptions.*;
import lapr.project.registos.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de uma CandidaturaAExposicao
 *
 * @author Ana Leite e Ricardo Osório
 */
public class CandidaturaAExposicao implements Importable<CandidaturaAExposicao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "candidatura";

    public static final String ESTADO_ATTR_NAME = "estado";

    public static final String DESCRICAO_ELEMENT_NAME = "descricao";
    public static final String AREA_ELEMENT_NAME = "areaPretendida";
    public static final String NUM_CONVITES_ELEMENT_NAME = "quantidadeConvites";
    public static final String AVALIACOES_ELEMENT_NAME = "avaliacoes";
    public static final String TLM_ELEMENT_NAME = "telemovel";
    public static final String NOME_EMPRESA_ELEMENT_NAME = "nomeEmpresa";
    public static final String MORADA_EMPRESA_ELEMENT_NAME = "moradaEmpresa";
    public static final String KEYWORDS_ELEMENT_NAME = "keywords";

    /**
     * Estado atual da Candidatura a Exposição.
     */
    private EstadoCandidaturaAExposicao m_estado;

    private Exposicao e;

    /**
     * Atributo numero de telemovel de CandidaturaAExposicao.
     */
    private int m_intTelemovel;

    /**
     * Atributo numero de convites de CandidaturaAExposicao.
     */
    private int m_intNumConvites;

    /**
     * Atributo area de CandidaturaAExposicao.
     */
    private int m_intArea;

    /**
     * Nome da empresa que se candidata.
     */
    private String m_StrNomeEmpresa;

    /**
     * Morada da empresa que se candidata.
     */
    private String m_StrMoradaEmpresa;

    /**
     * Descrição da candidatura.
     */
    private String m_descricao;

    /**
     * Registo(lista) dos produtos que o expositor pretende expor.
     */
    private RegistoProdutos m_rp;

    /**
     * Registo (lista) das demonstrações em que o expositor demonstra interesse
     * durante a candidatura.
     */
    private RegistoDemonstracoes m_rd;

    /**
     * Decisão tomada sobre esta candidatura durante o UC Decidir Candidatura a
     * Exposição.
     */
    private Decisao m_decisao;

    /**
     * Expositor gerador desta candidatura.
     */
    private Expositor m_expositor;

    /**
     * Keywords descritivas dos produtos a expor pelo expositor - introduzidas
     * no momento da candidatura.
     */
    private List<Keyword> m_keywords;

    /**
     * Contrutor de Candidatura sem parametros.
     *
     * @param expositor
     */
    public CandidaturaAExposicao(Exposicao e, Expositor expositor) {
        this.m_expositor = expositor;
        this.m_rp = new RegistoProdutos();
        this.m_rd = new RegistoDemonstracoes();
        this.m_keywords = new ArrayList<>();
        setEstado(new EstadoCandidaturaAExposicaoCriada(this));
        this.e = e;
        this.m_decisao = new Decisao(false);
    }

    public CandidaturaAExposicao(Expositor expositor) {
        this.m_expositor = expositor;
        this.m_rp = new RegistoProdutos();
        this.m_rd = new RegistoDemonstracoes();
        this.m_keywords = new ArrayList<>();
        setEstado(new EstadoCandidaturaAExposicaoCriada(this));
        this.e = null;
        this.m_decisao = new Decisao(false);
    }

    /**
     * Devolve o número de telemovel da empresa
     *
     * @return numero de telemovel da empresa
     */
    public int getTelemovel() {
        return m_intTelemovel;
    }

    /**
     * Devolve o número de convites que o expositor pretende
     *
     * @return número de convites que o expositor pretende
     */
    public int getNumConvites() {
        return m_intNumConvites;
    }

    /**
     * Devolve a área pretendida pelo expositor
     *
     * @return área pretendida pelo expositor
     */
    public int getArea() {
        return m_intArea;
    }

    /**
     * Devolve o nome da empresa
     *
     * @return nome da empresa
     */
    public String getNomeEmpresa() {
        return this.m_StrNomeEmpresa;
    }

    /**
     * Devolve a morada da empresa
     *
     * @return morada da empresa
     */
    public String getMoradaEmpresa() {
        return this.m_StrMoradaEmpresa;
    }

    /**
     * Devolve o username do expositor
     *
     * @return username do expositor
     */
    public String getUsernameExpositor() {
        return m_expositor.getUsername();
    }

    public String getEmailExpositor() {
        return m_expositor.getEmail();
    }

    /**
     * Devolve o Registo (lista) dos produtos introduzidos pelo expositor no
     * momento de criação da candidatura
     *
     * @return Registo dos produtos introduzidos pelo expositor
     */
    public RegistoProdutos getRegistoProdutos() {
        return this.m_rp;
    }

    /**
     * Devolve o Registo (lista) de demonstrações a que o expositor demonstrou
     * interesse em participar durante a candidatura
     *
     * @return Registo (lista) de monstrações em que o expositor demonstrou
     * interesse em participar
     */
    public RegistoDemonstracoes getRegistoDemonstracoes() {
        return this.m_rd;
    }

    /**
     * Define um novo número de telemóvel da empresa
     *
     * @param m_intTelemovel novo número de telemóvel da empresa
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
     * Define um novo número de convites que o expositor pretende ter
     *
     * @param m_StrNumConvites novo número de convites
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
     * Define um novo valor para a área que o expositor precisa
     *
     * @param m_StrArea novo valor para a área necessária
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
     * Define um novo nome da empresa
     *
     * @param nomeEmpresa novo nome da empresa
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.m_StrNomeEmpresa = nomeEmpresa;
    }

    /**
     * Define uma nova morada da empresa
     *
     * @param morada nova morada
     */
    public void setMorada(String morada) {
        this.m_StrMoradaEmpresa = morada;
    }

    /**
     * @return a descricao
     */
    public String getDescricao() {
        return m_descricao;
    }

    /**
     * @param m_descricao a descricao a definir
     */
    public void setDescricao(String m_descricao) {
        this.m_descricao = m_descricao;
    }

    /**
     * Cria um novo produto recebendo como parametro o seu nome e adiciona-o ao
     * registo de produtos desta candidatura
     *
     * @param nome nome do novo produto a ser adicionado
     *
     * @return produto criado
     */
    public Produto criarProduto(String nome) {
        Produto produto = new Produto(nome);
        this.m_rp.addProduto(produto);
        return produto;
    }

    /**
     * Remove um produto já adicionado ao registo de produtos desta candidatura
     * recebendo como parametro o index da sua posição dentro do RegistoProdutos
     *
     * @param index posição do produto dentro do RegistoProdutos
     */
    public void removeProduto(int index) {
        if (index < m_rp.getListaProdutosAExpor().size()) {
            this.m_rp.getListaProdutosAExpor().remove(index);
        } else {
            throw new IllegalArgumentException("Produto Inválido!");
        }
    }

    /**
     * Edita um produto da candidatura - Altera um produto existente numa dada
     * posição dentro do RegistoProdutos por um novo produto (nome deste novo
     * produto recebido por parametro)
     *
     * @param index posição do produto a ser editado dentro do RegistoProdutos
     * @param novoProduto nome do nome produto a ser adicionado na posição
     * desejada
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
     * Adiciona um produto ao RegistoProdutos recendo-o por parametro
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

    boolean getDecisao() {
        return m_decisao.getDecisao();
    }

    public void setExpositor(Expositor expositor) {
        this.m_expositor = expositor;
    }

    @Override
    public String toString() {
        return m_StrNomeEmpresa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof CandidaturaAExposicao) {
            CandidaturaAExposicao cand = (CandidaturaAExposicao) obj;
            if (this.getRegistoProdutos().equals(cand.getRegistoProdutos())
                    && this.getExpositor().getUtilizador().equals(cand.getExpositor().getUtilizador())) {
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
        String[] vecKeywords = keywords.split(";");
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

    /**
     * @return the e
     */
    public Exposicao getExposicao() {
        return e;
    }

    /**
     * @param e the e to set
     */
    public void setExposicao(Exposicao e) {
        this.e = e;
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

    public void fix(RegistoUtilizadores m_registoUtilizadores, RegistoDemonstracoes m_rd) {
        for (Utilizador u : m_registoUtilizadores.getListaUtilizadores()) {
            if (this.m_expositor != null && this.m_expositor.getUtilizador().getUsername().equals(u.getUsername())) {
                this.m_expositor.setUtilizador(u);
                break;
            }
        }
        for (Demonstracao demo : this.m_rd.getListaDemonstracoes()) {
            for (Demonstracao demo2 : m_rd.getListaDemonstracoes()) {
                if (demo.equals(demo2)) {
                    demo = demo2;
                    break;
                }
            }
        }
    }

    @Override
    public CandidaturaAExposicao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        NodeList elementsKeyword = document.getChildNodes();

        Node n = elementsKeyword.item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_decisao = new Decisao();
            this.m_decisao.importContentFromXMLNode(elem.getElementsByTagName(Decisao.ROOT_ELEMENT_NAME).item(0));
            this.m_descricao = elem.getElementsByTagName(DESCRICAO_ELEMENT_NAME).item(0).getTextContent();
            this.m_intArea = Integer.parseInt(elem.getElementsByTagName(AREA_ELEMENT_NAME).item(0).getTextContent());
            this.m_intNumConvites = Integer.parseInt(elem.getElementsByTagName(NUM_CONVITES_ELEMENT_NAME).item(0).getTextContent());
            Node n2 = elem.getElementsByTagName(AVALIACOES_ELEMENT_NAME).item(0);
            if (n2 != null) {
                NodeList avaliacoesList = ((Element) n2).getElementsByTagName(Avaliacao.ROOT_ELEMENT_NAME);
                for (int i = 0; i < avaliacoesList.getLength(); i++) {

                    Avaliacao aval = new Avaliacao();
                    Node n3 = avaliacoesList.item(0);
                    aval.importContentFromXMLNode(n3);

                    FAE fae = new FAE();
                    Node n4 = ((Element) n3).getElementsByTagName("atribuicao").item(0);
                    fae.importContentFromXMLNode(((Element) n4).getElementsByTagName(FAE.ROOT_ELEMENT_NAME).item(0));

                    RegistoAtribuicoesCandidaturasExposicao ra = e.getRegistoAtribuicoes();
                    List<AtribuicaoCandidatura> listAtr = ra.getListaAtribuicoes();
                    AtribuicaoCandidatura atr = null;
                    for (AtribuicaoCandidatura atrCand : listAtr) {
                        if (atrCand.getCandidaturaAssociada().equals(this) && atrCand.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(fae.getUsernameFae()) != null) {
                            atr = atrCand;
                        }
                    }

                    if (atr == null) {
                        atr = new AtribuicaoCandidatura(this);
                        listAtr.add(atr);
                    }

                    FaeAvaliacao fAval = atr.getRegistoFaeAvaliacao().getObjFaeDecisaoDoFae(fae.getUsernameFae());
                    if (fAval == null) {
                        fAval = new FaeAvaliacao(fae);
                        atr.getRegistoFaeAvaliacao().getListaFaeAvaliacao().add(fAval);
                    }

                    fAval.setAvaliacao(aval);
                }
            }

            NodeList tempList = elem.getElementsByTagName(MORADA_EMPRESA_ELEMENT_NAME);
            if (tempList.getLength() > 0) {
                this.m_StrMoradaEmpresa = tempList.item(0).getTextContent();
            }
            tempList = elem.getElementsByTagName(NOME_EMPRESA_ELEMENT_NAME);
            if (tempList.getLength() > 0) {
                this.m_StrNomeEmpresa = tempList.item(0).getTextContent();
            }
            tempList = elem.getElementsByTagName(Expositor.ROOT_ELEMENT_NAME);
            if (tempList.getLength() > 0) {
                this.m_expositor = new Expositor(null);
                this.m_expositor.importContentFromXMLNode(tempList.item(0));
            }
            tempList = elem.getElementsByTagName(TLM_ELEMENT_NAME);
            if (tempList.getLength() > 0) {
                this.m_intTelemovel = Integer.parseInt(tempList.item(0).getTextContent());
            }
            tempList = elem.getElementsByTagName(KEYWORDS_ELEMENT_NAME);
            if (tempList.getLength() > 0) {
                Node m = tempList.item(0);
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
            }
            tempList = elem.getElementsByTagName(RegistoDemonstracoes.ROOT_ELEMENT_NAME);
            if (tempList.getLength() > 0) {
                this.m_rd = new RegistoDemonstracoes();
                this.m_rd.importContentFromXMLNode(tempList.item(0));
            }
            tempList = elem.getElementsByTagName(RegistoProdutos.ROOT_ELEMENT_NAME);
            if (tempList.getLength() > 0) {
                this.m_rp = new RegistoProdutos();
                this.m_rp.importContentFromXMLNode(tempList.item(0));
            }

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

        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementCandAExpo = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementCandAExpo);

            elementCandAExpo.appendChild(document.importNode(this.m_decisao.exportContentToXMLNode(), true));
            elementCandAExpo.appendChild(document.importNode(this.m_expositor.exportContentToXMLNode(), true));
            elementCandAExpo.appendChild(document.importNode(this.m_rd.exportContentToXMLNode(), true));
            elementCandAExpo.appendChild(document.importNode(this.m_rp.exportContentToXMLNode(), true));

            Element child = document.createElement(DESCRICAO_ELEMENT_NAME);
            child.setTextContent(this.m_descricao);
            elementCandAExpo.appendChild(child);

            child = document.createElement(AREA_ELEMENT_NAME);
            child.setTextContent(String.valueOf(this.m_intArea));
            elementCandAExpo.appendChild(child);

            child = document.createElement(NUM_CONVITES_ELEMENT_NAME);
            child.setTextContent(String.valueOf(this.m_intNumConvites));
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

            child = document.createElement(TLM_ELEMENT_NAME);
            child.setTextContent(String.valueOf(this.m_intTelemovel));
            elementCandAExpo.appendChild(child);

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
