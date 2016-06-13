package lapr.project.model;

import java.util.List;

/**
 * Representação um mecanismo simples - sem interação com o utilizador
 *
 * @author G29
 */
public interface MecanismoSimples extends Mecanismo {

    /**
     * Distribui os FAE pelas candidaturas
     *
     * @param exposicaoEscolhida exposição sobre a qual está a ser executada a
     * distribuição
     * @return distribuição gerada pelo mecanismo
     */
    List<AtribuicaoCandidatura> atribui(Exposicao exposicaoEscolhida);
    
    /**
     * Distribui os FAE pelas candidaturas
     * 
     * @param demonstracaoEscolhida demonstração sobre a qual está a ser executada a
     * distribuição
     * @return distribuição gerada pelo mecanismo
     */
    List<AtribuicaoCandidatura> atribui (Demonstracao demonstracaoEscolhida);
}
