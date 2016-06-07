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

    EstadoCandidaturaAExposicao estado;
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
    private RegistoProdutos rp;

    /**
     *
     */
    private RegistoDemonstracoes rd;

    /**
     *
     */
    private Decisao decisao;

    /**
     *
     */
    private Expositor expositor;
    private String[] keywords;

    /**
     * Contrutor de Candidatura sem parametros
     *
     * @param expositor
     */
    public CandidaturaAExposicao(Expositor expositor) {
        this.expositor = expositor;
        this.rp = new RegistoProdutos();
        this.rd = new RegistoDemonstracoes();
        setEstado(new EstadoCandidaturaAExposicaoCriada(this));
    }

    /**
     * Devolve o numero de telemovel de CandidaturaAExposicao
     *
     * @return numero de telemovel de CandidaturaAExposicao
     */
    public int getM_intTelemovel() {
        return m_intTelemovel;
    }

    /**
     * Devolve o numero de convites de CandidaturaAExposicao
     *
     * @return numero de convites de CandidaturaAExposicao
     */
    public int getM_intNumConvites() {
        return m_intNumConvites;
    }

    /**
     * Devolve a area de CandidaturaAExposicao
     *
     * @return area de CandidaturaAExposicao
     */
    public int getM_intArea() {
        return m_intArea;
    }

    /**
     * Devolve o nome da empresa
     *
     * @return nom da empresa
     */
    public String getM_StrNomeEmpresa() {
        return this.m_StrNomeEmpresa;
    }

    public String getM_StrMoradaEmpresa() {
        return this.m_StrMoradaEmpresa;
    }

    /**
     * Devolve o username do expositor
     *
     * @return username do expositor
     */
    public String getM_StrUsernameExpositor() {
        return expositor.getM_strUsername();
    }

    /**
     *
     * @return
     */
    public RegistoProdutos getRegistoProdutos() {
        return this.rp;
    }

    public RegistoDemonstracoes getRegistoDemonstracoes() {
        return this.rd;
    }

    /**
     * Define novo numero de telemovel de CandidaturaAExposicao
     *
     * @param m_intTelemovel novo numero de televovel de CandidaturaAExposicao
     */
    public void setM_intTelemovel(String m_intTelemovel) {
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
    public void setM_intNumConvites(String m_StrNumConvites) throws TelemovelEmpresaErradoException {
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
    public void setM_intArea(String m_StrArea) {
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
    public void setM_strNomeEmpresa(String nomeEmpresa) {
        this.m_StrNomeEmpresa = nomeEmpresa;
    }

    /**
     * Define nova morada de candidatura
     *
     * @param morada nova morada
     */
    public void setM_strMorada(String morada) {
        this.m_StrNomeEmpresa = morada;
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
        this.rp.addProduto(produto);
        return produto;
    }

    /**
     * Método que valida e adiciona um novo produto
     *
     * @param produto produto a ser validado e adicionado
     */
    public void adicionaProduto(Produto produto) {
        validaProduto(produto);
        addProduto(produto);
    }

    /**
     * Remove produto da candidatura
     *
     * @param index
     */
    public void removeProduto(int index) {
        if (index < rp.getListaProdutosAExpor().size()) {
            this.rp.getListaProdutosAExpor().remove(index);
        } else {
            throw new IllegalArgumentException("Produto Inválido!");
        }
    }
    
    /**
     * Edita um produto da candidatura
     *
     * @param p - novo produto
     */
    public void editProduto(int index, String novoProduto) {
        if (index < rp.getListaProdutosAExpor().size()) {
            Produto temp = this.rp.getListaProdutosAExpor().get(index);
            temp.setNome(novoProduto);
        } else {
            throw new IllegalArgumentException("Produto Inválido!");
        }
    }
    
    /**
     * Método que valida a candidatura
     *
     * @return boolean conforme a validação
     */
    public boolean validarCandidatura() {
        //validação local dos dados
        if (validarDadosRepetidosOuInvalidos() == false) {
            //remove os dados introduzidos anteriormente por estarem repetidos ou invalidos
            return false;
        } else {
            return true;
        }
    }

    /**
     * Método que valida os dados repetidos pu invalidos de
     * CandidaturaAExposicao
     *
     * @return boolean com a confirmação da validação
     */
    public boolean validarDadosRepetidosOuInvalidos() {
        return true;
    }

    /**
     * Método que valida o produto de CandidaturaAExposicao
     */
    public void validaProduto() {

        if (validarDadosRepetidosOuInvalidos() == false) {
            //remove os dados introduzidos anteriormente por estarem repetidos ou invalidos
        }

    }

    /**
     * Método que valida produto de CandidaturaAExposicao recebendo-o como
     * parametro
     *
     * @param produto produto a ser validado
     */
    public void validaProduto(Produto produto) {

        if (validarDadosRepetidosOuInvalidos() == false) {
            //remove os dados introduzidos anteriormente por estarem repetidos ou invalidos
        }

    }

    /**
     * Método que valida e adiciona uma nova demonstração
     *
     * @param demonstracao demonstracao a ser validada e adicionada
     */
    public void adicionaDemonstracao(Demonstracao demonstracao) {
        validaDemonstracao(demonstracao);
        addDemonstracao(demonstracao);
    }

    /**
     * Método que adiciona uma demonstração de CandidaturaAExposicao
     *
     * @param demonstracao
     */
    public void addDemonstracao(Demonstracao demonstracao) {
        this.rd.adicionaDemonstracao(demonstracao);
    }

    /**
     * Método que valida demonstração de CandidaturaAExposicao recebendo-a como
     * parametro
     *
     * @param demonstracao demonstração a ser validads
     */
    public void validaDemonstracao(Demonstracao demonstracao) {

        if (validarDadosRepetidosOuInvalidos() == false) {
            //remove os dados introduzidos anteriormente por estarem repetidos ou invalidos
        }

    }

    /**
     * Método que adiciona um produto de CandidaturaAExposicao
     *
     * @param p produto a ser adicionado
     */
    public void addProduto(Produto p) {
        this.rp.addProduto(p);
    }

    /**
     * Devolve um ArrayList com os produtos de CandidaturaAExposicao
     *
     * @return produtos de CandidaturaAExposicao
     */
    public List<Produto> getProdutosExpor() {
        return this.rp.getListaProdutosAExpor();
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
        this.decisao.setM_bDecisao(decisao);
    }

    /**
     * Método que valida os dados de candidatura
     *
     * @return boolean que confirma validação
     */
    public boolean validarDadosCandidatura() {
        //valida candidatura
        return true;
    }

    public void valida() {
        //valida
    }

    public Expositor getExpositor() {
        return expositor;
    }

    public EstadoCandidaturaAExposicao getEstado() {
        return estado;
    }

    public void setEstado(EstadoCandidaturaAExposicao ne) {
        this.estado = ne;
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

    public void setM_Keywords(String keywords) throws KeywordsErradasException {
        String[] vecKeywords = keywords.split(",");
        if (vecKeywords.length > 5) {
            throw new KeywordsErradasException("O número de keywords introduzidas não é válido!");
        } else {
            this.keywords = vecKeywords;
        }
    }

}
