package lapr.project.model;

import java.util.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.estados.Demonstracao.*;
import lapr.project.registos.*;
import lapr.project.timerTasks.demonstracao.*;

import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de uma demonstração
 *
 * @author G29
 */
public class Demonstracao implements Agendavel, Importable<Demonstracao>, Exportable {

    /**
     *
     */
    public static final String ROOT_ELEMENT_NAME = "Demonstracao";

    /**
     *
     */
    public static final String DATA_INICIO_SUB_CAND_ELEMENT_NAME = "DataInicioSubmissaoCandidaturas";

    /**
     *
     */
    public static final String DATA_FIM_SUB_CAND_ELEMENT_NAME = "DataFimSubmissaoCandidaturas";

    /**
     *
     */
    public static final String DESCR_ELEMENT_NAME = "Descricao";

    /**
     *
     */
    public static final String ID_ATTR_NAME = "ID";

    /**
     *
     */
    public static final String ESTADO_ATTR_NAME = "estado";

    /**
     *
     */
    private Data m_dataInicioSubCand;

    /**
     *
     */
    private Data m_dataFimSubCand;

    /**
     *
     */
    private Data m_dataFimDetecaoConflitos;

    /**
     *
     */
    private String m_StrDescricao;

    /**
     *
     */
    private String m_StrCodigoIdentificacao;

    /**
     *
     */
    private Exposicao m_expo;

    /**
     *
     */
    private RegistoRecursos rc;

    /**
     *
     */
    private EstadoDemonstracao m_estado;

    /**
     *
     */
    private RegistoCandidaturaADemonstracoes m_rcd;

    /**
     *
     */
    private RegistoConflitosDemonstracao m_rconfDemo;

    /**
     * Registo de candidaturas a demonstracao removidas
     */
    private RegistoCandidaturasADemonstracaoRemovidas m_rcdr;

    public Demonstracao() {
        this.rc = new RegistoRecursos();
        this.m_expo = null;
        this.m_rcd = new RegistoCandidaturaADemonstracoes();
        this.m_rcdr = new RegistoCandidaturasADemonstracaoRemovidas();
        this.m_estado = new EstadoDemonstracaoPendente(this);
        this.m_rconfDemo = new RegistoConflitosDemonstracao();
    }

    /**
     *
     * @param descricao
     */
    public Demonstracao(String descricao) {
        this();
        this.m_expo = null;
        this.m_StrDescricao = descricao;
    }
    
    /**
     *
     * @param descricao
     */
    public Demonstracao(String descricao, Exposicao e) {
        this();
        this.m_expo = e;
        this.m_StrDescricao = descricao;
    }

    /**
     * Define uma nova descrição para a exposição. Recebe a nova descrição por
     * parametro
     *
     * @param descricao nova descrição
     */
    public void setDescricao(String descricao) {
        this.m_StrDescricao = descricao;
    }

    /**
     * Devolve a descrição da demonstração
     *
     * @return descrição da demonstração
     */
    public String getDescricao() {
        return this.m_StrDescricao;
    }

    /**
     * Devolve a exposição em que a demonstração vai ocorrer
     *
     * @return - exposição
     */
    public Exposicao getExpo() {
        return m_expo;
    }

    /**
     * Define a exposição desta Demonstração
     *
     * @param exposicao exposição
     */
    public void setExpo(Exposicao exposicao) {
        this.m_expo = exposicao;
    }

    /**
     * Devolve o registo dos recursos necessários à demonstração
     *
     * @return registo dos recursos necessários à demonstração
     */
    public RegistoRecursos getRegistoRecursosNecessarios() {
        return this.rc;
    }

    /**
     * Devolve o registo de conflitos da demonstração
     *
     * @return registo de conflitos da demonstração
     */
    public RegistoConflitosDemonstracao getRegistoConflitosDemonstracao() {
        return this.m_rconfDemo;
    }

