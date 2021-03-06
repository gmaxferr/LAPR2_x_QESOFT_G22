package lapr.project.ui;

import lapr.project.uiModel.*;
import java.awt.CardLayout;
import java.awt.event.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr.project.controller.AtribuirCandidaturasADemonstracaoController;
import lapr.project.model.*;

/**
 * UI do UC Atribuir candidaturas a demonstracao
 * 
 * @author G29
 */
public class JFrameAtribuirCandidaturasADemonstracaoUI extends javax.swing.JFrame {

    /**
     * JFrame do menu principal. Usada para a voltar a tornar visivél no fim
     * deste UC
     */
    private transient JFrame jFrameMenuPrincipal;
    
    /**
     * Username do organizador
     */
    private transient final String usernameOrganizador;
    
    /**
     * Centro de exposições
     */
    private transient CentroExposicoes centroExposicoes;
    
    /**
     * Controller deste UC
     */
    private transient AtribuirCandidaturasADemonstracaoController controller;
    
    /**
     * Lista de exposições utilizadas para a execução deste UC
     */
    transient List<Exposicao> listaExposicoesDoOrganizador;
    
    /**
     * Lista de demonstrações utilizadas para a execução deste UC
     */
    private transient List<Demonstracao> listaDemonstracoesDoOrganizador;
    
    /**
     * Lista de mecanismos
     */
    private transient List<Mecanismo> listaMecanismos;
    
    /**
     * Vetor com a lista de mecanismos
     */
    private transient String[] listaNomeMecanismos;
    
    /**
     * Mecanismo selecionado
     */
    private transient Mecanismo mecanismoEscolhido;
    
    /**
     * Lista de atribuicoes candidatura a demonstração
     */
    private transient List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoes;
    
    /**
     * JTable 
     */
    private transient ModeloJTableUtilizadores modeloJTableFAEPorCandidatura;

    private static final int LARGURA_JANELA_PASSO1 = 705;
    private static final int ALTURA_JANELA_PASSO1 = 382;

    private static final int LARGURA_JANELA_PASSO2 = 589;
    private static final int ALTURA_JANELA_PASSO2 = 335;

    private static final int LARGURA_JANELA_PASSO3 = 620;
    private static final int ALTURA_JANELA_PASSO3 = 350;

    private static final int LARGURA_JANELA_PASSO4 = 800;
    private static final int ALTURA_JANELA_PASSO4 = 400;

    /**
     * Vetor com as opções sim ou não
     */
    private static final String[] OPCOES_SIM_NAO_DIALOG = {"Sim", "Não"};
    
    /**
     * Descrição da exposição por omissão
     */
    private static final String DESCRICAO_EXPOSICAO_POR_OMISSAO = "A apresentar a descrição da esposição selecionada";
    
    /**
     * Local da exposição por omissão
     */
    private static final String LOCAL_EXPOSICAO_POR_OMISSAO = "A apresentar o nome do local de realização para a exposição selecionada";
    
    /**
     * Data de inicio e de fim da exposição por omissão
     */
    private static final String DATA_INICIO_E_FIM_POR_OMISSAO = "00/00/0000";
    
    /**
     * Descrição do mecanismo por omissão
     */
    private static final String DESCRICAO_MECANISMO_POR_OMISSAO = "A apresentar uma breve discrição sobre como o mecanismo funciona e este distribui os FAE's pelas candidaturas existentes.";
    
