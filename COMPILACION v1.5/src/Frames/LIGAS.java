package Frames;

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumnModel;

public class LIGAS extends javax.swing.JFrame {

    // Atributos de las Ligas
    String liga = "";
    String tipo = "";
    
    Conexion oCN = new Conexion();
    
    DefaultTableModel modelo;
    //TableColumnModel modeloColumna;
    
    public void asignar() {
        liga = JTFNombre.getText();
        tipo = JTFTipo.getText();
    }
    
    public LIGAS() {
        initComponents();
        
        Color color = new Color(204,204,204);
        getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        
        //Asignar una imagen como icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Frames/Kompilacion.png"));
        setIconImage(icon);
        
        modelo = (DefaultTableModel)TablaLigas.getModel();
        
        oCN.mostrarLigas(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFNombre = new javax.swing.JTextField();
        JTFTipo = new javax.swing.JTextField();
        BotonAlta = new javax.swing.JLabel();
        BotonBaja = new javax.swing.JLabel();
        BotonModificar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaLigas = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        Regresar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LIGAS");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel1.setText("NOMBRE:");

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel2.setText("TIPO:");

        JTFTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFTipoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(BotonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(JTFNombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaLigas.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        TablaLigas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LIGA", "TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaLigas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaLigasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaLigas);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarMouseClicked
        // Salir
        dispose();
    }//GEN-LAST:event_RegresarMouseClicked

    private void BotonAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAltaMouseClicked
        // Dar de alta una liga
        asignar();
        oCN.altaLiga(liga, tipo);
        oCN.mostrarLigas(modelo);
    }//GEN-LAST:event_BotonAltaMouseClicked

    private void BotonModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonModificarMouseClicked
        // Modificar una liga
        asignar();
        String nLiga = JOptionPane.showInputDialog("Indique el Nuevo Nombre de la Liga:");
        String nTipo = JOptionPane.showInputDialog("Indique el Nuevo Tipo:");
        oCN.modificarLiga(nLiga, nTipo, liga);
        oCN.mostrarLigas(modelo);
    }//GEN-LAST:event_BotonModificarMouseClicked

    private void BotonBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonBajaMouseClicked
        // Dar de baja una liga
        asignar();
        oCN.bajaLiga(liga);
        oCN.mostrarLigas(modelo);
    }//GEN-LAST:event_BotonBajaMouseClicked

    private void TablaLigasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaLigasMouseClicked
        // Asignar los datos a los textfields
        if(evt.getClickCount() > 0){
            JTFNombre.setText(TablaLigas.getValueAt(this.TablaLigas.getSelectedRow(), 0).toString());
            JTFTipo.setText(TablaLigas.getValueAt(this.TablaLigas.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_TablaLigasMouseClicked

    private void JTFTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFTipoActionPerformed
        // Dar de alta con enter
        BotonAltaMouseClicked(null);
        JTFNombre.setText("");
        JTFTipo.setText("");
    }//GEN-LAST:event_JTFTipoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LIGAS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonAlta;
    private javax.swing.JLabel BotonBaja;
    private javax.swing.JLabel BotonModificar;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JTextField JTFTipo;
    private javax.swing.JMenu Regresar;
    private javax.swing.JTable TablaLigas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
