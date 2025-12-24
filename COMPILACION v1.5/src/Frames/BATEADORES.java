/*------------------------------------------------------------------------------------------
                        Liga de Beisbol Sertoma 

                    PERIODO: VACACIONES DE VERANO 2024   

            Frame para manipular la información de los Jugadores
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : JUGADORES.java
  Fecha       : JULIO/2024
  Compilador  : JDK 17 + Java NetBeans 20
  Descripción : Este frame contiene los componentes necesarios para manipular la información
                de los jugadores:
                    1. Dar de alta Jugadores, modificarlos o darlos de baja.
                    2. Dar de alta lo que hizo el Jugador en determinada Jornada, así como   
                    modificarlo o darlo de baja.
                    3. Toda la información se resume en una tabla, dando los totales de apariciones,
                    turnos legales, hits, homeruns, promedio, producidas, bases robadas, innings lanzados,
                    record de ganados y perdidos.
==========================================================================================*/

package Frames;

//--------------------------------------------------------------------------------------------

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

//--------------------------------------------------------------------------------------------

public class BATEADORES extends javax.swing.JFrame {

    //--------------------------------------------------------------------------------------------
    
    Conexion oCN = new Conexion();
    DefaultTableModel modelo;
    TableColumnModel modeloColumna;
    String liga, temporada, nombre, equipo, categoria, jugador, jornada;
    
    double ap, tl;
    int hits, dobles, triples, hr, cp, bb, bg, br, ts, fs;
    
    public void asignar(){
        try {
        liga = JCBLiga.getSelectedItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        nombre = jTFNombre.getText();
        equipo = jCBEquipo.getSelectedItem().toString();
        categoria = jCBCategoria.getSelectedItem().toString();
        jugador = jCBJugador.getSelectedItem().toString();
        jornada = JCBJornada.getSelectedItem().toString();

        ap = Double.parseDouble(jSpinApariciones.getValue().toString());
        tl = Double.parseDouble(jSpinTurnosLegales.getValue().toString());

        hits = Integer.parseInt(jSpinHits.getValue().toString());
        dobles = Integer.parseInt(jSpinDobles.getValue().toString());
        triples = Integer.parseInt(jSpinTriples.getValue().toString());
        hr = Integer.parseInt(jSpinHomeRuns.getValue().toString());
        cp = Integer.parseInt(jSpinProducidas.getValue().toString());
        bb = Integer.parseInt(jSpinBases.getValue().toString());
        bg = Integer.parseInt(jSpinGolpes.getValue().toString());
        br = Integer.parseInt(jSpinRobos.getValue().toString());
        ts = Integer.parseInt(jSpinToquesSac.getValue().toString());
        fs = Integer.parseInt(jSpinElesSac.getValue().toString());
        } catch(NullPointerException ex) {
                
        }
    }
    
    public void borrar() {
        jSpinHits.setValue(0);
        jSpinDobles.setValue(0);
        jSpinTriples.setValue(0);
        jSpinHomeRuns.setValue(0);
        jSpinProducidas.setValue(0);
        jSpinBases.setValue(0);
        jSpinGolpes.setValue(0);
        jSpinRobos.setValue(0);
        jSpinToquesSac.setValue(0);
        jSpinElesSac.setValue(0);
    }
    
    //--------------------------------------------------------------------------------------------
    
    public BATEADORES() {
        initComponents();
        //Darle color y centrar
        Color color = new Color(204,204,204);
        getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        
        //Asignar tamaño a cada una de las columnas
        modelo = (DefaultTableModel)jTablaJugadores.getModel();
        modeloColumna = jTablaJugadores.getColumnModel();
        // La tabla mide 836
        modeloColumna.getColumn(0).setPreferredWidth(200);
        modeloColumna.getColumn(1).setPreferredWidth(54);
        modeloColumna.getColumn(2).setPreferredWidth(54);
        modeloColumna.getColumn(3).setPreferredWidth(54);
        modeloColumna.getColumn(4).setPreferredWidth(54);
        modeloColumna.getColumn(5).setPreferredWidth(54);
        modeloColumna.getColumn(6).setPreferredWidth(54);
        modeloColumna.getColumn(7).setPreferredWidth(54);
        modeloColumna.getColumn(8).setPreferredWidth(54);
        modeloColumna.getColumn(9).setPreferredWidth(54);
        modeloColumna.getColumn(10).setPreferredWidth(54);
        modeloColumna.getColumn(11).setPreferredWidth(54);

        //Asignar una imagen como icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Frames/Kompilacion.png"));
        setIconImage(icon);

        // Crear un DefaultTableCellRenderer para centrar el contenido
        DefaultTableCellRenderer centrador = new DefaultTableCellRenderer();
        centrador.setHorizontalAlignment(SwingConstants.CENTER);

        // Asignar el centrador a cada columna de la tabla
        for (int i = 1; i < jTablaJugadores.getColumnCount(); i++) {
            jTablaJugadores.getColumnModel().getColumn(i).setCellRenderer(centrador);
        }

        //Conectar y mostrar los jugadores por equipo
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
            oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        }

