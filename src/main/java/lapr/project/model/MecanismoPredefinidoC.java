package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class MecanismoPredefinidoC implements MecanismoIteragivel, Serializable {

    /**
     * Identificação do mecanismo C.
     */
    public static final String NOME_MECANISMO = "Experiência mínima";

    /**
     * Descrição do funcionamento do mecanismo C.
     */
    public static final String DESCRICAO_MECANISMO = "Distribui os FAE com pelo menos X anos de "
            + "experiência (valor introduzido pelo utilizador) apenas, deixando de fora todos os restantes. "
            + "A distribuição é feita com prioridade a que todas as candidaturas tenham o mesmo número de "
            + "FAE. Quando tal não é possivél distribui mais FAE nas primeiras candidaturas atribuidas "
            + "(sendo estes os com mais anos de experiência).";

    /**
     * Devolve a identificação do mecanismo C.
     *
     * @return identificação do mecanismo C.
     */
    @Override
    public String getNome() {
        return NOME_MECANISMO;
    }

    /**
     * Devolve a descrição do mecanismo C.
     *
     * @return descrição do funcionamento do mecanismo C.
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
     * @param experienciaStr String inserida pelo utilziador na UI
     * correspondente aos anos de experiência do FAE no cargo
     *
     * @return atribuição gerada.
     */
    @Override
    public List<Atribuicao> atribui(Exposicao exposicaoEscolhida, String experienciaStr) throws IllegalArgumentException {
        int experiencia = Integer.parseInt(experienciaStr);
        if (experiencia < 0) {
            throw new IllegalArgumentException();
        }

        List<Atribuicao> listaAtrib = new ArrayList<>();
        List<Candidatura> listaCand = exposicaoEscolhida.getRegistoCandidaturas().getListaCandidaturas();
        List<FAE> listaFAE = criarListaFAEComExperienciaMinima(exposicaoEscolhida, experiencia);

        Collections.sort(listaFAE);

        if (listaFAE.isEmpty() || listaCand.isEmpty()) {
            return listaAtrib;
        } else if (listaFAE.size() < listaCand.size()) {
            int pos = 0;
            for (Candidatura cand : listaCand) {
                Atribuicao atribuicao = new Atribuicao();
                atribuicao.setCandidatura(cand);
                if (pos < listaFAE.size()) {
                    atribuicao.addFAE(listaFAE.get(pos));
                    pos++;
                }
                listaAtrib.add(atribuicao);
            }
        } else {
            int numFAEPorCand = listaFAE.size() / listaCand.size();
            int numFAESobra = listaFAE.size() - (numFAEPorCand * listaCand.size());
            int posInicio = 0, posFim = 0;

            if (numFAEPorCand > 0) {
                for (int i = 0; i < listaCand.size(); i++) {
                    if (numFAESobra > 0) {
                        posFim++;
                        numFAESobra--;
                    }
                    if (i != 0) {
                        posInicio = posFim;
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
        }

        return listaAtrib;
    }

    private List<FAE> criarListaFAEComExperienciaMinima(Exposicao exposicaoEscolhida, int experiencia) {
        List<FAE> listaDaExpo = exposicaoEscolhida.getRegistoFAE().getListaFAE();
        List<FAE> listaNova = new ArrayList<>(listaDaExpo);

        for (int i = 0; i < listaNova.size(); i++) {
            if (listaNova.get(i).getExperiencia() < experiencia) {
                listaNova.remove(i);
            }
        }
        return listaNova;
    }

}
