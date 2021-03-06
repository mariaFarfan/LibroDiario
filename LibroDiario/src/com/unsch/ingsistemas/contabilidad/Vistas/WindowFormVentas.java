/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.ingsistemas.contabilidad.Vistas;

import com.unsch.ingsistemas.contabilidad.Clases.Producto;
import com.unsch.ingsistemas.contabilidad.Clases.TablaAsiento;
import com.unsch.ingsistemas.contabilidad.bd.ConexionBD;
import com.unsch.ingsistemas.contabilidad.bd.ProductoCrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USUARIO
 */
public class WindowFormVentas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Ventas
     */
    public String getFecha() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-dd-MM");
        return formateador.format(ahora);
    }

    public void guardarVenta(String nombre, String cantidad, String documento) {
        try {
            ArrayList<TablaAsiento> reg = new ArrayList();
            ConexionBD con = new ConexionBD();
            // INSERT INTO `compra` VALUES ('', '12/12/12', 'USB', '23');
            String sql = "insert into venta values(NULL,'" + getFecha() + "','" + nombre + "','" + cantidad + "','" + documento + "','VENTA')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(WindowFormProductAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int obtnerultimoRgtr() throws SQLException {
        int cx = 0;

        ConexionBD con = new ConexionBD();
        Statement s = (Statement) con.getConexion().createStatement();
        ResultSet c = s.executeQuery("select MAX(numeroCorrelativo) from factura ");

        while (c.next()) {
            cx = c.getInt(1);
        }
        return cx + 1;

    }

    public WindowFormVentas() throws SQLException {
        initComponents();
        txtfecha.setText(getFecha());
        txtNumeroCorrelativo.setText("00000" + obtnerultimoRgtr() + "");
    }

    public int obtnerultimoRgtrAsiento() throws SQLException {
        int cx = 0;

        ConexionBD con = new ConexionBD();
        Statement s = (Statement) con.getConexion().createStatement();
        ResultSet c = s.executeQuery("select MAX(numeroAsiento) from asiento ");

        while (c.next()) {
            cx = c.getInt(1);
        }
        return cx + 1;

    }

    public void guardartablaAsientoFactura() {
        try {
            TablaAsiento tabla1 = new TablaAsiento();
            tabla1.setNumeroAsiento(obtnerultimoRgtrAsiento() + "");
            tabla1.setCodigo("121");
            tabla1.setDescripcion("FACTURAS, BOLETAS Y OTROS COMPROBANTES POR COBRAR");
            tabla1.setDebe(txtTotal.getText());
            tabla1.setHaber("0");

            ConexionBD con = new ConexionBD();
            String sql = "insert into tablaasiento values(NULL,'" + tabla1.getNumeroAsiento() + "','" + tabla1.getCodigo() + "','" + tabla1.getDescripcion() + "','" + tabla1.getDebe() + "','" + tabla1.getHaber() + "')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            s.close();

            TablaAsiento tabla2 = new TablaAsiento();
            tabla2.setNumeroAsiento(obtnerultimoRgtrAsiento() + "");
            tabla2.setCodigo("4011");
            tabla2.setDescripcion("IMPUESTO GENERAL A LAS VENTAS ");
            tabla2.setDebe("0");
            tabla2.setHaber(txtIgv.getText());

            String sql2 = "insert into tablaasiento values(NULL,'" + tabla2.getNumeroAsiento() + "','" + tabla2.getCodigo() + "','" + tabla2.getDescripcion() + "','" + tabla2.getDebe() + "','" + tabla2.getHaber() + "')";
            Statement s2 = (Statement) con.getConexion().createStatement();
            s2.executeUpdate(sql2);
            s2.close();

            TablaAsiento tabla3 = new TablaAsiento();
            tabla3.setNumeroAsiento(obtnerultimoRgtrAsiento() + "");
            tabla3.setCodigo("701");
            tabla3.setDescripcion("MERCADERÍAS");
            tabla3.setDebe("0");
            tabla3.setHaber(txtSubTotal.getText());

            String sql3 = "insert into tablaasiento values(NULL,'" + tabla3.getNumeroAsiento() + "','" + tabla3.getCodigo() + "','" + tabla3.getDescripcion() + "','" + tabla3.getDebe() + "','" + tabla3.getHaber() + "')";
            Statement s3 = (Statement) con.getConexion().createStatement();
            s3.executeUpdate(sql3);
            s3.close();

            con.cerrarConexion();

            System.out.println(tabla1.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNumeroCorrelativo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtruc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbFactura = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        txtMostrarNumeroLetra = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtSubTotal = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Ventas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("FACTURA");

        jLabel2.setFont(new java.awt.Font("Poor Richard", 1, 36)); // NOI18N
        jLabel2.setText("\" JOMASOFT \"");

        jLabel3.setText("Empresa de Desarrollo de Software");

        jLabel4.setText("Desarrollo de Software  Profesional a pequeñas y medianas Empresas");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unsch/ingsistemas/contabilidad/Images/Linux.png"))); // NOI18N

        jLabel5.setText("Informes: ");

        jLabel6.setText("980254113");

        jLabel7.setText("066-3107746");

        jLabel8.setText("josephcand@gmail.com");

        jLabel10.setText("Telefono :");

        jLabel11.setText("E-mail :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("R.U.C.");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("10712653174");

        jLabel14.setBackground(javax.swing.UIManager.getDefaults().getColor("EditorPane.selectionBackground"));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("FACTURA");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("001 - ");

        txtNumeroCorrelativo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNumeroCorrelativo.setText("12");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel12)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumeroCorrelativo)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNumeroCorrelativo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(80, 80, 80)))))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel17.setText("Fecha :");

        jLabel18.setText("Señor (es) :");

        jLabel19.setText("R.U.C. :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cant.", "Descripcion", "Precio Unit.", "Importe"
            }
        ));
        jScrollPane2.setViewportView(jtbFactura);
        if (jtbFactura.getColumnModel().getColumnCount() > 0) {
            jtbFactura.getColumnModel().getColumn(0).setMinWidth(100);
            jtbFactura.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtbFactura.getColumnModel().getColumn(0).setMaxWidth(100);
            jtbFactura.getColumnModel().getColumn(2).setMinWidth(100);
            jtbFactura.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtbFactura.getColumnModel().getColumn(2).setMaxWidth(100);
            jtbFactura.getColumnModel().getColumn(3).setMinWidth(100);
            jtbFactura.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtbFactura.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jLabel20.setText("SON :");

        jLabel21.setText("/00 Soles");

        jLabel22.setText("I.G.V. :");

        jLabel23.setText("SUB - TOTAL  S/. ");

        jLabel24.setText("TOTAL  S/.");

        jButton1.setText("AGREGAR PRODUCTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgvActionPerformed(evt);
            }
        });

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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unsch/ingsistemas/contabilidad/Images/full_page.png"))); // NOI18N
        jButton3.setText("REPORTE");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unsch/ingsistemas/contabilidad/Images/delete.png"))); // NOI18N
        jButton5.setText("SALIR");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel22)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtMostrarNumeroLetra)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel21)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel23))
                                        .addComponent(jLabel24))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                        .addComponent(txtIgv)
                                        .addComponent(txtTotal)))
                                .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txtMostrarNumeroLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel24)))
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        WindowFormProduct n = new WindowFormProduct();
        n.setLocationRelativeTo(null);
        n.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void guardarFactura(String numeroCorrelativo, String fecha, String cliente, String ruc, String subTotal, String igv, String total) {
        try {
            ArrayList<TablaAsiento> reg = new ArrayList();
            ConexionBD con = new ConexionBD();
            String sql = "insert into factura values(NULL,'" + numeroCorrelativo + "','" + fecha + "','" + cliente + "','" + ruc + "','" + subTotal + "','" + igv + "','" + total + "')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            s.close();
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(WindowFormProductAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ActualizarProducto(String producto, int cantidadStock) {

        try {
            ConexionBD con = new ConexionBD();
            Statement s = (Statement) con.getConexion().createStatement();

            PreparedStatement stmt;
            // UPDATE `producto` SET `Nombre` = 'Usb', `Descripcion` = 'Toshiba' WHERE `producto`.`id` = 8;
            // UPDATE `producto` 
            //SET `Nombre` = 'Laptop', `Descripcion` = 'HP', `cantidad_existencia` = '45', `PrecioVenta` = '300', `PrecioCompra` = '250' WHERE `producto`.`id` = 7;
            stmt = con.getConexion().prepareStatement("UPDATE producto SET cantidad_existencia = ? WHERE Nombre=?");
            stmt.setInt(1, cantidadStock);
            stmt.setString(2, producto);
            int retorno = stmt.executeUpdate();
            con.cerrarConexion();

            System.out.println(retorno);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        guardarFactura(txtNumeroCorrelativo.getText(), txtfecha.getText(), txtCliente.getText(), txtruc.getText(), txtSubTotal.getText(), txtIgv.getText(), txtTotal.getText());

        try {
            guardartablaAsientoFactura();
            String ultimoRegistro = obtnerultimoRgtrAsiento() + "";
            ConexionBD con = new ConexionBD();
            String sql = "insert into asiento values(NULL,'" + ultimoRegistro + "','" + txtfecha.getText() + "','" + txtTotal.getText() + "','" + txtTotal.getText() + "','" + " Por la venta de mercaderia con factura " + "','" + txtNumeroCorrelativo.getText() + "')";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        JOptionPane.showMessageDialog(null, "Factura guardada");

        // Recorrer toda la tabla y guaradr cada fila
        int fila = jtbFactura.getRowCount();
        int columna = jtbFactura.getColumnCount();
        int i;
        String cantidad = "";
        String nombre = "";

        String valores = "";
        for (i = 0; i < fila; i++) {
            cantidad = (String) jtbFactura.getValueAt(i, 0);
            nombre = (String) jtbFactura.getValueAt(i, 1);
            //valores = valores + ", " + valor+ valor2;
            String doc = "Factura / N° " + txtNumeroCorrelativo.getText();
            guardarVenta(nombre, cantidad, doc);
            ProductoCrud p = new ProductoCrud();
            Producto pr = p.select2(nombre);
            System.out.println(pr);
            System.out.println(cantidad);
            System.out.println(nombre);
            int cantActual = pr.getCantidad_existencia() - Integer.parseInt(cantidad);
            ActualizarProducto(nombre, cantActual);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // Generar reportes
            JasperReport jr = (JasperReport) JRLoader.loadObject(WindowFormAsiento.class.getResource("/com/unsch/ingsistemas/contabilidad/Reportes/factura.jasper"));
            Map parametro = new HashMap<String, Object>();
            parametro.put("fecha", (String) getFecha());
            parametro.put("numeroDoc", (String) txtNumeroCorrelativo.getText());
            parametro.put("ruc", (String) txtruc.getText());
            parametro.put("nombre", (String) txtCliente.getText());

            parametro.put("total", (String) txtTotal.getText());
            parametro.put("subtotal", (String) txtSubTotal.getText());
            parametro.put("igv", (String) txtIgv.getText());
            parametro.put("pago", (String) txtMostrarNumeroLetra.getText());

            JRTableModelDataSource jrtmd = new JRTableModelDataSource(jtbFactura.getModel());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, jrtmd);
//            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, new JREmptyDataSource());

            JasperViewer jv = new JasperViewer(jp, false);
            jv.show();
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JTable jtbFactura;
    private javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtIgv;
    public static javax.swing.JTextField txtMostrarNumeroLetra;
    private javax.swing.JLabel txtNumeroCorrelativo;
    public static javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtruc;
    // End of variables declaration//GEN-END:variables
}
