package lapr.project.ui;

import lapr.project.ui.model.ComboBoxModelExposicoes;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import lapr.project.controller.RegistarCandidaturaADemonstracaoController;
import lapr.project.model.*;
import lapr.project.ui.model.AbstractListModelDemonstracoes;

/**
 *
 * @author Guilherme
 */
public class JFrameRegistarCandidaturaADemonstracaoUI extends JFrame {

    private static final String DESCRICAO_EXPOSICAO_POR_OMISSAO = "A apresentar a descrição da esposição selecionada";
    private static final String LOCAL_EXPOSICAO_POR_OMISSAO = "A apresentar o local de realização da exposição selecionada";
    private static final String DATA_INICIO_E_FIM_POR_OMISSAO = "00/00/0000";
    private static final String DESCRICAO_DEMONSTRACAO_POR_OMISSAO = "A apresentar a descricao da exposição selecionada.";

    private transient RegistarCandidaturaADemonstracaoController CTRL;
    private transient List<Exposicao> listaExposicoes = new ArrayList<>();
    private transient List<Demonstracao> listaDemos = new ArrayList<>();
    private transient JFrame jFrameMenuPrincipal;

    ;
    /**
     * Cria interface de Registar Candidatura a uma Demonstracao
     * 
     * @param janelaMae - Menu principal
     * @param ce - Centro de Exposções
     * @param usernameRep - username do representante
     */
    public JFrameRegistarCandidaturaADemonstracaoUI(JFrame janelaMae, CentroExposicoes ce, String usernameRep) {
        CTRL = new RegistarCandidaturaADemonstracaoController(ce, usernameRep);
        jFrameMenuPrincipal = janelaMae;
        listaExposicoes = CTRL.getListaDeExposicoes();
        if (listaExposicoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem exposições com demonstrações com candidaturas avaliadas.", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            initComponents();
            alterarComportamentoFecharJFrame();
            setVisible(true);
        }
    }

    /**
     * altera o comportamento da janela ao fechar
     */
    private void alterarComportamentoFecharJFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                jFrameMenuPrincipal.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabelCard1Titulo = new javax.swing.JLabel();
        botaoSelecionaExpo = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jPanelCard1DescricaoExposicao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaCard1DescricaoExposicao = new javax.swing.JTextArea();
        jPanelCard1Duracao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCard1DataInicio = new javax.swing.JLabel();
        jLabelCard1DataFim = new javax.swing.JLabel();
        jPanelCard1Local = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaCard1LocalExposicao = new javax.swing.JTextArea();
        comboBoxCard1EscolherExposicao = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCard2 = new javax.swing.JList<>();
        botaoContinuar = new javax.swing.JButton();
        boataoCancelar2 = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaCard3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Criar Candidatura A Demonstração");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabelCard1Titulo.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabelCard1Titulo.setText("Escolha a exposição pretendida");
        jLabelCard1Titulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        botaoSelecionaExpo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoSelecionaExpo.setText("Selecionar exposição");
        botaoSelecionaExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionaExpoActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        jPanelCard1DescricaoExposicao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descricao", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanelCard1DescricaoExposicao.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setRequestFocusEnabled(false);

        textAreaCard1DescricaoExposicao.setEditable(false);
        textAreaCard1DescricaoExposicao.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        textAreaCard1DescricaoExposicao.setColumns(20);
        textAreaCard1DescricaoExposicao.setLineWrap(true);
        textAreaCard1DescricaoExposicao.setRows(5);
        textAreaCard1DescricaoExposicao.setText("A apresentar a descrição da demonstração selecionada");
        textAreaCard1DescricaoExposicao.setToolTipText("");
        textAreaCard1DescricaoExposicao.setWrapStyleWord(true);
        textAreaCard1DescricaoExposicao.setBorder(null);
        jScrollPane1.setViewportView(textAreaCard1DescricaoExposicao);

