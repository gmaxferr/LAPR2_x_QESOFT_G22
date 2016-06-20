package lapr.project.controller;

import java.util.List;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author G29
 */
public class AtribuirStandsController {

    private final CentroExposicoes m_centroDeExposicoes;

    private Exposicao expo;
    private RegistoCandidaturasAExposicao rc;
    private RegistoStands rs;
    private RegistoAtribuicoesStands ras;
    List<CandidaturaAExposicao> listCand;

    private List<AtribuicaoStand> listAtr;

    public AtribuirStandsController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }

    public List<Exposicao> getListaExposicoes() {
        RegistoExposicoes re = m_centroDeExposicoes.getRegistoExposicoes();
        return re.getListaExposicoesEstadoCandidaturasDecididas();
    }

    public void select(Exposicao expo) {
        expo = expo;
        rc = expo.getRegistoCandidaturasAExposicao();
    }

    public List<CandidaturaAExposicao> getListaCand() {
        this.listCand = rc.getListaCandidaturasAceites();
        return listCand;
    }

    public List<Stand> getListaStands() {
        rs = m_centroDeExposicoes.getRegistoStands();
        return rs.getListaStands();
    }

    public void setAtribuicoes(List<AtribuicaoStand> listAtr) {
        this.listAtr.clear();
        this.listAtr.addAll(listAtr);
    }

    public void confirm() {
        ras = expo.getRegistoAtribuicoesStands();
        ras.addAll(listAtr);
        for (CandidaturaAExposicao c : listCand) {
            EstadoCandidaturaAExposicao state = c.getEstado();
            state.setEstadoCandidaturaStandsAtribuidos();
        }
    }
}
