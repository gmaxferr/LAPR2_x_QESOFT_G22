/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.ui.model.ComboBoxModelExposicoes;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr.project.controller.RemoverCandidaturaExpoController;
import lapr.project.model.AtribuicaoCandidatura;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Produto;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class JFrameRemoverCandidaturaExposicaoUI extends javax.swing.JFrame {

    private static final String DESCRICAO_EXPOSICAO_POR_OMISSAO = "A apresentar a descrição da exposição selecionada";
    private static final String LOCAL_EXPOSICAO_POR_OMISSAO = "A apresentar o local de realização para a exposição selecionada";
    private static final String DATA_INICIO_E_FIM_POR_OMISSAO = "00/00/0000";

    private transient List<AtribuicaoCandidatura> listaAtribuicoesDoFAE;
    private transient Exposicao expoSelecionada;
    private transient List<Exposicao> listaExposicoes;

    private static final String[] LISTA_PRODUTOS_POR_OMISSAO = {"A apresentar os produtos a expor pela candidatura selecionada."};
    private static final int CARD1_ALTURA_MINIMA = 300;
    private static final int CARD1_LARGURA_MINIMA = 400;

    private static final int CARD2_LARGURA_MINIMA = 480;
    private static final int CARD2_ALTURA_MINIMA = 450;
    private transient final CardLayout cardLayout;
    private transient String username;
    private transient CentroExposicoes ce;
    private transient RemoverCandidaturaExpoController ctrl;
    private transient JFrame janelaMae;

    /**
     * Creates new form JFrameRemoverCandidaturaUI
     */
    public JFrameRemoverCandidaturaExposicaoUI(JFrame janelaMae, CentroExposicoes ce, String username) {
        this.ctrl = new RemoverCandidaturaExpoController(username, ce);
        this.ce = ce;
        this.username = username;
        this.janelaMae = janelaMae;
        this.listaExposicoes = ce.getRegistoExposicoes().getExposicoesDoRepresentante(username);
        initComponents();
        alterarComportamentoFecharJFrame();
        this.cardLayout = (CardLayout) getContentPane().getLayout();
        setVisible(true);
        setSize(CARD1_LARGURA_MINIMA, CARD1_ALTURA_MINIMA);
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
        card2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelCard2DadosEmpresaNome = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelCard2DadosEmpresaMorada = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelCard2DadosEmpresaTelemovel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelCard2DadosCandidaturaArea = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelCard2DadosCandidaturaNumeroConvites = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListCard2ListaProdutos = new javax.swing.JList<>(LISTA_PRODUTOS_POR_OMISSAO);
        jComboBoxCard2EscolherCandidatura = new javax.swing.JComboBox<>();
        jButtonCard2Avancar = new javax.swing.JButton();
        jButtonCard2Recuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                .addGap(0, 0, Short.MAX_VALUE))
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
                        .addGap(0, 133, Short.MAX_VALUE))
                    .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(Card1, "card2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Escolha a candidatura a remover");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel5.setText("Nome:");

        jLabelCard2DadosEmpresaNome.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCard2DadosEmpresaNome.setText("A apresentar o nome da empresa selecionada");
        jLabelCard2DadosEmpresaNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel6.setText("Morada:");

        jLabelCard2DadosEmpresaMorada.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCard2DadosEmpresaMorada.setText("A apresentar a morada da empresa selecionada");
        jLabelCard2DadosEmpresaMorada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel8.setText("Telemóvel:");

        jLabelCard2DadosEmpresaTelemovel.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCard2DadosEmpresaTelemovel.setText("Telemóvel");
        jLabelCard2DadosEmpresaTelemovel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel10.setText("Número de convites:");

        jLabelCard2DadosCandidaturaArea.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCard2DadosCandidaturaArea.setText("Área");
        jLabelCard2DadosCandidaturaArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel12.setText("Área:");

        jLabelCard2DadosCandidaturaNumeroConvites.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCard2DadosCandidaturaNumeroConvites.setText("Convites");
        jLabelCard2DadosCandidaturaNumeroConvites.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel14.setText("m²");

        jLabel15.setText("Produtos a expor:");

        jScrollPane4.setViewportView(jListCard2ListaProdutos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCard2DadosEmpresaMorada, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCard2DadosCandidaturaNumeroConvites, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCard2DadosEmpresaTelemovel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCard2DadosEmpresaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCard2DadosCandidaturaArea, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelCard2DadosEmpresaNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelCard2DadosEmpresaMorada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelCard2DadosEmpresaTelemovel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabelCard2DadosCandidaturaArea)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabelCard2DadosCandidaturaNumeroConvites))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBoxCard2EscolherCandidatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCard2EscolherCandidatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCard2EscolherCandidaturaActionPerformed(evt);
            }
        });

        jButtonCard2Avancar.setText("Avançar");
        jButtonCard2Avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard2AvancarActionPerformed(evt);
            }
        });

        jButtonCard2Recuar.setText("Recuar");
        jButtonCard2Recuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard2RecuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButtonCard2Recuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCard2Avancar)
                .addGap(47, 47, 47))
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxCard2EscolherCandidatura, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxCard2EscolherCandidatura, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCard2Avancar)
                    .addComponent(jButtonCard2Recuar))
                .addContainerGap())
        );

        getContentPane().add(card2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCard1AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1AvancarActionPerformed
        if (jComboBoxCard1EscolherExposicao.getSelectedItem() != null) {
            ctrl.setExposicao(listaExposicoes.get(jComboBoxCard1EscolherExposicao.getSelectedIndex()));
            ctrl.getRegistoAtribuicoes();
            listaAtribuicoesDoFAE = ctrl.getListaAtribuicoesComOFAE();
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

    private void jComboBoxCard2EscolherCandidaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCard2EscolherCandidaturaActionPerformed
        if (jComboBoxCard2EscolherCandidatura.getSelectedItem() != null) {
            preencherDados();
        }
    }//GEN-LAST:event_jComboBoxCard2EscolherCandidaturaActionPerformed

    private void preencherDados() {
        CandidaturaAExposicao cand = listaAtribuicoesDoFAE.get(jComboBoxCard2EscolherCandidatura.getSelectedIndex()).getCandidaturaAssociada();
        jLabelCard2DadosEmpresaNome.setText(cand.getNomeEmpresa());
        String telemovelEmpresa = Integer.toString(cand.getTelemovel());
        jLabelCard2DadosEmpresaTelemovel.setText(telemovelEmpresa);
        jLabelCard2DadosEmpresaMorada.setText(cand.getMoradaEmpresa());
        String numConvites = Integer.toString(cand.getNumConvites());
        jLabelCard2DadosCandidaturaNumeroConvites.setText(numConvites);
        String area = Integer.toString(cand.getArea());
        jLabelCard2DadosCandidaturaArea.setText(area);
        String[] vetorProdutosCandSelecionada = card2CriarVetorListaProdutosCandidaturaSelecionada(cand.getRegistoProdutos().getListaProdutosAExpor());
        jListCard2ListaProdutos.setListData(vetorProdutosCandSelecionada);
    }

    private String[] card2CriarVetorListaProdutosCandidaturaSelecionada(List<Produto> listaProdutos) {
        String[] vetorProdutos = new String[listaProdutos.size()];
        for (int i = 0; i < listaProdutos.size(); i++) {
            vetorProdutos[i] = listaProdutos.get(i).getNome();
        }
        return vetorProdutos;
    }

    private void jButtonCard2AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard2AvancarActionPerformed
        CandidaturaAExposicao c = (CandidaturaAExposicao) jComboBoxCard2EscolherCandidatura.getSelectedItem();
        if (c != null) {
            int op = JOptionPane.showConfirmDialog(null, "Confirma a remoção da candidatura selecionada?", "Confirmação da remoção", JOptionPane.YES_NO_OPTION);
            if(op == 0){
                ctrl.setCandidaturaARemover(c);
                ctrl.removerCandidatura();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma candidatura primeiro!", "Candidatura em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard2AvancarActionPerformed

    private void jButtonCard2RecuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard2RecuarActionPerformed
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card1");
        setSize(CARD1_LARGURA_MINIMA, CARD1_ALTURA_MINIMA);
    }//GEN-LAST:event_jButtonCard2RecuarActionPerformed

    private void avancarParaCard2() {
        cardLayout.show(getContentPane(), "card2");
        setSize(CARD2_LARGURA_MINIMA, CARD2_ALTURA_MINIMA);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Card1;
    private javax.swing.JPanel card2;
    private javax.swing.JButton jButtonCard1Avancar;
    private javax.swing.JButton jButtonCard1Fechar;
    private javax.swing.JButton jButtonCard2Avancar;
    private javax.swing.JButton jButtonCard2Recuar;
    private javax.swing.JComboBox<String> jComboBoxCard1EscolherExposicao;
    private javax.swing.JComboBox<String> jComboBoxCard2EscolherCandidatura;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCard1DataFim;
    private javax.swing.JLabel jLabelCard1DataInicio;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JLabel jLabelCard2DadosCandidaturaArea;
    private javax.swing.JLabel jLabelCard2DadosCandidaturaNumeroConvites;
    private javax.swing.JLabel jLabelCard2DadosEmpresaMorada;
    private javax.swing.JLabel jLabelCard2DadosEmpresaNome;
    private javax.swing.JLabel jLabelCard2DadosEmpresaTelemovel;
    private javax.swing.JList<String> jListCard2ListaProdutos;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCard1DescricaoExposicao;
    private javax.swing.JPanel jPanelCard1Duracao;
    private javax.swing.JPanel jPanelCard1Local;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaCard1DescricaoExposicao;
    private javax.swing.JTextArea jTextAreaCard1LocalExposicao;
    // End of variables declaration//GEN-END:variables
}
