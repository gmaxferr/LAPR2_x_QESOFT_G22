/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.controller.CriarCandidaturaExposicaoXMLController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.ui.model.ComboBoxModelExposicoes;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class JFrameCriarCandidaturaExposicaoXML extends javax.swing.JFrame {

    private JFrame jFrameMenuPrincipal;
    private List<Exposicao> m_listaExposicoes;
    private Exposicao m_expo;
    private CentroExposicoes m_ce;
    private CriarCandidaturaExposicaoXMLController controller;

    private static final String DESCRICAO_EXPOSICAO_POR_OMISSAO = "A apresentar a descrição da esposição selecionada";
    private static final String LOCAL_EXPOSICAO_POR_OMISSAO = "A apresentar o local de realização da exposição selecionada";
    private static final String DATA_INICIO_E_FIM_POR_OMISSAO = "00/00/0000";

    /**
     * Creates new form JFrameCriarCandidaturaExposicaoXML
     */
    public JFrameCriarCandidaturaExposicaoXML(CentroExposicoes ce, JFrame janelaMae, String username) {
        m_ce = ce;
        m_listaExposicoes = ce.getRegistoExposicoes().getListaExposicoes();
        jFrameMenuPrincipal = janelaMae;
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

        card1 = new javax.swing.JPanel();
        jLabelCard1Titulo = new javax.swing.JLabel();
        selectExpoBtn = new javax.swing.JButton();
        card1CancelBtn = new javax.swing.JButton();
        jPanelCard1DescricaoExposicao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoExpoTxt = new javax.swing.JTextArea();
        jPanelCard1Duracao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCard1DataInicio = new javax.swing.JLabel();
        jLabelCard1DataFim = new javax.swing.JLabel();
        jPanelCard1Local = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        localExpoTxt = new javax.swing.JTextArea();
        jComboBoxCard1EscolherExposicao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabelCard1Titulo.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabelCard1Titulo.setText("Escolha a exposição pretendida");
        jLabelCard1Titulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        selectExpoBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectExpoBtn.setText("Selecionar exposição");
        selectExpoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectExpoBtnActionPerformed(evt);
            }
        });

        card1CancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        card1CancelBtn.setText("Cancelar");
        card1CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card1CancelBtnActionPerformed(evt);
            }
        });

        jPanelCard1DescricaoExposicao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descricao", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanelCard1DescricaoExposicao.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setRequestFocusEnabled(false);

        descricaoExpoTxt.setEditable(false);
        descricaoExpoTxt.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        descricaoExpoTxt.setColumns(20);
        descricaoExpoTxt.setLineWrap(true);
        descricaoExpoTxt.setRows(5);
        descricaoExpoTxt.setText("A apresentar a descrição da demonstração selecionada");
        descricaoExpoTxt.setToolTipText("");
        descricaoExpoTxt.setWrapStyleWord(true);
        descricaoExpoTxt.setBorder(null);
        jScrollPane1.setViewportView(descricaoExpoTxt);

        jPanelCard1DescricaoExposicao.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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

        localExpoTxt.setEditable(false);
        localExpoTxt.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        localExpoTxt.setColumns(20);
        localExpoTxt.setLineWrap(true);
        localExpoTxt.setRows(5);
        localExpoTxt.setText("A apresentar o local da exposição selecionada");
        localExpoTxt.setWrapStyleWord(true);
        localExpoTxt.setBorder(null);
        jScrollPane2.setViewportView(localExpoTxt);

        javax.swing.GroupLayout jPanelCard1LocalLayout = new javax.swing.GroupLayout(jPanelCard1Local);
        jPanelCard1Local.setLayout(jPanelCard1LocalLayout);
        jPanelCard1LocalLayout.setHorizontalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelCard1LocalLayout.setVerticalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        );

        jComboBoxCard1EscolherExposicao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxCard1EscolherExposicao.setModel(new ComboBoxModelExposicoes(this.m_listaExposicoes));
        jComboBoxCard1EscolherExposicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCard1EscolherExposicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jComboBoxCard1EscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(card1Layout.createSequentialGroup()
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabelCard1Titulo))
                    .addGroup(card1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(card1Layout.createSequentialGroup()
                                .addComponent(card1CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(selectExpoBtn))
                            .addComponent(jPanelCard1Local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCard1Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxCard1EscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelCard1Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(card1CancelBtn)
                            .addComponent(selectExpoBtn))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(card1, "card1");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectExpoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectExpoBtnActionPerformed
        if (jComboBoxCard1EscolherExposicao.getSelectedItem() != null) {
            m_expo = m_listaExposicoes.get(jComboBoxCard1EscolherExposicao.getSelectedIndex());
            String filename = selectFile();
            if(filename!=null){
            try {
                controller = new CriarCandidaturaExposicaoXMLController(m_ce, m_expo, filename);
                controller.registarCandidatura();
                
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(JFrameCriarCandidaturaExposicaoXML.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
                JOptionPane.showMessageDialog(rootPane, "O ficheiro selecionado é inválido!", "Ficheiro inválido", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma exposição primeiro!", "Exposição em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_selectExpoBtnActionPerformed

    /**
     * Permite selecionar o ficheiro XML da candidatura a importar
     * @return - caminho completo do ficheiro no sistema
     */
    private String selectFile() {
        JFileChooser fc = new JFileChooser();

        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String filename = file.getAbsolutePath();
            return filename;
        } else {
            return null;
        }
    }

    private void card1CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_card1CancelBtnActionPerformed
        dispose();
        this.jFrameMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_card1CancelBtnActionPerformed

    private void jComboBoxCard1EscolherExposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCard1EscolherExposicaoActionPerformed
        if (jComboBoxCard1EscolherExposicao.getSelectedItem() != null) {
            Exposicao expo = m_listaExposicoes.get(jComboBoxCard1EscolherExposicao.getSelectedIndex());
            descricaoExpoTxt.setText(expo.getDescricao());
            localExpoTxt.setText(expo.getLocal().getMorada());
            jLabelCard1DataInicio.setText(expo.getDataInicio().toAnoMesDiaString());
            jLabelCard1DataFim.setText(expo.getDataFim().toAnoMesDiaString());
        } else {
            descricaoExpoTxt.setText(DESCRICAO_EXPOSICAO_POR_OMISSAO);
            localExpoTxt.setText(LOCAL_EXPOSICAO_POR_OMISSAO);
            jLabelCard1DataInicio.setText(DATA_INICIO_E_FIM_POR_OMISSAO);
            jLabelCard1DataFim.setText(DATA_INICIO_E_FIM_POR_OMISSAO);
        }
    }//GEN-LAST:event_jComboBoxCard1EscolherExposicaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JButton card1CancelBtn;
    private javax.swing.JTextArea descricaoExpoTxt;
    private javax.swing.JComboBox<String> jComboBoxCard1EscolherExposicao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCard1DataFim;
    private javax.swing.JLabel jLabelCard1DataInicio;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JPanel jPanelCard1DescricaoExposicao;
    private javax.swing.JPanel jPanelCard1Duracao;
    private javax.swing.JPanel jPanelCard1Local;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea localExpoTxt;
    private javax.swing.JButton selectExpoBtn;
    // End of variables declaration//GEN-END:variables
}
