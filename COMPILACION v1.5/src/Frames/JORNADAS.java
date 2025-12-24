/*------------------------------------------------------------------------------------------
                        Liga de Beisbol Sertoma 

                    PERIODO: VACACIONES DE VERANO 2024   

            Frame para manipular la información de las Jornadas
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : JORNADAS.java
  Fecha       : JULIO/2024
  Compilador  : JDK 17 + Java NetBeans 20
  Descripción : Este frame contiene los componentes necesarios para manipular la información
                de las jornadas:
                    1. Dar de alta Jornadas con su fecha de inicio y su fecha de fin, se puede modificar
                    y eliminar cierta jornada.
==========================================================================================*/

//--------------------------------------------------------------------------------------------

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

public class JORNADAS extends javax.swing.JFrame {

    //--------------------------------------------------------------------------------------------
    
    // Atributos de la temporada
    Conexion oCN = new Conexion();
    DefaultTableModel modelo;
    //int jornada;
    String liga, temporada;
    String clave, jornada, vuelta, fechaI, fechaF;
    
    public void asignar() {
        liga = JCBLiga.getSelectedItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        labelClave.setText(liga.charAt(0) + "" + liga.charAt(1) + "-" + temporada + "-");
        clave = labelClave.getText();
        vuelta = jSpinVuelta.getValue().toString();
        jornada = jSpinNumJornada.getValue().toString();
        jornada = clave + jornada + "-" + vuelta;
        fechaI = jTFFechaI.getText();
        fechaF = jTFFechaF.getText();
    }
    
    //--------------------------------------------------------------------------------------------
    
    public JORNADAS() {
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
        for (int i = 0; i < jTablaJornadas.getColumnCount(); i++) {
            jTablaJornadas.getColumnModel().getColumn(i).setCellRenderer(centrador);
        }
            
        modelo = (DefaultTableModel)jTablaJornadas.getModel();
        
        try {
            oCN.Ligas(JCBLiga);
            liga = JCBLiga.getSelectedItem().toString();
            oCN.Temporadas(JCBTemporada, liga);
            temporada = JCBTemporada.getSelectedItem().toString();
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Podrian faltar datos...");
        }
        
        //Conectar y mostrar
        oCN.conectar();
        oCN.mostrarJornada(modelo, temporada);
    }

    //--------------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSpinNumJornada = new javax.swing.JSpinner();
        jButAltaJornada = new javax.swing.JButton();
        jButModificarJornada = new javax.swing.JButton();
        jButBajaJornada = new javax.swing.JButton();
        jTFFechaI = new javax.swing.JTextField();
        jTFFechaF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaJornadas1 = new javax.swing.JTable();
        labelClave = new javax.swing.JLabel();
        jSpinVuelta = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaJornadas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        JCBLiga = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        JCBTemporada = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        jMIRegresar = new javax.swing.JMenuItem();