    /**
     * Devolve o código de identificação da demonstração
     *
     * @return código de identificação da demonstração
     */
    public String getCodigoIdentificacao() {
        return this.m_StrCodigoIdentificacao;
    }

    /**
     * Permite obter o estado atual da demonstração
     *
     * @return estado atual da demonstração
     */
    public EstadoDemonstracao getEstadoDemo() {
        return m_estado;
    }

    /**
     * Devolve a data de inicio de submissão de candidaturas à demonstração
     *
     * @return data de inicio de submissão de candidaturas à demonstração
     */
    public Data getDataInicioCand() {
        return m_dataInicioSubCand;
    }

    /**
     * Devolve a data de fim de submissão de candidaturas à demonstração
     *
     * @return data de fim de submissão de candidaturas à demonstração
     */
    public Data getDataFimCand() {
        return m_dataFimSubCand;
    }

    /**
     * Permite alterar o código de identificação da demonstração
     *
     * @param m_StrCodigoIdentificacao novo código de identificação
     */
    public void setCodigoIdentificacao(String m_StrCodigoIdentificacao) {
        this.m_StrCodigoIdentificacao = m_StrCodigoIdentificacao;
    }

    /**
     * Devolve o registo de candidaturas à demonstração
     *
     * @return registo de candidaturas à demonstração
     */
    public RegistoCandidaturaADemonstracoes getRegistoCandidaturasADemonstracao() {
        return m_rcd;
    }

    /**
     * Devolve o registo de candidaturas a demonstração removidas
     *
     * @return registo de candidaturas a demonstração removidas
     */
    public RegistoCandidaturasADemonstracaoRemovidas getRegistoCandidaturasADemonstracaoRemovidas() {
        return m_rcdr;

    }

    void setDataFimDetecaoConflitos(Data dataFimDetecaoConflitos) {
        if (dataFimDetecaoConflitos != null) {
            m_dataFimDetecaoConflitos = dataFimDetecaoConflitos;
            this.schedule(new AlterarParaConflitosDetetados(this), m_dataFimDetecaoConflitos);
        }
    }

    /**
     * Define uma data de inicio de candidaturas à demonstração e cria timer
     *
     * @param dataInicioCandDemo - data de inicio de candidaturas à demonstração
     */
    void setDataInicioCandidaturas(Data dataInicioCandDemo) {
        if (dataInicioCandDemo != null) {
            m_dataInicioSubCand = dataInicioCandDemo;
            this.schedule(new AlterarParaCandidaturasAbertas(this), m_dataInicioSubCand);
        }
    }

    /**
     * Define uma data de fim de candidaturas à demonstração e cria timer
     *
     * @param dataFimCandDemo - data de fim de candidaturas à demonstração
     */
    void setDataFimCandidaturas(Data dataFimCandDemo) {
        if (dataFimCandDemo != null) {
            m_dataFimSubCand = dataFimCandDemo;
            this.schedule(new AlterarParaCandidaturasFechadas(this), m_dataFimSubCand);
        }
    }

    /**
     * Devolve uma lista das candidaturas do expositor à demonstração
     *
     * @param m_emailExpositor - email do expositor
     * @return lista das candidaturas do expositor à demonstração
     */
    public List<CandidaturaADemonstracao> getCandidaturasDemoExpositor(String m_emailExpositor) {
        RegistoCandidaturaADemonstracoes rcd = this.getRegistoCandidaturasADemonstracao();
        return rcd.getListaCandidaturasADemonstracaoRep(m_emailExpositor);

    }

