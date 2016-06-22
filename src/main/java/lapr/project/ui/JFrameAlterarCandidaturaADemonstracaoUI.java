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
import lapr.project.controller.AlterarCandidaturaDemonstracaoController;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.ui.model.ComboBoxModelExposicoes;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class JFrameAlterarCandidaturaADemonstracaoUI extends javax.swing.JFrame {

    private transient final JFrame jFrameMenuPrincipal;
    private transient final JFrame thisFrame;
    private transient String emailExpositor;
    private transient Exposicao m_expo;
    private transient final List<Exposicao> m_listaExposicoes;
    private transient List<CandidaturaADemonstracao> m_listaCandidaturas;

    private CandidaturaADemonstracao m_candidatura;
    private AlterarCandidaturaDemonstracaoController controller;

    private static final String DESCRICAO_EXPOSICAO_POR_OMISSAO = "A apresentar a descrição da esposição selecionada";
    private static final String LOCAL_EXPOSICAO_POR_OMISSAO = "A apresentar o local de realização da exposição selecionada";
    private static final String DATA_INICIO_E_FIM_POR_OMISSAO = "00/00/0000";

    /**
     * Creates new form JFrameAlterarCandidaturaADemonstracaoUI
     */
    public JFrameAlterarCandidaturaADemonstracaoUI(CentroExposicoes ce, String email, JFrame janelaMae) {
        this.emailExpositor = email;
        this.jFrameMenuPrincipal = janelaMae;
        this.m_listaExposicoes = ce.getRegistoExposicoes().getExposicoesDoRepresentanteCandidaturasAbertas(emailExpositor);
        this.thisFrame = this;
        initComponents();
        alterarComportamentoFecharJFrame();
        setVisible(true);
    }

    private void alterarComportamentoFecharJFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                setVisible(false);
                JOptionPane.showMessageDialog(rootPane, "Fechou a janela antes de terminar o processo."
                        + "\nOs dados escolhidos até ao momento não foram guardados.",
                        "Dados não guardados",
                        JOptionPane.WARNING_MESSAGE);
                jFrameMenuPrincipal.setVisible(true);
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
        jLabelCard1Titulo1 = new javax.swing.JLabel();
        jButtonCard1Avancar1 = new javax.swing.JButton();
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
        card2 = new javax.swing.JPanel();
        jComboBoxCandidaturas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigoDemonstracaoTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dadosCandTxt = new javax.swing.JTextArea();
        confirmarCandBtn = new javax.swing.JButton();
        voltarCard1btn = new javax.swing.JButton();
        card3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaCard3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabelCard1Titulo1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabelCard1Titulo1.setText("Escolha a exposição pretendida");
        jLabelCard1Titulo1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButtonCard1Avancar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard1Avancar1.setText("Selecionar exposição");
        jButtonCard1Avancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard1Avancar1ActionPerformed(evt);
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
        jComboBoxCard1EscolherExposicao.setModel(new ComboBoxModelExposicoes(this.m_listaExposicoes));
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
                        .addComponent(jLabelCard1Titulo1))
                    .addGroup(Card1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Card1Layout.createSequentialGroup()
                                .addComponent(jButtonCard1Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButtonCard1Avancar1))
                            .addComponent(jPanelCard1Local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        Card1Layout.setVerticalGroup(
            Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCard1Titulo1)
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
                            .addComponent(jButtonCard1Avancar1))
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(Card1, "card1");

        jComboBoxCandidaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCandidaturasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Selecione a candidatura que pretende alterar:");

        jLabel4.setText("Demonstração:");

        codigoDemonstracaoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoDemonstracaoTxtActionPerformed(evt);
            }
        });

        jLabel5.setText("Dados da candidatura:");

        dadosCandTxt.setColumns(20);
        dadosCandTxt.setRows(5);
        jScrollPane1.setViewportView(dadosCandTxt);

        confirmarCandBtn.setText("Confirmar");
        confirmarCandBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarCandBtnActionPerformed(evt);
            }
        });

        voltarCard1btn.setText("Voltar");
        voltarCard1btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarCard1btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(card2Layout.createSequentialGroup()
                                .addComponent(jComboBoxCandidaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(codigoDemonstracaoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(card2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(voltarCard1btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(confirmarCandBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))))
                .addGap(109, 109, 109))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCandidaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(codigoDemonstracaoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmarCandBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(voltarCard1btn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );

        getContentPane().add(card2, "card2");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Alteração de Candidatura a Demonstração  ");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Insira os novos dados:");

        jButton8.setText("Submeter");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Cancel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Voltar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel10.setText("Novos Dados de Candidatura:");

        textAreaCard3.setColumns(20);
        textAreaCard3.setRows(5);
        jScrollPane4.setViewportView(textAreaCard3);

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, card3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGap(11, 11, 11)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(card3, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCard1Avancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1Avancar1ActionPerformed
        if (jComboBoxCard1EscolherExposicao.getSelectedItem() != null) {
            avancarParaCard2();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma exposição primeiro!", "Exposição em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard1Avancar1ActionPerformed

    private void avancarParaCard2() {
        m_expo = m_listaExposicoes.get(jComboBoxCard1EscolherExposicao.getSelectedIndex());
        controller = new AlterarCandidaturaDemonstracaoController(emailExpositor, m_expo);
        m_listaCandidaturas = controller.getCandidaturasRepresentante();
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card2");
    }

    private void jButtonCard1FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1FecharActionPerformed
        dispose();
        this.jFrameMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButtonCard1FecharActionPerformed

    private void jComboBoxCard1EscolherExposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCard1EscolherExposicaoActionPerformed
        if (jComboBoxCard1EscolherExposicao.getSelectedItem() != null) {
            Exposicao expo = m_listaExposicoes.get(jComboBoxCard1EscolherExposicao.getSelectedIndex());
            jTextAreaCard1DescricaoExposicao.setText(expo.getDescricao());
            jTextAreaCard1LocalExposicao.setText(expo.getLocal().getMorada());
            jLabelCard1DataInicio.setText(expo.getDataInicio().toAnoMesDiaString());
            jLabelCard1DataFim.setText(expo.getDataFim().toAnoMesDiaString());
        } else {
            jTextAreaCard1DescricaoExposicao.setText(DESCRICAO_EXPOSICAO_POR_OMISSAO);
            jTextAreaCard1LocalExposicao.setText(LOCAL_EXPOSICAO_POR_OMISSAO);
            jLabelCard1DataInicio.setText(DATA_INICIO_E_FIM_POR_OMISSAO);
            jLabelCard1DataFim.setText(DATA_INICIO_E_FIM_POR_OMISSAO);
        }
    }//GEN-LAST:event_jComboBoxCard1EscolherExposicaoActionPerformed

    private void codigoDemonstracaoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoDemonstracaoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoDemonstracaoTxtActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (!dadosCandTxt.getText().trim().isEmpty()) {
            controller.setDados(dadosCandTxt.getText());
            if (JOptionPane.showConfirmDialog(rootPane, "Confirma alterações na candidatura?", "Confirma?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                controller.alterarCandidatura();
                JOptionPane.showMessageDialog(rootPane, "Candidatura alterada com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                thisFrame.dispose();
                jFrameMenuPrincipal.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de inserir dados para a candidatura", "Dados Inválidos", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jFrameMenuPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        recuarParaCard2();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void voltarCard1btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarCard1btnActionPerformed
        recuarParaCard1();
    }//GEN-LAST:event_voltarCard1btnActionPerformed

    private void confirmarCandBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarCandBtnActionPerformed
        if (jComboBoxCandidaturas.getSelectedItem() != null) {
            m_candidatura = m_listaCandidaturas.get(jComboBoxCandidaturas.getSelectedIndex());
            controller.selectCand(m_candidatura);
            avancarParaCard3();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma candidatura", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmarCandBtnActionPerformed

    private void avancarParaCard3() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card3");
    }

    private void jComboBoxCandidaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCandidaturasActionPerformed
        if (jComboBoxCandidaturas.getSelectedItem() != null) {
            CandidaturaADemonstracao c = m_listaCandidaturas.get(jComboBoxCandidaturas.getSelectedIndex());
            dadosCandTxt.setText(c.getDadosCandidatura());
            codigoDemonstracaoTxt.setText(c.getCodigoDemo());
        }
    }//GEN-LAST:event_jComboBoxCandidaturasActionPerformed

    private void recuarParaCard1() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card1");
    }

    private void recuarParaCard2() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card2");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Card1;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JTextField codigoDemonstracaoTxt;
    private javax.swing.JButton confirmarCandBtn;
    private javax.swing.JTextArea dadosCandTxt;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonCard1Avancar;
    private javax.swing.JButton jButtonCard1Avancar1;
    private javax.swing.JButton jButtonCard1Fechar;
    private javax.swing.JComboBox<String> jComboBoxCandidaturas;
    private javax.swing.JComboBox<String> jComboBoxCard1EscolherExposicao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCard1DataFim;
    private javax.swing.JLabel jLabelCard1DataInicio;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JLabel jLabelCard1Titulo1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCard1DescricaoExposicao;
    private javax.swing.JPanel jPanelCard1Duracao;
    private javax.swing.JPanel jPanelCard1Local;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaCard1DescricaoExposicao;
    private javax.swing.JTextArea jTextAreaCard1LocalExposicao;
    private javax.swing.JTextArea textAreaCard3;
    private javax.swing.JButton voltarCard1btn;
    // End of variables declaration//GEN-END:variables
}