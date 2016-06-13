package lapr.project.controller;

import lapr.project.model.CentroExposicoes;

/**
 *
 * @author G29
 */
public class CriarStandsController {

    private final CentroExposicoes centroExposicoes;
    private final String usernameGestor;
    
    public CriarStandsController(CentroExposicoes ce, String username){
        this.centroExposicoes=ce;
        this.usernameGestor=username;
    }
    public void getRegistoStands(){
        
    }
}
