/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class EstadoExposicaoDemonstracoesDecididas extends EstadoExposicao{
    
    public EstadoExposicaoDemonstracoesDecididas(Exposicao exposicao) {
        super(exposicao);
    }
    
    @Override
    public boolean setEstadoDemosDecididas(){
        return true;
    }
    
    @Override
    public boolean isEstadoDemosDecididas(){
        return true;
    }
    
}
