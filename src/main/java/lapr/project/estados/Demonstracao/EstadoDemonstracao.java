/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Demonstracao;

import lapr.project.estados.Estado;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public interface EstadoDemonstracao extends Estado{

    public boolean setEstadoDemonstracaoPendente();

    public boolean setEstadoDemonstracaoConfirmada();

    public boolean setEstadoDemonstracaoCancelada();
    
    public boolean setEstadoDemonstracaoCandidaturasAtribuidas();

    public boolean setEstadoDemonstracaoCandidaturasAvaliadas();
    
    public boolean setEstadoDemonstracaoCandidaturasDecididas();
    
    public boolean setEstadoDemonstracaoCandidaturasAbertas();
    
    public boolean setEstadoDemonstracaoCandidaturasFechadas();
    
    public boolean isEstadoDemonstracaoPendente();

    public boolean isEstadoDemonstracaoConfirmada();

    public boolean isEstadoDemonstracaoCancelada();
    
    public boolean isEstadoDemonstracaoCandidaturasAtribuidas();

    public boolean isEstadoDemonstracaoCandidaturasAvaliadas();
    
    public boolean isEstadoDemonstracaoCandidaturasDecididas();
    
    public boolean isEstadoDemonstracaoCandidaturasAbertas();
    
    public boolean isEstadoDemonstracaoCandidaturasFechadas();
}
