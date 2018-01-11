/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.ingsistemas.contabilidad.Vistas;

import com.unsch.ingsistemas.contabilidad.Clases.CellRenderer;
import com.unsch.ingsistemas.contabilidad.Clases.Empleado;
import com.unsch.ingsistemas.contabilidad.Clases.TablaAsiento;
import static com.unsch.ingsistemas.contabilidad.Vistas.WindowFormAsiento.jtfCuenta;
import static com.unsch.ingsistemas.contabilidad.Vistas.WindowFormAsiento.jtfDescripcion;
import com.unsch.ingsistemas.contabilidad.bd.ConexionBD;
import com.unsch.ingsistemas.contabilidad.bd.EmpleadoCRUD;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MARIA
 */
public class WindowFormPlanilla extends javax.swing.JInternalFrame {

    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }

    public void sumaHaber() {
        String a = "";
        double total = 0;
        double total2 = 0;
        double total3 = 0;
        double total4 = 0;
        double total5 = 0;
        double total6 = 0;
        double total7 = 0;
        double total8 = 0;
        double total9 = 0;
        double total10 = 0;
        double total11 = 0;
        double total12 = 0;

        double b = 0;
        double b2 = 0;
        double b3 = 0;
        double b4 = 0;
        double b5 = 0;
        double b6 = 0;
        double b7 = 0;
        double b8 = 0;
        double b9 = 0;
        double b10 = 0;
        double b11 = 0;
        double b12 = 0;

        for (int fila = 0; fila < jtbPlanilla.getRowCount(); fila++) {

            b = Double.valueOf(jtbPlanilla.getValueAt(fila, 3).toString());
            b2 = Double.valueOf(jtbPlanilla.getValueAt(fila, 4).toString());
            b3 = Double.valueOf(jtbPlanilla.getValueAt(fila, 5).toString());
            b4 = Double.valueOf(jtbPlanilla.getValueAt(fila, 6).toString());
            b5 = Double.valueOf(jtbPlanilla.getValueAt(fila, 7).toString());
            b6 = Double.valueOf(jtbPlanilla.getValueAt(fila, 8).toString());
            b7 = Double.valueOf(jtbPlanilla.getValueAt(fila, 9).toString());
            b8 = Double.valueOf(jtbPlanilla.getValueAt(fila, 10).toString());
            b9 = Double.valueOf(jtbPlanilla.getValueAt(fila, 11).toString());
            b10 = Double.valueOf(jtbPlanilla.getValueAt(fila, 12).toString());
            b11 = Double.valueOf(jtbPlanilla.getValueAt(fila, 13).toString());
            b12 = Double.valueOf(jtbPlanilla.getValueAt(fila, 14).toString());

            total = total + b;
            total2 = total2 + b2;
            total3 = total3 + b3;
            total4 = total4 + b4;
            total5 = total5 + b5;
            total6 = total6 + b6;
            total7 = total7 + b7;
            total8 = total8 + b8;
            total9 = total9 + b9;
            total10 = total10 + b10;
            total11 = total11 + b11;
            total12 = total12 + b12;

        }

        rpt1.setText(String.valueOf(total));
        rpt2.setText(String.valueOf(total2));
        rpt3.setText(String.valueOf(total3));
        rpt4.setText(String.valueOf(total4));
        rpt5.setText(String.valueOf(total5));
        rpt6.setText(String.valueOf(total6));
        rpt7.setText(String.valueOf(total7));
        rpt8.setText(String.valueOf(total8));
        rpt9.setText(String.valueOf(total9));
        rpt10.setText(String.valueOf(total10));
        rpt11.setText(String.valueOf(total11));
        rpt12.setText(String.valueOf(total12));

    }

    /**
     * Creates new form WindowFormPlanilla
     */
    public WindowFormPlanilla() {
        initComponents();
        setCellRender(jtbPlanilla);
        setTitle("Planilla de Sueldos - UNSCH - EPIS - Contabilidad General");
        rpt1.setText("00.00");
        rpt2.setText("00.00");
        rpt3.setText("00.00");
        rpt4.setText("00.00");
        rpt5.setText("00.00");
        rpt6.setText("00.00");
        rpt7.setText("00.00");
        rpt8.setText("00.00");
        rpt9.setText("00.00");
        rpt10.setText("00.00");
        rpt11.setText("00.00");
        rpt12.setText("00.00");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtOtrosAportes = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtOtrosDescuentos = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHaberBasico = new javax.swing.JTextField();
        txtOtros = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbPlanilla = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtAdministracion = new javax.swing.JTextField();
        txtVentas = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        rpt1 = new javax.swing.JLabel();
        rpt2 = new javax.swing.JLabel();
        rpt3 = new javax.swing.JLabel();
        rpt4 = new javax.swing.JLabel();
        rpt5 = new javax.swing.JLabel();
        rpt6 = new javax.swing.JLabel();
        rpt7 = new javax.swing.JLabel();
        rpt8 = new javax.swing.JLabel();
        rpt9 = new javax.swing.JLabel();
        rpt10 = new javax.swing.JLabel();
        rpt11 = new javax.swing.JLabel();
        rpt12 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("APORTES"));

        jLabel16.setText("Otros :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 81, Short.MAX_VALUE)
                .addComponent(txtOtrosAportes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOtrosAportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DESCUENTOS"));

        jLabel10.setText("Otros :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(txtOtrosDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10))
                    .addComponent(txtOtrosDescuentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INGRESOS"));

        jLabel3.setText("Haber Basico :");

        jLabel5.setText("Otros :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHaberBasico, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHaberBasico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(22, 22, 22))
        );

        jLabel2.setText("Cargo:");

        jLabel1.setText("Nombre :");

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel17.setText("PLANILLA DE SUELDOS");

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        jtbPlanilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nombres", "Cargo", "H. Básico", "A. Familiar", "Otros", "R. Bruta", "AFP", "SNP", "otros", "R. Neta", "Seguro", "Senati", "SCTR", "Otros"
            }
        ));
        jtbPlanilla.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jtbPlanilla);
        jtbPlanilla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jtbPlanilla.getColumnModel().getColumnCount() > 0) {
            jtbPlanilla.getColumnModel().getColumn(0).setMinWidth(30);
            jtbPlanilla.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtbPlanilla.getColumnModel().getColumn(0).setMaxWidth(30);
            jtbPlanilla.getColumnModel().getColumn(3).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(3).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(4).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(4).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(5).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(5).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(6).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(6).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(7).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(7).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(8).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(8).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(9).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(9).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(10).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(10).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(11).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(11).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(12).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(12).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(13).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(13).setMaxWidth(70);
            jtbPlanilla.getColumnModel().getColumn(14).setMinWidth(70);
            jtbPlanilla.getColumnModel().getColumn(14).setMaxWidth(70);
        }

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setText("Ventas : ");

        jLabel19.setText("Administración : ");

        jLabel18.setText("afectacion a resultados :  ");

        jLabel22.setText("%");

        jLabel21.setText("%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVentas)
                            .addComponent(txtAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addComponent(jButton1))
        );

        jToolBar1.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unsch/ingsistemas/contabilidad/Images/accept.png"))); // NOI18N
        jButton2.setText("GUARDAR");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unsch/ingsistemas/contabilidad/Images/add_to_folder.png"))); // NOI18N
        jButton3.setText("NUEVO");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unsch/ingsistemas/contabilidad/Images/full_page.png"))); // NOI18N
        jButton4.setText("REPORTE");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unsch/ingsistemas/contabilidad/Images/delete.png"))); // NOI18N
        jButton5.setText("SALIR");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        rpt1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt1.setForeground(new java.awt.Color(204, 0, 0));
        rpt1.setText("jLabel6");

        rpt2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt2.setForeground(new java.awt.Color(204, 0, 0));
        rpt2.setText("jLabel7");

        rpt3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt3.setForeground(new java.awt.Color(204, 0, 0));
        rpt3.setText("jLabel11");
        rpt3.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt3.setMinimumSize(new java.awt.Dimension(41, 16));

        rpt4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt4.setForeground(new java.awt.Color(204, 0, 0));
        rpt4.setText("jLabel12");
        rpt4.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt4.setMinimumSize(new java.awt.Dimension(41, 16));

        rpt5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt5.setForeground(new java.awt.Color(204, 0, 0));
        rpt5.setText("jLabel23");
        rpt5.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt5.setMinimumSize(new java.awt.Dimension(41, 16));

        rpt6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt6.setForeground(new java.awt.Color(204, 0, 0));
        rpt6.setText("jLabel24");
        rpt6.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt6.setMinimumSize(new java.awt.Dimension(41, 16));

        rpt7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt7.setForeground(new java.awt.Color(204, 0, 0));
        rpt7.setText("jLabel25");
        rpt7.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt7.setMinimumSize(new java.awt.Dimension(41, 16));

        rpt8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt8.setForeground(new java.awt.Color(204, 0, 0));
        rpt8.setText("jLabel26");
        rpt8.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt8.setMinimumSize(new java.awt.Dimension(41, 16));

        rpt9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt9.setForeground(new java.awt.Color(204, 0, 0));
        rpt9.setText("jLabel27");
        rpt9.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt9.setMinimumSize(new java.awt.Dimension(41, 16));

        rpt10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt10.setForeground(new java.awt.Color(204, 0, 0));
        rpt10.setText("jLabel28");
        rpt10.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt10.setMinimumSize(new java.awt.Dimension(41, 16));

        rpt11.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt11.setForeground(new java.awt.Color(204, 0, 0));
        rpt11.setText("jLabel29");
        rpt11.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt11.setMinimumSize(new java.awt.Dimension(41, 16));

        rpt12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rpt12.setForeground(new java.awt.Color(204, 0, 0));
        rpt12.setText("jLabel30");
        rpt12.setMaximumSize(new java.awt.Dimension(41, 16));
        rpt12.setMinimumSize(new java.awt.Dimension(41, 16));

        jLabel31.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel31.setText("TOTAL :");

        jButton6.setText("...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(388, 388, 388)
                            .addComponent(jLabel31)
                            .addGap(18, 18, 18)
                            .addComponent(rpt1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rpt3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rpt4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rpt5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rpt6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rpt7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rpt8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rpt9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rpt10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rpt11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rpt12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton6))))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jLabel17)))
                .addContainerGap(472, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel17)
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rpt1)
                    .addComponent(rpt2)
                    .addComponent(rpt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpt11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpt12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            if (txtVentas.getText().equalsIgnoreCase("") || txtAdministracion.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos :) ");
            } else {

//                 si tiene hijo 10%
//                 si no tiene  0 
                double asigFamiliar=0;
                EmpleadoCRUD ec = new EmpleadoCRUD();
                Empleado e = ec.select(txtNombre.getText());
                double hijo = Double.parseDouble(e.getHijo());
                if (hijo > 0) {
                    asigFamiliar = 0.10 * 850;
                } 

                double remuneraconBruta = Double.parseDouble(txtHaberBasico.getText()) + asigFamiliar + Double.parseDouble(txtOtros.getText());

                // depende cual tenga
                String pension  =  e.getPension();
                double snp =0;
                double afp =0;
                if (pension.equalsIgnoreCase("afp")) {
                     afp = 0.1356 * Double.parseDouble(txtHaberBasico.getText());
                }
                else{
                    snp = 0.13 * Double.parseDouble(txtHaberBasico.getText());
                }
                
                double remuneracionNeta = remuneraconBruta - afp - snp - Double.parseDouble(txtOtrosDescuentos.getText());

                double seguro = 0.9 * remuneraconBruta;
                double senati = 0.75 * remuneraconBruta;
                double sctr = 0.03 * remuneraconBruta;

                DefaultTableModel modelo = (DefaultTableModel) jtbPlanilla.getModel();
                modelo.addRow(new Object[]{jtbPlanilla.getRowCount() + 1, txtNombre.getText(), txtCargo.getText(), txtHaberBasico.getText(), asigFamiliar, txtOtros.getText(),
                    remuneraconBruta, afp, snp, txtOtrosDescuentos.getText(), remuneracionNeta, seguro, senati,
                    sctr, txtOtrosAportes.getText()});
                sumaHaber();

            }

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos :) ");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtNombre.setText("");
        txtCargo.setText("");
        txtHaberBasico.setText("");
