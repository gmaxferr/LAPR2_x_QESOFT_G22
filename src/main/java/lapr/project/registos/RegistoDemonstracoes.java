package lapr.project.registos;

import java.util.ArrayList;
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
    private ArrayList<Demonstracao> m_listaDemonstracoes;

    private CandidaturaAExposicao c;

    public RegistoDemonstracoes() {

    }

    /**
     * Deolve uma lista com todas as demostrações associadas a um centro de
     * exposições
     *
     * @return lista com todas as demontrações associadas a um centro de
     * exposições
     */
    public ArrayList<Demonstracao> getlistaDemonstracoes() {
        return this.m_listaDemonstracoes;
    }

    /**
     * Método que adiciona uma nova demonstração
     *
     * @param demonstracao demostracao a ser adicionada
     */
    public void adicionaDemostracao(Demonstracao demonstracao) {
        c.adicionaDemonstracao(demonstracao);
    }

    public Demonstracao novaDemonstracao(String descricaoIntroduzidaPeloUtilizador) {
        Demonstracao demo = new Demonstracao();
        demo.setDescricao(descricaoIntroduzidaPeloUtilizador);
        return demo;
    }

    public void confirma(Demonstracao demo) {
        this.m_listaDemonstracoes.add(demo);
    }
}
