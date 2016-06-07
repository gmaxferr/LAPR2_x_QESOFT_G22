package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;

/**
 * Menu Principal disponivel a todos os utilizadores a partir do momento em que
 * fazem login e lhes permite accesso a todo o resto do sistema.
 *
 * @author Ricardo Catalao
 *
 */
public class MainMenuGUI extends JFrame {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JPanel infoPanel;
    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JPanel southPanel;
    private JButton button;

    private final Color background = new Color(0, 204, 102);
    private final Color grey = new Color(192, 192, 192);

    private final Utilizador utilizador;
    private final CentroExposicoes centroExposicoes;
    private final JFrame thisJFrame;

    /**
     * Janela principal depois de iniciar sessão
     *
     * @param centroExposicoes
     * @param utilizador - Utilizador que fez login
     */
    public MainMenuGUI(CentroExposicoes centroExposicoes, Utilizador utilizador) {
        super("Main menu");
        this.utilizador = utilizador;
        this.centroExposicoes = centroExposicoes;
        this.thisJFrame = (JFrame) SwingUtilities.getRoot(this);
        criaBase();
        createWindow();

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);

        //Leitura do ficheiro
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//                int op = JOptionPane.showConfirmDialog(null, "Deseja salvar todas as alterações feitas?");
//                if (op == JOptionPane.YES_OPTION) {
//                    new IO_BinFile().save(saveFile, centroExposicoes);
//                    System.exit(0);
//                } else if (op == JOptionPane.NO_OPTION) {
//                    System.exit(0);
//                }
//            }
//        });
        paint();

    }

    /**
     * Cria a base da janela do menu principal
     */
    public void criaBase() {
        //Cria a barra de menu
        criaBarraDeMenu();

        infoPanel = createInfoPanel();
        infoPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        add(infoPanel, BorderLayout.NORTH);
    }

    /**
     * Cria a barra de menu
     */
    private void criaBarraDeMenu() {
        //Criar a barra de menu
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //Cria um menu para fazer operações com a conta de utilizador
        menu = new JMenu("Conta");
        menu.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menu);

        //Cria botao de editar dados de accesso
        menuItem = new JMenuItem("Editar Perfil");
        menuItem.getAccessibleContext().setAccessibleDescription("Permite a alteração do nome e palavra-passe no sistema.");    //Nao permite a alteração do username nem do e-mail para não correr o risco de se tornar num utilizador não único
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        menu.add(menuItem);

        //Cria botao de terminar sessão
        menuItem = new JMenuItem("Terminar Sessão");
        menuItem.getAccessibleContext().setAccessibleDescription("Terminar sessão no sistema");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                int op = JOptionPane.showConfirmDialog(null, "Deseja salvar todas as alterações feitas?");
