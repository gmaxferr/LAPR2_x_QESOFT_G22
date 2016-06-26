package lapr.project.registos;

import java.util.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.estados.Exposicao.EstadoExposicao;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoExposicoes
 *
 * @author G29
 */
public class RegistoExposicoes implements Importable<RegistoExposicoes>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoExposicoes";

    /**
     * Lista de exposições existentes
     */
    private final List<Exposicao> m_listaExposicoes;

    /**
     * Centro de exposições
     */
    private final CentroExposicoes m_ce;

    /**
     * Construtor de objetos do tipo RegsitoExposicoes com o parâmetro centro de
     * exposicoes
     *
     * @param ce centro de exposicoes
     */
    public RegistoExposicoes(CentroExposicoes ce) {
        m_listaExposicoes = new ArrayList<>();
        this.m_ce = ce;
    }

    /**
     * Devolve lista das Exposições
     *
     * @return lista das Exposições
     */
    public List<Exposicao> getListaExposicoes() {
        return m_listaExposicoes;
    }

    /**
     * Devolve uma nova exposição criada
     *
     * @return nova exposição
     */
    public Exposicao novaExposicao() {
        return new Exposicao(m_ce);
    }

    /**
     * Valida a exposição e no caso positivo adiciona à lista de exposições
     *
     * @param e exposição recebida
     * @return true se a exposição foi adionada. Caso contrário retorna false
     */
    public boolean registaExposicao(Exposicao e) {
        if (e.valida()) {
            e.getEstado().setEstadoCriada();
            m_listaExposicoes.add(e);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devolve uma lista com todas as exposições associadas a um centro de
     * exposições
     *
     * @return lista com todas as exposições associadas a um centro de
     * exposições
     */
    public ArrayList<Exposicao> getListaExposicoesValidas() {
        ArrayList<Exposicao> lista = new ArrayList<>();
        for (Exposicao exposicao : this.m_listaExposicoes) {
            if (exposicao.dadosMinimosObrigatorios() == true) {
                lista.add(exposicao);
            }
        }
        return lista;
    }

    /**
     * Devolve a lista de exposições de um organizador
     *
     * @param usernameOrganizador username do organizador
     *
     * @return lista de exposições do organizador
     */
    public ArrayList<Exposicao> getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(String usernameOrganizador) {
        ArrayList<Exposicao> listaExposicoesDoOrganizador = new ArrayList<>();

        for (Exposicao exposicao : m_listaExposicoes) {
            for (Organizador organizador : exposicao.getListaOrganizadores()) {
                if (organizador != null && organizador.getUsernameOrganizador().equalsIgnoreCase(usernameOrganizador) && (exposicao.getEstado().isEstadoCriada() || exposicao.getEstado().isEstadoDemosDefinidasSemFAE())) {
                    listaExposicoesDoOrganizador.add(exposicao);
                }
            }
        }

        return listaExposicoesDoOrganizador;

    }

    /**
     * Devolve uma lista com as exposições em que existem candidaturas
     * atribuidas de um representante
     *
     * @param username - username do representante
     * @return lista com as exposições em que existem candidaturas atribuidas de
     * um representante
     */
    public List<Exposicao> getListaExposicoesComCanditaturasAtribuidasDoRepresentante(String username) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : m_listaExposicoes) {
            if (e.getEstado().isEstadoCandidaturasAbertas()) {
                RegistoCandidaturasAExposicao rc = e.getRegistoCandidaturasAExposicao();
                for (CandidaturaAExposicao c : rc.getListaCandidaturas()) {
                    if (c.getUsernameExpositor().equals(username)) {
                        if (!c.getEstado().isEstadoCandidaturaAvaliada()) {
                            listaExpoRep.add(e);
                            break;
                        }
                    }
                }
            }
        }
        return listaExpoRep;
    }

    /**
     * Devolve uma lista com as exposições em que existem candidaturas com stand
     * aceite de um representante
     *
     * @param email email do representante
     * @return lista com as exposições em que existem candidaturas com stand
     * aceite de um representante
     */
    public List<Exposicao> getListaExposicoesComCanditaturasComStandAceiteDoRepresentante(String email) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : m_listaExposicoes) {
            RegistoCandidaturasAExposicao rc = e.getRegistoCandidaturasAExposicao();
            for (CandidaturaAExposicao c : rc.getListaCandidaturas()) {
                if (c.getEmailExpositor().equals(email) && c.getEstado().isEstadoCandidaturaStandAceite()) {
                    listaExpoRep.add(e);
                    break;
                }
            }
        }
        return listaExpoRep;
    }

    /**
     * Devolve uma lista com as exposições em que existem candidaturas no estado
     * stands Atribuidos de um representante
     *
     * @param email email do representante
     * @return lista com as exposições em que existem candidaturas no estado
     * stands Atribuidos de um representante
     */
    public List<Exposicao> getListaExposicoesComCanditaturasEstadoStandsAtribuidosDoRepresentante(String email) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : m_listaExposicoes) {
            RegistoCandidaturasAExposicao rc = e.getRegistoCandidaturasAExposicao();
            for (CandidaturaAExposicao c : rc.getListaCandidaturasEstadoStandsAtribuidos()) {
                if (c.getEmailExpositor().equals(email)) {
                    listaExpoRep.add(e);
                    break;
                }
            }
        }
        return listaExpoRep;
    }

    /**
     * Devolve uma lista com as exposições em que existem candidaturas aceites
     * de um representante e que pelo menos uma demonstração das que mostrou
     * interesse foi confirmada
     *
     * @param email email do representante
     * @return lista com as exposições em que existem candidaturas aceites de um
     * representante e que pelo menos uma demonstração das que mostrou interesse
     * foi confirmada
     */
    public List<Exposicao> getListaExposicoesComCanditaturasAceitesDoRepresentanteComDemosConfirmadas(String email) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : m_listaExposicoes) {
            RegistoCandidaturasAExposicao rc = e.getRegistoCandidaturasAExposicao();
            for (CandidaturaAExposicao c : rc.getListaCandidaturas()) {
                if (c.getEmailExpositor().equals(email) && c.getEstado().isEstadoCandidaturaAceite() && e.peloMenosUmaDemonstracaoAceite(c.getRegistoDemonstracoes().getListaDemonstracoes())) {
                    listaExpoRep.add(e);
                    break;
                }
            }
        }
        return listaExpoRep;
    }

    /**
     * Devolve uma lista com as exposições em que existem candidaturas de um
     * representante
     *
     * @param email - email do representante
     * @return - lista com as exposições em que existem candidaturas do
     * representante
     */
    public List<Exposicao> getExposicoesDoRepresentanteCandidaturasAExposicaoAbertas(String email) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : m_listaExposicoes) {
            if (e.getEstado().isEstadoCandidaturasAbertas()) {
                RegistoCandidaturasAExposicao rc = e.getRegistoCandidaturasAExposicao();
                for (CandidaturaAExposicao c : rc.getListaCandidaturas()) {
                    if (c.getEmailExpositor().equals(email)) {
                        listaExpoRep.add(e);
                        break;

                    }
                }
            }
        }
        return listaExpoRep;
    }

    /**
     * Devolve uma lista com as exposições em que existem candidaturas às
     * demonstrações de um representante
     *
     * @param email - email do representante
     * @return - lista com as exposições em que existem candidaturas do
     * representante
     */
    public List<Exposicao> getExposicoesDoRepresentanteCandidaturasADemosAbertas(String email) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : m_listaExposicoes) {
            if (e.getEstado().isEstadoDemosDecididas()) {
                List<Demonstracao> listaDemosCandAbertas = e.getRegistoDemonstracoes().getListaDemonstracoesEstadoCandidaturasAbertas();
                for (Demonstracao demo : listaDemosCandAbertas) {
                    if (!demo.getCandidaturasDemoExpositor(email).isEmpty()) {
                        listaExpoRep.add(e);
                        break;
                    }
                }
            }
        }
        return listaExpoRep;
    }

    /**
     * Devolve uma lista com as exposições no estado candidaturas avaliadas
     *
     * @return lista com as exposições no estado candidaturas avaliadas
     */
    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAvaliadas() {
        ArrayList<Exposicao> listaExposicoesEstadoCandidaturasAvaliadas = new ArrayList<>();
        for (Exposicao exposicao : this.m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasAvaliadas()) {
                listaExposicoesEstadoCandidaturasAvaliadas.add(exposicao);
            }
        }
        return listaExposicoesEstadoCandidaturasAvaliadas;
    }

    /**
     * Devolve uma lista de exposições que já tenham tido o seu periodo de
     * submissão de candidaturas às suas demonstrações e que tenham estas
     * candidaturas já avaliadas.
     *
     * @return lista de exposições
     */
    public ArrayList<Exposicao> getListaExposicoesDoOrganizadorComDemonstracoesEmEstadoAvaliadas(String username) {
        ArrayList<Exposicao> listaExpos = new ArrayList<>();
        for (Exposicao e : this.m_listaExposicoes) {
            List<Organizador> listaOrg = e.getListaOrganizadores();
            boolean isOrg = false;
            for (Organizador o : listaOrg) {
                if (o.getUsernameOrganizador().equals(username)) {
                    isOrg = true;
                }
            }
            if (isOrg) {
                RegistoDemonstracoes rd = e.getRegistoDemonstracoes();
                List<Demonstracao> listaDemos = rd.getListaDemonstracoesEmEstadoCandidaturasAvaliadas();
                if (!listaDemos.isEmpty()) {
                    listaExpos.add(e);
                }
            }
        }
        return listaExpos;

    }

    /**
     * Devolve uma lista com as exposições no estado candidaturas abertas
     *
     * @return lista com as exposições no estado candidaturas abertas
     */
    public List<Exposicao> getListaExposicoesEstadoCandidaturasAbertas() {
        ArrayList<Exposicao> listaExposicoesEstadoCandidaturasAbertas = new ArrayList<>();
        for (Exposicao exposicao : m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasAbertas()) {
                listaExposicoesEstadoCandidaturasAbertas.add(exposicao);
            }
        }
        return listaExposicoesEstadoCandidaturasAbertas;
    }

    /**
     * Devolve uma lista de exposiçoes no estado candidaturas atribuidas do fae
     *
     * @param usernameFAE username do fae
     * @return lista de exposiçoes no estado candidaturas atribuidas do fae
     */
    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(String usernameFAE) {
        ArrayList<Exposicao> listaExposicoesEstadoCandidaturaAtribuidasDoFAE = new ArrayList<>();
        for (Exposicao exposicao : this.m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasAtribuidas() && exposicao.getRegistoFAE().isFAE(usernameFAE)) {
                listaExposicoesEstadoCandidaturaAtribuidasDoFAE.add(exposicao);
            }
        }
        return listaExposicoesEstadoCandidaturaAtribuidasDoFAE;
    }

    /**
     * Devolve uma lista de exposiçoes no estado candidaturas atribuidas do fae
     *
     * @param usernameFAE username do fae
     * @return lista de exposiçoes no estado candidaturas atribuidas do fae
     */
    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasDecididasDoFAEComDemonstracoesEmEstadoCandidaturasAtribuidas(String usernameFAE) {
        ArrayList<Exposicao> listaExposicoesEstadoCandidaturaDecididasDoFAE = new ArrayList<>();
        for (Exposicao exposicao : this.m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasDecididas() && exposicao.getRegistoFAE().isFAE(usernameFAE)) {
                RegistoDemonstracoes rd = new RegistoDemonstracoes(true);
                rd = exposicao.getRegistoDemonstracoes();
                for (Demonstracao d : rd.getListaDemonstracoes()) {
                    if (d.getEstadoDemo().isEstadoDemonstracaoCandidaturasAtribuidas()) {
                        listaExposicoesEstadoCandidaturaDecididasDoFAE.add(exposicao);
                    }
                }
            }
        }
        return listaExposicoesEstadoCandidaturaDecididasDoFAE;
    }

    /**
     * Devolve exposições do organizador em que existem demonstrações pendentes
     *
     * @param usernameOrganizador - username do organizador logado
     * @return exposições do organizador em que existem demonstrações pendentes
     */
    public List<Exposicao> getlistaExposicoesDoOrganizadorComDemos(String usernameOrganizador) {
        ArrayList<Exposicao> listaExposicoesDoOrganizador = new ArrayList<>();
        //encontra as exposições do organizador autenticado no sistema.
        for (Exposicao exposicao : m_listaExposicoes) {
            if (!exposicao.getEstado().isEstadoDemosDecididas()) {
                if (exposicao.getRegistoDemonstracoes().getDemonstracoesPendentes().size() > 0) {
                    for (Organizador organizador : exposicao.getListaOrganizadores()) {
                        if (organizador.getUsernameOrganizador().equalsIgnoreCase(usernameOrganizador)) {
                            listaExposicoesDoOrganizador.add(exposicao);
                            break;
                        }
                    }
                }
            }
        }
        return listaExposicoesDoOrganizador;
    }

    /**
     * Devolve uma lista de exposições que um fae pode atualizar conflitos
     *
     * @param usernameFae username do fae
     * @return lista de exposições que o fae pode atualizar conflitos
     */
    public List<Exposicao> getExposEstadoConflitosDetetadosFae(String usernameFae) {
        List<Exposicao> exposFAE = new ArrayList<>();
        for (Exposicao ex : this.m_listaExposicoes) {
            if (ex.getEstado().isEstadoConflitosDetetados()) {
                for (FAE f : ex.getListaFAE()) {
                    if (f.getUsernameFae().equalsIgnoreCase(usernameFae)) {
                        exposFAE.add(ex);
                    }
                }
            }
        }
        return exposFAE;
    }

    /**
     * Devolve uma lista de exposições de um fae
     *
     * @param username - username do fae
     * @return lista de exposições do fae
     */
    public List<Exposicao> getFaeDasDemosExpos(String username) {
        List<Exposicao> exposFAE = new ArrayList<>();
        for (Exposicao e : this.m_listaExposicoes) {
            RegistoDemonstracoes rd = e.getRegistoDemonstracoes();
            if (rd.isFaeDeDemo(username)) {
                if (e.getRegistoFAE().isFAE(username)) {
                    exposFAE.add(e);
                }
            }
        }
        return exposFAE;
    }

    /**
     * Devolve uma lista com todas as exposições em estado de candidaturas
     * decididas
     *
     * @return lista com todas as exposições em estado de candidaturas decididas
     */
    public List<Exposicao> getListaExposicoesEstadoCandidaturasDecididas() {
        List<Exposicao> listExpo = new ArrayList<>();
        for (Exposicao e : m_listaExposicoes) {
            EstadoExposicao state = e.getEstado();
            if (state.isEstadoDemosDecididas()) {
                listExpo.add(e);
            }
        }
        return listExpo;
    }

    /**
     * Devolve uma lista com todas as exposições cujo ranking está pronto para
     * ser exportado para um ficheiro
     *
     * @return lista com todas as exposições cujo ranking está pronto para ser
     * exportado para um ficheiro
     */
    public List<Exposicao> getListaExposicoesRankingPronto() {
        List<Exposicao> result = new ArrayList<>();
        for (Exposicao e : m_listaExposicoes) {
            if (e.getKeywordRanking().isReady()) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * Devolve uma lista de exposições no estado criada ou fae definidos sem
     * demos de um organizador
     *
     * @param usernameOrg username do organizador
     * @return lista de exposições no estado criada ou fae definidos sem demos
     * de um organizador
     */
    public List<Exposicao> getListaExposicoesDoOrganizadorAteEstadoAbertoACandidaturas(String usernameOrg) {
        List<Exposicao> listaExposicoesDoOrganizador = new ArrayList<>();
        List<Organizador> listOrg;

        for (Exposicao exposicao : m_listaExposicoes) {
            listOrg = exposicao.getListaOrganizadores();
            for (Organizador organizador : listOrg) {
                if (validaOrgEExpo(usernameOrg, organizador, exposicao)) {
                    listaExposicoesDoOrganizador.add(exposicao);
                }
            }
        }

        return listaExposicoesDoOrganizador;
    }

    public List<Exposicao> getListaExposicoesDoOrganizadorEstadoCriadaOuEstadoFaeDefinidos(String usernameOrg) {
        List<Exposicao> listaExposicoes = new ArrayList<>();
        List<Organizador> listOrg;

        for (Exposicao exposicao : m_listaExposicoes) {
            listOrg = exposicao.getListaOrganizadores();
            for (Organizador organizador : listOrg) {
                if (validaOrgEExpo2(usernameOrg, organizador, exposicao)) {
                    listaExposicoes.add(exposicao);
                }
            }
        }

        return listaExposicoes;
    }

    /**
     * verifica se o username recebido por parametro coincide com o do
     * organizador também recebido por parametro e que a exposição sobre a qual
     * este organizador detém o cargo esta no estado FaeDefinidosSemDemos
     *
     * @param usernameOrg usernanme do organizador
     * @param organizador organizador
     * @param exposicao exposição
     * @return true se o organizador for válido. Caso contrário retorna false.
     */
    private boolean validaOrgEExpo2(String usernameOrg, Organizador organizador, Exposicao exposicao) {
        return organizador.getUsernameOrganizador().equalsIgnoreCase(usernameOrg)
                && (exposicao.getEstado().isEstadoCriada()
                || exposicao.getEstado().isEstadoFAEDefinidosSemDemos());
    }

    /**
     * Valida organizador
     *
     * @param usernameOrg username do organizador
     * @param organizador organizador
     * @param exposicao exposicao
     * @return true se o organizador for válido. Caso contrário retorna false.
     */
    private boolean validaOrgEExpo(String usernameOrg, Organizador organizador, Exposicao exposicao) {
        return organizador.getUsernameOrganizador().equalsIgnoreCase(usernameOrg)
                && (exposicao.getEstado().isEstadoCriada()
                || exposicao.getEstado().isEstadoFAEDefinidosSemDemos()
                || exposicao.getEstado().isEstadoDemosDefinidasSemFAE()
                || exposicao.getEstado().isEstadoCompleta());
    }

    /**
     * Devolve uma lista de exposições no estado de CandidaturasAvaliadas ou
     * mais avançado.
     *
     * @return lista de exposições no estado de CandidaturasAvaliadas ou mais
     * avançado.
     */
    public List<Exposicao> getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado() {
        List<Exposicao> result = new ArrayList<>();
        for (Exposicao expo : m_listaExposicoes) {
            EstadoExposicao state = expo.getEstado();
            if (!state.isEstadoInicial()
                    && !state.isEstadoCriada()
                    && !state.isEstadoFAEDefinidosSemDemos()
                    && !state.isEstadoDemosDefinidasSemFAE()
                    && !state.isEstadoCompleta()
                    && !state.isEstadoCandidaturasAbertas()
                    && !state.isEstadoCandidaturasFechadas()
                    && !state.isEstadoConflitosDetetados()
                    && !state.isEstadoConflitosAlterados()
                    && !state.isEstadoCandidaturasAtribuidas()) {
                result.add(expo);
            }
        }
        return result;
    }

    /**
     * Devolve uma lista de exposições do organizador em estado candidatura a
     * demonstrações avaliadas
     *
     * @param username username do organozador
     * @return lista de exposições do organizador em estado candidatura a
     * demonstrações avaliadas
     */
    public List<Exposicao> getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas(String username) {
        List<Exposicao> result = new ArrayList<>();

        for (Exposicao e : m_listaExposicoes) {
            for (Organizador o : e.getListaOrganizadores()) {
                if (o.getUsernameOrganizador().equals(username)) {
                    for (Demonstracao d : e.getRegistoDemonstracoes().getListaDemonstracoes()) {
                        if (d.getEstadoDemo().isEstadoDemonstracaoCandidaturasAvaliadas()) {
                            result.add(e);
                            break;
                        }
                    }
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Devolve a lista de exposições do organizador em estado conflitos
     * alterados
     *
     * @param usernameOrganizador username do organizador
     * @return lista de exposições do organizador em estado conflitos alterados
     */
    public List<Exposicao> getlistaExposicoesDoOrganizadorEstadoConflitosAlterados(String usernameOrganizador) {
        List<Exposicao> listaExposicoesDoOrganizadorEstadoConflitosAlterados = new ArrayList<>();

        for (Exposicao exposicao : m_listaExposicoes) {
            for (Organizador organizador : exposicao.getListaOrganizadores()) {
                if (organizador.getUsernameOrganizador().equalsIgnoreCase(usernameOrganizador) && (exposicao.getEstado().isEstadoConflitosAlterados())) {
                    listaExposicoesDoOrganizadorEstadoConflitosAlterados.add(exposicao);
                }
            }
        }

        return listaExposicoesDoOrganizadorEstadoConflitosAlterados;
    }

    /**
     * Devolve uma lista com todas as exposições no estado avaliadas
     *
     * @return lista das exposições no estado avaliadas
     */
    public List<Exposicao> getListaExposicoesEstadoAvaliadas() {
        List<Exposicao> listaExposicoesEstadoAvaliadas = new ArrayList<>();

        for (Exposicao exposicao : m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasAvaliadas()) {
                listaExposicoesEstadoAvaliadas.add(exposicao);
            }
        }

        return listaExposicoesEstadoAvaliadas;
    }

    /**
     * Devolve uma lista com todas as exposições no estado avaliadas ou
     * posterior
     *
     * @return lista das exposições no estado avaliadas ou posterior
     */
    public List<Exposicao> getListaExposicoesEstadoAvaliadasOuPosterior() {
        List<Exposicao> listaExposicoesEstadoAvaliadas = new ArrayList<>();

        for (Exposicao exposicao : m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasAvaliadas()
                    || exposicao.getEstado().isEstadoCandidaturasDecididas()
                    || exposicao.getEstado().isEstadoDemosDecididas()) {
                listaExposicoesEstadoAvaliadas.add(exposicao);
            }
        }

        return listaExposicoesEstadoAvaliadas;
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     *
     * @param m_registoRecursos registo de recursos
     * @param m_registoTipoConflitos registo tipo de conflitos
     * @param m_registoUtilizadores registo de utilizadores
     */
    public void fix(RegistoRecursos m_registoRecursos, RegistoTipoConflitos m_registoTipoConflitos, RegistoUtilizadores m_registoUtilizadores) {
        for (Exposicao e : m_listaExposicoes) {
            e.fix(m_registoRecursos, m_registoTipoConflitos, m_registoUtilizadores);
        }
    }

    @Override
    public RegistoExposicoes importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document doc = XMLParser.createDocument(node, true);

        Node n = doc.getChildNodes().item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_listaExposicoes.clear();

            NodeList nList = elem.getElementsByTagName(Exposicao.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);
                Exposicao expo = novaExposicao();
                expo.importContentFromXMLNode(n2);
                this.m_listaExposicoes.add(expo);
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

            for (Exposicao expo : this.m_listaExposicoes) {
                Node n = expo.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoExposicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
