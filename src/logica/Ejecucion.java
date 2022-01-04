package logica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import estructuras.*;
import interfaz.Boton;
import interfaz.CampoL;
import interfaz.Contenedor;
import interfaz.Texto;
import interfaz.Ventana;

public class Ejecucion {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		//-------------------------------------------PRUEBAS---------------------------------------------------------
		
		//referencias simples
		
		Cola_ref_simple<Integer> objeto = new Cola_ref_simple<Integer>();
		
		objeto.encolar(1);
		objeto.encolar(2);
		objeto.encolar(3);
		objeto.encolar(4);
		objeto.encolar(5);
		objeto.encolar(6);
		objeto.desencolar();
		
		//objeto.imprimir();
	
		System.out.println();
		
		Pila_ref_simple<String> objeto2 = new Pila_ref_simple<String>();
		
		objeto2.push("hola");
		objeto2.push("cómo");
		objeto2.push("estás");
		objeto2.push("bebé");
		objeto2.pop();
		objeto2.pop();
		
		//objeto2.imprimir();
		
        Lista_ref_simple<Integer> objeto5 = new Lista_ref_simple<Integer>();
		
		objeto5.agregar(1);
		objeto5.agregar(2);
		objeto5.agregar(3);
		objeto5.agregar(4);
		objeto5.agregar(5);
		
		//System.out.print(objeto5.encontrar(0).getDato());
		
		//objeto5.imprimir();
		
		System.out.println();
		
		//arreglos dinamicos
		
		Pila_arreglo_dinamico<Integer> objeto3 = new Pila_arreglo_dinamico<Integer>();
		
		objeto3.push(1);
		objeto3.push(2);
		objeto3.push(3);
		objeto3.push(4);
		objeto3.pop();
		
		//objeto3.imprimir();
		
		System.out.println();
		
        Cola_arreglo_dinamico<String> objeto4 = new Cola_arreglo_dinamico<String>();
		
		objeto4.encolar("eres");
		objeto4.encolar("todo");
		objeto4.encolar("un");
		objeto4.encolar("programador");
		objeto4.desencolar();
	
		
		//objeto4.imprimir();
		
		System.out.println();
		
		Lista_arreglo_dinamico<Integer> objeto6 = new Lista_arreglo_dinamico<Integer>();
		
		objeto6.agregar(1);
		objeto6.agregar(2);
		objeto6.agregar(3);
		objeto6.agregar(4);
		objeto6.eliminar_en(3);
		
		//objeto6.imprimir();
		
		
		//--------------------------------------------INSTANCIACIONES-----------------------------------------------------------
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//--------------------------------------------EJECUCIÓN DE INTERFAZ-----------------------------------------------------------
		
		
		//PLANTILLAS
		/*
		
		//Ventanas emergentes
		
		JOptionPane.showMessageDialog(La_ventana,"mensaje","Título",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(La_ventana,"mensaje","Título",JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(La_ventana,"mensaje","Título",JOptionPane.ERROR_MESSAGE);
		
		if(JOptionPane.showConfirmDialog(contentPane, "Mensaje", "Título", JOptionPane.YES_NO_OPTION) == 0) {
					
			//Lo que hace en caso de "YES"
		}
		
		//Ventana emergente para guardar un usuario o contraseña
		
		String cadena_texto = JOptionPane.showInputDialog(La_ventana,"mesaje");
		
		//Botones
		
		Boton nombre = new Boton("texto del boton", La_ventana, x, y, ancho, largo);
		
		nombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			///////////////////////////////////////////////////////////////////////
						
				//lo que va a hacer el botón
				
			///////////////////////////////////////////////////////////////////////			
			}
		});
		 */
		
		
		//Ejemplo
		
		
		
		Ventana ventana1= new Ventana("Primera ventana");
	    
		
		Texto texto1_ventana3 = new Texto("Esta es la prueba para texto", ventana1, 0, 0, 100, 100);
		
		CampoL campo1 = new CampoL(ventana1, 10, 200, 100, 20);
		
		Boton boton1_ventana1 = new Boton("Siguiente ventana", ventana1, 100, 58, 187, 54);
		
		boton1_ventana1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
            ///////////////////////////////////////////////////////////////////////	
				System.out.println("boton 1");
				
				Ventana ventana2 = new Ventana("Segunda ventana");
				ventana2.setBounds(300,100,300,500);
				ventana1.desactivar();
				
				Boton boton1_ventana2 = new Boton("ventana anterior", ventana2, 50, 58, 187, 54);
				boton1_ventana2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
                    ///////////////////////////////////////////////////////////////////////	
						
						ventana2.desactivar();
						ventana1.activar();
						
                    ///////////////////////////////////////////////////////////////////////	
					}
				});
				
				Boton boton2_ventana2 = new Boton("ventana siguiente", ventana2, 50, 58+100, 187, 54);
				
				boton2_ventana2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
                    ///////////////////////////////////////////////////////////////////////			
						
						Ventana ventana3 =  new Ventana("Tercera ventana");
						ventana3.setBounds(800,100,300,300);
						
						ventana2.desactivar();
						
						//Texto texto1_ventana3 = new Texto("esta es la prueba para texto", ventana3, 0, 0, 187, 54 );
						
						Boton nombre = new Boton("Anterior ventana", ventana3, 50, 58, 187, 54);
						
						nombre.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
                            ///////////////////////////////////////////////////////////////////////	
								
								JOptionPane.showMessageDialog(ventana3,"Vas a volver a la ventana anterior","Alerta",JOptionPane.WARNING_MESSAGE);
								
								ventana2.activar();
								ventana3.desactivar();
								
                            ///////////////////////////////////////////////////////////////////////		
							}
						});
						
						
                    ///////////////////////////////////////////////////////////////////////			
					}
				});
			
            ///////////////////////////////////////////////////////////////////////	
			}
		});
		
		
        Boton boton2_ventana1 = new Boton("contenedor", ventana1, 150, 150, 100, 100);
		
        boton2_ventana1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			///////////////////////////////////////////////////////////////////////
						
				Ventana ventana_general = new Ventana("ventana general",false);
				
				Contenedor contenedor1 = new Contenedor(ventana_general);
				ventana1.desactivar();
				
				Boton boton1_contenedor1 = new Boton("Desactivar contenedor1", contenedor1,100, 100, 100, 100);
				
				boton1_contenedor1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					///////////////////////////////////////////////////////////////////////
							
						System.out.println("funciona");
						
						contenedor1.desactivar();
						Contenedor contenedor2 = new Contenedor(ventana_general);
						
						Boton boton1_contenedor2 = new Boton("anterior contenedor", contenedor2, 100, 200, 100, 100);
						
						boton1_contenedor2.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
							///////////////////////////////////////////////////////////////////////
										
								contenedor2.desactivar();
								contenedor1.activar();
				            				
							///////////////////////////////////////////////////////////////////////			
							}
						});
						
						
						
					///////////////////////////////////////////////////////////////////////			
					}
				});
				
			///////////////////////////////////////////////////////////////////////			
			}
		});
        
        
        /*
         * 
         */
	}

}
