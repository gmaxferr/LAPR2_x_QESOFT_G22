package lapr.project.model;

import lapr.project.registos.*;
import java.util.ArrayList;
import lapr.project.estados.EstadoExposicao;
import lapr.project.estados.EstadoExposicaoInicial;

/**
 * Representação de uma Exposição
 *
 * @author Ana Leite Ricardo Osório
 */
public class Exposicao {

    EstadoExposicao estado;
    /**
     * Atributo titulo de Exposição
     */
    private String m_strTitulo;

    /**
     * Atributo descrição de Exposição
     */
    private String m_strDescricao;

    /**
     * Atributo data de inicio de Exposição
     */
    private String m_strDataInicio;

    /**
     * Atributo data de fim de Exposição
     */
    private String m_strDataFim;

    /**
     * Atributo local de Exposição
     */
    private Local local;

    /**
     *
     */
    private RegistoAtribuicoes ra;

    /**
     *
     */
    private RegistoFAE rfae;

    /**
     *
     */
    private RegistoCandidaturas rc;

    /**
     *
     */
    private RegistoCandidaturasRemovidas rcr;

    /**
     *
     */
    private RegistoOrganizadores ro;

    /**
     *
     */
    private RegistoDemonstracoes rd;

    private RegistoConflitos rconf;

    private ArrayList<Organizador> m_listaOrganizadores;
    private ArrayList<FAE> m_listaFAE;
    private ArrayList<CandidaturaAExposicao> m_listaCandidaturas;

    public static ArrayList<CandidaturaAExposicao> listaCand;
    public static ArrayList<FAE> listaFAE;

    Exposicao e;
    FAE f;
    CandidaturaAExposicao c;

    /**
     * Construtor de Exposição sem parametros
     */
    public Exposicao() {
        m_listaOrganizadores = new ArrayList<>();
        m_listaFAE = new ArrayList<>();
        m_listaCandidaturas = new ArrayList<>();
        this.rconf = new RegistoConflitos();
        this.ra = new RegistoAtribuicoes();
        this.rc = new RegistoCandidaturas();
        this.rcr = new RegistoCandidaturasRemovidas();
        this.rd = new RegistoDemonstracoes();
        this.rfae = new RegistoFAE();
        this.ro = new RegistoOrganizadores();
        this.estado = new EstadoExposicaoInicial(this);
    }

    /**
     * Construtor de Exposição com parametros
     *
     * @param titulo titulo da exposição
     * @param descricao descrição da exposição
     * @param dataInicio data de inicio da exposição
     * @param dataFim data de fim da exposição
     * @param local local da exposição
     */
    public Exposicao(String titulo, String descricao, String dataInicio, String dataFim, String local) {
        this.m_strTitulo = titulo;
        this.m_strDescricao = descricao;
        this.m_strDataInicio = dataInicio;
        this.m_strDataFim = dataFim;
        this.local = new Local(local);
        this.ra = new RegistoAtribuicoes();
        this.rfae = new RegistoFAE();
        this.rc = new RegistoCandidaturas();
        this.ro = new RegistoOrganizadores();
        this.rd = new RegistoDemonstracoes();
        this.rcr = new RegistoCandidaturasRemovidas();
    }

    public Exposicao(ArrayList<Organizador> m_listaOrganizadores, ArrayList<FAE> m_listaFAE, ArrayList<CandidaturaAExposicao> m_listaCandidaturas) {
        this.m_listaOrganizadores = m_listaOrganizadores;
        this.m_listaFAE = m_listaFAE;
        this.m_listaCandidaturas = m_listaCandidaturas;
    }

    /**
     * Método que valida a exposição
     *
     * @return boolean de confirmação de validação
     */
    public boolean valida() {
        return true;
    }

    /**
     * Devolve o titulo da exposição
     *
     * @return titulo da exposição
     */
    public String getM_strTitulo() {
        return m_strTitulo;
    }

    /**
     * Devolve a descrição da exposição
     *
     * @return descricao da exposição
     */
    public String getM_strDescricao() {
        return m_strDescricao;
    }

    /**
     * Devolve a data de inicio da exposição
     *
     * @return data de inicio da exposição
     */
    public String getM_strDataInicio() {
        return m_strDataInicio;
    }

    /**
     * Devolve a data de fim da exposição
     *
     * @return data de fim da exposição
     */
    public String getM_strDataFim() {
        return m_strDataFim;
    }

    /**
     * Devolve o local da exposição
     *
     * @return local da exposição
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Devolve o registo de candidaturas removidas da exposição
     *
     * @return
     */
    public RegistoCandidaturasRemovidas getRegistoCandidaturasRemovidas() {
        return rcr;
    }

    /**
     * Define novo organizador de exposição
     *
     * @param organizador novo organizador de exposição
     */
    public void setOrganizador(Organizador organizador) {
        m_listaOrganizadores.add(organizador);
    }

