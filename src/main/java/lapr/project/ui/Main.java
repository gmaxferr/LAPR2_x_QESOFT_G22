package lapr.project.ui;

import java.io.File;
import javax.swing.*;
import lapr.project.controller.ImportarXMLController;
import lapr.project.model.*;

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

        if (centroExposicoes == null) {
            centroExposicoes = new CentroExposicoes();
            Utilizador admin = new Utilizador("admin", "admin", "Admin-1".toCharArray(), "admin@admin.admin");
            admin.setIsExpositor();
            admin.setIsFAE();
            admin.setIsGestor();
            admin.setIsOrganizador();
            centroExposicoes.getRegistoUtilizadores().addUtilizador(admin);

            JOptionPane.showMessageDialog(null, "Foi criado um utilizador predefinido para ser possível"
                    + "\naceder ao sistema com todos os privilégios:"
                    + "\n\nUtilizador - ADMIN"
                    + "\n    username: \"admin\""
                    + "\n    password: \"Admin-1\"", "INFORMAÇÂO", JOptionPane.INFORMATION_MESSAGE);
        }

        new LoginV2(centroExposicoes);
    }
}
