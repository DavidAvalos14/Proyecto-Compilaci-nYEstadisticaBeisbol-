/*------------------------------------------------------------------------------------------
                        Compilación Beisbol y Softbol

                    PERIODO: VACACIONES DE INVIERNO 2024-25 

            Frame inicial para acceder a distinta información
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : Inicio.java
  Fecha       : ENERO/2025
  Compilador  : JDK 17 + Java NetBeans 22
  Descripción : Este frame contiene 10 botones que redireccionan a frames
                dedicados a la información individual de distintos tópicos:
                    1. Ligas
                    2. Temporadas
                    3. Categorías
                    4. Equipos
                    5. Bateadores
                    6. Pichers
                    7. Jornadas
                    8. Lideres
                    9. Juegos Jugados
                    10. Jornada X Jornada
==========================================================================================*/

package Frames;

//--------------------------------------------------------------------------------------------

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

//--------------------------------------------------------------------------------------------

public class Inicio extends javax.swing.JFrame {

    Conexion oCN = null;
      
    //--------------------------------------------------------------------------------------------
    
    public Inicio() {
        initComponents();
        //Darle color y centrar
        Color color = new Color(204,204,204);
        getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        //Asignar una imagen como icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Frames/Kompilacion.png"));
        setIconImage(icon);
        //Crear la conexión
        oCN = new Conexion();
        oCN.conectar();
    }

