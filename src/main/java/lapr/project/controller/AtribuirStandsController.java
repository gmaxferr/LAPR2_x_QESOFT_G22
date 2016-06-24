package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Represnetação do controller do UC Atribuir Stands 
 * 
 * @author G29
 */
public class AtribuirStandsController {

    /**
     * Centro d exposições
     */
    private final CentroExposicoes m_centroDeExposicoes;

    /**
     * Exposição selecionada
     */
    private Exposicao expo;

    /**
     * Registo de candidaturas a exposição
     */
    private RegistoCandidaturasAExposicao rc;

    /**
     * Registo de stands
     */
    private RegistoStands rs;

    /**
     * Registo de atribuições dos stands
     */
    private RegistoAtribuicoesStands ras;

    /**
     * Lista de candidaturas a exposição
     */
    private List<CandidaturaAExposicao> listCand;

    /**
     * Lista de atribuições dos stands
     */
    private List<AtribuicaoStand> listAtr;

    /**
     * Construtor de objetos do tipo AtribuirStandsController com o parametros
     * centro de exposições
     * 
     * @param centroDeExposicoes centro de exposições
     */
    public AtribuirStandsController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
        listAtr = new ArrayList<>();
    }

    /**
     * Devolve a lista de exposições
     * 
     * @return lista de exposições
     */
    public List<Exposicao> getListaExposicoes() {
        RegistoExposicoes re = m_centroDeExposicoes.getRegistoExposicoes();
        return re.getListaExposicoesEstadoCandidaturasDecididas();
    }

    /**
     * Devolve a lista de candidaturas a exposição
     * 
     * @return lista de candidaturas a exposição
     */
    public List<CandidaturaAExposicao> getListaCand() {
        this.listCand = rc.getListaCandidaturasAceites();
        return listCand;
    }

    /**
     * Devolve a lista de stands
     *
     * @return lista de stands
     */
    public List<Stand> getListaStands() {
        rs = m_centroDeExposicoes.getRegistoStands();
        return rs.getListaStands();
    }

    /**
     * Modifica a lista de atribuições
     * 
     * @param listAtr nova lista de atribuições
     */
    public void setAtribuicoes(List<AtribuicaoStand> listAtr) {
        this.listAtr.clear();
        this.listAtr.addAll(listAtr);
    }

    /**
     * Confirma aatribuição dos stands
     */
    public void confirm() {
        ras = expo.getRegistoAtribuicoesStands();
        ras.addAll(listAtr);
        for (CandidaturaAExposicao c : listCand) {
            EstadoCandidaturaAExposicao state = c.getEstado();
            state.setEstadoCandidaturaStandsAtribuidos();
        }
    }

    /**
     * Modifica a exposição seleciona e guarda o registo de candidaturas dessa 
     * exposição
     * 
     * @param expo exposição selecionada
     */
    public void select(Exposicao expo) {
        this.expo = expo;
        rc = expo.getRegistoCandidaturasAExposicao();
    }

}
