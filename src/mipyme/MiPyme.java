/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipyme;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.UnsupportedLookAndFeelException;

import vistas.Principal;

import javax.swing.UIManager;

/**
 *
 * @authors Sergio, Andres, Julian, Marco
 */
public class MiPyme {
	
	public static Bills ventas = new Bills();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try {
            
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//ESTA LINEA DA EL ESTILO PARA LOS FORMULARIOS.
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            
           
        }
        Sistema sistema=new Sistema();  //OBJETO DEL FORMULARIO 
        sistema.setExtendedState(MAXIMIZED_BOTH);//PARA ABRIR SIEMPRE EN VENTANA MAXIMIZADA
        sistema.setVisible(true);*/
    	int i =0;
    	long startTime = System.nanoTime();
		while(i<=10) {
			ventas.newBill(String.valueOf(i),"A"+String.valueOf(i), "C"+String.valueOf(i));
			i++;
		}
		long endTime = System.nanoTime()-startTime;
		System.out.println("Agregar "+String.valueOf(i)+" datos "+String.valueOf(endTime));
    	startTime = System.nanoTime();
		ventas.delBill((int) i/2);
		endTime = System.nanoTime()-startTime;
		System.out.println("Borrar el "+String.valueOf((int)i/2)+"avo elemento "+String.valueOf(endTime));
		startTime = System.nanoTime();
		ventas.delBill(i);
		endTime = System.nanoTime()-startTime;
		System.out.println("Borrar el "+String.valueOf(i)+"avo elemento "+String.valueOf(endTime));
    	Principal frame = new Principal();
		frame.setVisible(true);
    }
    
}
