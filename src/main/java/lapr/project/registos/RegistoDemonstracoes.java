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

    private CandidaturaAExposicao candidaturaAExposicao;

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
    public void adicionaDemonstracao(Demonstracao demonstracao) {
        candidaturaAExposicao.adicionaDemonstracao(demonstracao);
    }

    public Demonstracao novaDemonstracao(String descricaoIntroduzidaPeloUtilizador) {
        Demonstracao demo = new Demonstracao(descricaoIntroduzidaPeloUtilizador);
        return demo;
    }

    /**
     * Permite definir lista de demonstrações
     * @param listaDemonstracoes 
     */
    public void setListaDemonstracoes(List<Demonstracao> listaDemonstracoes) {
        this.m_listaDemonstracoes = listaDemonstracoes;
    }

    /**
     * 
     * @return - lista das demonstrações pendentes
     */
    public List<Demonstracao> getDemonstracoesPendentes() {
        List<Demonstracao>demosPendentes = new ArrayList<>();
        for(Demonstracao d : m_listaDemonstracoes){
            if(d.getEstadoDemo().isEstadoDemonstracaoPendente())
            demosPendentes.add(d);
        }
        return demosPendentes;
    }
}
