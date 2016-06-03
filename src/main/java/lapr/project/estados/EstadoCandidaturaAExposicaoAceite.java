/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados;

import lapr.project.model.CandidaturaAExposicao;


/**
 *
 * @author osori
 */
public class EstadoCandidaturaAExposicaoAceite implements EstadoCandidaturaAExposicao {

    private CandidaturaAExposicao cand;

    public EstadoCandidaturaAExposicaoAceite(CandidaturaAExposicao cand) {
        this.cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {

        return false;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosAtribuidos() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaAvaliada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAceite() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaRejeitada() {
        return false;
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return false;
    }

    @Override
    public boolean isEstadoConflitosDetetados() {
        return false;
    }

    @Override
    public boolean isEstadoConflitosAtribuidos() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAceite() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaRejeitada() {
        return false;
    }    

    @Override
    public boolean setEstadoCandidaturaRemovida() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaRemovida() {
        return false;
    }

}
