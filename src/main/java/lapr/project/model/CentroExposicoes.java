package lapr.project.model;

import java.util.List;
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

    public static final String ROOT_ELEMENT_NAME = "CentroExposicoes";

    /**
     *
     */
    private final RegistoExposicoes m_registoExposicoes;

    /**
     *
     */
    private final RegistoUtilizadores m_registoUtilizadores;

    /**
     *
     */
    private final RegistoMecanismos m_registoMecanismos;

    /**
     *
     */
    private final RegistoRecursos m_registoRecursos;

    private final RegistoTipoConflitos m_registoTipoConflitos;
    private final RegistoExpositores m_registoExpositores;

    private final RegistoStands m_rStands;

    /**
     * Construtor de objectos do tipo CentroExposicoes sem parametros
     */
    public CentroExposicoes() {
        this.m_registoExposicoes = new RegistoExposicoes(this);
        this.m_registoUtilizadores = new RegistoUtilizadores();

        this.m_registoMecanismos = new RegistoMecanismos();
        this.m_registoMecanismos.addMecanismo(new MecanismoPredefinidoA());
        this.m_registoMecanismos.addMecanismo(new MecanismoPredefinidoB());
        this.m_registoMecanismos.addMecanismo(new MecanismoPredefinidoC());

        this.m_registoRecursos = new RegistoRecursos();
        this.m_registoTipoConflitos = new RegistoTipoConflitos();
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
     * @return registo de utilizadores
     */
    public RegistoUtilizadores getRegistoUtilizadores() {
        return m_registoUtilizadores;
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

    /**
     * Devolve o registo dos stands existentes neste centro de exposições
     *
     * @return registo de stand deste centro de exposições
     */
    public RegistoStands getRegistoStands() {
        return this.m_rStands;
    }

    /**
     * Confirma o registo de um utilizador recebendo como parametro esse
     * utilizador
     *
     * @param u Utilizador desejado
     */
    public void setUtilizadorRegistado(Utilizador u) {
        u.setUtilizadorRegistado();

    }

    /**
     * Devolve um novo Utilizador
     *
     * @return novo utilizador
     */
    public Utilizador novoUtilizador() {
        return new Utilizador();
    }

    /**
     * Devolve o objecto Expositor identificado pelo seu username (passado por
     * parametro)
     *
     * @param m_StrUsername username do expositor
     * @return expositor com o username passado por parametro
     */
    public Expositor getExpositorPeloUsername(String m_StrUsername) {
        for (Expositor expositor : this.getRegistoExpositores().getListaExpositores()) {
            if (expositor.getUsername().equalsIgnoreCase(m_StrUsername)) {
                return expositor;
            }
        }
        return null;
    }

    /**
     * Devolve a lista de expositores
     *
     * @return lista de expositores
     */
    public List<Expositor> getListaExpositores() {
        return this.m_registoExpositores.getListaExpositores();
    }

    /**
     *
     * @param node
     * @return
     */
    @Override
    public CentroExposicoes importContentFromXMLNode(Node node) {
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

                this.m_registoUtilizadores.importContentFromXMLNode(elem.getElementsByTagName(RegistoUtilizadores.ROOT_ELEMENT_NAME).item(0));

                this.m_registoExpositores.importContentFromXMLNode(elem.getElementsByTagName(RegistoExpositores.ROOT_ELEMENT_NAME).item(0));
                this.m_registoExpositores.fix(this.m_registoUtilizadores);

                this.m_registoTipoConflitos.importContentFromXMLNode(elem.getElementsByTagName(RegistoTipoConflitos.ROOT_ELEMENT_NAME).item(0));
                this.m_registoRecursos.importContentFromXMLNode(elem.getElementsByTagName(RegistoRecursos.ROOT_ELEMENT_NAME).item(0));

                this.m_registoExposicoes.importContentFromXMLNode(elem.getElementsByTagName(RegistoExposicoes.ROOT_ELEMENT_NAME).item(0));
                this.m_registoExposicoes.fix(this.m_registoRecursos, this.m_registoTipoConflitos, this.m_registoUtilizadores);
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
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elementExpo = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementExpo);

            elementExpo.appendChild(document.importNode(this.m_registoExpositores.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_registoExposicoes.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_registoRecursos.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_registoTipoConflitos.exportContentToXMLNode(), true));
            elementExpo.appendChild(document.importNode(this.m_registoUtilizadores.exportContentToXMLNode(), true));

            node = elementExpo;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CentroExposicoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
