/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.EstadoDemonstracao;
import lapr.project.registos.RegistoCandidaturaADemonstracoes;
import lapr.project.registos.RegistoRecursos;
<<<<<<< HEAD
import lapr.project.utils.Data;
=======
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
>>>>>>> 067302e6bc987c1b1b1590cac67590c0dcb6d5a8

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class Demonstracao implements Importable<Demonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Demonstracao";
    public static final String DESCR_ELEMENT_NAME = "Descricao";
    public static final String ID_ATTR_NAME = "ID";
    public static final String ESTADO_ATTR_NAME = "estado";

    private String m_StrDescricao;
    private String m_StrCodigoIdentificacao;
    private RegistoRecursos rc;
    private EstadoDemonstracao m_estado;
    private RegistoCandidaturaADemonstracoes m_rcd;

    public Demonstracao(String descricao) {
        this.rc = new RegistoRecursos();
        this.m_StrDescricao = descricao;
        this.m_rcd = new RegistoCandidaturaADemonstracoes();
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
     * @param m_StrCodigoIdentificacao the m_StrCodigoIdentificacao to set
     */
    public void setCodigoIdentificacao(String m_StrCodigoIdentificacao) {
        this.m_StrCodigoIdentificacao = m_StrCodigoIdentificacao;
    }
<<<<<<< HEAD

    /**
     *
     * @return - registo de candidaturas a demonstração
     */
    public RegistoCandidaturaADemonstracoes getRegistoCandidaturasADemonstracao() {
        return m_rcd;
    }

    void setDataInicioCandidaturas(Data dataInicioCandDemo) {
        Data m_dataInicioSubCand = dataInicioCandDemo;
    }

    void setDataFimoCandidaturas(Data dataFimCandDemo) {
        Data m_dataFimSubCand = dataFimCandDemo;
=======
    
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
                
                // Falta estado - TODO
                
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

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            Element elementValue = document.createElement(DESCR_ELEMENT_NAME);
            elementValue.setTextContent(this.m_StrDescricao);
            elementKeyword.appendChild(elementValue);

            elementKeyword.appendChild(this.rc.exportContentToXMLNode());

            elementKeyword.setAttribute(ID_ATTR_NAME, this.m_StrCodigoIdentificacao);
            
            // Falta Estado - TODO

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Demonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
>>>>>>> 067302e6bc987c1b1b1590cac67590c0dcb6d5a8
    }
}
