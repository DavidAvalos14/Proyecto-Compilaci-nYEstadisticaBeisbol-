/*------------------------------------------------------------------------------------------
                        Liga de Beisbol Sertoma 

                    PERIODO: VACACIONES DE VERANO 2024   

            Frame para consultar la información jornada tras jornada de Equipos y Jugadores
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : JuegosJugados.java
  Fecha       : JULIO/2024
  Compilador  : JDK 17 + Java NetBeans 20
  Descripción : Este frame contiene checkbox para seleccionar equipos por categoría
                dando a lo que hicieron los equipos en cada una de las jornadas así como 
                lo que hizo cada uno de sus jugadores
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

//--------------------------------------------------------------------------------------------

public class JornadasX extends javax.swing.JFrame {

    //--------------------------------------------------------------------------------------------
    
    Conexion oCN = new Conexion();
    DefaultTableModel modelo1, modelo2, modelo3;
    String liga, temporada, equipo, categoria, bateador, picher;
    
    public void asignar() {
        liga = JCBLiga.getSelectedItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        equipo = jCBEquipos.getSelectedItem().toString();
        categoria = jCBCategoria.getSelectedItem().toString();
        bateador = jCBBateador.getSelectedItem().toString();
        picher = CB_Picher.getSelectedItem().toString();
    }
    
    //--------------------------------------------------------------------------------------------
    
    public JornadasX() {
        initComponents();
        //Darle color y centrar
        Color color = new Color(204,204,204);
        getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        
        //Asignar una imagen como icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Frames/Kompilacion.png"));
        setIconImage(icon);
        
        // Crear un DefaultTableCellRenderer para centrar el contenido
        DefaultTableCellRenderer centrador = new DefaultTableCellRenderer();
        centrador.setHorizontalAlignment(SwingConstants.CENTER);

        // Asignar el centrador a cada columna de la tabla
        for (int i = 1; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centrador);
        }
        
        for (int i = 1; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(centrador);
        }
        
        for (int i = 1; i < jTable3.getColumnCount(); i++) {
            jTable3.getColumnModel().getColumn(i).setCellRenderer(centrador);
        }
        
        //Conectar
        try{
            oCN.conectar();
            modelo1 = (DefaultTableModel)jTable1.getModel();
            modelo2 = (DefaultTableModel)jTable2.getModel();
            modelo3 = (DefaultTableModel)jTable3.getModel();
                    
            oCN.Ligas(JCBLiga);
            liga = JCBLiga.getSelectedItem().toString();
            
            oCN.Temporadas(JCBTemporada, liga);
            temporada = JCBTemporada.getSelectedItem().toString();
            
            oCN.Categorias(jCBCategoria, liga);
            categoria = jCBCategoria.getSelectedItem().toString();
            
            oCN.Equipos(jCBEquipos, temporada,categoria);
            equipo = jCBEquipos.getSelectedItem().toString();
                    
            oCN.mostrarJEquipo(modelo1, oCN.claveEquipo(equipo, categoria, temporada));
            oCN.Jugadores(jCBBateador, equipo, categoria, temporada);
            bateador = jCBBateador.getSelectedItem().toString();
            oCN.mostrarJBateador(modelo2, oCN.claveJugador(bateador, oCN.claveEquipo(equipo, categoria, temporada)));
            
            oCN.Jugadores(CB_Picher, equipo, categoria, temporada);
            picher = CB_Picher.getSelectedItem().toString();
            oCN.mostrarJPicher(modelo3, oCN.claveJugador(bateador, oCN.claveEquipo(equipo, categoria, temporada)));
            
            oCN.mostrarJPicher(modelo3, oCN.claveJugador(picher, oCN.claveEquipo(equipo, categoria, temporada)));
            
        } catch(NullPointerException e){
            
        }
    }

    //--------------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabEquipo = new javax.swing.JLabel();
        jLabCategoría = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jCBEquipos = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jCBBateador = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        CB_Picher = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCBTemporada = new javax.swing.JComboBox<>();
        JCBLiga = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        jMIRegresar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JORNADAS POR JORNADA");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabEquipo.setText("Equipo:");

        jLabCategoría.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabCategoría.setText("Categoría");

        jCBCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBCategoria.setToolTipText("");
        jCBCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCBCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBCategoriaItemStateChanged(evt);
            }
        });

        jCBEquipos.setEditable(true);
        jCBEquipos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBEquipos.setMaximumRowCount(40);
        jCBEquipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCBEquipos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBEquiposItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabEquipo)
                    .addComponent(jCBEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabCategoría)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabEquipo)
                    .addComponent(jLabCategoría))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jornada", "Gano", "Perdio", "Anotadas", "Recibidas", "Rival"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable2.setBackground(new java.awt.Color(204, 204, 204));
        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jornada", "AP", "TL", "H", "2B", "3B", "HR", "CP", "BB", "BG", "BR", "TS", "FS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Bateador");

        jCBBateador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBBateador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCBBateador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBBateadorItemStateChanged(evt);
            }
        });

        jTable3.setBackground(new java.awt.Color(204, 204, 204));
        jTable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jornada", "IL", "G", "P", "CP", "CL", "K", "H", "BB", "BG", "SAC", "LE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setGridColor(new java.awt.Color(0, 0, 0));
        jTable3.setShowGrid(true);
        jScrollPane3.setViewportView(jTable3);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Picher");

        CB_Picher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CB_Picher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CB_Picher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_PicherItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jCBBateador, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(CB_Picher, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBBateador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CB_Picher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel3.setText("LIGA:");

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel5.setText("TEMPORADA:");

        JCBTemporada.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JCBTemporada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        JCBTemporada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBTemporadaItemStateChanged(evt);
            }
        });

        JCBLiga.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JCBLiga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBLigaItemStateChanged(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenuMenu.setText("Menú");
        jMenuMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMIRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMIRegresar.setText("Regresar");
        jMIRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRegresarActionPerformed(evt);
            }
        });
        jMenuMenu.add(jMIRegresar);

        jMenuBar1.add(jMenuMenu);

        jMenu1.setText("Ayuda");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem1.setText("Siglas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(JCBLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(JCBTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JCBLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(JCBTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        // Cambiar la información seguún cambie la categoría
        categoria = evt.getItem().toString();
        try{
            temporada = JCBTemporada.getSelectedItem().toString();
            oCN.Equipos(jCBEquipos, temporada, categoria);
            equipo = jCBEquipos.getSelectedItem().toString();
            oCN.mostrarJEquipo(modelo1, oCN.claveEquipo(equipo, categoria, temporada));
            oCN.Jugadores(jCBBateador, equipo, categoria, temporada);
            asignar();
            oCN.mostrarJBateador(modelo2, oCN.claveJugador(bateador, oCN.claveEquipo(equipo, categoria, temporada)));
            oCN.mostrarJPicher(modelo3, oCN.claveJugador(picher, oCN.claveEquipo(equipo, categoria, temporada)));
        } catch(NullPointerException e) {
            
        }
    }//GEN-LAST:event_jCBCategoriaItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    private void jCBBateadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBBateadorItemStateChanged
        // Cambiar la información según cambie el Jugador
        try{
            asignar();
            oCN.mostrarJBateador(modelo2, oCN.claveJugador(bateador, oCN.claveEquipo(equipo, categoria, temporada)));
        } catch(NullPointerException e) {
            
        }
    }//GEN-LAST:event_jCBBateadorItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    private void jCBEquiposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBEquiposItemStateChanged
        // Cambiar la información según el Equipo
        try{
            equipo = evt.getItem().toString();
            categoria = jCBCategoria.getSelectedItem().toString();
            temporada = JCBTemporada.getSelectedItem().toString();
            oCN.mostrarJEquipo(modelo1, oCN.claveEquipo(equipo, categoria, temporada));
            oCN.Jugadores(jCBBateador, equipo, categoria, temporada);
            oCN.Jugadores(CB_Picher, equipo, categoria, temporada);
            oCN.mostrarJBateador(modelo2, oCN.claveJugador(bateador, oCN.claveEquipo(equipo, categoria, temporada)));
            oCN.mostrarJPicher(modelo3, oCN.claveJugador(bateador, oCN.claveEquipo(equipo, categoria, temporada)));
        } catch(NullPointerException e) {
            
        }
    }//GEN-LAST:event_jCBEquiposItemStateChanged

    private void CB_PicherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_PicherItemStateChanged
        // Cambiar la información según cambie el Jugador
        try{
            asignar();
            oCN.mostrarJPicher(modelo3, oCN.claveJugador(picher, oCN.claveEquipo(equipo, categoria, temporada)));
        } catch(NullPointerException e) {
            
        }
    }//GEN-LAST:event_CB_PicherItemStateChanged

    private void JCBLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBLigaItemStateChanged
        // Cambiar la información según la liga}
        try {
            liga = evt.getItem().toString();

            oCN.Temporadas(JCBTemporada, liga);
            oCN.Categorias(jCBCategoria, liga);

            temporada = JCBTemporada.getSelectedItem().toString();
            categoria = jCBCategoria.getSelectedItem().toString();

            oCN.Equipos(jCBEquipos, temporada, categoria);

            oCN.Jugadores(jCBBateador, equipo, categoria, temporada);
            oCN.Jugadores(CB_Picher, equipo, categoria, temporada);

            equipo = jCBEquipos.getSelectedItem().toString();
            bateador = jCBBateador.getSelectedItem().toString();
            picher = CB_Picher.getSelectedItem().toString();

            oCN.mostrarJBateador(modelo1, oCN.claveJugador(bateador, oCN.claveEquipo(equipo, categoria, temporada)));
            oCN.mostrarJPicher(modelo3, oCN.claveJugador(picher, oCN.claveEquipo(equipo, categoria, temporada)));
        } catch (NullPointerException ex) {
        
    }
    }//GEN-LAST:event_JCBLigaItemStateChanged

    private void JCBTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBTemporadaItemStateChanged
        // Cambiar la información según la temporada
        try {
            temporada = evt.getItem().toString();
            categoria = jCBCategoria.getSelectedItem().toString();

            oCN.Equipos(jCBEquipos, temporada, categoria);

            oCN.Jugadores(jCBBateador, equipo, categoria, temporada);
            oCN.Jugadores(CB_Picher, equipo, categoria, temporada);
        
        
            equipo = jCBEquipos.getSelectedItem().toString();
            bateador = jCBBateador.getSelectedItem().toString();
            picher = CB_Picher.getSelectedItem().toString();
            oCN.mostrarJBateador(modelo1, oCN.claveJugador(bateador, oCN.claveEquipo(equipo, categoria, temporada)));
            oCN.mostrarJPicher(modelo3, oCN.claveJugador(picher, oCN.claveEquipo(equipo, categoria, temporada)));
        } catch(NullPointerException ex) {
            
        }
    }//GEN-LAST:event_JCBTemporadaItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(null, "--BATEADORES--\n"
                                            + "AP - Apariciones\n"
                                            + "TL - Turnos Legales\n"
                                            + "H - Hits\n"
                                            + "2B - Dobles\n"
                                            + "3B - Triples\n"
                                            + "HR - HomeRuns\n"
                                            + "CP - Carreras Producidas\n"
                                            + "BB - Bases por Bola\n"
                                            + "BG - Bases por Golpe\n"
                                            + "BR - Bases Robadas\n"
                                            + "TS - Toques de Sacrificio\n"
                                            + "FS - Flys de Sacrificio\n\n"
                                            + "--PICHERS--\n"
                                            + "IL - Innings Lanzados\n"
                                            + "G - Ganados\n"
                                            + "P - Perdidos\n"
                                            + "CP - Carreras Permitidas\n"
                                            + "CL - Carreras Limpias Permitidas\n"
                                            + "K - Ponches\n"
                                            + "H - Hits\n"
                                            + "BB - Bases por Bola\n"
                                            + "BG - Bases por Golpe\n"
                                            + "SAC - Sacrificios\n"
                                            + "LE - Legales Enfrentados\n"
                , "Siglas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    //--------------------------------------------------------------------------------------------
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JornadasX().setVisible(true);
            }
        });
    }

    //--------------------------------------------------------------------------------------------
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Picher;
    private javax.swing.JComboBox<String> JCBLiga;
    private javax.swing.JComboBox<String> JCBTemporada;
    private javax.swing.JComboBox<String> jCBBateador;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JComboBox<String> jCBEquipos;
    private javax.swing.JLabel jLabCategoría;
    private javax.swing.JLabel jLabEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMIRegresar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
