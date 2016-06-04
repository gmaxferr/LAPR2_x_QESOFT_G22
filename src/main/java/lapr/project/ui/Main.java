/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.MyJFileChooser;
import lapr.project.utils.FicheiroDados;

/**
 *
 * @author osori
 */
public class Main {

    public static void main(String[] args) {
        MyJFileChooser.personalizarEmPortugues();
        FicheiroDados tratarFicheiro = new FicheiroDados();
        CentroExposicoes centroExposicoes = tratarFicheiro.lerFicheiroBinario(FicheiroDados.NOME_FICHEIRO_BINARIO_PREDEFINICAO);
        if (centroExposicoes == null) {
            centroExposicoes = new CentroExposicoes();
            tratarFicheiro.lerDadosFicheiroTexto(centroExposicoes);
        }

        new LoginGui(centroExposicoes);
    }
}