    /**
     * Descrição da demonstração por omissao
     */
    private static final String DESCRICAO_DEMONSTRACAO_POR_OMISSAO = "A apresentar a descricao da exposição selecionada.";

    
    /**
     * Creates new form JFrameAtribuirCandidaturasADemonstracaoUI
     */
    public JFrameAtribuirCandidaturasADemonstracaoUI(JFrame jFrameMenuPrincipal, String usernameOrganizador, CentroExposicoes centroExposicoes) {
         super("Atribuir candidaturas a demonstração");

        this.jFrameMenuPrincipal = jFrameMenuPrincipal;
        this.usernameOrganizador = usernameOrganizador;
        this.centroExposicoes = centroExposicoes;
        controller = new AtribuirCandidaturasADemonstracaoController(this.centroExposicoes);
        controller.getRegistoExposicoes();
        this.listaExposicoesDoOrganizador = controller.getListaExposicoesDoOrganizadorEstadoConflitosAlterados(usernameOrganizador);

        initComponents();
        alterarComportamentoFecharJFrame();

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
        jLabel1Card1Titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPaneCard1 = new javax.swing.JScrollPane();
        jTextAreaCard1DescricaoDemonstracao = new javax.swing.JTextArea();
        jButtonCard1Avancar1 = new javax.swing.JButton();
        jButtonCard1Fechar1 = new javax.swing.JButton();
        jComboBoxEscolherDemonstracao = new javax.swing.JComboBox<>();
        card3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCard3EscolherMecanismo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaCard2DescricaoMecanismo = new javax.swing.JTextArea();
        jButtonCard3Recuar = new javax.swing.JButton();
        jButtonCard3Avancar = new javax.swing.JButton();
        jPanelCard2DadosAdicionais = new javax.swing.JPanel();
        jLabelCard3DadosAdicionais = new javax.swing.JLabel();
        jTextFieldDadosAdicionais = new javax.swing.JTextField();
        card4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBoxCard4EscolherCandidatura = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jLabel1Card1Titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1Card1Titulo.setText("Escolha a demonstração pretendida");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jScrollPaneCard1.setBorder(null);

        jTextAreaCard1DescricaoDemonstracao.setEditable(false);
        jTextAreaCard1DescricaoDemonstracao.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        jTextAreaCard1DescricaoDemonstracao.setColumns(20);
        jTextAreaCard1DescricaoDemonstracao.setLineWrap(true);
        jTextAreaCard1DescricaoDemonstracao.setRows(5);
        jTextAreaCard1DescricaoDemonstracao.setText("A apresentar a descrição da demonstração selecionada");
        jTextAreaCard1DescricaoDemonstracao.setWrapStyleWord(true);
        jScrollPaneCard1.setViewportView(jTextAreaCard1DescricaoDemonstracao);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneCard1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneCard1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );

