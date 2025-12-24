/*------------------------------------------------------------------------------------------
                        Liga de Beisbol Sertoma 

                    PERIODO: VACACIONES DE INVIERNO 2024 - 25   

            Frame para manipular la información de Equipos
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : EQUIPOS.java
  Fecha       : ENERO/2025
  Compilador  : JDK 17 + Java NetBeans 22
  Descripción : Este frame contiene los componentes necesarios para manipular la información
                de los equipos:
                    1. Dar de alta Equipos, modificarlos o darlos de baja.
                    2. Dar de alta lo que hizo el Equipo en determinada Jornada, así como   
                    modificarlo o darlo de baja.
                    3. Toda la información se resume en una tabla, dando los totales de juegos
                    jugados, ganados, perdidos, anotadas, recibidas, porcentaje y diferencial,
                    sirviendo a su vez como la tabla de posiciones.
==========================================================================================*/

package Frames;

//--------------------------------------------------------------------------------------------

import Clases.Conexion;
//import com.microsoft.sqlserver.jdbc.dataclassification.ColumnSensitivity;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

//--------------------------------------------------------------------------------------------

public class EQUIPOS extends javax.swing.JFrame {

    // Atributos de los equipos
    DefaultTableModel modelo;
    TableColumnModel modeloColumna;
    Conexion oCN = new Conexion();
  
    // Del Equipo
    String liga, temporada, equipo, categoria, nombre;
    
    // De su jornada
    String rival, jornada;
    int gano, perdio, anotadas, recibidas;
    
    //--------------------------------------------------------------------------------------------
    
    public EQUIPOS() {
        initComponents();
        //Darle color y centrarlo
        Color color = new Color(204,204,204);
        getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        //Asignar una imagen como icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Frames/Kompilacion.png"));
        setIconImage(icon);
        //Definir distintos tamaños para cada columna
        modelo = (DefaultTableModel)jTablaEquipos.getModel();
        modeloColumna = jTablaEquipos.getColumnModel();
        // La tabla mide 836
        modeloColumna.getColumn(0).setPreferredWidth(111);
        modeloColumna.getColumn(1).setPreferredWidth(75);
        modeloColumna.getColumn(2).setPreferredWidth(75);
        modeloColumna.getColumn(3).setPreferredWidth(75);
        modeloColumna.getColumn(4).setPreferredWidth(75);
        modeloColumna.getColumn(5).setPreferredWidth(75);
        modeloColumna.getColumn(6).setPreferredWidth(75);
        modeloColumna.getColumn(7).setPreferredWidth(75);
        // Crear un DefaultTableCellRenderer para centrar el contenido
        DefaultTableCellRenderer centrador = new DefaultTableCellRenderer();
        centrador.setHorizontalAlignment(SwingConstants.CENTER);
        // Asignar el centrador a cada columna de la tabla
        for (int i = 1; i < jTablaEquipos.getColumnCount(); i++) {
            jTablaEquipos.getColumnModel().getColumn(i).setCellRenderer(centrador);
        }
        //Conectar y mostrar los Equipos
        oCN.conectar();
        

        oCN.Ligas(JCBLiga);
        liga = JCBLiga.getSelectedItem().toString();

        oCN.Temporadas(JCBTemporada, liga);
        oCN.Categorias(jCBCategoria, liga);

        categoria = jCBCategoria.getSelectedItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
       
        
        oCN.Jornadas(JCBJornada, temporada);
        oCN.Equipos(JCBRival, temporada, categoria);
        oCN.Equipos(jCBEquipo, temporada, categoria);
   
        oCN.mostrarEquipo(modelo, categoria, temporada);
    }

    public void asignar() {
        try {
            nombre = jTFNombre.getText();
            liga = JCBLiga.getSelectedItem().toString();
            temporada = JCBTemporada.getSelectedItem().toString();
            equipo = jCBEquipo.getSelectedItem().toString();
            categoria = jCBCategoria.getSelectedItem().toString();

            jornada = JCBJornada.getSelectedItem().toString();
            gano = (jChBGano.isSelected()) ? 1 : 0;
            perdio = (jChBPerdio.isSelected()) ? 1 : 0;
            anotadas = Integer.parseInt(jTFAnotadas.getText());
            recibidas = Integer.parseInt(jTFRecibidas.getText());
            rival = JCBRival.getSelectedItem().toString();
            
        } catch(NullPointerException ex) {
            
        } catch (NumberFormatException ex) {
            
        }
   }
    
