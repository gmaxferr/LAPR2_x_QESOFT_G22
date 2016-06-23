package lapr.project.ui;

import java.awt.CardLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author G29
 */
public class JFrameExportarRankingKeywordsCSV extends javax.swing.JFrame {

    private final CardLayout cardLayout;
    private final JFrame menu;

    /**
     * Creates new form JFrameExportarRankingKeywordsCSV
     *
     * @param menu JFrame do menu principal
     */
    public JFrameExportarRankingKeywordsCSV(JFrame menu) {
        this.menu=menu;
        
        initComponents();

        alterarComportamentoFecharJFrame();
        this.cardLayout = (CardLayout) getContentPane().getLayout();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * altera o comportamento da janela ao fechar
     */
    private void alterarComportamentoFecharJFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                dispose();
                JOptionPane.showMessageDialog(rootPane, "Fechou a janela antes de terminar o processo."
                        + "\nOs dados escolhidos até ao momento não foram guardados.",
                        "Dados não guardados",
                        JOptionPane.WARNING_MESSAGE);
                menu.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
