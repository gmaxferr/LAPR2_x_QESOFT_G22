package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;
import lapr.project.utils.QualidadeFaeCalculo;

/**
 *
 * @author G29
 */
public class QualidadeFaeController {

    public static final double DESVIO_MAXIMO_PERMITIDO = 1D;

    private final CentroExposicoes ce;
    private QualidadeFaeCalculo qualFaeCalc;

    public QualidadeFaeController(CentroExposicoes ce) {
        this.ce = ce;
    }

    public List<FAE> getListaFAE() {
        qualFaeCalc = new QualidadeFaeCalculo();
        RegistoExposicoes re = ce.getRegistoExposicoes();
        List<Exposicao> listExpo = re.getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado();
        for (Exposicao expo : listExpo) {
            RegistoCandidaturasAExposicao rc = expo.getRegistoCandidaturasAExposicao();
            RegistoAtribuicoesCandidaturasExposicao ra = expo.getRegistoAtribuicoes();
            List<CandidaturaAExposicao> listCand = rc.getListaCandidaturas();
            for (CandidaturaAExposicao cand : listCand) {
                qualFaeCalc.calcMedia(cand, ra);
            }
            RegistoFAE rfae = expo.getRegistoFAE();
            List<FAE> listFae = rfae.getListaFAE();
            for (FAE fae : listFae) {
                qualFaeCalc.calcMediaAndVariance(fae, ra);
            }
        }
        return qualFaeCalc.getListaFAEsComDesvioPadraoAcimaDe(1);
    }

    public List<FAE> testeHipotese(double grauConfianca) {
        return qualFaeCalc.testeHipotese(DESVIO_MAXIMO_PERMITIDO, grauConfianca);
    }

}
