package lapr.project.model;

import java.util.List;

/**
 * Representação de um mecanismo interagivel - tem iteração com o utilziador
 * (dado recebido). - Comporta-se como um Mecanismo e usado para permitir o
 * polimorfismo
 *
 * @author Ricardo Osório e Ana Leite
 */
public interface MecanismoIteragivel extends Mecanismo {

    /**
     * Distribui os FAE pelas candidaturas
     *
     * @param exposicaoEscolhida exposição sobre a qual está a ser executada a
     * distribuição
     * @param numeroLido valor introduzido pelo utilizador, pode representar o
     * número de FAE por candidatura ou os anos de experiência
     * @return distribuição gerado pelo mecanismo
     */
    List<AtribuicaoCandidatura> atribui(Exposicao exposicaoEscolhida, String numeroLido);
}
