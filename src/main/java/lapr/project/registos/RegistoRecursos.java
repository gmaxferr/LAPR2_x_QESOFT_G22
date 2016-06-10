/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Recurso;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ana Leite
 */
public class RegistoRecursos implements Importable<RegistoRecursos>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoRecursos";

    private List<Recurso> m_listaRecursosNecessarios;

    /**
     *
     */
    public RegistoRecursos() {
        this.m_listaRecursosNecessarios = new ArrayList<>();
    }

    /**
     * Método que cria um recurso
     *
     * @param nome nome do recurso a ser criadp
     * @return novo recurso
     */
    public Recurso criarRecurso(String nome) {
        if (validarRecurso() == true) {
            Recurso recurso = new Recurso(nome);
            recurso.setNomeRecurso(nome);
            return recurso;
        }
        return null;
    }

    /**
     * Valida o nome do recurso
     *
     * @return
     */
    private boolean validarRecurso() {
        return true;
    }

    public List<Recurso> getListaDeRecursos() {
        return this.m_listaRecursosNecessarios;
    }

    public void addRecurso(Recurso rec) {
        if (valida() == true) {
            this.m_listaRecursosNecessarios.add(rec);
        } else {
            //avisa o utilizador para o facto de o recurso não ser válido
        }
    }

    public boolean valida() {
        //validação global
        return true;
    }

    /**
     * @param listaRecursosNecessarios
     */
    public void setListaRecursosNecessarios(List<Recurso> listaRecursosNecessarios) {
        this.m_listaRecursosNecessarios = listaRecursosNecessarios;
    }

    @Override
    public RegistoRecursos importContentFromXMLNode(Node node) {
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
}
