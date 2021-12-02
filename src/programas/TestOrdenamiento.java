/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programas;

import Clase.DatosDesordenados;
import Clase.DatosOrdenados;
import javax.swing.JOptionPane;

public class TestOrdenamiento {
    public static void main(String[] args) {
        
        DatosDesordenados m;
        //DatosOrdenados datosOrd;
        int n, s; 
        long t, t1, t2;
        
        n = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuántos datos son?"));
        s = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuál es el valor máximo?"));
        
         m = new DatosDesordenados(s, n);
        m.generarValores();
        System.out.println("" + m);

        t1 = System.nanoTime();   // start
        DatosOrdenados mob = m.bubbleSort();
        t2 = System.nanoTime();   // stop
        t = t2 - t1;
        
        System.out.println(" \n n= " + n + " t= " + t + " ns. Burbuja= " + mob+"\n" );
        

        t1 = System.nanoTime();   // start
        DatosOrdenados moqs = m.QuickSort();
        t2 = System.nanoTime();   // stop
        t = t2 - t1;
        System.out.println("n=" + n + " t=" + t + " ns. QuickSort=" + moqs+"\n");

        t1 = System.nanoTime();   // start
        DatosOrdenados moss = m.ShellSort();
        t2 = System.nanoTime();   // stop
        t = t2 - t1;
        System.out.println("n=" + n + " t=" + t + " ns. ShellSort=" + moss+"\n");

        t1 = System.nanoTime();   // start
        DatosOrdenados moR = m.Radix();
        t2 = System.nanoTime();   // stop
        t = t2 - t1;
        System.out.println("n=" + n + " t=" + t + " ns. Radix=" + moR+"\n");    }
}