//        txtAsignacionFamiliar.setText("");
        txtOtros.setText("");
//        txtAfp.setText("");
//        txtSnp.setText("");
        txtOtrosDescuentos.setText("");
//        txtSeguro.setText("");
//        txtSenati.setText("");
//        txtSCTR.setText("");
        txtAdministracion.setText("");
        txtVentas.setText("");

        modelo = (DefaultTableModel) jtbPlanilla.getModel();
        modelo.setRowCount(0);
        jtbPlanilla.setModel(modelo);

        rpt1.setText("00.00");
        rpt2.setText("00.00");
        rpt3.setText("00.00");
        rpt4.setText("00.00");
        rpt5.setText("00.00");
        rpt6.setText("00.00");
        rpt7.setText("00.00");
        rpt8.setText("00.00");
        rpt9.setText("00.00");
        rpt10.setText("00.00");
        rpt11.setText("00.00");
        rpt12.setText("00.00");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed
    public void guardartablaPlnilla() {
        ArrayList<TablaAsiento> reg = new ArrayList();
        for (int fila = 0; fila < jtbPlanilla.getRowCount(); fila++) {
            try {
                String nombre = (String) jtbPlanilla.getValueAt(fila, 1);
                String cargo = (String) jtbPlanilla.getValueAt(fila, 2);
                String haberBasico = (String) jtbPlanilla.getValueAt(fila, 3);
                String asignacionFamiliar = (String) jtbPlanilla.getValueAt(fila, 4).toString();
                String otrosIngresos = (String) jtbPlanilla.getValueAt(fila, 5).toString();
                String remuneracionBruta = "" + jtbPlanilla.getValueAt(fila, 6).toString();
                String afp = (String) jtbPlanilla.getValueAt(fila, 7).toString();
                String snp = (String) jtbPlanilla.getValueAt(fila, 8).toString();
                String otrosDescuentos = (String) jtbPlanilla.getValueAt(fila, 9).toString();
                String RemuneracinNeta = "" + jtbPlanilla.getValueAt(fila, 10).toString();
                String seguro = (String) jtbPlanilla.getValueAt(fila, 11).toString();
                String senati = (String) jtbPlanilla.getValueAt(fila, 12).toString();
                String sctr = (String) jtbPlanilla.getValueAt(fila, 13).toString();
                String otrosAportes = (String) jtbPlanilla.getValueAt(fila, 14).toString();

                ConexionBD con = new ConexionBD();
                String sql = "insert into planilla values(NULL,'" + nombre + "','" + cargo + "','" + haberBasico + "','" + asignacionFamiliar + "','" + otrosIngresos + "','" + remuneracionBruta + "','" + afp + "','" + snp + "','" + otrosDescuentos + "','" + RemuneracinNeta + "','" + seguro + "','" + senati + "','" + sctr + "','" + otrosAportes + "')";
                Statement s = (Statement) con.getConexion().createStatement();
                s.executeUpdate(sql);
                con.cerrarConexion();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }

    DefaultTableModel modelo;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        guardarPlanilla(txtNombre.getText(), txtCargo.getText(), jtfTotaldebe.getText(), jtfTotalHaber.getText(), jTextArea2.getText(), jtfnumerodoc.getText());
        guardartablaPlnilla();
        JOptionPane.showMessageDialog(null, "Asiento Guardado \nExitosamente :) ");

        txtNombre.setText("");
        txtCargo.setText("");
        txtHaberBasico.setText("");
//        txtAsignacionFamiliar.setText("");
        txtOtros.setText("");
//        txtAfp.setText("");
//        txtSnp.setText("");
        txtOtrosDescuentos.setText("");
//        txtSeguro.setText("");
//        txtSenati.setText("");
//        txtSCTR.setText("");
        txtAdministracion.setText("");
        txtVentas.setText("");

        modelo = (DefaultTableModel) jtbPlanilla.getModel();
        modelo.setRowCount(0);
        jtbPlanilla.setModel(modelo);

        rpt1.setText("00.00");
        rpt2.setText("00.00");
        rpt3.setText("00.00");
        rpt4.setText("00.00");
        rpt5.setText("00.00");
        rpt6.setText("00.00");
        rpt7.setText("00.00");
        rpt8.setText("00.00");
        rpt9.setText("00.00");
        rpt10.setText("00.00");
        rpt11.setText("00.00");
        rpt12.setText("00.00");


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            // Generar reportes
            JasperReport jr = (JasperReport) JRLoader.loadObject(WindowFormAsiento.class.getResource("/com/unsch/ingsistemas/contabilidad/Reportes/planilla.jasper"));
            ConexionBD con = new ConexionBD();
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConexion());
//            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, new JREmptyDataSource());

            JasperViewer jv = new JasperViewer(jp, false);
            jv.show();
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        WindowFormFindEmployee v = new WindowFormFindEmployee();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtbPlanilla;
    private javax.swing.JLabel rpt1;
    private javax.swing.JLabel rpt10;
    private javax.swing.JLabel rpt11;
    private javax.swing.JLabel rpt12;
    private javax.swing.JLabel rpt2;
    private javax.swing.JLabel rpt3;
    private javax.swing.JLabel rpt4;
    private javax.swing.JLabel rpt5;
    private javax.swing.JLabel rpt6;
    private javax.swing.JLabel rpt7;
    private javax.swing.JLabel rpt8;
    private javax.swing.JLabel rpt9;
    private javax.swing.JTextField txtAdministracion;
    public static javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtHaberBasico;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOtros;
    private javax.swing.JTextField txtOtrosAportes;
    private javax.swing.JTextField txtOtrosDescuentos;
    private javax.swing.JTextField txtVentas;
    // End of variables declaration//GEN-END:variables
}
