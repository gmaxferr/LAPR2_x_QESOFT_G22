/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Mecanismo de atribuição por experiência: Este mecanismo distribui as
 * candidaturas pelos FAEs de acordo com a sua experiência.<!-- -->O mecanismo
 * consegue este resultado criando primeiro uma reta real, de 0 a 1, com
 * intervalos correspondentes à constribuição dos FAE da exposição (ou
 * equitativamente caso não tenham experiência) e ajustando essa reta a uma
 * outra reta contendo as Candidaturas.<!-- -->Depois de ajustados os valores,
 * ele atribui as candidaturas correspondentes aos intervalos da reta das
 * candidaturas aos FAEs correspondentes aos intervalos da reta dos FAE.
 *
 * @author Ricardo Catalao
 */
public class MecanismoPredefinidoC implements MecanismoIteragivel, Serializable {

    /**
     * Numero minimo de atribuicoes por candidatura (para evitar candidaturas
     * estarem atribuidas a poucos FAES, quando possível).
     */
    public static final int MIN_ATR_PER_CAND = 3;

    /**
     * Numero maximo de atribuicoes por candidatura (para o caso de haver muitos
     * mais faes que candidaturas e não ter de fazer um numero de atribuicoes
     * exagerado).
     */
    public static final int MAX_ATR_PER_CAND = 12;

    /**
     * Resultado da lista de atribuicoes criada pelo mecanismo.<!-- -->Null se
     * não foi ainda criado ou não existem FAEs suficientes para atribuir as
     * candidaturas.
     */
    private List<AtribuicoesCandidatura> resultadoAtribuicoes = new ArrayList<>();

    /**
     * Contrutor do mecanismo
     */
    public MecanismoPredefinidoC() {
        resultadoAtribuicoes = new ArrayList<AtribuicoesCandidatura>();
    }

    @Override
    public List<AtribuicoesCandidatura> atribui(Exposicao e, String numeroLido) {

        //Obtem lista de Candidaturas, lista de FAEs e quantidade dos mesmos
        List<CandidaturaAExposicao> cands = e.getRegistoCandidaturasAExposicao().getListaCandidaturas();
        int nCand = cands.size();
        List<FAE> faes = e.getRegistoFAE().getListaFAE();
        int nFae = faes.size();

        //Se nao houver FAE, retorna null e acaba o mecanismo
        if (nFae == 0) {
            return null;
        }
        
        //Aqui decidimos quantos faes vamos atribuir a cada candidatura
        int resultFaePerCand = getResultFaePerCand(nFae);

        //Aqui é criada a máscara para aceder às candidaturas
        int[] maskCand = createMaskCand(resultFaePerCand, nCand);

        //Aqui é criada uma lista dos FAEs que vão ser usados de facto
        List<FAE> toBeUsed = new ArrayList<FAE>();
        double contribution = getFaesToBeUsed(nFae, faes, toBeUsed);

        //Numero de FAEs que temos disponiveis apos a filtragem
        int size = toBeUsed.size();

        //Percentagem de FAEs relativamente ao número de candidaturas
        double percentFaePerCand = (double) 1 / resultFaePerCand;

        //Array de percentagens dos FAEs
        double[] arrPercent = getArrayPercentages(size, contribution, resultFaePerCand, toBeUsed, percentFaePerCand);

        //Atribui as candidaturas já com toda a informação necessária
        atribuiCandidaturas(nCand, percentFaePerCand, maskCand, arrPercent, cands, toBeUsed);

        return resultadoAtribuicoes;
    }

    /**
     * Calcula quantos FAEs serão atribuidos a cada candidatura
     *
     * @param nFae Número de FAEs disponíveis
     * @return Número calculado de FAEs para cada candidatura
     */
    private int getResultFaePerCand(int nFae) {
        int minFaePerCand = nFae < MIN_ATR_PER_CAND ? nFae : MIN_ATR_PER_CAND;
        int maxFaePerCand = nFae;
        int resultFaePerCand = Math.min((minFaePerCand + maxFaePerCand) / 2, MAX_ATR_PER_CAND);

        return resultFaePerCand;
    }

    /**
     * Cria uma máscara para poder aceder às Candidaturas uma a seguir à outra,
     * repetindo n vezes.<!-- -->Um exemplo seria: Se temos 2 FAE e 3
     * Candidaturas, a máscara vai ser {0, 1, 2, 0, 1, 2}.
     *
     * @param resultFaePerCand Número calculado de FAEs por Candidatura
     * @param nCand Número de Candidaturas
     * @return Retorna a máscara criada para estes valores
     */
    private int[] createMaskCand(int resultFaePerCand, int nCand) {
        int[] maskCand = new int[resultFaePerCand * nCand];
        for (int i = 0; i < resultFaePerCand; i++) {
            for (int j = 0; j < nCand; j++) {
                maskCand[i * nCand + j] = j;
            }
        }

        return maskCand;
    }

