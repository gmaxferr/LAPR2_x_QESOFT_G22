package lapr.project.controller;

import java.util.List;
import lapr.project.model.AtribuicaoStand;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoAtribuicoesStands;
import lapr.project.registos.RegistoExposicoes;

/**
 * Representação do Controller do caso de uso - confirmar stands
 * 
 * @author Ana Leite
 */
public class ConfirmarStandsController {

    /**
     * Centro de exposições
     */
    private CentroExposicoes m_centroExpo;
    
    /**
     * Registo de exposições
     */
    private RegistoExposicoes m_RegistoExposicoes;
    
    /**
     * Registo de atribuições de stands
     */
    private RegistoAtribuicoesStands m_RegistoAtribuicoesStand;
    
    /**
     * Decisão tomada pelo representante
     */
    private boolean m_decisao;
    
    private AtribuicaoStand m_atribuicaoStand;
    /**
     * Exposicao escolhida
     */
    private Exposicao m_exposicaoEscolhida;
    
    /**
     * Constrói uma instância de ConfirmarStandsController recendo como
     * parâmentro o centro de exposições
     * 
     * @param centro_exposicoes centro de exposições
     */
    public ConfirmarStandsController(CentroExposicoes centro_exposicoes){
        this.m_centroExpo = centro_exposicoes;
    }
    
    /**
     * Guarda o registo de exposições
     */
    public void getRegistoExposicoes(){
        m_RegistoExposicoes = m_centroExpo.getRegistoExposicoes();
    }
    
    /**
     * Devolve a lista das exposições de um representante
     * 
     * @param usernameRepresentante username do representante
     * 
     * @return lista das exposições de um representante
     */
    public List<Exposicao> getListaExposicoesDoRepresentante(String usernameRepresentante){
        return m_RegistoExposicoes.getListaExposicoesComCanditaturasAceitesRepresentante(usernameRepresentante);
    }
    
    /**
     * Modifica a exposição.
     *
     * @param e nova exposição.
     */
    public void setExposicao(Exposicao e) {
        this.m_exposicaoEscolhida = e;
    }
    
    /**
     * Guarda o registo de atribuições de stand
     */
    public void getRegistoAtribuicoesStands(){
        m_RegistoAtribuicoesStand = m_exposicaoEscolhida.getRegistoAtribuicoesStands();
    }
    
    public List<AtribuicaoStand> getAtribuicao(String username){
        return m_RegistoAtribuicoesStand.getListAtribuicoesStandDoRepresentante(username);
    }
    
    public void setDecisao(boolean decisao){
        this.m_atribuicaoStand.setDecisao(decisao);
        
    }
}
