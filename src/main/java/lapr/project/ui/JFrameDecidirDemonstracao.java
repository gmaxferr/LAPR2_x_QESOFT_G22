/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr.project.controller.DecidirDemonstracaoController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class JFrameDecidirDemonstracao extends javax.swing.JFrame {

    private DecidirDemonstracaoController ctrl;
    private CentroExposicoes ce;
    private String username;
    private List<Exposicao> listaExposicoes;
    private List<Demonstracao> lstDemos;
    private boolean[] decisoes;
    private Exposicao expoSelecionada;
    private final JFrame janelaMae;
    private CardLayout cardLayout;

    private static final int LARGURA_JANELA_PASSO1 = 700;
    private static final int ALTURA_JANELA_PASSO1 = 390;

    private static final int LARGURA_JANELA_PASSO2 = 850;
    private static final int ALTURA_JANELA_PASSO2 = 600;

    /**
     * Creates new form JFrameDecidirCandidatura
     */
    public JFrameDecidirDemonstracao(CentroExposicoes ce, String username, JFrame menuPrincipal) {
        this.ce = ce;
        this.username = username;
        this.listaExposicoes = ce.getRegistoExposicoes().getlistaExposicoesDoOrganizadorComDemos(username);
        this.ctrl = new DecidirDemonstracaoController(ce, username);
        this.lstDemos = ctrl.setExposicao(expoSelecionada);
        this.janelaMae = menuPrincipal;
        initComponents();
        alterarComportamentoFecharJFrame();
        this.cardLayout = (CardLayout) getContentPane().getLayout();
        setVisible(true);
        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
    }

    private void alterarComportamentoFecharJFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                setVisible(false);
                JOptionPane.showMessageDialog(rootPane, "Fechou a janela antes de terminar o processo."
                        + "\nOs dados escolhidos até ao momento não foram guardados.",
                        "Dados não guardados",
                        JOptionPane.WARNING_MESSAGE);
                janelaMae.setVisible(true);
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
        jButtonCard1Avancar = new javax.swing.JButton();
        jButtonCard1Fechar = new javax.swing.JButton();
        jPanelCard1DescricaoExposicao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCard1DescricaoExposicao = new javax.swing.JTextArea();
        jPanelCard1Duracao = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelCard1DataInicio = new javax.swing.JLabel();
        jLabelCard1DataFim = new javax.swing.JLabel();
        jPanelCard1Local = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaCard1LocalExposicao = new javax.swing.JTextArea();
        jComboBoxCard1EscolherExposicao = new javax.swing.JComboBox<>();
        Card2 = new javax.swing.JPanel();
        confirmBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDemonstracoes = new javax.swing.JTable();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelCard1Titulo.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabelCard1Titulo.setText("Escolha a exposição pretendida");
        jLabelCard1Titulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButtonCard1Avancar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard1Avancar.setText("Selecionar exposição");
        jButtonCard1Avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard1AvancarActionPerformed(evt);
            }
        });

        jButtonCard1Fechar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard1Fechar.setText("Cancelar");
        jButtonCard1Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard1FecharActionPerformed(evt);
            }
        });

        jPanelCard1DescricaoExposicao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descricao", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanelCard1DescricaoExposicao.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(null);
        jScrollPane2.setRequestFocusEnabled(false);

        jTextAreaCard1DescricaoExposicao.setEditable(false);
        jTextAreaCard1DescricaoExposicao.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextAreaCard1DescricaoExposicao.setColumns(20);
        jTextAreaCard1DescricaoExposicao.setLineWrap(true);
        jTextAreaCard1DescricaoExposicao.setRows(5);
        jTextAreaCard1DescricaoExposicao.setText("A apresentar a descrição da demonstração selecionada");
        jTextAreaCard1DescricaoExposicao.setToolTipText("");
        jTextAreaCard1DescricaoExposicao.setWrapStyleWord(true);
        jTextAreaCard1DescricaoExposicao.setBorder(null);
        jScrollPane2.setViewportView(jTextAreaCard1DescricaoExposicao);

        jPanelCard1DescricaoExposicao.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanelCard1Duracao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duração", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("De");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("até");

        jLabelCard1DataInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCard1DataInicio.setText("00/00/0000");

        jLabelCard1DataFim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCard1DataFim.setText("00/00/0000");

        javax.swing.GroupLayout jPanelCard1DuracaoLayout = new javax.swing.GroupLayout(jPanelCard1Duracao);
        jPanelCard1Duracao.setLayout(jPanelCard1DuracaoLayout);
        jPanelCard1DuracaoLayout.setHorizontalGroup(
            jPanelCard1DuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1DuracaoLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCard1DataInicio)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabelCard1DataFim)
                .addGap(32, 32, 32))
        );
        jPanelCard1DuracaoLayout.setVerticalGroup(
            jPanelCard1DuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1DuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelCard1DataInicio)
                .addComponent(jLabelCard1DataFim))
        );

        jPanelCard1Local.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Local", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jScrollPane3.setBorder(null);

        jTextAreaCard1LocalExposicao.setEditable(false);
        jTextAreaCard1LocalExposicao.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        jTextAreaCard1LocalExposicao.setColumns(20);
        jTextAreaCard1LocalExposicao.setLineWrap(true);
        jTextAreaCard1LocalExposicao.setRows(5);
        jTextAreaCard1LocalExposicao.setText("A apresentar o local da exposição selecionada");
        jTextAreaCard1LocalExposicao.setWrapStyleWord(true);
        jTextAreaCard1LocalExposicao.setBorder(null);
        jScrollPane3.setViewportView(jTextAreaCard1LocalExposicao);

        javax.swing.GroupLayout jPanelCard1LocalLayout = new javax.swing.GroupLayout(jPanelCard1Local);
        jPanelCard1Local.setLayout(jPanelCard1LocalLayout);
        jPanelCard1LocalLayout.setHorizontalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelCard1LocalLayout.setVerticalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        );

        jComboBoxCard1EscolherExposicao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxCard1EscolherExposicao.setModel(new ComboBoxModelExposicoes(this.listaExposicoes));
        jComboBoxCard1EscolherExposicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCard1EscolherExposicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Card1Layout = new javax.swing.GroupLayout(Card1);
        Card1.setLayout(Card1Layout);
        Card1Layout.setHorizontalGroup(
            Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card1Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jComboBoxCard1EscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Card1Layout.createSequentialGroup()
                .addGroup(Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Card1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabelCard1Titulo))
                    .addGroup(Card1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Card1Layout.createSequentialGroup()
                                .addComponent(jButtonCard1Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButtonCard1Avancar))
                            .addComponent(jPanelCard1Local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        Card1Layout.setVerticalGroup(
            Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCard1Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxCard1EscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Card1Layout.createSequentialGroup()
                        .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelCard1Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCard1Fechar)
                            .addComponent(jButtonCard1Avancar))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        confirmBtn.setText("Confirmar");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setText("Decidir Demonstrações");

        tabelaDemonstracoes.setModel(new ModeloJTableDecidirDemonstracoes(lstDemos, decisoes));
        jScrollPane1.setViewportView(tabelaDemonstracoes);

        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Card2Layout = new javax.swing.GroupLayout(Card2);
        Card2.setLayout(Card2Layout);
        Card2Layout.setHorizontalGroup(
            Card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 847, Short.MAX_VALUE)
            .addGroup(Card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Card2Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(Card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Card2Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel1))
                        .addGroup(Card2Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addGroup(Card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(49, Short.MAX_VALUE)))
        );
        Card2Layout.setVerticalGroup(
            Card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(Card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Card2Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(Card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(Card2Layout.createSequentialGroup()
                            .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.janelaMae.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        int op1 = JOptionPane.showConfirmDialog(null, "Confirma as suas decisões?", "Confirma?", JOptionPane.YES_NO_CANCEL_OPTION);
        switch (op1) {
            case 0:
                ctrl.registarDecisoes();
                JOptionPane.showMessageDialog(null, "Decisões Registadas");
                int op2 = JOptionPane.showConfirmDialog(null, "Pretende selecionar uma nova exposição?", "Nova exposição?", JOptionPane.YES_NO_OPTION);
                if (op2 == 0) {
                    voltarParaCard1();
                } else {
                    janelaMae.setVisible(true);
                }
            case 1:
                int op3 = JOptionPane.showConfirmDialog(null, "Pretende selecionar uma nova exposição?", "Nova exposição?", JOptionPane.YES_NO_CANCEL_OPTION);
                switch (op3) {
                    case 0:
                        voltarParaCard1();

                    case 1:
                        janelaMae.setVisible(true);
                }
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void jButtonCard1AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1AvancarActionPerformed
        if (jComboBoxCard1EscolherExposicao.getSelectedItem() != null) {
            avancarParaCard2();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma exposição primeiro!", "Exposição em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard1AvancarActionPerformed

    private void jButtonCard1FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1FecharActionPerformed
        dispose();
        this.janelaMae.setVisible(true);
    }//GEN-LAST:event_jButtonCard1FecharActionPerformed

    private void jComboBoxCard1EscolherExposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCard1EscolherExposicaoActionPerformed
        if (jComboBoxCard1EscolherExposicao.getSelectedItem() != null) {
            Exposicao expo = listaExposicoes.get(jComboBoxCard1EscolherExposicao.getSelectedIndex());
            jTextAreaCard1DescricaoExposicao.setText(expo.getDescricao());
            jTextAreaCard1LocalExposicao.setText(expo.getLocal().getMorada());
            jLabelCard1DataInicio.setText(expo.getDataInicio().toAnoMesDiaString());
            jLabelCard1DataFim.setText(expo.getDataFim().toAnoMesDiaString());
        }
    }//GEN-LAST:event_jComboBoxCard1EscolherExposicaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Card1;
    private javax.swing.JPanel Card2;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton jButtonCard1Avancar;
    private javax.swing.JButton jButtonCard1Fechar;
    private javax.swing.JComboBox<String> jComboBoxCard1EscolherExposicao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCard1DataFim;
    private javax.swing.JLabel jLabelCard1DataInicio;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JPanel jPanelCard1DescricaoExposicao;
    private javax.swing.JPanel jPanelCard1Duracao;
    private javax.swing.JPanel jPanelCard1Local;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaCard1DescricaoExposicao;
    private javax.swing.JTextArea jTextAreaCard1LocalExposicao;
    private javax.swing.JTable tabelaDemonstracoes;
    // End of variables declaration//GEN-END:variables

    private void avancarParaCard2() {
        ctrl.setExposicao(listaExposicoes.get(jComboBoxCard1EscolherExposicao.getSelectedIndex()));
        cardLayout.show(getContentPane(), "Card2");
        setSize(LARGURA_JANELA_PASSO2, ALTURA_JANELA_PASSO2);
    }

    private void voltarParaCard1() {
        cardLayout.show(getContentPane(), "Card1");
    }
}
