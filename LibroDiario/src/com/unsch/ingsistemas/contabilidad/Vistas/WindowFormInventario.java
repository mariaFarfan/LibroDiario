/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.ingsistemas.contabilidad.Vistas;

import com.unsch.ingsistemas.contabilidad.Clases.TablaAsiento;
import com.unsch.ingsistemas.contabilidad.bd.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nn.WindowFormFind2;
import nn.WindowFormFind3;
import nn.WindowFormFind4;
import nn.WindowFormFind5;

/**
 *
 * @author MARIA
 */
public class WindowFormInventario extends javax.swing.JInternalFrame {
    
     public void guardartablaAsientoPatrimonio(String numeroAsiento) {
        ArrayList<TablaAsiento> reg = new ArrayList();
        try {
            TablaAsiento tabla = new TablaAsiento();
            tabla.setNumeroAsiento(numeroAsiento);
            tabla.setCodigo("50");
            tabla.setDescripcion("CAPITAL");
            tabla.setDebe("0");
            tabla.setHaber(jLabel19.getText());

            ConexionBD con = new ConexionBD();
            String sql = "insert into tablaasiento values(NULL,'" + numeroAsiento + "','" + tabla.getCodigo() + "','" + tabla.getDescripcion() + "','" + tabla.getDebe() + "','" + tabla.getHaber() + "')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();

            System.out.println(tabla.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void guardartablaAsiento1(String numeroAsiento) {
        ArrayList<TablaAsiento> reg = new ArrayList();
        try {
            TablaAsiento tabla = new TablaAsiento();
            tabla.setNumeroAsiento(numeroAsiento);
            tabla.setCodigo((String) cod);
            tabla.setDescripcion(jtfDescripcion.getText());
            tabla.setDebe(jtfMonto.getText());
            tabla.setHaber("0");

            ConexionBD con = new ConexionBD();
            String sql = "insert into tablaasiento values(NULL,'" + numeroAsiento + "','" + tabla.getCodigo() + "','" + tabla.getDescripcion() + "','" + tabla.getDebe() + "','" + tabla.getHaber() + "')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();

            System.out.println(tabla.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void guardartablaAsiento2(String numeroAsiento) {
        ArrayList<TablaAsiento> reg = new ArrayList();
        try {
            TablaAsiento tabla = new TablaAsiento();
            tabla.setNumeroAsiento(numeroAsiento);
            tabla.setCodigo((String) cod);
            tabla.setDescripcion(jtfDescripcion1.getText());
            tabla.setDebe(jtfMonto1.getText());
            tabla.setHaber("0");

            ConexionBD con = new ConexionBD();
            String sql = "insert into tablaasiento values(NULL,'" + numeroAsiento + "','" + tabla.getCodigo() + "','" + tabla.getDescripcion() + "','" + tabla.getDebe() + "','" + tabla.getHaber() + "')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();

            System.out.println(tabla.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void guardartablaAsiento3(String numeroAsiento) {
        ArrayList<TablaAsiento> reg = new ArrayList();
        try {
            TablaAsiento tabla = new TablaAsiento();
            tabla.setNumeroAsiento(numeroAsiento);
            tabla.setCodigo((String) cod);
            tabla.setDescripcion(jtfDescripcion2.getText());
            tabla.setDebe("0");
            tabla.setHaber(jtfMonto2.getText());

            ConexionBD con = new ConexionBD();
            String sql = "insert into tablaasiento values(NULL,'" + numeroAsiento + "','" + tabla.getCodigo() + "','" + tabla.getDescripcion() + "','" + tabla.getDebe() + "','" + tabla.getHaber() + "')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();

            System.out.println(tabla.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public int obtnerultimoRgtr() throws SQLException {
        int cx = 0;

        ConexionBD con = new ConexionBD();
        Statement s = (Statement) con.getConexion().createStatement();
        ResultSet c = s.executeQuery("select MAX(numeroAsiento) from asiento ");

        while (c.next()) {
            cx = c.getInt(1);
        }
        return cx + 1;

    }

    public void sumaActivoCorriente() {
        String a = "";
        double total = 0;
        double b = 0;

        for (int fila = 0; fila < jtbInventario1.getRowCount(); fila++) {

            if (jtbInventario1.getValueAt(fila, 1) != "") {
                a = String.valueOf(jtbInventario1.getValueAt(fila, 1));
                b = Double.valueOf(a);
                total = total + b;
            } else {
                total = total + 0;
            }

        }
        txtTotalAcCor.setText(String.valueOf(total));
    }

    public void sumaActivoNoCorriente() {
        String a = "";
        double total = 0;
        double b = 0;

        for (int fila = 0; fila < JTBaCTIVOcORRIENTE1.getRowCount(); fila++) {

            if (JTBaCTIVOcORRIENTE1.getValueAt(fila, 1) != "") {
                a = String.valueOf(JTBaCTIVOcORRIENTE1.getValueAt(fila, 1));
                b = Double.valueOf(a);
                total = total + b;
            } else {
                total = total + 0;
            }

        }
        txtTotalANC.setText(String.valueOf(total));
    }

    public void sumaPasivoCorriente() {
        String a = "";
        double total = 0;
        double b = 0;

        for (int fila = 0; fila < JTBaCTIVOcORRIENTE2.getRowCount(); fila++) {

            if (JTBaCTIVOcORRIENTE2.getValueAt(fila, 1) != "") {
                a = String.valueOf(JTBaCTIVOcORRIENTE2.getValueAt(fila, 1));
                b = Double.valueOf(a);
                total = total + b;
            } else {
                total = total + 0;
            }

        }
        txtTotalPC.setText(String.valueOf(total));
    }

    public void sumaPasivoNoCorriente() {
        String a = "";
        double total = 0;
        double b = 0;

        for (int fila = 0; fila < JTBaCTIVOcORRIENTE3.getRowCount(); fila++) {

            if (JTBaCTIVOcORRIENTE3.getValueAt(fila, 1) != "") {
                a = String.valueOf(JTBaCTIVOcORRIENTE3.getValueAt(fila, 1));
                b = Double.valueOf(a);
                total = total + b;
            } else {
                total = total + 0;
            }

        }
        txtTotalPNC.setText(String.valueOf(total));
    }

    public void patrimonioNeto() {
        double patrimnonioNeto2 = (Double.parseDouble(txtTotalAcCor.getText()) + Double.parseDouble(txtTotalANC.getText())) - (Double.parseDouble(txtTotalPC.getText()) + Double.parseDouble(txtTotalPNC.getText()));
        double totalActivo = (Double.parseDouble(txtTotalAcCor.getText()) + Double.parseDouble(txtTotalANC.getText()));
        double totalPasivo = (Double.parseDouble(txtTotalPC.getText()) + Double.parseDouble(txtTotalPNC.getText()));
        double patpasiv = patrimnonioNeto2 + totalPasivo;
        lblTotalActivo.setText("" + totalActivo);
        lblTotalPasivo.setText("" + totalPasivo);
        jLabel19.setText(patrimnonioNeto2 + "");
        lblpasivoPatrimonio.setText("" + patpasiv);
    }

    public String getFecha() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yy");
        return formateador.format(ahora);
    }

    int ultimoRegistroBD = obtnerultimoRgtr();

    /**
     * Creates new form WindowFormInventario
     */
    public WindowFormInventario() throws SQLException {
        initComponents();
        jtfFecha.setText(getFecha());
        lblTotalActivo.setText("00.00");
        lblTotalPasivo.setText("00.00");
        txtTotalANC.setText("0.00");
        txtTotalAcCor.setText("0.00");
        txtTotalPC.setText("0.00");
        txtTotalPNC.setText("0.00");
        jLabel19.setText("0.00");
        lblpasivoPatrimonio.setText("0.00");
        guardarAsiento(ultimoRegistroBD + "" + "", jtfFecha.getText(), "0", "0", jTextArea1.getText(), "");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jtfFecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtfDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfMonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbInventario1 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtTotalAcCor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jtfDescripcion1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfMonto1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTBaCTIVOcORRIENTE1 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtTotalANC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalActivo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jtfDescripcion2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtfMonto2 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTBaCTIVOcORRIENTE2 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtTotalPC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jtfDescripcion3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtfMonto3 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTBaCTIVOcORRIENTE3 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtTotalPNC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblTotalPasivo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblpasivoPatrimonio = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Inventario - UNSCH - EPIS - Contabilidad General");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS :"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setText("Glosa :");

        jtfFecha.setEditable(false);

        jLabel9.setText("Fecha :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("ACTIVO"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("ACTIVO CORRIENTE"));

        jLabel8.setText("Descripción de la Cuenta :");

        jLabel7.setText("Monto :");

        jtfMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMontoActionPerformed(evt);
            }
        });

        jtbInventario1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DENOMINACION", "MONTO"
            }
        ));
        jScrollPane1.setViewportView(jtbInventario1);
        if (jtbInventario1.getColumnModel().getColumnCount() > 0) {
            jtbInventario1.getColumnModel().getColumn(1).setMinWidth(100);
            jtbInventario1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtbInventario1.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jButton10.setText("GUARDAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTotalAcCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalAcCorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("TOTAL ACTIVO CORRIENTE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalAcCor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton10)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10)
                    .addComponent(jLabel7))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalAcCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("ACTIVO NO CORRIENTE"));

        jLabel10.setText("Descripción de la Cuenta :");

        jLabel11.setText("Monto :");

        jtfMonto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMonto1ActionPerformed(evt);
            }
        });

        JTBaCTIVOcORRIENTE1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DENOMINACION", "MONTO"
            }
        ));
        jScrollPane4.setViewportView(JTBaCTIVOcORRIENTE1);
        if (JTBaCTIVOcORRIENTE1.getColumnModel().getColumnCount() > 0) {
            JTBaCTIVOcORRIENTE1.getColumnModel().getColumn(1).setMinWidth(100);
            JTBaCTIVOcORRIENTE1.getColumnModel().getColumn(1).setPreferredWidth(100);
            JTBaCTIVOcORRIENTE1.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jButton11.setText("GUARDAR");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtTotalANC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalANCActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("TOTAL ACTIVO CORRIENTE");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalANC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jtfDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11)
                    .addComponent(jLabel11))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalANC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)))
        );

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setText("TOTAL ACTIVO");

        lblTotalActivo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTotalActivo.setForeground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("PASIVO"));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("PASIVO CORRIENTE"));

        jLabel12.setText("Descripción de la Cuenta :");

        jLabel13.setText("Monto :");

        jtfMonto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMonto2ActionPerformed(evt);
            }
        });

        JTBaCTIVOcORRIENTE2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DENOMINACION", "MONTO"
            }
        ));
        jScrollPane5.setViewportView(JTBaCTIVOcORRIENTE2);
        if (JTBaCTIVOcORRIENTE2.getColumnModel().getColumnCount() > 0) {
            JTBaCTIVOcORRIENTE2.getColumnModel().getColumn(1).setMinWidth(100);
            JTBaCTIVOcORRIENTE2.getColumnModel().getColumn(1).setPreferredWidth(100);
            JTBaCTIVOcORRIENTE2.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jButton12.setText("GUARDAR");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton3.setText("BUSCAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtTotalPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPCActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("TOTAL ACTIVO CORRIENTE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalPC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfMonto2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jtfDescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMonto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12)
                    .addComponent(jLabel13))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("PASIVO NO CORRIENTE"));

        jLabel14.setText("Descripción de la Cuenta :");

        jLabel15.setText("Monto :");

        jtfMonto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMonto3ActionPerformed(evt);
            }
        });

        JTBaCTIVOcORRIENTE3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DENOMINACION", "MONTO"
            }
        ));
        jScrollPane6.setViewportView(JTBaCTIVOcORRIENTE3);
        if (JTBaCTIVOcORRIENTE3.getColumnModel().getColumnCount() > 0) {
            JTBaCTIVOcORRIENTE3.getColumnModel().getColumn(1).setMinWidth(100);
            JTBaCTIVOcORRIENTE3.getColumnModel().getColumn(1).setPreferredWidth(100);
            JTBaCTIVOcORRIENTE3.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jButton13.setText("GUARDAR");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton4.setText("BUSCAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtTotalPNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPNCActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("TOTAL ACTIVO CORRIENTE");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalPNC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfMonto3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton13))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jtfDescripcion3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDescripcion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMonto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13)
                    .addComponent(jLabel15))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)))
        );

        lblTotalPasivo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTotalPasivo.setForeground(new java.awt.Color(204, 0, 51));

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel17.setText("TOTAL PASIVO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalPasivo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPasivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unsch/ingsistemas/contabilidad/Images/accept.png"))); // NOI18N
        jButton5.setText("GUARDAR");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("DejaVu Sans Light", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 204));
        jLabel16.setText("INVENTARIO INICIAL");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("PATRIMONIO NETO"));

        jLabel18.setText("TOTAL PATRIMONIO NETO");

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 51, 0));
        jLabel19.setText("jLabel19");

        jLabel20.setText("Total  Pasivo y Patrimonio");

        lblpasivoPatrimonio.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblpasivoPatrimonio.setForeground(new java.awt.Color(204, 51, 0));
        lblpasivoPatrimonio.setText("jLabel19");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpasivoPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblpasivoPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {

            DefaultTableModel modelo = (DefaultTableModel) jtbInventario1.getModel();

            double monto = Double.parseDouble(jtfMonto.getText());
            modelo.addRow(new Object[]{jtfDescripcion.getText(), jtfMonto.getText()});

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ingrese un numero correcto");
        }
        sumaActivoCorriente();
        patrimonioNeto();
        guardartablaAsiento1(ultimoRegistroBD + "");
