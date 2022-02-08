package interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import datos.Factura;
import datos.Producto;
import logica.Ejecucion;

public class PantallaMenu {

	public static boolean flag = true;
	public static boolean temaFlag = (Ejecucion.Tema==Ejecucion.ModoClaro);
	//public static boolean inicializado = false;
	private static ImageIcon carritoO;
	private static ImageIcon carritoC;
	private static ImageIcon busqueda_facturaC;
	private static ImageIcon busqueda_facturaO;
	private static ImageIcon pedidosC; 
	private static ImageIcon pedidosO;		
	private static ImageIcon inventarioO;		
	private static ImageIcon inventarioC;		
	private static ImageIcon busqueda_productosO;		
	private static ImageIcon busqueda_productosC;		
	private static ImageIcon usuarioC;		
	private static ImageIcon usuarioO;	
	private static ImageIcon cerrarC;		
	private static ImageIcon cerrarO;	
	public static ImageIcon ingresarC;		
	public static ImageIcon ingresarO;
	public static ImageIcon DetallesO;
	public static ImageIcon DetallesC;
	public static ImageIcon PagoO;
	public static ImageIcon PagoC;
	public static ImageIcon PedirO;
	public static ImageIcon PedirC;
	public static ImageIcon RegresarO;
	public static ImageIcon RegresarC;
	public static ImageIcon AgregarO;
	public static ImageIcon AgregarC;
	public static ImageIcon AUsuarioO;
	public static ImageIcon AUsuarioC;
	public static ImageIcon EUsuarioO;
	public static ImageIcon EUsuarioC;
	public static ImageIcon QUsuarioO;
	public static ImageIcon QUsuarioC;
	public static ImageIcon LupaO;
	public static ImageIcon LupaC;
	public static ImageIcon AceptarO;
	public static ImageIcon AceptarC;
	public static ImageIcon CancelarO;
	public static ImageIcon CancelarC;
	public static ImageIcon EliminarO;
	public static ImageIcon EliminarC;

