package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoDemonstracoes
 *
 * @author G29
 */
public class RegistoDemonstracoes implements Importable<RegistoDemonstracoes>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoDemonstracoes";
    public static final String CONTADOR_ATTR_NAME = "contador";

    /**
     * Lista de demostrações existentes
     */
    private List<Demonstracao> m_listaDemonstracoes;

    /**
     * Prefixo das demonstrações
     */
    private static final String m_Prefixo = "Demo_";

    /**
     * Contador de demonstrações
     */
    private int m_contadorDemos;

    /**
     * Exposicção
     */
    private Exposicao m_expo;

    /**
     * Construtor de objetos do tipo RegistoDemonstracoes sem paramentros
     */
    public RegistoDemonstracoes() {
        this.m_listaDemonstracoes = new ArrayList<>();
        this.m_expo = null;
    }

    /**
     * Define uma nova Exposicao para este RegistoDemonstracoes
     *
     * @param e Exposicao
     */
    public void setExposicao(Exposicao e) {
        this.m_expo = e;
    }

    /**
     * @return Devolve a exposição a que pertence este RegistoDemonstracoes
     */
    public Exposicao getExposicao() {
        return m_expo;
    }

    /**
     * Devolve uma lista com todas as demostrações
     *
     * @return lista com todas as demontrações
     */
    public List<Demonstracao> getListaDemonstracoes() {
        return this.m_listaDemonstracoes;
    }

    /**
     * Devolve a lista de candidaturas às demonstrações de um expositor. O
     * expositor éidentificado passando o seu email por parametro
     *
     * @param emailExpositor email do expositor
     *
     * @return lista de candidaturas às demos do expositor
     */
    public List<CandidaturaADemonstracao> getListaCandidaturasAsDemonstracoesDoExpositor(String emailExpositor) {
        List<CandidaturaADemonstracao> listaCandidaturasAsDemosDoExpositor = new ArrayList<>();
        for (Demonstracao demonstracao : m_listaDemonstracoes) {
            listaCandidaturasAsDemosDoExpositor.addAll(demonstracao.getRegistoCandidaturasADemonstracao().getListaCandidaturasADemonstracaoRep(emailExpositor));
        }
        return listaCandidaturasAsDemosDoExpositor;
    }

    /**
     * lista de candidaturas a demonstração alida demonstração de
     * CandidaturaAExposicao recebendo-a como parametro
     *
     * @param demonstracao demonstração a ser validads
     */
    public void validaDemonstracao(Demonstracao demonstracao) {

        if (validarDadosRepetidosOuInvalidos() == false) {
            //remove os dados introduzidos anteriormente por estarem repetidos ou invalidos
        }
    }

    /**
     * Valida os dados repetidos pu invalidos de CandidaturaAExposicao
     *
     * @return boolean com a confirmação da validação
     */
    public boolean validarDadosRepetidosOuInvalidos() {
        return true;
    }

    /**
     * Cria uma nova demonstração
     *
     * @param descricao - descrição da demonstração
     * @return nova demonstração
     */
    public Demonstracao novaDemonstracao(String descricao) {
        Demonstracao demo;
        if (m_expo == null) {
            demo = new Demonstracao(descricao);
        } else {
            demo = new Demonstracao(descricao, m_expo);
        }
        return demo;
    }

    /**
     * Define a lista de demonstrações
     *
     * @param listaDemonstracoes lista de demonstrações
     */
    public void setListaDemonstracoes(List<Demonstracao> listaDemonstracoes) {
        for (Demonstracao d : listaDemonstracoes) {
            d.setCodigoIdentificacao(m_Prefixo + m_contadorDemos);
        }
        this.m_listaDemonstracoes = listaDemonstracoes;
    }

    /**
     * Devolve a lista das demonstrações pendentes
     *
     * @return lista das demonstrações pendentes
     */
    public List<Demonstracao> getDemonstracoesPendentes() {
        List<Demonstracao> demosPendentes = new ArrayList<>();
        for (Demonstracao d : m_listaDemonstracoes) {
            if (d.getEstadoDemo().isEstadoDemonstracaoPendente()) {
                demosPendentes.add(d);
            }
        }
        return demosPendentes;
    }

    /**
     * Valida uma demonstração
     *
     * @param m_demoCriada - nova demonstração a validar
     * @return true se for válida; false caso contrário
     */
    public boolean valida(Demonstracao m_demoCriada) {
        return (!m_listaDemonstracoes.contains(m_demoCriada))
                && (!m_demoCriada.getRegistoRecursosNecessarios().getListaDeRecursos().isEmpty());
    }

    /**
     * Adiciona uma demonstração à lista de demonstrações deste registo
     *
     * @param m_demoCriada - demonstração a adicionar
     */
    public void addDemo(Demonstracao m_demoCriada) {
        m_demoCriada.setCodigoIdentificacao(m_Prefixo + m_contadorDemos);
        m_contadorDemos++;
        if (valida(m_demoCriada)) {
            this.m_listaDemonstracoes.add(m_demoCriada);
        }
    }

    /**
     * Devolve a lista de demonstrações de um organizador
     *
     * @return lista de demonstrações de um organizador
     */
    public List<Demonstracao> getListaDemonstracoesEstadoConfirmada() {
        List<Demonstracao> listaDemonstracoesDoOrganizador = new ArrayList<>();

        for (Demonstracao demonstracao : m_listaDemonstracoes) {
            if (m_expo != null) {
                demonstracao.setExpo(m_expo);
            }
            if (demonstracao.getEstadoDemo().isEstadoDemonstracaoConfirmada()) {
                listaDemonstracoesDoOrganizador.add(demonstracao);
            }
        }
        return listaDemonstracoesDoOrganizador;
    }

    /**
     * Devolve a lista de demonstrações de um organizador
     *
     * @return lista de demonstrações de um organizador
     */
    public List<Demonstracao> getListaDemonstracoesVariosEstados() {
        List<Demonstracao> listaDemonstracoesDoOrganizador = new ArrayList<>();

        for (Demonstracao demonstracao : m_listaDemonstracoes) {
            if (m_expo != null) {
                demonstracao.setExpo(m_expo);
            }
            if (!demonstracao.getEstadoDemo().isEstadoDemonstracaoPendente()
                    || !demonstracao.getEstadoDemo().isEstadoDemonstracaoConfirmada()
                    || !demonstracao.getEstadoDemo().isEstadoDemonstracaoCancelada()
                    || !demonstracao.getEstadoDemo().isEstadoDemonstracaoDatasDefinidas()) {
                listaDemonstracoesDoOrganizador.add(demonstracao);
            }
        }
        return listaDemonstracoesDoOrganizador;
    }

    /**
     * Devolve a lista de demonstrações do fae
     *
     * @return lista de demonstrações do fae
     */
    public List<Demonstracao> getListaDemonstracoesEstadoCandidaturasAtribuidas() {
        List<Demonstracao> listaDemonstracoesDoFAE = new ArrayList<>();

        for (Demonstracao demonstracao : m_listaDemonstracoes) {
            if (m_expo != null) {
                demonstracao.setExpo(m_expo);
            }
            if (demonstracao.getEstadoDemo().isEstadoDemonstracaoCandidaturasAtribuidas()) {
                listaDemonstracoesDoFAE.add(demonstracao);
            }
        }
        return listaDemonstracoesDoFAE;
    }

    /**
     * Devolve a lista de demonstrações no estado candidaturas fechadas
     *
     * @return lista de demonstrações no estado candidaturas fechadas
     */
    public List<Demonstracao> getListaDemonstracoesEstadoCandidaturasFechadas() {
        List<Demonstracao> listaDemonstracoesDoOrganizador = new ArrayList<>();
        for (Demonstracao demonstracao : m_listaDemonstracoes) {
            if (m_expo != null) {
                demonstracao.setExpo(m_expo);
            }
            if (demonstracao.getEstadoDemo().isEstadoDemonstracaoCandidaturasFechadas()) {
                listaDemonstracoesDoOrganizador.add(demonstracao);
            }
        }
        return listaDemonstracoesDoOrganizador;
    }

    /**
     * Devolve a lista das demonstrações dentro do periodo de submissão de
     * candidaturas
     *
     * @return lista das demonstrações dentro do periodo de submissão de
     * candidaturas
     */
    public List<Demonstracao> getListaDemonstracoesEstadoCandidaturasAbertas() {
        List<Demonstracao> listaDemonstracoes = new ArrayList<>();
        for (Demonstracao demonstracao : m_listaDemonstracoes) {
            if (m_expo != null) {
                demonstracao.setExpo(m_expo);
            }
            if (demonstracao.getEstadoDemo().isEstadoDemonstracaoCandidaturasAbertas()) {
                listaDemonstracoes.add(demonstracao);
            }
        }
        return listaDemonstracoes;
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     *
     * @param m_registoRecursos registo de recursos
     * @param rCand registo candidatura
     */
    public void fix(RegistoRecursos m_registoRecursos, RegistoCandidaturasAExposicao rCand, RegistoUtilizadores ru) {
        for (Demonstracao d : this.m_listaDemonstracoes) {
            for (Recurso r : d.getRegistoRecursosNecessarios().getListaDeRecursos()) {
                for (Recurso r2 : m_registoRecursos.getListaDeRecursos()) {
                    if (r.equals(r2)) {
                        r = r2;
                        break;
                    }
                }
            }
        }

        for (Demonstracao d : m_listaDemonstracoes) {
            d.fix(rCand, m_expo, ru);
        }
    }

    @Override
    public RegistoDemonstracoes importContentFromXMLNode(Node node) throws ParserConfigurationException {
        if (node == null) {
            return this;
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        doc.appendChild(doc.importNode(node, true));

        Node n = doc.getChildNodes().item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_listaDemonstracoes.clear();

            NodeList nList = elem.getElementsByTagName(Demonstracao.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);
                Demonstracao demo = new Demonstracao("", m_expo);
                demo.importContentFromXMLNode(n2);
                m_listaDemonstracoes.add(demo);
            }

            this.m_contadorDemos = Integer.parseInt(elem.getAttribute(CONTADOR_ATTR_NAME));
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

            for (Demonstracao demo : m_listaDemonstracoes) {
                Node n = demo.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            elementKeyword.setAttribute(CONTADOR_ATTR_NAME, String.valueOf(this.m_contadorDemos));

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoDemonstracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

    /**
     * Forma uma lista com as demonstrações em estado avaliadas
     *
     * @return lista formada
     */
    public ArrayList<Demonstracao> getListaDemonstracoesEmEstadoCandidaturasAvaliadas() {
        ArrayList<Demonstracao> listaDemosAvaliadas = new ArrayList<Demonstracao>();
        EstadoDemonstracao estado;
        for (Demonstracao d : this.m_listaDemonstracoes) {
            estado = d.getEstadoDemo();
            if (estado.isEstadoDemonstracaoCandidaturasAvaliadas()) {
                listaDemosAvaliadas.add(d);
            }
        }
        return listaDemosAvaliadas;
    }

    /**
     * Devolve a percentagem de candidaturas de um expositor às demonstrações
     * aceites.
     *
     * @param emailExpositor email do expositor
     * @return percentagem de candidaturas às demonstrações aceites
     */
    public float getPercentagemCandidaturasAceites(String emailExpositor) {
        List<CandidaturaADemonstracao> listaCandidaturasDoExpositor = getListaCandidaturasAsDemonstracoesDoExpositor(emailExpositor);
        int cont = listaCandidaturasDoExpositor.size();
        float candAceites = 0;
        for (CandidaturaADemonstracao candidatura : listaCandidaturasDoExpositor) {
            if (candidatura.getEstado().isEstadoCandidaturaADemonstracaoAceite()) {
                candAceites++;
            }
        }
        if (cont != 0) {
            return (candAceites / cont) * 100;
        } else {
            return 0;
        }
    }

}