    //--------------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGRecord = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabCategoria = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabNombre = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jBtnAltaEquipo = new javax.swing.JButton();
        jBtnModificarEquipo = new javax.swing.JButton();
        jBtnBajaEquipo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabEquipo = new javax.swing.JLabel();
        jLabJornada = new javax.swing.JLabel();
        jChBGano = new javax.swing.JCheckBox();
        jChBPerdio = new javax.swing.JCheckBox();
        jTFAnotadas = new javax.swing.JTextField();
        jTFRecibidas = new javax.swing.JTextField();
        jButAltaJEquipo = new javax.swing.JButton();
        jButModificarJEquipo = new javax.swing.JButton();
        jButBajaJEquipo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaEquipos = new javax.swing.JTable();
        JCBRival = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaEquipos1 = new javax.swing.JTable();
        JCBJornada = new javax.swing.JComboBox<>();
        jCBEquipo = new javax.swing.JComboBox<>();
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
        setTitle("EQUIPOS");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabCategoria.setText("Categoría");
        jLabCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBCategoria, 0, 336, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabNombre.setText("Nombre:");

        jTFNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTFNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });

        jBtnAltaEquipo.setBackground(new java.awt.Color(204, 204, 204));
        jBtnAltaEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnAltaEquipo.setText("ALTA");
        jBtnAltaEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltaEquipoActionPerformed(evt);
            }
        });

        jBtnModificarEquipo.setBackground(new java.awt.Color(204, 204, 204));
        jBtnModificarEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnModificarEquipo.setText("MODIFICAR");
        jBtnModificarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarEquipoActionPerformed(evt);
            }
        });

        jBtnBajaEquipo.setBackground(new java.awt.Color(204, 204, 204));
        jBtnBajaEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnBajaEquipo.setText("BAJA");
        jBtnBajaEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBajaEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFNombre)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabNombre)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtnAltaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnModificarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jBtnBajaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAltaEquipo)
                    .addComponent(jBtnModificarEquipo)
                    .addComponent(jBtnBajaEquipo))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabEquipo.setText("Equipo:");

        jLabJornada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabJornada.setText("Jornada:");

        jChBGano.setBackground(new java.awt.Color(204, 204, 204));
        BGRecord.add(jChBGano);
        jChBGano.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jChBGano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jChBGano.setOpaque(true);
        jChBGano.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jChBGanoItemStateChanged(evt);
            }
        });
        jChBGano.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jChBGanoStateChanged(evt);
            }
        });
        jChBGano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChBGanoMouseClicked(evt);
            }
        });
        jChBGano.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jChBGanoPropertyChange(evt);
            }
        });

        jChBPerdio.setBackground(new java.awt.Color(204, 204, 204));
        BGRecord.add(jChBPerdio);
        jChBPerdio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jChBPerdio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jChBPerdio.setOpaque(true);
        jChBPerdio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jChBPerdioItemStateChanged(evt);
            }
        });
        jChBPerdio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jChBPerdioStateChanged(evt);
            }
        });
        jChBPerdio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChBPerdioMouseClicked(evt);
            }
        });
        jChBPerdio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jChBPerdioPropertyChange(evt);
            }
        });

        jTFAnotadas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTFAnotadas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFAnotadas.setText("0");
        jTFAnotadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTFRecibidas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTFRecibidas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFRecibidas.setText("0");
        jTFRecibidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButAltaJEquipo.setBackground(new java.awt.Color(204, 204, 204));
        jButAltaJEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButAltaJEquipo.setText("ALTA");
        jButAltaJEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAltaJEquipoActionPerformed(evt);
            }
        });

        jButModificarJEquipo.setBackground(new java.awt.Color(204, 204, 204));
        jButModificarJEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButModificarJEquipo.setText("MODIFICAR");
        jButModificarJEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButModificarJEquipoActionPerformed(evt);
            }
        });

        jButBajaJEquipo.setBackground(new java.awt.Color(204, 204, 204));
        jButBajaJEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButBajaJEquipo.setText("BAJA");
        jButBajaJEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButBajaJEquipoActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jTablaEquipos.setBackground(new java.awt.Color(204, 204, 204));
        jTablaEquipos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaEquipos.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jTablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EQUIPO", "JJ", "G", "P", "CA", "CR", "PCTE", "DIF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaEquipos.setGridColor(new java.awt.Color(0, 0, 0));
        jTablaEquipos.setShowGrid(true);
        jTablaEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaEquiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaEquipos);

        JCBRival.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        jTablaEquipos1.setBackground(new java.awt.Color(204, 204, 204));
        jTablaEquipos1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaEquipos1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTablaEquipos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GANÓ", "PERDIÓ", "ANOTADAS", "RECIBIDAS", "RIVAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaEquipos1.setGridColor(new java.awt.Color(0, 0, 0));
        jTablaEquipos1.setShowGrid(true);
        jTablaEquipos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaEquipos1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablaEquipos1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButAltaJEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButModificarJEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jButBajaJEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 17, Short.MAX_VALUE)
                                .addComponent(jLabEquipo)
                                .addGap(18, 18, 18)
                                .addComponent(jCBEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabJornada)
                                .addGap(18, 18, 18)
                                .addComponent(JCBJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jChBGano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jChBPerdio)
                        .addGap(104, 104, 104)
                        .addComponent(jTFAnotadas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jTFRecibidas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(JCBRival, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabEquipo)
                    .addComponent(jLabJornada)
                    .addComponent(JCBJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChBGano)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFAnotadas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFRecibidas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCBRival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jChBPerdio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButModificarJEquipo)
                    .addComponent(jButBajaJEquipo)
                    .addComponent(jButAltaJEquipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
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

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuMenu.setText("Menú");
        jMenuMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMenuActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //--------------------------------------------------------------------------------------------
    
    private void jMIRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRegresarActionPerformed
        // Salir
        dispose();
    }//GEN-LAST:event_jMIRegresarActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jCBCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBCategoriaItemStateChanged
        // Mostrar los equipos según cambie la categoría seleccionada
        //asignar();
        categoria = evt.getItem().toString();
