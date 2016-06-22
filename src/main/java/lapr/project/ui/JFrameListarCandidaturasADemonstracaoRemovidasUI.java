package lapr.project.ui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr.project.controller.ListarCandidaturasADemonstracaoRemovidasController;
import lapr.project.model.*;
import lapr.project.ui.model.ComboBoxModelExposicoes;

/**
 *
 * @author G29
 */
public class JFrameListarCandidaturasADemonstracaoRemovidasUI extends javax.swing.JFrame {

    /**
     * JFrame do menu principal. Usada para a voltar a tornar visivél no fim
     * deste UC
     */
    private transient JFrame jFrameMenuPrincipal;
    
    /**
     * Centro de exposições
     */
    private transient CentroExposicoes centroExposicoesAtual;
    
    /**
     * Username do organizador
     */
    private transient String usernameOrganizador;
    
    /**
     * Lista de exposições do organizador utilizadas para a execução deste UC
     */
    private transient List<Exposicao> listaExposicoesDoOrganizador;
    
    /**
     * Controller deste UC
     */
    private transient ListarCandidaturasADemonstracaoRemovidasController controller;
    
    /**
     * Lista de demonstrações utilizadas para a execução deste UC
     */
    private transient List<Demonstracao> listaDemonstracoes;

    private static final int LARGURA_JANELA_PASSO1 = 682;
    private static final int ALTURA_JANELA_PASSO1 = 308;

    private static final int LARGURA_JANELA_PASSO2 = 589;
    private static final int ALTURA_JANELA_PASSO2 = 335;

    private static final int LARGURA_JANELA_PASSO3 = 400;
    private static final int ALTURA_JANELA_PASSO3 = 610;

    /**
     * Descrição da demonstração por omissão
     */
    private static final String DESCRICAO_DEMONSTRACAO_POR_OMISSAO = "A apresentar a descricao da exposição selecionada.";
    
    /**
     * Descrição da exposição por omissão
     */
    private static final String DESCRICAO_EXPOSICAO_POR_OMISSAO = "A apresentar a descrição da esposição selecionada";
    
    /**
     * Local da exposição por omissão
     */
    private static final String LOCAL_EXPOSICAO_POR_OMISSAO = "A apresentar o local de realização da exposição selecionada";
   
    /**
     * Data de inicio e de fim da exposição por omissão
     */
    private static final String DATA_INICIO_E_FIM_POR_OMISSAO = "00/00/0000";

    /**
     * Creates new form jFrameListarCandidaturasADemonstracaoRemovidasUI
     */
    public JFrameListarCandidaturasADemonstracaoRemovidasUI(JFrame jFrameMenuPrincipal, CentroExposicoes centroExposicoes, String usernameOrganizador) {
        super("Listar candidaturas a demonstração removidas");
        this.jFrameMenuPrincipal = jFrameMenuPrincipal;
        this.centroExposicoesAtual = centroExposicoes;
        this.usernameOrganizador = usernameOrganizador;
        this.controller = new ListarCandidaturasADemonstracaoRemovidasController(centroExposicoes);
        controller.getRegistoExposicoes();
        listaExposicoesDoOrganizador = controller.getListaExposicoesDoOrganizador(usernameOrganizador);
        initComponents();

        alterarComportamentoFecharJFrame();

        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
        setVisible(true);
    }