        asignar();
        
        oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));

    }

    //--------------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGJugador = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabNombre = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jButAltaJugador = new javax.swing.JButton();
        jButModificarJugador = new javax.swing.JButton();
        jButBajaJugador = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabEquipo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabCategoria = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jCBEquipo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaJugadores = new javax.swing.JTable();
        jLabJugador = new javax.swing.JLabel();
        jLabJornada = new javax.swing.JLabel();
        jButAltaJJugador = new javax.swing.JButton();
        jButModificarJJugador = new javax.swing.JButton();
        jButBajaJJugador = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSpinApariciones = new javax.swing.JSpinner();
        jSpinTurnosLegales = new javax.swing.JSpinner();
        jSpinHits = new javax.swing.JSpinner();
        jSpinHomeRuns = new javax.swing.JSpinner();
        jSpinProducidas = new javax.swing.JSpinner();
        jSpinRobos = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaJugadores1 = new javax.swing.JTable();
        jSpinDobles = new javax.swing.JSpinner();
        jSpinTriples = new javax.swing.JSpinner();
        jSpinBases = new javax.swing.JSpinner();
        jSpinGolpes = new javax.swing.JSpinner();
        jSpinToquesSac = new javax.swing.JSpinner();
        jSpinElesSac = new javax.swing.JSpinner();
        JCBJornada = new javax.swing.JComboBox<>();
        jCBJugador = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JCBLiga = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JCBTemporada = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        jMIImprimir = new javax.swing.JMenuItem();
        jMIRegresar = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMISiglas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BATEADORES");

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
        jButAltaJugador.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jButAltaJugador.setText("ALTA");
        jButAltaJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAltaJugadorActionPerformed(evt);
            }
        });

        jButModificarJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButModificarJugador.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jButModificarJugador.setText("MODIFICAR");
        jButModificarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButModificarJugadorActionPerformed(evt);
            }
        });

        jButBajaJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButBajaJugador.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButBajaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButAltaJugador)
                        .addComponent(jButModificarJugador)))
                .addContainerGap())
        );

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
        jCBEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBEquipo, 0, 220, Short.MAX_VALUE)
                    .addComponent(jLabEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablaJugadores.setBackground(new java.awt.Color(204, 204, 204));
        jTablaJugadores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaJugadores.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jTablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JUGADOR", "JJ", "AP", "TL", "H", "2B", "3B", "HR", "AVG", "CP", "BB", "BG", "BR", "TS", "FS", "SAC", "SLG", "OBP", "OPS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true
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
        jButAltaJJugador.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jButAltaJJugador.setText("ALTA");
        jButAltaJJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAltaJJugadorActionPerformed(evt);
            }
        });

        jButModificarJJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButModificarJJugador.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jButModificarJJugador.setText("MODIFICAR");
        jButModificarJJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButModificarJJugadorActionPerformed(evt);
            }
        });

        jButBajaJJugador.setBackground(new java.awt.Color(204, 204, 204));
        jButBajaJJugador.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jButBajaJJugador.setText("BAJA");
        jButBajaJJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButBajaJJugadorActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSpinApariciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinApariciones.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jSpinApariciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinTurnosLegales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinTurnosLegales.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jSpinTurnosLegales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinHits.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinHits.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinHits.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinHomeRuns.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinHomeRuns.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinHomeRuns.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinProducidas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinProducidas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinProducidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinRobos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinRobos.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinRobos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablaJugadores1.setBackground(new java.awt.Color(204, 204, 204));
        jTablaJugadores1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaJugadores1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTablaJugadores1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AP", "TL", "HITS", "DOBLES", "TRIPLES", "HR", "CP", "BB", "BG", "BR", "TS", "FS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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

        jSpinDobles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinDobles.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinDobles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinTriples.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinTriples.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinTriples.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinBases.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinBases.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinBases.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinGolpes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinGolpes.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinGolpes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinToquesSac.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinToquesSac.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinToquesSac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinElesSac.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinElesSac.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinElesSac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JCBJornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBJornadaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabJugador)
                .addGap(18, 18, 18)
                .addComponent(jCBJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabJornada)
                .addGap(18, 18, 18)
                .addComponent(JCBJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButAltaJJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButModificarJJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButBajaJJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSpinApariciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinTurnosLegales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinHits, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinDobles, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinTriples, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinHomeRuns, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinProducidas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinBases, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinGolpes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinRobos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinToquesSac, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jSpinElesSac, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addGap(8, 8, 8))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabJugador)
                    .addComponent(jLabJornada)
                    .addComponent(JCBJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinApariciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinTurnosLegales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinHits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinHomeRuns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinProducidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinRobos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinDobles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinTriples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinBases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinGolpes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinToquesSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinElesSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButAltaJJugador)
                    .addComponent(jButModificarJJugador)
                    .addComponent(jButBajaJJugador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
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
        JCBTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBTemporadaActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 485, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //--------------------------------------------------------------------------------------------
    
    private void jMIRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRegresarActionPerformed
        // Salir
        dispose();
    }//GEN-LAST:event_jMIRegresarActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButAltaJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAltaJugadorActionPerformed
        // Dar de alta un Jugador
        asignar();
        oCN.altaJugador(nombre, oCN.claveEquipo(equipo, categoria, temporada));
        //oCN.altaJBateador(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, jornada, oCN.claveJugador(jugador, oCN.claveEquipo(equipo, categoria, temporada)));
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
        //oCN.mostrarJugador(modelo, oCN.claveEquipo(equipo, categoria));
    }//GEN-LAST:event_jButAltaJugadorActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButModificarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButModificarJugadorActionPerformed
        //Mostrar mensajes con campos de texto para indicar nuevo nombre o nuevo equipo
        String nnombre = JOptionPane.showInputDialog("Indique el Nuevo Nombre del Jugador:");
        String nequipo = JOptionPane.showInputDialog("Indique el Nuevo Equipo:");
        asignar();
        oCN.modificarJugador(nnombre, oCN.claveEquipo(nequipo, categoria, temporada), oCN.claveJugador(nombre, oCN.claveEquipo(equipo, categoria, temporada)));
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
        oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_jButModificarJugadorActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButBajaJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButBajaJugadorActionPerformed
        // Dar de baja a determinado Jugador
        asignar();
        oCN.bajaJugador(oCN.claveJugador(nombre, oCN.claveEquipo(equipo, categoria, temporada)));
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
        oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_jButBajaJugadorActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButAltaJJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAltaJJugadorActionPerformed
        // Dar de alta la Jornada de un Jugador
        asignar();
        
        oCN.altaJBateador(ap, tl, hits, dobles, triples, hr, cp, bb, bg, br, fs, ts, jornada, oCN.claveJugador(jugador, oCN.claveEquipo(equipo, categoria, temporada)));
        oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        
        borrar();
    }//GEN-LAST:event_jButAltaJJugadorActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButModificarJJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButModificarJJugadorActionPerformed
        // Modificar la Jornada de un Jugador
        try{
            //Guardar los datos en varables para pasarlos al método
            asignar();
            
            oCN.modificarJBateador(ap, tl, hits, dobles, triples, hr, cp, bb, bg, br, fs, ts, oCN.claveJBateador(oCN.claveJornada(jornada), oCN.claveJugador(jugador, oCN.claveEquipo(equipo, categoria, temporada))));
            oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
            
            borrar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Establezca correctamente los datos", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButModificarJJugadorActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButBajaJJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButBajaJJugadorActionPerformed
        // Dar de baja la Jornada de un Jugador
        asignar();
        
        oCN.bajaJBateador(oCN.claveJBateador(oCN.claveJornada(jornada), oCN.claveJugador(nombre, oCN.claveEquipo(equipo, categoria, temporada))));
        oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_jButBajaJJugadorActionPerformed

    //--------------------------------------------------------------------------------------------
    
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

    //--------------------------------------------------------------------------------------------
    
    private void jCBCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBCategoriaItemStateChanged
        // Mostrar los Equipos segun la categoria
        try {
        categoria = evt.getItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        
        oCN.Equipos(jCBEquipo, temporada, categoria);
        equipo = jCBEquipo.getSelectedItem().toString();
        
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
        jugador = jCBJugador.getSelectedItem().toString();
        
        oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        } catch(NullPointerException e) {
            
        }
    }//GEN-LAST:event_jCBCategoriaItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    private void jCBEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBEquipoItemStateChanged
        // Mostrar los jugadores de los equipos
        try {
        equipo = evt.getItem().toString();
        } catch(NullPointerException e) {
            equipo = " ";
            oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        }
        categoria = jCBCategoria.getSelectedItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        
        oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
        try {
        jugador = jCBJugador.getSelectedItem().toString();
        } catch (NullPointerException ex) {
            jugador = " ";
        }
        
        oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_jCBEquipoItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    private void jMISiglasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISiglasActionPerformed
        // Indicar la simbología de la tabla
        JOptionPane.showMessageDialog(null, "JJ - Juegos Jugados"
                                        + "AP - Apariciones al Bat\n"
                                        + "TL - Turnos Legales\n"
                                        + "H - Hits\n"
                                        + "2B - Dobles\n"
                                        + "3B - Triples\n"
                                        + "HR - HomeRuns\n"
                                        + "AVG - Promedio de Bateo\n"
                                        + "CP - Carreras Producidas\n"
                                        + "BB - Bases por Bola\n"
                                        + "BG - Bases por Golpe\n"
                                        + "BR - Bases Robadas\n"
                                        + "TS - Toques de Sacrificio\n"
                                        + "FS - Flys de Sacrificio\n"
                                        + "SAC - Sacrificios"
                                        + "SLG - Slugging"
                                        + "OBP - Porcentaje de embasado"
                                        + "OPS - Porcentaje de embasado + Slugging", "SIGLAS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMISiglasActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jMIImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIImprimirActionPerformed
        // Imprimir la información de los jugadores de cada equipo
        equipo = jCBEquipo.getSelectedItem().toString();
        categoria = jCBCategoria.getSelectedItem().toString();
        oCN.Imprimir(jTablaJugadores, liga,equipo + " (B) -- " + categoria, "Individuales");
    }//GEN-LAST:event_jMIImprimirActionPerformed

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
        jButAltaJugadorActionPerformed(null);
        jTFNombre.setText("");
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jTablaJugadores1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaJugadores1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablaJugadores1MouseClicked

    private void JCBLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBLigaItemStateChanged
        // Actualizar la información de las ligas
        liga = evt.getItem().toString();
        
        try {
            oCN.Categorias(jCBCategoria, liga);
            categoria = jCBCategoria.getSelectedItem().toString();
            
            oCN.Temporadas(JCBTemporada, liga);
            temporada = JCBTemporada.getSelectedItem().toString();

            oCN.Jornadas(JCBJornada, temporada);
            jornada = JCBJornada.getSelectedItem().toString();

            oCN.Equipos(jCBEquipo, temporada, categoria);
            equipo = jCBEquipo.getSelectedItem().toString();

            oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
            jugador = JCBJornada.getSelectedItem().toString();
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Podrian faltar datos");
        }
        
        oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_JCBLigaItemStateChanged

    private void JCBTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBTemporadaItemStateChanged
        // Actualizar los datos de las temporadas
        try {
            temporada = evt.getItem().toString();
            categoria = jCBCategoria.getSelectedItem().toString();

            oCN.Equipos(jCBEquipo, temporada, categoria);
            equipo = jCBEquipo.getSelectedItem().toString();

            oCN.Jornadas(JCBJornada, temporada);
            jornada = JCBJornada.getSelectedItem().toString();

            oCN.Jugadores(jCBJugador, equipo, categoria, temporada);
            jugador = jCBJugador.getSelectedItem().toString();
            
            oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        } catch(NullPointerException e) {
            
        }
    }//GEN-LAST:event_JCBTemporadaItemStateChanged

    private void jCBEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBEquipoActionPerformed

    private void JCBJornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBJornadaItemStateChanged
        // Cambiar la información de las jornadas
        //asignar();
        //oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
    }//GEN-LAST:event_JCBJornadaItemStateChanged

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void JCBTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBTemporadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBTemporadaActionPerformed

    //--------------------------------------------------------------------------------------------
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BATEADORES().setVisible(true);
            }
        });
    }

    //--------------------------------------------------------------------------------------------
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGJugador;
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
    private javax.swing.JSpinner jSpinApariciones;
    private javax.swing.JSpinner jSpinBases;
    private javax.swing.JSpinner jSpinDobles;
    private javax.swing.JSpinner jSpinElesSac;
    private javax.swing.JSpinner jSpinGolpes;
    private javax.swing.JSpinner jSpinHits;
    private javax.swing.JSpinner jSpinHomeRuns;
    private javax.swing.JSpinner jSpinProducidas;
    private javax.swing.JSpinner jSpinRobos;
    private javax.swing.JSpinner jSpinToquesSac;
    private javax.swing.JSpinner jSpinTriples;
    private javax.swing.JSpinner jSpinTurnosLegales;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTablaJugadores;
    private javax.swing.JTable jTablaJugadores1;
    // End of variables declaration//GEN-END:variables
}
