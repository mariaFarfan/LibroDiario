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
        String CANTIDADNUEVA = pi.getCantidad_existencia() + "";
        String VALORTOTAL = pi.getCantidad_existencia() * pi.getPrecioCompra() + "";
        String VALORUNITARIO = pi.getPrecioCompra() + "";
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
        registro[10] = VALORTOTAL + "";
        modelo.addRow(registro);

        String s = "SELECT * FROM compra WHERE producto='" + ProductOptionKardex.productoElegido + "' UNION ALL SELECT * FROM venta WHERE producto='" + ProductOptionKardex.productoElegido + "' ORDER BY fecha desc;";

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
                        registro[6] = VALORUNITARIO;
                        double valorTotal2 = Integer.parseInt(aux.getCantidad()) * Double.parseDouble(aux.getCosto());
                        registro[7] = valorTotal2 + "";
                        // ----------
                        int nuevaCantidad = pi.getCantidad_existencia() - Integer.parseInt(aux.getCantidad());

                        CANTIDADNUEVA = nuevaCantidad + "";
                        registro[8] = CANTIDADNUEVA;
                        // VALOR TOTAL ANTERIO + Valor TOtal Actual / CantidaNueva
                        double valorUnitario = (Double.parseDouble(VALORTOTAL) + valorTotal2) / Double.parseDouble(CANTIDADNUEVA);
                        VALORUNITARIO = valorUnitario + "";
                        registro[9] = VALORUNITARIO + "";
                        double VALORTOTALaux = Double.parseDouble(VALORUNITARIO) * Integer.parseInt(CANTIDADNUEVA);
                        VALORTOTAL = VALORTOTALaux + "";
                        registro[10] = VALORTOTAL + "";
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
                        registro[6] = VALORUNITARIO;
                        double valorTotal2 = Integer.parseInt(aux.getCantidad()) * Double.parseDouble(aux.getCosto());
                        registro[7] = valorTotal2 + "";
                        // ----------
                        int nuevaCantidad = Integer.parseInt(CANTIDADNUEVA) - Integer.parseInt(aux.getCantidad());
                        CANTIDADNUEVA = nuevaCantidad + "";
                        registro[8] = CANTIDADNUEVA;// VALOR TOTAL ANTERIO + Valor TOtal Actual / CantidaNueva
                        double valorUnitario = (Double.parseDouble(VALORTOTAL) + valorTotal2) / Double.parseDouble(CANTIDADNUEVA);
                        VALORUNITARIO = valorUnitario + "";
                        registro[9] = VALORUNITARIO + "";
                        double VALORTOTALaux = Double.parseDouble(VALORUNITARIO) * Integer.parseInt(CANTIDADNUEVA);
                        VALORTOTAL = VALORTOTALaux + "";
                        registro[10] = VALORTOTAL + "";
                        modelo.addRow(registro);
                    }

                } else {
                    if (i == 0) {
                        registro[0] = aux.getFecha();
                        registro[1] = "Compra " + aux.getDocumento();
                        // Compra = Entrada
                        registro[2] = aux.getCantidad();
                        registro[3] = VALORUNITARIO;
                        double valorTotal2 = Integer.parseInt(aux.getCantidad()) * Double.parseDouble(aux.getCosto());
                        registro[4] = valorTotal2 + "";

                        registro[5] = "";
                        registro[6] = "";
                        registro[7] = "";
                        // ----------
                        int nuevaCantidad = Integer.parseInt(CANTIDADNUEVA) + Integer.parseInt(aux.getCantidad());
                        CANTIDADNUEVA = nuevaCantidad + "";
                        registro[8] = CANTIDADNUEVA;
                        // VALOR TOTAL ANTERIO + Valor TOtal Actual / CantidaNueva
                        double valorUnitario = (Double.parseDouble(VALORTOTAL) + valorTotal2) / Double.parseDouble(CANTIDADNUEVA);
                        VALORUNITARIO = valorUnitario + "";
                        registro[9] = VALORUNITARIO + "";
                        double VALORTOTALaux = Double.parseDouble(VALORUNITARIO) * Integer.parseInt(CANTIDADNUEVA);
                        VALORTOTAL = VALORTOTALaux + "";
                        registro[10] = VALORTOTAL;
                        modelo.addRow(registro);

                    } else {
                        int nuevaCantidad = Integer.parseInt(CANTIDADNUEVA) + Integer.parseInt(aux.getCantidad());
                        CANTIDADNUEVA = nuevaCantidad + "";
                        Kardex auxAnterior = lista.get(i - 1);
                        registro[0] = aux.getFecha();
                        registro[1] = "Compra " + aux.getDocumento();
                        // Compra = Entrada
                        registro[2] = aux.getCantidad();
                        registro[3] = VALORUNITARIO;
                        double valorTotal2 = Integer.parseInt(aux.getCantidad()) * Double.parseDouble(aux.getCosto());
                        registro[4] = valorTotal2 + "";

                        registro[5] = "";
                        registro[6] = "";
                        registro[7] = "";
                        // ----------
                        registro[8] = CANTIDADNUEVA + "";
                        double valorUnitario = (Double.parseDouble(VALORTOTAL) + valorTotal2) / Double.parseDouble(CANTIDADNUEVA);
                        VALORUNITARIO = valorUnitario + "";
                        registro[9] = VALORUNITARIO;
                        double VALORTOTALaux = Double.parseDouble(VALORUNITARIO) * Integer.parseInt(CANTIDADNUEVA);
                        VALORTOTAL = VALORTOTALaux + "";
                        registro[10] = VALORTOTAL;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtPrueba = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtbKardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fecha", "Detalle", "cantidad", "Valor uni", "Valor Total", "cantidad", "Valor uni", "Valor Total", "cantidad", "Valor uni", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(jtbKardex);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENTRADAS");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SALIDAS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setBackground(javax.swing.UIManager.getDefaults().getColor("tab_attention_fill_lower"));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("EXISTENCIAS");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS"));

        jLabel4.setText("Nombre Empresa :");

        txtPrueba.setEditable(false);
        txtPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPruebaActionPerformed(evt);
            }
        });

        jLabel5.setText("Articulo :");

        jTextField1.setEditable(false);
        jTextField1.setText("XXXXX- XXXXX SAC");

        jLabel6.setText("Unidad de medida:");

        jTextField2.setEditable(false);
        jTextField2.setText("UNIDAD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(txtPrueba))))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tauri", 0, 60)); // NOI18N
        jLabel7.setText("KARDEX");

        jLabel8.setText(" Método Promedio Ponderado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPruebaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPruebaActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable jtbKardex;
    private javax.swing.JTextField txtPrueba;
    // End of variables declaration//GEN-END:variables
}
