package lapr.project.controller;

import java.util.List;
import lapr.project.estados.EstadoExposicao;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.FAE;
import lapr.project.registos.*;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.TipoConflito;

/**
 *
 * @author osori
 */
public class DetetarConflitoController {

    private RegistoExposicoes re;
    private RegistoTipoConflitos rtc;
    private RegistoMecanismosDetecaoConflitos rmdc;
    private RegistoFAE rfae;
    private RegistoCandidaturas rc;
    private List<FAE> listaFAE;
    private List<CandidaturaAExposicao> listaCand;
    private int tamanho;
    private boolean b;
    private RegistoConflitos rconf;
    private EstadoExposicao estadoExposicao;
    private EstadoCandidaturaAExposicao estadoCandidatura;

    

    private CentroExposicoes centroExposicoes;

    public DetetarConflitoController(CentroExposicoes centroExposicoes) {
        this.centroExposicoes = centroExposicoes;
    }


    public void getRegistoExposições() {
        this.re = centroExposicoes.getRegistoExposicoes();
    }

    public void getRegistoTiposDeConflito() {
        this.rtc = centroExposicoes.getRegistoTiposConflitos();

    }

    public void getRegistoMecanismosDetecaoConflitos() {

        for (TipoConflito tipoConflito : this.rtc.getListaTipoConflitos()) {
            this.rmdc = tipoConflito.getRegistoMecanismosDetecaoConflitos();

            for (Exposicao exposicao : re.getlistaExposicoesValidas()) {
                this.rfae = exposicao.getRegistoFAE();
                this.rc = exposicao.getRegistoCandidaturas();
                this.listaFAE = exposicao.getListaFAE();
                this.listaCand = exposicao.getListaCandidaturas();

                if (listaCand.size() > listaFAE.size()) {
                    tamanho = listaFAE.size();
                } else {
                    tamanho = listaCand.size();
                }
                for (int i = 0; i < tamanho; i++) {
                    b = rmdc.detetarConflitos(listaFAE.get(i), listaCand.get(i));
                    if (b == true) {
                        this.rconf = exposicao.getRegistoCoflitos();
                        rconf.criarConflito(listaFAE.get(i), listaCand.get(i));
                    }

                }
            }

        }
    }

    public void setEstadoConflitoDetetados() {
        for (Exposicao exposicao : this.re.getlistaExposicoesValidas()) {
            this.estadoExposicao = exposicao.getEstado();
            estadoExposicao.setEstadoConflitosDetetados();
        }

        for (CandidaturaAExposicao cand : this.rc.getListaCandidaturas()) {
            this.estadoCandidatura = cand.getEstado();
            estadoCandidatura.setEstadoConflitosDetetados();
        }

    }

}