        jPanelCard1DescricaoExposicao.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanelCard1Duracao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duração", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("De");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("até");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCard1DataInicio)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabelCard1DataFim)
                .addGap(32, 32, 32))
        );
        jPanelCard1DuracaoLayout.setVerticalGroup(
            jPanelCard1DuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1DuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        comboBoxCard1EscolherExposicao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboBoxCard1EscolherExposicao.setModel(new ComboBoxModelExposicoes(this.listaExposicoes));
        comboBoxCard1EscolherExposicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCard1EscolherExposicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(comboBoxCard1EscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabelCard1Titulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(botaoSelecionaExpo))
                            .addComponent(jPanelCard1Local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCard1Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxCard1EscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelCard1Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCancelar)
                            .addComponent(botaoSelecionaExpo))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card1");
        jPanel1.getAccessibleContext().setAccessibleName("card1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("  Criação de Candidatura a Demonstração  ");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Selecione uma das demonstrações abaixo a que quer submeter candidatura:");

        listaCard2.setModel(new AbstractListModelDemonstracoes(listaDemos));
        listaCard2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listaCard2);

        botaoContinuar.setText("Continuar");
        botaoContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoContinuarActionPerformed(evt);
            }
        });

        boataoCancelar2.setText("Cancel");
        boataoCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boataoCancelar2ActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(239, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(boataoCancelar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoVoltar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoContinuar)
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boataoCancelar2)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoContinuar))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, "card2");
        jPanel2.getAccessibleContext().setAccessibleName("card2");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("  Criação de Candidatura a Demonstração  ");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Preencha o formulário de submissão de candidatura:");

        jButton7.setText("Submeter");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Cancel");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Voltar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel8.setText("Dados de Candidatura:");

        textAreaCard3.setColumns(20);
        textAreaCard3.setRows(5);
        jScrollPane4.setViewportView(textAreaCard3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(165, 165, 165)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, "card4");
        jPanel3.getAccessibleContext().setAccessibleName("card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoContinuarActionPerformed
        if (listaCard2.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Ainda não selecionou nenhuma demonstração!", "Atenção!", ERROR_MESSAGE);
        } else {
            CTRL.setDemo(listaCard2.getSelectedIndex());
            passaParaPanel3();
        }
    }//GEN-LAST:event_botaoContinuarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (textAreaCard3.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ainda não escreveu nenhum dado do formulário!", "Atenção!", ERROR_MESSAGE);
        } else if (CTRL.setFormularioDados(textAreaCard3.getText().trim())) {
            CTRL.RegistaCandADemo();
            JOptionPane.showMessageDialog(null, "Candidatura Registada!", "Sucesso", PLAIN_MESSAGE);
            jFrameMenuPrincipal.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        passaParaPanel1();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void boataoCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boataoCancelar2ActionPerformed
        jFrameMenuPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_boataoCancelar2ActionPerformed

    private void botaoSelecionaExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionaExpoActionPerformed
        if (comboBoxCard1EscolherExposicao.getSelectedItem() != null) {
            passaParaPanel2();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma exposição primeiro!", "Exposição em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoSelecionaExpoActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        jFrameMenuPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void comboBoxCard1EscolherExposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCard1EscolherExposicaoActionPerformed
        if (comboBoxCard1EscolherExposicao.getSelectedItem() != null) {
            Exposicao e = listaExposicoes.get(comboBoxCard1EscolherExposicao.getSelectedIndex());
            textAreaCard1DescricaoExposicao.setText(e.getDescricao());
            jTextAreaCard1LocalExposicao.setText(e.getLocal().getMorada());
            jLabelCard1DataInicio.setText(e.getDataInicio().toAnoMesDiaString());
            jLabelCard1DataFim.setText(e.getDataFim().toString());
            CTRL.setExpo(e);
        }
    }//GEN-LAST:event_comboBoxCard1EscolherExposicaoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jFrameMenuPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        passaParaPanel2();
    }//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boataoCancelar2;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoContinuar;
    private javax.swing.JButton botaoSelecionaExpo;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox<String> comboBoxCard1EscolherExposicao;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCard1DataFim;
    private javax.swing.JLabel jLabelCard1DataInicio;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCard1DescricaoExposicao;
    private javax.swing.JPanel jPanelCard1Duracao;
    private javax.swing.JPanel jPanelCard1Local;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaCard1LocalExposicao;
    private javax.swing.JList<String> listaCard2;
    private javax.swing.JTextArea textAreaCard1DescricaoExposicao;
    private javax.swing.JTextArea textAreaCard3;
    // End of variables declaration//GEN-END:variables

    private void passaParaPanel1() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card1");
        setSize(this.getSize());

    }

    private void passaParaPanel2() {
        listaDemos = CTRL.getListaDemos();
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
