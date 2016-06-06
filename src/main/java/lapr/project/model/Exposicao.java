package lapr.project.model;

import lapr.project.registos.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import lapr.project.controller.DetetarConflitoController;
import lapr.project.estados.Estado;
import lapr.project.estados.EstadoExposicao;
import lapr.project.estados.EstadoExposicaoInicial;
import lapr.project.utils.Data;

/**
 * Representação de uma Exposição
 *
 * @author Ana Leite Ricardo Osório
 */
public class Exposicao implements Agendavel{

    EstadoExposicao m_estado;
    /**
     * Atributo titulo de Exposição
     */
    private String m_strTitulo;

    /**
     * Atributo descrição de Exposição
     */
    private String m_strDescricao;

    /**
     * Data de inicio
     */
    private Data m_dataInicio;

    /**
     * Data de fim
     */
    private Data m_dataFim;

    /**
     * Data em que a Exposição ficou ou ficará aberta para receber candidaturas
     */
    private Data m_dataAberturaCandidatura;

    /**
     * Data em que a Exposição ficou ou ficará fechada para receber candidaturas
     */
    private Data m_dataEncerramentoCandidatura;

    /**
     * Data em que a acaba a deteção de conflitos
     */
    private Data m_dataFimDetecaoConflitos;

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
    private RegistoCandidaturasAExposicao rce;

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

    /**
     * Timer despoletado quando a data de abertura de submissão de candidaturas
     * for atingida
     */
    private Timer timerAberturaCandidatura;

    /**
     * Timer despoletado quando a data de encerramento de candidaturas chegar
     */
    private Timer timerEncerramentoCandidatura;

    /**
     * Timer despoletado quando chega a data final para deteção de conflitos
     */
    private Timer timerFimDetecaoConflitos;

    private RegistoConflitos rconf;

    private RegistoExpositores rexpositores;

    Exposicao e;
    FAE f;
    CandidaturaAExposicao c;
    private CentroExposicoes centroExposicoes;

    /**
     * Construtor de Exposição sem parametros
     */
    public Exposicao() {
        this.rce = new RegistoCandidaturasAExposicao();
        this.rfae = new RegistoFAE();
        this.rcr = new RegistoCandidaturasRemovidas();
        this.rconf = new RegistoConflitos();
        this.ra = new RegistoAtribuicoes();
        this.rce = new RegistoCandidaturasAExposicao();
        this.rcr = new RegistoCandidaturasRemovidas();
        this.rd = new RegistoDemonstracoes();
        this.rfae = new RegistoFAE();
        this.ro = new RegistoOrganizadores();
        this.m_estado = new EstadoExposicaoInicial(this);
    }

    /**
     * Construtor de Exposição com parametros
     *
     * @param titulo titulo da exposição
     * @param descricao descrição da exposição
     * @param dataInicio data de inicio da exposição
     * @param dataFim data de fim da exposição
     * @param local local da exposição
     * @param centroExposicoes
     */
    public Exposicao(String titulo, String descricao, Data dataInicio, Data dataFim, Local local, CentroExposicoes centroExposicoes) {
        this.m_strTitulo = titulo;
        this.m_strDescricao = descricao;
        this.m_dataInicio = dataInicio;
        this.m_dataFim = dataFim;
        this.local = local;
        this.centroExposicoes = centroExposicoes;
        this.ra = new RegistoAtribuicoes();
        this.rfae = new RegistoFAE();
        this.rce = new RegistoCandidaturasAExposicao();
        this.ro = new RegistoOrganizadores();
        this.rd = new RegistoDemonstracoes();
        this.rcr = new RegistoCandidaturasRemovidas();
    }

    public Exposicao(RegistoOrganizadores ro, RegistoFAE rfae, RegistoCandidaturasAExposicao rce) {
        this.ro = ro;
        this.rfae = rfae;
        this.rce = rce;
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
    public Data getM_strDataInicio() {
        return m_dataInicio;
    }

    /**
     * Devolve a data de fim da exposição
     *
     * @return data de fim da exposição
     */
    public Data getM_strDataFim() {
        return m_dataFim;
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
     * @param utilizador
     */
    public void addOrganizador(Utilizador utilizador) {
        this.ro.addOrganizador(utilizador);
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
    public void setPeriodo(Data dataInicio, Data dataFim) {
        this.m_dataInicio = dataInicio;
        this.m_dataFim = dataFim;
    }

    /**
     * Define novo local de exposição
     *
     * @param local novo local de exposição
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    public ArrayList<Organizador> getListaOrganizadores() {
        return this.ro.getListaOrganizadores();
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
        this.rfae.adicionaFAE(u);

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
    public List<CandidaturaAExposicao> getListaCandidaturasAExposicao() {
        return this.rce.getListaCandidaturasAExposicao();
    }

    /**
     * Lista dos fae da exposição
     *
     * @return lista dos fae
     */
    public List<FAE> getListaFAE() {
        return this.rfae.getListaFAE();
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
    public RegistoCandidaturasAExposicao getRegistoCandidaturas() {
        return rce;
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
        this.m_estado = estado;
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

    public EstadoExposicao getEstado() {
        return m_estado;
    }

    public RegistoConflitos getRegistoCoflitos() {
        return this.rconf;
    }

    public RegistoAtribuicoes getRegistoAtribuicoes() {
        return this.ra;
    }

    /**
     * Cria o timer que muda o estado da exposição para aberta a candidaturas
     */
    private void criaTimerAberturaCandidaturas( 
        Exposicao this) {
        Exposicao thisExpo = this;
        timerAberturaCandidatura = new Timer();
        timerAberturaCandidatura.schedule(new TimerTask() {
            @Override
            public void run() {
                EstadoExposicao estado = m_estado;
                estado.setEstadoCandidaturasAbertas();
            }
        }, getDataAberturaCandidatura().toDate());
    }

    private void criaTimerEncerramentoCandidaturas( 
        Exposicao this) {
        Exposicao thisExpo = this;
        timerEncerramentoCandidatura = new Timer();
        timerEncerramentoCandidatura.schedule(new TimerTask() {
            @Override
            public void run() {
                EstadoExposicao estado = m_estado;
                estado.setEstadoCandidaturasFechadas();
                DetetarConflitoController ctrl = new DetetarConflitoController(centroExposicoes);
                ctrl.detetaConflitos(getCentroDeExposicoes(), thisExpo);
            }
        }, getDataEncerramentoCandidatura().toDate());
    }

    private void criaTimerFimDetecaoConflitos( 
        Exposicao this) {
        Exposicao thisExpo = this;
        timerFimDetecaoConflitos = new Timer();
        timerFimDetecaoConflitos.schedule(new TimerTask() {
            @Override
            public void run() {
                EstadoExposicao estado = m_estado;
                estado.setEstadoConflitosDetetados();
            }
        }, this.m_dataFimDetecaoConflitos.toDate());
    }

    private void criaTimers() {
        criaTimerAberturaCandidaturas();
        criaTimerEncerramentoCandidaturas();
        criaTimerFimDetecaoConflitos();
    }

    /**
     * Devolve a data de abertura a candidaturas
     *
     * @return data de abertura a candidaturas
     */
    private Data getDataAberturaCandidatura() {
        return this.m_dataAberturaCandidatura;
    }

    /**
     * Devolve a data de encerramento a candidaturas
     *
     * @return data de encerramento a candidaturas
     */
    private Data getDataEncerramentoCandidatura() {
        return this.m_dataEncerramentoCandidatura;
    }

}