    /**
     * Atribui à lista os elementos dos FAEs que vao ser usados (FAEs sem
     * experiencia não são considerados para este mecanismo a não ser na
     * ausência de FAEs com experiencia)
     *
     * @param nFae Numbero de FAEs disponíveis
     * @param faes Lista de FAEs disponíveis
     * @param toBeUsed Lista onde se irá atribuir os FAEs que vão ser usados de
     * facto
     * @return Retorna a soma da contribuição de todos os FAE
     */
    private double getFaesToBeUsed(int nFae, List<FAE> faes, List<FAE> toBeUsed) {
        toBeUsed.clear();
        double contribution = 0;    //Contribuicao total
        for (int i = 0; i < nFae; i++) {
            int nAvaliacoes = faes.get(i).getUtilizador().getnAvaliacoesDesdeSempre();
            if (nAvaliacoes > 0) {
                toBeUsed.add(faes.get(i));
                contribution += nAvaliacoes;
            }
        }
        //Caso nao tenha-mos encontrado FAEs com experiencia
        if (contribution == 0) {
            toBeUsed.addAll(faes);
        }

        return contribution;
    }

    /**
     * Calcula um array com os intervalos de percentagens para cada FAE.
     *
     * @param size Número de FAEs
     * @param contribution Contribuição total dos FAEs
     * @param resultFaePerCand Número de FAEs por Candidatura
     * @param toBeUsed Lista com todos os FAEs que vão ser usados nas
     * atribuições
     * @param percentFaePerCand Percentagem de FAEs por Candidatura
     * @return Array de doubles com os intervalos de contribuição de cada FAE
     */
    private double[] getArrayPercentages(int size, double contribution, int resultFaePerCand, List<FAE> toBeUsed, double percentFaePerCand) {
        double res[] = new double[size];
        double percentContribution;
        int nAvaliacoes;
        for (int i = 0; i < size; i++) {
            if (contribution == 0) {
                percentContribution = 1 / resultFaePerCand;
            } else {
                nAvaliacoes = toBeUsed.get(i).getUtilizador().getnAvaliacoesDesdeSempre();
                percentContribution = (double) nAvaliacoes / contribution;
                //Se a percentagem for maior que a percentagem de FAEs por candidatura
                if (percentContribution > percentFaePerCand) {
                    contribution -= percentContribution - percentFaePerCand;
                    percentContribution = percentFaePerCand;
                }
            }
            if (i > 0) {
                res[i] = percentContribution + res[i - 1];
            } else {
                res[i] = percentContribution;
            }
        }
        return res;
    }

    /**
     * Faz a atribuição das Candidaturas já com toda a informação necessária.
     *
     * @param nCand Número de candidaturas
     * @param percentFaePerCand Percentagem de FAEs por Candidatura
     * @param maskCand Máscara de Candidaturas
     * @param arrPercent Array de doubles com os valores dos intervalos de
     * percentagem de cada FAE
     * @param cands Lista de Candidaturas a atribuir
     * @param toBeUsed Lista de FAEs que vão ser usados
     */
    private void atribuiCandidaturas(int nCand, double percentFaePerCand, int[] maskCand, double arrPercent[], List<CandidaturaAExposicao> cands, List<FAE> toBeUsed) {
        resultadoAtribuicoes.clear();
        for (int i = 0; i < cands.size(); i++) {
            resultadoAtribuicoes.add(new AtribuicoesCandidatura(cands.get(i)));
        }
        //  O Indice do FAE Atual
        int indexFAE = 0;
        //  Percorre todas as candidaturas e vai atribuindo-as aos FAEs.
        for (int i = 0; i < maskCand.length; i++) {
            while (arrPercent[indexFAE] < (double) i * percentFaePerCand / nCand) {
                indexFAE++;
            }
            resultadoAtribuicoes.get(maskCand[i]).addFaeAvaliacao(toBeUsed.get(indexFAE));
        }
    }

    @Override
    public String getNome() {
        return "Mecanismo de atribuição por experiência";
    }

    @Override
    public String getDescricao() {
        return "Este mecanismo distribui as candidaturas pelos FAEs de acordo com a sua experiência. O mecanismo consegue este resultado criando primeiro uma reta real, de 0 a 1, com intervalos correspondentes à constribuição dos FAE da exposição (ou equitativamente caso não tenham experiência) e ajustando essa reta a uma outra reta contendo as Candidaturas. Depois de ajustados os valores, ele atribui as candidaturas correspondentes aos intervalos da reta das candidaturas aos FAEs correspondentes aos intervalos da reta dos FAE.";
    }

}
