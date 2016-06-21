package lapr.project.model;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author G29
 */
public class MecanismoPredefinidoB implements MecanismoIteragivel, Serializable {

    /**
     * Identificação do mecanismo.
     */
    private static final String NOME_MECANISMO = "FAE por canidatura";

    /**
     * Descrição do funcionamento do mecanismo B.
     */
    private static final String DESCRICAO_MECANISMO = "Distribuir os FAE pelas candidaturas de forma a que cada "
            + "candidatura tenha, no final, até X (numero introduzido pelo Organizador) FAE associados. "
            + "Note que os FAE são distribuidos na totalidade por cada candidatura, desta forma se o número de "
            + "FAE for menor do que o número de candidaturas, não serão atribuidos FAE às últimas Candidaturas "
            + "registadas no Centro de Exposições.";

    /**
     * Devolve a identificação do mecanismo B.
     *
     * @return identificação do mecanismo B.
     */
    @Override
    public String getNome() {
        return NOME_MECANISMO;
    }

    /**
     * Devolve a descrição do mecanismo B.
     *
     * @return descrição do funcionamento do mecanismo B.
     */
    @Override
    public String getDescricao() {
        return DESCRICAO_MECANISMO;
    }

    /**
     * Distribuí os FAE pelas candidaturas.
     *
     * @param exposicaoEscolhida exposição selecionada onde será feita
     * distribuição dos seus FAE pelas suas candidaturas.
     * @param numeroFAEStr String inserida pelo utilziador na UI correspondente
     * ao número de FAE que pretende por cada candidatura
     *
     * @return atribuição gerada.
     */
    @Override
    public List<AtribuicaoCandidatura> atribui(Exposicao exposicaoEscolhida, String numeroFAEStr) throws IllegalArgumentException {

        int numeroFAE = Integer.parseInt(numeroFAEStr);
        if (numeroFAE < 0) {
            throw new IllegalArgumentException();
        }

        List<AtribuicaoCandidatura> listaAtrib = new ArrayList<>();
        List<CandidaturaAExposicao> listaCand = exposicaoEscolhida.getRegistoCandidaturasAExposicao().getListaCandidaturasEstadoProntaAtribuicoes();
        List<FAE> listaFAE = exposicaoEscolhida.getRegistoFAE().getListaFAE();

        if (listaFAE.isEmpty() || listaCand.isEmpty()) {
            return listaAtrib;
        } else {
            int posInicio = 0, posFim = 0;

            if (numeroFAE != 0) {
                for (int i = 0; i < listaCand.size(); i++) {
                    if (i != 0) {
                        posInicio += numeroFAE;
                    }
                    posFim += numeroFAE;
                    if (posFim > listaFAE.size()) {
                        posFim = listaFAE.size();
                    }
                    AtribuicaoCandidatura atribuicao = new AtribuicaoCandidatura(listaCand.get(i));
                    for (int j = posInicio; j < posFim; j++) {
                        atribuicao.addFaeAvaliacao(listaFAE.get(j));
                    }
                    listaAtrib.add(atribuicao);
                }
            }
        }
        return listaAtrib;
    }

    @Override
    public List<AtribuicaoCandidaturaDemonstracao> atribui(Exposicao exposicaoEscolhida, Demonstracao demonstracaoEscolhida, String numeroLido) {
        int numeroFAE = Integer.parseInt(numeroLido);
        if (numeroFAE < 0) {
            throw new IllegalArgumentException();
        }

        List<AtribuicaoCandidaturaDemonstracao> listaAtrib = new ArrayList<>();
        List<CandidaturaADemonstracao> listaCand = demonstracaoEscolhida.getRegistoCandidaturasADemonstracao().getListaCandidaturasEstadoCriada();
        List<FAE> listaFAE = exposicaoEscolhida.getRegistoFAE().getListaFAE();

        if (listaFAE.isEmpty() || listaCand.isEmpty()) {
            return listaAtrib;
        } else {
            int posInicio = 0, posFim = 0;

            if (numeroFAE != 0) {
                for (int i = 0; i < listaCand.size(); i++) {
                    if (i != 0) {
                        posInicio += numeroFAE;
                    }
                    posFim += numeroFAE;
                    if (posFim > listaFAE.size()) {
                        posFim = listaFAE.size();
                    }
                    AtribuicaoCandidaturaDemonstracao atribuicao = new AtribuicaoCandidaturaDemonstracao(listaCand.get(i));
                    for (int j = posInicio; j < posFim; j++) {
                        atribuicao.addFaeAvaliacao(listaFAE.get(j));
                    }
                    listaAtrib.add(atribuicao);
                }
            }
        }
        return listaAtrib;
    }

}
