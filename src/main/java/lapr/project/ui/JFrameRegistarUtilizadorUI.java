package lapr.project.ui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr.project.controller.RegistarUtilizadorController;
import lapr.project.exceptions.InvalidEmailException;
import lapr.project.exceptions.InvalidPasswordException;
import lapr.project.model.*;

/**
 *
 * @author G29
 */
public class JFrameRegistarUtilizadorUI extends javax.swing.JFrame {

    private JFrame jFrameLogin;
    private CentroExposicoes centroExposicoesAtual;
    private RegistarUtilizadorController controller;
    private Utilizador u;

    private static final int LARGURA_JANELA_PASSO1 = 470;
    private static final int ALTURA_JANELA_PASSO1 = 420;

    private static final int LARGURA_JANELA_PASSO2 = 460;
    private static final int ALTURA_JANELA_PASSO2 = 340;

    /**
     * Creates new form JFrameRegistarUtilizadorUI
     *
     * @param jFrameLogin
     * @param centroExposicoes
     */
    public JFrameRegistarUtilizadorUI(JFrame jFrameLogin, CentroExposicoes centroExposicoes) {
        super("Registar Utilizador");
        this.jFrameLogin = jFrameLogin;
        this.centroExposicoesAtual = centroExposicoes;
        this.controller = new RegistarUtilizadorController(centroExposicoes);
        controller.getRegistoUtilizadores();
        u = controller.novoUtilizador();
        initComponents();

        alterarComportamentoFecharJFrame();

        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
        setVisible(true);
    }

    private void alterarComportamentoFecharJFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                jFrameLogin.setVisible(true);
                dispose();
                JOptionPane.showMessageDialog(rootPane, "Fechou a janela antes de terminar o processo."
                        + "\nOs dados escolhidos até ao momento não foram guardados.",
                        "Dados não guardados",
                        JOptionPane.WARNING_MESSAGE);
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

        card1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        card2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        card1.setPreferredSize(new java.awt.Dimension(547, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Introduza os dados necessários");

        jPanel2.setPreferredSize(new java.awt.Dimension(444, 200));

        jLabel2.setText("Nome");

        jLabel3.setText("Email");

        jLabel4.setText("Username");

        jLabel5.setText("Password");

        jTextField1.setToolTipText("");

        jLabel15.setText("Reintroduza a password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPasswordField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleName("jLabelCard1Nome");
        jLabel3.getAccessibleContext().setAccessibleName("JLabelCard1Email");
        jLabel4.getAccessibleContext().setAccessibleName("jLabelCard1Username");
        jLabel5.getAccessibleContext().setAccessibleName("JLabelCard1Password");
        jTextField1.getAccessibleContext().setAccessibleName("jTextFieldCard1Nome");
        jTextField2.getAccessibleContext().setAccessibleName("jTextFieldCard2Email");
        jTextField3.getAccessibleContext().setAccessibleName("jTextFieldCard1Username");
        jPasswordField3.getAccessibleContext().setAccessibleName("JPasswordFieldCard1ReintroduzirPassword");
        jLabel15.getAccessibleContext().setAccessibleName("jLabelCard1ReintroduzaAPassword");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Avançar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(27, 27, 27))
        );

        jButton1.getAccessibleContext().setAccessibleName("jButtonCard1Recuar");
        jButton2.getAccessibleContext().setAccessibleName("jButtonCard1Avançar");

        getContentPane().add(card1, "card1");

        jLabel6.setFont(jLabel1.getFont());
        jLabel6.setText("Confirme os dados ");

        jPanel4.setPreferredSize(new java.awt.Dimension(444, 200));

        jLabel7.setText("Nome");

        jLabel8.setText("Email");

        jLabel9.setText("Username");

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Apresentar o nome do utilizador");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Apresentar o email do utilizador");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Apresentar o username do utilizador");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel7.getAccessibleContext().setAccessibleName("jLabelCard2Nome");
        jLabel8.getAccessibleContext().setAccessibleName("jLabelCard2Email");
        jLabel9.getAccessibleContext().setAccessibleName("jLabelCard2Username");
        jLabel11.getAccessibleContext().setAccessibleName("jLabelCard2NomeApresentar");
        jLabel12.getAccessibleContext().setAccessibleName("jLabelCard2EmailApresentar");
        jLabel13.getAccessibleContext().setAccessibleName("jLabelCard2UsernameApresentar");

        jButton3.setText("Recuar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Confirma");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel6))
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jLabel6.getAccessibleContext().setAccessibleName("jLabelCard2Titulo");
        jButton3.getAccessibleContext().setAccessibleName("jButtonCard2Recuar");
        jButton4.getAccessibleContext().setAccessibleName("jButtonCard2Confirma");

        getContentPane().add(card2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        this.jFrameLogin.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean validarPasswordIguais(char[] jPasswordField3, char[] jPasswordField2) {

        if (jPasswordField3.length == jPasswordField2.length) {
            for (int i = 0; i < jPasswordField3.length; i++) {
                if (jPasswordField3[i] != jPasswordField2[i]) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controller.setDados(jTextField1.getText(), jTextField2.getText(), jPasswordField3.getPassword(), jTextField3.getText());
        boolean valido = validarPasswordIguais(jPasswordField3.getPassword(), jPasswordField2.getPassword());
        try {
            if (controller.validaUtilizador(jTextField1.getText(), jTextField2.getText(), jPasswordField3.getPassword(), jTextField3.getText()) == true && valido == true) {
                avancarParaCard2();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados inválidos!", "Dados Inválidos", JOptionPane.WARNING_MESSAGE);
            }
        } catch (InvalidPasswordException  | InvalidEmailException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Dados inválidos.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card1");
        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        controller.setDados(jTextField1.getText(), jTextField2.getText(), jPasswordField3.getPassword(), jTextField3.getText());
        try {
            if (controller.addUtilizador(u) == false) {
                JOptionPane.showMessageDialog(rootPane, "Dados já existentes. Insira novos dados!", "Dados já existentes.", JOptionPane.WARNING_MESSAGE);
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "card1");
                setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Utilizador registado com sucesso!", "Registo com sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (InvalidEmailException | InvalidPasswordException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Dados inválidos.", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void avancarParaCard2() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card2");
        setSize(LARGURA_JANELA_PASSO2, ALTURA_JANELA_PASSO2);
        apresentaOsDadosIntroduzidosAnteriormentePeloUtilizador();
    }

    private void apresentaOsDadosIntroduzidosAnteriormentePeloUtilizador() {
        jLabel11.setText(jTextField1.getText());
        jLabel12.setText(jTextField2.getText());
        jLabel13.setText(jTextField3.getText());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
