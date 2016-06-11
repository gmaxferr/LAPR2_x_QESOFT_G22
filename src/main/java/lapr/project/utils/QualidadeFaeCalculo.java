package lapr.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.Avaliacao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.FAE;
import lapr.project.registos.RegistoAtribuicoes;

/**
 *
 * @author Ricardo Catalao
 */
public class QualidadeFaeCalculo {

    private final List<Media<CandidaturaAExposicao>> listCands;
    private final List<Media<FAE>> listFaes;
    private final List<Media<FAE>> listFaesParaAnalisar;

    public QualidadeFaeCalculo() {
        this.listCands = new ArrayList<>();
        this.listFaes = new ArrayList<>();
        this.listFaesParaAnalisar = new ArrayList<>();
    }

    public void calcMedia(CandidaturaAExposicao cand, RegistoAtribuicoes ra) {
        boolean candEncontrada = false;

        Media<CandidaturaAExposicao> res = null;
        for (Media<CandidaturaAExposicao> medias : listCands) {
            if (medias.obj == cand) {
                candEncontrada = true;
                res = medias;
                break;
            }
        }
        if (!candEncontrada) {
            res = new Media<CandidaturaAExposicao>(cand);
            listCands.add(res);
        }

        for (AtribuicaoCandidatura atr : ra.getListaAtribuicoes()) {
            if (atr.getCandidaturaAssociada() == cand) {
                double media = atr.getRegistoFaeAvaliacao().getMediaRatings();
                res.addSomaMedias(media);
                break;
            }
        }
    }

    public void calcMediaAndVariance(FAE fae, RegistoAtribuicoes ra) {
        boolean faeEncontrado = false;

        Media<FAE> res = null;
        for (Media<FAE> media : listFaes) {
            if (media.obj == fae) {
                faeEncontrado = true;
                res = media;
                break;
            }
        }

        if (!faeEncontrado) {
            res = new Media<FAE>(fae);
            listFaes.add(res);
        }

        for (AtribuicaoCandidatura atr : ra.getListaAtribuicoesDoFAE(res.obj.getUsernameFae())) {
            Avaliacao fAval = atr.getRegistoFaeAvaliacao().getAvaliacaoDoFae(res.obj.getUsernameFae());
            double mediaFae = fAval.getMediaRatings();
            
            double variance = 0D;
            CandidaturaAExposicao cand = atr.getCandidaturaAssociada();
            for(Media<CandidaturaAExposicao> media : listCands){
                if(media.obj == cand){
                    variance = Math.pow(media.getMedia() - mediaFae, 2);
                }
            }
            
            res.addSomaMedias(mediaFae);
            res.addSomaVariancias(variance);
        }
    }

    public List<FAE> getListaFAEsWithVarianceOver(double vairancia) {
        List<FAE> result = new ArrayList<>();
        for(Media<FAE> fae : listFaes){
            if(fae.getMediaVariancia() > vairancia){
                result.add(fae.obj);
                this.listFaesParaAnalisar.add(fae);
            }
        }
        return result;
    }

    public List<FAE> testeHipotese(double grauConfianca) {
        throw new UnsupportedOperationException("Ainda não implementado.");
    }

    private class Media<T> {

        private final T obj;

        private double somaMedias;
        private int nMedias;

        private double somaVariancia;
        private int nVariancias;

        public Media(T obj) {
            this.obj = obj;
            this.somaMedias = 0.0D;
            this.nMedias = 0;
        }

        /**
         * @param somaMedias the somaMedias to set
         */
        public void addSomaMedias(double somaMedias) {
            this.somaMedias += somaMedias;
            this.nMedias++;
        }

        /**
         * @param somaMedias the somaMedias to set
         */
        public void addSomaVariancias(double somaMedias) {
            this.somaVariancia += somaMedias;
            this.nVariancias++;
        }

        /**
         * @return Devolve a média calculada desta candidatura;
         */
        public double getMedia() {
            if (nMedias > 0) {
                return somaMedias / nMedias;
            }
            return -1;
        }

        /**
         * @return Devolve a média calculada desta candidatura;
         */
        public double getMediaVariancia() {
            if (nVariancias > 0) {
                return somaVariancia / nVariancias;
            }
            return -1;
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
            hash = 59 * hash + Objects.hashCode(this.obj);
            hash = 59 * hash + (int) (Double.doubleToLongBits(this.somaMedias) ^ (Double.doubleToLongBits(this.somaMedias) >>> 32));
            hash = 59 * hash + this.nMedias;
            return hash;
        }
    }
}
