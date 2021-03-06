package lapr.project.ui;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.QualidadeFaeCalculo.Media;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Node;

/**
 * Menu principal da aplicação. Permite o acesso a todas as funcionalidades
 * (UC's), verificar as permissões que o utilizador tem, alternar entre vários
 * estilos da janela
 *
 * @author G29
 */
public class MenuV2 extends javax.swing.JFrame {

    private transient CentroExposicoes centroExposicoes;

    private transient final Utilizador utilizador;
    private transient final JFrame thisJFrame;

    /**
     * Creates new form Menu
     *
     * @param centroExposicoes
     * @param utilizador
     */
    public MenuV2(CentroExposicoes centroExposicoes, Utilizador utilizador) {
        super("Main menu");
        this.utilizador = utilizador;
        this.centroExposicoes = centroExposicoes;
        this.thisJFrame = (JFrame) SwingUtilities.getRoot(this);

        initComponents();
        desativarJTabbedPanelDosCargos();
        identificarCargosDoUtilizador();
        modificarFecharJanela();
        addJMenuItemsEstilosDaJanela();

        setVisible(true);
        setLocationRelativeTo(null);
        setSize(1400, 560);
    }

    /**
     * Desativa as tabs no JTabbedPane responsável por mostrar os cargos e
     * respectivas permissões
     */
    private void desativarJTabbedPanelDosCargos() {
        jTabbedPaneCargos.setEnabledAt(0, false);
        jTabbedPaneCargos.setEnabledAt(1, false);
        jTabbedPaneCargos.setEnabledAt(2, false);
        jTabbedPaneCargos.setEnabledAt(3, false);
        jTabbedPaneCargos.setEnabledAt(4, false);
    }

    /**
     * Identifica os cargos do utilizador atualmente a utilizador o menu e
     * atualiza os botões disponiveis de acordo com os privilégios do cargo
     * deste.
     */
    public void identificarCargosDoUtilizador() {
        this.jLabelNomeUtilizador.setText(utilizador.getNome());
        boolean temPapeis = false;
        if (utilizador.isGestor()) {
            this.jCheckBoxGestor.setSelected(true);
            jTabbedPaneCargos.setEnabledAt(2, true);
            temPapeis = true;
        }
        if (centroExposicoes.isFae(utilizador)) {
            this.jCheckBoxFAE.setSelected(true);
            jTabbedPaneCargos.setEnabledAt(1, true);
            temPapeis = true;
        }
        if (centroExposicoes.isExpositor(utilizador)) {
            this.jCheckBoxExpositor.setSelected(true);
            jTabbedPaneCargos.setEnabledAt(0, true);
            temPapeis = true;
        }
        if (centroExposicoes.isOrganizador(utilizador)) {
            this.jCheckBoxOrganizador.setSelected(true);
            jTabbedPaneCargos.setEnabledAt(4, true);
            temPapeis = true;
        }
        if (!temPapeis) {
            jTabbedPaneCargos.setEnabledAt(3, true);
        }
        for (int i = 0; i < 5; i++) {
            if (jTabbedPaneCargos.isEnabledAt(i)) {
                jTabbedPaneCargos.setSelectedIndex(i);
                break;
            }
        }
    }

