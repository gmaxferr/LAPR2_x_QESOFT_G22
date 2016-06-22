package lapr.project.controller;

import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author G29
 */
public class RegistarCandidaturaADemonstracaoController {

    private Exposicao m_e; //exposição selecionada
    private Demonstracao m_d; //demonstração selecionada
    private String m_dados; //dados do formulário
    private CandidaturaADemonstracao m_cand; //nova candidatura a uma demonstração

    private CentroExposicoes m_ce;
    private String m_emailRep; //username do representante

    private RegistoExposicoes m_re;
    private RegistoDemonstracoes m_rd;
    private RegistoCandidaturasADemonstracao m_rcd;

    private List<Demonstracao> m_listDemos; //lista de demonstrações da exposição selecionada
    private List<Exposicao> m_listExpos; //lista de exposicoes em que o representante entra

    private EstadoCandidaturaADemonstracao m_estado;

    public RegistarCandidaturaADemonstracaoController(CentroExposicoes ce, String email) {
        this.m_ce = ce;
        this.m_emailRep = email;
    }

    /**
     * @return lista de exposiçoes (nas quais o representante foi integradp) do
     * registo de exposições do centro de exposições. selecionada previamente
     */
    public List<Exposicao> getListaDeExposicoes() {
        m_re = m_ce.getRegistoExposicoes();
        m_listExpos = m_re.getListaExposicoesComCanditaturasAceitesDoRepresentante(m_emailRep);
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
     * @return lista de demonstrações do registo de demonstrações da exposição
     * selecionada previamente
     */
    public List<Demonstracao> getListaDemos() {
        m_rd = m_e.getRegistoDemonstracoes();
        m_listDemos = m_rd.getListaDemonstracoes();
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
