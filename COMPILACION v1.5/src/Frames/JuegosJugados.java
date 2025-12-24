/*------------------------------------------------------------------------------------------
                        Liga de Beisbol Sertoma 

                    PERIODO: VACACIONES DE VERANO 2024   

            Frame para consultar los juegos jugados de cada jugador por equipo
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : JuegosJugados.java
  Fecha       : JULIO/2024
  Compilador  : JDK 17 + Java NetBeans 20
  Descripción : Este frame contiene checkbox para seleccionar equipos por categoría
                dando a conocer en una tabla los jugadores con sus juegos jugados
==========================================================================================*/

package Frames;

//--------------------------------------------------------------------------------------------

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//--------------------------------------------------------------------------------------------

public class JuegosJugados extends javax.swing.JFrame {

    //--------------------------------------------------------------------------------------------
    
    Conexion oCN = new Conexion();
    DefaultTableModel modelo;
    String liga, temporada, equipo, categoria;
    
    public void asignar() {
        liga = JCBLiga.getSelectedItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        equipo = jCBEquipo.getSelectedItem().toString();
        categoria = jCBCategoria.getSelectedItem().toString();
    }
    
    //--------------------------------------------------------------------------------------------
    
    public JuegosJugados() {
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
        for (int i = 1; i < jTablaJuegos.getColumnCount(); i++) {
            jTablaJuegos.getColumnModel().getColumn(i).setCellRenderer(centrador);
        }
        
        //Conectar
        try{
            oCN.conectar();
            modelo = (DefaultTableModel)jTablaJuegos.getModel();
            
            oCN.Ligas(JCBLiga);
            liga = JCBLiga.getSelectedItem().toString();
            oCN.Temporadas(JCBTemporada, liga);
            temporada = JCBTemporada.getSelectedItem().toString();
            oCN.Categorias(jCBCategoria, liga);
            categoria = jCBCategoria.getSelectedItem().toString();
            oCN.Equipos(jCBEquipo, temporada, categoria);
            equipo = jCBEquipo.getSelectedItem().toString();
            if(jRBBateadores.isSelected())
                oCN.JuegosJugadosBateadores(modelo, oCN.claveEquipo(equipo, categoria, temporada));
            else
                oCN.JuegosJugadosPichers(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        } catch(NullPointerException e) {
            
        }
    }

    //--------------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabEquipo = new javax.swing.JLabel();
        jCBEquipo = new javax.swing.JComboBox<>();
        jLabCategoría = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jRBBateadores = new javax.swing.JRadioButton();
        jRBPichers = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaJuegos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCBTemporada = new javax.swing.JComboBox<>();
        JCBLiga = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        jMIImprimir = new javax.swing.JMenuItem();
        jMIRegresar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JUEGOS JUGADOS");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabEquipo.setText("Equipo:");

        jCBEquipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCBEquipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBEquipoItemStateChanged(evt);
            }
        });

        jLabCategoría.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabCategoría.setText("Categoría");

        jCBCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCBCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBCategoriaItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRBBateadores);
        jRBBateadores.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jRBBateadores.setSelected(true);
        jRBBateadores.setText("Bateadores");

        buttonGroup1.add(jRBPichers);
        jRBPichers.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jRBPichers.setText("Pichers");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabEquipo)
                    .addComponent(jCBEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabCategoría))
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jRBBateadores)
                .addGap(18, 18, 18)
                .addComponent(jRBPichers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabEquipo)
                    .addComponent(jLabCategoría))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBBateadores)
                    .addComponent(jRBPichers))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablaJuegos.setBackground(new java.awt.Color(204, 204, 204));
        jTablaJuegos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaJuegos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTablaJuegos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Juegos Jugados"
            }
        ));
        jTablaJuegos.setGridColor(new java.awt.Color(0, 0, 0));
        jTablaJuegos.setShowGrid(true);
        jScrollPane1.setViewportView(jTablaJuegos);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JCBLiga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JCBTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JCBLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JCBTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        // Mostrar los Jugadores y sus Juegos Jugados por Categoria
        try {
        asignar();
        oCN.Equipos(jCBEquipo, temporada, categoria);
        if(jRBBateadores.isSelected())
            oCN.JuegosJugadosBateadores(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        else
            oCN.JuegosJugadosPichers(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        } catch(NullPointerException ex) {
            
        }
    }//GEN-LAST:event_jCBCategoriaItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    private void jCBEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBEquipoItemStateChanged
        // Mostrar los Jugadores y sus Juegos Jugados por Equipo
        try{
            equipo = evt.getItem().toString();
            asignar();
            if(jRBBateadores.isSelected())
                oCN.JuegosJugadosBateadores(modelo, oCN.claveEquipo(equipo, categoria, temporada));
            else
                oCN.JuegosJugadosPichers(modelo, oCN.claveEquipo(equipo, categoria, temporada));
        } catch (NullPointerException e) {
            equipo = " ";
        }
    }//GEN-LAST:event_jCBEquipoItemStateChanged

    private void jMIImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIImprimirActionPerformed
        // Imprimir la información
        asignar();
        oCN.Imprimir(jTablaJuegos, liga, equipo + " -JJ- " + categoria, "JuegosJugados");
    }//GEN-LAST:event_jMIImprimirActionPerformed

    private void JCBLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBLigaItemStateChanged
        // TODO add your handling code here:
        try{
            asignar();
            oCN.Temporadas(JCBTemporada, liga);
            oCN.Categorias(jCBCategoria, liga);
        } catch(NullPointerException ex) {
            
        }
    }//GEN-LAST:event_JCBLigaItemStateChanged

    private void JCBTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBTemporadaItemStateChanged
        // Cambiar la información según la temporada
        temporada = evt.getItem().toString();
        oCN.Categorias(jCBCategoria, liga);
        categoria = jCBCategoria.getSelectedItem().toString();
        
        oCN.Equipos(jCBEquipo, temporada, categoria);
    }//GEN-LAST:event_JCBTemporadaItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegosJugados().setVisible(true);
            }
        });
    }

    //--------------------------------------------------------------------------------------------
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBLiga;
    private javax.swing.JComboBox<String> JCBTemporada;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JComboBox<String> jCBEquipo;
    private javax.swing.JLabel jLabCategoría;
    private javax.swing.JLabel jLabEquipo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMIImprimir;
    private javax.swing.JMenuItem jMIRegresar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRBBateadores;
    private javax.swing.JRadioButton jRBPichers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaJuegos;
    // End of variables declaration//GEN-END:variables
}
