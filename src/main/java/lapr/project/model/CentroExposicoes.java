package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.registos.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um Centro de Exposições
 *
 * @author Ricardo Osório Ana Leite
 */
public class CentroExposicoes implements Importable<CentroExposicoes>, Exportable {

    public static final String PROPERTIES_FILE_LOCATION = "lapr2.g29.user.properties";
    public static final String ROOT_ELEMENT_NAME = "centroExposicoes";

    /**
     * Registo de Exposições
     */
    private RegistoExposicoes m_registoExposicoes;

    /**
     * Registo de Utilizadores (pendentes)
     */
    private RegistoUtilizadores m_registoUtilizadoresPendentes;

    /**
     * registo de Utilizadores (confirmados)
     */
    private RegistoUtilizadores m_registoUtilizadoresConfirmados;

    /**
     * Registo de Mecanismos
     */
    private RegistoMecanismos m_registoMecanismos;

    /**
     * Registo de recursos
     */
    private RegistoRecursos m_registoRecursos;

    /**
     * Registo de Tipos de Conflito
     */
    private RegistoTipoConflitos m_registoTipoConflitos;

    /**
     * Registo de tipos de conflito da demonstração
     */
    private RegistoTiposConflitoDemonstracao m_registoTipoConflitosDemonstracao;

    /**
     * Registo de Expositores
     */
    private RegistoExpositores m_registoExpositores;

    /**
     * Registo de Stands
     */
    private RegistoStands m_rStands;

    /**
     * Construtor de objectos do tipo CentroExposicoes sem parametros
     */
    public CentroExposicoes() {
        this.m_registoExposicoes = new RegistoExposicoes(this);
        this.m_registoUtilizadoresPendentes = new RegistoUtilizadores("NaoConfirmados");
        this.m_registoUtilizadoresConfirmados = new RegistoUtilizadores("Confirmados");

        this.m_registoMecanismos = new RegistoMecanismos();
        this.m_registoMecanismos.addMecanismo(new MecanismoPredefinidoA());
        this.m_registoMecanismos.addMecanismo(new MecanismoPredefinidoB());
        this.m_registoMecanismos.addMecanismo(new MecanismoPredefinidoC());

        this.m_registoRecursos = new RegistoRecursos();
        this.m_registoTipoConflitos = new RegistoTipoConflitos();
        this.m_registoTipoConflitosDemonstracao = new RegistoTiposConflitoDemonstracao();
        this.m_registoExpositores = new RegistoExpositores();
        this.m_rStands = new RegistoStands();
    }

    /**
     * Devolve o registo de exposições deste centro de exposições
     *
     * @return registo de exposições
     */
    public RegistoExposicoes getRegistoExposicoes() {
        return m_registoExposicoes;
    }

    /**
     * Devolve o registo de expositores deste centro de exposições
     *
     * @return registo de expositores
     */
    public RegistoExpositores getRegistoExpositores() {
        return this.m_registoExpositores;
    }

    /**
     * Devolve o registo de utilizadores deste centro de exposições
     *
     * @return registo de utilizadores pendentes
     */
    public RegistoUtilizadores getRegistoUtilizadoresPendentes() {
        return m_registoUtilizadoresPendentes;
    }

    /**
     * Devolve o registo de utilizadores deste centro de exposições
     *
     * @return registo de utilizadores confirmados
     */
    public RegistoUtilizadores getRegistoUtilizadoresConfirmados() {
        return m_registoUtilizadoresConfirmados;
    }

    /**
     * Devolve o registo de mecanismos deste centro de exposições
     *
     * @return registo de mecanismos
     */
    public RegistoMecanismos getRegistoMecanismos() {
        return m_registoMecanismos;
    }

    /**
     * Devolve o registo de recursos deste centro de exposições
     *
     * @return registo de recursos
     */
    public RegistoRecursos getRegistoRecursos() {
        return m_registoRecursos;
    }

    /**
     * Devolve o registo de tipos de conflitos deste centro de exposições
     *
     * @return registo de tipos de conflitos
     */
    public RegistoTipoConflitos getRegistoTiposConflitos() {
        return m_registoTipoConflitos;
    }

    public RegistoTiposConflitoDemonstracao getRegistoTiposConflitosDemonstracao() {
        return m_registoTipoConflitosDemonstracao;
    }

    /**
     * Devolve o registo dos stands existentes neste centro de exposições
     *
     * @return registo de stand deste centro de exposições
     */
    public RegistoStands getRegistoStands() {
        return this.m_rStands;
    }

