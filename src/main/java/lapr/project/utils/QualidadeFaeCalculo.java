package lapr.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.exceptions.InsufficientNumberOfElementsForNormalDistributionException;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.Avaliacao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.FAE;
import lapr.project.registos.RegistoAtribuicoesCandidaturasExposicao;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Reoresentação de uma QualidadeFaeCalculo
 *
 * @author G29
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
                double media = atr.getRegistoFaeAvaliacao().getMediaDeTodosOsRatingsCandidaturaAExposicao();
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
    public NormalDistribution calcMediaAndVariance(FAE fae, RegistoAtribuicoesCandidaturasExposicao ra) throws InsufficientNumberOfElementsForNormalDistributionException {
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
            double mediaFae = fAval.getMediaRatingsCandidaturaAExposicao();

            double variance = 0D;
            CandidaturaAExposicao cand = atr.getCandidaturaAssociada();
            for (Media<CandidaturaAExposicao> media : mediaCands) {
                if (media.obj == cand) {
                    variance = Math.pow(media.getMedia() - mediaFae, 2);
                }
            }

            res.addValor(variance);
        }

        if (res.getN() < 30) {
            throw new InsufficientNumberOfElementsForNormalDistributionException();
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
    public List<Media<FAE>> getListaFAEsComDesvioPadraoAcimaDe(double desvioPadrao) {
        List<Media<FAE>> result = new ArrayList<>();
        for (Media<FAE> fae : mediaDesviosFaes) {
            if (fae.getN() >= 30 && fae.getMediaDesvios() > desvioPadrao) {
                result.add(fae);
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
    public List<Media<FAE>> testeHipotese(double valorIdeal, double grauConfianca) {

        NormalDistribution phi = new NormalDistribution(0, 1);
        double zCritico = phi.inverseCumulativeProbability(grauConfianca);

        for (Media<FAE> mediaFAE : mediaDesviosFaesParaAnalisar) {
            double mediaDesvios = mediaFAE.getMediaDesvios();
            double desvioPadrao = Math.sqrt(mediaFAE.getVarianciaDesvios());
            double numValores = mediaFAE.getN();

            double delta = zCritico * (desvioPadrao / Math.sqrt(numValores));
            double lowerBound = mediaDesvios + delta;

            double z0 = (mediaDesvios - valorIdeal) / (desvioPadrao / Math.sqrt(numValores));
            
            mediaFAE.setzCritico(zCritico);
            mediaFAE.setZ0(z0);

            if (z0 >= lowerBound) {
                mediaFAE.setDecisao(true);
            }
        }

        return mediaDesviosFaesParaAnalisar;
    }

    public class Media<T> {

        private final T obj;

        private double zCritico;
        private double z0;

        private List<Double> listaValores;

        private boolean decisao;

        public Media(T obj) {
            this.obj = obj;
            this.listaValores = new ArrayList<>();
            this.decisao = false;
        }

        /**
         * @return Retorna o objeto T
         */
        public T getObject(){
            return obj;
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
            if (listaValores.size() > 1) {
                double media = getMedia();
                double somaVariancias = 0D;
                for (Double d : listaValores) {
                    somaVariancias += Math.pow(d - media, 2);
                }
                return somaVariancias / (listaValores.size() - 1);
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

        /**
         * Define uma nova decisao.
         *
         * @param decisao decisao a definir
         */
        public void setDecisao(boolean decisao) {
            this.decisao = decisao;
        }

        /**
         * @return Retorna se o FAE deve ou não ser avisado
         */
        public boolean getDecisao() {
            return decisao;
        }

        /**
         * @return the zCritico
         */
        public double getzCritico() {
            return zCritico;
        }

        /**
         * @param zCritico the zCritico to set
         */
        public void setzCritico(double zCritico) {
            this.zCritico = zCritico;
        }

        /**
         * @return the z0
         */
        public double getZ0() {
            return z0;
        }

        /**
         * @param z0 the z0 to set
         */
        public void setZ0(double z0) {
            this.z0 = z0;
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
