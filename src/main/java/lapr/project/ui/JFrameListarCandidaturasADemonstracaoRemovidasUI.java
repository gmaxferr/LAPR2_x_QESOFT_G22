package lapr.project.ui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr.project.controller.ListarCandidaturasADemonstracaoRemovidasController;
import lapr.project.model.*;

/**
 *
 * @author Ana Leite
 */
public class JFrameListarCandidaturasADemonstracaoRemovidasUI extends javax.swing.JFrame {

    private transient JFrame jFrameMenuPrincipal;
    private transient CentroExposicoes centroExposicoesAtual;
    private transient String usernameOrganizador;
    private transient ListarCandidaturasADemonstracaoRemovidasController controller;
    private transient List<Demonstracao> listaDemonstracoes;

    private static final int LARGURA_JANELA_PASSO1 = 589;
    private static final int ALTURA_JANELA_PASSO1 = 335;

    private static final int LARGURA_JANELA_PASSO2 = 400;
    private static final int ALTURA_JANELA_PASSO2 = 610;
    
    private static final String DESCRICAO_DEMONSTRACAO_POR_OMISSAO = "A apresentar a descricao da exposição selecionada.";


    /**
     * Creates new form jFrameListarCandidaturasADemonstracaoRemovidasUI
     */
    public JFrameListarCandidaturasADemonstracaoRemovidasUI(JFrame jFrameMenuPrincipal, CentroExposicoes centroExposicoes, String usernameOrganizador) {
        super("Listar candidaturas a demonstração removidas");
        this.jFrameMenuPrincipal = jFrameMenuPrincipal;
        this.centroExposicoesAtual = centroExposicoes;
        this.usernameOrganizador = usernameOrganizador;
        this.controller = new ListarCandidaturasADemonstracaoRemovidasController(centroExposicoes);
        controller.getRegistoDemonstracoes();;
        this.listaDemonstracoes = controller.getListaDemonstracoesDoOrganizadorEstadoConfirmada(usernameOrganizador);
        initComponents();

        alterarComportamentoFecharJFrame();

        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
        setVisible(true);
    }

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

        card1 = new javax.swing.JPanel();
        jLabel1Card1Titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneCard1 = new javax.swing.JScrollPane();
        jTextAreaCard1DescricaoDemonstracao = new javax.swing.JTextArea();
        jButtonCard1Avancar = new javax.swing.JButton();
        jButtonCard1Fechar = new javax.swing.JButton();
        jComboBoxEscolherDemonstracao = new javax.swing.JComboBox<>();
        card2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPaneCard2 = new javax.swing.JScrollPane();
        jListCard2ListaCandidaturas = new javax.swing.JList<>();
        jButtonCard2Recuar = new javax.swing.JButton();
        jButtonCard2Fechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel1Card1Titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1Card1Titulo.setText("Escolha a demonstração pretendida");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jScrollPaneCard1.setBorder(null);

        jTextAreaCard1DescricaoDemonstracao.setEditable(false);
        jTextAreaCard1DescricaoDemonstracao.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        jTextAreaCard1DescricaoDemonstracao.setColumns(20);
        jTextAreaCard1DescricaoDemonstracao.setLineWrap(true);
        jTextAreaCard1DescricaoDemonstracao.setRows(5);
        jTextAreaCard1DescricaoDemonstracao.setText("A apresentar a descrição da demonstração selecionada");
        jTextAreaCard1DescricaoDemonstracao.setWrapStyleWord(true);
        jScrollPaneCard1.setViewportView(jTextAreaCard1DescricaoDemonstracao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneCard1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneCard1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );

        jButtonCard1Avancar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard1Avancar.setText("Selecionar demonstração");
        jButtonCard1Avancar.setToolTipText("");
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