    /**
     * Altera o comportamente de clicar no botão de fechar nesta janela
     */
    private void alterarComportamentoFecharJFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                jFrameMenuPrincipal.setVisible(true);
                dispose();
                JOptionPane.showMessageDialog(rootPane, "Fechou a janela antes de terminar o processo."
                        + "%nOs dados escolhidos até ao momento não foram guardados.",
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
        jLabel1Card2Titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneCard1 = new javax.swing.JScrollPane();
        jTextAreaCard1DescricaoDemonstracao = new javax.swing.JTextArea();
        jButtonCard2Avancar = new javax.swing.JButton();
        jButtonCard2Fechar = new javax.swing.JButton();
        jComboBoxEscolherDemonstracao = new javax.swing.JComboBox<>();
        card3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPaneCard3 = new javax.swing.JScrollPane();
        jListCard3ListaCandidaturas = new javax.swing.JList<>();
        jButtonCard3Recuar = new javax.swing.JButton();
        jButtonCard3Fechar = new javax.swing.JButton();

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

        jPanelCard1DescricaoExposicao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descricao", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanelCard1DescricaoExposicao.setLayout(new java.awt.BorderLayout());

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

        jPanelCard1DescricaoExposicao.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanelCard1Duracao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duração", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

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

        jPanelCard1Local.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Local", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jScrollPane2.setBorder(null);

        jTextAreaCard1LocalExposicao.setEditable(false);
        jTextAreaCard1LocalExposicao.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        jTextAreaCard1LocalExposicao.setColumns(20);
        jTextAreaCard1LocalExposicao.setLineWrap(true);
        jTextAreaCard1LocalExposicao.setRows(5);
        jTextAreaCard1LocalExposicao.setText("A apresentar o local da exposição selecionada");
        jTextAreaCard1LocalExposicao.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextAreaCard1LocalExposicao);

