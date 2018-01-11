/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.ingsistemas.contabilidad.Vistas;

import com.unsch.ingsistemas.contabilidad.Clases.Kardex;
import com.unsch.ingsistemas.contabilidad.Clases.Producto;
import com.unsch.ingsistemas.contabilidad.bd.ConexionBD;
import com.unsch.ingsistemas.contabilidad.bd.ProductoCrud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class formKradex extends javax.swing.JFrame {

    DefaultTableModel modelo;

    public void llenarTablaKardex() {
        modelo = (DefaultTableModel) jtbKardex.getModel();
        modelo.setRowCount(0);
        String[] registro = new String[11];
        // Producto Inicial 
        Producto pi = productoInicial();
        ProductoCrud p = new ProductoCrud();
        Producto pi2 = p.select2(ProductOptionKardex.productoElegido);
        registro[0] = "-------";
        registro[1] = "Inventario Inicial";
        registro[2] = "";
        registro[3] = "";
        registro[4] = "";
        registro[5] = "";
        registro[6] = "";
        registro[7] = "";
        registro[8] = pi.getCantidad_existencia() + "";
        registro[9] = pi.getPrecioCompra() + "";
        double valorTotal = pi.getCantidad_existencia() * pi.getPrecioCompra();
        registro[10] = valorTotal + "";
        modelo.addRow(registro);

        String s = "SELECT * FROM compra WHERE producto='" + ProductOptionKardex.productoElegido + "' UNION ALL SELECT * FROM venta WHERE producto='" + ProductOptionKardex.productoElegido + "' ORDER BY fecha;";

        ConexionBD mysql = new ConexionBD();
        Connection cn = mysql.getConexion();

        ArrayList<Kardex> lista = new ArrayList<>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {
                Kardex aux = new Kardex(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), productoInicial().getPrecioCompra() + "", rs.getString(5), rs.getString(6));
                lista.add(aux);
            }
            System.out.println("\n");
            for (int i = 0; i < lista.size(); i++) {
                Kardex aux = (Kardex) lista.get(i);
                if (aux.getTipo().equalsIgnoreCase("Venta")) {

                    if (i == 0) {

                        registro[0] = aux.getFecha();
                        registro[1] = "Venta " + aux.getDocumento();
                        registro[2] = "";
                        registro[3] = "";
                        registro[4] = "";
                        // Venta = Salida
                        registro[5] = aux.getCantidad();
                        registro[6] = aux.getCosto();
                        double valorTotal2 = Integer.parseInt(aux.getCantidad()) * Double.parseDouble(aux.getCosto());
                        registro[7] = valorTotal2 + "";
                        // ----------
                        int nuevaCantidad = pi.getCantidad_existencia() - Integer.parseInt(aux.getCantidad());
                        registro[8] = nuevaCantidad + "";
                        registro[9] = pi2.getPrecioCompra() + "";
                        registro[10] = valorTotal -valorTotal2+ "";
                        modelo.addRow(registro);

                    } else {
                        Kardex auxAnterior = lista.get(i - 1);
                        System.out.println(auxAnterior);
                        registro[0] = aux.getFecha();
                        registro[1] = "Venta " + aux.getDocumento();
                        registro[2] = "";
                        registro[3] = "";
                        registro[4] = "";
                        // Venta = Salida
                        registro[5] = aux.getCantidad();
                        registro[6] = aux.getCosto();
                        double valorTotal2 = Integer.parseInt(aux.getCantidad()) * Double.parseDouble(aux.getCosto());
                        registro[7] = valorTotal2 + "";
                        // ----------
                        int nuevaCantidad = Integer.parseInt(auxAnterior.getCantidad()) - Integer.parseInt(aux.getCantidad());
                        registro[8] = nuevaCantidad + "";
                        registro[9] = pi2.getPrecioCompra() + "";
                        double v = valorTotal - valorTotal2;
                        registro[10] = v + "";
                        modelo.addRow(registro);
                    }

                } else {
                    if (i == 0) {
                        registro[0] = aux.getFecha();
                        registro[1] = "Compra " + aux.getDocumento();
                        // Compra = Entrada
                        registro[2] = aux.getCantidad();
                        registro[3] = aux.getCosto();
                        double valorTotal2 = Integer.parseInt(aux.getCantidad()) * Double.parseDouble(aux.getCosto());
                        registro[4] = valorTotal2 + "";

                        registro[5] = "";
                        registro[6] = "";
                        registro[7] = "";
                        // ----------
                        int nuevaCantidad = pi.getCantidad_existencia() + Integer.parseInt(aux.getCantidad());
                        registro[8] = nuevaCantidad + "";
                        registro[9] = pi2.getPrecioCompra() + "";
                        registro[10] = valorTotal + valorTotal2+"";
                        modelo.addRow(registro);

                    } else {
                        Kardex auxAnterior = lista.get(i - 1);
                        registro[0] = aux.getFecha();
                        registro[1] = "Compra " + aux.getDocumento();
                        // Compra = Entrada
                        registro[2] = aux.getCantidad();
                        registro[3] = aux.getCosto();
                        double valorTotal2 = Integer.parseInt(aux.getCantidad()) * Double.parseDouble(aux.getCosto());
                        registro[4] = valorTotal2 + "";

                        registro[5] = "";
                        registro[6] = "";
                        registro[7] = "";
                        // ----------
                        int nuevaCantidad = Integer.parseInt(auxAnterior.getCantidad())+ Integer.parseInt(aux.getCantidad());
                        registro[8] = nuevaCantidad + "";
                        registro[9] = pi2.getPrecioCompra() + "";
                        registro[10] = valorTotal +valorTotal2+ "";
                        modelo.addRow(registro);
                    }

                }
            }
            jtbKardex.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public formKradex() {
        initComponents();
        txtPrueba.setText(ProductOptionKardex.productoElegido);
        llenarTablaKardex();
    }

//    Seleccionar inventario inicial
    public Producto productoInicial() {
        ProductoCrud p = new ProductoCrud();
        return p.select(ProductOptionKardex.productoElegido);
    }

    // Lenado de tabla de Kardex
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbKardex = new javax.swing.JTable();
        txtPrueba = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtbKardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fecha", "Detalle", "cantidad", "Valor uni", "Valor Total", "cantidad", "Valor uni", "Valor Total", "cantidad", "Valor uni", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(jtbKardex);

        txtPrueba.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(txtPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(formKradex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formKradex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formKradex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formKradex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formKradex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbKardex;
    private javax.swing.JTextField txtPrueba;
    // End of variables declaration//GEN-END:variables
}