    public boolean isFae(Utilizador utilizador) {
        for (Exposicao e : m_registoExposicoes.getListaExposicoes()) {
            if (e.getRegistoFAE().isFAE(utilizador.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean isExpositor(Utilizador utilizador) {
        for (Exposicao e : m_registoExposicoes.getListaExposicoes()) {
            for (CandidaturaAExposicao cand : e.getRegistoCandidaturasAExposicao().getListaCandidaturas()) {
                if (cand.getExpositor().getUsername().equals(utilizador.getUsername())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOrganizador(Utilizador utilizador) {
        for (Exposicao e : m_registoExposicoes.getListaExposicoes()) {
            for (Organizador o : e.getRegistoOrganizadores().getListaOrganizadores()) {
                if (o.getUsernameOrganizador().equals(utilizador.getUsername())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Confirma o registo de todos os utilizadores registados no centro de
     * exposições atual. Este método é usado apenas na primeira execução do
     * programa.
     */
    public void confirmarRegistoTodosUtilizadores() {
        for (int i = 0; i < this.m_registoUtilizadoresPendentes.getListaUtilizadores().size(); i++) {
            Utilizador utilizador = this.m_registoUtilizadoresPendentes.getListaUtilizadores().get(i);
            this.m_registoUtilizadoresPendentes.getListaUtilizadores().remove(utilizador);
            this.m_registoUtilizadoresConfirmados.getListaUtilizadores().add(utilizador);
        }
    }

    /**
     *
     * @param node
     * @return
     */
    @Override
    public CentroExposicoes importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

            NodeList elementsKeyword = document.getChildNodes();
            Node n = elementsKeyword.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_registoUtilizadoresPendentes.importContentFromXMLNode(
                        elem.getElementsByTagName(RegistoUtilizadores.ROOT_ELEMENT_NAME + m_registoUtilizadoresPendentes.TAG_SUFFIX).item(0));
                this.m_registoUtilizadoresConfirmados.importContentFromXMLNode(
                        elem.getElementsByTagName(RegistoUtilizadores.ROOT_ELEMENT_NAME + m_registoUtilizadoresConfirmados.TAG_SUFFIX).item(0));

                this.m_rStands.importContentFromXMLNode(elem.getElementsByTagName(RegistoStands.ROOT_ELEMENT_NAME).item(0));

                this.m_registoExposicoes.importContentFromXMLNode(elem.getElementsByTagName(RegistoExposicoes.ROOT_ELEMENT_NAME).item(0));
                this.m_registoExposicoes.fix(this.m_registoRecursos, this.m_registoTipoConflitos, this.m_registoUtilizadoresConfirmados);

                this.m_registoExpositores.importContentFromXMLNode(elem.getElementsByTagName(RegistoExpositores.ROOT_ELEMENT_NAME).item(0));
                this.m_registoExpositores.fix(this.m_registoUtilizadoresPendentes);

                this.m_registoTipoConflitos.importContentFromXMLNode(elem.getElementsByTagName(RegistoTipoConflitos.ROOT_ELEMENT_NAME).item(0));
                this.m_registoRecursos.importContentFromXMLNode(elem.getElementsByTagName(RegistoRecursos.ROOT_ELEMENT_NAME).item(0));
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CentroExposicoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    /**
     *
     * @return
     */
    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementExpo = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementExpo);

            elementExpo.appendChild(document.importNode(this.m_registoExpositores.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_registoExposicoes.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_registoRecursos.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_registoTipoConflitos.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_registoUtilizadoresPendentes.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_rStands.exportContentToXMLNode(), true));

            node = elementExpo;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CentroExposicoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

    /**
     *      * PARA TESTES APENAS
     *
     * @param m_registoExposicoes the m_registoExposicoes to set
     * @deprecated
     */
    public void setRegistoExposicoes(RegistoExposicoes m_registoExposicoes) {
        this.m_registoExposicoes = m_registoExposicoes;
    }

    /**
     *      * PARA TESTES APENAS
     *
     * @param m_registoUtilizadores the m_registoUtilizadores to set
     * @deprecated
     */
    public void setRegistoUtilizadoresPendentes(RegistoUtilizadores m_registoUtilizadores) {
        this.m_registoUtilizadoresPendentes = m_registoUtilizadores;
    }

    /**
     *      * PARA TESTES APENAS
     *
     * @param m_registoMecanismos the m_registoMecanismos to set
     * @deprecated
     */
    public void setRegistoMecanismos(RegistoMecanismos m_registoMecanismos) {
        this.m_registoMecanismos = m_registoMecanismos;
    }

    /**
     *      * PARA TESTES APENAS
     *
     * @param m_registoRecursos the m_registoRecursos to set
     * @deprecated
     */
    public void setRegistoRecursos(RegistoRecursos m_registoRecursos) {
        this.m_registoRecursos = m_registoRecursos;
    }

    /**
     *      * PARA TESTES APENAS
     *
     * @param m_registoTipoConflitos the m_registoTipoConflitos to set
     * @deprecated
     */
    public void setRegistoTipoConflitos(RegistoTipoConflitos m_registoTipoConflitos) {
        this.m_registoTipoConflitos = m_registoTipoConflitos;
    }

    /**
     *      * PARA TESTES APENAS
     *
     * @param m_registoExpositores the m_registoExpositores to set
     * @deprecated
     */
    public void setRegistoExpositores(RegistoExpositores m_registoExpositores) {
        this.m_registoExpositores = m_registoExpositores;
    }

    /**
     * PARA TESTES APENAS
     *
     * @param m_rStands the m_rStands to set
     * @deprecated
     */
    public void setRegistoStands(RegistoStands m_rStands) {
        this.m_rStands = m_rStands;
    }

}
