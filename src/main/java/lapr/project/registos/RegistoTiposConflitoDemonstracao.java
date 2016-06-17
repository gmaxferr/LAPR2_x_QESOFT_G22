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
import lapr.project.model.TipoConflito;
import lapr.project.model.TipoConflitoDemonstracao;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class RegistoTiposConflitoDemonstracao {

    public static final String ROOT_ELEMENT_NAME = "RegistoTipoConflitos";
    public static final String NUM_CONFLITOS_ATTR_NAME = "numConflitos";

    /**
     * Contador de numero de conflitos
     */
    private int numConflitos = 0;

    /**
     * Prefixo de um tipo de conflito
     */
    private static final String m_prefix = "TC-";

    /**
     * Lista de tipos de conflito
     */
    private final List<TipoConflitoDemonstracao> m_listaTipoConflitos;

    /**
     * Construtor de objetos do tipo RegistoTipoConflitos sem parâmetros
     */
    public RegistoTiposConflitoDemonstracao() {
        numConflitos = 0;
        this.m_listaTipoConflitos = new ArrayList<>();
    }

    /**
     * Devolve a lista de tipos de conflitos
     *
     * @return lista de tipos de conflitos
     */
    public List<TipoConflitoDemonstracao> getListaTipoConflitos() {
        return this.m_listaTipoConflitos;
    }

    /**
     * Cria um novo tipo de conflito
     *
     * @return novo tipo de conflito
     */
    public TipoConflitoDemonstracao novoTipoConflito() {
        return new TipoConflitoDemonstracao(m_prefix + numConflitos++);
    }

    /**
     * Valida um tipo de conflito
     *
     * @param tipoConflito tipo de conflito a validar
     * @return true se a lista de tipo de conflitos não conter o tipo de
     * conflito a validar. Caso contrário retorna false.
     */
    public boolean validaTipoDeConflito(TipoConflitoDemonstracao tipoConflito) {
        return !m_listaTipoConflitos.contains(tipoConflito);
    }

    /**
     * Adiciona um tipo de conflito
     *
     * @param tipoConflito tipo de conflito a ser adicionado
     *
     * @return true se o tipo de conflito foi adicionado à lista de tipos de
     * conflito. Caso contrário retorna false.
     */
    public boolean add(TipoConflitoDemonstracao tipoConflito) {
        boolean b = validaTipoDeConflito(tipoConflito);
        if (b) {
            m_listaTipoConflitos.add(tipoConflito);
        }
        return b;
    }

    @Override
    public RegistoTipoConflitos importContentFromXMLNode(Node node) {

    }

    @Override
    public Node exportContentToXMLNode() {
    }
}
