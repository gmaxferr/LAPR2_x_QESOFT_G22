/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.ui.model.ComboBoxModelExposicoes;
import lapr.project.ui.model.AbstractListModelRecursos;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import lapr.project.controller.CriarDemonstracaoController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Recurso;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class JFrameCriarDemonstracaoUI extends javax.swing.JFrame {

    private static final String DESCRICAO_EXPOSICAO_POR_OMISSAO = "A apresentar a descrição da exposição selecionada";
    private static final String LOCAL_EXPOSICAO_POR_OMISSAO = "A apresentar o local de realização para a exposição selecionada";
    private static final String DATA_INICIO_E_FIM_POR_OMISSAO = "00/00/0000";

    private CriarDemonstracaoController CTRL;
    private List<Exposicao> m_listaExposicoes;
    private List<Recurso> m_listaRecursos;
    
    private String m_usernameOrg;
    private CentroExposicoes m_ce;

    private Exposicao m_e;
    private boolean continua;
    /**
     * Creates new form JFrameCriarDemonstracaoUI
     */
    public JFrameCriarDemonstracaoUI(String usernameOrg, CentroExposicoes ce) {
        CTRL = new CriarDemonstracaoController(usernameOrg, ce);
        CTRL.pullRegistosCE();
        m_listaExposicoes = CTRL.getListaExposicoesDoOrganizador();
        
        this.m_usernameOrg = usernameOrg;
        this.m_ce = ce;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtonCard1Avancar = new javax.swing.JButton();
        jLabelCard1Titulo = new javax.swing.JLabel();
        jPanelCard1DescricaoExposicao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCard1DescricaoExposicao = new javax.swing.JTextArea();
        jButtonCard1Fechar = new javax.swing.JButton();
        jPanelCard1Duracao = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelCard1DataInicio = new javax.swing.JLabel();
        jLabelCard1DataFim = new javax.swing.JLabel();
        jPanelCard1Local = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaCard1LocalExposicao = new javax.swing.JTextArea();
        jComboBoxEscolherExposicao = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        m_textAreadDescricao = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        m_listaRecursosCE = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jButtonCard1Avancar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard1Avancar.setText("Selecionar exposição");
        jButtonCard1Avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard1AvancarActionPerformed(evt);
            }
        });

        jLabelCard1Titulo.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabelCard1Titulo.setText("Escolha a exposição pretendida");
        jLabelCard1Titulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jPanelCard1DescricaoExposicao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descricao", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

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

        javax.swing.GroupLayout jPanelCard1DescricaoExposicaoLayout = new javax.swing.GroupLayout(jPanelCard1DescricaoExposicao);
        jPanelCard1DescricaoExposicao.setLayout(jPanelCard1DescricaoExposicaoLayout);
        jPanelCard1DescricaoExposicaoLayout.setHorizontalGroup(
            jPanelCard1DescricaoExposicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelCard1DescricaoExposicaoLayout.setVerticalGroup(
            jPanelCard1DescricaoExposicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButtonCard1Fechar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard1Fechar.setText("Cancelar");
        jButtonCard1Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard1FecharActionPerformed(evt);
            }
        });

        jPanelCard1Duracao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duração", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("De");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("até");

        jLabelCard1DataInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCard1DataInicio.setText("0000/00/00");

        jLabelCard1DataFim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCard1DataFim.setText("0000/00/00");

        javax.swing.GroupLayout jPanelCard1DuracaoLayout = new javax.swing.GroupLayout(jPanelCard1Duracao);
        jPanelCard1Duracao.setLayout(jPanelCard1DuracaoLayout);
        jPanelCard1DuracaoLayout.setHorizontalGroup(
            jPanelCard1DuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1DuracaoLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCard1DataInicio)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabelCard1DataFim)
                .addGap(32, 32, 32))
        );
        jPanelCard1DuracaoLayout.setVerticalGroup(
            jPanelCard1DuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1DuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jScrollPane3.setViewportView(jTextAreaCard1LocalExposicao);

        javax.swing.GroupLayout jPanelCard1LocalLayout = new javax.swing.GroupLayout(jPanelCard1Local);
        jPanelCard1Local.setLayout(jPanelCard1LocalLayout);
        jPanelCard1LocalLayout.setHorizontalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCard1LocalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
        );
        jPanelCard1LocalLayout.setVerticalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jComboBoxEscolherExposicao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxEscolherExposicao.setModel(new ComboBoxModelExposicoes(m_listaExposicoes));
        jComboBoxEscolherExposicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEscolherExposicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(244, 244, 244)
                            .addComponent(jComboBoxEscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(jLabelCard1Titulo))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jButtonCard1Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jButtonCard1Avancar))
                                .addComponent(jPanelCard1Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabelCard1Titulo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jComboBoxEscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanelCard1Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonCard1Fechar)
                                .addComponent(jButtonCard1Avancar)))
                        .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel4, "card1");
        jPanel4.getAccessibleContext().setAccessibleName("card1");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("  Criar nova demonstração  ");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Descrição:");

        m_textAreadDescricao.setColumns(20);
        m_textAreadDescricao.setRows(5);
        jScrollPane1.setViewportView(m_textAreadDescricao);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.setMaximumSize(new java.awt.Dimension(89, 25));
        jButton2.setMinimumSize(new java.awt.Dimension(89, 25));
        jButton2.setPreferredSize(new java.awt.Dimension(89, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Escreva uma descrição para a nova demonstração.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel3, "card2");
        jPanel3.getAccessibleContext().setAccessibleName("card2");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("  Criar Nova Demonstração  ");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Selecione, da lista apresentada, os recursos necessários à realização da demonstração:");

        m_listaRecursosCE.setModel(new AbstractListModelRecursos(m_listaRecursos)
        );
        jScrollPane4.setViewportView(m_listaRecursosCE);

        jButton3.setText("Adicionar Selecionados");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Confrimar e Criar Demonstração");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(15, 15, 15)
                        .addComponent(jButton4)
                        .addGap(41, 41, 41))))
        );

        getContentPane().add(jPanel1, "card3");
        jPanel1.getAccessibleContext().setAccessibleName("card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CTRL.novaDemonstracao(m_textAreadDescricao.getText());
        m_listaRecursos = CTRL.getListaDeRecursos();
        passaParaPanel3();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonCard1AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1AvancarActionPerformed
        Exposicao e = (Exposicao) jComboBoxEscolherExposicao.getSelectedItem();
        if (e != null) {
            CTRL.setExposicao(e);
            m_e = e;
            CTRL.pullRegistoDemonstracaoDaExposicao();
            passaParaPanel2();
        }
    }//GEN-LAST:event_jButtonCard1AvancarActionPerformed

    private void jButtonCard1FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1FecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCard1FecharActionPerformed

    private void jComboBoxEscolherExposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscolherExposicaoActionPerformed
        if (jComboBoxEscolherExposicao.getSelectedItem() != null) {
            Exposicao e = m_listaExposicoes.get(jComboBoxEscolherExposicao.getSelectedIndex());
            jTextAreaCard1DescricaoExposicao.setText(e.getDescricao());
            jTextAreaCard1LocalExposicao.setText(e.getLocal().getMorada());
            jLabelCard1DataInicio.setText(e.getDataInicio().toAnoMesDiaString());
            jLabelCard1DataFim.setText(e.getDataFim().toAnoMesDiaString());
        } else {
            jTextAreaCard1DescricaoExposicao.setText(DESCRICAO_EXPOSICAO_POR_OMISSAO);
            jTextAreaCard1LocalExposicao.setText(LOCAL_EXPOSICAO_POR_OMISSAO);
            jLabelCard1DataInicio.setText(DATA_INICIO_E_FIM_POR_OMISSAO);
            jLabelCard1DataFim.setText(DATA_INICIO_E_FIM_POR_OMISSAO);
        }
    }//GEN-LAST:event_jComboBoxEscolherExposicaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        passaParaPanel1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        passaParaPanel2();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int[] selected = m_listaRecursosCE.getSelectedIndices();
        List<Recurso> alreadyInList = new ArrayList();
        for (int i : selected) {
            Recurso r = m_listaRecursos.get(i);
            if (!CTRL.exists(r)) {
                CTRL.addRecurso(r);
            } else {
                alreadyInList.add(r);
            }
        }

        //numa unica JOptionPane mostra todos os recursos que já se encontravam registados
        if (!alreadyInList.isEmpty()) {
            String aux = "O(s) seguinte(s) recurso(s) já se encontra(m) na lista\n";
            for (Recurso r : alreadyInList) {
                aux += r.getNomeRecurso() + "\n";
            }
            JOptionPane.showMessageDialog(null, aux, "Atenção!", ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CTRL.setRecursos();
        if (CTRL.valida()) {
            CTRL.registaDemo();
            int opcao = JOptionPane.showConfirmDialog(null, "Demonstração registada com sucesso!", "Sucesso!", INFORMATION_MESSAGE);
            if(opcao == JOptionPane.OK_OPTION){
                CTRL = new CriarDemonstracaoController(m_usernameOrg, m_ce);
                CTRL.setExposicao(m_e);
                CTRL.pullRegistoDemonstracaoDaExposicao();
                passaParaPanel2();
            }else{
                CTRL.mudaEstado();
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro a resgistar Demonstração, veja se cometeu alguns dos seguintes erros:"
                    + "\n1.Não introduziu descrição."
                    + "\n2.Não selecionou recursos.", "Erro!", ERROR_MESSAGE);
        }
        CTRL = new CriarDemonstracaoController(m_usernameOrg, m_ce);
        passaParaPanel1();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonCard1Avancar;
    private javax.swing.JButton jButtonCard1Fechar;
    private javax.swing.JComboBox<String> jComboBoxEscolherExposicao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCard1DataFim;
    private javax.swing.JLabel jLabelCard1DataInicio;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCard1DescricaoExposicao;
    private javax.swing.JPanel jPanelCard1Duracao;
    private javax.swing.JPanel jPanelCard1Local;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaCard1DescricaoExposicao;
    private javax.swing.JTextArea jTextAreaCard1LocalExposicao;
    private javax.swing.JList<String> m_listaRecursosCE;
    private javax.swing.JTextArea m_textAreadDescricao;
    // End of variables declaration//GEN-END:variables

    private void passaParaPanel1() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card1");
        setSize(this.getSize());
    }

    private void passaParaPanel2() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card2");
        setSize(this.getSize());
    }

    private void passaParaPanel3() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card3");
        setSize(this.getSize());
    }

}
