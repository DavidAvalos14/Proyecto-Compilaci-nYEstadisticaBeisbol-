package Frames;

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CATEGORIAS extends javax.swing.JFrame {

    // Atributos de las categorias
    String liga = "";
    String categoria = "";
    
    DefaultTableModel modelo;
    
    Conexion oCN = new Conexion();
    
    public void asignar() {
        liga = JCBLiga.getSelectedItem().toString();
        categoria = JTFNombre.getText();
    }
    
    public CATEGORIAS() {
        initComponents();
        
        Color color = new Color(204,204,204);
        getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        
        //Asignar una imagen como icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Frames/Kompilacion.png"));
        setIconImage(icon);
        
        oCN.Ligas(JCBLiga);
        
        modelo = (DefaultTableModel)TablaCategorias.getModel();
        
        oCN.mostrarCategorias(modelo, liga);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JCBLiga = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        JTFNombre = new javax.swing.JTextField();
        BotonAlta = new javax.swing.JLabel();
        BotonModificar = new javax.swing.JLabel();
        BotonBaja = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCategorias = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        Regresar = new javax.swing.JMenu();

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("LIGA:");

        jLabel2.setText("TEMPORADA:");

        jLabel3.setText("PERIODO:");

        jLabel4.setText("ALTA");

        jLabel5.setText("MODIFICAR");

        jLabel6.setText("BAJA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(168, 168, 168)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CATEGORÍAS");

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(550, 188));

        jLabel7.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel7.setText("LIGA:");

        JCBLiga.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JCBLiga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBLigaItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel8.setText("NOMBRE:");

        JTFNombre.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNombreActionPerformed(evt);
            }
        });

        BotonAlta.setBackground(new java.awt.Color(204, 204, 204));
        BotonAlta.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonAlta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonAlta.setText("ALTA");
        BotonAlta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonAlta.setOpaque(true);
        BotonAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAltaMouseClicked(evt);
            }
        });

        BotonModificar.setBackground(new java.awt.Color(204, 204, 204));
        BotonModificar.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonModificar.setText("MODIFICAR");
        BotonModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonModificar.setOpaque(true);
        BotonModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonModificarMouseClicked(evt);
            }
        });

        BotonBaja.setBackground(new java.awt.Color(204, 204, 204));
        BotonBaja.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonBaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonBaja.setText("BAJA");
        BotonBaja.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonBaja.setOpaque(true);
        BotonBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonBajaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFNombre)
                    .addComponent(JCBLiga, 0, 400, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JCBLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TablaCategorias.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        TablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CATEGORÍA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCategorias);

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));

        Regresar.setText("Regresar");
        Regresar.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegresarMouseClicked(evt);
            }
        });
        jMenuBar1.add(Regresar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarMouseClicked
        // Salir
        dispose();
    }//GEN-LAST:event_RegresarMouseClicked

    private void BotonAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAltaMouseClicked
        // Dar de alta una Categoría
        asignar();
        oCN.altaCategoria(liga, categoria);
        oCN.mostrarCategorias(modelo, liga);
    }//GEN-LAST:event_BotonAltaMouseClicked

    private void BotonModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonModificarMouseClicked
        // Modificar una categoría
        asignar();
        String nCat = JOptionPane.showInputDialog("Indique el Nuevo Nombre de la Categoria:");
        oCN.modificarCategoria(nCat, categoria);
        oCN.mostrarCategorias(modelo, liga);
    }//GEN-LAST:event_BotonModificarMouseClicked

    private void BotonBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonBajaMouseClicked
        // Dar de baja una Categoría
        asignar();
        oCN.bajaCategoria(categoria);
        oCN.mostrarCategorias(modelo, liga);
    }//GEN-LAST:event_BotonBajaMouseClicked

    private void TablaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCategoriasMouseClicked
        // Asignar los datos de las tablas
        if(evt.getClickCount() > 0){
            JTFNombre.setText(TablaCategorias.getValueAt(this.TablaCategorias.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_TablaCategoriasMouseClicked

    private void JTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNombreActionPerformed
        // Dar de alta con enter
        BotonAltaMouseClicked(null);
        JTFNombre.setText("");
    }//GEN-LAST:event_JTFNombreActionPerformed

    private void JCBLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBLigaItemStateChanged
        // refrescar cuando cambie de liga
        try {
            asignar();
            oCN.mostrarCategorias(modelo, liga);
        } catch (NullPointerException ex) {
            
        }
    }//GEN-LAST:event_JCBLigaItemStateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CATEGORIAS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonAlta;
    private javax.swing.JLabel BotonBaja;
    private javax.swing.JLabel BotonModificar;
    private javax.swing.JComboBox<String> JCBLiga;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JMenu Regresar;
    private javax.swing.JTable TablaCategorias;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