    /**
     * Permite comparar esta demonstração a outro objecto passado por parametro.
     * Duas demonstrações são comparadas recorrendo ao código de identificação
     * apenas. Duas demonstrações são consideradas iguais quando os seus códigos
     * de identificação são iguais.
     *
     * @param obj objecto a comparar a esta demonstração
     * @return true se esta demonstração for igual à passada por parametro,
     * false todos os restantes casos.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Demonstracao) {
            Demonstracao o = (Demonstracao) obj;
            if (o == this) {
                return true;
            }
            return this.m_StrCodigoIdentificacao == null ? o.m_StrCodigoIdentificacao == null : this.m_StrCodigoIdentificacao.equals(o.m_StrCodigoIdentificacao);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.m_dataInicioSubCand);
        hash = 37 * hash + Objects.hashCode(this.m_dataFimSubCand);
        hash = 37 * hash + Objects.hashCode(this.m_dataFimDetecaoConflitos);
        hash = 37 * hash + Objects.hashCode(this.m_StrDescricao);
        hash = 37 * hash + Objects.hashCode(this.m_StrCodigoIdentificacao);
        return hash;
    }

    public void fix(RegistoCandidaturasAExposicao rCand, Exposicao e) {
        this.m_rconfDemo.fix(rCand);
        this.m_expo = e;
    }

    @Override
    public Demonstracao importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

            NodeList elementsKeyword = document.getChildNodes();

            Node n = elementsKeyword.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.m_StrCodigoIdentificacao = elem.getAttribute(ID_ATTR_NAME);
                this.m_StrDescricao = elem.getElementsByTagName(DESCR_ELEMENT_NAME).item(0).getTextContent();
                this.rc = new RegistoRecursos();
                this.rc.importContentFromXMLNode(elem.getElementsByTagName(RegistoRecursos.ROOT_ELEMENT_NAME).item(0));
                this.m_rcd = new RegistoCandidaturaADemonstracoes();
                this.m_rcd.importContentFromXMLNode(elem.getElementsByTagName(RegistoCandidaturaADemonstracoes.ROOT_ELEMENT_NAME).item(0));
                this.m_rcdr = new RegistoCandidaturasADemonstracaoRemovidas();
                this.m_rcdr.importContentFromXMLNode(elem.getElementsByTagName(RegistoCandidaturasADemonstracaoRemovidas.ROOT_ELEMENT_NAME).item(0));
                this.m_rconfDemo = new RegistoConflitosDemonstracao();
                this.m_rconfDemo.importContentFromXMLNode(elem.getElementsByTagName(RegistoConflitosDemonstracao.ROOT_ELEMENT_NAME).item(0));

                Data invalidData = new Data(1, 1, 1);

                Element elem2 = (Element) elem.getElementsByTagName(DATA_INICIO_SUB_CAND_ELEMENT_NAME).item(0);
                this.m_dataInicioSubCand = new Data(1, 1, 1);
                this.m_dataInicioSubCand.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataInicioSubCand.equals(invalidData)) {
                    this.m_dataInicioSubCand = null;
                }

                elem2 = (Element) elem.getElementsByTagName(DATA_FIM_SUB_CAND_ELEMENT_NAME).item(0);
                this.m_dataFimSubCand = new Data(1, 1, 1);
                this.m_dataFimSubCand.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataFimSubCand.equals(invalidData)) {
                    this.m_dataFimSubCand = null;
                }

                String estado = elem.getAttribute(ESTADO_ATTR_NAME);

                switch (estado) {
                    case "pendente":
                        this.m_estado = new EstadoDemonstracaoPendente(this);
                        break;
                    case "cancelada":
                        this.m_estado = new EstadoDemonstracaoCancelada(this);
                        break;
                    case "confirmada":
                        this.m_estado = new EstadoDemonstracaoConfirmada(this);
                        break;
                    case "candidaturasAbertas":
                        this.m_estado = new EstadoDemonstracaoCandidaturasAbertas(this);
                        break;
                    case "candidaturasFechadas":
                        this.m_estado = new EstadoDemonstracaoCandidaturasFechadas(this);
                        break;
                    case "candidaturasAtribuidas":
                        this.m_estado = new EstadoDemonstracaoCandidaturasAtribuidas(this);
                        break;
                    case "candidaturasAvaliadas":
                        this.m_estado = new EstadoDemonstracaoCandidaturasAvaliadas(this);
                        break;
                    case "candidaturasDecididas":
                        this.m_estado = new EstadoDemonstracaoCandidaturasDecididas(this);
                        break;
                    default:
                        break;
                }

            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Demonstracao.class.getName()).log(Level.SEVERE, null, ex);
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

            Element elemChild = document.createElement(DESCR_ELEMENT_NAME);
            elemChild.setTextContent(this.m_StrDescricao);
            elemBase.appendChild(elemChild);

            elemBase.appendChild(document.importNode(this.rc.exportContentToXMLNode(), true));
            elemBase.appendChild(document.importNode(this.m_rcd.exportContentToXMLNode(), true));
            elemBase.appendChild(document.importNode(this.m_rcdr.exportContentToXMLNode(), true));
            elemBase.appendChild(document.importNode(this.m_rconfDemo.exportContentToXMLNode(), true));

            elemBase.setAttribute(ID_ATTR_NAME, this.m_StrCodigoIdentificacao);

            elemChild = document.createElement(DATA_INICIO_SUB_CAND_ELEMENT_NAME);
            if (this.m_dataInicioSubCand == null) {
                elemChild.appendChild(document.importNode(new Data(1, 1, 1).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataInicioSubCand.exportContentToXMLNode(), true));
            }
            elemBase.appendChild(elemChild);

            elemChild = document.createElement(DATA_FIM_SUB_CAND_ELEMENT_NAME);
            if (this.m_dataFimSubCand == null) {
                elemChild.appendChild(document.importNode(new Data(1, 1, 1).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataFimSubCand.exportContentToXMLNode(), true));
            }
            elemBase.appendChild(elemChild);

            if (this.m_estado.isEstadoDemonstracaoPendente()) {
                elemBase.setAttribute(ESTADO_ATTR_NAME, "pendente");
            } else if (this.m_estado.isEstadoDemonstracaoCancelada()) {
                elemBase.setAttribute(ESTADO_ATTR_NAME, "cancelada");
            } else if (this.m_estado.isEstadoDemonstracaoConfirmada()) {
                elemBase.setAttribute(ESTADO_ATTR_NAME, "confirmada");
            } else if (this.m_estado.isEstadoDemonstracaoCandidaturasAbertas()) {
                elemBase.setAttribute(ESTADO_ATTR_NAME, "candidaturasAbertas");
            } else if (this.m_estado.isEstadoDemonstracaoCandidaturasFechadas()) {
                elemBase.setAttribute(ESTADO_ATTR_NAME, "candidaturasFechadas");
            } else if (this.m_estado.isEstadoDemonstracaoCandidaturasAtribuidas()) {
                elemBase.setAttribute(ESTADO_ATTR_NAME, "candidaturasAtribuidas");
            } else if (this.m_estado.isEstadoDemonstracaoCandidaturasAvaliadas()) {
                elemBase.setAttribute(ESTADO_ATTR_NAME, "candidaturasAvaliadas");
            } else if (this.m_estado.isEstadoDemonstracaoCandidaturasDecididas()) {
                elemBase.setAttribute(ESTADO_ATTR_NAME, "candidaturasDecididas");
            }

            node = elemBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Demonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;

    }

    /**
     *
     * @param m_tt
     * @param date
     */
    @Override
    public void schedule(TimerTask m_tt, Data date) {
        Timer timer = new Timer();
        timer.schedule(m_tt, date.toDate());
    }

    /**
     * Define um novo estado para a demonstração. Recebe o novo estado por
     * parametro.
     *
     * @param estado novo estado da demonstração
     */
    public void setEstado(EstadoDemonstracao estado) {
        this.m_estado = estado;
    }

    Data getDataFimDetecaoConflitos() {
        return m_dataFimDetecaoConflitos;
    }
}