//                if (op == JOptionPane.YES_OPTION) {
//                    new IO_BinFile().save(saveFile, ce);
//                    terminaSessao(saveFile);
//                } else if (op == JOptionPane.NO_OPTION) {
//                    terminaSessao(saveFile);
//                }
            }
        }
        );
        menu.add(menuItem);
    }

    /**
     * cria o painel com a informação do utilizador
     *
     * @return
     */
    private JPanel createInfoPanel() {
        infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBorder(BorderFactory.createEtchedBorder());

        String nomeUtilizador = utilizador.getM_strNome();
        if (nomeUtilizador.length() > 20) {
            nomeUtilizador = nomeUtilizador.substring(0, 17) + "...";
        }
        JLabel introInfo = new JLabel("Sessao iniciada como: " + nomeUtilizador);
        infoPanel.add(introInfo);

        return infoPanel;
    }

    /**
     * Ação do botão terminar sessão (retorna ao menu de login)
     *
     * @param data - ficheiro com a informação guardada
     */
    private void terminaSessao(File data) {
        new LoginGui(centroExposicoes);
        dispose();
    }

    /**
     * Cria a janela do menu principal
     */
    private void createWindow() {
        //Painel para o cabeçalho do menu principal
        JPanel titlePanel = createTitlePanel();
        add(titlePanel, BorderLayout.CENTER);

        //Painel com os botoes do menu principal
        criaPainelComBotoes();
    }

    /**
     * cria painel com o título da janela
     *
     * @return
     */
    private JPanel createTitlePanel() {
        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel title = new JLabel("Menu Principal");
        Font titleFont = title.getFont();
        title.setFont(new Font(titleFont.getName(), titleFont.getStyle(), 28));
        titlePanel.add(title);
        titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        return titlePanel;
    }

    /**
     * Cria um Painel com os vários botões a apresnetar
     */
    private void criaPainelComBotoes() {
        buttonPanel = new JPanel(new GridLayout(3, 4, 30, 10));
        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        southPanel.add(buttonPanel);
        southPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        add(southPanel, BorderLayout.SOUTH);

        //Botao exposicoes
        button = criarBotaoExposicoes();
        button.setEnabled(true);
        button.setBackground(grey);
        button.setContentAreaFilled(true);
        buttonPanel.add(button);
        ImageIcon iconeExpo = new ImageIcon("expo.png");
        buttonPanel.add(new JLabel(iconeExpo));
        //Botao candidaturas
        button = criarButaoExecutarUCCriarCandidatura();
        button.setEnabled(true);
        button.setBackground(grey);
        button.setContentAreaFilled(true);
        buttonPanel.add(button);
        iconeExpo = new ImageIcon("candidatura.png");
        buttonPanel.add(new JLabel(iconeExpo));
        //Botao conflitos
        button = criarBotaoConflitos();
        button.setEnabled(true);
        button.setBackground(grey);
        button.setContentAreaFilled(true);
        buttonPanel.add(button);
        iconeExpo = new ImageIcon("conflitos.png");
        buttonPanel.add(new JLabel(iconeExpo));
        //Botao utilizadores
        button = criarBotaoUtilizadores();
        button.setEnabled(true);
        button.setBackground(grey);
        button.setContentAreaFilled(true);
        buttonPanel.add(button);
        iconeExpo = new ImageIcon("utilizadores.png");
        buttonPanel.add(new JLabel(iconeExpo));
        //Botao recursos
        button = criarBotaoRecursos();
        button.setEnabled(false);
        button.setBackground(grey);
        button.setContentAreaFilled(true);
        buttonPanel.add(button);
        iconeExpo = new ImageIcon("recursos.png");
        buttonPanel.add(new JLabel(iconeExpo));
        //Botao sair
        button = criarBotaoSair();
        button.setEnabled(true);
        button.setBackground(grey);
        button.setContentAreaFilled(true);
        buttonPanel.add(button);
        iconeExpo = new ImageIcon("sair.png");
        buttonPanel.add(new JLabel(iconeExpo));
    }

    /**
     * Cria botão que abre opções: Criar Exposição, Definir FAEs,
     *
     * @return
     */
    private JButton criarBotaoExposicoes() {
        JButton button = new JButton("Atribuir cand");
        Font font = button.getFont();
        button.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new JFrameAtribuirCandidaturasUI(thisJFrame, utilizador.getM_StrUsername(), centroExposicoes);
            }
        });
        return button;
    }

    /**
     * Cria botão que abre opções:
     *
     * @return
     */
    private JButton criarButaoExecutarUCCriarCandidatura() {
        JButton button = new JButton("Candidaturas");
        Font font = button.getFont();
        button.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new JFrameCriarCandidaturaAExposicaoUI(thisJFrame, centroExposicoes, centroExposicoes.getExpositorPeloUsername(utilizador.getM_StrUsername()));
            }
        });
        return button;
    }
    
    /**
     * Cria botão que abre opções:
     *
     * @return
     */
    private JButton criarBotaoConflitos() {
        JButton button = new JButton("Conflitos");
        Font font = button.getFont();
        button.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        return button;
    }

    /**
     * Cria botão que abre opções:
     *
     * @return
     */
    private JButton criarBotaoUtilizadores() {
        JButton button = new JButton("Utilizadores");
        Font font = button.getFont();
        button.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        return button;
    }

    /**
     * Cria botão que abre opções:
     *
     * @return
     */
    private JButton criarBotaoRecursos() {
        JButton button = new JButton("Recursos");
        Font font = button.getFont();
        button.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        return button;
    }

    /**
     * Botão Sair de aplicação
     *
     * @return botão que sai da exposição
     */
    private JButton criarBotaoSair() {
        JButton button = new JButton("Sair");
        Font font = button.getFont();
        button.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
        JFrame mainWindow = this;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));
            }
        });
        return button;
    }

    public void paint() {
        setBackground(background);
        southPanel.setBackground(background);
        menuBar.setBackground(background);
        menuBar.setBorderPainted(true);
        buttonPanel.setBackground(background);
        infoPanel.setBackground(grey);
        titlePanel.setBackground(grey);
    }
}
