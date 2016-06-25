package lapr.project.controller;

import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do controller do UC Registar Candidatura a Demonstração
 *
 * @author G29
 */
public class RegistarCandidaturaADemonstracaoController {

    /**
     * Exposição selecionada
     */
    private Exposicao m_e;

    /**
     * Demonstração selecionada
     */
    private Demonstracao m_d;

    /**
     * Dados do formulário para preencher
     */
    private String m_dados;

    /**
     * Candidatura a demonstração
     */
    private CandidaturaADemonstracao m_cand;

    /**
     * Centro de exposições
     */
    private CentroExposicoes m_ce;

    /**
     * Email do representante
     */
    private String m_emailRep;

    /**
     * Registo de exposições
     */
    private RegistoExposicoes m_re;

    /**
     * Registo de demonstrações
     */
    private RegistoDemonstracoes m_rd;

    /**
     * Registo de candidaturas a demonstração
     */
    private RegistoCandidaturasADemonstracao m_rcd;

    /**
     * Lista de demonstrações da exposição selecionada
     */
    private List<Demonstracao> m_listDemos;

    /**
     * Lista de exposições do representante
     */
    private List<Exposicao> m_listExpos;

    /**
     * Estado candidatura a demonstração
     */
    private EstadoCandidaturaADemonstracao m_estado;

    /**
     * Construtor de objetos do tipo RegistarCandidaturaADemonstracaoController
     * com os parametros centro de exposições e email
     *
     * @param ce centro de exposições
     * @param email email do representante
     */
    public RegistarCandidaturaADemonstracaoController(CentroExposicoes ce, String email) {
        this.m_ce = ce;
        this.m_emailRep = email;
    }

    /**
     * Devolve uma lista com todas as exposições que tenham candidaturas aceites
     * de um expositor cujo email (forma de identificar) é passado por parametro
     *
     * @return lista de exposiçoes (nas quais o representante foi integradp) do
     * registo de exposições do centro de exposições. selecionada previamente
     */
    public List<Exposicao> getListaDeExposicoes() {
        m_re = m_ce.getRegistoExposicoes();
        m_listExpos = m_re.getListaExposicoesComCanditaturasComStandAceiteDoRepresentante(m_emailRep);
        return m_listExpos;
    }

    /**
     * Guarda a exposição selecionada pelo representante.
     *
     * @param e - exposição selecionada
     */
    public void setExpo(Exposicao e) {
        this.m_e = e;

    }

    /**
     * Guarda a demonstração selecionada pelo representante
     *
     * @param indexSelectedDemo - indice da demonstração selecionada
     */
    public void setDemo(int indexSelectedDemo) {
        this.m_d = m_listDemos.get(indexSelectedDemo);
        m_rcd = m_d.getRegistoCandidaturasADemonstracao();
    }

    /**
     * Devolve a lista de demonstrações do registo de demonstrações da exposição
     * selecionada previamente
     *
     * @return lista de demonstrações do registo de demonstrações da exposição
     * selecionada previamente
     */
    public List<Demonstracao> getListaDemos() {
        m_rd = m_e.getRegistoDemonstracoes();
        m_listDemos = m_rd.getListaDemonstracoesEstadoConfirmada();
        return m_listDemos;
    }

    /**
     * Valida os dados conforme estes estejam ou não preenchidos. (Ainda não
     * temos outra forma de validar estes dados)
     *
     * @param dados - dados do formulário
     * @return true se forem válidos; false caso contrário
     */
    public boolean isValidDados(String dados) {
        return !dados.isEmpty();
    }

    /**
     * Armazena os dados do formulário, introduzidos pelo utilizador (se forem
     * válidos).
     *
     * @param dados - daods do formulário, introduzidos pelo utilizador
     * @return true se forem válidos e, por tanto, armazenados com sucesso;
     * false caso contrário.
     */
    public boolean setFormularioDados(String dados) {
        boolean valido = false;
        if (isValidDados(dados)) {
            this.m_dados = dados;
            valido = true;
        }
        return valido;
    }

    /**
     * Valida globalmente uma candidatura e regista-a se for válida.
     *
     * @return true se a adição foi efetuada com sucesso; false caso contrário
     */
    public boolean RegistaCandADemo() {
        m_cand = new CandidaturaADemonstracao(m_dados, m_emailRep);
        return m_rcd.adiciona(m_cand);
    }

    /**
     * Muda o estado da candidatura à demonstração
     */
    public void transitaEstado() {
        this.m_estado = m_cand.getEstado();
        m_estado.setEstadoCandidaturaADemonstracaoCriada();
    }
}
