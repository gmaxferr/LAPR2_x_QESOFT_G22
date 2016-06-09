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
//            tratarFicheiro.lerDadosFicheiroTexto(centroExposicoes);
        }

        new LoginGui(centroExposicoes);
    }
}
