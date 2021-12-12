/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipyme;
import static java.awt.Frame.MAXIMIZED_BOTH;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UnsupportedLookAndFeelException;

import vistas.Principal;
import vistas.Venta;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @authors Marco, Andres, Juan Mayorga, Nicolas Parra
 */
public class MiPyme {
	
	public static Bills ventas = new Bills();
	public static Users Usuarios = new Users();
	public static Cola pedidos = new Cola();
	public static JFrame ventana = new JFrame();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	Usuarios.addUser("Juan", "juan123");
    	Usuarios.addUser("Marco", "marco123");
    	Usuarios.addUser("Andres", "andres123");
    	Usuarios.addUser("Nicolas", "nicolas123");
    	
    	/*
        try {
            
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//ESTA LINEA DA EL ESTILO PARA LOS FORMULARIOS.
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            
           
        }
        /*
        Sistema sistema=new Sistema();  //OBJETO DEL FORMULARIO 
        sistema.setExtendedState(MAXIMIZED_BOTH);//PARA ABRIR SIEMPRE EN VENTANA MAXIMIZADA
        sistema.setVisible(true);
    	/*
    	long startTime = System.nanoTime();
    	int i = 0;
    	while(i<=10000) {
    		ventas.newBill("U"+String.valueOf(i), "C"+String.valueOf(i),"P"+String.valueOf(i));
    	}
    	long finishTime = System.nanoTime()-startTime;
    	System.out.print("Agregar "+i+" usuarios: "+finishTime);
    	/*
    	startTime = System.nanoTime();
    	Usuarios.findById(i);
    	finishTime = System.nanoTime()-startTime;
    	System.out.print("Busacar el usuario "+i+": "+finishTime);
    	startTime = System.nanoTime();
    	Usuarios.delUserById((int)i/2);;
    	finishTime = System.nanoTime()-startTime;
    	System.out.print("Busacar el usuario "+(int)i/2+": "+finishTime);*/
    	
    	
    	JFrame ventana2= new JFrame("Tienda Don Pedro");
		JPanel contenedor= new JPanel(null);
		JPanel contenedor2= new JPanel(null);
		
		JLabel bienvenida = new JLabel("<html>Bienvenido a la tienda Don Pedro<br><br>Los mejores precios del mercado</html>");
		bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bienvenida.setBounds(10, 11, 404, 100);
		
		JButton boton1 = new JButton("Administrador");
		boton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("boton numero uno");
				
				String usuario2 = "";
				String contrasena2 = "";
				usuario2 = (String) JOptionPane.showInputDialog(ventana,"Ingrese su usuario");
				
				if(usuario2!=null) {
				contrasena2 = (String) JOptionPane.showInputDialog(ventana,"Ingrese su contrasena");
				
				if(contrasena2!=null) {
				if((usuario2 != null && contrasena2 != null) && (contrasena2.length()==0||usuario2.length()==0)) {
					JOptionPane.showMessageDialog(ventana,"No deje campo vacio","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					//MiPyme.Usuarios.addUser(usuario2, contrasena2);
					
					if(Usuarios.verificarUsuarioYcontra(usuario2, contrasena2)) {
					
					JOptionPane.showMessageDialog(ventana,"Usuario existente","Exitoso",JOptionPane.INFORMATION_MESSAGE);
					
					Principal frame = new Principal(ventana);
					frame.setVisible(true);
					ventana.dispose();
					}else {
						
						JOptionPane.showMessageDialog(ventana,"Usuario no existente","Error",JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
				}
				}
			}
		});
		boton1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		JButton boton2 = new JButton("Hacer una compra");
		boton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JLabel textoNombre = new JLabel("Nombre:");
				textoNombre.setBounds(20,20,100,50);
				
				JTextField campo1 = new JTextField();
				campo1.setBounds(20,60,200,25);
				
				JLabel textoNumero = new JLabel("Número de celular:");
				textoNumero.setBounds(20,20+70,150,50);
				
				JTextField campo2 = new JTextField();
				campo2.setBounds(20,60+70,200,25);
				
				JLabel textoPedido = new JLabel("Pedido:");
				textoPedido.setBounds(20,20+70*2,100,50);
				
				JTextArea campo3 = new JTextArea();
				campo3.setBounds(20,60+70*2,300,70);
				
				
				JButton boton3 = new JButton("Atrás");
				boton3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						campo1.setText(null);
						campo2.setText(null);
						campo3.setText(null);
						
						ventana2.dispose();
						ventana.setVisible(true);
					
					}
				});
				boton3.setFont(new Font("Tahoma", Font.BOLD, 11));
				
				JButton boton4 = new JButton("Enviar");
				boton4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						pedidos.encolar(new Pedido(campo1.getText(),campo2.getText(),campo3.getText()));
						
						JOptionPane.showMessageDialog(ventana,"Tu pedido fue enviado con éxito","Exitoso",JOptionPane.INFORMATION_MESSAGE);
						
						campo1.setText(null);
						campo2.setText(null);
						campo3.setText(null);
						
						ventana2.dispose();
						ventana.setVisible(true);
					
					}
				});
				boton4.setFont(new Font("Tahoma", Font.BOLD, 11));
				
				boton3.setBounds(50,300,100,50);
				boton4.setBounds(270,300,100,50);
				
				contenedor2.add(textoNombre);
				contenedor2.add(textoNumero);
				contenedor2.add(textoPedido);
				contenedor2.add(campo1);
				contenedor2.add(campo2);
				contenedor2.add(campo3);
				contenedor2.add(boton3);
				contenedor2.add(boton4);
				ventana2.add(contenedor2);
				ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventana2.pack();
				ventana2.setSize(450,400);
				ventana2.setVisible(true);
				ventana.dispose();
			}
		});
		boton2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		boton1.setBounds(50,150,150,70);
		boton2.setBounds(250,150,150,70);
		
		contenedor.add(boton1);
		contenedor.add(boton2);
		contenedor.add(bienvenida);
		ventana.add(contenedor);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setSize(450,400);
		ventana.setVisible(true);
    }
    
}