        jButtonCard1Avancar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard1Avancar1.setText("Selecionar demonstração");
        jButtonCard1Avancar1.setToolTipText("");
        jButtonCard1Avancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard1Avancar1ActionPerformed(evt);
            }
        });

        jButtonCard1Fechar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCard1Fechar1.setText("Cancelar");
        jButtonCard1Fechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard1Fechar1ActionPerformed(evt);
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
                            .addComponent(jLabel1Card1Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButtonCard1Fechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButtonCard1Avancar1))
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jComboBoxEscolherDemonstracao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1Card1Titulo)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxEscolherDemonstracao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCard1Fechar1)
                    .addComponent(jButtonCard1Avancar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(card2, "card2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Escolha o mecanismo pretendido");

        jComboBoxCard3EscolherMecanismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCard3EscolherMecanismoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jScrollPane3.setBorder(null);

        jTextAreaCard2DescricaoMecanismo.setEditable(false);
        jTextAreaCard2DescricaoMecanismo.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        jTextAreaCard2DescricaoMecanismo.setColumns(20);
        jTextAreaCard2DescricaoMecanismo.setLineWrap(true);
        jTextAreaCard2DescricaoMecanismo.setRows(5);
        jTextAreaCard2DescricaoMecanismo.setText("A apresentar a descrição do funcionamento do mecanismo selecionado");
        jTextAreaCard2DescricaoMecanismo.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextAreaCard2DescricaoMecanismo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );

        jButtonCard3Recuar.setText("Recuar");
        jButtonCard3Recuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard3RecuarActionPerformed(evt);
            }
        });

        jButtonCard3Avancar.setText("Avancar");
        jButtonCard3Avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCard3AvancarActionPerformed(evt);
            }
        });

        jLabelCard3DadosAdicionais.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCard3DadosAdicionais.setText("Introduza o número de ...");
        jPanelCard2DadosAdicionais.add(jLabelCard3DadosAdicionais);

        jTextFieldDadosAdicionais.setColumns(5);
        jPanelCard2DadosAdicionais.add(jTextFieldDadosAdicionais);

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jPanelCard2DadosAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButtonCard3Recuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCard3Avancar)
                .addGap(42, 42, 42))
            .addGroup(card3Layout.createSequentialGroup()
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card3Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel3))
                    .addGroup(card3Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jComboBoxCard3EscolherMecanismo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 158, Short.MAX_VALUE))
            .addGroup(card3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jComboBoxCard3EscolherMecanismo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelCard2DadosAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCard3Recuar)
                    .addComponent(jButtonCard3Avancar)))
        );

        getContentPane().add(card3, "card3");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Distribuição gerada por candidatura");

        this.modeloJTableFAEPorCandidatura = new ModeloJTableUtilizadores();
        jTable1.setModel(modeloJTableFAEPorCandidatura);
        jScrollPane4.setViewportView(jTable1);

        jComboBoxCard4EscolherCandidatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCard4EscolherCandidaturaActionPerformed(evt);
            }
        });

        jLabel6.setText("Candidatura:");

        jButton3.setText("Recuar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Registar distribuição");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card4Layout = new javax.swing.GroupLayout(card4);
        card4.setLayout(card4Layout);
        card4Layout.setHorizontalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(31, 31, 31))
            .addGroup(card4Layout.createSequentialGroup()
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card4Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCard4EscolherCandidatura, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card4Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        card4Layout.setVerticalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCard4EscolherCandidatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(22, 22, 22))
        );

        getContentPane().add(card4, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCard1AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1AvancarActionPerformed
        if (jComboBoxEscolherExposicao.getSelectedItem() != null) {
            avancarParaPasso2();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma exposição primeiro!", "Exposição em falta", JOptionPane.WARNING_MESSAGE);
        }
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card2");
    }//GEN-LAST:event_jButtonCard1AvancarActionPerformed

    private void avancarParaPasso2(){
        controller.setExposicao(listaExposicoesDoOrganizador.get(jComboBoxEscolherExposicao.getSelectedIndex())); //entra com a expo escolhida da combobox
        controller.getRegistoDemonstracoes();
        this.listaDemonstracoesDoOrganizador = controller.getListaDemonstracoesEstadoCandidaturasFechadas(usernameOrganizador);
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

    private void jComboBoxCard4EscolherCandidaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCard4EscolherCandidaturaActionPerformed
        List<Utilizador> listaUtilizadoresAssociadosAosFAE = listaAtribuicoes.get(jComboBoxCard4EscolherCandidatura.getSelectedIndex()).getRegistoFaeAvaliacao().getListaUtilizadoresAssociadoAosFAE();
        modeloJTableFAEPorCandidatura.setLista(listaUtilizadoresAssociadosAosFAE);
        modeloJTableFAEPorCandidatura.fireTableDataChanged();
    }//GEN-LAST:event_jComboBoxCard4EscolherCandidaturaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card3");
        setSize(LARGURA_JANELA_PASSO2, ALTURA_JANELA_PASSO2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (!listaAtribuicoes.isEmpty()) {
            finalizarDistribuicao();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma atribuição gerada para a respectiva exposição com este mecanismo.", "Sem atribuições", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void finalizarDistribuicao() {
        int resposta = JOptionPane.showOptionDialog(rootPane, "Tem a certeza que pretende esta distribuição?", "Terminar", 0, JOptionPane.QUESTION_MESSAGE, null, OPCOES_SIM_NAO_DIALOG, OPCOES_SIM_NAO_DIALOG[1]);
        if (resposta == 0) {
            controller.registaAtribuicao(listaAtribuicoes);
            controller.setEstadoCandidaturaAtribuida();
            setVisible(false);
            JOptionPane.showMessageDialog(rootPane, "Distribuição registada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            jFrameMenuPrincipal.setVisible(true);
        }
    }
    
    private void jComboBoxCard3EscolherMecanismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCard3EscolherMecanismoActionPerformed
        if (jComboBoxCard3EscolherMecanismo.getSelectedItem() != null) {
            switch (jComboBoxCard3EscolherMecanismo.getSelectedIndex()) {
                case 0:
                    jPanelCard2DadosAdicionais.setVisible(false);
                    break;
                case 1:

                    jPanelCard2DadosAdicionais.setVisible(true);
                    jLabelCard3DadosAdicionais.setText("Número de FAE:");
                    break;
                case 2:
                    jPanelCard2DadosAdicionais.setVisible(true);
                    jLabelCard3DadosAdicionais.setText("Anos de experiência:");
                    break;
                default:
                    break;
            }
            mecanismoEscolhido = listaMecanismos.get(jComboBoxCard3EscolherMecanismo.getSelectedIndex());
            jTextAreaCard2DescricaoMecanismo.setText(mecanismoEscolhido.getDescricao());
        } else {
            jTextAreaCard2DescricaoMecanismo.setText(DESCRICAO_MECANISMO_POR_OMISSAO);
        }
    }//GEN-LAST:event_jComboBoxCard3EscolherMecanismoActionPerformed

    private void jButtonCard3RecuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard3RecuarActionPerformed
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card2");
        setSize(LARGURA_JANELA_PASSO1, ALTURA_JANELA_PASSO1);
    }//GEN-LAST:event_jButtonCard3RecuarActionPerformed

    private void jButtonCard3AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard3AvancarActionPerformed
        if (jComboBoxCard3EscolherMecanismo.getSelectedItem() != null) {
            controller.getRegistoAtribuicoes();
            if (jComboBoxCard3EscolherMecanismo.getSelectedIndex() == 0) {
                listaAtribuicoes = controller.atribui(mecanismoEscolhido);
                if (!listaAtribuicoes.isEmpty()) {
                    jComboBoxCard4EscolherCandidatura.setModel(new ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura(listaAtribuicoes));
                    avancarParaCard4();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não foi gerada nenhuma atribuição! Verifique se existem FAE/Candidaturas suficientes", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                try {
                    String dadosAdicionais = jTextFieldDadosAdicionais.getText();
                    listaAtribuicoes = controller.atribui(mecanismoEscolhido, dadosAdicionais);
                    if (!listaAtribuicoes.isEmpty()) {
                        jComboBoxCard4EscolherCandidatura.setModel(new ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura(listaAtribuicoes));
                        avancarParaCard4();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Não foi gerada nenhuma atribuição! Verifique se existem FAE/Candidaturas suficientes", "Erro", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(rootPane, jLabelCard3DadosAdicionais.getText().replace(":", "") + " não válido!", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhum mecanismo selecionado!", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard3AvancarActionPerformed

    private void avancarParaCard4() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card4");
        setSize(LARGURA_JANELA_PASSO4, ALTURA_JANELA_PASSO4);
    }
    
    private void jButtonCard1Avancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1Avancar1ActionPerformed
        if (jComboBoxEscolherDemonstracao.getSelectedItem() != null) {
            avancarParaCard3();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tem de selecionar uma demonstração primeiro!", "Demonstração em falta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCard1Avancar1ActionPerformed

    private void avancarParaCard3(){
        controller.setDemonstracao(listaDemonstracoesDoOrganizador.get(jComboBoxEscolherDemonstracao.getSelectedIndex()));
        controller.getRegistoMecanismos();
        listaMecanismos = controller.getListaMecanismos();
        jComboBoxCard3EscolherMecanismo.setModel(new ComboBoxModelMecanismos(this.listaMecanismos));
        preencherListaNomeMecanismos();
        jPanelCard2DadosAdicionais.setVisible(false);
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card3");
        setSize(LARGURA_JANELA_PASSO3, ALTURA_JANELA_PASSO3);
    }
    
    public void preencherListaNomeMecanismos() {
        this.listaNomeMecanismos = new String[this.listaMecanismos.size() + 1];
        this.listaNomeMecanismos[0] = "Nenhum mecanismo selecionado";
        for (int i = 0; i < this.listaMecanismos.size(); i++) {
            this.listaNomeMecanismos[i + 1] = this.listaMecanismos.get(i).getNome();
        }
    }
    
    private void jButtonCard1Fechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCard1Fechar1ActionPerformed
        dispose();
        this.jFrameMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButtonCard1Fechar1ActionPerformed

    private void jComboBoxEscolherDemonstracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscolherDemonstracaoActionPerformed
        if (jComboBoxEscolherDemonstracao.getSelectedItem() != null) {
            jTextAreaCard1DescricaoDemonstracao.setText(listaDemonstracoesDoOrganizador.get(jComboBoxEscolherDemonstracao.getSelectedIndex()).getDescricao());
        } else {
            jTextAreaCard1DescricaoDemonstracao.setText(DESCRICAO_DEMONSTRACAO_POR_OMISSAO);
        }
    }//GEN-LAST:event_jComboBoxEscolherDemonstracaoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonCard1Avancar;
    private javax.swing.JButton jButtonCard1Avancar1;
    private javax.swing.JButton jButtonCard1Fechar;
    private javax.swing.JButton jButtonCard1Fechar1;
    private javax.swing.JButton jButtonCard3Avancar;
    private javax.swing.JButton jButtonCard3Recuar;
    private javax.swing.JComboBox<String> jComboBoxCard3EscolherMecanismo;
    private javax.swing.JComboBox<String> jComboBoxCard4EscolherCandidatura;
    private javax.swing.JComboBox<String> jComboBoxEscolherDemonstracao;
    private javax.swing.JComboBox<String> jComboBoxEscolherExposicao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1Card1Titulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCard1DataFim;
    private javax.swing.JLabel jLabelCard1DataInicio;
    private javax.swing.JLabel jLabelCard1Titulo;
    private javax.swing.JLabel jLabelCard3DadosAdicionais;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCard1DescricaoExposicao;
    private javax.swing.JPanel jPanelCard1Duracao;
    private javax.swing.JPanel jPanelCard1Local;
    private javax.swing.JPanel jPanelCard2DadosAdicionais;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPaneCard1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaCard1DescricaoDemonstracao;
    private javax.swing.JTextArea jTextAreaCard1DescricaoExposicao;
    private javax.swing.JTextArea jTextAreaCard1LocalExposicao;
    private javax.swing.JTextArea jTextAreaCard2DescricaoMecanismo;
    private javax.swing.JTextField jTextFieldDadosAdicionais;
    // End of variables declaration//GEN-END:variables
}