    //--------------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonEquipos = new javax.swing.JLabel();
        BotonBateadores = new javax.swing.JLabel();
        BotonJornadas = new javax.swing.JLabel();
        BotonLideres = new javax.swing.JLabel();
        BotonJuegosJugados = new javax.swing.JLabel();
        BotonLigas = new javax.swing.JLabel();
        BotonCategorias = new javax.swing.JLabel();
        BotonPichers = new javax.swing.JLabel();
        BotonJornadaXJornada = new javax.swing.JLabel();
        BotonTemporadas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        MenuItemSalir = new javax.swing.JMenuItem();
        MenuAyuda = new javax.swing.JMenu();
        MenuItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COMPILACIÓN Y ESTADÍSTICA");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BotonEquipos.setBackground(new java.awt.Color(204, 204, 204));
        BotonEquipos.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonEquipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonEquipos.setText("EQUIPOS");
        BotonEquipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonEquipos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonEquipos.setOpaque(true);
        BotonEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEquiposMouseClicked(evt);
            }
        });

        BotonBateadores.setBackground(new java.awt.Color(204, 204, 204));
        BotonBateadores.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonBateadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonBateadores.setText("BATEADORES");
        BotonBateadores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonBateadores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonBateadores.setOpaque(true);
        BotonBateadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonBateadoresMouseClicked(evt);
            }
        });

        BotonJornadas.setBackground(new java.awt.Color(204, 204, 204));
        BotonJornadas.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonJornadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonJornadas.setText("JORNADAS");
        BotonJornadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonJornadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonJornadas.setOpaque(true);
        BotonJornadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonJornadasMouseClicked(evt);
            }
        });

        BotonLideres.setBackground(new java.awt.Color(204, 204, 204));
        BotonLideres.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonLideres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonLideres.setText("LIDERES");
        BotonLideres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonLideres.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonLideres.setOpaque(true);
        BotonLideres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonLideresMouseClicked(evt);
            }
        });

        BotonJuegosJugados.setBackground(new java.awt.Color(204, 204, 204));
        BotonJuegosJugados.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonJuegosJugados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonJuegosJugados.setText("JUEGOS JUGADOS");
        BotonJuegosJugados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonJuegosJugados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonJuegosJugados.setOpaque(true);
        BotonJuegosJugados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonJuegosJugadosMouseClicked(evt);
            }
        });

        BotonLigas.setBackground(new java.awt.Color(204, 204, 204));
        BotonLigas.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonLigas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonLigas.setText("LIGAS");
        BotonLigas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonLigas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonLigas.setOpaque(true);
        BotonLigas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonLigasMouseClicked(evt);
            }
        });

        BotonCategorias.setBackground(new java.awt.Color(204, 204, 204));
        BotonCategorias.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonCategorias.setText("CATEGORÍAS");
        BotonCategorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonCategorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonCategorias.setOpaque(true);
        BotonCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonCategoriasMouseClicked(evt);
            }
        });

        BotonPichers.setBackground(new java.awt.Color(204, 204, 204));
        BotonPichers.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonPichers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonPichers.setText("PICHERS");
        BotonPichers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonPichers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonPichers.setOpaque(true);
        BotonPichers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonPichersMouseClicked(evt);
            }
        });

        BotonJornadaXJornada.setBackground(new java.awt.Color(204, 204, 204));
        BotonJornadaXJornada.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonJornadaXJornada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonJornadaXJornada.setText("JORNADA POR JORNADA");
        BotonJornadaXJornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonJornadaXJornada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonJornadaXJornada.setOpaque(true);
        BotonJornadaXJornada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonJornadaXJornadaMouseClicked(evt);
            }
        });

        BotonTemporadas.setBackground(new java.awt.Color(204, 204, 204));
        BotonTemporadas.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        BotonTemporadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonTemporadas.setText("TEMPORADAS");
        BotonTemporadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonTemporadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonTemporadas.setOpaque(true);
        BotonTemporadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonTemporadasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonBateadores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonLigas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonPichers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonJornadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonLideres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonJuegosJugados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonJornadaXJornada, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(BotonTemporadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonLigas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonTemporadas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonBateadores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonPichers, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonLideres, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonJuegosJugados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonJornadaXJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frames/Kompilacion.png"))); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        MenuArchivo.setText("Archivo");
        MenuArchivo.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N

        MenuItemSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuItemSalir.setText("Salir");
        MenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSalirActionPerformed(evt);
            }
        });
        MenuArchivo.add(MenuItemSalir);

        jMenuBar1.add(MenuArchivo);

        MenuAyuda.setText("Ayuda");
        MenuAyuda.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N

        MenuItemAcercaDe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuItemAcercaDe.setText("Acerca De...");
        MenuItemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAcercaDeActionPerformed(evt);
            }
        });
        MenuAyuda.add(MenuItemAcercaDe);

        jMenuBar1.add(MenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //--------------------------------------------------------------------------------------------
    
    private void BotonEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEquiposMouseClicked
        // Acceder al Frame EQUIPOS
        EQUIPOS eq = new EQUIPOS();
        eq.setVisible(true);
    }//GEN-LAST:event_BotonEquiposMouseClicked

    //--------------------------------------------------------------------------------------------
    
    private void BotonBateadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonBateadoresMouseClicked
        // Acceder al Frame JUGADORES
        BATEADORES jg = new BATEADORES();
        jg.setVisible(true);
    }//GEN-LAST:event_BotonBateadoresMouseClicked

    //--------------------------------------------------------------------------------------------
    
    private void BotonJornadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonJornadasMouseClicked
        // Acceder al Frame JORNADAS
        JORNADAS jr = new JORNADAS();
        jr.setVisible(true);
    }//GEN-LAST:event_BotonJornadasMouseClicked

    //--------------------------------------------------------------------------------------------
    
    private void BotonLideresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLideresMouseClicked
        // Acceder al Frame LIDERES
        LIDERES ld = new LIDERES();
        ld.setVisible(true);
    }//GEN-LAST:event_BotonLideresMouseClicked

    //--------------------------------------------------------------------------------------------
    
    private void BotonJuegosJugadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonJuegosJugadosMouseClicked
        // Acceder al Frame OTROS
        JuegosJugados jj = new JuegosJugados();
        jj.setVisible(true);
    }//GEN-LAST:event_BotonJuegosJugadosMouseClicked

    //--------------------------------------------------------------------------------------------
    
    private void MenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSalirActionPerformed
        // Salir
        dispose();
    }//GEN-LAST:event_MenuItemSalirActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void MenuItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAcercaDeActionPerformed
        // Mostrar información sobre el programa
        JOptionPane.showMessageDialog(null, "Autor: Angel David Avalos Carrillo\n"
                            + "Sistema de Compilación y Estadística\n"
                            + "Versión 1.5\n",
                            "Acerca De", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_MenuItemAcercaDeActionPerformed

    private void BotonLigasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLigasMouseClicked
        // Dirigir hacia la ventana de Ligas
        LIGAS liga = new LIGAS();
        liga.setVisible(true);
    }//GEN-LAST:event_BotonLigasMouseClicked

    private void BotonTemporadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonTemporadasMouseClicked
        // Dirigir hacia la ventana Temporadas
        TEMPORADAS tmp = new TEMPORADAS();
        tmp.setVisible(true);
    }//GEN-LAST:event_BotonTemporadasMouseClicked

    private void BotonCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCategoriasMouseClicked
        // Dirigir hacia la ventana Categorias
        CATEGORIAS ctg = new CATEGORIAS();
        ctg.setVisible(true);
    }//GEN-LAST:event_BotonCategoriasMouseClicked

    private void BotonPichersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonPichersMouseClicked
        // Dirigir hacia la ventana de pichers
        PICHERS pch = new PICHERS();
        pch.setVisible(true);
    }//GEN-LAST:event_BotonPichersMouseClicked

    private void BotonJornadaXJornadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonJornadaXJornadaMouseClicked
        // Dirigir hacia la ventana jornada X jornada
        JornadasX jx = new JornadasX();
        jx.setVisible(true);
    }//GEN-LAST:event_BotonJornadaXJornadaMouseClicked

    //--------------------------------------------------------------------------------------------
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    //--------------------------------------------------------------------------------------------
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonBateadores;
    private javax.swing.JLabel BotonCategorias;
    private javax.swing.JLabel BotonEquipos;
    private javax.swing.JLabel BotonJornadaXJornada;
    private javax.swing.JLabel BotonJornadas;
    private javax.swing.JLabel BotonJuegosJugados;
    private javax.swing.JLabel BotonLideres;
    private javax.swing.JLabel BotonLigas;
    private javax.swing.JLabel BotonPichers;
    private javax.swing.JLabel BotonTemporadas;
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenu MenuAyuda;
    private javax.swing.JMenuItem MenuItemAcercaDe;
    private javax.swing.JMenuItem MenuItemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