    private void modificarFecharJanela() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                int op = JOptionPane.showConfirmDialog(null, "Deseja salvar todas as alterações feitas?");
                if (op == JOptionPane.YES_OPTION) {
                    JFileChooser fc = new JFileChooser();
                    ExportarXMLController CTRL = new ExportarXMLController();

                    File properties = new File(CentroExposicoes.PROPERTIES_FILE_LOCATION);
                    boolean successfulExport = false;

                    try {
                        Scanner in = new Scanner(properties);

                        while (in.hasNext()) {
                            String[] input = in.nextLine().split("=");
                            if (input[0].trim().equalsIgnoreCase("saveFileLocation")) {
                                String[] filePath = input[1].split("\".*\"");
                                if (filePath.length > 0) {
                                    File file = new File(filePath[0]);
                                    if (!file.exists()) {
                                        break;
                                    }
                                    if (CTRL.export(filePath[0], centroExposicoes)) {
                                        JOptionPane.showMessageDialog(null, "Informação gravada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                                        successfulExport = true;
                                        dispose();
                                        System.exit(0);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Erro na gravação dos dados.", "ERRO", JOptionPane.ERROR_MESSAGE);
                                        successfulExport = false;
                                    }
                                }
                            }
                        }

                        in.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MenuV2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (!successfulExport) {
                        int returnVal = fc.showSaveDialog(thisJFrame);
                        if (returnVal == JFileChooser.APPROVE_OPTION) {
                            File f = fc.getSelectedFile();
                            String fileName = f.getAbsolutePath();
                            if (CTRL.exportAndUpdateProperties(fileName, centroExposicoes)) {
                                JOptionPane.showMessageDialog(null, "Informação guardada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                                System.exit(0);
                            } else {
                                JOptionPane.showMessageDialog(null, "Erro na gravação da informação.", "ERRO", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } else if (op == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
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
        jLabel1 = new javax.swing.JLabel();
        jLabelNomeUtilizador = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxFAE = new javax.swing.JCheckBox();
        jCheckBoxOrganizador = new javax.swing.JCheckBox();
        jCheckBoxGestor = new javax.swing.JCheckBox();
        jCheckBoxExpositor = new javax.swing.JCheckBox();
        jTabbedPaneCargos = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemCarregarDados = new javax.swing.JMenuItem();
        jMenuItemGuardarDados = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemTerminarSessao = new javax.swing.JMenuItem();
        jMenuEstiloDaJanela = new javax.swing.JMenu();
        jMenuItemEstiloDaJanela = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Sessão iniciada como:");

        jLabelNomeUtilizador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jButton7.setText("Alterar perfil");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNomeUtilizador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNomeUtilizador)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("FAE");

        jLabel4.setText("Organizador");

        jLabel5.setText("Gestor");

        jLabel6.setText("Expositor");

        jLabel2.setText("Detem cargos de:");

        jCheckBoxFAE.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxFAE.setEnabled(false);
        jCheckBoxFAE.setFocusable(false);
        jCheckBoxFAE.setRequestFocusEnabled(false);
        jCheckBoxFAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFAEActionPerformed(evt);
            }
        });

        jCheckBoxOrganizador.setEnabled(false);

        jCheckBoxGestor.setEnabled(false);

        jCheckBoxExpositor.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBoxExpositor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(66, 66, 66)
                        .addComponent(jCheckBoxFAE, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(76, 76, 76)
                        .addComponent(jCheckBoxOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(86, 86, 86)
                        .addComponent(jCheckBoxGestor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxExpositor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBoxFAE, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jCheckBoxOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel5)
                    .addComponent(jCheckBoxGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jButton6.setText("Remover candidatura à exposição");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton26.setText("Confrmar stands");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("Registar candidatura à demonstração");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("Remover candidatura à demonstração");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton5.setText("Alterar candidatura à exposição");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton31.setText("Alterar candidatura à demonstração");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("quando a sua candidatura a exposição for aceite");

        jLabel8.setText("Apenas poderá candidatar-se a demonstrações que tenha mostrado interesse ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262)
                        .addComponent(jButton26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(179, 179, 179))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton26))))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton28)
                .addGap(24, 24, 24))
        );

        jTabbedPaneCargos.addTab("Expositor", jPanel3);

        jButton2.setText("Avaliar candidaturas à exposição");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton29.setText("Atualizar conflitos de interesse de candidaturas a Exposição");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setText("Avaliar candidaturas à demonstração");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPaneCargos.addTab("FAE", jPanel4);

        jButton8.setText("Criar exposição");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Confirmar registo de utilizadores");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Definir recursos");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setText("Definir tipo de conflitos");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Exportar ranking de keywords para CSV");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton4.setText("Criar stand");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton14.setText("Percentagem de candidaturas aceites e média de ratings");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton23.setText("Qualidade dos FAE");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton3.setText("Importar Exposição via XML");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addGap(71, 71, 71)
                        .addComponent(jButton4)
                        .addGap(76, 76, 76)
                        .addComponent(jButton23)
                        .addGap(53, 53, 53)
                        .addComponent(jButton9))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addGap(50, 50, 50)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton14)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton8))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10)
                            .addComponent(jButton13)
                            .addComponent(jButton14))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton4)
                    .addComponent(jButton23)
                    .addComponent(jButton9)
                    .addComponent(jButton3))
                .addGap(78, 78, 78))
        );

        jTabbedPaneCargos.addTab("Gestor", jPanel6);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Infelizmente como ainda não detêm cargos, por enquanto não tem permissões para executar nenhuma ação.");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(514, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(161, 161, 161))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel7)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPaneCargos.addTab("Utilizador", jPanel7);

        jButton16.setText("Definir FAE");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Atribuir candidaturas à exposição");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Criar demonstração");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Atribuir stands");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("Decidir candidaturas à exposição");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Listar candidaturas a exposição removidas");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("Decidir demonstrações");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton24.setText("Atribuir candidaturas à demonstração");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("Decidir candidaturas à demonstração");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton32.setText("Listar candidaturas a demonstração removidas");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton15.setText("Percentagem de candidaturas aceites e média de ratings");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton32))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton24)
                            .addComponent(jButton25))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton22))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jButton19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton21)
                        .addGap(239, 239, 239))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton17)
                        .addGap(266, 266, 266))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(jButton15)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jButton16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton25)
                            .addComponent(jButton19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton24)
                            .addComponent(jButton18))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton32)
                        .addComponent(jButton22)))
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addGap(23, 23, 23))
        );

        jTabbedPaneCargos.addTab("Organizador", jPanel5);

        jButton1.setText("Criar candidatura à exposição");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton34.setText("Criar Candidatura a Exposição via XML");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu1.setText("Ficheiros");

        jMenuItemCarregarDados.setText("Abrir");
        jMenuItemCarregarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarregarDadosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCarregarDados);

        jMenuItemGuardarDados.setText("Guardar");
        jMenuItemGuardarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarDadosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGuardarDados);

        jMenuItem1.setText("Guardar como");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu3.setText("Login");

        jMenuItemTerminarSessao.setText("Terminar sessão");
        jMenuItemTerminarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTerminarSessaoActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemTerminarSessao);

        jMenuBar1.add(jMenu3);

        jMenuEstiloDaJanela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuEstiloDaJanela.setText("Estilos");

        jMenuItemEstiloDaJanela.setText("Estilo da janela");
        jMenuItemEstiloDaJanela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstiloDaJanelaActionPerformed(evt);
            }
        });
        jMenuEstiloDaJanela.add(jMenuItemEstiloDaJanela);

        jMenuBar1.add(jMenuEstiloDaJanela);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPaneCargos))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(396, 396, 396))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPaneCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxFAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFAEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxFAEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameCriarCandidaturaAExposicaoUI(thisJFrame, centroExposicoes, utilizador);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItemCarregarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarregarDadosActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(thisJFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            ImportarXMLController CTRL = new ImportarXMLController();
            CentroExposicoes ce;
            try {
                ce = new CentroExposicoes();
                ce.importContentFromXMLNode(CTRL.Import(file.getAbsolutePath()));
                this.centroExposicoes = ce;
                JOptionPane.showMessageDialog(thisJFrame, "Informação carregada com sucesso.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException | NullPointerException | ParserConfigurationException ex) {
                JOptionPane.showMessageDialog(thisJFrame, "Erro no carregamento da informação.", "ERRO", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItemCarregarDadosActionPerformed

    private void jMenuItemTerminarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTerminarSessaoActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Deseja salvar todas as alterações feitas?");
        if (op == JOptionPane.YES_OPTION) {

            JFileChooser fc = new JFileChooser();
            ExportarXMLController CTRL = new ExportarXMLController();

            File properties = new File(CentroExposicoes.PROPERTIES_FILE_LOCATION);
            boolean successfulExport = false;

            try {
                Scanner in = new Scanner(properties);

                while (in.hasNext()) {
                    String[] input = in.nextLine().split("=");
                    if (input[0].trim().equalsIgnoreCase("saveFileLocation")) {
                        String[] filePath = input[1].split("\".*\"");
                        if (filePath.length > 0) {
                            File file = new File(filePath[0]);
                            if (!file.exists()) {
                                break;
                            }
                            if (CTRL.export(filePath[0], centroExposicoes)) {
                                JOptionPane.showMessageDialog(null, "Informação gravada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                                successfulExport = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Erro na gravação dos dados.", "ERRO", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }

                in.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuV2.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

            if (!successfulExport) {
                int returnVal = fc.showSaveDialog(thisJFrame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    String fileName = f.getAbsolutePath();
                    if (CTRL.exportAndUpdateProperties(fileName, centroExposicoes)) {
                        JOptionPane.showMessageDialog(null, "Informação guardada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro na gravação da informação.", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            terminaSessao();
        } else if (op == JOptionPane.NO_OPTION) {
            terminaSessao();
        }
    }//GEN-LAST:event_jMenuItemTerminarSessaoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameRegistarExpoUI(centroExposicoes, thisJFrame);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItemGuardarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarDadosActionPerformed
        JFileChooser fc = new JFileChooser();
        ExportarXMLController CTRL = new ExportarXMLController();

        File properties = new File(CentroExposicoes.PROPERTIES_FILE_LOCATION);
        boolean successfulExport = false;

        try {
            Scanner in = new Scanner(properties);

            while (in.hasNext()) {
                String[] input = in.nextLine().split("=");
                if (input[0].trim().equalsIgnoreCase("saveFileLocation")) {
                    String[] filePath = input[1].split("\".*\"");
                    if (filePath.length > 0) {
                        File file = new File(filePath[0]);
                        if (!file.exists()) {
                            break;
                        }
                        if (CTRL.export(filePath[0], centroExposicoes)) {
                            JOptionPane.showMessageDialog(null, "Informação gravada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                            successfulExport = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro na gravação dos dados.", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

            in.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuV2.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        if (!successfulExport) {
            int returnVal = fc.showSaveDialog(thisJFrame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                String fileName = f.getAbsolutePath();
                if (CTRL.exportAndUpdateProperties(fileName, centroExposicoes)) {
                    JOptionPane.showMessageDialog(null, "Informação guardada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro na gravação da informação.", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jMenuItemGuardarDadosActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameAlterarPerfilDeUtilizador(centroExposicoes, this.utilizador.getUsername(), this);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameConfirmarStandUI(thisJFrame, centroExposicoes, this.utilizador.getEmail());
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameRemoverCandidaturaADemonstracaoUI(thisJFrame, utilizador.getEmail(), centroExposicoes);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameRemoverCandidaturaExposicaoUI(thisJFrame, centroExposicoes, this.utilizador.getEmail());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameRegistarCandidaturaADemonstracaoUI(thisJFrame, centroExposicoes, this.utilizador.getEmail());
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameAvaliarCandidaturasAExposicao(thisJFrame, this.utilizador.getUsername(), centroExposicoes);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        setVisible(false);
        JFrame frame = new JFrameAtualizarConflitoDeInteresseCandidaturaAExposicaoUI(utilizador.getUsername(), this.centroExposicoes, this);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameAvaliarCandidaturaADemonstracaoUI(thisJFrame, centroExposicoes, utilizador.getUsername());
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameDefinirFAEUI(thisJFrame, centroExposicoes, this.utilizador.getUsername());
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameAtribuirCandidaturasAExposicaoUI(thisJFrame, this.utilizador.getUsername(), centroExposicoes);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameCriarDemonstracaoUI(this.utilizador.getUsername(), centroExposicoes, thisJFrame);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        AtribuirStandsController CTRL = new AtribuirStandsController(centroExposicoes);
        this.setVisible(false);
        Exposicao[] listExpo = CTRL.getListaExposicoes().toArray(new Exposicao[0]);
        if (listExpo.length > 0 && centroExposicoes.getRegistoStands().getListaStands().size() > 0) {
            Exposicao selectedExpo = (Exposicao) JOptionPane.showInputDialog(this, "A qual exposição pretende atribuir os stands?", "", JOptionPane.QUESTION_MESSAGE, null, listExpo, listExpo[0]);
            if (selectedExpo != null) {
                CTRL.select(selectedExpo);
                this.setVisible(false);
                JFrame frame = new JFrameAtribuirStandsUI(CTRL, this);
            } else {
                JOptionPane.showMessageDialog(this, "Operação cancelada a pedido do utilizador.", "ERRO", JOptionPane.OK_OPTION);
            }
        } else if (listExpo.length == 0) {
            JOptionPane.showMessageDialog(this, "Não existem exposições num estado disponível para que possa ser possível atribuir stands.", "ERRO", JOptionPane.OK_OPTION);
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Não existem stands no centro de exposições.", "ERRO", JOptionPane.OK_OPTION);
            setVisible(true);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameDecidirCandidaturasAExposicaoUI(thisJFrame, centroExposicoes);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameListarCandidaturasAExposicaoRemovidasUI(thisJFrame, centroExposicoes, this.utilizador.getUsername());
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameDecidirDemonstracao(centroExposicoes, this.utilizador.getUsername(), thisJFrame);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            String input = JOptionPane.showInputDialog(this, "Qual o nível de confiança que pretende que seja utilizado nos cálculos estatísticos?");
            if (input == null || input.trim().length() == 0) {
                throw new NumberFormatException();
            }
            double nivelConfiance = Double.parseDouble(input);
            if (nivelConfiance < 0) {
                throw new NumberFormatException();
            }
            QualidadeFaeController CTRL = new QualidadeFaeController(centroExposicoes);
            if (CTRL.getListaFAE().size() > 0) {
                List<Media<FAE>> infoFAEs = CTRL.testeHipotese(nivelConfiance);
                setVisible(false);
                JFrame frame = new JFrameQualidadeFAEUI(this, nivelConfiance, infoFAEs);
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível executar esta UC. Isto pode ser devido a:"
                        + "\n    Nenhum dos FAEs existentes tem pelo menos 30 avaliações."
                        + "\n    Nenhum dos FAEs com pelo menos 30 avaliações tem um desvio padrão maior a 1.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O número introduzido não é válido.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameAtribuirCandidaturasADemonstracaoUI(thisJFrame, utilizador.getUsername(), centroExposicoes);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameDecidirCandidaturaADemonstracaoUI(thisJFrame, centroExposicoes, utilizador.getUsername());
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (this.centroExposicoes.getRegistoUtilizadoresPendentes().getListaUtilizadores().size() > 0) {
            this.setVisible(false);
            JFrame frame = new JFrameConfirmarRegistoUtilizadorUI(thisJFrame, centroExposicoes);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(thisJFrame, "Não existem registos de utilizadores pendentes.", "ERRO", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameDefinirRecursos(centroExposicoes, this);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DefinirTipoConflitoController CTRL = new DefinirTipoConflitoController(centroExposicoes);
        CTRL.novoTipoConflito();
        String input = JOptionPane.showInputDialog(this, "Como se vai chamar o novo tipo de conflito?", "Definir Tipos de Conflito");
        if (input != null) {
            CTRL.setDadosTipoConflito(input);
            if (CTRL.registaTipoConflito()) {
                JOptionPane.showMessageDialog(this, "Novo tipo de conflito registado com sucesso.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro no registo do novo tipo de conflito."
                        + "\n    Erro: Tipo de conflito já existente.", "SUCESSO", JOptionPane.OK_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Operação cancelada a pedido do Utilizador", "CANCEL", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        ExportarRankingController CTRL = new ExportarRankingController(centroExposicoes);
        Exposicao[] listExpo = CTRL.getListaExposicoesRankingPronto().toArray(new Exposicao[0]);
        if (listExpo.length > 0) {
            Object option = JOptionPane.showInputDialog(this, "Escolha o nome da exposição sobre a qual pretende exportar o ranking de keywords.", "Exportar Ranking para CSV", JOptionPane.OK_CANCEL_OPTION, null, listExpo, listExpo[0]);
            if (option != null) {
                CTRL.select((Exposicao) option);
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(this);
                switch (returnVal) {
                    case JFileChooser.APPROVE_OPTION:
                        try {
                            CTRL.export(fc.getSelectedFile());
                            JOptionPane.showMessageDialog(this, "Informação exportada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        } catch (FileNotFoundException ex) {
                        }
                    case JFileChooser.ERROR_OPTION:
                        JOptionPane.showMessageDialog(this, "Ocorreu um erro na exportação do ranking para ficheiro CSV.", "ERRO", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não existeme exposições sobre as quais exportar o ranking de keywords para CSV se encontra possível.", "ERRO", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jMenuItemEstiloDaJanelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstiloDaJanelaActionPerformed
    }//GEN-LAST:event_jMenuItemEstiloDaJanelaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameAlterarCandidaturaAExposicaoUI(utilizador.getEmail(), centroExposicoes, thisJFrame);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameAlterarCandidaturaADemonstracaoUI(centroExposicoes, utilizador.getEmail(), thisJFrame);

    }//GEN-LAST:event_jButton31ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(thisJFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            String fileName = f.getAbsolutePath();
            ExportarXMLController CTRL = new ExportarXMLController();
            if (CTRL.exportAndUpdateProperties(fileName, centroExposicoes)) {
                JOptionPane.showMessageDialog(null, "Informação guardada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro na gravação da informação.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameListarCandidaturasADemonstracaoRemovidasUI(thisJFrame, centroExposicoes, this.utilizador.getUsername());
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameCriarCandidaturaExposicaoXML(centroExposicoes, thisJFrame, utilizador);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFrameCriarStandsUI(thisJFrame, centroExposicoes);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFramePercentagemCandAceitesMediaRatings(thisJFrame, centroExposicoes);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        this.setVisible(false);
        JFrame frame = new JFramePercentagemCandAceitesMediaRatings(thisJFrame, centroExposicoes);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(thisJFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            String filename = f.getAbsolutePath();
            ImportarExposicaoXMLController CTRL;
            try {
                CTRL = new ImportarExposicaoXMLController(centroExposicoes, filename);
                CTRL.registarExposicao();
                JOptionPane.showMessageDialog(null, "Exposiçao carregada com sucesso", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } catch (ParserConfigurationException ex) {
                JOptionPane.showMessageDialog(null, "Erro na leitura do ficheiro.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void terminaSessao() {
        JFrame frame = new LoginV2(centroExposicoes);
        dispose();
    }

    private void addJMenuItemsEstilosDaJanela() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            this.jMenuEstiloDaJanela.add(criarItemEstilo(info));
        }
    }

    private JMenuItem criarItemEstilo(UIManager.LookAndFeelInfo info) {
        JMenuItem item = new JMenuItem(info.getName());

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (menuItem.getActionCommand().equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    SwingUtilities.updateComponentTreeUI(rootPane);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            rootPane,
                            ex.getMessage(),
                            "Estilo " + menuItem.getActionCommand(),
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return item;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            identificarCargosDoUtilizador();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBoxExpositor;
    private javax.swing.JCheckBox jCheckBoxFAE;
    private javax.swing.JCheckBox jCheckBoxGestor;
    private javax.swing.JCheckBox jCheckBoxOrganizador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNomeUtilizador;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEstiloDaJanela;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemCarregarDados;
    private javax.swing.JMenuItem jMenuItemEstiloDaJanela;
    private javax.swing.JMenuItem jMenuItemGuardarDados;
    private javax.swing.JMenuItem jMenuItemTerminarSessao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPaneCargos;
    // End of variables declaration//GEN-END:variables
}
