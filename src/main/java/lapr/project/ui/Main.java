package lapr.project.ui;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.controller.ImportarXMLController;
import lapr.project.exceptions.*;
import lapr.project.model.*;
import lapr.project.registos.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class Main {

    public static void main(String[] args) {
        CentroExposicoes centroExposicoes = null;
        MyJFileChooser.personalizarEmPortugues();

        ImportarXMLController CTRL = new ImportarXMLController();

        File properties = new File(CentroExposicoes.PROPERTIES_FILE_LOCATION);
        try {
            Scanner in = new Scanner(properties);
            boolean canceledLoad = false;

            while (in.hasNext()) {
                String[] input = in.nextLine().split("=");
                if (input[0].trim().equalsIgnoreCase("saveFileLocation")) {
                    String[] filePath = input[1].split("\".*\"");
                    if (filePath.length > 0) {
                        File file = new File(filePath[0]);
                        if (!file.exists()) {
                            break;
                        }
                        int resultVal = JOptionPane.showConfirmDialog(null, "Foi encontrada informação guardada previamente em ficheiro!"
                                + "\nDeseja carregar esta informação?", "INFO", JOptionPane.YES_NO_OPTION);

                        if (resultVal == JOptionPane.YES_OPTION) {
                            try {
                                Node node = CTRL.Import(filePath[0]);
                                if (node != null) {
                                    centroExposicoes = new CentroExposicoes();
                                    centroExposicoes.importContentFromXMLNode(node);
                                    JOptionPane.showMessageDialog(null, "Informação carregada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Erro no carregamento da informação.", "ERRO", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (FileNotFoundException | ParserConfigurationException ex) {
                                JOptionPane.showMessageDialog(null, "Erro no carregamento da informação.", "ERRO", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            canceledLoad = true;
                        }
                    }
                }
            }

            in.close();

            if (canceledLoad) {
                in.close();
                Formatter out = new Formatter(properties);
                out.flush();
                out.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.CONFIG, "Ficheiro de propriedades não existente.");
        }

        if (centroExposicoes == null) {
            JFileChooser fc = new JFileChooser();

            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                String filename = file.getAbsolutePath();
                try {
                    centroExposicoes = CTRL.importAndUpdateProperties(filename);
                    if (centroExposicoes != null) {
                        JOptionPane.showMessageDialog(null, "Informação carregada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro no carregamento da informação.", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Erro no carregamento da informação.", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
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
        JFrame frame = new LoginV2(centroExposicoes);
    }

    private static void instanciarPelaPrimeiraVez(CentroExposicoes centroExposicoes) {
        //Utilizadores
        RegistoUtilizadores ru = centroExposicoes.getRegistoUtilizadoresPendentes();
        ru.addUtilizador(new Utilizador("Ricardo", "Ricardo", "Abc-1".toCharArray(), "Ricardo@email.pt", "abcd"));
        centroExposicoes.confirmarRegistoTodosUtilizadores();
        ru = centroExposicoes.getRegistoUtilizadoresConfirmados();

        //GestorExposições
        Utilizador utilizador;
        utilizador = ru.identificarUtilizadorPeloUsername("Ricardo");
        utilizador.setIsGestor(true);

        JOptionPane.showMessageDialog(null, "Foram criados vários utilizadores para facilitar o uso do programa, tanto para testes como para avaliação. "
                + "\nCriamos um utilizador por cada membro do grupo, o seu username é o nome da pessoa e a password"
                + "\n é igual parar todos: \"Abc-1\".\n"
                + "\n"
                + "Exemplo:           Username: \"Ricardo\" e Password: \"Abc-1\".", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
}