//        categoria = jCBCategoria.getSelectedItem().toString();
        oCN.Equipos(jCBEquipo, temporada, categoria);
        oCN.Equipos(JCBRival, temporada, categoria);
        oCN.mostrarEquipo(modelo, categoria, temporada);
    }//GEN-LAST:event_jCBCategoriaItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    private void jBtnAltaEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltaEquipoActionPerformed
        // Dar de alta un Equipo
        asignar();
        oCN.altaEquipo(nombre, temporada, categoria);
        oCN.Equipos(JCBRival, temporada, categoria);
        oCN.Equipos(jCBEquipo, temporada, categoria);
        //asignar();
        //int x1, x2, x3;
        //x1 = oCN.claveEquipo(rival, categoria, temporada); x2 = oCN.claveJornada("Se-20-0-1"); x3 = oCN.claveEquipo(equipo, categoria, temporada);
        //oCN.altaJEquipo(0, 0, 0, 0, oCN.claveEquipo(rival, categoria, temporada), oCN.claveJornada(jornada), oCN.claveEquipo(nombre, categoria, temporada));
        //oCN.mostrarEquipo(modelo, categoria);
    }//GEN-LAST:event_jBtnAltaEquipoActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jBtnModificarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarEquipoActionPerformed
        // Modificar dicho Equipo
        //Recibir los nuevos datos en campos de texto
        String nequipo = JOptionPane.showInputDialog("Indique el Nuevo Nombre del Equipo:");
        String ncategoria = JOptionPane.showInputDialog("Indicar la Nueva Categoría del Equipo:");
        asignar();
        oCN.modificarEquipo(nequipo, ncategoria, oCN.claveEquipo(nombre, categoria, temporada));
        oCN.Equipos(jCBEquipo, temporada, categoria);
        oCN.mostrarEquipo(modelo, categoria, temporada);
    }//GEN-LAST:event_jBtnModificarEquipoActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jBtnBajaEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBajaEquipoActionPerformed
        // Dar de Baja un Equipo
        asignar();
        oCN.bajaEquipo(nombre, categoria, temporada);
        oCN.Equipos(jCBEquipo, temporada, categoria);
        oCN.Equipos(JCBRival, temporada, categoria);
        oCN.mostrarEquipo(modelo, categoria, temporada);
    }//GEN-LAST:event_jBtnBajaEquipoActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButAltaJEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAltaJEquipoActionPerformed
        // Vaciar la información de UNA Jornada del Equipo
        try{
            //Guardar los valores en variables para posteriormente mandarlas al método
            asignar();
            //Mandar llamar a los métodos
            oCN.altaJEquipo(gano, perdio, anotadas, recibidas, oCN.claveEquipo(rival, categoria, temporada), oCN.claveJornada(jornada), oCN.claveEquipo(equipo, categoria, temporada));
            oCN.mostrarEquipo(modelo, categoria, temporada);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Establezca correctamente los datos", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButAltaJEquipoActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButModificarJEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButModificarJEquipoActionPerformed
        // Modificar la información de tal Jornada para el Equipo
        try{
            //Guardar los valores en variables para posteriormente mandarlas al método
            asignar();

            oCN.modificarJEquipo(gano, perdio, anotadas, recibidas, oCN.claveEquipo(rival, categoria, temporada), oCN.claveJEquipo(jornada, oCN.claveEquipo(equipo, categoria, temporada)));
            oCN.mostrarEquipo(modelo, categoria, temporada);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Establezca correctamente los datos", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButModificarJEquipoActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButBajaJEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButBajaJEquipoActionPerformed
        // Dar de Baja cierta Jornada del Equipo
        asignar();
        oCN.bajaJEquipo(oCN.claveJEquipo(jornada, oCN.claveEquipo(equipo, categoria, temporada)));
        oCN.Equipos(jCBEquipo, temporada, categoria);
        oCN.mostrarEquipo(modelo, categoria, temporada);
    }//GEN-LAST:event_jButBajaJEquipoActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jTablaEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaEquiposMouseClicked
        // Pasar el nombre del Equipo al campo de Texto con solo dar click
        if(evt.getClickCount() > 0){
            jTFNombre.setText(jTablaEquipos.getValueAt(this.jTablaEquipos.getSelectedRow(), 0).toString());
            jCBEquipo.setSelectedItem(jTablaEquipos.getValueAt(this.jTablaEquipos.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTablaEquiposMouseClicked
 
    //--------------------------------------------------------------------------------------------
    
                        /*EVENTOS NO UTILIZADOS*/
    private void jChBGanoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jChBGanoStateChanged

    }//GEN-LAST:event_jChBGanoStateChanged

    private void jChBPerdioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jChBPerdioStateChanged

    }//GEN-LAST:event_jChBPerdioStateChanged

    private void jChBGanoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jChBGanoItemStateChanged

    }//GEN-LAST:event_jChBGanoItemStateChanged

    private void jChBPerdioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jChBPerdioItemStateChanged

    }//GEN-LAST:event_jChBPerdioItemStateChanged

    private void jChBPerdioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jChBPerdioPropertyChange

    }//GEN-LAST:event_jChBPerdioPropertyChange

    private void jChBGanoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jChBGanoPropertyChange

    }//GEN-LAST:event_jChBGanoPropertyChange

    //--------------------------------------------------------------------------------------------
    
    private void jChBGanoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChBGanoMouseClicked
        // Cambiar de lugar las anotadas y recibidas según cambie si perdió o ganó
        try{
            asignar();
            jTFAnotadas.setText(Integer.toString(recibidas));
            jTFRecibidas.setText(Integer.toString(anotadas));
            
            jCBEquipo.setSelectedItem(rival);
            JCBRival.setSelectedItem(equipo);
        } catch(NumberFormatException e) {
            
        }
    }//GEN-LAST:event_jChBGanoMouseClicked

    //--------------------------------------------------------------------------------------------
    
    private void jChBPerdioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChBPerdioMouseClicked
        // Cambiar de lugar las anotadas y recibidas según cambie si perdió o ganó
        try{
            asignar();
            jTFAnotadas.setText(Integer.toString(recibidas));
            jTFRecibidas.setText(Integer.toString(anotadas));
            
            jCBEquipo.setSelectedItem(rival);
            JCBRival.setSelectedItem(equipo);
        } catch(NumberFormatException e) {
            
        }
    }//GEN-LAST:event_jChBPerdioMouseClicked

    //--------------------------------------------------------------------------------------------
    
    private void jMISiglasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISiglasActionPerformed
        // Dar a conocer que significa cada encabezado de la tabla
        JOptionPane.showMessageDialog(null, "JJ - Juegos Jugados\n"
                                        + "G - Ganados\n"
                                        + "P - Perdidos\n"
                                        + "CA - Carreras Anotadas\n"
                                        + "CR - Carreras Recibidas\n"
                                        + "PCTE - Porcentaje de Victorias\n"
                                        + "DIF - Diferencial de Carreras", "SIGLAS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMISiglasActionPerformed

    //--------------------------------------------------------------------------------------------
    
                        /*Evento no utilizado*/
    private void jMenuMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMenuActionPerformed
        
    }//GEN-LAST:event_jMenuMenuActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jMIImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIImprimirActionPerformed
        // Mandar la tabla a que se imprima en un archivo de texto
        asignar();
        oCN.Imprimir(jTablaEquipos, liga, "Posiciones " + categoria, "Standings");
    }//GEN-LAST:event_jMIImprimirActionPerformed

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
        jBtnAltaEquipoActionPerformed(null);
        jTFNombre.setText("");
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        // TODO add your handling code here:
//        categoria = jCBCategoria.getSelectedItem().toString();
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void jTablaEquipos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaEquipos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablaEquipos1MouseClicked

    private void JCBLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBLigaItemStateChanged
        // TODO add your handling code here:
        try {
            //oCN.Ligas(JCBLiga);
            liga = evt.getItem().toString();

            oCN.Temporadas(JCBTemporada, liga);
            temporada = JCBTemporada.getSelectedItem().toString();

            oCN.Categorias(jCBCategoria, liga);
            categoria = jCBCategoria.getSelectedItem().toString();

            oCN.Jornadas(JCBJornada, temporada);
            //jornada = JCBJornada.getSelectedItem().toString();
            
            oCN.Equipos(jCBEquipo, temporada, categoria);
            //equipo = jCBEquipo.getSelectedItem().toString();

            oCN.Equipos(JCBRival, temporada, categoria);
            //rival = JCBRival.getSelectedItem().toString();
            
            oCN.mostrarEquipo(modelo, categoria, temporada);
        } catch(NullPointerException ex) {
            //JOptionPane.showMessageDialog(null, "PODRIAN FALTAR DATOS PARA EL ALTA DE EQUIPOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_JCBLigaItemStateChanged

    private void JCBTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBTemporadaItemStateChanged
        // TODO add your handling code here:
        try {
            temporada = evt.getItem().toString();
            
            liga = JCBLiga.getSelectedItem().toString();
            
            categoria = jCBCategoria.getSelectedItem().toString();
            
            oCN.Jornadas(JCBJornada, temporada);
            //jornada = JCBJornada.getSelectedItem().toString();
            
            oCN.Equipos(jCBEquipo, temporada, categoria);
            oCN.Equipos(jCBEquipo, temporada, categoria);
            
            oCN.mostrarBateador(modelo, oCN.claveEquipo(equipo, categoria, temporada));
            
            
        } catch(NullPointerException e) {
            //JOptionPane.showMessageDialog(null, "PODRÍAN FALTAR DATOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_JCBTemporadaItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EQUIPOS().setVisible(true);
            }
        });
    }

    //--------------------------------------------------------------------------------------------
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGRecord;
    private javax.swing.JComboBox<String> JCBJornada;
    private javax.swing.JComboBox<String> JCBLiga;
    private javax.swing.JComboBox<String> JCBRival;
    private javax.swing.JComboBox<String> JCBTemporada;
    private javax.swing.JButton jBtnAltaEquipo;
    private javax.swing.JButton jBtnBajaEquipo;
    private javax.swing.JButton jBtnModificarEquipo;
    private javax.swing.JButton jButAltaJEquipo;
    private javax.swing.JButton jButBajaJEquipo;
    private javax.swing.JButton jButModificarJEquipo;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JComboBox<String> jCBEquipo;
    private javax.swing.JCheckBox jChBGano;
    private javax.swing.JCheckBox jChBPerdio;
    private javax.swing.JLabel jLabCategoria;
    private javax.swing.JLabel jLabEquipo;
    private javax.swing.JLabel jLabJornada;
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
    private javax.swing.JTextField jTFAnotadas;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFRecibidas;
    private javax.swing.JTable jTablaEquipos;
    private javax.swing.JTable jTablaEquipos1;
    // End of variables declaration//GEN-END:variables
}
