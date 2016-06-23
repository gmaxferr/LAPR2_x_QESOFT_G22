package lapr.project.ui;

import lapr.project.uiModel.ModeloJTableUtilizadores;
import lapr.project.uiModel.ComboBoxModelExposicoes;
import java.awt.CardLayout;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import lapr.project.controller.DefinirFAEController;
import lapr.project.model.*;

/**
 *
 * @author G29
 */
public class JFrameDefinirFAEUI extends javax.swing.JFrame {

    /**
     * Lista de exposições utilizadas para a execução deste UC
     */
    private transient List<Exposicao> listaExposicoes;

    /**
     * JFrame do menu principal. Usada para a voltar a tornar visivél no fim
     * deste UC
     */
    private transient JFrame jFrameMenuPrincipal;

    /**
     * Controller deste UC
     */
    private transient final DefinirFAEController controller;

    /**
     * Largura da janela no passo 1
     */
    private static final int LARGURA_JANELA_PASSO1 = 710;

    /**
     * Altura da janela no passo 1
     */
    private static final int ALTURA_JANELA_PASSO1 = 370;

    /**
     * Largura da janela no passo 2
     */
    private static final int LARGURA_JANELA_PASSO2 = 722;

    /**
     * Altura da janela no passo 2
     */
    private static final int ALTURA_JANELA_PASSO2 = 500;

    /**
     * CardLayout usado na UI que permite a troca entre JPanels e simplificação
     * da UI para o utilizador
     */
    private transient final CardLayout cardLayout;

    /**
     * Lista de utilizadores do centro de exposições atual
     */
    private transient List<Utilizador> listaUtilizadores;

    /**
     * Lista dos Utilizadores que têm papel de FAE na exposição selecionada na
     * UI
     */
    private transient List<Utilizador> listaUtilizadoresCorrespondentesAosFae;

    /**
     * Creates new form JFrameDefinirFAE
     *
     * @param jFrameMenuPrincipal
     * @param centroExposicoes
     * @param usernameOrganizador
     */
    public JFrameDefinirFAEUI(JFrame jFrameMenuPrincipal, CentroExposicoes centroExposicoes, String usernameOrganizador) {
        super("Definir FAE");

        this.jFrameMenuPrincipal = jFrameMenuPrincipal;
        this.controller = new DefinirFAEController(centroExposicoes, usernameOrganizador);
        controller.getRegistoExposicoes();
        this.listaExposicoes = controller.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE();

        initComponents();
        alterarComportamentoFecharJFrame();
        this.cardLayout = (CardLayout) getContentPane().getLayout();

        setLocationRelativeTo(null);
        setVisible(true);
        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
    }

    /**
     * Altera o comportamente de clicar no botão de fechar nesta janela
     */
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

        card1 = new javax.swing.JPanel();
        jLabelCard1Titulo = new javax.swing.JLabel();
        jButtonCard1Avancar = new javax.swing.JButton();
        jButtonCard1Fechar = new javax.swing.JButton();
        jPanelCard1DescricaoExposicao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCard1DescricaoExposicao = new javax.swing.JTextArea();
        jPanelCard1Duracao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCard1DataInicio = new javax.swing.JLabel();
        jLabelCard1DataFim = new javax.swing.JLabel();
        jPanelCard1Local = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCard1LocalExposicao = new javax.swing.JTextArea();
        jComboBoxEscolherExposicao = new javax.swing.JComboBox<>();
        card2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCard2IntroduzirUsernameUtilizador = new javax.swing.JTextField();
        jButtonCard2AdicionarFAE = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonCard2Recuar = new javax.swing.JButton();
        jButtonCard2Terminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableUtilizadores = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableFAE = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

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

        jScrollPane1.setBorder(null);
        jScrollPane1.setRequestFocusEnabled(false);

        jTextAreaCard1DescricaoExposicao.setEditable(false);
        jTextAreaCard1DescricaoExposicao.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextAreaCard1DescricaoExposicao.setColumns(20);
        jTextAreaCard1DescricaoExposicao.setLineWrap(true);
        jTextAreaCard1DescricaoExposicao.setRows(5);
        jTextAreaCard1DescricaoExposicao.setText("A apresentar a descrição da demonstração selecionada");
        jTextAreaCard1DescricaoExposicao.setToolTipText("");
        jTextAreaCard1DescricaoExposicao.setWrapStyleWord(true);
        jTextAreaCard1DescricaoExposicao.setBorder(null);
        jScrollPane1.setViewportView(jTextAreaCard1DescricaoExposicao);