        jLabel4.setText("TEMPORADA:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JORNADAS");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinNumJornada.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jSpinNumJornada.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        jSpinNumJornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButAltaJornada.setBackground(new java.awt.Color(204, 204, 204));
        jButAltaJornada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButAltaJornada.setText("ALTA");
        jButAltaJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAltaJornadaActionPerformed(evt);
            }
        });

        jButModificarJornada.setBackground(new java.awt.Color(204, 204, 204));
        jButModificarJornada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButModificarJornada.setText("MODIFICAR");
        jButModificarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButModificarJornadaActionPerformed(evt);
            }
        });

        jButBajaJornada.setBackground(new java.awt.Color(204, 204, 204));
        jButBajaJornada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButBajaJornada.setText("BAJA");
        jButBajaJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButBajaJornadaActionPerformed(evt);
            }
        });

        jTFFechaI.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jTFFechaI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFFechaI.setToolTipText("YYYY-MM-DD");
        jTFFechaI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTFFechaF.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jTFFechaF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFFechaF.setToolTipText("YYYY-MM-DD");
        jTFFechaF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablaJornadas1.setBackground(new java.awt.Color(204, 204, 204));
        jTablaJornadas1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaJornadas1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTablaJornadas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CLAVE", "JORNADA", "1/2", "INICIO", "FIN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaJornadas1.setGridColor(new java.awt.Color(0, 0, 0));
        jTablaJornadas1.setShowGrid(true);
        jTablaJornadas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaJornadas1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablaJornadas1);

        labelClave.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        labelClave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinVuelta.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jSpinVuelta.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));
        jSpinVuelta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButAltaJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButModificarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jButBajaJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelClave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jSpinNumJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jSpinVuelta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTFFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTFFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(9, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinNumJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelClave, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinVuelta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButAltaJornada)
                    .addComponent(jButModificarJornada)
                    .addComponent(jButBajaJornada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablaJornadas.setBackground(new java.awt.Color(204, 204, 204));
        jTablaJornadas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaJornadas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTablaJornadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jornada", "Inicio", "Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaJornadas.setGridColor(new java.awt.Color(0, 0, 0));
        jTablaJornadas.setShowGrid(true);
        jTablaJornadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaJornadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaJornadas);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel3.setText("LIGA:");

        JCBLiga.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JCBLiga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBLigaItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel5.setText("TEMPORADA:");

        JCBTemporada.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JCBTemporada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        JCBTemporada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBTemporadaItemStateChanged(evt);
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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCBLiga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JCBTemporada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
    
    private void jButAltaJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAltaJornadaActionPerformed
        // Dar de alta una Jornada
        asignar();
        oCN.altaJornada(jornada, fechaI, fechaF, temporada);
        oCN.mostrarJornada(modelo, temporada);
    }//GEN-LAST:event_jButAltaJornadaActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButModificarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButModificarJornadaActionPerformed
        // Modificar los datos de una Jornada
        //Guardar los datos por mensajes de texto
        asignar();
        String njornada = JOptionPane.showInputDialog("Indique la Nueva Jornada:");
        String nfi = JOptionPane.showInputDialog("Indique la Nueva Fecha de Inicio:");
        String nff = JOptionPane.showInputDialog("Indique la Nueva Fecha de Fin:");
        oCN.modificarJornada(njornada, nfi, nff, oCN.claveJornada(jornada));
        oCN.mostrarJornada(modelo, temporada);
    }//GEN-LAST:event_jButModificarJornadaActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jButBajaJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButBajaJornadaActionPerformed
        // Dar de Baja una Jornada
        asignar();
        oCN.bajaJornada(oCN.claveJornada(jornada));
        oCN.mostrarJornada(modelo, temporada);
    }//GEN-LAST:event_jButBajaJornadaActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jTablaJornadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaJornadasMouseClicked
        // Pasar los datos a los campos con dar click
        /*if(evt.getClickCount() > 0){
            jSpinNumJornada.setValue((jTablaJornadas.getValueAt(this.jTablaJornadas.getSelectedRow(), 0).toString().charAt(7)));
            jTFFechaI.setText(jTablaJornadas.getValueAt(this.jTablaJornadas.getSelectedRow(), 1).toString());
            jTFFechaF.setText(jTablaJornadas.getValueAt(this.jTablaJornadas.getSelectedRow(), 2).toString());
        }*/
    }//GEN-LAST:event_jTablaJornadasMouseClicked

    private void jTablaJornadas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaJornadas1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablaJornadas1MouseClicked

    private void JCBLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBLigaItemStateChanged
        // TODO add your handling code here:
        liga = JCBLiga.getSelectedItem().toString();
        oCN.Temporadas(JCBTemporada, liga);
        asignar();
        oCN.mostrarJornada(modelo, temporada);
    }//GEN-LAST:event_JCBLigaItemStateChanged

    private void JCBTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBTemporadaItemStateChanged
        // TODO add your handling code here:
        try {
            asignar();
            oCN.mostrarJornada(modelo, temporada);
        } catch (NullPointerException e) {
            temporada = "Default";
        }
    }//GEN-LAST:event_JCBTemporadaItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JORNADAS().setVisible(true);
            }
        });
    }

    //--------------------------------------------------------------------------------------------
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBLiga;
    private javax.swing.JComboBox<String> JCBTemporada;
    private javax.swing.JButton jButAltaJornada;
    private javax.swing.JButton jButBajaJornada;
    private javax.swing.JButton jButModificarJornada;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMIRegresar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinNumJornada;
    private javax.swing.JSpinner jSpinVuelta;
    private javax.swing.JTextField jTFFechaF;
    private javax.swing.JTextField jTFFechaI;
    private javax.swing.JTable jTablaJornadas;
    private javax.swing.JTable jTablaJornadas1;
    private javax.swing.JLabel labelClave;
    // End of variables declaration//GEN-END:variables
}
