package lapr.project.model;

import lapr.project.registos.*;
import java.util.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.estados.Exposicao.*;
import lapr.project.timerTasks.demonstracao.*;
import lapr.project.timerTasks.expo.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de uma Exposição
 *
 * @author G29
 */
public class Exposicao implements Agendavel, Importable<Exposicao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "exposicao";

    public static final String ESTADO_ATTR_NAME = "estado";

    public static final String TITUTLO_ELEMENT_NAME = "titulo";
    public static final String DESCR_ELEMENT_NAME = "descricao";
    public static final String DATA_INICIO_ELEMENT_NAME = "dataInicio";
    public static final String DATA_FIM_ELEMENT_NAME = "dataFim";
    public static final String DATA_ABERTURA_CAND_ELEMENT_NAME = "subInicio";
    public static final String DATA_ENCERRAMENTO_CAND_ELEMENT_NAME = "subFim";
    public static final String DATA_FIM_CONFLITOS_ELEMENT_NAME = "dataLimiteConflitos";

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
    private RegistoAtribuicoesCandidaturasExposicao m_ra;

    private RegistoAtribuicoesCandidaturasDemonstracao m_rad;

    /**
     *
     */
    private RegistoFAE m_rfae;

    /**
     *
     */
    private RegistoCandidaturasAExposicao m_rce;

    /**
     *
     */
    private RegistoCandidaturasAExposicaoRemovidas m_rcr;

    /**
     *
     */
    private RegistoOrganizadores m_ro;

    /**
     *
     */
    private RegistoDemonstracoes m_rd;

    /**
     *
     */
    private RegistoAtribuicoesStands m_ras;

    private RegistoConflitos m_rconf;

    private RegistoExpositores m_rexpositores;

    private KeywordRanking m_keywordRanking;

    private CentroExposicoes m_ce;

    /**
     * Construtor de Exposição sem parametros
     *
     * @param ce centro de exposições
     */
    public Exposicao(CentroExposicoes ce) {
        this.m_ce = ce;
        this.m_rce = new RegistoCandidaturasAExposicao(this);
        this.m_rfae = new RegistoFAE();
        this.m_rcr = new RegistoCandidaturasAExposicaoRemovidas(this);
        this.m_rconf = new RegistoConflitos();
        this.m_ra = new RegistoAtribuicoesCandidaturasExposicao();
        this.m_rd = new RegistoDemonstracoes(true);
        this.m_rd.setExposicao(this);
        this.m_ro = new RegistoOrganizadores();
        this.m_estado = new EstadoExposicaoInicial(this, ce);
        this.m_keywordRanking = new KeywordRanking();
        this.m_ras = new RegistoAtribuicoesStands();
        this.m_rexpositores = new RegistoExpositores();
        this.m_rad = new RegistoAtribuicoesCandidaturasDemonstracao();
    }

    /**
     * Construtor de Exposição com parametros
     *
     * @param titulo titulo da exposição
     * @param descricao descrição da exposição
     * @param dataInicio data de inicio da exposição
     * @param dataFim data de fim da exposição
     * @param dataInicioSubCand
     * @param dataFimSubCand
     * @param dataFimDetecaoConflitos
     * @param local local da exposição
     * @param centroExposicoes
     */
    public Exposicao(String titulo, String descricao, Data dataInicio, Data dataFim, Data dataInicioSubCand, Data dataFimSubCand, Data dataFimDetecaoConflitos, Local local, CentroExposicoes centroExposicoes) {
        this(centroExposicoes);
        this.m_strTitulo = titulo;
        this.m_strDescricao = descricao;
        this.m_dataInicio = dataInicio;
        this.m_dataFim = dataFim;
        this.local = local;
        this.m_dataAberturaCandidatura = dataInicioSubCand;
        this.m_dataEncerramentoCandidatura = dataFimSubCand;
        this.m_dataFimDetecaoConflitos = dataFimDetecaoConflitos;
    }

    /**
     * Método que valida a exposição
     *
     * @return true se a exposição for válida. Caso contrário retorna false.
     */
    public boolean valida() {
        return m_strTitulo != null && m_strDescricao != null && m_dataAberturaCandidatura != null && m_dataEncerramentoCandidatura != null && m_dataFim != null && m_dataInicio != null && m_dataFimDetecaoConflitos != null;
    }

    /**
     * Devolve o titulo da exposição
     *
     * @return titulo da exposição
     */
    public String getTitulo() {
        return m_strTitulo;
    }

    /**
     * Devolve a descrição da exposição
     *
     * @return descricao da exposição
     */
    public String getDescricao() {
        return m_strDescricao;
    }

    /**
     * Devolve a data de abertura de submissão de candidaturas à exposição
     *
     * @return data de abertura de submissão de candidaturas à exposição
     */
    public Data getDataInicioSubCand() {
        return m_dataAberturaCandidatura;
    }

    /**
     * Devolve a data de encerramento de submissão de candidaturas à exposição
     *
     * @return data de encerramento de submissão de candidaturas à exposição
     */
    public Data getDataFimSubCand() {
        return m_dataEncerramentoCandidatura;
    }

    /**
     * Devolve a data de fim de deteção de conflitos nas atribuições
     *
     * @return a data de fim de deteção de conflitos nas atribuições
     */
    public Data getDataFimDetecaoConflitos() {
        return m_dataFimDetecaoConflitos;
    }

    /**
     * Devolve a data de inicio da exposição
     *
     * @return data de inicio da exposição
     */
    public Data getDataInicio() {
        return m_dataInicio;
    }

    /**
     * Devolve a data de fim da exposição
     *
     * @return data de fim da exposição
     */
    public Data getDataFim() {
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

    public KeywordRanking getKeywordRanking() {
        return this.m_keywordRanking;
    }

    /**
     * Devolve o registo de candidaturas removidas da exposição
     *
     * @return registo de candidaturas removidas
     */
    public RegistoCandidaturasAExposicaoRemovidas getRegistoCandidaturasAExposicaoRemovidas() {
        return m_rcr;
    }

    /**
     * Define um novo título para esta exposição
     *
     * @param strTitulo novo título para esta exposição
     */
    public void setTitulo(String strTitulo) {
        this.m_strTitulo = (strTitulo == null || strTitulo.equals("")) ? null : strTitulo;
    }

    /**
     * Define uma nova descrição para esta exposição
     *
     * @param strDescricao nova descrição para esta exposição
     */
    public void setDescricao(String strDescricao) {
        this.m_strDescricao = (strDescricao == null || strDescricao.equals("")) ? null : strDescricao;
    }

    /**
     * Define um novo período de realização desta exposição
     *
     * @param dataInicio nova data de ínicio
     * @param dataFim nova data de fim
     */
    public void setPeriodo(Data dataInicio, Data dataFim) {
        this.m_dataInicio = dataInicio;
        this.m_dataFim = dataFim;
    }

    /**
     * Define a data de início para a realização desta exposição
     *
     * @param dataInicio nova data de inicio
     */
    public void setDataInicio(Data dataInicio) {
        this.m_dataInicio = dataInicio;
    }

    /**
     * Define a data de fim para a realização desta exposição
     *
     * @param dataFim nova data de fim
     */
    public void setDataFim(Data dataFim) {
        this.m_dataFim = dataFim;
    }

    /**
     * Define um novo local de exposição
     *
     * @param local novo local de exposição
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Devolve a lista de organizadores
     *
     * @return lista de organizadores
     */
    public List<Organizador> getListaOrganizadores() {
        return this.m_ro.getListaOrganizadores();
    }

    /**
     * Devolve a lista de fae
     *
     * @return lista de fae
     */
    public List<FAE> getListaFAE() {
        return this.m_rfae.getListaFAE();
    }

    /**
     * Valida os dados de um candidatura nova
     *
     * @param candidaturaAValidar candidatura a ser validada
     *
     * @return true se a candidatura for válida, false caso não seja
     */
    public boolean validarDadosCandidatura(CandidaturaAExposicao candidaturaAValidar) {
        for (CandidaturaAExposicao cand : this.getRegistoCandidaturasAExposicao().getListaCandidaturas()) {
            if (candidaturaAValidar.equals(cand)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adiciona um novo fae à exposição recebendo o utilizador como parametro
     *
     * @param u utilizador que passará a ser considerado como FAE da exposição
     * @return Retorna TRUE se o utilizador foi adicionado com successo
     */
    public boolean addFAE(Utilizador u) {
        //cria o fae a partir do utilizador recebido (u)
        for (Organizador o : this.m_ro.getListaOrganizadores()) {
            if (o.getUsernameOrganizador().equals(u.getUsername())) {
                return false;
            }
        }
        return this.m_rfae.adicionaFAE(u);
    }

    /**
     * Devolve a lista de todas as candidaturas associadas à exposição
     *
     * @return arraylist com todas as candidatuas associadas à exposição
     */
    public List<CandidaturaAExposicao> getListaCandidaturasAExposicao() {
        return this.m_rce.getListaCandidaturas();
    }

    /**
     *
     * @return
     */
    public RegistoFAE getRegistoFAE() {
        return m_rfae;
    }

    /**
     *
     * @return
     */
    public RegistoCandidaturasAExposicao getRegistoCandidaturasAExposicao() {
        return m_rce;
    }

    /**
     * Método que valida candidatura
     *
     * @param c candidatura
     *
     * @return boolean de confirmação da validação
     */
    public boolean validarCandidatura(CandidaturaAExposicao c) {
        return c.validaCandidatura();
    }

    public void setEstado(EstadoExposicao estado) {
        this.m_estado = estado;
    }

    /**
     * Métoto que define nova decisao
     *
     * @param candidaturaAExposicao
     * @param decisao
     */
    public void setDecisao(CandidaturaAExposicao candidaturaAExposicao, boolean decisao) {
        candidaturaAExposicao.setDecisao(decisao);
    }

    /**
     * Devolve o registo de demonstrações
     *
     * @return registo de demonstrações
     */
    public RegistoDemonstracoes getRegistoDemonstracoes() {
        if (this.m_rd.getExposicao() == null) {
            this.m_rd.setExposicao(this);
        }
        return this.m_rd;
    }

    /**
     *
     * @return
     */
    public boolean dadosMinimosObrigatorios() {
        return m_dataAberturaCandidatura != null
                && m_dataEncerramentoCandidatura != null
                && m_dataFim != null
                && m_dataFimDetecaoConflitos != null
                && m_dataInicio != null
                && m_ro.getListaOrganizadores().size() >= 2
                && m_strTitulo != null
                && m_strTitulo.length() > 0
                && m_strDescricao != null
                && m_strDescricao.length() > 0
                && local != null;
    }

    public EstadoExposicao getEstado() {
        return m_estado;
    }

    public RegistoConflitos getRegistoConflitos() {
        return this.m_rconf;
    }

    /**
     * Devolve o registo de atribuições
     *
     * @return registo de atribuições
     */
    public RegistoAtribuicoesCandidaturasExposicao getRegistoAtribuicoesExposicao() {
        return this.m_ra;
    }

    public RegistoAtribuicoesCandidaturasDemonstracao getRegistoAtribuicoesDemonstracao() {
        return this.m_rad;
    }

    public RegistoOrganizadores getRegistoOrganizadores() {
        return this.m_ro;
    }

    /**
     * Devolve o registo de atribuicoes stand
     *
     * @return registo de atribuicoes stand
     */
    public RegistoAtribuicoesStands getRegistoAtribuicoesStands() {
        return m_ras;
    }

    /**
     * Programa um timer
     *
     * @param m_tt - timertask (tarefa a realizar aquando da data prevista)
     * @param date - data para acionar o timer
     */
    @Override
    public void schedule(TimerTask m_tt, Data date) {
        Timer timer = new Timer();
        timer.schedule(m_tt, date.toDate());
    }

    /**
     * Permite alterar a data de abertura de submissão de candidaturas
     *
     * @param dataAberturaSubCand - data de abertura de submissão de
     * candidaturas
     */
    public void setDataAberturaSubCand(Data dataAberturaSubCand) {
        m_dataAberturaCandidatura = dataAberturaSubCand;
    }

    /**
     * Permite alterar a data de encerramento de submissão de candidaturas
     *
     * @param dataEncerramentoSubCand - data de encerramento de submissão de
     * candidaturas
     */
    public void setDataEncerramentoSubCand(Data dataEncerramentoSubCand) {
        m_dataEncerramentoCandidatura = dataEncerramentoSubCand;
    }

    /**
     * Permite alterar a data de fim de deteção de conflitos de interesse
     *
     * @param dataFimDetecaoConflitos - data de fim de deteção de conflitos de
     * interesse
     */
    public void setDataFimDetecaoConflitos(Data dataFimDetecaoConflitos) {
        m_dataFimDetecaoConflitos = dataFimDetecaoConflitos;
    }

    /**
     * @param dataInicioCandDemo the dataInicioCandDemo to set
     */
    public void setDataInicioCandDemo(Data dataInicioCandDemo) {
        for (Demonstracao d : m_rd.getListaDemonstracoes()) {
            if (d.getEstadoDemo().isEstadoDemonstracaoConfirmada()) {
                d.setDataInicioCandidaturas(dataInicioCandDemo);
                d.getEstadoDemo().setEstadoDemonstracaoDatasDefinidas();
            }
        }
    }

    /**
     * @param dataFimCandDemo the dataFimCandDemo to set
     */
    public void setDataFimCandDemo(Data dataFimCandDemo) {
        for (Demonstracao d : m_rd.getListaDemonstracoes()) {
            if (d.getEstadoDemo().isEstadoDemonstracaoConfirmada()) {
                d.setDataFimCandidaturas(dataFimCandDemo, m_ce);
            }
        }
    }

    public void setDataFimDetecaoConflitosDemo(Data dataFimDetecaoConflitos) {
        for (Demonstracao d : m_rd.getListaDemonstracoes()) {
            if (d.getEstadoDemo().isEstadoDemonstracaoConfirmada()) {
                d.setDataFimDetecaoConflitos(dataFimDetecaoConflitos);
            }
        }
    }

    /**
     * @return the m_ce
     */
    public CentroExposicoes getCentroExposicoes() {
        return m_ce;
    }

    /**
     * @param ce the ce to set
     */
    public void setCentroExposicoes(CentroExposicoes ce) {
        this.m_ce = ce;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Exposicao) {
            Exposicao o = (Exposicao) obj;
            return (local == null ? o.local == null : local.equals(o.local))
                    && (m_dataAberturaCandidatura == null ? o.m_dataAberturaCandidatura == null : m_dataAberturaCandidatura.equals(o.m_dataAberturaCandidatura))
                    && (m_dataEncerramentoCandidatura == null ? o.m_dataEncerramentoCandidatura == null : m_dataEncerramentoCandidatura.equals(o.m_dataEncerramentoCandidatura))
                    && (m_dataFim == null ? o.m_dataFim == null : m_dataFim.equals(o.m_dataFim))
                    && (m_dataFimDetecaoConflitos == null ? o.m_dataFimDetecaoConflitos == null : m_dataFimDetecaoConflitos.equals(o.m_dataFimDetecaoConflitos))
                    && (m_dataInicio == null ? o.m_dataInicio == null : m_dataInicio.equals(o.m_dataInicio))
                    && (m_strTitulo == null ? o.m_strTitulo == null : m_strTitulo.equals(o.m_strTitulo))
                    && (m_strDescricao == null ? o.m_strDescricao == null : m_strDescricao.equals(o.m_strDescricao));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.m_strTitulo);
        hash = 97 * hash + Objects.hashCode(this.m_strDescricao);
        hash = 97 * hash + Objects.hashCode(this.m_dataInicio);
        hash = 97 * hash + Objects.hashCode(this.m_dataFim);
        hash = 97 * hash + Objects.hashCode(this.m_dataAberturaCandidatura);
        hash = 97 * hash + Objects.hashCode(this.m_dataEncerramentoCandidatura);
        hash = 97 * hash + Objects.hashCode(this.m_dataFimDetecaoConflitos);
        hash = 97 * hash + Objects.hashCode(this.local);
        return hash;
    }

    /**
     * Corrige as discrepâncias nas referências deste objeto causadas pela
     * exportação e importação de XML.
     *
     * @param m_registoRecursos Registo de recursos
     * @param m_registoTipoConflitos Registo de tipos de conflito
     * @param m_registoUtilizadores Registo de Utilizadores
     */
    public void fix(RegistoRecursos m_registoRecursos, RegistoTipoConflitos m_registoTipoConflitos, RegistoUtilizadores m_registoUtilizadores) {
        this.m_ro.fix(m_registoUtilizadores);
        this.m_rfae.fix(m_registoUtilizadores);
        this.m_rexpositores.fix(m_registoUtilizadores);
        this.m_rce.fix(m_registoUtilizadores, this.m_rd);
        this.m_rd.setExposicao(this);
        this.m_rd.fix(m_registoRecursos, m_rce, m_registoUtilizadores);
        this.m_ra.fix(this.m_rce, m_registoUtilizadores);
    }

    /**
     * Recria os Timers da demonstração ao importar dados do XML
     */
    public void recriarTimersDemo() {
        List<Demonstracao> lstDemos = m_rd.getListaDemonstracoes();
        if (this.getEstado().isEstadoCandidaturasDecididas()) {
            for (Demonstracao d : lstDemos) {
                d.schedule(new AlterarParaCandidaturasAbertas(d), d.getDataInicioCand());
                d.schedule(new AlterarParaCandidaturasFechadas(d), d.getDataFimCand());
                d.schedule(new AlterarParaConflitosDetetados(d), d.getDataFimDetecaoConflitos());
            }

        }
    }

    /**
     * Recria os Timers da exposição ao importar dados do XML
     */
    public void recriarTimersExpo() {
        Data data1 = this.getDataInicioSubCand();

        Data data2 = this.getDataFimSubCand();

        Data data3 = this.getDataFimDetecaoConflitos();

        TimerTask inicioSubCand = new AlterarParaAbertaCandidaturas(this);
        this.schedule(inicioSubCand, data1);

        TimerTask fimSubCand = new AlterarParaFechadaCandidaturas(this, m_ce);
        this.schedule(fimSubCand, data2);

        TimerTask fimDetecaoConflitos = new AlterarParaConflitosAtualizados(this);
        this.schedule(fimDetecaoConflitos, data3);
    }

    @Override
    public Exposicao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        NodeList elementsKeyword = document.getChildNodes();
        Node n = elementsKeyword.item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_strTitulo = elem.getElementsByTagName(TITUTLO_ELEMENT_NAME).item(0).getTextContent();
            this.m_strDescricao = elem.getElementsByTagName(DESCR_ELEMENT_NAME).item(0).getTextContent();

            Data invalidData = new Data(1, 1, 1);

            Element elem2 = (Element) elem.getElementsByTagName(DATA_ABERTURA_CAND_ELEMENT_NAME).item(0);
            this.m_dataAberturaCandidatura = new Data(1, 1, 1);
            this.m_dataAberturaCandidatura.importContentFromXMLNode(elem2);
            if (this.m_dataAberturaCandidatura.equals(invalidData)) {
                this.m_dataAberturaCandidatura = null;
            }

            elem2 = (Element) elem.getElementsByTagName(DATA_ENCERRAMENTO_CAND_ELEMENT_NAME).item(0);
            this.m_dataEncerramentoCandidatura = new Data(1, 1, 1);
            this.m_dataEncerramentoCandidatura.importContentFromXMLNode(elem2);
            if (this.m_dataEncerramentoCandidatura.equals(invalidData)) {
                this.m_dataEncerramentoCandidatura = null;
            }

            elem2 = (Element) elem.getElementsByTagName(DATA_FIM_ELEMENT_NAME).item(0);
            this.m_dataFim = new Data(1, 1, 1);
            this.m_dataFim.importContentFromXMLNode(elem2);
            if (this.m_dataFim.equals(invalidData)) {
                this.m_dataFim = null;
            }

            elem2 = (Element) elem.getElementsByTagName(DATA_FIM_CONFLITOS_ELEMENT_NAME).item(0);
            this.m_dataFimDetecaoConflitos = new Data(1, 1, 1);
            this.m_dataFimDetecaoConflitos.importContentFromXMLNode(elem2);
            if (this.m_dataFimDetecaoConflitos.equals(invalidData)) {
                this.m_dataFimDetecaoConflitos = null;
            }

            elem2 = (Element) elem.getElementsByTagName(DATA_INICIO_ELEMENT_NAME).item(0);
            this.m_dataInicio = new Data(1, 1, 1);
            this.m_dataInicio.importContentFromXMLNode(elem2);
            if (this.m_dataInicio.equals(invalidData)) {
                this.m_dataInicio = null;
            }

            this.m_ro.importContentFromXMLNode(elem.getElementsByTagName(RegistoOrganizadores.ROOT_ELEMENT_NAME).item(0));
            this.m_rfae.importContentFromXMLNode(elem.getElementsByTagName(RegistoFAE.ROOT_ELEMENT_NAME).item(0));
            this.m_rce.importContentFromXMLNode(elem.getElementsByTagName(RegistoCandidaturasAExposicao.ROOT_ELEMENT_NAME).item(0));
            if (this.m_ra.getListaAtribuicoes().isEmpty()) {
                this.m_ra.importContentFromXMLNode(elem.getElementsByTagName(RegistoAtribuicoesCandidaturasExposicao.ROOT_ELEMENT_NAME).item(0));
            }
            this.m_rad.importContentFromXMLNode(elem.getElementsByTagName(RegistoAtribuicoesCandidaturasDemonstracao.ROOT_ELEMENT_NAME).item(0));
            this.m_ras.importContentFromXMLNode(elem.getElementsByTagName(RegistoAtribuicoesStands.ROOT_ELEMENT_NAME).item(0));
            this.m_rconf.importContentFromXMLNode(elem.getElementsByTagName(RegistoConflitos.ROOT_ELEMENT_NAME).item(0));
            this.m_rcr.importContentFromXMLNode(elem.getElementsByTagName(RegistoCandidaturasAExposicaoRemovidas.ROOT_ELEMENT_NAME).item(0));
            this.m_rd.importContentFromXMLNode(elem.getElementsByTagName(RegistoDemonstracoes.ROOT_ELEMENT_NAME + m_rd.TAG_SUFFIX).item(0));
            this.m_rd.setExposicao(this);
            this.m_rexpositores.importContentFromXMLNode(elem.getElementsByTagName(RegistoExpositores.ROOT_ELEMENT_NAME).item(0));
            this.local = new Local("");
            this.local.importContentFromXMLNode(elem.getElementsByTagName(Local.ROOT_ELEMENT_NAME).item(0));
            this.m_keywordRanking.importContentFromXMLNode(elem.getElementsByTagName(KeywordRanking.ROOT_ELEMENT_NAME).item(0));

            String estado = elem.getAttribute(ESTADO_ATTR_NAME);
            switch (estado) {
                case "inicial":
                    this.m_estado = new EstadoExposicaoInicial(this, m_ce);
                    break;
                case "criada":
                    this.m_estado = new EstadoExposicaoCriada(this);
                    recriarTimersExpo();
                    break;
                case "demosSemFAE":
                    this.m_estado = new EstadoExposicaoDemosDefinidasSemFAE(this);
                    recriarTimersExpo();
                    break;
                case "FAESemDemos":
                    this.m_estado = new EstadoExposicaoFAEDefinidosSemDemos(this);
                    recriarTimersExpo();
                    break;
                case "completa":
                    this.m_estado = new EstadoExposicaoCompleta(this);
                    recriarTimersExpo();
                    break;
                case "candsAbertas":
                    this.m_estado = new EstadoExposicaoCandidaturasAbertas(this);
                    recriarTimersExpo();
                    break;
                case "candsFechadas":
                    this.m_estado = new EstadoExposicaoCandidaturasFechadas(this);
                    break;
                case "conflitosDetetados":
                    this.m_estado = new EstadoExposicaoConflitosDetetados(this);
                    break;
                case "conflitosAlterados":
                    this.m_estado = new EstadoExposicaoConflitosAlterados(this);
                    break;
                case "candsAtribuidas":
                    this.m_estado = new EstadoExposicaoCandidaturasAtribuidas(this);
                    break;
                case "candsAvaliadas":
                    this.m_estado = new EstadoExposicaoCandidaturasAvaliadas(this);
                    break;
                case "candsDecididas":
                    this.m_estado = new EstadoExposicaoCandidaturasDecididas(this);
                    if (!this.m_keywordRanking.isReady()) {
                        for (CandidaturaAExposicao cand : getListaCandidaturasAExposicao()) {
                            if (!cand.getEstado().isEstadoCandidaturaRemovida()) {
                                String[] keywords = cand.getKeywords();
                                for (String str : keywords) {
                                    this.m_keywordRanking.addKeyword(str, cand.getDecisao());
                                }
                            }
                        }
                        this.m_keywordRanking.setReady();
                    }
                    break;
                default:
                    break;
            }
            recriarTimersDemo();
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementExpo = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementExpo);

            if (this.m_estado.isEstadoInicial()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "inicial");
            } else if (this.m_estado.isEstadoCriada()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "criada");
            } else if (this.m_estado.isEstadoDemosDefinidasSemFAE()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "demosSemFAE");
            } else if (this.m_estado.isEstadoFAEDefinidosSemDemos()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "FAESemDemos");
            } else if (this.m_estado.isEstadoCompleta()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "completa");
            } else if (this.m_estado.isEstadoCandidaturasAbertas()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "candsAbertas");
            } else if (this.m_estado.isEstadoCandidaturasFechadas()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "candsFechadas");
            } else if (this.m_estado.isEstadoConflitosDetetados()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "conflitosDetetados");
            } else if (this.m_estado.isEstadoConflitosAlterados()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "conflitosAlterados");
            } else if (this.m_estado.isEstadoCandidaturasAtribuidas()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "candsAtribuidas");
            } else if (this.m_estado.isEstadoCandidaturasAvaliadas()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "candsAvaliadas");
            } else if (this.m_estado.isEstadoCandidaturasDecididas()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "candsDecididas");
            }

            Element elemChild;

            elemChild = document.createElement(TITUTLO_ELEMENT_NAME);
            elemChild.setTextContent(this.m_strTitulo);
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DESCR_ELEMENT_NAME);
            elemChild.setTextContent(this.m_strDescricao);
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_INICIO_ELEMENT_NAME);
            if (this.m_dataInicio == null) {
                elemChild.setTextContent(new Data(1, 1, 1).exportContentToXMLNode().getTextContent());
            } else {
                elemChild.setTextContent(this.m_dataInicio.exportContentToXMLNode().getTextContent());
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_FIM_ELEMENT_NAME);
            if (this.m_dataFim == null) {
                elemChild.setTextContent(new Data(1, 1, 1).exportContentToXMLNode().getTextContent());
            } else {
                elemChild.setTextContent(this.m_dataFim.exportContentToXMLNode().getTextContent());
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_ABERTURA_CAND_ELEMENT_NAME);
            if (this.m_dataAberturaCandidatura == null) {
                elemChild.setTextContent(new Data(1, 1, 1).exportContentToXMLNode().getTextContent());
            } else {
                elemChild.setTextContent(this.m_dataAberturaCandidatura.exportContentToXMLNode().getTextContent());
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_ENCERRAMENTO_CAND_ELEMENT_NAME);
            if (this.m_dataEncerramentoCandidatura == null) {
                elemChild.setTextContent(new Data(1, 1, 1).exportContentToXMLNode().getTextContent());
            } else {
                elemChild.setTextContent(this.m_dataEncerramentoCandidatura.exportContentToXMLNode().getTextContent());
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_FIM_CONFLITOS_ELEMENT_NAME);
            if (this.m_dataFimDetecaoConflitos == null) {
                elemChild.setTextContent(new Data(1, 1, 1).exportContentToXMLNode().getTextContent());
            } else {
                elemChild.setTextContent(this.m_dataFimDetecaoConflitos.exportContentToXMLNode().getTextContent());
            }
            elementExpo.appendChild(elemChild);

            elementExpo.appendChild(document.importNode(this.m_ra.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rad.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_ras.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rce.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rconf.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rcr.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rd.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rexpositores.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rfae.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_ro.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.local.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_keywordRanking.exportContentToXMLNode(), true));

            node = elementExpo;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Exposicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

    public void addOrganizadores(List<Organizador> m_organizadoresSelecionados) {
        for (Organizador o : m_organizadoresSelecionados) {
            this.m_ro.addOrganizador(o);
        }
    }

    /**
     * Apenas para uso de TESTES
     *
     * @param m_keywordRanking the m_keywordRanking to set
     */
    public void setKeywordRanking(KeywordRanking m_keywordRanking) {
        this.m_keywordRanking = m_keywordRanking;
    }

    /**
     * * APENAS PARA TESTES
     *
     * @param m_ra the m_ra to set
     */
    public void setRegistoAtribuicoes(RegistoAtribuicoesCandidaturasExposicao m_ra) {
        this.m_ra = m_ra;
    }

    /**
     * * APENAS PARA TESTES
     *
     * @param m_rfae the m_rfae to set
     */
    public void setRegistoFAE(RegistoFAE m_rfae) {
        this.m_rfae = m_rfae;
    }

    /**
     * * APENAS PARA TESTES
     *
     * @param m_rce the m_rce to set
     */
    public void setRegistoCandidaturasAExposicao(RegistoCandidaturasAExposicao m_rce) {
        this.m_rce = m_rce;
    }

    /**
     * * APENAS PARA TESTES
     *
     * @param m_rcr the m_rcr to set
     */
    public void setRegistoCandidaturasAExposicaoRemovidas(RegistoCandidaturasAExposicaoRemovidas m_rcr) {
        this.m_rcr = m_rcr;
    }

    /**
     * * APENAS PARA TESTES
     *
     * @param m_ro the m_ro to set
     */
    public void setRegistoOrganizadores(RegistoOrganizadores m_ro) {
        this.m_ro = m_ro;
    }

    /**
     * * APENAS PARA TESTES
     *
     * @param m_rd the m_rd to set
     */
    public void setRegistoDemonstracoes(RegistoDemonstracoes m_rd) {
        this.m_rd = m_rd;
    }

    /**
     * * APENAS PARA TESTES
     *
     * @param m_ras the m_ras to set
     */
    public void setRegistoAtribuicoesStands(RegistoAtribuicoesStands m_ras) {
        this.m_ras = m_ras;
    }

    /**
     * * APENAS PARA TESTES
     *
     * @param m_rconf the m_rconf to set
     */
    public void setRegistoConflitos(RegistoConflitos m_rconf) {
        this.m_rconf = m_rconf;
    }

    /**
     * * APENAS PARA TESTES
     *
     * @param m_rexpositores the m_rexpositores to set
     */
    public void setRegistoExpositores(RegistoExpositores m_rexpositores) {
        this.m_rexpositores = m_rexpositores;
    }

}
