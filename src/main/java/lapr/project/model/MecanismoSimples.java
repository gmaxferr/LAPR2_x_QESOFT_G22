package lapr.project.model;

import java.util.List;

/**
 * Representação um mecanismo simples - sem interação com o utilizador
 *
 * @author Ricardo Osório e Ana Leite
 */
public interface MecanismoSimples extends Mecanismo {

    /**
     * Distribui os FAE pelas candidaturas
     *
     * @param exposicaoEscolhida exposição sobre a qual está a ser executada a
     * distribuição
     * @return distribuição gerada pelo mecanismo
     */
    List<AtribuicoesCandidatura> atribui(Exposicao exposicaoEscolhida);
}
