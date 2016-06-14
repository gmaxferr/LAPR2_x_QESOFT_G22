package lapr.project.ui;

import java.io.File;
import javax.swing.*;
import lapr.project.controller.ImportarXMLController;
import lapr.project.exceptions.InvalidEmailException;
import lapr.project.exceptions.InvalidPasswordException;
import lapr.project.model.*;
import lapr.project.registos.RegistoUtilizadores;

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
        ru.addUtilizador(new Utilizador("Ricardo", "Ricardo", "Abc-1".toCharArray(), "Ricardo@email.pt"));
        ru.addUtilizador(new Utilizador("Ana", "Ana", "Abc-1".toCharArray(), "Ana@email.pt"));
        ru.addUtilizador(new Utilizador("Joao", "Joao", "Abc-1".toCharArray(), "Joao@email.pt"));
        ru.addUtilizador(new Utilizador("Osorio", "Osorio", "Abc-1".toCharArray(), "Osorio@email.pt"));
        ru.addUtilizador(new Utilizador("Guilherme", "Guilherme", "Abc-1".toCharArray(), "Guilherme@email.pt"));
        ru.confirmarRegistoTodosUtilizadores();

        //GestorExposições
        Utilizador utilizador;
        utilizador = ru.identificarUtilizadorPeloUsername("Ricardo");
        utilizador.setIsGestor();

        JOptionPane.showMessageDialog(null, "Foram criados vários utilizadores para facilitar o uso do programa, tanto para testes como para avaliação. "
                + "\nCriamos um utilizador por cada membro do grupo, o seu username é o nome da pessoa e a password"
                + "\n é igual parar todos: \"Abc-1\".\n"
                + "\n"
                + "Exemplo:           Username: \"Ricardo\" e Password: \"Abc-1\".", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
}
