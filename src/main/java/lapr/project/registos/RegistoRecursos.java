package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.Recurso;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoRecursos
 * 
 * @author G29
 */
public class RegistoRecursos implements Importable<RegistoRecursos>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoRecursos";

    /**
     * Lista de recursos necessários
     */
    private List<Recurso> m_listaRecursosNecessarios;

    /**
     * Contrutor de objetos do tipo RegistoRecursos sem parâmetros
     */
    public RegistoRecursos() {
        this.m_listaRecursosNecessarios = new ArrayList<>();
    }

    /**
     * Cria um recurso
     *
     * @param nomeRecurso nome do recurso a ser criado
     */
    public boolean criarRecurso(String nomeRecurso) {
        boolean valido = false;
        if (validarRecurso(nomeRecurso)) {
            Recurso rec = new Recurso(nomeRecurso);
            rec.setNomeRecurso(nomeRecurso);
            adiciona(rec);
            valido = true;
        }
        return valido;
    }

    /**
     * Valida o nome do recurso, verificando se já existe algum com esse nome ou
     * não.
     *
     * @return true se for válido; false caso contrário
     */
    private boolean validarRecurso(String nomeRec) {
        boolean valido = true;
        for (Recurso rec : m_listaRecursosNecessarios) {
            if (rec.getNomeRecurso().equals(nomeRec.trim())) {
                valido = false;
            }
        }
        return valido && !nomeRec.isEmpty();
    }

    /**
     * Devolve a lista de recursos necessários
     * 
     * @return lista de recursos necessários
     */
    public List<Recurso> getListaDeRecursos() {
        return this.m_listaRecursosNecessarios;
    }

    /**
     * Adiciona a lista de recursos necessários
     * 
     * @param listaRecursosNecessarios lista de recursos necessários
     */
    public void setListaRecursosNecessarios(List<Recurso> listaRecursosNecessarios) {
        this.m_listaRecursosNecessarios.addAll(listaRecursosNecessarios);
    }

    @Override
    public RegistoRecursos importContentFromXMLNode(Node node) {
        if(node == null){
            return this;
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_listaRecursosNecessarios.clear();

                NodeList nList = elem.getElementsByTagName(Recurso.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    Recurso rec = new Recurso("");
                    rec.importContentFromXMLNode(n2);
                    m_listaRecursosNecessarios.add(rec);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoRecursos.class.getName()).log(Level.SEVERE, null, ex);
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

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementKeyword);

            for (Recurso r : m_listaRecursosNecessarios) {
                Node n = r.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

    /**
     * Adiciona um recurso à lista dos mesmos
     * @param rec - recurso a adicionar
     */
    private void adiciona(Recurso rec) {
        this.m_listaRecursosNecessarios.add(rec);
    }
}
