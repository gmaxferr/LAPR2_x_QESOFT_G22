package lapr.project.ui;

import java.io.File;
import javax.swing.*;
import lapr.project.controller.ImportarXMLController;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasAbertas;
import lapr.project.exceptions.*;
import lapr.project.model.*;
import lapr.project.registos.*;
import lapr.project.utils.Data;

/**
 *
 * @author G29
 */
public class Main {

    public static void main(String[] args) {
        MyJFileChooser.personalizarEmPortugues();

        CentroExposicoes centroExposicoes = null;

        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String filename = file.getAbsolutePath();
            ImportarXMLController CTRL = new ImportarXMLController();
            centroExposicoes = CTRL.Import(filename);

            if (centroExposicoes != null) {
                JOptionPane.showMessageDialog(null, "Informação carregada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro no carregamento da informação.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            if (centroExposicoes == null) {
                centroExposicoes = new CentroExposicoes();
                instanciarPelaPrimeiraVez(centroExposicoes);
            }
        } catch (InvalidEmailException | InvalidPasswordException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Dados inválidos.", JOptionPane.WARNING_MESSAGE);

        }
        new LoginV2(centroExposicoes);
    }

    private static void instanciarPelaPrimeiraVez(CentroExposicoes centroExposicoes) {
//        //Admin
//        Utilizador admin = new Utilizador("admin", "admin", "Admin-1".toCharArray(), "admin@admin.admin");
//        admin.setIsExpositor();
//        admin.setIsFAE();
//        admin.setIsGestor();
//        admin.setIsOrganizador();
//        centroExposicoes.getRegistoUtilizadores().addUtilizador(admin);
//
//        JOptionPane.showMessageDialog(null, "Foi criado um utilizador predefinido para ser possível"
//                + "\naceder ao sistema com todos os privilégios:"
//                + "\n\nUtilizador - ADMIN"
//                + "\n    username: \"admin\""
//                + "\n    password: \"Admin-1\"", "INFORMAÇÂO", JOptionPane.INFORMATION_MESSAGE);

        //Utilizadores
        RegistoUtilizadores ru = centroExposicoes.getRegistoUtilizadores();
        ru.addUtilizador(new Utilizador("Ricardo", "Ricardo", "Abc-1".toCharArray(), "Ricardo@email.pt", "abcd"));
        ru.addUtilizador(new Utilizador("Ana", "Ana", "Abc-1".toCharArray(), "Ana@email.pt", "cheese"));
        ru.addUtilizador(new Utilizador("Joao", "Joao", "Abc-1".toCharArray(), "Joao@email.pt", "sport"));
        ru.addUtilizador(new Utilizador("Osorio", "Osorio", "Abc-1".toCharArray(), "Osorio@email.pt", "deceive"));
        ru.addUtilizador(new Utilizador("Guilherme", "Guilherme", "Abc-1".toCharArray(), "Guilherme@email.pt", "blue"));
        ru.confirmarRegistoTodosUtilizadores();

        //GestorExposições
        Utilizador utilizador;
        utilizador = ru.identificarUtilizadorPeloUsername("Ricardo");
        utilizador.setIsGestor();

        //Organizador
        utilizador = ru.identificarUtilizadorPeloUsername("Ana");
        utilizador.setIsOrganizador();

        //Exposições
        RegistoExposicoes re = centroExposicoes.getRegistoExposicoes();
        Exposicao exposicao;
        /*1*/
        exposicao = new Exposicao("Titulo", "Descricao", new Data(2016, 2, 25), new Data(2016, 3, 5), new Data(2016, 2, 5), new Data(2016, 2, 10), new Data(2016, 2, 15), new Local("Local"), centroExposicoes);
        re.registaExposicao(exposicao);
        exposicao.getEstado().setEstadoCriada();
        exposicao.getRegistoOrganizadores().addOrganizador(utilizador);

        //FAE
        RegistoFAE rf = exposicao.getRegistoFAE();
        rf.adicionaFAE(ru.identificarUtilizadorPeloUsername("Joao"));

        /*2*/
        exposicao = new Exposicao("Titulo2", "Descricao2", new Data(2016, 3, 25), new Data(2016, 4, 5), new Data(2016, 3, 5), new Data(2016, 3, 10), new Data(2016, 3, 15), new Local("Local2"), centroExposicoes);
        re.registaExposicao(exposicao);
        exposicao.setEstado(new EstadoExposicaoCandidaturasAbertas(exposicao));
        exposicao.getRegistoOrganizadores().addOrganizador(utilizador);

        JOptionPane.showMessageDialog(null, "Foram criados vários utilizadores para facilitar o uso do programa, tanto para testes como para avaliação. "
                + "\nCriamos um utilizador por cada membro do grupo, o seu username é o nome da pessoa e a password"
                + "\n é igual parar todos: \"Abc-1\".\n"
                + "\n"
                + "Exemplo:           Username: \"Ricardo\" e Password: \"Abc-1\".", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
}
