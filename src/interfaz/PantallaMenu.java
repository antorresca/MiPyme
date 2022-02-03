package interfaz;

import java.awt.Color;
import java.awt.Cursor;
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
		
		//Ejecucion.usuarios.imprimir(Ejecucion.usuarios.getRaiz());

		Ventana pantallaMenu = new Ventana("Menu"); 
		pantallaMenu.setBackground(Ejecucion.Tema);

		Imagen logoAppClaro = new Imagen("Img\\LogoClaro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo claro
		Imagen logoAppOscuro = new Imagen("Img\\LogoOscuro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo Oscuro
		logoAppOscuro.setVisible((temaFlag)?false:true);
		logoAppClaro.setVisible((temaFlag)?true:false);
		
		Texto NombreUsuario = new Texto("Bienvenido, " + PantallaInicio.textoUsuario,pantallaMenu,30, 10, 150,30);

		//Botones del menu

		Boton btn_cerrar_sesion = new Boton("Cerrar Sesion", pantallaMenu, 110+55, 240+25, 150, 30);
		
		Boton btnCarrito = new Boton("",pantallaMenu,25+40,70,100,75);
		ImageIcon carritoIcon =  new ImageIcon((temaFlag) ? "Img\\CarritoClaro.png":"Img\\CarritoOscuro.png"); //Las rutas relativas no estan sirviendo
		Icon iconCarrito = new ImageIcon(carritoIcon.getImage().getScaledInstance(
				btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btnCarrito.setIcon(iconCarrito);
		btnCarrito.setToolTipText("Carrito\r\n");
		btnCarrito.setBackground(null);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setOpaque(false);
		
		Boton btn_busqueda_productos = new Boton("",pantallaMenu,40+100+50,70,100,75);
		ImageIcon btn_busqueda_productos_Icon =  new ImageIcon((temaFlag)?"Img\\BuscarProductoClaro.png":"Img\\BuscarProductoOscuro.png"); //Las rutas relativas no estan sirviendo
		Icon icon_btn_busqueda_productos = new ImageIcon(btn_busqueda_productos_Icon.getImage().getScaledInstance(
				btn_busqueda_productos.getWidth(),btn_busqueda_productos.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btn_busqueda_productos.setIcon(icon_btn_busqueda_productos);
		btn_busqueda_productos.setToolTipText("Buscar Productos\r\n");
		btn_busqueda_productos.setBackground(null);
		btn_busqueda_productos.setBorderPainted(false);
		btn_busqueda_productos.setContentAreaFilled(false);
		btn_busqueda_productos.setOpaque(false);

		Boton btn_busqueda_factura = new Boton("",pantallaMenu,25+40,170,100,75);
		ImageIcon facturaIcon =  new ImageIcon((temaFlag)?"Img\\FacturaClaro.png":"Img\\FacturaOscuro.png"); //Las rutas relativas no estan sirviendo
		Icon iconFactura = new ImageIcon(facturaIcon.getImage().getScaledInstance(
				btn_busqueda_factura.getWidth(), btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btn_busqueda_factura.setIcon(iconFactura);
		btn_busqueda_factura.setToolTipText("Factura\r\n");
		btn_busqueda_factura.setBackground(null);
		btn_busqueda_factura.setBorderPainted(false);
		btn_busqueda_factura.setContentAreaFilled(false);
		btn_busqueda_factura.setOpaque(false);

		Boton btn_pedidos = new Boton("",pantallaMenu,40+100+50,170,100,75);
		ImageIcon pedidosIcon =  new ImageIcon((temaFlag) ? "Img\\PedidoClaro.png":"Img\\PedidoOscuro.png"); //Las rutas relativas no estan sirviendo
		Icon iconPedidos = new ImageIcon(pedidosIcon.getImage().getScaledInstance(
				btn_pedidos.getWidth(), btn_pedidos.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btn_pedidos.setIcon(iconPedidos);
		btn_pedidos.setToolTipText("Pedidos\r\n");
		btn_pedidos.setBackground(null);
		btn_pedidos.setBorderPainted(false);
		btn_pedidos.setContentAreaFilled(false);
		btn_pedidos.setOpaque(false);

		Boton btn_inventario = new Boton("",pantallaMenu,40+2*100+75,70,100,75);
		//ImageIcon btn_inventario_Icon =  new ImageIcon((temaFlag)?"Img\\InventarioClaro.png":"Img\\InventarioOscuro.png"); //Las rutas relativas no estan sirviendo
		Icon icon_btn_inventario = new ImageIcon((new ImageIcon((temaFlag)?"Img\\InventarioClaro.png":"Img\\InventarioOscuro.png")).getImage().getScaledInstance(
				btn_inventario.getWidth(), btn_inventario.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btn_inventario.setIcon(icon_btn_inventario);
		btn_inventario.setToolTipText("Inventario\r\n");
		btn_inventario.setBackground(null);
		btn_inventario.setBorderPainted(false);
		btn_inventario.setContentAreaFilled(false);
		btn_inventario.setOpaque(false);
		

		Boton boton_usuario = new Boton("",pantallaMenu,40+2*100+75,170,100,75);
		boton_usuario.setVisible(flag);
		ImageIcon boton_usuario_Icon =  new ImageIcon((temaFlag)?"Img\\UsuarioClaro.png":"Img\\UsuarioOscuro.png"); //Las rutas relativas no estan sirviendo
		Icon icon_boton_usuario = new ImageIcon(boton_usuario_Icon.getImage().getScaledInstance(
				boton_usuario.getWidth()-20, boton_usuario.getHeight()-10, Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		boton_usuario.setIcon(icon_boton_usuario);
		boton_usuario.setToolTipText("Usuario\r\n");
		boton_usuario.setBackground(null);
		boton_usuario.setBorderPainted(false);
		boton_usuario.setContentAreaFilled(false);
		boton_usuario.setOpaque(false);

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
				Producto productoDetalles = Ejecucion.inventario.encontrar(n).getDato();
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
				int n = -1;
				String entrada;

				while(n == -1) {
					entrada = JOptionPane.showInputDialog(pantallaMenu,"Ingrese numero de la factura","Busqueda de Factura");
					try {
						n = (entrada==null)?-2:(entrada.equals("Busqueda de Factura"))?-1:Integer.valueOf(entrada);
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(pantallaMenu,"Entrada inv\u00e1lida","Solo n\u00fameros p\u00f3sitivos v\u00e1lidos",JOptionPane.ERROR_MESSAGE);
					}

				}

				Factura nuevaFactura = Ejecucion.facturas.encontrar(n).getDato();
				if(nuevaFactura!=null) {
					pantallaMenu.desactivar();
					VerFactura.main("menu",nuevaFactura);
				}else {
					if(n!=-2)JOptionPane.showMessageDialog(pantallaMenu,"Factura no encontrada","ID no v\u00e1lido",JOptionPane.ERROR_MESSAGE);
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

				btnCarrito.setIcon(new ImageIcon(new ImageIcon((temaFlag)?"Img\\CarritoOscuro.png":"Img\\CarritoClaro.png")
						.getImage().getScaledInstance(btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING))); //Cambio icono de carrito
				btn_busqueda_factura.setIcon(new ImageIcon(new ImageIcon((temaFlag)?"Img\\FacturaOscuro.png":"Img\\FacturaClaro.png")
						.getImage().getScaledInstance(btn_busqueda_factura.getWidth(), btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)));
				btn_pedidos.setIcon(new ImageIcon(new ImageIcon((temaFlag)?"Img\\PedidoOscuro.png":"Img\\PedidoClaro.png")
						.getImage().getScaledInstance(btn_pedidos.getWidth(), btn_pedidos.getHeight(), Image.SCALE_AREA_AVERAGING)));
				
				btn_inventario.setIcon(new ImageIcon((new ImageIcon((!temaFlag)?"Img\\InventarioClaro.png":"Img\\InventarioOscuro.png")).getImage().getScaledInstance(
						btn_inventario.getWidth(), btn_inventario.getHeight(), Image.SCALE_AREA_AVERAGING)));
				
				btn_busqueda_productos.setIcon(new ImageIcon((new ImageIcon((!temaFlag)?"Img\\BuscarProductoClaro.png":"Img\\BuscarProductoOscuro.png")).getImage().getScaledInstance(
						btn_busqueda_productos.getWidth(), btn_busqueda_productos.getHeight(), Image.SCALE_AREA_AVERAGING)));
				
				boton_usuario.setIcon(new ImageIcon((new ImageIcon((!temaFlag)?"Img\\UsuarioClaro.png":"Img\\UsuarioOscuro.png")).getImage().getScaledInstance(
						boton_usuario.getWidth()-20, boton_usuario.getHeight()-10, Image.SCALE_AREA_AVERAGING)));
				
				
				//btn_inventario_Icon.s
				
				
				//btn_inventario.setIcon(new ImageIcon((temaFlag)?"Img\\InventarioOscuro.png":"Img\\InventarioClaro.png"));
				
				//pedidosIcon.setImage((temaFlag) ? "Img\\PedidoClaro.png":"Img\\PedidoOscuro.png");
				
				//pedidosIcon.set
				
				//((temaFlag) ? "Img\\InventarioClaro.png":"Img\\InventarioOscuro.png");
				
				
				
				/*
				ImageIcon pedidosIcon =  new ImageIcon((temaFlag) ? "Img\\PedidoClaro.png":"Img\\PedidoOscuro.png");
				 
		        Icon iconPedidos = new ImageIcon(
		        pedidosIcon.getImage().getScaledInstance(
		        
		        btn_pedidos.getWidth()-20, 
		        btn_pedidos.getHeight(), 
		        Image.SCALE_AREA_AVERAGING
		        
		        )
		        );
				
				*/
				
				temaFlag = (Ejecucion.Tema==Ejecucion.ModoClaro);

			}
		});
	

	}
}
