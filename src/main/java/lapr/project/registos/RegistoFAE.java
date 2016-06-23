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

    public static final String ROOT_ELEMENT_NAME = "registoFAEs";

    /**
     * Lista de fae
     */
    private final List<FAE> m_listaFAE;

    /**
     * Construtor de objetos do tipo RegistoFAE sem parâmetros
     */
    public RegistoFAE() {
        this.m_listaFAE = new ArrayList<>();
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

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     *
     * @param m_registoUtilizadores registo de utilizadores
     */
    public void fix(RegistoUtilizadores m_registoUtilizadores) {
        for (FAE fae : m_listaFAE) {
            for (Utilizador u : m_registoUtilizadores.getListaUtilizadores()) {
                if (fae.getUtilizador().getUsername().equals(u.getUsername())) {
                    fae.setUtilizador(u);
                    break;
                }
            }
        }
    }

    @Override
    public RegistoFAE importContentFromXMLNode(Node node) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        doc.appendChild(doc.importNode(node, true));

        Node n = doc.getChildNodes().item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_listaFAE.clear();
            NodeList nList = elem.getElementsByTagName(FAE.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);

                FAE fae = new FAE();
                fae.importContentFromXMLNode(n2);
                this.m_listaFAE.add(fae);
            }
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

            for (FAE fae : m_listaFAE) {
                elementBase.appendChild(document.importNode(fae.exportContentToXMLNode(), true));
            }

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoFAE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
