package lapr.project.ui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr.project.controller.ConfirmarRegistoController;
import lapr.project.model.*;
import lapr.project.uiModel.ComboBoxModelUtilizadores;

/**
 *
 * @author G29
 */
public class JFrameConfirmarRegistoUtilizadorUI extends javax.swing.JFrame {

    /**
     * JFrame do Login. Usada para a voltar a tornar visivél no fim deste UC
     */
    private transient JFrame jFrameLogin;

    /**
     * Centro de exposições
     */
    private transient CentroExposicoes centroExposicoesAtual;

    /**
     * Controller deste UC
     */
    private transient ConfirmarRegistoController controller;

    /**
     * Lista de Utilizadores
     */
    private transient List<Utilizador> listaUtilizadores;

    /**
     * CardLayout usado na UI que permite a troca entre JPanels e simplificação
     * da UI para o utilizador
     */
    private final CardLayout cardLayout;

    private static final int LARGURA_JANELA_PASSO1 = 485;
    private static final int ALTURA_JANELA_PASSO1 = 400;

    /**
     * Nome do utilizador por omissão
     */
    private static final String NOME_POR_OMISSAO = "Nome do utilizador";

    /**
     * Email do utilizador por omissão
     */
    private static final String EMAIL_POR_OMISSAO = "Email do utilizador";

    /**
     * Username do utilizador por omissão
     */
    private static final String USERNAME_POR_OMISSAO = "Username do utilizador";

    /**
     * Creates new form JFrameConfirmarRegistoUtilizadorUI
     */
    public JFrameConfirmarRegistoUtilizadorUI(JFrame jFrameLogin, CentroExposicoes centroExposicoes) {
        super("Confirmar Registo de Utilizador");
        this.jFrameLogin = jFrameLogin;
        this.centroExposicoesAtual = centroExposicoes;
        this.controller = new ConfirmarRegistoController(centroExposicoes);
        controller.getRegistoUtilizadores();
        listaUtilizadores = controller.getListaNovosRegistos();
        initComponents();

        alterarComportamentoFecharJFrame();

        this.JComboBoxEscolherUtilizador.setSelectedIndex(0);
        this.cardLayout = (CardLayout) getContentPane().getLayout();
        setLocationRelativeTo(null);
        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
        setVisible(true);
    }

    /**
     * Altera o comportamente de clicar no botão de fechar nesta janela
     */
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

        Card1 = new javax.swing.JPanel();
        jLabelCard1Titulo = new javax.swing.JLabel();
        JComboBoxEscolherUtilizador = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabelCard1Titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCard1Titulo.setText("Escolha o utilizador pretendido");

        JComboBoxEscolherUtilizador.setModel(new ComboBoxModelUtilizadores(this.listaUtilizadores));
        JComboBoxEscolherUtilizador.setToolTipText("");
        JComboBoxEscolherUtilizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxEscolherUtilizadorActionPerformed(evt);
            }
        });

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

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Registar confirmação");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Card1Layout = new javax.swing.GroupLayout(Card1);
        Card1.setLayout(Card1Layout);
        Card1Layout.setHorizontalGroup(
            Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card1Layout.createSequentialGroup()
                .addGroup(Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Card1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(JComboBoxEscolherUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Card1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCard1Titulo)))
                    .addGroup(Card1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        Card1Layout.setVerticalGroup(
            Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelCard1Titulo)
                .addGap(18, 18, 18)
                .addComponent(JComboBoxEscolherUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabelCard1Titulo.getAccessibleContext().setAccessibleName("JLabelCard1Titulo");
        JComboBoxEscolherUtilizador.getAccessibleContext().setAccessibleName("JComboBoxCard1Utilizadores");

        getContentPane().add(Card1, "card5");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controller.setUtilizadorRegistado(listaUtilizadores.get(JComboBoxEscolherUtilizador.getSelectedIndex()));
        JOptionPane.showMessageDialog(rootPane, "Registo confirmado.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        this.listaUtilizadores = controller.getListaNovosRegistos();
        if (listaUtilizadores.size() > 0) {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja confirmar outro utilizador?", "Confirmação de novo registo", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                voltarASelecionarUtilizador();
            } else {
                terminarUC();
            }
        } else {
            terminarUC();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void voltarASelecionarUtilizador() {
        cardLayout.show(getContentPane(), "card1");
        this.JComboBoxEscolherUtilizador.setSelectedIndex(0);
        this.JComboBoxEscolherUtilizador.revalidate();
        this.JComboBoxEscolherUtilizador.repaint();
        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
    }

    private void terminarUC() {
        dispose();
        jFrameLogin.setVisible(true);
    }

    private void JComboBoxEscolherUtilizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxEscolherUtilizadorActionPerformed
        if (JComboBoxEscolherUtilizador.getSelectedItem() != null) {
            Utilizador utilizador = listaUtilizadores.get(JComboBoxEscolherUtilizador.getSelectedIndex());
            jLabel11.setText(utilizador.getNome());
            jLabel12.setText(utilizador.getEmail());
            jLabel13.setText(utilizador.getUsername());
        } else {
            jLabel11.setText(NOME_POR_OMISSAO);
            jLabel12.setText(EMAIL_POR_OMISSAO);
            jLabel13.setText(USERNAME_POR_OMISSAO);
        }
    }//GEN-LAST:event_JComboBoxEscolherUtilizadorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        this.jFrameLogin.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Card1;
    private javax.swing.JComboBox<String> JComboBoxEscolherUtilizador;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
