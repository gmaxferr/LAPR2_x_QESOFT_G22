package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.*;
import lapr.project.exceptions.*;
import lapr.project.registos.*;

/**
 * Representação de uma CandidaturaAExposicao
 *
 * @author Ana Leite e Ricardo Osório
 */
public class CandidaturaAExposicao {

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
        return m_expositor.getM_strUsername();
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
        this.m_decisao.setM_bDecisao(decisao);
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
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }
        CandidaturaAExposicao cand = (CandidaturaAExposicao) obj;
        if (this.getRegistoProdutos().equals(cand.getRegistoProdutos()) && this.getExpositor().getM_strUsername().equalsIgnoreCase(cand.getExpositor().getM_strUsername())) {
            return true;
        } else {
            return false;
        }
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
     * Devolve as keywords introduzidas pelo expositor no momento da
     * candidatura. Estas descrevem os produtos introduzidos.
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

}
