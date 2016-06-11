/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCancelada;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasAbertas;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasAtribuidas;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasAvaliadas;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasDecididas;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasFechadas;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoConfirmada;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoPendente;
import lapr.project.registos.RegistoCandidaturaADemonstracoes;
import lapr.project.registos.RegistoOrganizadores;
import lapr.project.registos.RegistoRecursos;
import lapr.project.timerTasks.demonstracao.AlterarParaCandidaturasAbertas;
import lapr.project.timerTasks.demonstracao.AlterarParaCandidaturasFechadas;

import lapr.project.utils.Data;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class Demonstracao implements Agendavel, Importable<Demonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Demonstracao";
    public static final String DATA_INICIO_SUB_CAND_ELEMENT_NAME = "DataInicioSubmissaoCandidaturas";
    public static final String DATA_FIM_SUB_CAND_ELEMENT_NAME = "DataFimSubmissaoCandidaturas";
    public static final String DESCR_ELEMENT_NAME = "Descricao";
    public static final String ID_ATTR_NAME = "ID";
    public static final String ESTADO_ATTR_NAME = "estado";

    private Data m_dataInicioSubCand;
    private Data m_dataFimSubCand;

    private String m_StrDescricao;
    private String m_StrCodigoIdentificacao;
    private RegistoRecursos rc;
    private RegistoOrganizadores m_ro;
    private EstadoDemonstracao m_estado;
    private RegistoCandidaturaADemonstracoes m_rcd;

    public Demonstracao(String descricao) {
        this.rc = new RegistoRecursos();
        this.m_StrDescricao = descricao;
        this.m_rcd = new RegistoCandidaturaADemonstracoes();
        this.m_estado = new EstadoDemonstracaoPendente(this);
    }

    /**
     *
     * @return descrição da demonstração
     */
    public String getDescricao() {
        return this.m_StrDescricao;
    }

    /**
     * Permite alterar a descrição da demonstração
     *
     * @param descricaoIntroduzidaPeloUtilizador
     */
    public void getDescricao(String descricaoIntroduzidaPeloUtilizador) {
        this.m_StrDescricao = descricaoIntroduzidaPeloUtilizador;
    }

    /**
     *
     * @return registo dos recursos necessários à demonstração
     */
    public RegistoRecursos getRegistoRecursosNecessarios() {
        return this.rc;
    }

    /**
     *
     * @return código da demonstração
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
     *
     * @return data de inicio de submissão de candidaturas à demonstração
     */
    public Data getDataInicioCand() {
        return m_dataInicioSubCand;
    }

    /**
     *
     * @return data de fim de submissão de candidaturas à demonstração
     */
    public Data getDataFimCand() {
        return m_dataFimSubCand;
    }

    /**
     * @param m_StrCodigoIdentificacao the m_StrCodigoIdentificacao to set
     */
    public void setCodigoIdentificacao(String m_StrCodigoIdentificacao) {
        this.m_StrCodigoIdentificacao = m_StrCodigoIdentificacao;
    }

    /**
     *
     * @return - registo de candidaturas a demonstração
     */
    public RegistoCandidaturaADemonstracoes getRegistoCandidaturasADemonstracao() {
        return m_rcd;
    }

    /**
     * Define data de inicio de candidaturas à demonstração e cria timer
     *
     * @param dataInicioCandDemo - data de inicio de candidaturas à demonstração
     */
    void setDataInicioCandidaturas(Data dataInicioCandDemo) {
        m_dataInicioSubCand = dataInicioCandDemo;
        this.schedule(new AlterarParaCandidaturasAbertas(this), m_dataInicioSubCand);
    }

    /**
     * Define data de fim de candidaturas à demonstração e cria timer
     *
     * @param dataFimCandDemo - data de fim de candidaturas à demonstração
     */
    void setDataFimCandidaturas(Data dataFimCandDemo) {
        m_dataFimSubCand = dataFimCandDemo;
        this.schedule(new AlterarParaCandidaturasFechadas(this), m_dataFimSubCand);
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Demonstracao) {
            Demonstracao o = (Demonstracao) obj;
            if (o == this) {
                return true;
            }
            return this.m_StrCodigoIdentificacao == o.m_StrCodigoIdentificacao;
        }
        return false;
    }

    @Override
    public Demonstracao importContentFromXMLNode(Node node) {
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
                this.m_StrCodigoIdentificacao = elem.getAttribute(ID_ATTR_NAME);
                this.m_StrDescricao = elem.getElementsByTagName(DESCR_ELEMENT_NAME).item(0).getTextContent();
                this.rc = new RegistoRecursos();
                this.rc.importContentFromXMLNode(elem.getElementsByTagName(RegistoRecursos.ROOT_ELEMENT_NAME).item(0));
                this.m_rcd = new RegistoCandidaturaADemonstracoes();
                this.m_rcd.importContentFromXMLNode(elem.getElementsByTagName(RegistoCandidaturaADemonstracoes.ROOT_ELEMENT_NAME).item(0));

                Data invalidData = new Data(0, 0, 0);

                Element elem2 = (Element) elem.getElementsByTagName(DATA_INICIO_SUB_CAND_ELEMENT_NAME).item(0);
                this.m_dataInicioSubCand = new Data(0, 0, 0);
                this.m_dataInicioSubCand.importContentFromXMLNode(elem2.getElementsByTagName(Data.ROOT_ELEMENT_NAME).item(0));
                if (this.m_dataInicioSubCand.equals(invalidData)) {
                    this.m_dataInicioSubCand = null;
                }

                elem2 = (Element) elem.getElementsByTagName(DATA_FIM_SUB_CAND_ELEMENT_NAME).item(0);
                this.m_dataFimSubCand = new Data(0, 0, 0);
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
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elemBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elemBase);

            Element elemChild = document.createElement(DESCR_ELEMENT_NAME);
            elemChild.setTextContent(this.m_StrDescricao);
            elemBase.appendChild(elemChild);

            elemBase.appendChild(document.importNode(this.rc.exportContentToXMLNode(), true));
            elemBase.appendChild(document.importNode(this.m_rcd.exportContentToXMLNode(), true));

            elemBase.setAttribute(ID_ATTR_NAME, this.m_StrCodigoIdentificacao);

            elemChild = document.createElement(DATA_INICIO_SUB_CAND_ELEMENT_NAME);
            if (this.m_dataInicioSubCand == null) {
                elemChild.appendChild(document.importNode(new Data(0, 0, 0).exportContentToXMLNode(), true));
            } else {
                elemChild.appendChild(document.importNode(this.m_dataInicioSubCand.exportContentToXMLNode(), true));
            }
            elemBase.appendChild(elemChild);

            elemChild = document.createElement(DATA_FIM_SUB_CAND_ELEMENT_NAME);
            if (this.m_dataFimSubCand == null) {
                elemChild.appendChild(document.importNode(new Data(0, 0, 0).exportContentToXMLNode(), true));
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

    @Override
    public void schedule(TimerTask m_tt, Data date) {
        Timer timer = new Timer();
        timer.schedule(m_tt, date.toDate());
    }

    /**
     * @return Retorna a lista de organizadores.
     */
    public List<Organizador> getListaOrganizadores() {
        return this.m_ro.getListaOrganizadores();
    }

    /**
     * Define o estado
     *
     * @param estado EstadoDemonstracao
     */
    public void setEstado(EstadoDemonstracao estado) {
        this.m_estado = estado;
    }
}
