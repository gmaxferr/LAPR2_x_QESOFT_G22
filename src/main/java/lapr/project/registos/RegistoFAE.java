package lapr.project.registos;

import java.util.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author G29
 */
public class RegistoFAE implements Importable<RegistoFAE>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoFAE";

    public static final String LISTA_FAE_ELEMENT_NAME = "ListaFAE";

    private final List<FAE> m_listaFAE;
    private final List<FAE> m_listaFAETemp;
    private RegistoOrganizadores m_rOrganizadoresDestaExposicao;

    public RegistoFAE() {
        this.m_listaFAE = new ArrayList<>();
        this.m_listaFAETemp = new ArrayList<>();
        this.m_rOrganizadoresDestaExposicao = new RegistoOrganizadores();
    }

    public List<FAE> getListaFAE() {
        return this.m_listaFAE;
    }

    public boolean adicionaFAE(Utilizador u) {
        if (validaUtilizador(u)) {
            this.m_listaFAETemp.add(new FAE(u));
            return true;
        }
        return false;
    }

    private boolean validaUtilizador(Utilizador u) {
        for (FAE fae : m_listaFAETemp) {
            if (fae.getUsernameFae().equalsIgnoreCase(u.getUsername())) {
                return false;
            }
        }
        for (Organizador organizador : this.m_rOrganizadoresDestaExposicao.getListaOrganizadores()) {
            if (organizador.getUsernameOrganizador().equalsIgnoreCase(u.getUsername())) {
                return false;
            }
        }
        return true;
    }

    public void confirmaAddFAE() {
        this.m_listaFAE.clear();
        this.m_listaFAE.addAll(this.m_listaFAETemp);
        for (FAE fae : m_listaFAE) {
            fae.getUtilizador().setIsFAE();
        }
    }

    /**
     * Verifica se já existe um FAE com um determinado username
     *
     * @param usernameFAE - username do FAE a procurar
     * @return true se encontrar, false caso contrário
     */
    public boolean isFAE(String usernameFAE) {
        for (FAE fae : m_listaFAE) {
            if (fae.getUtilizador().getUsername().equalsIgnoreCase(usernameFAE)) {
                return true;
            }
        }
        return false;
    }

    public void setRegistoOrganizadoresParaValidacoes(RegistoOrganizadores ro) {
        this.m_rOrganizadoresDestaExposicao = ro;
    }

    /**
     * Retorn ao FAE que tem determinado username
     *
     * @param usernameFAE - usernmae do FAE
     * @return FAE com o username enviado como parametro. null caso não exista
     */
    public FAE getFAE(String usernameFAE) {
        for (FAE f : m_listaFAE) {
            if (f.getUsernameFae().equals(usernameFAE)) {
                return f;
            }
        }
        return null;
    }

    public List<Utilizador> getListaUtilizadoresCorrespondentesAosFae() {
        List<Utilizador> listaUtilizadores = new ArrayList<>();
        for (FAE fae : m_listaFAE) {
            listaUtilizadores.add(fae.getUtilizador());
        }
        return listaUtilizadores;
    }

    public void fix(RegistoUtilizadores m_registoUtilizadores, RegistoOrganizadores m_ro) {
        for (FAE fae : m_listaFAE) {
            for (Utilizador u : m_registoUtilizadores.getListaUtilizadores()) {
                if (fae.getUtilizador().getUsername().equals(u.getUsername())) {
                    fae.setUtilizador(u);
                    break;
                }
            }
        }
        for (FAE fae : m_listaFAETemp) {
            for (Utilizador u : m_registoUtilizadores.getListaUtilizadores()) {
                if (fae.getUtilizador().getUsername().equals(u.getUsername())) {
                    fae.setUtilizador(u);
                    break;
                }
            }
        }
        this.m_rOrganizadoresDestaExposicao.fix(m_ro);
    }

    @Override
    public RegistoFAE importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_rOrganizadoresDestaExposicao = new RegistoOrganizadores();
                this.m_rOrganizadoresDestaExposicao.importContentFromXMLNode(elem.getElementsByTagName(RegistoOrganizadores.ROOT_ELEMENT_NAME).item(0));

                this.m_listaFAE.clear();
                NodeList nList = elem.getElementsByTagName(LISTA_FAE_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    FAE fae = new FAE();
                    fae.importContentFromXMLNode(n2);
                    this.m_listaFAE.add(fae);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoFAE.class.getName()).log(Level.SEVERE, null, ex);
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

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementBase);

            Element elemChild = document.createElement(LISTA_FAE_ELEMENT_NAME);
            for (FAE fae : m_listaFAE) {
                elemChild.appendChild(document.importNode(fae.exportContentToXMLNode(), true));
            }
            elementBase.appendChild(elemChild);

            elementBase.appendChild(document.importNode(this.m_rOrganizadoresDestaExposicao.exportContentToXMLNode(), true));

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoFAE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