	public static void cargar() {
		cerrarO = new ImageIcon(new ImageIcon("Img\\CerrarOscuro.png").getImage().getScaledInstance( 300, 60, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito
		ingresarO = new ImageIcon(new ImageIcon("Img\\IngresarOscuro.png").getImage().getScaledInstance( 200, 50, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito
		carritoO = new ImageIcon(new ImageIcon("Img\\CarritoOscuro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito
		busqueda_facturaO =  new ImageIcon(new ImageIcon("Img\\FacturaOscuro.png").getImage().getScaledInstance(75,75, Image.SCALE_AREA_AVERAGING));
		pedidosO = new ImageIcon(new ImageIcon("Img\\PedidosOscuro.png").getImage().getScaledInstance(70,75, Image.SCALE_AREA_AVERAGING));
		inventarioO = new ImageIcon((new ImageIcon("Img\\InventarioOscuro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));		
		busqueda_productosO = new ImageIcon((new ImageIcon(("Img\\TareasOscuro.png")).getImage().getScaledInstance(70,66, Image.SCALE_AREA_AVERAGING)));		
		usuarioO = new ImageIcon((new ImageIcon("Img\\UsuariosOscuro.png")).getImage().getScaledInstance(70,75, Image.SCALE_AREA_AVERAGING));		
		DetallesO = new ImageIcon(new ImageIcon("Img\\ModificarOscuro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING));
		PagoO = new ImageIcon(new ImageIcon("Img\\PagarOscuro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING));
		PedirO = new ImageIcon(new ImageIcon("Img\\PagarOscuro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING));
		RegresarO = new ImageIcon(new ImageIcon("Img\\RegresarOscuro.png").getImage().getScaledInstance(35,35, Image.SCALE_AREA_AVERAGING));
		AgregarO = new ImageIcon(new ImageIcon("Img\\AgregarOscuro.png").getImage().getScaledInstance(89, 32, Image.SCALE_AREA_AVERAGING));
		AUsuarioO = new ImageIcon(new ImageIcon("Img\\AgregarUsuarioOscuro.png").getImage().getScaledInstance(35,35, Image.SCALE_AREA_AVERAGING));
		EUsuarioO = new ImageIcon(new ImageIcon("Img\\ModificarUsuarioOscuro.png").getImage().getScaledInstance(35,35, Image.SCALE_AREA_AVERAGING));
		QUsuarioO = new ImageIcon(new ImageIcon("Img\\EliminarUsuarioOscuro.png").getImage().getScaledInstance(35,35, Image.SCALE_AREA_AVERAGING)); 
		LupaO = new ImageIcon(new ImageIcon("Img\\BuscarOscuro.png").getImage().getScaledInstance(20,20, Image.SCALE_AREA_AVERAGING)); 
		AceptarO = new ImageIcon(new ImageIcon("Img\\AceptarOscuro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING)); 
		CancelarO = new ImageIcon(new ImageIcon("Img\\CancelarOscuro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING)); 
		EliminarO = new ImageIcon(new ImageIcon("Img\\EliminarOscuro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING)); 
		

		cerrarC = new ImageIcon(new ImageIcon("Img\\CerrarClaro.png").getImage().getScaledInstance( 300, 60, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito
		ingresarC = new ImageIcon(new ImageIcon("Img\\IngresarClaro.png").getImage().getScaledInstance( 200, 50, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito
		carritoC = new ImageIcon(new ImageIcon("Img\\CarritoClaro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito
		busqueda_facturaC =  new ImageIcon(new ImageIcon("Img\\FacturaClaro.png").getImage().getScaledInstance(75,75, Image.SCALE_AREA_AVERAGING));
		pedidosC = new ImageIcon(new ImageIcon("Img\\PedidosClaro.png").getImage().getScaledInstance(70,75, Image.SCALE_AREA_AVERAGING));
		inventarioC = new ImageIcon((new ImageIcon("Img\\InventarioClaro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));		
		busqueda_productosC = new ImageIcon((new ImageIcon("Img\\TareasClaro.png")).getImage().getScaledInstance(70,66, Image.SCALE_AREA_AVERAGING));		
		usuarioC = new ImageIcon((new ImageIcon("Img\\UsuariosClaro.png")).getImage().getScaledInstance(70,75, Image.SCALE_AREA_AVERAGING));		
		DetallesC = new ImageIcon(new ImageIcon("Img\\ModificarClaro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING));
		PagoC = new ImageIcon(new ImageIcon("Img\\PagarClaro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING));
		PedirC = new ImageIcon(new ImageIcon("Img\\PagarClaro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING));
		RegresarC = new ImageIcon(new ImageIcon("Img\\RegresarClaro.png").getImage().getScaledInstance(35,35, Image.SCALE_AREA_AVERAGING));
		AgregarC = new ImageIcon(new ImageIcon("Img\\AgregarClaro.png").getImage().getScaledInstance(89, 32, Image.SCALE_AREA_AVERAGING));
		AUsuarioC = new ImageIcon(new ImageIcon("Img\\AgregarUsuarioClaro.png").getImage().getScaledInstance(35,35, Image.SCALE_AREA_AVERAGING));
		EUsuarioC = new ImageIcon(new ImageIcon("Img\\ModificarUsuarioClaro.png").getImage().getScaledInstance(35,35, Image.SCALE_AREA_AVERAGING));
		QUsuarioC = new ImageIcon(new ImageIcon("Img\\EliminarUsuarioClaro.png").getImage().getScaledInstance(35,35, Image.SCALE_AREA_AVERAGING)); 
		LupaC = new ImageIcon(new ImageIcon("Img\\BuscarClaro.png").getImage().getScaledInstance(20,20, Image.SCALE_AREA_AVERAGING)); 
		AceptarC = new ImageIcon(new ImageIcon("Img\\AceptarClaro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING)); 
		CancelarC = new ImageIcon(new ImageIcon("Img\\CancelarClaro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING)); 
		EliminarC = new ImageIcon(new ImageIcon("Img\\EliminarClaro.png").getImage().getScaledInstance(89,32, Image.SCALE_AREA_AVERAGING)); 
		
		
	}

	public static void main(String[] args) {
		//cargar();
		Ventana pantallaMenu = new Ventana("Menu"); 
		pantallaMenu.setBackground(Ejecucion.Tema);

		//----------------- Iconos botones ----------------//
		/*
		ImageIcon carritoO = new ImageIcon(new ImageIcon("Img\\CarritoOscuro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito
		ImageIcon carritoC = new ImageIcon(new ImageIcon("Img\\CarritoClaro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito

		ImageIcon busqueda_facturaO =  new ImageIcon(new ImageIcon("Img\\FacturaOscuro.png").getImage().getScaledInstance(70,75, Image.SCALE_AREA_AVERAGING));
		ImageIcon busqueda_facturaC =  new ImageIcon(new ImageIcon("Img\\FacturaClaro.png").getImage().getScaledInstance(70,75, Image.SCALE_AREA_AVERAGING));

		ImageIcon pedidosO = new ImageIcon(new ImageIcon("Img\\PedidoOscuro.png").getImage().getScaledInstance(65,75, Image.SCALE_AREA_AVERAGING));
		ImageIcon pedidosC = new ImageIcon(new ImageIcon("Img\\PedidoClaro.png").getImage().getScaledInstance(65,75, Image.SCALE_AREA_AVERAGING));

		ImageIcon inventarioC = new ImageIcon((new ImageIcon("Img\\InventarioClaro.png")).getImage().getScaledInstance(95,75, Image.SCALE_AREA_AVERAGING));		
		ImageIcon inventarioO = new ImageIcon((new ImageIcon("Img\\InventarioOscuro.png")).getImage().getScaledInstance(95,75, Image.SCALE_AREA_AVERAGING));		

		ImageIcon busqueda_productosC = new ImageIcon((new ImageIcon("Img\\BuscarProductoClaro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));		
		ImageIcon busqueda_productosO = new ImageIcon((new ImageIcon(("Img\\BuscarProductoOscuro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING)));		

		ImageIcon usuarioC = new ImageIcon((new ImageIcon("Img\\UsuarioClaro.png")).getImage().getScaledInstance(65,65, Image.SCALE_AREA_AVERAGING));		
		ImageIcon usuarioO = new ImageIcon((new ImageIcon("Img\\UsuarioOscuro.png")).getImage().getScaledInstance(65,65, Image.SCALE_AREA_AVERAGING));		
		 */
		//Ejecucion.usuarios.imprimir(Ejecucion.usuarios.getRaiz());

		Imagen logoAppClaro = new Imagen("Img\\LogoClaro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo claro
		Imagen logoAppOscuro = new Imagen("Img\\LogoOscuro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo Oscuro
		logoAppOscuro.setVisible((temaFlag)?false:true);
		logoAppClaro.setVisible((temaFlag)?true:false);

		Texto NombreUsuario = new Texto("Bienvenido, " + PantallaInicio.textoUsuario,pantallaMenu,30, 10, 150,30);

		//Botones del menu

		Boton btn_cerrar_sesion = new Boton("", pantallaMenu, 45+55, 240+25, 300, 60);
		btn_cerrar_sesion.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_cerrar_sesion.volverIcono("Cerrar Sesion\r\n");
		btn_cerrar_sesion.setIcon((!temaFlag)?cerrarO:cerrarC);

		Boton btnCarrito = new Boton("",pantallaMenu,25+40,70,100,75);
		btnCarrito.setBackground(null);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setOpaque(false);
		//btnCarrito.volverIcono("Carrito\r\n","Img\\CarritoClaro.png","Img\\CarritoOscuro.png");

		Boton boton_tarea = new Boton("",pantallaMenu,40+100+50,70,100,75);
		boton_tarea.volverIcono("Tareas\r\n");
		//btn_busqueda_productos.volverIcono("Buscar Productos\r\n","Img\\BuscarProductoClaro.png","Img\\BuscarProductoOscuro.png");

		Boton btn_busqueda_factura = new Boton("",pantallaMenu,35+40,170,100,75);
		btn_busqueda_factura.setBackground(null);
		btn_busqueda_factura.setBorderPainted(false);
		btn_busqueda_factura.setContentAreaFilled(false);
		btn_busqueda_factura.setOpaque(false);
		//btn_busqueda_factura.volverIcono("Factura\r\n","Img\\FacturaClaro.png","Img\\FacturaOscuro.png",btn_busqueda_factura.getWidth()-15,btn_busqueda_factura.getHeight());


		Boton btn_pedidos = new Boton("",pantallaMenu,50+100+45,170,100,75);
		btn_pedidos.setBackground(null);
		btn_pedidos.setBorderPainted(false);
		btn_pedidos.setContentAreaFilled(false);
		btn_pedidos.setOpaque(false);
		//btn_pedidos.volverIcono("Pedidos\r\n","Img\\PedidoClaro.png","Img\\PedidoOscuro.png",btn_pedidos.getWidth()-28, btn_pedidos.getHeight());

		Boton btn_inventario = new Boton("",pantallaMenu,40+2*100+75,70,100,75);
		btn_inventario.setBackground(null);
		btn_inventario.setBorderPainted(false);
		btn_inventario.setContentAreaFilled(false);
		btn_inventario.setOpaque(false);
		//btn_inventario.volverIcono("Inventario\r\n","Img\\InventarioClaro.png","Img\\InventarioOscuro.png",btn_inventario.getWidth()-20,btn_inventario.getHeight());

		Boton boton_usuario = new Boton("",pantallaMenu,40+2*100+75,175,100,75);
		boton_usuario.setBackground(null);
		boton_usuario.setBorderPainted(false);
		boton_usuario.setContentAreaFilled(false);
		boton_usuario.setOpaque(false);
		boton_usuario.setVisible(flag);
		//boton_usuario.volverIcono("Usuario\r\n","Img\\UsuarioClaro.png","Img\\UsuarioOscuro.png",boton_usuario.getWidth()-40,boton_usuario.getHeight()-10);


		btnCarrito.setIcon((!temaFlag)?carritoO:carritoC);
		boton_usuario.setIcon((!temaFlag)?usuarioO:usuarioC);
		btn_inventario.setIcon((!temaFlag)?inventarioO:inventarioC);
		boton_tarea.setIcon((!temaFlag)?busqueda_productosO:busqueda_productosC);
		btn_pedidos.setIcon((!temaFlag)?pedidosO:pedidosC);
		btn_busqueda_factura.setIcon((!temaFlag)?busqueda_facturaO:busqueda_facturaC);

		JToggleButton btnTema = new JToggleButton(""); //BotÃ³n de seleccion de tema
		btnTema.setCursor(new Cursor(JFrame.HAND_CURSOR));	
		btnTema.setBounds(374+30, -5, 80, 80);
		ImageIcon claro = new ImageIcon("Img\\ModoClaro.png");
		Icon iconClaro = new ImageIcon(claro.getImage().getScaledInstance(btnTema.getWidth()/2,btnTema.getHeight()/2, Image.SCALE_DEFAULT));
		ImageIcon oscuro = new ImageIcon("Img\\ModoOscuro.png");
		Icon iconOscuro = new ImageIcon(oscuro.getImage().getScaledInstance(btnTema.getWidth()/2,btnTema.getHeight()/2, Image.SCALE_DEFAULT));
		btnTema.setIcon((temaFlag)?iconClaro:iconOscuro);
		btnTema.setBackground(null);
		btnTema.setBorderPainted(false);
		btnTema.setContentAreaFilled(false);
		btnTema.setOpaque(false);
		btnTema.setVisible(true);
		pantallaMenu.getContenedor().add(btnTema);

		Boton btn_registro = new Boton("Registrar", pantallaMenu, 365, 150, 100, 25);
		btn_registro.setVisible(false);

		//Metodo botones

		boton_tarea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				
				pantallaMenu.desactivar();
				PantallaTarea.main(null);
				
			}
		});

		boton_usuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				pantallaMenu.setVisible(false);
				PantallaUsuarios.main(null);
			}
		});

		btn_registro.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaMenu.setVisible(false);
				PantallaRegistro.main(null);
			}});

		btn_busqueda_factura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String entrada;

				entrada = JOptionPane.showInputDialog(pantallaMenu,"Ingrese número de cédula","Cedula");

				System.out.println(entrada);

				if(entrada != null) {

					try {

						Factura nuevaFactura = Ejecucion.facturas.buscar(Integer.parseInt(entrada));

						if(nuevaFactura!=null) {

							pantallaMenu.desactivar();
							VerFactura.main("menu",nuevaFactura);
						}else {

							JOptionPane.showMessageDialog(pantallaMenu,"Factura no encontrada","Mensaje",JOptionPane.INFORMATION_MESSAGE);
						}

					} catch(Exception exc){

						JOptionPane.showMessageDialog(pantallaMenu,"Valor introducido no valido","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		btn_inventario.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pantallaMenu.desactivar();
				PantallaInventario.main(null);

			}
		});

		btn_cerrar_sesion.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(pantallaMenu, "¿Seguro que deseas cerrar sesi\u00f3n?", "¿Seguro?", JOptionPane.YES_NO_OPTION) == 0) { //Eliminacion de producto

					JOptionPane.showMessageDialog(pantallaMenu,"Sesi\u00f3n Cerrada","Sesi\u00f3n Cerrada",JOptionPane.INFORMATION_MESSAGE); //Mensaje informativo

					pantallaMenu.desactivar(); //Salida de ventana
					PantallaInicio.main(null);
					btn_registro.setVisible(false);

				}

			}
		});

		btnCarrito.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaMenu.desactivar();
				PantallaCarrito.flag = false;
				PantallaCarrito.main(null);
			}
		});

		btn_pedidos.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaMenu.desactivar();
				PantallaPedidos.main(null);
			}
		});

		btnTema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnTema.setText(""); //Cambio de bandera de tema
				Ejecucion.Tema = (temaFlag)?Ejecucion.ModoOscuro:Ejecucion.ModoClaro;

				btnTema.setIcon((temaFlag)? iconOscuro:iconClaro);

				logoAppClaro.setVisible((temaFlag)?false:true); //Cambio de logo
				logoAppOscuro.setVisible((temaFlag)?true:false); //""


				pantallaMenu.getContenedor().setBackground(Ejecucion.Tema); //Cambio de color de fondo

				btn_cerrar_sesion.setIcon((temaFlag)?cerrarO:cerrarC);
				btnCarrito.setIcon((temaFlag)?carritoO:carritoC);
				boton_usuario.setIcon((temaFlag)?usuarioO:usuarioC);
				btn_inventario.setIcon((temaFlag)?inventarioO:inventarioC);
				boton_tarea.setIcon((temaFlag)?busqueda_productosO:busqueda_productosC);
				btn_pedidos.setIcon((temaFlag)?pedidosO:pedidosC);
				btn_busqueda_factura.setIcon((temaFlag)?busqueda_facturaO:busqueda_facturaC);
				temaFlag = (Ejecucion.Tema==Ejecucion.ModoClaro);

			}
		});


	}
}
