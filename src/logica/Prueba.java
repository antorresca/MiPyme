package logica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import datos.Carrito;
import datos.Producto;
import datos.Usuario;
import interfaz.*;

public class Prueba implements ActionListener{
	
	private static JTextField textoUsuario;
	private static JTextField textoPassword;
	private static Ventana pantallaMenu;
	private static Ventana pantallaInicio;
	private static Ventana pantallaRegistro;
	private static JLabel bienvenida;
	private static JTextField registroUsuario;
	private static JTextField registroContrasena;
	private static JLabel LabelSuccess;
	private static JLabel NombreUsuario;
	private static String registroUsuariotxt;
	private static String registroPasswordtxt;

	
	
	private static int i; //contador de productos en carrito
	private static long precio = 0 ; //variable para precio total de los productos	
	
	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) throws IOException {
		///////////////////////////////////////////////////////////////////////
		
		/*
		 * Instancia de elementos de prueba
		 */
		
		Usuario user1 = new Usuario("Andres","12345");
		Carrito carro1 = new Carrito(user1);
		for(int i = 0; i<100;i++) {
			carro1.agregar(new Producto(String.valueOf(i),"P"+String.valueOf(i),"Este producto es..."+String.valueOf(i),(long) (Math.random()*10000),null,2));
		}
		
		
		Color ModoClaro = new Color(225,237,249); //Variable de colores (claro y oscuro)
		Color ModoOscuro = new Color(20,31,59);
		Icon LogoClaro_ = new ImageIcon("Img\\LogoOscuro.png");
		File archivo = new File("Img\\LogoOscuro.png");
		System.out.println(archivo.exists());
		ImageIcon Imagen1 = new ImageIcon("Img\\LogoOscuro.png");
		///////////////////////////////////////////////////////////////////////
		
		/*
		 * Pantalla Inicio
		 */
		
		pantallaInicio = new Ventana("MiPYME");
		pantallaInicio.activar();
		pantallaInicio.getContenedor().setBackground(ModoClaro);
		
		
		Imagen1.setImage(Imagen1.getImage().getScaledInstance(190,135,Image.SCALE_DEFAULT));
		bienvenida = new JLabel(Imagen1);	
		bienvenida.setBounds(140, 0, 200, 160);
		pantallaInicio.getContenedor().add(bienvenida);
		
		
		
		JLabel userLabel = new JLabel("Usuario", SwingConstants.CENTER);
		userLabel.setBounds(110, 165, 90, 35);
		pantallaInicio.getContenedor().add(userLabel);
		
		textoUsuario = new JTextField(20);
		textoUsuario.setBounds(185,170,165,25);
		pantallaInicio.getContenedor().add(textoUsuario);
		pantallaInicio.getContenedor().setVisible(false);
		pantallaInicio.getContenedor().setVisible(true);
		
		JLabel passwordLabel = new JLabel("Contraseña");
		passwordLabel.setBounds(110, 185, 90, 35);
		pantallaInicio.getContenedor().add(passwordLabel);
		
		textoPassword = new JTextField(20);
		textoPassword.setBounds(185, 190, 165, 25);
		pantallaInicio.getContenedor().add(textoPassword);
		
		pantallaInicio.add(new JLabel(new ImageIcon("")));
		
		
		/*
		 * Botones Inicio
		 */
		
		Boton btningreso = new Boton("Ingresar", pantallaInicio, 130, 230, 100, 25);
		btningreso.addActionListener(new Prueba());
		
		Boton btnregistro = new Boton("Registrarme", pantallaInicio, 255, 230, 100, 25);
		btnregistro.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				pantallaInicio.setVisible(false);
				pantallaRegistro.setVisible(true);
					
			}
			
		});
		
		
		/*
		 * Pantalla Registro
		 */
		
		pantallaRegistro = new Ventana("MiPYME - Registro");
		pantallaRegistro.activar();
		pantallaRegistro.getContenedor().setBackground(ModoClaro);
		pantallaRegistro.setVisible(false);
		
		registroUsuario = new JTextField(20);
		registroUsuario.setBounds(225,120,165,25);
		pantallaRegistro.getContenedor().add(registroUsuario);
		
		registroContrasena = new JTextField(20);
		registroContrasena.setBounds(225,150,165,25);
		pantallaRegistro.getContenedor().add(registroContrasena);
		
		JLabel LabelRegistroU = new JLabel("Escriba su usuario");
		LabelRegistroU.setBounds(90, 115, 130, 35);
		pantallaRegistro.getContenedor().add(LabelRegistroU);
		
		JLabel LabelRegistroC = new JLabel("Escriba su contraseña");
		LabelRegistroC.setBounds(80, 145, 150, 35);
		pantallaRegistro.getContenedor().add(LabelRegistroC);
		
		LabelSuccess = new JLabel("", SwingConstants.CENTER);
		LabelSuccess.setBounds(90, 245, 300, 35);
		pantallaRegistro.getContenedor().add(LabelSuccess);
		
		
		/*
		 * Botones Registro
		 */
		
		
		Boton BtnRegistrar = new Boton("Registrarme", pantallaRegistro, 255, 200, 100, 25);
		BtnRegistrar.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				String registroUsuariotxt = registroUsuario.getText();
				String registroPasswordtxt = registroContrasena.getText();
				
				if (registroPasswordtxt.equals("") && registroUsuariotxt.equals("")) {
					
					LabelSuccess.setText("Por favor, llene los espacios en blanco");
					
				}
				
				
				else if(registroUsuariotxt.equals("")) {
					
					LabelSuccess.setText("Por favor ingrese su usuario");
					
				}
				
				else if (registroPasswordtxt.equals("")) {
					
					LabelSuccess.setText("Ingrese la contraseña");
					
				}
				
				else if(!"".equals(registroUsuariotxt) && !"".equals(registroPasswordtxt)) {
					
					pantallaRegistro.setVisible(false);
					pantallaMenu.setVisible(true);
					
				}
					
			}
			
		});
		
		
		Boton BtnVolver = new Boton("Volver", pantallaRegistro, 130, 200, 100, 25);
		BtnVolver.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				pantallaRegistro.setVisible(false);
				pantallaInicio.setVisible(true);
					
			}
			
		});
		
		
		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////
		
		/*
		 * Pantalla Menú
		 */
		
		pantallaMenu = new Ventana("Menu"); 
		pantallaMenu.activar();
		pantallaMenu.getContenedor().setBackground(new Color(225,237,249)); //Seleccion color fondo (por defecto color tema claro)
		pantallaMenu.setVisible(false);
		
		/*
		 * Logos de la aplicación
		 */
		
		Imagen logoAppClaro = new Imagen("src\\Img\\LogoClaro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo claro
		Imagen logoAppOscuro = new Imagen("src\\Img\\LogoOscuro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo Oscuro
		logoAppOscuro.setVisible(false);
		
		/*
		 * Botones del menu
		 */
		
		Boton BtnCerrarSesion = new Boton("Cerrar Sesión", pantallaMenu, 130, 240, 200, 50);
		BtnCerrarSesion.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				pantallaMenu.setVisible(false);
				pantallaInicio.setVisible(true);
					
			}
			
		});
		
		NombreUsuario = new JLabel("Bienvenido, " + registroUsuariotxt);
		NombreUsuario.setBounds(30, 10, 150,30);
		pantallaMenu.getContenedor().add(NombreUsuario);
		
		Boton btnCarrito = new Boton("Carrito",pantallaMenu,38,71,98,74);
		ImageIcon carritoIcon =  new ImageIcon("Img\\CarritoClaro.png"); //LAs rutas relativas no estan sirviendo
		Icon iconCarrito = new ImageIcon(carritoIcon.getImage().getScaledInstance(
				btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btnCarrito.setIcon(iconCarrito);
		btnCarrito.setToolTipText("Carrito\r\n");
		btnCarrito.setBackground(null);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setOpaque(false);
		
		Boton btn2 = new Boton("Opcion 2",pantallaMenu,38,156,98,74);
		
		Boton btn3 = new Boton("Opcion 3",pantallaMenu,146,71,98,74);
		
		Boton btn4 = new Boton("Opcion 4",pantallaMenu,146,156,98,74);
		
		Boton btn5 = new Boton("Opcion 5",pantallaMenu,254,71,98,74);
		
		Boton btn6 = new Boton("Opcion 6",pantallaMenu,254,156,98,74);
		
		JToggleButton btnTema = new JToggleButton("CLARO"); //Botón de seleccion de tema
		btnTema.setBounds(374, 11, 80, 80);
		ImageIcon claro = new ImageIcon("Img\\ModoClaro.png");
		Icon iconClaro = new ImageIcon(claro.getImage().getScaledInstance(btnTema.getWidth()/2,btnTema.getHeight()/2, Image.SCALE_DEFAULT));
		ImageIcon oscuro = new ImageIcon("Img\\ModoOscuro.png");
		Icon iconOscuro = new ImageIcon(oscuro.getImage().getScaledInstance(btnTema.getWidth()/2,btnTema.getHeight()/2, Image.SCALE_DEFAULT));
		btnTema.setIcon(iconClaro);
		btnTema.setBackground(null);
		btnTema.setBorderPainted(false);
		btnTema.setContentAreaFilled(false);
		btnTema.setOpaque(false);
		pantallaMenu.getContenedor().add(btnTema);
		
		/*
		 * Eventos en botones
		 */
		
		btnCarrito.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				Ventana Carrito = new Ventana("Carrito"); //Ventana del carrito
				Carrito.getContenedor().setBackground(pantallaMenu.getContenedor().getBackground());
				pantallaMenu.desactivar();
				/*
				 * Elementos de la ventana
				 */
				
				Boton detalles = new Boton("Detalles",Carrito,319, 139, 89, 23);
				
				Boton pago = new Boton("Pago",Carrito,319, 173, 89, 23);
				
				Boton regresar = new Boton("Regresar",Carrito,319, 207, 89, 23);
				
				DefaultListModel modelo = new DefaultListModel();
				
				/*
				 * Elemento de prueba
				 */
				
				for(i=0; i<carro1.obtenerProductos().getTamano();i++) { //Creacion de datos random para pruebas
					modelo.addElement(carro1.obtenerProductos().encontrar(i).getDato().imprimir());
					precio += carro1.obtenerProductos().encontrar(i).getDato().getPre();
				}
				
				///////////////////////////////////////
				
				JList list = new JList();
				list.setModel(modelo);
				
				JScrollPane scroll = new JScrollPane(list);
				scroll.setBounds(76, 41, 233, 189);
				Carrito.getContenedor().add(scroll);
				
				Texto cabecera = new Texto("Producto  |  Precio",Carrito,76, 68, 233, 14);
				
				Texto totalCarrito = new Texto("TOTAL",Carrito,319, 118, 46, 14);
				
				Texto productosCarrito = new Texto("No. Productos",Carrito,319, 68, 89, 14);
				
				Texto pagoCarrito = new Texto(String.valueOf(precio),Carrito,319, 143, 76, 23); //Muestra precio total de productos
				
				Texto prodCarrito = new Texto(String.valueOf(i),Carrito,319, 93, 46, 14); //Muestra cantidad de productos
				
				/*
				 * Eventos de botones y elementos
				 */
				
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount()==2) { //Saber si se dio doble clic sobre elemento
							
							String producto = list.getSelectedValue().toString().split(" | ")[0]; //Obtener nombre del producto
							
							if(JOptionPane.showConfirmDialog(Carrito, "Eliminar "+producto+ "?",
									"Elimacion completada", JOptionPane.YES_NO_OPTION) == 0) { //Mensaje de dialogo para eliminar productos
								
								/*
								 * Actualizacion de variables globales
								 */
								
								precio -= carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getPre(); 
								
								i -= 1;
								
								carro1.obtenerProductos().eliminar_en(list.getSelectedIndex()); //Eliminacion de productos del objeto
								
								modelo.removeElementAt(list.getSelectedIndex()); //Eliminacion de producto en lista
								
								pagoCarrito.setText(String.valueOf(precio)); //Actualizar informacion mostrada
								prodCarrito.setText(String.valueOf(i)); //""
								
								JOptionPane.showMessageDialog(Carrito,"Producto eliminado",
										"Elimacion completada",JOptionPane.INFORMATION_MESSAGE);	//Mensaje informativo						
								
							}/*else {
								if(e.getClickCount()==1) { 
									Ventana detalles = new Ventana("Detalles");
									Imagen imgProducto = new Imagen("C:\\\\Users\\\\Andres\\\\eclipse-workspace\\\\MiPyme2\\\\src\\\\Img\\\\shopping-cart (4).png"
											,detalles,0,40,detalles.getWidth()/10,detalles.getHeight()/10);
									Carrito.desactivar();
									detalles.activar();
								}
							}*/
						}
					}
				});
				
				detalles.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(list.getSelectedValue() != null) { //Saber si hay seleccionado algun elemento en lista
						Ventana detalles = new Ventana("Detalles"); //Ventada de detalles de producto
						Carrito.desactivar();
						detalles.activar();
						
						/*
						 * Elementos de ventana
						 */
						
						Imagen imgProducto = new Imagen("Img\\shopping-cart (4).png"
								,detalles,0,40,345-detalles.getWidth()/2,detalles.getHeight()/2); //Imagen de prueba
						
						String nombre = carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getNo(); //Nombre de producto
						Texto nombrePro = new Texto(nombre, detalles,0,40+imgProducto.getHeight(),detalles.getWidth(),15);
						
						String descripcion = carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getDes(); //Descripcion de producto
						Texto desPro = new Texto(descripcion, detalles,0,40+imgProducto.getHeight()+15,detalles.getWidth(),15);
						
						String precioP = String.valueOf(carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getPre()); //Precio de producto
						Texto prePro = new Texto(precioP, detalles,0,40+imgProducto.getHeight()+30,detalles.getWidth(),15);
						
						Boton regresar = new Boton("Regresar",detalles,80,210, 89, 23);
						Boton elimarPro = new Boton("Eliminar Producto",detalles,182,210, 150, 23);
						
						/*
						 * Evento de botones
						 */
						
						regresar.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								detalles.desactivar();
								Carrito.activar();
							}
						});
						
						elimarPro.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							String producto = list.getSelectedValue().toString().split(" | ")[0]; //Nombre del producto
							
							if(JOptionPane.showConfirmDialog(Carrito, "Eliminar "+
									producto+ "?", "Elimacion completada", JOptionPane.YES_NO_OPTION) == 0) { //Eliminacion de producto
								/*
								 * Actualizacion de variables globales
								 */
								
								precio -= carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getPre();
								i -= 1;
								carro1.obtenerProductos().eliminar_en(list.getSelectedIndex());
								
								modelo.removeElementAt(list.getSelectedIndex());	
								
								pagoCarrito.setText(String.valueOf(precio));
								
								prodCarrito.setText(String.valueOf(i));
								
								JOptionPane.showMessageDialog(Carrito,"Producto eliminado",
										"Elimacion completada",JOptionPane.INFORMATION_MESSAGE); //Mensaje informativo
								
								detalles.desactivar(); //Salida de ventana
								Carrito.activar();
							}}});
						
						
					}else {
						JOptionPane.showMessageDialog(Carrito,"Por favor elija un producto",
								"Error",JOptionPane.ERROR_MESSAGE); //Mensaje de error
					}
				}});

				
				regresar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
					@Override
					public void mouseClicked(MouseEvent e) {
						Carrito.desactivar(); 
						pantallaMenu.activar();
					}
				});
				
				pago.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
					@Override
					public void mouseClicked(MouseEvent e) {
						Ventana Factura = new Ventana("Factura");
						Carrito.desactivar();
						Factura.setBounds(100, 100, 268, 534);
						Boton regresar = new Boton("Regresar",Factura,10, 17, 89, 23);
						Texto Titulo = new Texto("Mi Pyme",Factura,0, 102, 252, 25);
						Titulo.setHorizontalAlignment(SwingConstants.CENTER);
						Titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
						Texto encabezado = new Texto("Factura de compra",Factura,0, 126, 252, 14);
						encabezado.setHorizontalAlignment(SwingConstants.CENTER);
						Texto lblNewLabel_2 = new Texto("------------------------------------------------",Factura,0, 147, 252, 14);
						JList list = new JList();
						list.setEnabled(false);
						list.setModel(modelo);
						JScrollPane LaFactura = new JScrollPane(list);
						LaFactura.setBounds(0, 139, 252, 285);
						Factura.getContenedor().add(LaFactura);
						Texto lblNewLabel_2_1 = new Texto("----------------------------------------------",Factura,0, 462, 252, 14);
						Texto lblNewLabel_3 = new Texto("Total a Pagar:",Factura,0, 485, 170, 14);
						lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
						Texto lblNewLabel_4 = new Texto(String.valueOf(precio),Factura,99, 496, 143, 38);
						
						regresar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
					@Override
					public void mouseClicked(MouseEvent e) {
						Factura.desactivar(); 
						Carrito.activar();
					}
				});
					}
				});
			}
		});
		btnTema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnTema.getText().contains("CLARO")){ //Verificacion de tema actual de la pantalla
					
					/*
					 * Actualizacion de variables
					 */
					
					btnTema.setText("OSCURO"); //Cambio de bandera de tema
					btnTema.setIcon(iconOscuro);
					
					logoAppClaro.setVisible(false); //Cambio de logo
					logoAppOscuro.setVisible(true); //""
					
					pantallaMenu.getContenedor().setBackground(ModoOscuro); //Cambio de color de fondo
					
					btnCarrito.setIcon(new ImageIcon(new ImageIcon("Img\\CarritoOscuro.png")
							.getImage().getScaledInstance(btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING))); //Cambio icono de carrito
				}else {
					
					/*
					 * Actualizacion de variables
					 */
					
					btnTema.setText("CLARO"); //Cambio de bandera de tema
					btnTema.setIcon(iconClaro);
					
					logoAppClaro.setVisible(true); //Cambio de logo
					logoAppOscuro.setVisible(false); //""
					
					pantallaMenu.getContenedor().setBackground(new Color(225,237,249)); //Cambio color de fondo
					
					btnCarrito.setIcon(new ImageIcon(new ImageIcon("Img\\CarritoClaro.png")
							.getImage().getScaledInstance(btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING))); //Cambio icono de carrito
				}

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String user = textoUsuario.getText();
		String password = textoPassword.getText();
		if (user.equals("Andres") && password.equals("12345")) {
			
			System.out.println("Funciona");
			pantallaInicio.setVisible(false);
			pantallaMenu.setVisible(true);
			
		}
		else {
			System.out.println("No funciona");
		}
		System.out.println(user + ", " + password);
		
	}
}