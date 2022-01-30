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
import logica.Ejecucion;

public class PantallaMenu {

	public static boolean flag = false;
	public static boolean temaFlag = (Ejecucion.Tema==Ejecucion.ModoClaro);
	
	public static void main(String[] args) {
		
		Ejecucion.usuarios.imprimir(Ejecucion.usuarios.getRaiz());

		Ventana pantallaMenu = new Ventana("Menu"); 
		pantallaMenu.setBackground(Ejecucion.Tema);

		Imagen logoAppClaro = new Imagen("Img\\LogoClaro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo claro
		Imagen logoAppOscuro = new Imagen("Img\\LogoOscuro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo Oscuro
		logoAppOscuro.setVisible((temaFlag)?false:true);
		logoAppClaro.setVisible((temaFlag)?true:false);
		
		Texto NombreUsuario = new Texto("Bienvenido, " + PantallaInicio.textoUsuario,pantallaMenu,30, 10, 150,30);

		//Botones del menu

		Boton BtnCerrarSesion = new Boton("Cerrar Sesion", pantallaMenu, 130, 240, 200, 50);
		
		Boton btnCarrito = new Boton("",pantallaMenu,38,71,98,74);
		ImageIcon carritoIcon =  new ImageIcon((temaFlag)?"Img\\CarritoClaro.png":"Img\\CarritoOscuro.png"); //Las rutas relativas no estan sirviendo
		Icon iconCarrito = new ImageIcon(carritoIcon.getImage().getScaledInstance(
				btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btnCarrito.setIcon(iconCarrito);
		btnCarrito.setToolTipText("Carrito\r\n");
		btnCarrito.setBackground(null);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setOpaque(false);
		
		Boton btn_busqueda_productos = new Boton("Busqueda Productos",pantallaMenu,146,71,98,74);

		Boton btn_busqueda_factura = new Boton("",pantallaMenu,0,156,200,74);
		ImageIcon facturaIcon =  new ImageIcon((temaFlag)?"Img\\FacturaClaro.png":"Img\\FacturaOscuro.png"); //Las rutas relativas no estan sirviendo
		Icon iconFactura = new ImageIcon(facturaIcon.getImage().getScaledInstance(
				70, btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btn_busqueda_factura.setIcon(iconFactura);
		btn_busqueda_factura.setToolTipText("Factura\r\n");
		btn_busqueda_factura.setBackground(null);
		btn_busqueda_factura.setBorderPainted(false);
		btn_busqueda_factura.setContentAreaFilled(false);
		btn_busqueda_factura.setOpaque(false);

		Boton btn_pedidos = new Boton("",pantallaMenu,146,156,98,74);
		ImageIcon pedidosIcon =  new ImageIcon((temaFlag)?"Img\\PedidoClaro.png":"Img\\PedidoOscuro.png"); //Las rutas relativas no estan sirviendo
		Icon iconPedidos = new ImageIcon(pedidosIcon.getImage().getScaledInstance(
				70, btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btn_pedidos.setIcon(iconPedidos);
		btn_pedidos.setToolTipText("Pedidos\r\n");
		btn_pedidos.setBackground(null);
		btn_pedidos.setBorderPainted(false);
		btn_pedidos.setContentAreaFilled(false);
		btn_pedidos.setOpaque(false);

		Boton btn5 = new Boton("Opcion 5",pantallaMenu,254,71,98,74);

		Boton btn6 = new Boton("Usuarios",pantallaMenu,254,156,98,74);
		btn6.setVisible(flag);

		JToggleButton btnTema = new JToggleButton(""); //BotÃ³n de seleccion de tema
		btnTema.setCursor(new Cursor(JFrame.HAND_CURSOR));	
		btnTema.setBounds(374, 11, 80, 80);
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
		
		Boton btnregistro = new Boton("Registrar", pantallaMenu, 365, 150, 100, 25);
		btnregistro.setVisible(false);
		
		//Metodo botones
		
		btn_busqueda_productos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				int n = -1;
				while(n == -1) {
					//entrada = JOptionPane.showInputDialog(pantallaMenu,"Ingrese numero de la factura","Busqueda de Factura");
					try {
						//n = (entrada==null)?-2:(entrada.equals("Busqueda de Factura"))?-1:Integer.valueOf(entrada);
					}catch(Exception except) {
						JOptionPane.showMessageDialog(pantallaMenu,"Entrada invalida","Solo numeros validos",JOptionPane.ERROR_MESSAGE);
					}

				}
			}
			});
		
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				pantallaMenu.setVisible(false);
				PantallaUsuarios.main(null);
			}
			});
		
		btnregistro.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaMenu.setVisible(false);
				PantallaRegistro.main(null);
			}});
		
		btn_busqueda_factura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaMenu.desactivar();
				PantallaFactura.flag = false;
				PantallaFactura.main(null);
				
			}
		});


		BtnCerrarSesion.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(pantallaMenu, "¿Seguro que deseas cerrar sesi\u00f3n?", "¿Seguro?", JOptionPane.YES_NO_OPTION) == 0) { //Eliminacion de producto
					/*
					 * Actualizacion de variables globales
					 */

					JOptionPane.showMessageDialog(pantallaMenu,"Sesi\u00f3n Cerrada",
							"Sesi\u00f3n Cerrada",JOptionPane.INFORMATION_MESSAGE); //Mensaje informativo

					pantallaMenu.desactivar(); //Salida de ventana
					PantallaInicio.main(null);
					btnregistro.setVisible(false);

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
						.getImage().getScaledInstance(70, btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)));
				btn_pedidos.setIcon(new ImageIcon(new ImageIcon((temaFlag)?"Img\\PedidoOscuro.png":"Img\\PedidoClaro.png")
						.getImage().getScaledInstance(70, btn_pedidos.getHeight(), Image.SCALE_AREA_AVERAGING)));
				temaFlag = (Ejecucion.Tema==Ejecucion.ModoClaro);

			}
		});
	

	}
}