        jComboBoxEscolherDemonstracao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxEscolherDemonstracao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEscolherDemonstracao.setSelectedIndex(-1);
        jComboBoxEscolherDemonstracao.setToolTipText("");
        jComboBoxEscolherDemonstracao.setMinimumSize(new java.awt.Dimension(30, 21));
        jComboBoxEscolherDemonstracao.setPreferredSize(new java.awt.Dimension(30, 21));
        jComboBoxEscolherDemonstracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEscolherDemonstracaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1Card1Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButtonCard1Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButtonCard1Avancar))
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jComboBoxEscolherDemonstracao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1Card1Titulo)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxEscolherDemonstracao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCard1Fechar)
                    .addComponent(jButtonCard1Avancar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(card1, "card3");

        card2.setPreferredSize(new java.awt.Dimension(200, 308));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Lista de Candidaturas Removidas");

        jListCard2ListaCandidaturas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneCard2.setViewportView(jListCard2ListaCandidaturas);

        jButtonCard2Recuar.setText("Recuar");
        jButtonCard2Recuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard2RecuarActionPerformed(evt);
            }
        });

        jButtonCard2Fechar.setText("Fechar");
        jButtonCard2Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard2FecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(card2Layout.createSequentialGroup()
                                .addComponent(jButtonCard2Recuar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCard2Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPaneCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCard2Recuar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCard2Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(card2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCard1AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1AvancarActionPerformed
        if (jComboBoxEscolherDemonstracao.getSelectedItem() != null) {
            avancarParaCard2();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma demonstração primeiro!", "Demonstração em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard1AvancarActionPerformed

    private void avancarParaCard2() {
        controller.setDemonstracao(listaDemonstracoes.get(jComboBoxEscolherDemonstracao.getSelectedIndex()));
        controller.getRegistoCandidaturasADemonstracaoRemovidas();
        String [] vetorCandidaturasRemovidas = criarVetorListaCandidaturasADemonstracaoRemovidas(controller.getListaCandidaturasADemonstracaoRemovidas());        
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        jListCard2ListaCandidaturas.setListData(vetorCandidaturasRemovidas);
        cardLayout.show(getContentPane(), "card2");
        setSize(LARGURA_JANELA_PASSO2, ALTURA_JANELA_PASSO2);
    }

    private String[] criarVetorListaCandidaturasADemonstracaoRemovidas(List<CandidaturaADemonstracao> listaCandidaturas){
        String[] vetorCandidaturasRemovidas = new String [listaCandidaturas.size()];
        for(int i = 0; i < listaCandidaturas.size(); i++){
            vetorCandidaturasRemovidas[i] = listaCandidaturas.get(i).getDadosCandidatura();
        }
        return vetorCandidaturasRemovidas;
    }
    
    private void jButtonCard1FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1FecharActionPerformed
        dispose();
        this.jFrameMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButtonCard1FecharActionPerformed

    private void jButtonCard2RecuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard2RecuarActionPerformed
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card1");
        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
    }//GEN-LAST:event_jButtonCard2RecuarActionPerformed

    private void jButtonCard2FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard2FecharActionPerformed
        setVisible(false);
        jFrameMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButtonCard2FecharActionPerformed

    private void jComboBoxEscolherDemonstracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscolherDemonstracaoActionPerformed
        if (jComboBoxEscolherDemonstracao.getSelectedItem() != null) {
            jTextAreaCard1DescricaoDemonstracao.setText(listaDemonstracoes.get(jComboBoxEscolherDemonstracao.getSelectedIndex()).getDescricao());
        } else { 
            jTextAreaCard1DescricaoDemonstracao.setText(DESCRICAO_DEMONSTRACAO_POR_OMISSAO);
        }
    }//GEN-LAST:event_jComboBoxEscolherDemonstracaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JButton jButtonCard1Avancar;
    private javax.swing.JButton jButtonCard1Fechar;
    private javax.swing.JButton jButtonCard2Fechar;
    private javax.swing.JButton jButtonCard2Recuar;
    private javax.swing.JComboBox<String> jComboBoxEscolherDemonstracao;
    private javax.swing.JLabel jLabel1Card1Titulo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jListCard2ListaCandidaturas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneCard1;
    private javax.swing.JScrollPane jScrollPaneCard2;
    private javax.swing.JTextArea jTextAreaCard1DescricaoDemonstracao;
    // End of variables declaration//GEN-END:variables
}