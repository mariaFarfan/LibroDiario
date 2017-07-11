/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn;

/**
 *
 * @author USUARIO
 */
public class main {

    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    public static void main(String[] args) {
        double num = 125.36;
        int p_ent = (int) num;
        double p_dec = num - p_ent;

        n2t numero = new n2t();
        int decimales = (int) redondearDecimales(p_dec*100, 3);
        
        String res = numero.convertirLetras(p_ent) + " con " + numero.convertirLetras(decimales) + " /00 soles";
        System.out.println(res);
    }
}
