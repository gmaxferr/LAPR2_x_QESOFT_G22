/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados;

import classesREMOVIDAS.Exposicao;

/**
 *
 * @author osori
 */
public class EstadoExposicaoInicial implements EstadoExposicao {

    private final Exposicao exposicao;

    public EstadoExposicaoInicial(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

    @Override
    public boolean setEstadoCriada() {
        //validação se pode passar para o próximo passo
        if (valida()) {
            this.exposicao.setEstado(new EstadoExposicaoCriada(this.exposicao));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setEstadoFAEDefinidosSemDemos() {
        return false;
    }

    @Override
    public boolean setEstadoDemosDefinidasSemFAE() {
        return false;
    }

    @Override
    public boolean setEstadoCompleta() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasFechadas() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return true;
    }

    @Override
    public boolean setEstadoConflitosAlterados() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAtribuidas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAvaliadas() {
        return false;
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }
}
