package lapr.project.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import lapr.project.model.*;
import lapr.project.utils.Utilitarios;

/**
 *
 * @author Guilherme
 */
public class LoginGui extends JFrame {

    //Strings
    private static final String FRAME_TITLE = "Login";
    private static final String LABEL_USERNAME = "Username:";
    private static final String LABEL_PASSWORD = "Password: ";
    private static final String TEXT_LOGIN_BUTTON = "Login";
    private static final String TEXT_HELP_BUTTON = "Ajuda";

    private Font font = new Font("Arial", 0, 14);
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton helpButton;
    private ImageIcon iconeLogin = new ImageIcon("login.png");
    private ImageIcon iconeWelcome = new ImageIcon("Welcome.png");
    CentroExposicoes centroExposicoes;
    Utilizador utilizador;

    private final Color background = new Color(0, 204, 102);
    private final Color grey = new Color(192, 192, 192);

    /**
     * Cria um GUI para o menu de Login recebendo como parametro o Centro de
     * Exposicoes (Contentor de toda a informação).
     *
     * @param centroExposicoes Centro de Exposições em que vamos iniciar sessão
     */
    public LoginGui(CentroExposicoes centroExposicoes) {
        super(FRAME_TITLE);
        this.centroExposicoes = centroExposicoes;

        createComponents();
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Cria todos os componentes da janela de login
     *
     * @param data - Ficheiro onde é guardada e lida toda a informação que o
     * programa utiliza
     */
    public void createComponents() {
        //Titulo do login
        JLabel title = new JLabel(FRAME_TITLE);

        Font titleFont = title.getFont();
        //Altera o tamanho do titulo
        title.setFont(new Font(titleFont.getName(), titleFont.getStyle(), 32));
        title.setForeground(grey);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
        titlePanel.setBackground(background.darker());
        titlePanel.add(title);
        JLabel imagem = new JLabel(iconeLogin);
        titlePanel.add(imagem);
        titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        add(titlePanel, BorderLayout.NORTH);

        setBackground(background.darker());

        //Area de login
        add(new LoginArea(), BorderLayout.CENTER);

        //Area de butoes
        add(new ButtonArea(this), BorderLayout.SOUTH);
    }

    /**
     * Componente contendo 2 JLabels, 1 JTextField e 1 JPasswordField formando a
     * area onde o utilizador vai introduzir os dados
     */
    private class LoginArea extends JPanel {

        public LoginArea() {
            super(new GridLayout(2, 1));
            setBackground(background.darker());
            //Painel do username
            JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 2));
            JLabel login = new JLabel(LABEL_USERNAME);
            login.setFont(font);
            usernamePanel.add(login);
            usernameField = new JTextField(15);
            usernameField.setToolTipText("Insira o seu username de inicio de sessão");
            usernamePanel.add(usernameField);
            super.add(usernamePanel);

            //Painel da password
            JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 2));
            JLabel password = new JLabel(LABEL_PASSWORD);
            password.setFont(font);
            passwordPanel.add(password);
            passwordField = new JPasswordField(15);
            passwordField.setToolTipText("Insira a sua password se inicio de sessão");
            passwordPanel.add(passwordField);
            super.add(passwordPanel);
        }
    }

    /**
     * Area dos botoes no painel de login
     */
    private class ButtonArea extends JPanel {

        public ButtonArea(JFrame f) {
            super(new FlowLayout(FlowLayout.CENTER, 20, 5));
            setBackground(background.darker());

            //Botao de login
            loginButton = new JButton(TEXT_LOGIN_BUTTON);
            loginButton.setToolTipText("Fazer login");
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    botaoLoginClicado();
                }
            });

            //Botao de ajuda
            helpButton = new JButton(TEXT_HELP_BUTTON);
            helpButton.setToolTipText("Ajuda sobre Login");
            helpButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "\tUtilizador predefinido ADMIN:"
                            + "\n\nUsername: admin"
                            + "\nPassword: admin"
                            + "\n\nEstes são os valores por defeito do"
                            + "\nprograma quando este é iniciado pela"
                            + "\nprimeira vez. Sugere-se que se altere"
                            + "\na palavra-passe logo após o login.", "Ajuda Login", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            add(loginButton);
            add(helpButton);
            f.getRootPane().setDefaultButton(loginButton);
        }

    }

    /**
     * botaoLoginClicado: O que acontece quando o botao de login é clicado
     *
     * @param data - Ficheiro onde é guardada e lida toda a informação que o
     * programa utiliza
     */
    public void botaoLoginClicado() {
        String user = usernameField.getText().trim();
        char[] pass = passwordField.getPassword();

        if (user.length() == 0 || pass.length == 0) {
            JOptionPane.showMessageDialog(null, "Login nao efetuado."
                    + "\nUsername e Password são campos obrigatórios.", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            utilizador = Utilitarios.autenticacao(user, pass, centroExposicoes);
            if (utilizador != null) {
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE, iconeWelcome);
                loginEfetuadoComSuccesso();
            } else {
                JOptionPane.showMessageDialog(null, "Login nao efetuado. Username e/ou password incorretos.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * loginEfetuadoComSuccesso: O que acontece quando o login é efetuado com
     * successo
     */
    private void loginEfetuadoComSuccesso() {
        new MainMenuGUI(centroExposicoes, utilizador);
        dispose();
    }
}
