package Frames;

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PICHERS extends javax.swing.JFrame {

    Conexion oCN = new Conexion();
    DefaultTableModel modelo;
    TableColumnModel modeloColumna;
    
    // Atributos del frame
    String liga, temporada, nombre, equipo, categoria, jugador, jornada;
    double il, le;
    int g, p, cp, cl, k, h, bb, bg, sac;
    
    public void asignar() {
        try {
            liga = JCBLiga.getSelectedItem().toString();
            temporada = JCBTemporada.getSelectedItem().toString();
            nombre = jTFNombre.getText();
            equipo = jCBEquipo.getSelectedItem().toString();
            categoria = jCBCategoria.getSelectedItem().toString();
            jugador = jCBJugador.getSelectedItem().toString();
            jornada = JCBJornada.getSelectedItem().toString();

            il = Double.parseDouble(jSpinInnings.getValue().toString());
            g = Integer.valueOf(jSpinGano.getValue().toString());
            p = Integer.valueOf(jSpinPerdio.getValue().toString());
            cp = Integer.valueOf(jSpinPermitidas.getValue().toString());
            cl = Integer.valueOf(jSpinLimpias.getValue().toString());
            k = Integer.valueOf(jSpinPonches.getValue().toString());
            h = Integer.valueOf(jSpinHits.getValue().toString());
            bb = Integer.valueOf(jSpinBases.getValue().toString());
            bg = Integer.valueOf(jSpinGolpes.getValue().toString());
            sac = Integer.valueOf(jSpinSacrificios.getValue().toString());
            le = Integer.valueOf(jSpinEnfrentados.getValue().toString());
        } catch(NullPointerException ex) {
            
        }
    }
    
    public PICHERS() {
        initComponents();
        
        Color color = new Color(204,204,204);
        getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        
        //Asignar una imagen como icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Frames/Kompilacion.png"));
        setIconImage(icon);
        
        modelo = (DefaultTableModel)jTablaJugadores.getModel();
        modeloColumna = jTablaJugadores.getColumnModel();
        
        oCN.conectar();
        
        try {
            oCN.Ligas(JCBLiga);
            liga = JCBLiga.getSelectedItem().toString();

            oCN.Temporadas(JCBTemporada, liga);
            temporada = JCBTemporada.getSelectedItem().toString();

            oCN.Categorias(jCBCategoria, liga);
            categoria = jCBCategoria.getSelectedItem().toString();

            oCN.Equipos(jCBEquipo, temporada, categoria);
            equipo = jCBEquipo.getSelectedItem().toString();

            oCN.Jornadas(JCBJornada, temporada);
            jornada = JCBJornada.getSelectedItem().toString();
        
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Podrian faltar datos...");
            oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        }

        asignar();
        
        oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaJugadores = new javax.swing.JTable();
        jLabJugador = new javax.swing.JLabel();
        jLabJornada = new javax.swing.JLabel();
        jButAltaJJugador = new javax.swing.JButton();
        jButModificarJJugador = new javax.swing.JButton();
        jButBajaJJugador = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSpinInnings = new javax.swing.JSpinner();
        jSpinGano = new javax.swing.JSpinner();
        jSpinPerdio = new javax.swing.JSpinner();
        jSpinPonches = new javax.swing.JSpinner();
        jSpinHits = new javax.swing.JSpinner();
        jSpinSacrificios = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaJugadores1 = new javax.swing.JTable();
        jSpinPermitidas = new javax.swing.JSpinner();
        jSpinLimpias = new javax.swing.JSpinner();
        jSpinBases = new javax.swing.JSpinner();
        jSpinGolpes = new javax.swing.JSpinner();
        jSpinEnfrentados = new javax.swing.JSpinner();
        JCBJornada = new javax.swing.JComboBox<>();
        jCBJugador = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JCBLiga = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JCBTemporada = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabEquipo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabCategoria = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jCBEquipo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabNombre = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jButAltaJugador = new javax.swing.JButton();
        jButModificarJugador = new javax.swing.JButton();
        jButBajaJugador = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        jMIImprimir = new javax.swing.JMenuItem();
        jMIRegresar = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMISiglas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PICHERS");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablaJugadores.setBackground(new java.awt.Color(204, 204, 204));
        jTablaJugadores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaJugadores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JUGADOR", "JJ", "IL", "G", "P", "CP", "CL", "K", "H", "BB", "BG", "SAC", "LE", "ERA", "WHIP", "OAA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaJugadores.setGridColor(new java.awt.Color(0, 0, 0));
        jTablaJugadores.setShowGrid(true);
        jTablaJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaJugadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaJugadores);

        jLabJugador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabJugador.setText("Jugador:");

        jLabJornada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabJornada.setText("Jornada:");

        jButAltaJJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButAltaJJugador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButAltaJJugador.setText("ALTA");
        jButAltaJJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAltaJJugadorActionPerformed(evt);
            }
        });

        jButModificarJJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButModificarJJugador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButModificarJJugador.setText("MODIFICAR");
        jButModificarJJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButModificarJJugadorActionPerformed(evt);
            }
        });

        jButBajaJJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButBajaJJugador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButBajaJJugador.setText("BAJA");
        jButBajaJJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButBajaJJugadorActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSpinInnings.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinInnings.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jSpinInnings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinGano.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinGano.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinGano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinPerdio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinPerdio.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinPerdio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinPonches.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinPonches.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinPonches.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinHits.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinHits.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinHits.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinSacrificios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinSacrificios.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinSacrificios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablaJugadores1.setBackground(new java.awt.Color(204, 204, 204));
        jTablaJugadores1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaJugadores1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTablaJugadores1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IL", "G", "P", "CP", "CL", "K", "H", "BB", "BG", "SAC", "LE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaJugadores1.setGridColor(new java.awt.Color(0, 0, 0));
        jTablaJugadores1.setShowGrid(true);
        jTablaJugadores1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaJugadores1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablaJugadores1);

        jSpinPermitidas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinPermitidas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinPermitidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinLimpias.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinLimpias.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinLimpias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinBases.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinBases.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinBases.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinGolpes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinGolpes.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinGolpes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinEnfrentados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinEnfrentados.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinEnfrentados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButAltaJJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 396, Short.MAX_VALUE)
                        .addComponent(jButBajaJJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabJugador)
                        .addGap(18, 18, 18)
                        .addComponent(jCBJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabJornada)
                        .addGap(18, 18, 18)
                        .addComponent(JCBJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jSpinInnings, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSpinGano, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSpinPerdio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSpinPermitidas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButModificarJJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSpinLimpias, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jSpinPonches, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jSpinHits, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jSpinBases, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jSpinGolpes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jSpinSacrificios, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jSpinEnfrentados, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabJugador)
                    .addComponent(jLabJornada)
                    .addComponent(JCBJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSpinInnings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinGano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinPerdio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinPermitidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinLimpias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinPonches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinHits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinBases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinGolpes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinSacrificios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinEnfrentados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButAltaJJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButModificarJJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButBajaJJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel1.setText("LIGA:");

        JCBLiga.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JCBLiga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBLigaItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel2.setText("TEMPORADA:");

        JCBTemporada.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JCBTemporada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        JCBTemporada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBTemporadaItemStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabEquipo.setText("Equipo:");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabCategoria.setText("Categoría");

        jCBCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCBCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBCategoriaItemStateChanged(evt);
            }
        });
        jCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaActionPerformed(evt);
            }
        });

        jCBEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCBEquipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBEquipoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBEquipo, 0, 220, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jCBCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabEquipo)
                            .addComponent(jLabCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabNombre.setText("Nombre:");

        jTFNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTFNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });

        jButAltaJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButAltaJugador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButAltaJugador.setText("ALTA");
        jButAltaJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAltaJugadorActionPerformed(evt);
            }
        });

        jButModificarJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButModificarJugador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButModificarJugador.setText("MODIFICAR");
        jButModificarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButModificarJugadorActionPerformed(evt);
            }
        });

        jButBajaJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButBajaJugador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButBajaJugador.setText("BAJA");
        jButBajaJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButBajaJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButAltaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButModificarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButBajaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabNombre)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButAltaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButModificarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButBajaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuMenu.setText("Menú");
        jMenuMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMIImprimir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIImprimir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMIImprimir.setText("Imprimir");
        jMIImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIImprimirActionPerformed(evt);
            }
        });
        jMenuMenu.add(jMIImprimir);

        jMIRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMIRegresar.setText("Regresar");
        jMIRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRegresarActionPerformed(evt);
            }
        });
        jMenuMenu.add(jMIRegresar);

        jMenuBar1.add(jMenuMenu);

        jMenuAyuda.setText("Ayuda");

        jMISiglas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMISiglas.setText("Siglas");
        jMISiglas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISiglasActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMISiglas);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(JCBLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(JCBTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JCBLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JCBTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaJugadoresMouseClicked
        // Mandar la información del jugador con solo dar click
        if(evt.getClickCount() > 0){
            jTFNombre.setText(jTablaJugadores.getValueAt(this.jTablaJugadores.getSelectedRow(), 0).toString());
            jCBJugador.setSelectedItem(jTablaJugadores.getValueAt(this.jTablaJugadores.getSelectedRow(), 0).toString());
            //jSpinApariciones.setValue(Double.valueOf(jTablaJugadores.getValueAt(this.jTablaJugadores.getSelectedRow(), 1).toString()));
            //jSpinTurnosLegales.setValue(Double.valueOf(jTablaJugadores.getValueAt(this.jTablaJugadores.getSelectedRow(), 2).toString()));
            //jSpinHits.setValue(Double.valueOf(jTablaJugadores.getValueAt(this.jTablaJugadores.getSelectedRow(), 3).toString()));
        }
    }//GEN-LAST:event_jTablaJugadoresMouseClicked

    private void jButAltaJJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAltaJJugadorActionPerformed
        // Dar de alta la Jornada de un Jugador
        asignar();
        oCN.altaJPicher(il, g, p, cp, cl, k, h, bb, bg, sac, le, oCN.claveJornada(jornada), oCN.claveJugador(jugador, oCN.claveEquipo(equipo, categoria, temporada)));
        oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_jButAltaJJugadorActionPerformed

    private void jButModificarJJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButModificarJJugadorActionPerformed
        // Modificar la Jornada de un Jugador
        try{
        asignar();
        oCN.modificarJPicher(il, g, p, cp, cl, k, h, bb, bg, sac, le, oCN.claveJPicher(oCN.claveJornada(jornada), oCN.claveJugador(jugador, oCN.claveEquipo(equipo, categoria, temporada))));
        oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Establezca correctamente los datos", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButModificarJJugadorActionPerformed

    private void jButBajaJJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButBajaJJugadorActionPerformed
        // Dar de baja la Jornada de un Jugador
        asignar();
        
        oCN.bajaJPicher(oCN.claveJPicher(oCN.claveJornada(jornada), oCN.claveJugador(jugador, oCN.claveEquipo(equipo, categoria, temporada))));
        oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_jButBajaJJugadorActionPerformed

    private void jTablaJugadores1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaJugadores1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablaJugadores1MouseClicked

    private void jCBCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBCategoriaItemStateChanged
        // Mostrar los Equipos segun la categoria
        try {
        categoria = evt.getItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        
        oCN.Equipos(jCBEquipo, temporada, categoria);
        equipo = jCBEquipo.getSelectedItem().toString();
        
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
        jugador = jCBJugador.getSelectedItem().toString();
        
        oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        } catch(NullPointerException e) {
            
        }
    }//GEN-LAST:event_jCBCategoriaItemStateChanged

    private void jCBEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBEquipoItemStateChanged
        // Mostrar los jugadores de los equipos
        // Mostrar los jugadores de los equipos
        try {
        equipo = evt.getItem().toString();
        } catch(NullPointerException e) {
            equipo = " ";
            oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        }
        categoria = jCBCategoria.getSelectedItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
        try {
        jugador = jCBJugador.getSelectedItem().toString();
        } catch (NullPointerException ex) {
            jugador = " ";
        }
        
        oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_jCBEquipoItemStateChanged

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
        jButAltaJugadorActionPerformed(null);
        jTFNombre.setText("");
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jButAltaJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAltaJugadorActionPerformed
        // Dar de alta un Jugador
        asignar();
        oCN.altaJugador(nombre, oCN.claveEquipo(equipo, categoria, temporada));
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
    }//GEN-LAST:event_jButAltaJugadorActionPerformed

    private void jButModificarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButModificarJugadorActionPerformed
        //Mostrar mensajes con campos de texto para indicar nuevo nombre o nuevo equipo
        //Mostrar mensajes con campos de texto para indicar nuevo nombre o nuevo equipo
        String nnombre = JOptionPane.showInputDialog("Indique el Nuevo Nombre del Jugador:");
        String nequipo = JOptionPane.showInputDialog("Indique el Nuevo Equipo:");
        asignar();
        oCN.modificarJugador(nnombre, oCN.claveEquipo(nequipo, categoria, temporada), oCN.claveJugador(nombre, oCN.claveEquipo(equipo, categoria, temporada)));
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
        oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_jButModificarJugadorActionPerformed

    private void jButBajaJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButBajaJugadorActionPerformed
        // Dar de baja a determinado Jugador
        asignar();
        oCN.bajaJugador(oCN.claveJugador(nombre, oCN.claveEquipo(equipo, categoria, temporada)));
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
        oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_jButBajaJugadorActionPerformed

    private void jMIImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIImprimirActionPerformed
        // Imprimir la información de los jugadores de cada equipo
        equipo = jCBEquipo.getSelectedItem().toString();
        categoria = jCBCategoria.getSelectedItem().toString();
        oCN.Imprimir(jTablaJugadores, liga, equipo + " (P) -- " + categoria, "Individuales");
    }//GEN-LAST:event_jMIImprimirActionPerformed

    private void jMIRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRegresarActionPerformed
        // Salir
        dispose();
    }//GEN-LAST:event_jMIRegresarActionPerformed

    private void jMISiglasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISiglasActionPerformed
        // Indicar la simbología de la tabla
        JOptionPane.showMessageDialog(null, "JJ - Juegos Jugados\n"
            + "IL - Innings Lanzados\n"
            + "G - Ganados\n"
            + "P - Perdidos\n"
            + "CP - Carreras Permitidas\n"
            + "CL - Carreras Limpias\n"
            + "K - Ponches\n"
            + "H - Hits Permitidos\n"
            + "BB - Bases por Bolas\n"
            + "BG - Bases por Golpe\n"
            + "SAC - Sacrificios\n"
            + "LE - Bateadores Legales Enfrentados\n"
            + "ERA - Promedio de Carreras Limpias\n"
            + "WHIP - Promedio de Bases y Hits por Inning\n"
            + "OAA - Promedio de Bateo en Contra\n"
            + "PS - Perdidos", "SIGLAS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMISiglasActionPerformed

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void JCBLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBLigaItemStateChanged
        // TODO add your handling code here:
        // Actualizar la información de las ligas
        liga = evt.getItem().toString();
        
        try {
            oCN.Categorias(jCBCategoria, liga);
            oCN.Temporadas(JCBTemporada, liga);
            oCN.Jornadas(JCBJornada, temporada);
            oCN.Equipos(jCBEquipo, temporada, categoria);
            oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
            
            categoria = jCBCategoria.getSelectedItem().toString();
            temporada = JCBTemporada.getSelectedItem().toString();
            jornada = JCBJornada.getSelectedItem().toString();
            equipo = jCBEquipo.getSelectedItem().toString();
            jugador = JCBJornada.getSelectedItem().toString();
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Podrian faltar datos");
        }
        
        oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_JCBLigaItemStateChanged

    private void JCBTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBTemporadaItemStateChanged
        // TODO add your handling code here:
        // Actualizar los datos de las temporadas
        try {
            temporada = evt.getItem().toString();
            categoria = jCBCategoria.getSelectedItem().toString();

            oCN.Equipos(jCBEquipo, temporada, categoria);
            oCN.Jornadas(JCBJornada, temporada);
            oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
            
            equipo = jCBEquipo.getSelectedItem().toString();
            jornada = JCBJornada.getSelectedItem().toString();
            jugador = jCBJugador.getSelectedItem().toString();
            
            oCN.mostrarPicher(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        } catch(NullPointerException e) {
            
        }
    }//GEN-LAST:event_JCBTemporadaItemStateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PICHERS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBJornada;
    private javax.swing.JComboBox<String> JCBLiga;
    private javax.swing.JComboBox<String> JCBTemporada;
    private javax.swing.JButton jButAltaJJugador;
    private javax.swing.JButton jButAltaJugador;
    private javax.swing.JButton jButBajaJJugador;
    private javax.swing.JButton jButBajaJugador;
    private javax.swing.JButton jButModificarJJugador;
    private javax.swing.JButton jButModificarJugador;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JComboBox<String> jCBEquipo;
    private javax.swing.JComboBox<String> jCBJugador;
    private javax.swing.JLabel jLabCategoria;
    private javax.swing.JLabel jLabEquipo;
    private javax.swing.JLabel jLabJornada;
    private javax.swing.JLabel jLabJugador;
    private javax.swing.JLabel jLabNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMIImprimir;
    private javax.swing.JMenuItem jMIRegresar;
    private javax.swing.JMenuItem jMISiglas;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinBases;
    private javax.swing.JSpinner jSpinEnfrentados;
    private javax.swing.JSpinner jSpinGano;
    private javax.swing.JSpinner jSpinGolpes;
    private javax.swing.JSpinner jSpinHits;
    private javax.swing.JSpinner jSpinInnings;
    private javax.swing.JSpinner jSpinLimpias;
    private javax.swing.JSpinner jSpinPerdio;
    private javax.swing.JSpinner jSpinPermitidas;
    private javax.swing.JSpinner jSpinPonches;
    private javax.swing.JSpinner jSpinSacrificios;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTablaJugadores;
    private javax.swing.JTable jTablaJugadores1;
    // End of variables declaration//GEN-END:variables
}
