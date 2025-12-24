package Frames;

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TEMPORADAS extends javax.swing.JFrame {

    // Atributos de la temporada
    String liga = "";
    String temporada = "";
    String periodo = "";
    
    Conexion oCN = new Conexion();
    
    DefaultTableModel modelo;
    
    public void asignar() {
        liga = JCBLiga.getSelectedItem().toString();
        temporada = JTFTemporada.getText();
        periodo = JTFPeriodo.getText();
    }
    
    public TEMPORADAS() {
        initComponents();
        
        Color color = new Color(204,204,204);
        getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        
        //Asignar una imagen como icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Frames/Kompilacion.png"));
        setIconImage(icon);
        
        oCN.Ligas(JCBLiga);
        
        modelo = (DefaultTableModel)TablaTemporadas.getModel();
        
        oCN.mostrarTemporadas(modelo, liga);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JCBLiga = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JTFTemporada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFPeriodo = new javax.swing.JTextField();
        BotonAlta = new javax.swing.JLabel();
        BotonModificar = new javax.swing.JLabel();
        BotonBaja = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTemporadas = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        Regresar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TEMPORADAS");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel1.setText("LIGA:");

        JCBLiga.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JCBLiga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBLigaItemStateChanged(evt);
            }
        });
        JCBLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBLigaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel2.setText("TEMPORADA:");

        JTFTemporada.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel3.setText("PERIODO:");

        JTFPeriodo.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JTFPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFPeriodoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(BotonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JTFTemporada, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCBLiga, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTFPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JCBLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(JTFPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TablaTemporadas.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        TablaTemporadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TEMPORADA", "PERIODO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaTemporadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTemporadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTemporadas);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarMouseClicked
        // Salir
        dispose();
    }//GEN-LAST:event_RegresarMouseClicked

    private void BotonAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAltaMouseClicked
        // Dar de alta una Temporada
        asignar();
        oCN.altaTemporada(liga, temporada, periodo);
        oCN.mostrarTemporadas(modelo, liga);
    }//GEN-LAST:event_BotonAltaMouseClicked

    private void BotonModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonModificarMouseClicked
        // Modificar una Temporada
        asignar();
        String nTemp = JOptionPane.showInputDialog("Indique el Nuevo Nombre de la Temporada:");
        String nPeriodo = JOptionPane.showInputDialog("Indique el Nuevo Periodo:");
        oCN.modificarTemporada(nTemp, nPeriodo, temporada);
        oCN.mostrarTemporadas(modelo, liga);
    }//GEN-LAST:event_BotonModificarMouseClicked

    private void BotonBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonBajaMouseClicked
        // Dar de baja una Temporada
        asignar();
        oCN.bajaTemporada(temporada);
        oCN.mostrarTemporadas(modelo, liga);
    }//GEN-LAST:event_BotonBajaMouseClicked

    private void TablaTemporadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTemporadasMouseClicked
        // Asignar los datos a los textfields
        if(evt.getClickCount() > 0){
            JTFTemporada.setText(TablaTemporadas.getValueAt(this.TablaTemporadas.getSelectedRow(), 0).toString());
            JTFPeriodo.setText(TablaTemporadas.getValueAt(this.TablaTemporadas.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_TablaTemporadasMouseClicked

    private void JTFPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFPeriodoActionPerformed
        // Dar de alta con enter
        BotonAltaMouseClicked(null);
        JTFTemporada.setText("");
        JTFPeriodo.setText("");
    }//GEN-LAST:event_JTFPeriodoActionPerformed

    private void JCBLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBLigaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBLigaActionPerformed

    private void JCBLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBLigaItemStateChanged
        // Filtrar temporadas por ligas
        try {
            asignar();
            oCN.mostrarTemporadas(modelo, liga);
        } catch (NullPointerException ex) {
            
        }
    }//GEN-LAST:event_JCBLigaItemStateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TEMPORADAS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonAlta;
    private javax.swing.JLabel BotonBaja;
    private javax.swing.JLabel BotonModificar;
    private javax.swing.JComboBox<String> JCBLiga;
    private javax.swing.JTextField JTFPeriodo;
    private javax.swing.JTextField JTFTemporada;
    private javax.swing.JMenu Regresar;
    private javax.swing.JTable TablaTemporadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