        javax.swing.GroupLayout jPanelCard1LocalLayout = new javax.swing.GroupLayout(jPanelCard1Local);
        jPanelCard1Local.setLayout(jPanelCard1LocalLayout);
        jPanelCard1LocalLayout.setHorizontalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1LocalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
        );
        jPanelCard1LocalLayout.setVerticalGroup(
            jPanelCard1LocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1LocalLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jComboBoxEscolherExposicao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxEscolherExposicao.setModel(new ComboBoxModelExposicoes(this.listaExposicoesDoOrganizador));
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
                .addGap(194, 194, 194)
                .addComponent(jLabelCard1Titulo))
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jComboBoxEscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCard1Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButtonCard1Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonCard1Avancar))))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabelCard1Titulo)
                .addGap(11, 11, 11)
                .addComponent(jComboBoxEscolherExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCard1DescricaoExposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addComponent(jPanelCard1Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelCard1Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCard1Fechar)
                            .addComponent(jButtonCard1Avancar)))))
        );

        getContentPane().add(card1, "card1");

        jLabel1Card2Titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1Card2Titulo.setText("Escolha a demonstração pretendida");

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

        jButtonCard2Avancar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard2Avancar.setText("Selecionar demonstração");
        jButtonCard2Avancar.setToolTipText("");
        jButtonCard2Avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard2AvancarActionPerformed(evt);
            }
        });

        jButtonCard2Fechar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard2Fechar.setText("Cancelar");
        jButtonCard2Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard2FecharActionPerformed(evt);
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

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1Card2Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButtonCard2Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButtonCard2Avancar))
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jComboBoxEscolherDemonstracao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1Card2Titulo)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxEscolherDemonstracao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCard2Fechar)
                    .addComponent(jButtonCard2Avancar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(card2, "card3");

        card3.setPreferredSize(new java.awt.Dimension(200, 308));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Lista de Candidaturas Removidas");

        jListCard3ListaCandidaturas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneCard3.setViewportView(jListCard3ListaCandidaturas);

        jButtonCard3Recuar.setText("Recuar");
        jButtonCard3Recuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard3RecuarActionPerformed(evt);
            }
        });

        jButtonCard3Fechar.setText("Fechar");
        jButtonCard3Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard3FecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(card3Layout.createSequentialGroup()
                                .addComponent(jButtonCard3Recuar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCard3Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(card3Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPaneCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCard3Recuar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCard3Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(card3, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCard2AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard2AvancarActionPerformed
        if (jComboBoxEscolherDemonstracao.getSelectedItem() != null) {
            avancarParaCard3();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma demonstração primeiro!", "Demonstração em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard2AvancarActionPerformed

    private void avancarParaCard3() {
        controller.setDemonstracao(listaDemonstracoes.get(jComboBoxEscolherDemonstracao.getSelectedIndex()));
        controller.getRegistoCandidaturasADemonstracaoRemovidas();
        String[] vetorCandidaturasRemovidas = criarVetorListaCandidaturasADemonstracaoRemovidas(controller.getListaCandidaturasADemonstracaoRemovidas());
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        jListCard3ListaCandidaturas.setListData(vetorCandidaturasRemovidas);
        cardLayout.show(getContentPane(), "card2");
        setSize(LARGURA_JANELA_PASSO3, ALTURA_JANELA_PASSO3);
    }

    private String[] criarVetorListaCandidaturasADemonstracaoRemovidas(List<CandidaturaADemonstracao> listaCandidaturas) {
        String[] vetorCandidaturasRemovidas = new String[listaCandidaturas.size()];
        for (int i = 0; i < listaCandidaturas.size(); i++) {
            vetorCandidaturasRemovidas[i] = listaCandidaturas.get(i).getDadosCandidatura();
        }
        return vetorCandidaturasRemovidas;
    }

    private void jButtonCard2FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard2FecharActionPerformed
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card1");
        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
    }//GEN-LAST:event_jButtonCard2FecharActionPerformed

    private void jButtonCard3RecuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard3RecuarActionPerformed
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card2");
        setSize(LARGURA_JANELA_PASSO2, ALTURA_JANELA_PASSO2);
    }//GEN-LAST:event_jButtonCard3RecuarActionPerformed

    private void jButtonCard3FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard3FecharActionPerformed
        setVisible(false);
        jFrameMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButtonCard3FecharActionPerformed

    private void jComboBoxEscolherDemonstracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscolherDemonstracaoActionPerformed
        if (jComboBoxEscolherDemonstracao.getSelectedItem() != null) {
            jTextAreaCard1DescricaoDemonstracao.setText(listaDemonstracoes.get(jComboBoxEscolherDemonstracao.getSelectedIndex()).getDescricao());
        } else {
            jTextAreaCard1DescricaoDemonstracao.setText(DESCRICAO_DEMONSTRACAO_POR_OMISSAO);
        }
    }//GEN-LAST:event_jComboBoxEscolherDemonstracaoActionPerformed

    private void jButtonCard1AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1AvancarActionPerformed
        if (jComboBoxEscolherExposicao.getSelectedItem() != null) {
            avancarParaCard2();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma exposição primeiro!", "Exposição em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard1AvancarActionPerformed

    private void avancarParaCard2() {
        controller.getRegistoDemonstracoes();;
        this.listaDemonstracoes = controller.getListaDemonstracoesDoOrganizadorVariosEstados(usernameOrganizador);
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card2");
        setSize(LARGURA_JANELA_PASSO2, ALTURA_JANELA_PASSO2);
    }

    private void jButtonCard1FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1FecharActionPerformed
        dispose();
        this.jFrameMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButtonCard1FecharActionPerformed

    private void jComboBoxEscolherExposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscolherExposicaoActionPerformed
        if (jComboBoxEscolherExposicao.getSelectedItem() != null) {
            Exposicao expo = listaExposicoesDoOrganizador.get(jComboBoxEscolherExposicao.getSelectedIndex());
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
    }//GEN-LAST:event_jComboBoxEscolherExposicaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JButton jButtonCard1Avancar;
    private javax.swing.JButton jButtonCard1Fechar;
    private javax.swing.JButton jButtonCard2Avancar;
    private javax.swing.JButton jButtonCard2Fechar;
    private javax.swing.JButton jButtonCard3Fechar;
    private javax.swing.JButton jButtonCard3Recuar;
    private javax.swing.JComboBox<String> jComboBoxEscolherDemonstracao;
    private javax.swing.JComboBox<String> jComboBoxEscolherExposicao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1Card2Titulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCard1DataFim;
    private javax.swing.JLabel jLabelCard1DataInicio;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JList<String> jListCard3ListaCandidaturas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCard1DescricaoExposicao;
    private javax.swing.JPanel jPanelCard1Duracao;
    private javax.swing.JPanel jPanelCard1Local;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneCard1;
    private javax.swing.JScrollPane jScrollPaneCard3;
    private javax.swing.JTextArea jTextAreaCard1DescricaoDemonstracao;
    private javax.swing.JTextArea jTextAreaCard1DescricaoExposicao;
    private javax.swing.JTextArea jTextAreaCard1LocalExposicao;
    // End of variables declaration//GEN-END:variables
}
