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

	public static void main(String[] args) {

		//----------------- Iconos botones ----------------//


		ImageIcon carritoO = new ImageIcon(new ImageIcon("Img\\CarritoOscuro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito
		ImageIcon carritoC = new ImageIcon(new ImageIcon("Img\\CarritoClaro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING)); //Cambio icono de carrito

		ImageIcon busqueda_facturaO =  new ImageIcon(new ImageIcon("Img\\FacturaOscuro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));
		ImageIcon busqueda_facturaC =  new ImageIcon(new ImageIcon("Img\\FacturaClaro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));

		ImageIcon pedidosO = new ImageIcon(new ImageIcon("Img\\PedidoOscuro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));
		ImageIcon pedidosC = new ImageIcon(new ImageIcon("Img\\PedidoClaro.png").getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));

		ImageIcon inventarioC = new ImageIcon((new ImageIcon("Img\\InventarioClaro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));		
		ImageIcon inventarioO = new ImageIcon((new ImageIcon("Img\\InventarioOscuro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));		

		ImageIcon busqueda_productosC = new ImageIcon((new ImageIcon("Img\\BuscarProductoClaro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));		
		ImageIcon busqueda_productosO = new ImageIcon((new ImageIcon(("Img\\BuscarProductoOscuro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING)));		

		ImageIcon usuarioC = new ImageIcon((new ImageIcon("Img\\UsuarioClaro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));		
		ImageIcon usuarioO = new ImageIcon((new ImageIcon("Img\\UsuarioOscuro.png")).getImage().getScaledInstance(100,75, Image.SCALE_AREA_AVERAGING));		

		//Ejecucion.usuarios.imprimir(Ejecucion.usuarios.getRaiz());

		Ventana pantallaMenu = new Ventana("Menu"); 
		pantallaMenu.setBackground(Ejecucion.Tema);

		Imagen logoAppClaro = new Imagen("Img\\LogoClaro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo claro
		Imagen logoAppOscuro = new Imagen("Img\\LogoOscuro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo Oscuro
		logoAppOscuro.setVisible((temaFlag)?false:true);
		logoAppClaro.setVisible((temaFlag)?true:false);

		Texto NombreUsuario = new Texto("Bienvenido, " + PantallaInicio.textoUsuario,pantallaMenu,30, 10, 150,30);

		//Botones del menu

		Boton btn_cerrar_sesion = new Boton("Cerrar Sesion", pantallaMenu, 45+55, 240+25, 300, 60);
		btn_cerrar_sesion.setFont(new Font("Tahoma", Font.BOLD, 18));

		Boton btnCarrito = new Boton("",pantallaMenu,25+40,70,100,75);
		btnCarrito.setBackground(null);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setOpaque(false);
		//btnCarrito.volverIcono("Carrito\r\n","Img\\CarritoClaro.png","Img\\CarritoOscuro.png");

		Boton btn_busqueda_productos = new Boton("",pantallaMenu,40+100+50,70,100,75);
		btn_busqueda_productos.setBackground(null);
		btn_busqueda_productos.setBorderPainted(false);
		btn_busqueda_productos.setContentAreaFilled(false);
		btn_busqueda_productos.setOpaque(false);
		//btn_busqueda_productos.volverIcono("Buscar Productos\r\n","Img\\BuscarProductoClaro.png","Img\\BuscarProductoOscuro.png");

		Boton btn_busqueda_factura = new Boton("",pantallaMenu,35+40,170,100,75);
		btn_busqueda_factura.setBackground(null);
		btn_busqueda_factura.setBorderPainted(false);
		btn_busqueda_factura.setContentAreaFilled(false);
		btn_busqueda_factura.setOpaque(false);
		//btn_busqueda_factura.volverIcono("Factura\r\n","Img\\FacturaClaro.png","Img\\FacturaOscuro.png",btn_busqueda_factura.getWidth()-15,btn_busqueda_factura.getHeight());


		Boton btn_pedidos = new Boton("",pantallaMenu,50+100+50,170,100,75);
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
		btn_busqueda_productos.setIcon((!temaFlag)?busqueda_productosO:busqueda_productosC);
		btn_pedidos.setIcon((!temaFlag)?pedidosO:pedidosC);
		btn_busqueda_factura.setIcon((!temaFlag)?busqueda_facturaO:busqueda_facturaC);
		
		JToggleButton btnTema = new JToggleButton(""); //BotÃ³n de seleccion de tema
		btnTema.setCursor(new Cursor(JFrame.HAND_CURSOR));	
		btnTema.setBounds(374+30, -5, 80, 80);
		ImageIcon claro = new ImageIcon("Img\\ModoClaro.png");
		Icon iconClaro = new ImageIcon(claro.getImage().getScaledInstance(btnTema.getWidth()/2,btnTema.getHeight()/2, Image.SCALE_DEFAULT));
		ImageIcon oscuro = new ImageIcon("Img\\ModoOscuro.png");
		Icon iconOscuro = new ImageIcon(oscuro.getImage().getScaledInstance(btnTema.getWidth()/2,btnTema.getHeight()/2, Image.SCALE_DEFAULT));
		btnTema.setIcon(iconClaro);
		btnTema.setBackground(null);
		btnTema.setBorderPainted(false);
		btnTema.setContentAreaFilled(false);
		btnTema.setOpaque(false);
		btnTema.setVisible(true);
		pantallaMenu.getContenedor().add(btnTema);

		Boton btn_registro = new Boton("Registrar", pantallaMenu, 365, 150, 100, 25);
		btn_registro.setVisible(false);

		//Metodo botones

		btn_busqueda_productos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				int n = -1;
				while(n == -1) {
					String entrada = JOptionPane.showInputDialog(pantallaMenu,"Ingrese id del producto","Busqueda de Productos");
					try {
						n = (entrada==null)?-2:(entrada.equals("Busqueda de Productos"))?-1:Integer.valueOf(entrada);
					}catch(Exception except) {
						JOptionPane.showMessageDialog(pantallaMenu,"Entrada invalida","Solo numeros validos",JOptionPane.ERROR_MESSAGE);
					}
				}
				Producto productoDetalles = Ejecucion.inventario.encontrar( new Producto(n)).getDato();
				if(productoDetalles!=null) {
					pantallaMenu.desactivar();
					PantallaDetalles.main("menu",productoDetalles);
				}else {
					JOptionPane.showMessageDialog(pantallaMenu,"Producto no encontrado","ID no v\u00e1lido",JOptionPane.ERROR_MESSAGE);
				}
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

				String entrada = JOptionPane.showInputDialog(pantallaMenu,"Ingrese número de cédula","Busqueda de Factura");

				//Factura nuevaFactura = Ejecucion.facturas.encontrar(n).getDato();
				Factura nuevaFactura = Ejecucion.facturas.buscar(Integer.parseInt(entrada));

				if(nuevaFactura!=null) {

					pantallaMenu.desactivar();
					VerFactura.main("menu",nuevaFactura);
				}else {
					//if(n!=-2)JOptionPane.showMessageDialog(pantallaMenu,"Factura no encontrada","ID no v\u00e1lido",JOptionPane.ERROR_MESSAGE);

					JOptionPane.showMessageDialog(pantallaMenu,"Factura no encontrada","Error",JOptionPane.ERROR_MESSAGE);
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
					/*
					 * Actualizacion de variables globales
					 */

					JOptionPane.showMessageDialog(pantallaMenu,"Sesi\u00f3n Cerrada",
							"Sesi\u00f3n Cerrada",JOptionPane.INFORMATION_MESSAGE); //Mensaje informativo

					pantallaMenu.desactivar(); //Salida de ventana
					PantallaInicio.main(null);
					btn_registro.setVisible(false);

				}

				/*else {
					JOptionPane.showMessageDialog(pantallaMenu,"Ke",
							"Error",JOptionPane.ERROR_MESSAGE); //Mensaje de error

				}
				 */
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

				btnCarrito.setIcon((temaFlag)?carritoO:carritoC);
				boton_usuario.setIcon((temaFlag)?usuarioO:usuarioC);
				btn_inventario.setIcon((temaFlag)?inventarioO:inventarioC);
				btn_busqueda_productos.setIcon((temaFlag)?busqueda_productosO:busqueda_productosC);
				btn_pedidos.setIcon((temaFlag)?pedidosO:pedidosC);
				btn_busqueda_factura.setIcon((temaFlag)?busqueda_facturaO:busqueda_facturaC);

				temaFlag = (Ejecucion.Tema==Ejecucion.ModoClaro);

			}
		});


	}
}
