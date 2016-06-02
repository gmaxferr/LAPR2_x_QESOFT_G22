/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author guima
 */
public class CandidaturaADemonstracao {

    /**
     * Não sabemos como é constituida uma candidatura a uma demonstração, por
     * isso optamos apenas por descreve-la com uma string que representa todos
     * os possíveis atributos que esta candidtura possa ter.
     */
    private String dados;
    
    private EstadoCandidaturaADemonstracao estado;

    public CandidaturaADemonstracao(String dados) {
        this.dados = dados;
    }
    
    /**
     * @return estado desta candidatura a demonstracao
     */
    public EstadoCandidaturaADemonstracao getEstado(){
        return estado;
    }
}
