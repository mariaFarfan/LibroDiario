/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.ingsistemas.contabilidad.Vistas;

import com.unsch.ingsistemas.contabilidad.Clases.TablaAsiento;
import com.unsch.ingsistemas.contabilidad.bd.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class product extends javax.swing.JFrame {

    public static String stock = "";
    DefaultTableModel modelo;

    public void llenarTabla() {
        modelo = (DefaultTableModel) jtbProducto.getModel();
        modelo.setRowCount(0);
        String[] registro = new String[4];
        //String s = "select concat(idcategoria, ' - ',iddisco) as codigo, tipoDisco, nombreDisco, cantidadDisponible from disco";
        String s = "select nombre, descripcion,PrecioCompra,cantidad_existencia from producto;";
        ConexionBD mysql = new ConexionBD();
        Connection cn = mysql.getConexion();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                modelo.addRow(registro);
            }
            jtbProducto.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        System.out.println("lleno tabla ok");
    }

    public void guardarProducto(String nombre, String Descripcion, int canidadExistencia, double precioVenta, double precioCompra) {
        try {
            ArrayList<TablaAsiento> reg = new ArrayList();
            ConexionBD con = new ConexionBD();
            String sql = "insert into producto values(NULL,'" + nombre + "','" + Descripcion + "'," + canidadExistencia + "," + precioVenta + "," + precioCompra + ")";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(WindowFormProductAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarProductoInicial(String nombre, String Descripcion, int canidadExistencia, double precioVenta, double precioCompra) {
        try {
            ArrayList<TablaAsiento> reg = new ArrayList();
            ConexionBD con = new ConexionBD();
            String sql = "insert into productoinicial values(NULL,'" + nombre + "','" + Descripcion + "'," + canidadExistencia + "," + precioVenta + "," + precioCompra + ")";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(WindowFormProductAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ActualizarProducto(String producto, String descripcion, int cantidadStock, double precioVenta, double precioCompra) {

        try {
            ConexionBD con = new ConexionBD();
            Statement s = (Statement) con.getConexion().createStatement();

            PreparedStatement stmt;
            // UPDATE `producto` SET `Nombre` = 'Usb', `Descripcion` = 'Toshiba' WHERE `producto`.`id` = 8;
            // UPDATE `producto` 
            //SET `Nombre` = 'Laptop', `Descripcion` = 'HP', `cantidad_existencia` = '45', `PrecioVenta` = '300', `PrecioCompra` = '250' WHERE `producto`.`id` = 7;
            stmt = con.getConexion().prepareStatement("UPDATE producto SET Descripcion = ?, cantidad_existencia = ?, PrecioVenta =?, PrecioCompra = ?  WHERE Nombre=?");
            stmt.setString(1, descripcion);
            stmt.setInt(2, cantidadStock);
            stmt.setDouble(3, precioVenta);
            stmt.setDouble(4, precioCompra);
            stmt.setString(5, producto);
            int retorno = stmt.executeUpdate();
            con.cerrarConexion();

            System.out.println(retorno);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getFecha() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-dd-MM");
        return formateador.format(ahora);
    }

    public void guardarCompra(String nombre, String cantidad, String documento) {
        try {
            ArrayList<TablaAsiento> reg = new ArrayList();
            ConexionBD con = new ConexionBD();
            // INSERT INTO `compra` VALUES ('', '12/12/12', 'USB', '23');
            String sql = "insert into compra values(NULL,'" + getFecha() + "','" + nombre + "','" + cantidad + "','" + documento + "','COMPRA')";

            //String sql = "insert into compra values(NULL,'"+getFecha()+"','" + nombre + "'," + cantidad + ")";
            Statement s = (Statement) con.getConexion().createStatement();
            s.executeUpdate(sql);
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(WindowFormProductAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form NewJFrame
     */
    public product() {
        initComponents();
        llenarTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProducto = new javax.swing.JTable();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });

        jLabel1.setText("Producto");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Cantidad");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jtbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Stock"
            }
        ));
        jScrollPane1.setViewportView(jtbProducto);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel3.setText("Costo");

        jLabel4.setText("Descripcion");

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("SALIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPrecio)
                                        .addComponent(txtCantidad)
                                        .addComponent(txtProducto))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        WindowFormFindProduct v = new WindowFormFindProduct();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String documento = "";
        // Guardar en la tabla Compra
        if (WindowFormCompras.txtnumeroD1.getText().equalsIgnoreCase("")) {
            documento = "Boleta / N° " + WindowFormCompras.txtnumeroD2.getText();
        } else {
            documento = "Factura / N° " + WindowFormCompras.txtnumeroD1.getText();

        }
        if (stock.equalsIgnoreCase("")) {
            // Agregar Producto
            // String nombre, String Descripcion, int canidadExistencia, double precioVenta, double precioCompra
            guardarProducto(txtProducto.getText(), txtDescripcion.getText(), Integer.parseInt(txtCantidad.getText()),
                    Double.parseDouble(txtPrecio.getText()) * 0.20 + Double.parseDouble(txtPrecio.getText()), Double.parseDouble(txtPrecio.getText()));
            guardarProductoInicial(txtProducto.getText(), txtDescripcion.getText(), Integer.parseInt(txtCantidad.getText()),
                    Double.parseDouble(txtPrecio.getText()) * 0.20 + Double.parseDouble(txtPrecio.getText()), Double.parseDouble(txtPrecio.getText()));
            llenarTabla();

        } else {
            // Actualizar
            //  producto,String descripcion, int cantidadStock, double  precioVenta, double precioCompra  
            ActualizarProducto(txtProducto.getText(), txtDescripcion.getText(), Integer.parseInt(txtCantidad.getText()) + Integer.parseInt(stock), Double.parseDouble(txtPrecio.getText()) * 0.20 + Double.parseDouble(txtPrecio.getText()), Double.parseDouble(txtPrecio.getText()));
            llenarTabla();
            stock = "";
            guardarCompra(txtProducto.getText(), txtCantidad.getText(), documento);

        }

        JOptionPane.showMessageDialog(null, "Actualizado :) ");
        llenarTabla();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        JOptionPane.showMessageDialog(null, "Compra guardada");
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbProducto;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextArea txtDescripcion;
    public static javax.swing.JTextField txtPrecio;
    public static javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
