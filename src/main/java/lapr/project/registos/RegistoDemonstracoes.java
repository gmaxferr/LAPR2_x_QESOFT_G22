package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Demonstracao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class RegistoDemonstracoes {

    /**
     * Lista de demostrações existentes
     */
    private List<Demonstracao> m_listaDemonstracoes;

    private CandidaturaAExposicao m_candidaturaAExposicao;

    private String m_Prefixo = "Demo_";

    private int m_contadorDemos;

    public RegistoDemonstracoes() {
        this.m_listaDemonstracoes = new ArrayList<>();
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
     * Método que adiciona uma nova demonstração
     *
     * @param demonstracao demostracao a ser adicionada
     */
    public void adicionaDemonstracaoACandidatura(Demonstracao demonstracao) {
        m_candidaturaAExposicao.adicionaDemonstracao(demonstracao);
    }

    /**
     * Cria uma nova demonstração
     * @param descricao - descrição da demonstração
     * @return nova demonstração
     */
    public Demonstracao novaDemonstracao(String descricao) {
        Demonstracao demo = new Demonstracao(descricao);
        return demo;
    }

    /**
     * <<<<<<< HEAD Permite definir lista de demonstrações a partir de uma outra
     *
     * @param listaDemonstracoes - lista de demonstrações a considerar =======
     * Permite definir lista de demonstrações
     *
     * @param listaDemonstracoes >>>>>>>
     * d028313c3d76f6dc2b99d2c5ca0701431aeb8599
     */
    public void setListaDemonstracoes(List<Demonstracao> listaDemonstracoes) {
        for (Demonstracao d : listaDemonstracoes) {
            d.setCodigoIdentificacao(m_Prefixo + m_contadorDemos);
        }
        this.m_listaDemonstracoes = listaDemonstracoes;
    }

    /**
     *
     * @return - lista das demonstrações pendentes
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
        return !m_demoCriada.getDescricao().isEmpty() && !m_listaDemonstracoes.contains(m_demoCriada) && !m_demoCriada.getRegistoRecursosNecessarios().getListaDeRecursos().isEmpty();
    }

    /**
     * Adiciona uma demonstração à lista de demonstrações deste registo
     *
     * @param m_demoCriada - demonstração a adicionar
     */
    public void addDemo(Demonstracao m_demoCriada) {
        m_demoCriada.setCodigoIdentificacao(m_Prefixo + m_contadorDemos);
        m_contadorDemos++;
        this.m_listaDemonstracoes.add(m_demoCriada);
    }
}
