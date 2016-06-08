package lapr.project.registos;

import com.sun.xml.internal.bind.v2.schemagen.Util;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicaoStand;
import lapr.project.model.*;

/**
 *
 * @author Ricardo Catalao
 */
public class RegistoAtribuicoesStands {

    private List<AtribuicaoStand> m_listaAtribuicoesStand;
    
    private CentroExposicoes m_centroExposicao;
    
    public RegistoAtribuicoesStands() {
        this.m_listaAtribuicoesStand = new ArrayList<>();
    }

    /**
     * @return the listaAtribuicoesStand
     */
    public List<AtribuicaoStand> getListaAtribuicoesStand() {
        return m_listaAtribuicoesStand;
    }

    /**
     * @param listaAtribuicoesStand the listaAtribuicoesStand to set
     */
    public void setListaAtribuicoesStand(List<AtribuicaoStand> listaAtribuicoesStand) {
        this.m_listaAtribuicoesStand = listaAtribuicoesStand;
    }

    /**
     * @param listAtr Adiciona todas as atribuicoes passadas como argumento à
     * lista de atribuicoes de stands
     */
    public void addAll(List<AtribuicaoStand> listAtr) {
        m_listaAtribuicoesStand.addAll(listAtr);
    }
    
    public List<AtribuicaoStand> getListAtribuicoesStandDoRepresentante(String username){
         ArrayList<AtribuicaoStand> listaAtribuicoesStandRepresentante = new ArrayList<>();
         for(AtribuicaoStand as : m_listaAtribuicoesStand){
             for(Expositor expositor : m_centroExposicao.getListaExpositores()){
                 if(expositor.getM_strUsername().equalsIgnoreCase(username)){
                     listaAtribuicoesStandRepresentante.add(as);
                 }
             }
         }
         return listaAtribuicoesStandRepresentante;
        
    }
}
