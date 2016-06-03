package classesModelERegistoDeESOFT;

import java.util.ArrayList;

/**
 * Representação de uma Candidatura
 *
 * @author Ana Leite e Ricardo Osório
 */
public class Candidatura {

    EstadoCandidatura estado;
    /**
     * Atributo numero de telemovel de Candidatura
     */
    private int m_intTelemovel;

    /**
     * Atributo numero de convites de Candidatura
     */
    private int m_intNumConvites;

    /**
     * Atributo area de Candidatura
     */
    private float m_floatArea;

    /**
     * Atributo produtos a expor de Candidatura
     */
    private ArrayList<Produto> ProdutosExpor;

    /**
     * Atributo fae associado de Candidatura
     */
    private FAE m_faeFAEAssociado;

    /**
     * Lista de demonstrações existentes
     */
    private ArrayList<Demonstracao> m_listaDemonstracoes;

    /**
     *
     */
    private RegistoProdutos rp;

    Expositor expositor;
    Decisao d;
    Candidatura cand;

    /**
     * Contrutor de Candidatura sem parametros
     */
    public Candidatura() {
        Expositor ex = new Expositor();
        setEstado(new EstadoCandidaturaCriada(cand));

    }

    /**
     * Construtor de Candidatura assumindo todos os parametros
     *
     * @param telemovel numero de telemovel de Candidatura
     * @param numConvites numero de convites de Candidatura
     * @param area area de Candidatura
     * @param produto produto a expor de Candidatura
     * @param fae fae associado de Candidatura
     */
    public Candidatura(int telemovel, int numConvites, float area, Produto produto, FAE fae) {
        ProdutosExpor = new ArrayList<>();
        this.m_floatArea = area;
        this.m_intNumConvites = numConvites;
        this.m_intTelemovel = telemovel;
        this.m_faeFAEAssociado = fae;
        this.rp = new RegistoProdutos();
        setEstado(new EstadoCandidaturaCriada(cand));

    }

    /**
     * Devolve o fae associado de Candidatura
     *
     * @return fae associado de Candidatura
     */
    public FAE getFaeResponsavel() {
        return m_faeFAEAssociado;
    }

    /**
     * Devolve o numero de telemovel de Candidatura
     *
     * @return numero de telemovel de Candidatura
     */
    public int getM_intTelemovel() {
        return m_intTelemovel;
    }

    /**
     * Devolve o numero de convites de Candidatura
     *
     * @return numero de convites de Candidatura
     */
    public int getM_intNumConvites() {
        return m_intNumConvites;
    }

    /**
     * Devolve a area de Candidatura
     *
     * @return area de Candidatura
     */
    public float getM_floatArea() {
        return m_floatArea;
    }

    /**
     *
     * @return
     */
    public RegistoProdutos getRp() {
        return rp;
    }

    /**
     * Fefine novo fae associado de Candidatura
     *
     * @param faeResponsavel novo fae associado de Candidatura
     */
    public void setFaeResponsavel(FAE faeResponsavel) {
        this.m_faeFAEAssociado = faeResponsavel;
    }

    /**
     * Define novo numero de telemovel de Candidatura
     *
     * @param m_intTelemovel novo numero de televovel de Candidatura
     */
    public void setM_intTelemovel(int m_intTelemovel) {
        this.m_intTelemovel = m_intTelemovel;
    }

    /**
     * Define novo numero de convites de Candidatura
     *
     * @param m_intNumConvites novo numero de convites de Candidatura
     */
    public void setM_intNumConvites(int m_intNumConvites) {
        this.m_intNumConvites = m_intNumConvites;
    }

    /**
     * Define nova area de Candidatura
     *
     * @param m_floatArea nova area de Candidatura
     */
    public void setM_intArea(float m_floatArea) {
        this.m_floatArea = m_floatArea;
    }

