package logica;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import datos.Factura;
import datos.Producto;
import datos.Usuario;
import estructuras.*;
import interfaz.Boton;
import interfaz.CampoL;
import interfaz.Contenedor;
import interfaz.Imagen;
import interfaz.Texto;
import interfaz.Ventana;

public class Ejecucion {

	private static String registroUsuariotxt;
	private static int i; //contador de productos en carrito
	private static long precio = 0; 
	private static Usuario usuario_admin = new Usuario("Andres","12345");

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) {

		DefaultListModel modelo = new DefaultListModel();
		DefaultListModel modelo2 = new DefaultListModel();

		Lista_ref_simple<Producto> inventario = new Lista_ref_simple<Producto>();
		Lista_ref_simple<Factura> facturas = new Lista_ref_simple<Factura>();
		Lista_ref_simple<Producto> compra = new Lista_ref_simple<Producto>();
		Lista_ref_simple<Usuario> usuarios = new Lista_ref_simple<Usuario>();
		
		for(int i = 0; i<100;i++) {
			inventario.agregar(new Producto(String.valueOf(i),"P"+String.valueOf(i),"Este producto es..."+String.valueOf(i),(long) (Math.random()*10000),null,2));
		}
		for(int t=0; t<inventario.getTamano();t++) { //Creacion de datos random para pruebas
			modelo.addElement(inventario.encontrar(t).getDato().imprimir());
		}

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

		objeto.imprimir();

		System.out.println();

		Pila_ref_simple<String> objeto2 = new Pila_ref_simple<String>();

		objeto2.push("hola");
		objeto2.push("cómo");
		objeto2.push("estás");
		objeto2.push("bebé");
		objeto2.pop();
		objeto2.pop();

		objeto2.imprimir();

		Lista_ref_simple<Integer> objeto5 = new Lista_ref_simple<Integer>();

		objeto5.agregar(1);
		objeto5.agregar(2);
		objeto5.agregar(3);
		objeto5.agregar(4);
		objeto5.agregar(5);

		System.out.print(objeto5.encontrar(0).getDato()+"\n");

		objeto5.imprimir();

		System.out.println();

		//arreglos dinamicos

		Pila_arreglo_dinamico<Integer> objeto3 = new Pila_arreglo_dinamico<Integer>();

		objeto3.push(1);
		objeto3.push(2);
		objeto3.push(3);
		objeto3.push(4);
		objeto3.pop();

		objeto3.imprimir();

		System.out.println();

		Cola_arreglo_dinamico<String> objeto4 = new Cola_arreglo_dinamico<String>();

		objeto4.encolar("eres");
		objeto4.encolar("todo");
		objeto4.encolar("un");
		objeto4.encolar("programador");
		objeto4.desencolar();


		objeto4.imprimir();

		System.out.println();

		Lista_arreglo_dinamico<Integer> objeto6 = new Lista_arreglo_dinamico<Integer>();

		objeto6.agregar(1);
		objeto6.agregar(2);
		objeto6.agregar(3);
		objeto6.agregar(4);
		objeto6.eliminar_en(1);

		objeto6.imprimir();


		/*
		//ANÁLISIS COMPARATIVO
		Lista_arreglo_dinamico<Integer> lista1 = new Lista_arreglo_dinamico<Integer>();
		Lista_ref_simple<Integer> lista2 = new Lista_ref_simple<Integer>();

		for(int i=0; i<100*1000000-5; i++) {

			lista1.agregar(i);
		}


		long tiempo_inicial = System.nanoTime();

		lista1.encontrar(100*1000000-7);

		long tiempo_final = System.nanoTime() - tiempo_inicial;

		System.out.print(tiempo_final);
		 */


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

		///////////////////////////////////////////////////////////////////////

		/*
		 * Instancia de elementos de prueba
		 */


		/*
		 * Colores
		 */

		Color ModoClaro = new Color(225,237,249); //Variable de colores (claro y oscuro)
		Color ModoOscuro = new Color(20,31,59);
		Color Tema = ModoClaro;

		/*
		 * Ventanas
		 */

		Ventana pantallaInicio = new Ventana("MiPYME");
		pantallaInicio.setBackground(Tema);

		Ventana pantallaMenu = new Ventana("Menu"); 
		pantallaMenu.setBackground(Tema);
		pantallaMenu.desactivar();

		Ventana pantallaRegistro = new Ventana("MiPYME - Registro");
		pantallaRegistro.setBackground(Tema);
		pantallaRegistro.desactivar();

		Ventana carrito = new Ventana("Carrito");
		carrito.setBackground(Tema);
		carrito.desactivar();

		Ventana pantallaDetalles = new Ventana("Detalles");
		pantallaDetalles.desactivar();

		////////////////////////////Pantalla Inicio///////////////////////////////////////////

		Imagen bienvenida = new Imagen("Img\\LogoOscuro.png", pantallaInicio,140, 40, 200, 160);

		Texto userLabel = new Texto("Usuario", pantallaInicio, 110, 205, 90, 35);

		Texto passwordLabel = new Texto("Contrasena", pantallaInicio,110, 225, 90, 35);

		CampoL textoUsuario = new CampoL(pantallaInicio,185,170,165,25);
		CampoL textoPassword = new CampoL(pantallaInicio,185, 190, 165, 25);

		/*
		 * Botones Inicio
		 */

		Boton btnregistro = new Boton("Registrarme", pantallaInicio, 255, 230, 100, 25);

		Boton btningreso = new Boton("Ingresar", pantallaInicio, 130, 230, 100, 25);

		/////////////////////////////////Pantalla Registro//////////////////////////////////////

		JTextField registroUsuario = new JTextField(20);
		registroUsuario.setBounds(225,120,165,25);
		pantallaRegistro.getContenedor().add(registroUsuario);

		JTextField registroContrasena = new JTextField(20);
		registroContrasena.setBounds(225,150,165,25);
		pantallaRegistro.getContenedor().add(registroContrasena);

		Texto LabelRegistroU = new Texto("Escriba su usuario",pantallaRegistro,90, 155, 130, 35);

		Texto LabelRegistroC = new Texto("Escriba su contrasena",pantallaRegistro,80, 185, 150, 35);

		Texto LabelSuccess = new Texto("",pantallaRegistro,90, 285, 300, 35);		

		/*
		 * Botones Registro 
		 */

		Boton BtnRegistrar = new Boton("Registrarme", pantallaRegistro, 255, 200, 100, 25);

		Boton BtnVolver = new Boton("Regresar", pantallaRegistro, 130, 200, 100, 25);

		///////////////////////////////Pantalla Menu////////////////////////////////////////

		Imagen logoAppClaro = new Imagen("Img\\LogoClaro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo claro
		Imagen logoAppOscuro = new Imagen("Img\\LogoOscuro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo Oscuro
		logoAppOscuro.setVisible(false);

		/*
		 * Botones del menu
		 */

		Boton BtnCerrarSesion = new Boton("Cerrar Sesion", pantallaMenu, 130, 240, 200, 50);

		Texto NombreUsuario = new Texto("Bienvenido, " + registroUsuariotxt,pantallaMenu,30, 10, 150,30);

		Boton btnCarrito = new Boton("Carrito",pantallaMenu,38,71,98,74);
		ImageIcon carritoIcon =  new ImageIcon("Img\\CarritoClaro.png"); //Las rutas relativas no estan sirviendo
		Icon iconCarrito = new ImageIcon(carritoIcon.getImage().getScaledInstance(
				btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btnCarrito.setIcon(iconCarrito);
		btnCarrito.setToolTipText("Carrito\r\n");
		btnCarrito.setBackground(null);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setOpaque(false);

		Boton btn_busqueda_factura = new Boton("Opcion 2",pantallaMenu,38,156,98,74);
		ImageIcon facturaIcon =  new ImageIcon("Img\\FacturaClaro.png"); //Las rutas relativas no estan sirviendo
		Icon iconFactura = new ImageIcon(facturaIcon.getImage().getScaledInstance(
				btn_busqueda_factura.getWidth(), btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btn_busqueda_factura.setIcon(iconFactura);
		btn_busqueda_factura.setToolTipText("Factura\r\n");
		btn_busqueda_factura.setBackground(null);
		btn_busqueda_factura.setBorderPainted(false);
		btn_busqueda_factura.setContentAreaFilled(false);
		btn_busqueda_factura.setOpaque(false);
		
		Boton btn3 = new Boton("Opcion 3",pantallaMenu,146,71,98,74);

		Boton btn4 = new Boton("Opcion 4",pantallaMenu,146,156,98,74);

		Boton btn5 = new Boton("Opcion 5",pantallaMenu,254,71,98,74);

		Boton btn6 = new Boton("Opcion 6",pantallaMenu,254,156,98,74);

		JToggleButton btnTema = new JToggleButton("CLARO"); //BotÃ³n de seleccion de tema
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

		///////////////////////////////Pantalla Carrito////////////////////////////////////////


		/////////////////////////////////Pantalla Busqueda de Factura//////////////////////////////////////

		btn_busqueda_factura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n = -1;
				Ventana Factura = new Ventana("Factura");
				Factura.desactivar();
				while(n == -1) {
					n = Integer.valueOf(JOptionPane.showInputDialog(pantallaMenu,"Ingrese numero de la factura","Busqueda de Factura"));
				}
				try {
					Factura nuevaFactura = facturas.encontrar(n).getDato();
					
					Factura.setBounds(100, 100, 268, 600);
					Boton regresar = new Boton("Regresar",Factura,10, 17, 89, 23);
					Texto Titulo = new Texto("Mi Pyme",Factura,0, 102, 252, 25);
					Titulo.setHorizontalAlignment(SwingConstants.CENTER);
					Texto encabezado = new Texto("Factura de compra # ",Factura,0, 126, 252, 14);
					encabezado.setHorizontalAlignment(SwingConstants.CENTER);
					Texto lblNewLabel_2 = new Texto("------------------------------------------------",Factura,0, 147, 252, 14);
					Texto lblNewLabel_2_1 = new Texto("----------------------------------------------",Factura,0, 379, 252, 14);
					Texto lblNewLabel_3 = new Texto("Total a Pagar:",Factura,0, 400, 240, 14);
					Texto tituloNombre = new Texto("Nombre",Factura,10,400,50,14);
					Texto tituloCedula = new Texto("Cedula",Factura,10,440,50,14);
					Texto tituloCorreo = new Texto("Correo",Factura,10,480,50,14);
					Texto separador = new Texto("----------------------------------------------",Factura,0, 520, 252, 14);
					Texto tituloCajero = new Texto("Cajero:",Factura,10,540,50,14);
					Texto tituloFecha = new Texto("Fecha:",Factura,10,560,50,14);
					lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
					JList listProductos = new JList();
					listProductos.setEnabled(false);
					listProductos.setModel(modelo2);
					JScrollPane LaFactura = new JScrollPane(listProductos);
					LaFactura.setBounds(0, 139, 252, 200);
					Factura.getContenedor().add(LaFactura);
					Texto precioProductos = new Texto("<precio>",Factura,0, 414, 240, 38);
					precioProductos.setHorizontalAlignment(SwingConstants.RIGHT);
					Texto nombreCliente = new Texto("<Nombre cliente>",Factura,10,420, 170, 14);
					Texto cedulaCliente = new Texto("<Cedula cliente>",Factura,10,460, 143,14);
					Texto correoCliente = new Texto("<Correo Cliente>",Factura,10,500, 143,14);
					Texto nombreCajero = new Texto("<Cajero>",Factura,50,540, 143,14);
					Texto fechaFactura = new Texto("<Fecha>",Factura,50,560, 143,14);

					pantallaMenu.desactivar();
					Factura.activar();
					precioProductos.setText(String.valueOf(nuevaFactura.getPrecio()));
					nombreCliente.setText(nuevaFactura.getNombre());
					cedulaCliente.setText(nuevaFactura.getCedula());
					correoCliente.setText(nuevaFactura.getCorreo());
					nombreCajero.setText(nuevaFactura.getVendedor().getUsuario());
					fechaFactura.setText(nuevaFactura.getFecha());
					encabezado.setText(encabezado.getText()+String.valueOf(nuevaFactura.getId()));


					regresar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
						@Override
						public void mouseClicked(MouseEvent e) {
							Factura.desactivar(); 
							carrito.activar();
						}
					});
				}catch(Exception exp) {
					Factura.desactivar();
					pantallaMenu.activar();
					JOptionPane.showMessageDialog(pantallaMenu,"Factura no encontrada","Factura no encontrada",JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		///////////////////////Eventos en botones///////////////////////



		BtnCerrarSesion.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				pantallaMenu.setVisible(false);
				pantallaInicio.setVisible(true);

			}

		});



		btnCarrito.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaMenu.desactivar();
				Ventana carrito = new Ventana("Carrito");
				Texto cabecera = new Texto("Producto  |  Precio",carrito,31, 68, 233, 14);

				Texto totalCarrito = new Texto("TOTAL",carrito,367, 118, 46, 14);

				Texto productosCarrito = new Texto("No. Productos",carrito,367, 68, 89, 14);

				Texto pagoCarrito = new Texto(String.valueOf(precio),carrito,367, 143, 76, 23); //Muestra precio total de productos

				Texto prodCarrito = new Texto(String.valueOf(i),carrito,367, 93, 46, 14);

				Boton detalles = new Boton("Detalles",carrito,367, 139, 89, 23);

				Boton pago = new Boton("Pago",carrito,367, 173, 89, 23);

				Boton regresarCarrito = new Boton("Regresar",carrito,367, 207, 89, 23);

				JList list = new JList();
				list.setModel(modelo);

				JScrollPane scroll = new JScrollPane(list);
				scroll.setBounds(31, 41, 117, 200);
				carrito.getContenedor().add(scroll);

				JList list2 = new JList();
				list2.setModel(modelo2);

				JScrollPane scroll2 = new JScrollPane(list2);
				scroll2.setBounds(227, 41, 117, 200);
				carrito.getContenedor().add(scroll2);

				Boton agregar = new Boton("+",carrito,162, 74, 55, 35);

				agregar.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("unchecked")
					@Override
					public void mouseClicked(MouseEvent e) {

						if(list.getSelectedValue() != null) {

							System.out.println(inventario.encontrar(list.getSelectedIndex()).getDato().getPre());
							precio += inventario.encontrar(list.getSelectedIndex()).getDato().getPre();
							i += 1;
							compra.agregar(inventario.encontrar(list.getSelectedIndex()).getDato());
							modelo2.addElement(compra.encontrar(compra.getTamano()-1).getDato().imprimir());
							compra.imprimir();
							pagoCarrito.setText(String.valueOf(precio));

							prodCarrito.setText(String.valueOf(i));

						}

					}
				});

				Boton eliminar = new Boton("-",carrito,162, 126, 55, 35);
				eliminar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						if(list2.getSelectedValue() != null) {


							precio -= compra.encontrar(list2.getSelectedIndex()).getDato().getPre();
							i -= 1;

							compra.eliminar_en(list2.getSelectedIndex());
							modelo2.removeElementAt(list2.getSelectedIndex());
							pagoCarrito.setText(String.valueOf(precio));

							prodCarrito.setText(String.valueOf(i));
						}
					}
				});

				regresarCarrito.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
					@Override
					public void mouseClicked(MouseEvent e) {
						carrito.setVisible(false);
						pantallaMenu.setVisible(true);
					}});

				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount()==2 && list.getSelectedValue() != null) { //Saber si se dio doble clic sobre elemento

							String producto = list.getSelectedValue().toString().split(" | ")[0]; //Obtener nombre del producto

							if(JOptionPane.showConfirmDialog(carrito, "Eliminar "+producto+ "?",
									"Elimacion completada", JOptionPane.YES_NO_OPTION) == 0) { //Mensaje de dialogo para eliminar productos

								/*
								 * Actualizacion de variables globales
								 */

								inventario.eliminar_en(list.getSelectedIndex()); //Eliminacion de productos del objeto

								modelo.removeElementAt(list.getSelectedIndex()); //Eliminacion de producto en lista

								pagoCarrito.setText(String.valueOf(precio)); //Actualizar informacion mostrada
								prodCarrito.setText(String.valueOf(i)); //""

								JOptionPane.showMessageDialog(carrito,"Producto eliminado",
										"Elimacion completada",JOptionPane.INFORMATION_MESSAGE);	//Mensaje informativo						

							}
						}
					}
				});

				pago.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
					@Override
					public void mouseClicked(MouseEvent e) {

						Ventana Factura = new Ventana("Factura");
						Factura.desactivar();
						Factura.setBounds(100, 100, 268, 600);
						Boton regresar = new Boton("Regresar",Factura,10, 17, 89, 23);
						Texto Titulo = new Texto("Mi Pyme",Factura,0, 102, 252, 25);
						Titulo.setHorizontalAlignment(SwingConstants.CENTER);
						Texto encabezado = new Texto("Factura de compra # ",Factura,0, 126, 252, 14);
						encabezado.setHorizontalAlignment(SwingConstants.CENTER);
						Texto lblNewLabel_2 = new Texto("------------------------------------------------",Factura,0, 147, 252, 14);
						Texto lblNewLabel_2_1 = new Texto("----------------------------------------------",Factura,0, 379, 252, 14);
						Texto lblNewLabel_3 = new Texto("Total a Pagar:",Factura,0, 400, 240, 14);
						Texto tituloNombre = new Texto("Nombre",Factura,10,400,50,14);
						Texto tituloCedula = new Texto("Cedula",Factura,10,440,50,14);
						Texto tituloCorreo = new Texto("Correo",Factura,10,480,50,14);
						Texto separador = new Texto("----------------------------------------------",Factura,0, 520, 252, 14);
						Texto tituloCajero = new Texto("Cajero:",Factura,10,540,50,14);
						Texto tituloFecha = new Texto("Fecha:",Factura,10,560,50,14);
						lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
						JList listProductos = new JList();
						listProductos.setEnabled(false);
						listProductos.setModel(modelo2);
						JScrollPane LaFactura = new JScrollPane(listProductos);
						LaFactura.setBounds(0, 139, 252, 200);
						Factura.getContenedor().add(LaFactura);

						Texto precioProductos = new Texto("<precio>",Factura,0, 414, 240, 38);
						precioProductos.setHorizontalAlignment(SwingConstants.RIGHT);
						Texto nombreCliente = new Texto("<Nombre cliente>",Factura,10,420, 170, 14);
						Texto cedulaCliente = new Texto("<Cedula cliente>",Factura,10,460, 143,14);
						Texto correoCliente = new Texto("<Correo Cliente>",Factura,10,500, 143,14);
						Texto nombreCajero = new Texto("<Cajero>",Factura,50,540, 143,14);
						Texto fechaFactura = new Texto("<Fecha>",Factura,50,560, 143,14);

						String nombre = "";
						String cedula = "";
						String correo = "";


						while(nombre == "") {
							nombre = JOptionPane.showInputDialog(carrito,"Ingrese nombre del cliente","Nombre cliente");
						}
						while(cedula == "") {
							cedula = JOptionPane.showInputDialog(carrito,"Ingrese cedula del cliente","Cedula cliente");
						}
						while(correo == "" || !correo.contains("@") || !correo.contains(".")) {
							correo = JOptionPane.showInputDialog(carrito,"Ingrese correo del cliente","Correo cliente");
						}

						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
						String Fecha = dtf.format(LocalDateTime.now());


						System.out.print(usuario_admin.getUsuario());
						Factura nuevaFactura = new Factura(nombre,cedula, correo, Fecha, usuario_admin, compra);
						facturas.agregar(nuevaFactura);

						carrito.desactivar();
						Factura.activar();
						precioProductos.setText(String.valueOf(nuevaFactura.getPrecio()));
						nombreCliente.setText(nuevaFactura.getNombre());
						cedulaCliente.setText(nuevaFactura.getCedula());
						correoCliente.setText(nuevaFactura.getCorreo());
						nombreCajero.setText(nuevaFactura.getVendedor().getUsuario());
						fechaFactura.setText(nuevaFactura.getFecha());
						encabezado.setText(encabezado.getText()+String.valueOf(nuevaFactura.getId()));


						regresar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
							@Override
							public void mouseClicked(MouseEvent e) {
								Factura.desactivar(); 
								carrito.activar();
							}
						});
					}
				});

				detalles.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(list.getSelectedValue() != null) { //Saber si hay seleccionado algun elemento en lista
							Ventana detalles = new Ventana("Detalles"); //Ventada de detalles de producto
							carrito.desactivar();
							detalles.activar();

							/*
							 * Elementos de ventana
							 */

							Imagen imgProducto = new Imagen("Img\\shopping-cart (4).png"
									,detalles,0,40,345-detalles.getWidth()/2,detalles.getHeight()/2); //Imagen de prueba

							String nombre = inventario.encontrar(list.getSelectedIndex()).getDato().getNo(); //Nombre de producto
							Texto nombrePro = new Texto(nombre, detalles,0,40+imgProducto.getHeight(),detalles.getWidth(),15);

							String descripcion = inventario.encontrar(list.getSelectedIndex()).getDato().getDes(); //Descripcion de producto
							Texto desPro = new Texto(descripcion, detalles,0,40+imgProducto.getHeight()+15,detalles.getWidth(),15);

							String precioP = String.valueOf(inventario.encontrar(list.getSelectedIndex()).getDato().getPre()); //Precio de producto
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
									carrito.activar();
								}
							});

							elimarPro.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									String producto = list.getSelectedValue().toString().split(" | ")[0]; //Nombre del producto

									if(JOptionPane.showConfirmDialog(carrito, "Eliminar "+
											producto+ "?", "Elimacion completada", JOptionPane.YES_NO_OPTION) == 0) { //Eliminacion de producto
										/*
										 * Actualizacion de variables globales
										 */

										inventario.eliminar_en(list.getSelectedIndex());

										modelo.removeElementAt(list.getSelectedIndex());	

										pagoCarrito.setText(String.valueOf(precio));

										prodCarrito.setText(String.valueOf(i));

										JOptionPane.showMessageDialog(carrito,"Producto eliminado",
												"Elimacion completada",JOptionPane.INFORMATION_MESSAGE); //Mensaje informativo

										detalles.desactivar(); //Salida de ventana
										carrito.activar();
									}}});


						}else {
							JOptionPane.showMessageDialog(carrito,"Por favor elija un producto",
									"Error",JOptionPane.ERROR_MESSAGE); //Mensaje de error
						}
					}});

			}
		});

		/////////////////////////Pantalla Factura///////////////////////////


		///////////////////////////////////////////////////////////////////


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
					btn_busqueda_factura.setIcon(new ImageIcon(new ImageIcon("Img\\FacturaOscuro.png")
							.getImage().getScaledInstance(btn_busqueda_factura.getWidth(), btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)));
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
					btn_busqueda_factura.setIcon(new ImageIcon(new ImageIcon("Img\\FacturaClaro.png")
							.getImage().getScaledInstance(btn_busqueda_factura.getWidth(), btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)));
				}

			}
		});

		/*
		 * Botones Registro
		 */

		BtnRegistrar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {

				String registro_usuario = registroUsuario.getText();
				String registro_contrasenia = registroContrasena.getText();
				
				

				if (registro_contrasenia.equals("") && registro_usuario.equals("")) {

					LabelSuccess.setText("Por favor, llene los espacios en blanco");

				}


				else if(registro_usuario.equals("")) {

					LabelSuccess.setText("Por favor ingrese su usuario");

				}

				else if (registro_contrasenia.equals("")) {

					LabelSuccess.setText("Ingrese la contrasena");

				}

				else if(!"".equals(registro_usuario) && !"".equals(registro_contrasenia)) {

					JOptionPane.showMessageDialog(pantallaRegistro,"Creación de usuario exitosa","Exitoso",JOptionPane.INFORMATION_MESSAGE);
					pantallaRegistro.setVisible(false);
					pantallaMenu.setVisible(true);
					
					usuarios.agregar(new Usuario(registro_usuario,registro_contrasenia));
                    
					
					registroUsuario.setText("");
					registroContrasena.setText("");

				}

			}});

		BtnVolver.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaRegistro.setVisible(false);
				pantallaInicio.setVisible(true);
			}});		

		btningreso.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				if (textoPassword.getText().equals("") && textoUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Por favor, llene los espacios en blanco","¡OJO!",JOptionPane.WARNING_MESSAGE);

				}


				else if(textoUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Por favor ingrese su usuario","¡OJO!",JOptionPane.WARNING_MESSAGE);

				}

				else if (textoPassword.getText().equals("")) {
					
					JOptionPane.showMessageDialog(pantallaInicio,"Ingrese la contrasena","¡OJO!",JOptionPane.WARNING_MESSAGE);
					

				}

				else if(!"".equals(textoUsuario.getText()) && !"".equals(textoPassword.getText())) {

					//JOptionPane.showMessageDialog(pantallaRegistro,"Creación de usuario exitosa","Exitoso",JOptionPane.INFORMATION_MESSAGE);
					System.out.println("ENTRO AQUI");
					
					boolean compuerta_filtro = true;
					
					if(usuario_admin.getUsuario().equals(textoUsuario.getText()) && usuario_admin.getContrasena().equals(textoPassword.getText())) {
						
						pantallaInicio.setVisible(false);
						pantallaMenu.setVisible(true);
						compuerta_filtro = false;
					}else {
					
					for(int i=0; i < usuarios.getTamano(); i++) {
						
						if(usuarios.encontrar(i).getDato().getUsuario().equals(textoUsuario.getText()) && usuarios.encontrar(i).getDato().getContrasena().equals(textoPassword.getText())) {
							
							pantallaInicio.setVisible(false);
							pantallaMenu.setVisible(true);
							compuerta_filtro = false;
						    break;
						}
					}
					}
					
					if(compuerta_filtro) {
						
						JOptionPane.showMessageDialog(pantallaRegistro,"Usuario no existente","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					//registroUsuario.setText("");
					//registroContrasena.setText("");

				}
				
				
				
				
				
				
				
				
			}});

		btnregistro.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaInicio.setVisible(false);
				pantallaRegistro.setVisible(true);
			}});
	}

}