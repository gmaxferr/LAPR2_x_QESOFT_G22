package lapr.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.Avaliacao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.FAE;
import lapr.project.registos.RegistoAtribuicoes;
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

    public void calcMedia(CandidaturaAExposicao cand, RegistoAtribuicoes ra) {
        Media<CandidaturaAExposicao> res = null;

        for (Media<CandidaturaAExposicao> medias : mediaCands) {
            if (medias.obj == cand) {
                res = medias;
                break;
            }
        }

        if (res == null) {
            res = new Media<CandidaturaAExposicao>(cand);
            mediaCands.add(res);
        }

        for (AtribuicaoCandidatura atr : ra.getListaAtribuicoes()) {
            if (atr.getCandidaturaAssociada() == cand) {
                double media = atr.getRegistoFaeAvaliacao().getMediaRatings();
                res.addValor(media);
                break;
            }
        }
    }

    public void calcMediaAndVariance(FAE fae, RegistoAtribuicoes ra) {
        Media<FAE> res = null;

        for (Media<FAE> media : mediaDesviosFaes) {
            if (media.obj == fae) {
                res = media;
                break;
            }
        }

        if (res == null) {
            res = new Media<FAE>(fae);
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
    }

    public List<FAE> getListaFAEsWithVarianceOver(double variancia) {
        List<FAE> result = new ArrayList<>();
        for (Media<FAE> fae : mediaDesviosFaes) {
            if (fae.getMedia() > variancia) {
                result.add(fae.obj);
                this.mediaDesviosFaesParaAnalisar.add(fae);
            }
        }
        return result;
    }

    public List<FAE> testeHipotese(double grauConfianca) {
        List<FAE> res = new ArrayList<>();

        NormalDistribution phi = new NormalDistribution(0, 1);
        double zCritico = phi.inverseCumulativeProbability(grauConfianca / 2);

        for (Media<FAE> mediaFAE : mediaDesviosFaesParaAnalisar) {
            double mediaDesvios = mediaFAE.getMedia();
            double variancia = Math.sqrt(mediaFAE.getVariancia());
            double numValores = mediaFAE.getN();

            double delta = zCritico * (Math.sqrt(variancia / numValores));
            double lowerBound = mediaDesvios - delta;
            double higherBound = mediaDesvios - delta;

            double z0 = (mediaDesvios - 0) / (Math.sqrt(variancia / numValores));

            if (z0 >= lowerBound && z0 <= higherBound) {
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
            if (listaValores.size() > 0) {
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
            if (listaValores.size() > 0) {
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
