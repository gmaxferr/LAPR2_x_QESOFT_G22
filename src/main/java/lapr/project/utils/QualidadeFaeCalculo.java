package lapr.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.Avaliacao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.FAE;
import lapr.project.registos.RegistoAtribuicoesCandidaturasExposicao;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 *
 * @author Ricardo Catalao
 */
public class QualidadeFaeCalculo {

    private final List<Media<CandidaturaAExposicao>> mediaCands;
    private final List<Media<FAE>> mediaDesviosFaes;
    private final List<Media<FAE>> mediaDesviosFaesParaAnalisar;

    public QualidadeFaeCalculo() {
        this.mediaCands = new ArrayList<>();
        this.mediaDesviosFaes = new ArrayList<>();
        this.mediaDesviosFaesParaAnalisar = new ArrayList<>();
    }

    /**
     * Calcula a média de todas as avaliações a uma
     * CandidaturaAExposição.<!-- -->Se já tiver calculado isto antes, adiciona
     * os valores aos já existentes.
     *
     * @param cand Candidatura da qual queremos saber a média das avaliações
     * @param ra Registo de Atribuicoes
     * @return Retorna o valor atual da média de avaliações desta Candidatura
     */
    public double calcMedia(CandidaturaAExposicao cand, RegistoAtribuicoesCandidaturasExposicao ra) {
        Media<CandidaturaAExposicao> res = null;

        for (Media<CandidaturaAExposicao> medias : mediaCands) {
            if (medias.obj == cand) {
                res = medias;
                break;
            }
        }

        if (res == null) {
            res = new Media<>(cand);
            mediaCands.add(res);
        }

        for (AtribuicaoCandidatura atr : ra.getListaAtribuicoes()) {
            if (atr.getCandidaturaAssociada() == cand) {
                double media = atr.getRegistoFaeAvaliacao().getMediaRatings();
                res.addValor(media);
            }
        }

        return res.getMedia();
    }

    /**
     * Calcula a média dos desvios e a variância da média desses mesmos desvios
     * para um determinado FAE.
     *
     * @param fae FAE que se pretende calcular estes valores
     * @param ra Registo de atribuicoes
     * @return Retorna uma distribuição normal de média equivalente à média dos
     * desvios calculado e desvio padrão igual ao desvio padrão calculado
     */
    public NormalDistribution calcMediaAndVariance(FAE fae, RegistoAtribuicoesCandidaturasExposicao ra) {
        Media<FAE> res = null;

        for (Media<FAE> media : mediaDesviosFaes) {
            if (media.obj == fae) {
                res = media;
                break;
            }
        }

        if (res == null) {
            res = new Media<>(fae);
            mediaDesviosFaes.add(res);
        }

        for (AtribuicaoCandidatura atr : ra.getListaAtribuicoesDoFAE(res.obj.getUsernameFae())) {
            Avaliacao fAval = atr.getRegistoFaeAvaliacao().getAvaliacaoDoFae(res.obj.getUsernameFae());
            double mediaFae = fAval.getMediaRatings();

            double variance = 0D;
            CandidaturaAExposicao cand = atr.getCandidaturaAssociada();
            for (Media<CandidaturaAExposicao> media : mediaCands) {
                if (media.obj == cand) {
                    variance = Math.pow(media.getMedia() - mediaFae, 2);
                }
            }

            res.addValor(variance);
        }

        double mediaDesvios = res.getMediaDesvios();
        double desvioPadrao = Math.sqrt(res.getVarianciaDesvios());
        return new NormalDistribution(mediaDesvios, Double.compare(desvioPadrao, 0D) == 0 ? Double.MIN_VALUE : desvioPadrao);
    }

    /**
     * @param desvioPadrao Desvio padrao limite.
     * @return Lista de FAEs cujo valor da media dos desvios seja maior que o
     * desvio padrao passado como limite
     */
    public List<FAE> getListaFAEsComDesvioPadraoAcimaDe(double desvioPadrao) {
        List<FAE> result = new ArrayList<>();
        for (Media<FAE> fae : mediaDesviosFaes) {
            if (fae.getMediaDesvios() > desvioPadrao) {
                result.add(fae.obj);
                this.mediaDesviosFaesParaAnalisar.add(fae);
            }
        }
        return result;
    }

    /**
     * @param valorIdeal Valor que o desvio padrão do FAE não pode ultrapassar
     * (hipótese nula (H0))
     * @param grauConfianca Grau de confiança para usar no teste de Hipoteses,
     * entre 0 e 1
     * @return Retorna uma lista inteira de FAEs para a qual a hipotese nula foi
     * rejeitada, para o grau de confiança especificado
     */
    public List<FAE> testeHipotese(double valorIdeal, double grauConfianca) {
        List<FAE> res = new ArrayList<>();

        NormalDistribution phi = new NormalDistribution(0, 1);
        double zCritico = phi.inverseCumulativeProbability(grauConfianca);

        for (Media<FAE> mediaFAE : mediaDesviosFaesParaAnalisar) {
            double mediaDesvios = mediaFAE.getMediaDesvios();
            double desvioPadrao = Math.sqrt(mediaFAE.getVarianciaDesvios());
            double numValores = mediaFAE.getN();

            double delta = zCritico * (desvioPadrao / Math.sqrt(numValores));
            double lowerBound = mediaDesvios + delta;

            double z0 = (mediaDesvios - valorIdeal) / (desvioPadrao / Math.sqrt(numValores));

            if (z0 >= lowerBound) {
                res.add(mediaFAE.obj);
            }
        }

        return res;
    }

    private class Media<T> {

        private final T obj;

        private List<Double> listaValores;

        public Media(T obj) {
            this.obj = obj;
            this.listaValores = new ArrayList<>();
        }

        /**
         * @param valor o valor a definir
         */
        public void addValor(double valor) {
            this.listaValores.add(valor);
        }

        /**
         * @return Devolve a média calculada desta candidatura;
         */
        public double getMedia() {
            if (!listaValores.isEmpty()) {
                double somaMedias = 0D;
                for (Double d : listaValores) {
                    somaMedias += d;
                }
                return somaMedias / listaValores.size();
            }
            return -1;
        }

        /**
         * @return Devolve a variancia dos valores
         */
        public double getVariancia() {
            if (!listaValores.isEmpty()) {
                double media = getMedia();
                double somaVariancias = 0D;
                for (Double d : listaValores) {
                    somaVariancias += Math.pow(d - media, 2);
                }
                return somaVariancias / listaValores.size();
            }
            return -1;
        }

        /**
         * @return Devolve a média calculada desta candidatura;
         */
        public double getMediaDesvios() {
            if (!listaValores.isEmpty()) {
                return Math.sqrt(getMedia());
            }
            return -1;
        }

        /**
         * @return Devolve a variancia dos valores
         */
        public double getVarianciaDesvios() {
            if (!listaValores.isEmpty()) {
                double media = getMediaDesvios();
                double somaVariancias = 0D;
                for (Double d : listaValores) {
                    somaVariancias += Math.pow(Math.sqrt(d) - media, 2);
                }
                return somaVariancias / listaValores.size();
            }
            return -1;
        }

        /**
         * @return Devolve o numero de elementos na lista de valores.
         */
        public int getN() {
            return listaValores.size();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj != null && obj instanceof Media<?>) {
                Media<?> media = (Media<?>) obj;
                return media.obj.equals(this.obj);
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.obj);
            hash = 97 * hash + Objects.hashCode(this.listaValores);
            return hash;
        }
    }
}
