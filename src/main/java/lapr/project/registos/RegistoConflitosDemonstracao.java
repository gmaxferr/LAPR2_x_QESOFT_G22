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
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.ConflitoDeInteresse;
import lapr.project.model.ConflitoDeInteresseDemonstracao;
import lapr.project.model.FAE;
import lapr.project.model.TipoConflitoDemonstracao;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class RegistoConflitosDemonstracao implements Importable<RegistoConflitosDemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoConflitosDemonstracao";

    /**
     * Lista de conflitos de interesse
     */
    private final List<ConflitoDeInteresseDemonstracao> m_listaConflitos;

    /**
     * Construtor de objetos do tipo RegistoConflitos sem parâmetros
     */
    public RegistoConflitosDemonstracao() {
        this.m_listaConflitos = new ArrayList<>();
    }

    /**
     * Cria um conflito entre o FAE e a Candidatura passados como argumentos e
     * regista esse conflito.
     *
     * @param fae - FAE que conflite com uma Candidatura
     * @param cand - Candidatura com que o FAE conflite
     */
    public void criarConflito(FAE fae, CandidaturaADemonstracao cand, TipoConflitoDemonstracao tipoConflito) {
        ConflitoDeInteresseDemonstracao c = new ConflitoDeInteresseDemonstracao(fae, cand, tipoConflito);
        adiciona(c);
    }

    /**
     * Verifica se um conflito é válido, verificando se este já existe ou não.
     *
     * @param fae - FAE em conflito
     * @param cand - Candidatura em conflito
     * @return true se for válido; false caso contrário.
     */
    public boolean valida(FAE fae, CandidaturaADemonstracao cand, TipoConflitoDemonstracao tipo) {
        boolean valido = true;
        for (ConflitoDeInteresseDemonstracao c : m_listaConflitos) {
            if (c.getFae().equals(fae) && c.getCandidatura().equals(cand) && c.getTipo().equals(tipo)) {
                valido = false;
            }
        }
        return valido;
    }

    /**
     * Devolve a lisat de conflitos de interesse
     *
     * @return a lista de conflitos
     */
    public List<ConflitoDeInteresseDemonstracao> getListaConflitos() {
        return m_listaConflitos;
    }

    /**
     * Remove um conflito da lista de conflitos de interesse
     *
     * @param c - Conflito a remover
     */
    public void remove(ConflitoDeInteresseDemonstracao c) {
        m_listaConflitos.remove(c);
    }

    /**
     * Adiciona um conflito da lista de conflitos de interesse
     *
     * @param c - Conflito a remover
     */
    public void adiciona(ConflitoDeInteresseDemonstracao c) {
        m_listaConflitos.add(c);
    }
    
    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     * 
     * @param rc registo de candidaturas a exposição
     */
    public void fix(RegistoCandidaturasAExposicao rc){
        for(ConflitoDeInteresseDemonstracao conf : m_listaConflitos){
            conf.fix(rc);
        }
    }

    @Override
    public RegistoConflitosDemonstracao importContentFromXMLNode(Node node) {
        try {
            Document doc = XMLParser.createDocument(node, true);

            Node n = doc.getChildNodes().item(0);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_listaConflitos.clear();
                
                NodeList nList = elem.getElementsByTagName(ConflitoDeInteresse.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    ConflitoDeInteresseDemonstracao conflito = new ConflitoDeInteresseDemonstracao(null, null, null);
                    conflito.importContentFromXMLNode(n2);
                    m_listaConflitos.add(conflito);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoConflitosDemonstracao.class.getName()).log(Level.SEVERE, null, ex);
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

            for (ConflitoDeInteresseDemonstracao conf : m_listaConflitos) {
                Node n = conf.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoConflitosDemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
