package lapr.project.controller;

import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.registos.RegistoAtribuicoes;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoFAE;
import lapr.project.utils.QualidadeFaeCalculo;

/**
 *
 * @author Ricardo Catalao
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
            RegistoAtribuicoes ra = expo.getRegistoAtribuicoes();
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
