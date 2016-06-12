package lapr.project.model;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/**
 * 
 * @author G29
 */
public class MyJFileChooser extends JFileChooser {

    /**
     * Construtor de objectos do tipo MyFileChooser
     */
    public MyJFileChooser() {
        super();
        definirFiltroExtensaoBin();
    }

    /**
     * Define a extensão obrigatória a ser lida pelos ficheiros importados
     */
    private void definirFiltroExtensaoBin() {
        setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }
                String extensao = extensao(file);
                if (extensao != null) {
                    return extensao.equals("bin");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "*.bin";
            }

            private String extensao(File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf(".");
                if (i != -1) {
                    ext = s.substring(i + 1).toLowerCase();
                }
                return ext;
            }
        });
    }

    /**
     * Define o texto a apresentar nas diversas caixas de opção. Pode ser visto
     * como aplicar uma tradução
     */
    public static void personalizarEmPortugues() {

        // Títulos das Caixas de Diálogo
        UIManager.put("FileChooser.openDialogTitleText", "Importar dados");
        UIManager.put("FileChooser.saveDialogTitleText", "Exportar dados");

        // Botão "Importar"
        UIManager.put("FileChooser.openButtonText", "Importar");
        UIManager.put("FileChooser.openButtonToolTipText", "Importar dados");

        // Botão "Exportar"
        UIManager.put("FileChooser.saveButtonText", "Guardar");
        UIManager.put("FileChooser.saveButtonToolTipText", "Guardar dados");

        // Botão "Cancelar"
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");

        // Legenda "Procurar em:"
        UIManager.put("FileChooser.lookInLabelText", "Procurar em:");

        // Legenda "Guardar em:"
        UIManager.put("FileChooser.saveInLabelText", "Guardar em:");

        // Legenda "Tipo de ficheiros:"
        UIManager.put("FileChooser.filesOfTypeLabelText", "Ficheiros do tipo:");

        // Legenda "Nome do ficheiro:"
        UIManager.put("FileChooser.fileNameLabelText", "Nome do ficheiro:");

        // Filtro "Todos os Ficheiros"
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os Ficheiros");

        // Botão "Um nível acima"
        UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");

        // Botão "Nova Pasta"
        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");

        // Botão "Vista Lista"
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");

        // Botão "Vista Detalhada"
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");

    }

}
