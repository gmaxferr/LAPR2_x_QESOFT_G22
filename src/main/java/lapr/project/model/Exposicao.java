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
 * @author Ana Leite Ricardo Osório
 */
public class Exposicao implements Agendavel, Importable<Exposicao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Exposicao";

    public static final String TITUTLO_ATTR_NAME = "titutlo";
    public static final String ESTADO_ATTR_NAME = "estado";

    public static final String DESCR_ELEMENT_NAME = "Descricao";
    public static final String DATA_INICIO_ELEMENT_NAME = "DataInicio";
    public static final String DATA_FIM_ELEMENT_NAME = "DataFim";
    public static final String DATA_ABERTURA_CAND_ELEMENT_NAME = "DataAberturaCandidatura";
    public static final String DATA_ENCERRAMENTO_CAND_ELEMENT_NAME = "DataEncerramentoCandidatura";
    public static final String DATA_FIM_CONFLITOS_ELEMENT_NAME = "DataFimConflitos";
    public static final String DATA_INICIO_CAND_DEMO_ELEMENT_NAME = "DataInicioCandDemo";
    public static final String DATA_FIM_CAND_DEMO_ELEMENT_NAME = "DataFimCandDemo";

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
     * Data de abertura de candidaturas a demonstrações.
     */
    private Data m_dataInicioCandDemo;

    /**
     * Data de fim de candidaturas a demonstrações.
     */
    private Data m_dataFimCandDemo;

    /**
     * Atributo local de Exposição
     */
    private Local local;

    /**
     *
     */
    private RegistoAtribuicoes m_ra;

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
    private RegistoCandidaturasRemovidas m_rcr;

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
     */
    public Exposicao(CentroExposicoes ce) {
        this.m_ce = ce;
        this.m_rce = new RegistoCandidaturasAExposicao();
        this.m_rfae = new RegistoFAE();
        this.m_rcr = new RegistoCandidaturasRemovidas();
        this.m_rconf = new RegistoConflitos();
        this.m_ra = new RegistoAtribuicoes();
        this.m_rd = new RegistoDemonstracoes();
        this.m_ro = new RegistoOrganizadores();
        this.m_estado = new EstadoExposicaoInicial(this, ce);
        this.m_keywordRanking = new KeywordRanking();
        this.m_ras = new RegistoAtribuicoesStands();
        this.m_rexpositores = new RegistoExpositores();
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

        this.m_rce = new RegistoCandidaturasAExposicao();
        this.m_rfae = new RegistoFAE();
        this.m_rcr = new RegistoCandidaturasRemovidas();
        this.m_rconf = new RegistoConflitos();
        this.m_ra = new RegistoAtribuicoes();
        this.m_rd = new RegistoDemonstracoes();
        this.m_ro = new RegistoOrganizadores();
        this.m_ras = new RegistoAtribuicoesStands();
        this.m_rexpositores = new RegistoExpositores();
    }

    /**
     * Método que valida a exposição
     *
     * @return boolean de confirmação de validação
     */
    public boolean valida() {
        if (m_strTitulo != null && m_strDescricao != null && m_dataAberturaCandidatura != null && m_dataEncerramentoCandidatura != null && m_dataFim != null && m_dataInicio != null && m_dataFimDetecaoConflitos != null) {
            return true;
        } else {
            return false;
        }
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
     * @return
     */
    public RegistoCandidaturasRemovidas getRegistoCandidaturasRemovidas() {
        return m_rcr;
    }

    /**
     * Define um novo título para esta exposição
     *
     * @param strTitulo novo título para esta exposição
     */
    public void setTitulo(String strTitulo) {
        this.m_strTitulo = strTitulo;
    }

    /**
     * Define uma nova descrição para esta exposição
     *
     * @param strDescricao nova descrição para esta exposição
     */
    public void setDescricao(String strDescricao) {
        this.m_strDescricao = strDescricao;
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
     * Define um novo local de exposição
     *
     * @param local novo local de exposição
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Organizador> getListaOrganizadores() {
        return this.m_ro.getListaOrganizadores();
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
     */
    public void addFAE(Utilizador u) {
        //cria o fae a partir do utilizador recebido (u)
        this.m_rfae.adicionaFAE(u);

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
     *
     * @return
     */
    public RegistoOrganizadores getRo() {
        return m_ro;
    }

    /**
     *
     * @return
     */
    public RegistoDemonstracoes getRd() {
        return m_rd;
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
     */
    public void setDecisao(CandidaturaAExposicao candidaturaAExposicao, boolean decisao) {
        candidaturaAExposicao.setDecisao(decisao);
    }

    public RegistoDemonstracoes getRegistoDemonstracoes() {
        return this.m_rd;
    }

    /**
     *
     * @return
     */
    public boolean dadosMinimosObrigatorios() {
        if (m_dataAberturaCandidatura != null && m_dataEncerramentoCandidatura != null && m_dataFim != null && m_dataFimDetecaoConflitos != null && m_dataInicio != null && m_ro.getListaOrganizadores().size() >= 2 && m_strTitulo.length() > 0 && m_strDescricao.length() > 0 && local != null) {
            return true;
        } else {
            return false;
        }
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
    public RegistoAtribuicoes getRegistoAtribuicoes() {
        return this.m_ra;
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
     * @return the dataInicioCandDemo
     */
    public Data getDataInicioCandDemo() {
        return m_dataInicioCandDemo;
    }

    /**
     * @param dataInicioCandDemo the dataInicioCandDemo to set
     */
    public void setDataInicioCandDemo(Data dataInicioCandDemo) {
        this.m_dataInicioCandDemo = dataInicioCandDemo;
        for (Demonstracao d : m_rd.getListaDemonstracoes()) {
            if (d.getEstadoDemo().isEstadoDemonstracaoConfirmada()) {
                d.setDataInicioCandidaturas(dataInicioCandDemo);
            }
        }
    }

    /**
     * @return the dataFimCandDemo
     */
    public Data getDataFimCandDemo() {
        return m_dataFimCandDemo;
    }

    /**
     * @param dataFimCandDemo the dataFimCandDemo to set
     */
    public void setDataFimCandDemo(Data dataFimCandDemo) {
        this.m_dataFimCandDemo = dataFimCandDemo;
        for (Demonstracao d : m_rd.getListaDemonstracoes()) {
            if (d.getEstadoDemo().isEstadoDemonstracaoConfirmada()) {
                d.setDataFimCandidaturas(dataFimCandDemo);
            }
        }
    }

    public void fix(RegistoRecursos m_registoRecursos, RegistoTipoConflitos m_registoTipoConflitos, RegistoUtilizadores m_registoUtilizadores) {
        this.m_ro.fix(m_registoUtilizadores);
        this.m_rfae.fix(m_registoUtilizadores, this.m_ro);
        this.m_rexpositores.fix(m_registoUtilizadores);
        this.m_rce.fix(m_registoUtilizadores, this.m_rd);
        this.m_rd.fix(m_registoRecursos);
        this.m_ra.fix(this.m_rce, m_registoUtilizadores);
    }

    /**
     * Verifica se o utilizadoré FAE desta exposição
     *
     * @param utilizador - utilizador a verificar
     * @return true se o utilizador nao é FAEou false caso contrário
     */
    public boolean validaOrganizador(Organizador utilizador) {
        for (FAE f : m_rfae.getListaFAE()) {
            if (utilizador.getUsernameOrganizador().equals(f.getUsernameFae())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Recria os Timers da demonstração ao importar dados do XML
     */
    public void recriarTimersDemo() {
        List<Demonstracao> lstDemos = m_rd.getListaDemonstracoes();
        if (this.getEstado().isEstadoCandidaturasDecididas() || this.getEstado().isEstadoStandsAtribuidos()) {
            for (Demonstracao d : lstDemos) {
                d.schedule(new AlterarParaCandidaturasAbertas(d), d.getDataInicioCand());
                d.schedule(new AlterarParaCandidaturasFechadas(d), d.getDataFimCand());
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
    public Exposicao importContentFromXMLNode(Node node) {
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

                this.m_strTitulo = elem.getAttribute(TITUTLO_ATTR_NAME);

                Data invalidData = new Data(0, 0, 0);

                Element elem2 = (Element) elem.getElementsByTagName(DATA_ABERTURA_CAND_ELEMENT_NAME).item(0);
                this.m_dataAberturaCandidatura = new Data(0, 0, 0);
                this.m_dataAberturaCandidatura.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataAberturaCandidatura.equals(invalidData)) {
                    this.m_dataAberturaCandidatura = null;
                }

                elem2 = (Element) elem.getElementsByTagName(DATA_ENCERRAMENTO_CAND_ELEMENT_NAME).item(0);
                this.m_dataEncerramentoCandidatura = new Data(0, 0, 0);
                this.m_dataEncerramentoCandidatura.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataEncerramentoCandidatura.equals(invalidData)) {
                    this.m_dataEncerramentoCandidatura = null;
                }

                elem2 = (Element) elem.getElementsByTagName(DATA_FIM_ELEMENT_NAME).item(0);
                this.m_dataFim = new Data(0, 0, 0);
                this.m_dataFim.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataFim.equals(invalidData)) {
                    this.m_dataFim = null;
                }

                elem2 = (Element) elem.getElementsByTagName(DATA_FIM_CAND_DEMO_ELEMENT_NAME).item(0);
                this.m_dataFimCandDemo = new Data(0, 0, 0);
                this.m_dataFimCandDemo.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataFimCandDemo.equals(invalidData)) {
                    this.m_dataFimCandDemo = null;
                }

                elem2 = (Element) elem.getElementsByTagName(DATA_FIM_CONFLITOS_ELEMENT_NAME).item(0);
                this.m_dataFimDetecaoConflitos = new Data(0, 0, 0);
                this.m_dataFimDetecaoConflitos.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataFimDetecaoConflitos.equals(invalidData)) {
                    this.m_dataFimDetecaoConflitos = null;
                }

                elem2 = (Element) elem.getElementsByTagName(DATA_INICIO_ELEMENT_NAME).item(0);
                this.m_dataInicio = new Data(0, 0, 0);
                this.m_dataInicio.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataInicio.equals(invalidData)) {
                    this.m_dataInicio = null;
                }

                elem2 = (Element) elem.getElementsByTagName(DATA_INICIO_CAND_DEMO_ELEMENT_NAME).item(0);
                this.m_dataInicioCandDemo = new Data(0, 0, 0);
                this.m_dataInicioCandDemo.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataInicioCandDemo.equals(invalidData)) {
                    this.m_dataInicioCandDemo = null;
                }

                this.m_ra.importContentFromXMLNode(elem.getElementsByTagName(RegistoAtribuicoes.ROOT_ELEMENT_NAME).item(0));
                this.m_ras.importContentFromXMLNode(elem.getElementsByTagName(RegistoAtribuicoesStands.ROOT_ELEMENT_NAME).item(0));
                this.m_rce.importContentFromXMLNode(elem.getElementsByTagName(RegistoCandidaturasAExposicao.ROOT_ELEMENT_NAME).item(0));
                this.m_rconf.importContentFromXMLNode(elem.getElementsByTagName(RegistoConflitos.ROOT_ELEMENT_NAME).item(0));
                this.m_rcr.importContentFromXMLNode(elem.getElementsByTagName(RegistoCandidaturasRemovidas.ROOT_ELEMENT_NAME).item(0));
                this.m_rd.importContentFromXMLNode(elem.getElementsByTagName(RegistoDemonstracoes.ROOT_ELEMENT_NAME).item(0));
                this.m_rexpositores.importContentFromXMLNode(elem.getElementsByTagName(RegistoExpositores.ROOT_ELEMENT_NAME).item(0));
                this.m_rfae.importContentFromXMLNode(elem.getElementsByTagName(RegistoFAE.ROOT_ELEMENT_NAME).item(0));
                this.m_ro.importContentFromXMLNode(elem.getElementsByTagName(RegistoOrganizadores.ROOT_ELEMENT_NAME).item(0));

                String estado = elem.getAttribute(ESTADO_ATTR_NAME);
                switch (estado) {
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
                        break;
                    case "standsAtribuidos":
                        this.m_estado = new EstadoExposicaoStandsAtribuidos(this);
                        break;
                    case "demosDecididas":
                        this.m_estado = new EstadoExposicaoDemonstracoesDecididas(this);
                        recriarTimersDemo();
                        break;
                    case "candDemosAbertas":
                        this.m_estado = new EstadoExposicaoCandidaturasDemonstracaoAbertas(this);
                        recriarTimersDemo();
                        break;
                    case "candDemosFechadas":
                        this.m_estado = new EstadoExposicaoCandidaturasDemonstracaoFechadas(this);
                        break;
                    default:
                        break;
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Exposicao.class.getName()).log(Level.SEVERE, null, ex);
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

            Element elementExpo = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementExpo);

            elementExpo.setAttribute(TITUTLO_ATTR_NAME, this.m_strTitulo);

            if (this.m_estado.isEstadoCriada()) {
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
            } else if (this.m_estado.isEstadoStandsAtribuidos()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "standsAtribuidos");
            } else if (this.m_estado.isEstadoDemonstracoesDecididas()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "demosDecididas");
            } else if (this.m_estado.isEstadoCandidaturasDemonstracaoAbertas()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "candDemosAbertas");
            } else if (this.m_estado.isEstadoCandidaturasDemonstracaoFechadas()) {
                elementExpo.setAttribute(ESTADO_ATTR_NAME, "candDemosFechadas");
            }

            Element elemChild;

            elemChild = document.createElement(DATA_ABERTURA_CAND_ELEMENT_NAME);
            if (this.m_dataAberturaCandidatura == null) {
                elemChild.appendChild(document.importNode(new Data(0, 0, 0).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataAberturaCandidatura.exportContentToXMLNode(), true));
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_ENCERRAMENTO_CAND_ELEMENT_NAME);
            if (this.m_dataEncerramentoCandidatura == null) {
                elemChild.appendChild(document.importNode(new Data(0, 0, 0).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataEncerramentoCandidatura.exportContentToXMLNode(), true));
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_FIM_CAND_DEMO_ELEMENT_NAME);
            if (this.m_dataFimCandDemo == null) {
                elemChild.appendChild(document.importNode(new Data(0, 0, 0).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataFimCandDemo.exportContentToXMLNode(), true));
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_FIM_CONFLITOS_ELEMENT_NAME);
            if (this.m_dataFimDetecaoConflitos == null) {
                elemChild.appendChild(document.importNode(new Data(0, 0, 0).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataFimDetecaoConflitos.exportContentToXMLNode(), true));
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_FIM_ELEMENT_NAME);
            if (this.m_dataFim == null) {
                elemChild.appendChild(document.importNode(new Data(0, 0, 0).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataFim.exportContentToXMLNode(), true));
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_INICIO_CAND_DEMO_ELEMENT_NAME);
            if (this.m_dataInicioCandDemo == null) {
                elemChild.appendChild(document.importNode(new Data(0, 0, 0).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataInicioCandDemo.exportContentToXMLNode(), true));
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DATA_INICIO_ELEMENT_NAME);
            if (this.m_dataInicio == null) {
                elemChild.appendChild(document.importNode(new Data(0, 0, 0).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataInicio.exportContentToXMLNode(), true));
            }
            elementExpo.appendChild(elemChild);

            elemChild = document.createElement(DESCR_ELEMENT_NAME);
            elemChild.setTextContent(this.m_strDescricao);
            elementExpo.appendChild(elemChild);

            elementExpo.appendChild(document.importNode(this.m_ra.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_ras.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rce.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rconf.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rcr.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rd.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rexpositores.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rfae.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_ro.exportContentToXMLNode(), true));

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

}
