package lapr.project.model;

import classesREMOVIDAS.Candidatura;
import classesREMOVIDAS.FAE;
import classesREMOVIDAS.Atribuicao;
import classesREMOVIDAS.Exposicao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * MecanismoSimples A - Distribui os fae por igual número em cada candidatura.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class MecanismoA implements MecanismoSimples, Serializable {

    /**
     * Identificação do mecanismo A.
     */
    public static final String NOME_MECANISMO = "Carga equitativa";

    /**
     * Descrição do funcionamento do mecanismo A.
     */
    public static final String DESCRICAO_MECANISMO = "Este mecanismo distribui os FAE pelas candidaturas "
            + "existentes de forma a que cada candidatura tenha o mesmo número de FAE. Note que isto "
            + "só é possivel quando existe um número favorável de FAE para o número de candidaturas. "
            + "Note que se o número de FAE for menor do que número de Candidaturas não será gerada distribuição. "
            + "Por outro lado caso exista apenas uma candidatura todos os FAE serão atribuidos a essa mesma.";

    /**
     * Devolve a identificação do mecanismo A.
     *
     * @return identificação do mecanismo A.
     */
    @Override
    public String getNome() {
        return NOME_MECANISMO;
    }

    /**
     * Devolve a descrição do mecanismo A.
     *
     * @return descrição do funcionamento do mecanismo A.
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
     *
     * @return atribuição gerada.
     */
    @Override
    public List<Atribuicao> atribui(Exposicao exposicaoEscolhida) {

        List<Atribuicao> listaAtrib = new ArrayList<>();
        List<Candidatura> listaCand = exposicaoEscolhida.getRegistoCandidaturas().getListaCandidaturas();
        List<FAE> listaFAE = exposicaoEscolhida.getRegistoFAE().getListaFAE();

        if (listaFAE.isEmpty() || listaCand.isEmpty()) {
            return listaAtrib;
        } else {
            int numFAEPorCand = listaFAE.size() / listaCand.size();
            int posInicio = 0, posFim = 0;

            if (numFAEPorCand != 0) {
                for (int i = 0; i < listaCand.size(); i++) {
                    if (i != 0) {
                        posInicio += numFAEPorCand;
                    }
                    posFim += numFAEPorCand;
                    if (posFim > listaFAE.size()) {
                        posFim = listaFAE.size();
                    }
                    Atribuicao atribuicao = new Atribuicao();
                    atribuicao.setCandidatura(listaCand.get(i));
                    for (int j = posInicio; j < posFim; j++) {
                        atribuicao.addFAE(listaFAE.get(j));
                    }
                    listaAtrib.add(atribuicao);
                }
            }
            return listaAtrib;
        }
    }

}
