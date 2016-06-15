package lapr.project.registos;

import java.util.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um registo fae
 *
 * @author G29
 */
public class RegistoFAE implements Importable<RegistoFAE>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoFAE";

    public static final String LISTA_FAE_ELEMENT_NAME = "ListaFAE";

    /**
     * Lista de fae
     */
    private final List<FAE> m_listaFAE;

    /**
     * Registo de organizadores
     */
    private RegistoOrganizadores m_rOrganizadoresDestaExposicao;

    /**
     * Construtor de objetos do tipo RegistoFAE sem parâmetros
     */
    public RegistoFAE() {
        this.m_listaFAE = new ArrayList<>();
        this.m_rOrganizadoresDestaExposicao = new RegistoOrganizadores();
    }

    /**
     * Devolve a lista de fae
     *
     * @return lista de fae
     */
    public List<FAE> getListaFAE() {
        return this.m_listaFAE;
    }

    /**
     * Adiciona fae à lista de fae
     *
     * @param u utilizador a ser adicionado
     * @return true se o fae for adicionado. Caso contrário retorna false.
     */
    public boolean adicionaFAE(Utilizador u) {
        if (validaUtilizador(u)) {
            this.m_listaFAE.add(new FAE(u));
            u.setIsFAE();
            return true;
        }
        return false;
    }

    /**
     * Valida o utilizador
     *
     * @param u utilizador a ser validado
     * @return true caso o utilizador ainda não esteja na lista de fae ou de
     * organizador. Caso contrário retona false.
     */
    private boolean validaUtilizador(Utilizador u) {
        for (FAE fae : m_listaFAE) {
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

    /**
     * Adiciona novos FAE à lista já existente de FAE. Método chamado na
     * execução do UC02 - Definir FAE.
     *
     * @param listaNovosFAEParaAdicionar lista com novos FAE para adicionar
     */
    public void confirmaAddFAE(List<FAE> listaNovosFAEParaAdicionar) {
        for (FAE fae : listaNovosFAEParaAdicionar) {
            this.m_listaFAE.add(fae);
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

    /**
     * Devolve a lista de utilizadores correspondeste aos fae
     *
     * @return lista de utilizadores correspondeste aos fae
     */
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
                Node n2 = nList.item(0);

                if (n2.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem2 = (Element) n2;

                    NodeList nList2 = elem2.getElementsByTagName(FAE.ROOT_ELEMENT_NAME);
                    for (int i = 0; i < nList2.getLength(); i++) {
                        Node n3 = nList2.item(i);

                        FAE fae = new FAE();
                        fae.importContentFromXMLNode(n3);
                        this.m_listaFAE.add(fae);
                    }
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
