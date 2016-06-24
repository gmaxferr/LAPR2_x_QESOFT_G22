package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;
import lapr.project.utils.QualidadeFaeCalculo;

/**
 * Representação do controller do UC Qualidade FAE
 * 
 * @author G29
 */
public class QualidadeFaeController {

    /**
     * Desvio máximo permitido
     */
    public static final double DESVIO_MAXIMO_PERMITIDO = 1D;

    /**
     * Centro de exposições
     */
    private final CentroExposicoes ce;
            
    /**
     * Qualidade do fae
     */        
    private QualidadeFaeCalculo qualFaeCalc;

    /**
     * Construtor de objetos do tipo QualidadeFaeController com o parametro
     * centro de exposições
     * 
     * @param ce centro de exposições
     */
    public QualidadeFaeController(CentroExposicoes ce) {
        this.ce = ce;
    }

    /**
     * Devolve a lista de FAEs cujo valor da media dos desvios seja maior que o
     * desvio padrao passado como limite
     * 
     * @return lista de FAEs cujo valor da media dos desvios seja maior que o
     * desvio padrao passado como limite
     */
    public List<FAE> getListaFAE() {
        qualFaeCalc = new QualidadeFaeCalculo();
        RegistoExposicoes re = ce.getRegistoExposicoes();
        List<Exposicao> listExpo = re.getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado();
        for (Exposicao expo : listExpo) {
            RegistoCandidaturasAExposicao rc = expo.getRegistoCandidaturasAExposicao();
            RegistoAtribuicoesCandidaturasExposicao ra = expo.getRegistoAtribuicoesExposicao();
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

    /**
     * Retorna uma lista inteira de FAEs para a qual a hipotese nula foi
     * rejeitada, para o grau de confiança especificado
     * 
     * @param grauConfianca grau de confiança especificado
     * @return lista inteira de FAEs para a qual a hipotese nula foi
     * rejeitada, para o grau de confiança especificado
     */
    public List<FAE> testeHipotese(double grauConfianca) {
        return qualFaeCalc.testeHipotese(DESVIO_MAXIMO_PERMITIDO, grauConfianca);
    }

}
