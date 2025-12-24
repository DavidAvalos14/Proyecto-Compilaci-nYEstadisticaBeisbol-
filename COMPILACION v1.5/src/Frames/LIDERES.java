/*------------------------------------------------------------------------------------------
                        Liga de Beisbol Sertoma 

                    PERIODO: VACACIONES DE VERANO 2024   

            Frame para consultar los lideres en distintos departamentos
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : LIDERES.java
  Fecha       : JULIO/2024
  Compilador  : JDK 17 + Java NetBeans 20
  Descripción : Este frame contiene los componentes necesarios para consultar los lideres en 
                distintos departamentos, separado por categoría se puede consultar los lideres en:
                    1. Promedio de Bateo.
                    2. HomeRuns.
                    3. Carreras Producidas.
                    4. Robos de Base.
                    5. Picheo
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

public class LIDERES extends javax.swing.JFrame {

    //--------------------------------------------------------------------------------------------
    
    // Atributos de los lideres
    Conexion oCN = new Conexion();
    TableColumnModel modeloColumna;
    String liga, temporada, categoria;
    int jornada;
    double minimo;
    
    public void asignar() {
        liga = JCBLiga.getSelectedItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        categoria = jCBCategoria.getSelectedItem().toString();
        jornada = Integer.parseInt(jSpinJornada.getValue().toString());
        minimo = Double.parseDouble(jSpinMinimo.getValue().toString());
    }
    
    //--------------------------------------------------------------------------------------------
    
    public void centrar(){
        // Crear un DefaultTableCellRenderer para centrar el contenido
        DefaultTableCellRenderer centrador = new DefaultTableCellRenderer();
        centrador.setHorizontalAlignment(SwingConstants.CENTER);

        // Asignar el centrador a cada columna de la tabla
        for (int i = 2; i < jTablaLideres.getColumnCount(); i++) {
            jTablaLideres.getColumnModel().getColumn(i).setCellRenderer(centrador);
        }
    }
    
    public LIDERES() {
        initComponents();
        //Darle color y centrar
        Color color = new Color(204,204,204);
        getContentPane().setBackground(color);
        setLocationRelativeTo(null);
        
        //Darle Tamaño a cada una de las columnas
        modeloColumna = jTablaLideres.getColumnModel();
        modeloColumna.getColumn(0).setPreferredWidth(200);
        modeloColumna.getColumn(1).setPreferredWidth(200);
        modeloColumna.getColumn(2).setPreferredWidth(136);
        //Asignar una imagen como icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Frames/Kompilacion.png"));
        setIconImage(icon);
        //Conectar
        oCN.conectar();
        
        try {
            oCN.Ligas(JCBLiga);
            liga = JCBLiga.getSelectedItem().toString();
            oCN.Temporadas(JCBTemporada, liga);
            oCN.Categorias(jCBCategoria, liga);
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Podrian faltar datos...");
        }
    }

    //--------------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGLideres = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabCategoria = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jRBPromedio = new javax.swing.JRadioButton();
        jRBHomeRuns = new javax.swing.JRadioButton();
        jRBProducidas = new javax.swing.JRadioButton();
        jRBRobos = new javax.swing.JRadioButton();
        jRBGyP = new javax.swing.JRadioButton();
        jRBHits = new javax.swing.JRadioButton();
        jRBDobles = new javax.swing.JRadioButton();
        jRBTriples = new javax.swing.JRadioButton();
        jRBExB = new javax.swing.JRadioButton();
        jRBERA = new javax.swing.JRadioButton();
        jRBWHIP = new javax.swing.JRadioButton();
        jRBOAA = new javax.swing.JRadioButton();
        jRBOBP = new javax.swing.JRadioButton();
        jRBSLG = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jRBOPS = new javax.swing.JRadioButton();
        jLabCategoria1 = new javax.swing.JLabel();
        jLabCategoria2 = new javax.swing.JLabel();
        jSpinJornada = new javax.swing.JSpinner();
        jSpinMinimo = new javax.swing.JSpinner();
        jRBKs = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaLideres = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCBLiga = new javax.swing.JComboBox<>();
        JCBTemporada = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        jMIImprimir = new javax.swing.JMenuItem();
        jMIRegresar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LIDERES");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jRBPromedio.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBPromedio);
        jRBPromedio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBPromedio.setText("AVG");
        jRBPromedio.setOpaque(true);
        jRBPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBPromedioActionPerformed(evt);
            }
        });

        jRBHomeRuns.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBHomeRuns);
        jRBHomeRuns.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBHomeRuns.setText("HR");
        jRBHomeRuns.setOpaque(true);
        jRBHomeRuns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBHomeRunsActionPerformed(evt);
            }
        });

        jRBProducidas.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBProducidas);
        jRBProducidas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBProducidas.setText("PRODUCIDAS");
        jRBProducidas.setOpaque(true);
        jRBProducidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBProducidasActionPerformed(evt);
            }
        });

        jRBRobos.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBRobos);
        jRBRobos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBRobos.setText("ROBOS");
        jRBRobos.setOpaque(true);
        jRBRobos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBRobosActionPerformed(evt);
            }
        });

        jRBGyP.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBGyP);
        jRBGyP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBGyP.setText("VICTORIAS");
        jRBGyP.setOpaque(true);
        jRBGyP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBGyPActionPerformed(evt);
            }
        });

        jRBHits.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBHits);
        jRBHits.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBHits.setText("HITS");
        jRBHits.setOpaque(true);
        jRBHits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBHitsActionPerformed(evt);
            }
        });

        jRBDobles.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBDobles);
        jRBDobles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBDobles.setText("DOBLES");
        jRBDobles.setOpaque(true);
        jRBDobles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBDoblesActionPerformed(evt);
            }
        });

        jRBTriples.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBTriples);
        jRBTriples.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBTriples.setText("TRIPLES");
        jRBTriples.setOpaque(true);
        jRBTriples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTriplesActionPerformed(evt);
            }
        });

        jRBExB.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBExB);
        jRBExB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBExB.setText("EXTRABASES");
        jRBExB.setOpaque(true);
        jRBExB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBExBActionPerformed(evt);
            }
        });

        jRBERA.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBERA);
        jRBERA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBERA.setText("ERA");
        jRBERA.setOpaque(true);
        jRBERA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBERAActionPerformed(evt);
            }
        });

        jRBWHIP.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBWHIP);
        jRBWHIP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBWHIP.setText("WHIP");
        jRBWHIP.setOpaque(true);
        jRBWHIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBWHIPActionPerformed(evt);
            }
        });

        jRBOAA.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBOAA);
        jRBOAA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBOAA.setText("OAA");
        jRBOAA.setOpaque(true);
        jRBOAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBOAAActionPerformed(evt);
            }
        });

        jRBOBP.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBOBP);
        jRBOBP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBOBP.setText("OBP");
        jRBOBP.setOpaque(true);
        jRBOBP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBOBPActionPerformed(evt);
            }
        });

        jRBSLG.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBSLG);
        jRBSLG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBSLG.setText("SLG");
        jRBSLG.setOpaque(true);
        jRBSLG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBSLGActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jRBOPS.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBOPS);
        jRBOPS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBOPS.setText("OPS");
        jRBOPS.setOpaque(true);
        jRBOPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBOPSActionPerformed(evt);
            }
        });

        jLabCategoria1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabCategoria1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabCategoria1.setText("Jornada");

        jLabCategoria2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabCategoria2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabCategoria2.setText("min AP / IP");

        jSpinMinimo.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jRBKs.setBackground(new java.awt.Color(153, 153, 153));
        BGLideres.add(jRBKs);
        jRBKs.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRBKs.setText("K´s");
        jRBKs.setOpaque(true);
        jRBKs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBKsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBPromedio)
                    .addComponent(jRBHomeRuns)
                    .addComponent(jRBProducidas)
                    .addComponent(jRBRobos)
                    .addComponent(jRBHits)
                    .addComponent(jRBDobles)
                    .addComponent(jRBTriples)
                    .addComponent(jRBExB)
                    .addComponent(jRBOBP)
                    .addComponent(jRBSLG)
                    .addComponent(jRBOPS))
                .addGap(32, 32, 32)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBGyP)
                    .addComponent(jRBERA)
                    .addComponent(jRBOAA)
                    .addComponent(jRBWHIP)
                    .addComponent(jRBKs))
                .addGap(48, 48, 48)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCBCategoria, 0, 246, Short.MAX_VALUE)
                    .addComponent(jLabCategoria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinJornada)
                    .addComponent(jSpinMinimo)
                    .addComponent(jLabCategoria2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRBPromedio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBOBP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBSLG)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBOPS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBHits)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBDobles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBTriples)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBHomeRuns)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBExB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBProducidas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBRobos))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabCategoria1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabCategoria2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRBGyP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBERA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBKs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBWHIP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRBOAA)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablaLideres.setBackground(new java.awt.Color(204, 204, 204));
        jTablaLideres.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablaLideres.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTablaLideres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Equipo", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaLideres.setGridColor(new java.awt.Color(0, 0, 0));
        jTablaLideres.setShowGrid(true);
        jScrollPane1.setViewportView(jTablaLideres);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel3.setText("LIGA:");

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jLabel5.setText("TEMPORADA:");

        JCBLiga.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        JCBLiga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBLigaItemStateChanged(evt);
            }
        });

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        // Mostrar los lideres por Categoria
        categoria = evt.getItem().toString();
        temporada = JCBTemporada.getSelectedItem().toString();
        if(jRBPromedio.isSelected()){
            oCN.lideresPromedio(jTablaLideres, categoria, temporada, jornada*minimo);
        } else if(jRBHomeRuns.isSelected()){
            oCN.lideresHomeRuns(jTablaLideres, categoria, temporada);
        } else if(jRBProducidas.isSelected()){
            oCN.lideresProducidas(jTablaLideres, categoria, temporada);
        } else if(jRBRobos.isSelected()){
            oCN.lideresRobos(jTablaLideres, categoria, temporada);
        } else if(jRBGyP.isSelected()){
            oCN.lideresPicheo(jTablaLideres, categoria, temporada);
        } else if(jRBOBP.isSelected()) {
            oCN.lideresOBP(jTablaLideres, categoria, temporada, jornada*minimo);
        } else if(jRBSLG.isSelected()) {
            oCN.lideresSLG(jTablaLideres, categoria, temporada, jornada*minimo);
        } else if(jRBOPS.isSelected()) {
            oCN.lideresOPS(jTablaLideres, categoria, temporada, jornada*minimo);
        } else if(jRBHits.isSelected()) {
            oCN.lideresHits(jTablaLideres, categoria, temporada);
        } else if(jRBDobles.isSelected()) {
            oCN.lideresDobles(jTablaLideres, categoria, temporada);
        } else if(jRBTriples.isSelected()) {
            oCN.lideresTriples(jTablaLideres, categoria, temporada);
        } else if(jRBExB.isSelected()) {
            oCN.lideresExB(jTablaLideres, categoria, temporada);
        } else if(jRBERA.isSelected()) {
            oCN.lideresERA(jTablaLideres, categoria, temporada, jornada*minimo);
        } else if(jRBWHIP.isSelected()) {
            oCN.lideresWHIP(jTablaLideres, categoria, temporada, jornada*minimo);
        } else if(jRBOAA.isSelected()) {
            oCN.lideresOAA(jTablaLideres, categoria, temporada,jornada*minimo);
        }
    }//GEN-LAST:event_jCBCategoriaItemStateChanged

    //--------------------------------------------------------------------------------------------
    
    private void jRBPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBPromedioActionPerformed
        // Mostrar los lideres de Promedio
        asignar();
        oCN.lideresPromedio(jTablaLideres, categoria, temporada, jornada*minimo);
        centrar();
    }//GEN-LAST:event_jRBPromedioActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jRBHomeRunsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBHomeRunsActionPerformed
        // Mostrar los lideres en HomeRuns
        asignar();
        oCN.lideresHomeRuns(jTablaLideres, categoria, temporada);
        centrar();
    }//GEN-LAST:event_jRBHomeRunsActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jRBProducidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBProducidasActionPerformed
        // Mostrar los lideres en Producidas
        asignar();
        oCN.lideresProducidas(jTablaLideres, categoria, temporada);
        centrar();
    }//GEN-LAST:event_jRBProducidasActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jRBRobosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBRobosActionPerformed
        // Mostrar los lideres en Robos
        asignar();
        oCN.lideresRobos(jTablaLideres, categoria, temporada);
        centrar();
    }//GEN-LAST:event_jRBRobosActionPerformed

    //--------------------------------------------------------------------------------------------
    
    private void jRBGyPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBGyPActionPerformed
        // Mostrar los lideres en Ganados y Perdidos
        asignar();
        oCN.lideresPicheo(jTablaLideres, categoria, temporada);
        centrar();
    }//GEN-LAST:event_jRBGyPActionPerformed

    private void jMIImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIImprimirActionPerformed
        // Imprimir los lideres en cada departamento por categoria
        categoria = jCBCategoria.getSelectedItem().toString();
        String departamento = "";
        if(jRBPromedio.isSelected()){
            departamento = "Promedio";
        } else if(jRBHomeRuns.isSelected()){
            departamento = "HomeRuns";
        } else if(jRBProducidas.isSelected()){
            departamento = "Producidas";
        } else if(jRBRobos.isSelected()){
            departamento = "Robos";
        } else if(jRBGyP.isSelected()) {
            departamento = "Picheo";
        } else if(jRBOBP.isSelected()) {
            departamento = "OBP";
        } else if(jRBSLG.isSelected()) {
            departamento = "SLG";
        } else if(jRBOPS.isSelected()) {
            departamento = "OPS";
        } else if(jRBHits.isSelected()) {
            departamento = "Hits";
        } else if(jRBDobles.isSelected()) {
            departamento = "Dobles";
        } else if(jRBTriples.isSelected()) {
            departamento = "Triples";
        } else if(jRBExB.isSelected()) {
            departamento = "ExtraBases";
        } else if(jRBERA.isSelected()) {
            departamento = "Efectividad";
        } else if(jRBWHIP.isSelected()) {
            departamento = "WHIP";
        } else if(jRBOAA.isSelected()) {
            departamento = "OAA";
        } else if(jRBKs.isSelected()) {
            departamento = "Ponches";
        }
        
        oCN.Imprimir(jTablaLideres, liga, departamento + " - " + categoria, "Lideres");
    }//GEN-LAST:event_jMIImprimirActionPerformed

    private void jRBHitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBHitsActionPerformed
        // Hits
        asignar();
        oCN.lideresHits(jTablaLideres, categoria, temporada);
        centrar();
    }//GEN-LAST:event_jRBHitsActionPerformed

    private void jRBDoblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBDoblesActionPerformed
        // Dobles
        asignar();
        oCN.lideresDobles(jTablaLideres, categoria, temporada);
        centrar();
    }//GEN-LAST:event_jRBDoblesActionPerformed

    private void jRBTriplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTriplesActionPerformed
        // Triples
        asignar();
        oCN.lideresTriples(jTablaLideres, categoria, temporada);
        centrar();
    }//GEN-LAST:event_jRBTriplesActionPerformed

    private void jRBExBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBExBActionPerformed
        // Extrabases
        asignar();
        oCN.lideresExB(jTablaLideres, categoria, temporada);
        centrar();
    }//GEN-LAST:event_jRBExBActionPerformed

    private void jRBERAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBERAActionPerformed
        // Efectividad
        asignar();
        oCN.lideresERA(jTablaLideres, categoria, temporada, jornada*minimo);
        centrar();
    }//GEN-LAST:event_jRBERAActionPerformed

    private void jRBWHIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBWHIPActionPerformed
        // WHIP
        asignar();
        oCN.lideresWHIP(jTablaLideres, categoria, temporada, jornada*minimo);
        centrar();
    }//GEN-LAST:event_jRBWHIPActionPerformed

    private void jRBOAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBOAAActionPerformed
        // OAA
        asignar();
        oCN.lideresOAA(jTablaLideres, categoria, temporada, jornada*minimo);
        centrar();
    }//GEN-LAST:event_jRBOAAActionPerformed

    private void jRBOBPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBOBPActionPerformed
        // OBP
        asignar();
        oCN.lideresOBP(jTablaLideres, categoria, temporada, jornada*minimo);
        centrar();
    }//GEN-LAST:event_jRBOBPActionPerformed

    private void jRBSLGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBSLGActionPerformed
        // Slugging
        asignar();
        oCN.lideresSLG(jTablaLideres, categoria, temporada, jornada*minimo);
        centrar();
    }//GEN-LAST:event_jRBSLGActionPerformed

    private void jRBOPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBOPSActionPerformed
        // OPS
        asignar();
        oCN.lideresOPS(jTablaLideres, categoria, temporada, jornada*minimo);
        centrar();
    }//GEN-LAST:event_jRBOPSActionPerformed

    private void JCBLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBLigaItemStateChanged
        // Cambiar la información según la liga
        liga = evt.getItem().toString();
        oCN.Temporadas(JCBTemporada, liga);
        oCN.Categorias(jCBCategoria, liga);
    }//GEN-LAST:event_JCBLigaItemStateChanged

    private void JCBTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBTemporadaItemStateChanged
        // Cambiar la información según la temporada
        temporada = evt.getItem().toString();
        //liga = JCBLiga.getSelectedItem().toString();
        //oCN.Categorias(jCBCategoria, liga);
        //categoria = jCBCategoria.getSelectedItem().toString();
    }//GEN-LAST:event_JCBTemporadaItemStateChanged

    private void jRBKsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBKsActionPerformed
        // TODO add your handling code here:
        asignar();
        oCN.LideresPonches(jTablaLideres, categoria, temporada);
        centrar();
    }//GEN-LAST:event_jRBKsActionPerformed

    //--------------------------------------------------------------------------------------------
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LIDERES().setVisible(true);
            }
        });
    }

    //--------------------------------------------------------------------------------------------
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGLideres;
    private javax.swing.JComboBox<String> JCBLiga;
    private javax.swing.JComboBox<String> JCBTemporada;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JLabel jLabCategoria;
    private javax.swing.JLabel jLabCategoria1;
    private javax.swing.JLabel jLabCategoria2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMIImprimir;
    private javax.swing.JMenuItem jMIRegresar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRBDobles;
    private javax.swing.JRadioButton jRBERA;
    private javax.swing.JRadioButton jRBExB;
    private javax.swing.JRadioButton jRBGyP;
    private javax.swing.JRadioButton jRBHits;
    private javax.swing.JRadioButton jRBHomeRuns;
    private javax.swing.JRadioButton jRBKs;
    private javax.swing.JRadioButton jRBOAA;
    private javax.swing.JRadioButton jRBOBP;
    private javax.swing.JRadioButton jRBOPS;
    private javax.swing.JRadioButton jRBProducidas;
    private javax.swing.JRadioButton jRBPromedio;
    private javax.swing.JRadioButton jRBRobos;
    private javax.swing.JRadioButton jRBSLG;
    private javax.swing.JRadioButton jRBTriples;
    private javax.swing.JRadioButton jRBWHIP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinJornada;
    private javax.swing.JSpinner jSpinMinimo;
    private javax.swing.JTable jTablaLideres;
    // End of variables declaration//GEN-END:variables
}