        javax.swing.GroupLayout jPanelCard1DescricaoExposicaoLayout = new javax.swing.GroupLayout(jPanelCard1DescricaoExposicao);
        jPanelCard1DescricaoExposicao.setLayout(jPanelCard1DescricaoExposicaoLayout);
        jPanelCard1DescricaoExposicaoLayout.setHorizontalGroup(
            jPanelCard1DescricaoExposicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1DescricaoExposicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelCard1DescricaoExposicaoLayout.setVerticalGroup(
            jPanelCard1DescricaoExposicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );

        jPanelCard1Duracao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duração", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("De");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("até");

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

        jScrollPane2.setBorder(null);

        jTextAreaCard1LocalExposicao.setEditable(false);
        jTextAreaCard1LocalExposicao.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        jTextAreaCard1LocalExposicao.setColumns(20);
        jTextAreaCard1LocalExposicao.setLineWrap(true);
        jTextAreaCard1LocalExposicao.setRows(5);
        jTextAreaCard1LocalExposicao.setText("Local");
        jTextAreaCard1LocalExposicao.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextAreaCard1LocalExposicao);

        javax.swing.GroupLayout jPanelCard1LocalLayout = new javax.swing.GroupLayout(jPanelCard1Local);
        jPanelCard1Local.setLayout(jPanelCard1LocalLayout);
        jPanelCard1LocalLayout.setHorizontalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1LocalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCard1LocalLayout.setVerticalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jComboBoxEscolherExposicao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxEscolherExposicao.setModel(new ComboBoxModelExposicoes(this.listaExposicoes));
        jComboBoxEscolherExposicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEscolherExposicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelCard1Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(card1Layout.createSequentialGroup()
                        .addComponent(jButtonCard1Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCard1Avancar)
                        .addGap(18, 18, 18))))
            .addGroup(card1Layout.createSequentialGroup()
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jComboBoxEscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabelCard1Titulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCard1Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxEscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelCard1Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCard1Fechar)
                            .addComponent(jButtonCard1Avancar)))
                    .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        getContentPane().add(card1, "card1");

        jLabel3.setFont(jLabelCard1Titulo.getFont());
        jLabel3.setText("Escolha os utilizadores");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Utilizadores registados (registo confirmado)");

        jLabel5.setText("Introduza o username do utilizador pretendido:");

        jButtonCard2AdicionarFAE.setText("Adicionar Fae");
        jButtonCard2AdicionarFAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard2AdicionarFAEActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("FAE (lista temporária)");

        jButtonCard2Recuar.setText("Recuar");
        jButtonCard2Recuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard2RecuarActionPerformed(evt);
            }
        });

        jButtonCard2Terminar.setText("Terminar");
        jButtonCard2Terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard2TerminarActionPerformed(evt);
            }
        });

        jTableUtilizadores.setModel(new ModeloJTableUtilizadores(this.listaUtilizadores));
        jScrollPane3.setViewportView(jTableUtilizadores);

        jTableFAE.setModel(new ModeloJTableUtilizadores(this.listaUtilizadoresCorrespondentesAosFae));
        jScrollPane4.setViewportView(jTableFAE);

        jLabel7.setText("(Mínimo de 2 FAE para fins estatisticos)");

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(214, 214, 214))
            .addGroup(card2Layout.createSequentialGroup()
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButtonCard2Recuar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCard2Terminar)
                                .addGap(15, 15, 15))
                            .addGroup(card2Layout.createSequentialGroup()
                                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addGroup(card2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(30, 30, 30))))
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCard2IntroduzirUsernameUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonCard2AdicionarFAE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCard2IntroduzirUsernameUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCard2AdicionarFAE))
                .addGap(18, 18, 18)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCard2Recuar)
                    .addComponent(jButtonCard2Terminar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(card2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCard1AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1AvancarActionPerformed
        if (jComboBoxEscolherExposicao.getSelectedItem() != null) {
            controller.setExposicao(this.listaExposicoes.get(jComboBoxEscolherExposicao.getSelectedIndex()));
            controller.getRegistoUtilizadores();
            controller.getRegistoOrganizadores();
            controller.getRegistoFAE();
            listaUtilizadores = controller.getListaUtilizadores();
            this.listaUtilizadoresCorrespondentesAosFae = controller.getListaUtilizadoresCorrespondentesAosFae();
            jTableFAE.setModel(new ModeloJTableUtilizadores(this.listaUtilizadoresCorrespondentesAosFae));
            if (!listaUtilizadores.isEmpty()) {
                avancarParaCard2();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foram encontrados utilizadores registados no sistema!", "Sem utilizadores", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma exposição primeiro!", "Exposição em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard1AvancarActionPerformed

    private void avancarParaCard2() {
        jTableUtilizadores.setModel(new ModeloJTableUtilizadores(this.listaUtilizadores));
        jTableFAE.setModel(new ModeloJTableUtilizadores(this.listaUtilizadoresCorrespondentesAosFae));
        cardLayout.show(getContentPane(), "card2");
        setSize(LARGURA_JANELA_PASSO2, ALTURA_JANELA_PASSO2);
    }

    private void jButtonCard1FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1FecharActionPerformed
        this.jFrameMenuPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCard1FecharActionPerformed

    private void jComboBoxEscolherExposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscolherExposicaoActionPerformed
        if (jComboBoxEscolherExposicao.getSelectedItem() != null) {
            Exposicao expo = listaExposicoes.get(jComboBoxEscolherExposicao.getSelectedIndex());
            jTextAreaCard1DescricaoExposicao.setText(expo.getDescricao());
            jTextAreaCard1LocalExposicao.setText(expo.getLocal().getMorada());
            jLabelCard1DataInicio.setText(expo.getDataInicio().toAnoMesDiaString());
            jLabelCard1DataFim.setText(expo.getDataFim().toAnoMesDiaString());
        }
    }//GEN-LAST:event_jComboBoxEscolherExposicaoActionPerformed
    private void jButtonCard2AdicionarFAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard2AdicionarFAEActionPerformed
        if (!jTextFieldCard2IntroduzirUsernameUtilizador.getText().replaceAll(" ", "").isEmpty()) {
            Utilizador u = controller.identificarUtilizadorPeloUsername(jTextFieldCard2IntroduzirUsernameUtilizador.getText());
            if (u != null) {
                if (controller.adicionarFaeListaTemp(u)) {
                    this.listaUtilizadoresCorrespondentesAosFae.add(u);
                    this.jTableFAE.setModel(new ModeloJTableUtilizadores(this.listaUtilizadoresCorrespondentesAosFae));
                    JOptionPane.showMessageDialog(rootPane, "O utilizador introduzido foi adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "O utilizador introduzido não pode ser definido como FAE para esta exposição. Verifique se introduziu o username corretamente. \nO mesmo utilizador não pode ser FAE e Organizador da mesma exposição. O utilizador pode já ter sido adicionado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi encontrado nenhum utilizador com o username inserido!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não pode deixar o campo do username vazio!", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard2AdicionarFAEActionPerformed

    private void jButtonCard2RecuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard2RecuarActionPerformed
        controller.limparFAEJaAdicionados();
        cardLayout.show(getContentPane(), "card1");
        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
    }//GEN-LAST:event_jButtonCard2RecuarActionPerformed

    private void jButtonCard2TerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard2TerminarActionPerformed
        if (controller.foramAdicionadosFAE()) {
            controller.confirmaAddFAE();
            if (!controller.setEstado()) {
                JOptionPane.showMessageDialog(rootPane, "Não foram adicionados FAE suficientes! Para a exposição se realizar terão de ser definidos pelos menos dois FAE\naté antes da data de início de submissão de candidaturas.", "Fae insuficientes", JOptionPane.WARNING_MESSAGE);
            }
            finalizarUC();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não foram adicionados FAE! Se não pretender adicionar nenhum FAE a esta exposição retorne ao passo anterior e selecione a exposição certa.", "Nenhum FAE adicionado", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard2TerminarActionPerformed
    private void finalizarUC() {
        String[] opcoes2 = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(rootPane, "Confirma os novos FAE?", "Terminar", 0, JOptionPane.QUESTION_MESSAGE, null, opcoes2, opcoes2[1]);
        if (resposta == 0) {
            setVisible(false);
            JOptionPane.showMessageDialog(rootPane, "Novos FAE adicionados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            jFrameMenuPrincipal.setVisible(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JButton jButtonCard1Avancar;
    private javax.swing.JButton jButtonCard1Fechar;
    private javax.swing.JButton jButtonCard2AdicionarFAE;
    private javax.swing.JButton jButtonCard2Recuar;
    private javax.swing.JButton jButtonCard2Terminar;
    private javax.swing.JComboBox<String> jComboBoxEscolherExposicao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCard1DataFim;
    private javax.swing.JLabel jLabelCard1DataInicio;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JPanel jPanelCard1DescricaoExposicao;
    private javax.swing.JPanel jPanelCard1Duracao;
    private javax.swing.JPanel jPanelCard1Local;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableFAE;
    private javax.swing.JTable jTableUtilizadores;
    private javax.swing.JTextArea jTextAreaCard1DescricaoExposicao;
    private javax.swing.JTextArea jTextAreaCard1LocalExposicao;
    private javax.swing.JTextField jTextFieldCard2IntroduzirUsernameUtilizador;
    // End of variables declaration//GEN-END:variables
}