//        sumaDeber();
//        sumaHaber();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        WindowFormFind2 n = new WindowFormFind2();
        n.setLocationRelativeTo(null);
        n.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMontoActionPerformed

    private void txtTotalAcCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalAcCorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalAcCorActionPerformed

    private void jtfMonto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMonto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMonto1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel modelo = (DefaultTableModel) JTBaCTIVOcORRIENTE1.getModel();

            double monto = Double.parseDouble(jtfMonto1.getText());
            modelo.addRow(new Object[]{jtfDescripcion1.getText(), jtfMonto1.getText()});

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ingrese un numero correcto");
        }
        sumaActivoNoCorriente();
        patrimonioNeto();
        guardartablaAsiento2(ultimoRegistroBD + "");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WindowFormFind3 n = new WindowFormFind3();
        n.setLocationRelativeTo(null);
        n.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTotalANCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalANCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalANCActionPerformed

    private void txtTotalPNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPNCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPNCActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        WindowFormFind5 n = new WindowFormFind5();
        n.setLocationRelativeTo(null);
        n.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    static public String cod = "";
    static public String descripciong = "";

    public void guardarAsiento(String ul, String fecha, String totaldebe, String totalhaber, String glosa, String numerodoc) {

        try {
            ConexionBD con = new ConexionBD();
            String sql = "insert into asiento values(NULL,'" + ul + "','" + fecha + "','" + totaldebe + "','" + totalhaber + "','" + glosa + "','" + numerodoc + "')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void guardartablaAsiento4(String numeroAsiento) {
        ArrayList<TablaAsiento> reg = new ArrayList();
        try {
            TablaAsiento tabla = new TablaAsiento();
            tabla.setNumeroAsiento(numeroAsiento);
            tabla.setCodigo((String) cod);
            tabla.setDescripcion(jtfDescripcion3.getText());
            tabla.setDebe("0");
            tabla.setHaber(jtfMonto3.getText());

            ConexionBD con = new ConexionBD();
            String sql = "insert into tablaasiento values(NULL,'" + numeroAsiento + "','" + tabla.getCodigo() + "','" + tabla.getDescripcion() + "','" + tabla.getDebe() + "','" + tabla.getHaber() + "')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();

            System.out.println(tabla.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {

            DefaultTableModel modelo = (DefaultTableModel) JTBaCTIVOcORRIENTE3.getModel();

            double monto = Double.parseDouble(jtfMonto3.getText());
            modelo.addRow(new Object[]{jtfDescripcion3.getText(), jtfMonto3.getText()});

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ingrese un numero correcto");
        }
        sumaPasivoNoCorriente();
        patrimonioNeto();

        guardartablaAsiento4(ultimoRegistroBD + "");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jtfMonto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMonto3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMonto3ActionPerformed

    private void txtTotalPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPCActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        WindowFormFind4 n = new WindowFormFind4();
        n.setLocationRelativeTo(null);
        n.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel modelo = (DefaultTableModel) JTBaCTIVOcORRIENTE2.getModel();

            double monto = Double.parseDouble(jtfMonto2.getText());
            modelo.addRow(new Object[]{jtfDescripcion2.getText(), jtfMonto2.getText()});

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ingrese un numero correcto");
        }
        sumaPasivoCorriente();
        patrimonioNeto();
        guardartablaAsiento3(ultimoRegistroBD + "");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jtfMonto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMonto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMonto2ActionPerformed

   
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        guardartablaAsientoPatrimonio(ultimoRegistroBD+"");
        JOptionPane.showMessageDialog(null,"Inventario Guardado :) " );
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTBaCTIVOcORRIENTE1;
    private javax.swing.JTable JTBaCTIVOcORRIENTE2;
    private javax.swing.JTable JTBaCTIVOcORRIENTE3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable jtbInventario1;
    public static javax.swing.JTextField jtfDescripcion;
    public static javax.swing.JTextField jtfDescripcion1;
    public static javax.swing.JTextField jtfDescripcion2;
    public static javax.swing.JTextField jtfDescripcion3;
    private javax.swing.JTextField jtfFecha;
    private javax.swing.JTextField jtfMonto;
    private javax.swing.JTextField jtfMonto1;
    private javax.swing.JTextField jtfMonto2;
    private javax.swing.JTextField jtfMonto3;
    private javax.swing.JLabel lblTotalActivo;
    private javax.swing.JLabel lblTotalPasivo;
    private javax.swing.JLabel lblpasivoPatrimonio;
    private javax.swing.JTextField txtTotalANC;
    private javax.swing.JTextField txtTotalAcCor;
    private javax.swing.JTextField txtTotalPC;
    private javax.swing.JTextField txtTotalPNC;
    // End of variables declaration//GEN-END:variables
}