    /**
     * Define novo titulo de exposição
     *
     * @param strTitulo novo tirulo de exposição
     */
    public void setTitulo(String strTitulo) {
        this.m_strTitulo = strTitulo;
    }

    /**
     * Define nova descrição de exposição
     *
     * @param strDescricao nova descrição de exposição
     */
    public void setDescricao(String strDescricao) {
        this.m_strDescricao = strDescricao;
    }

    /**
     * Define novo periodo de exposição
     *
     * @param strDataInicio nova data de inicio de exposição
     * @param strDataFim novo data de fim de exposição
     */
    public void setPeriodo(String strDataInicio, String strDataFim) {
        this.m_strDataInicio = strDataInicio;
        this.m_strDataFim = strDataFim;
    }

    /**
     * Define novo local de exposição
     *
     * @param local novo local de exposição
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    public Organizador getOrganizadores() {
        return null;
    }

    /**
     * Método que valida o utilizador
     *
     * @param u utilizador a ser validado
     *
     * @return boolean que confirma validação
     */
    public boolean validarUtilizador(Utilizador u) {
        //valida o utilizador
        return true;
    }

    /**
     * Método que valida dados da candidatura
     *
     * @param c candidatura
     *
     * @return boolean que confirma a validação dos dados
     */
    public boolean validarDadosCandidatura(CandidaturaAExposicao c) {
        //valida candidatura
        return true;
    }

    /**
     * Método que adiciona fae à exposição
     *
     * @param u utilizador/fae da exposição
     */
    public void addFAE(Utilizador u) {
        //cria o fae a partir do utilizador recebido (u)
        FAE fae = new FAE(u);
        this.m_listaFAE.add(fae);

    }

    /**
     * método que confirma adição de fae
     *
     * @param b
     */
    void confirmaAddFAE(boolean b) {
        if (b == true) {

        } else {
            //cancela as alterações e FAE adicionados
        }
    }

    /**
     * Devolve a lista de todas as candidaturas associadas à exposição
     *
     * @return arraylist com todas as candidatuas associadas à exposição
     */
    public ArrayList<CandidaturaAExposicao> getListaCandidaturas() {
        return this.m_listaCandidaturas;
    }

    /**
     * Lista dos fae da exposição
     *
     * @return lista dos fae
     */
    public ArrayList<FAE> getListaFAE() {
        return this.m_listaFAE;
    }

    /**
     * Método que valida decisao da candidatura
     *
     * @param c candidatura
     *
     * @return boolean de confirmação da validação
     */
    public boolean validarDecisao(CandidaturaAExposicao c) {
        return true;
    }

    /**
     * Método que devolve os dados da candidatura
     *
     * @param c candidatura
     * @return dados da candidatura
     */
    public ArrayList getDadosCandidatura(CandidaturaAExposicao c) {
        return c.getDadosCandidatura();
    }

    /**
     *
     * @return
     */
    public RegistoAtribuicoes getRa() {
        return ra;
    }

    /**
     *
     * @return
     */
    public RegistoFAE getRegistoFAE() {
        return rfae;
    }

    /**
     *
     * @return
     */
    public RegistoCandidaturas getRegistoCandidaturas() {
        return rc;
    }

    /**
     *
     * @return
     */
    public RegistoOrganizadores getRo() {
        return ro;
    }

    /**
     *
     * @return
     */
    public RegistoDemonstracoes getRd() {
        return rd;
    }

    /**
     * Método que remove candidaturas repetidas
     */
    public void removerCandidaturasRepetidas() {
        //remove as exposições repetidas dentro do arrayList
    }

    /**
     * Método que valida candidatura
     *
     * @param c candidatura
     *
     * @return boolean de confirmação da validação
     */
    public boolean validarCandidatura(CandidaturaAExposicao c) {
        return c.validarCandidatura();
    }

    public void setEstado(EstadoExposicao estado) {
        this.estado = estado;
    }

    /**
     * Métoto que define nova decisao
     *
     * @param candidaturaAExposicao
     */
    public void setDecisao(CandidaturaAExposicao candidaturaAExposicao, boolean decisao) {
        candidaturaAExposicao.setDecisao(decisao);
    }

    /**
     * Método que valida a decisao da candidatura
     *
     * @return boolean de confirmação de validação
     */
    public boolean validaDecidirCandidatura() {
        return true;
    }

    public RegistoDemonstracoes getRegistoDemonstracoes() {
        return this.rd;
    }

    public boolean dadosMinimosObrigatorios() {
        //verifica se a exposicao tem todos os dados minimos obrigatórios
        return true;
    }

    public EstadoExposicao getEstadoExposicao() {
        return estado;
    }

    public RegistoConflitos getRegistoCoflitos() {
        return this.rconf;
    }

    public RegistoAtribuicoes getRegistoAtribuicoes() {
        return this.ra;
    }

}