    /**
     * Define novo nome de empresa de candidatura
     *
     * @param nomeEmpresa novo nome de empresa
     */
    public void setM_strNomeEmpresa(String nomeEmpresa) {
        expositor.setM_strNomeEmpresa(nomeEmpresa);
    }

    /**
     * Define nova morada de candidatura
     *
     * @param morada nova morada
     */
    public void setM_strMorada(String morada) {
        expositor.setM_strNomeEmpresa(morada);
    }

    /**
     * Método que cria um novo produto à Candidatura
     *
     * @param nome novo produto associado à Candidatura
     *
     * @return produto criado
     */
    public Produto criarProduto(String nome) {
        Produto produto = new Produto(nome);
        ProdutosExpor.add(produto);
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
     * Método que devolve uma descrição textual do objecto Candidatura, isto é,
     * com os seus atributos
     *
     * @return
     */
    @Override
    public String toString() {
        String str = "Candidatura:\n";
        str += "\tNome Empresa:" + expositor.getM_strNomeEmpresa();
        str += "\tMorada:" + expositor.getM_strMorada();
        str += "\tNumero de Telemovel: " + this.m_intTelemovel + "\n";
        str += "\tÁrea " + this.m_floatArea + "\n";
        str += "\tProdutos " + this.ProdutosExpor + "\n";

        return str;
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
     * Método que valida os dados repetidos pu invalidos de Candidatura
     *
     * @return boolean com a confirmação da validação
     */
    public boolean validarDadosRepetidosOuInvalidos() {
        return true;
    }

    /**
     * Método que valida o produto de Candidatura
     */
    public void validaProduto() {

        if (validarDadosRepetidosOuInvalidos() == false) {
            //remove os dados introduzidos anteriormente por estarem repetidos ou invalidos
        }

    }

    /**
     * Método que valida produto de Candidatura recebendo-o como parametro
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
     * Método que adiciona uma demonstração de Candidatura
     *
     * @param d demonstração a ser adicionada
     */
    public void addDemonstracao(Demonstracao d) {
        this.m_listaDemonstracoes.add(d);
    }

    /**
     * Método que valida demonstração de Candidatura recebendo-a como parametro
     *
     * @param demonstracao demonstração a ser validads
     */
    public void validaDemonstracao(Demonstracao demonstracao) {

        if (validarDadosRepetidosOuInvalidos() == false) {
            //remove os dados introduzidos anteriormente por estarem repetidos ou invalidos
        }

    }

    /**
     * Método que adiciona um produto de Candidatura
     *
     * @param p produto a ser adicionado
     */
    public void addProduto(Produto p) {
        this.ProdutosExpor.add(p);
    }

    /**
     * Devolve um novo expositor criado
     *
     * @return novo expositor
     */
    public Expositor novoExpositor() {
        return new Expositor();
    }

    /**
     * Devolve um ArrayList com os produtos de Candidatura
     *
     * @return produtos de Candidatura
     */
    public ArrayList<Produto> getProdutosExpor() {
        return ProdutosExpor;
    }

    /**
     * Método que cria uma noca decisao
     *
     * @param fae que faz a decisao de Candidatura
     *
     * @return nova decisao
     */
    public Decisao criarDecisao(FAE fae) {
        valida(fae);
        return new Decisao(fae);
    }

    /**
     * Método que valida o fae de Candidatura
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
     * @return dados de Candidatura
     */
    public ArrayList getDadosCandidatura() {
        ArrayList<String> dados = new ArrayList<>();
        return dados;
    }

    /**
     * Define nova decisao e justificação de candidatura
     *
     * @param decisao nova decisao
     * @param justificacao nova justificação
     */
    public void setDecisao(String decisao, String justificacao) {
        d.setM_strDecisao(decisao);
        d.setM_strJustificacao(justificacao);
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
    
    public Expositor getExpositor(){
        return expositor;
    }

    public EstadoCandidatura getEstadoCandidatura() {
        return estado;
    }
    
    public void setEstado(EstadoCandidatura ne){
        this.estado = ne;
    }
}