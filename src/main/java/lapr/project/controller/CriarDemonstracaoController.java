package lapr.project.controller;

import lapr.project.estados.Exposicao.EstadoExposicaoCriada;
import lapr.project.estados.Exposicao.EstadoExposicao;
import lapr.project.estados.Exposicao.EstadoExposicaoDemosDefinidasSemFAE;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author G29
 */
public class CriarDemonstracaoController {

    private RegistoExposicoes m_re;
    private RegistoRecursos m_rr;
    private RegistoDemonstracoes m_registoDemonstracoes;
    private CentroExposicoes m_ce;
    private Exposicao m_e;
    private Demonstracao m_demostracao;
    private EstadoExposicao m_estado;
    private String m_usernameOrg;

    /**
     * Lista de recursos para uma demonstração
     */
    private List<Recurso> m_listaRecursosParaDemonstracao;

    public CriarDemonstracaoController(String usernameOrg, CentroExposicoes ce) {
        m_usernameOrg = usernameOrg;
        m_ce = ce;
    }

    /**
     * Guarda os registos de exposições e de recursos neste Controller
     */
    public void pullRegistosCE() {
        m_re = m_ce.getRegistoExposicoes();
        m_rr = m_ce.getRegistoRecursos();
    }

    /**
     *
     * @return lista de exposições, do organizador, que não têm demonstrações
     * definidas
     */
    public List<Exposicao> getListaExposicoesDoOrganizador() {
        return m_re.getListaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos(m_usernameOrg);
    }

    /**
     * Armazen a exposição selecionada pelo utilizador neste controller
     *
     * @param e - exposição selecionada
     */
    public void setExposicao(Exposicao e) {
        this.m_e = e;
    }

    /**
     * Busca o registo de demonstrações da exposição selecionada, para este
     * controller.
     */
    public void pullRegistoDemonstracaoDaExposicao() {
        this.m_registoDemonstracoes = m_e.getRegistoDemonstracoes();
    }

    /**
     * Cria uma nova demonstração e armazena no controller a lista de recursos
     * da mesma.
     *
     * @param descricaoIntroduzidaPeloUtilizador - descrição da demonstração
     */
    public void novaDemonstracao(String descricaoIntroduzidaPeloUtilizador) {
        this.m_demostracao = m_registoDemonstracoes.novaDemonstracao(descricaoIntroduzidaPeloUtilizador);
        this.m_listaRecursosParaDemonstracao = m_demostracao.getRegistoRecursosNecessarios().getListaDeRecursos();
    }

    /**
     * @return lista de recursos do Registo de Recursos do Centro de Exposições
     */
    public List<Recurso> getListaDeRecursos() {
        return m_rr.getListaDeRecursos();
    }

    /**
     * Define um recurso a adicionar
     *
     * @param rec - recurso a adicionar
     */
    public void addRecurso(Recurso rec) {
        m_listaRecursosParaDemonstracao.add(rec);
    }

    /**
     * Valida uma demonstração no Registo de Demonstrações
     *
     * @return true se for válida, false caso contrário.
     */
    public boolean valida() {
        return m_registoDemonstracoes.valida(m_demostracao);
    }

    /**
     * Transita o estado da demonstração: caso esteja no estado
     * "FAEDefinidosSemDemos" transita para um estado "Completa"; caso esteja
     * num estado "Criada", transita para o estado "DemonsDefinidasSemFAE"
     */
    public void mudaEstado() {
        m_estado = this.m_e.getEstado();
        if (m_estado.isEstadoFAEDefinidosSemDemos()) {
            m_estado.setEstadoCompleta();
        } else if (m_estado.isEstadoCriada()) {
            m_estado.setEstadoDemosDefinidasSemFAE();
        }
    }

    /**
     * Verifica se um recurso já foi adicionado à lista
     *
     * @param r - recurso a verificar
     * @return true se já existir, false caso contrário
     */
    public boolean exists(Recurso r) {
        return m_listaRecursosParaDemonstracao.contains(r);
    }

    /**
     * Atribui a lista de recursos à demonstração
     */
    public void setRecursos() {
        RegistoRecursos rr = m_demostracao.getRegistoRecursosNecessarios();
        rr.setListaRecursosNecessarios(m_listaRecursosParaDemonstracao);
    }

    public void registaDemo() {
        m_registoDemonstracoes.addDemo(m_demostracao);
    }
}
