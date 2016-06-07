package lapr.project.controller;

import java.util.List;
import lapr.project.model.AtribuicaoStand;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Stand;
import lapr.project.registos.RegistoAtribuicoesStands;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoStands;

/**
 *
 * @author Ricardo Catalao
 */
public class AtribuirStandsController {

    private final CentroExposicoes m_centroDeExposicoes;
    
    private Exposicao expo;
    private RegistoCandidaturasAExposicao rc;
    private RegistoStands rs;
    private RegistoAtribuicoesStands ras;
    
    private List<AtribuicaoStand> listAtr;
    
    public AtribuirStandsController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }
    
    public List<Exposicao> getListaExposicoes(){
        RegistoExposicoes re = m_centroDeExposicoes.getRegistoExposicoes();
        return re.getListaExposicoesEstadoCandidaturasDecididas();
    }
    
    public void select(Exposicao expo){
        expo = expo;
        rc = expo.getRegistoCandidaturasAExposicao();
    }
    
    public List<CandidaturaAExposicao> getListaCand(){
        return rc.getListaCandidaturasAceites();
    }
    
    public List<Stand> getListaStands(){
        rs = expo.getRegistoStands();
        return rs.getListaStands();
    }
    
    public void setAtribuicoes(List<AtribuicaoStand> listAtr){
        this.listAtr.clear();
        this.listAtr.addAll(listAtr);
    }
    
    public void confirm(){
        ras = expo.getRegistoAtribuicoesStands();
        ras.addAll(listAtr);
    }
}
