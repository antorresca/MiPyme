package interfaz;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import datos.Factura;
import logica.Ejecucion;

public class PantallaMenu {

	public static boolean flag = false;
	
	public static void main(String[] args) {

		Ventana pantallaMenu = new Ventana("Menu"); 
		pantallaMenu.setBackground(Ejecucion.Tema);

		Imagen logoAppClaro = new Imagen("Img\\LogoClaro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo claro
		Imagen logoAppOscuro = new Imagen("Img\\LogoOscuro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo Oscuro
		logoAppOscuro.setVisible(false);
		
		Texto NombreUsuario = new Texto("Bienvenido, " + PantallaInicio.textoUsuario,pantallaMenu,30, 10, 150,30);

		//Botones del menu

		Boton BtnCerrarSesion = new Boton("Cerrar Sesion", pantallaMenu, 130, 240, 200, 50);
		
		Boton btnCarrito = new Boton("",pantallaMenu,38,71,98,74);
		ImageIcon carritoIcon =  new ImageIcon("Img\\CarritoClaro.png"); //Las rutas relativas no estan sirviendo
		Icon iconCarrito = new ImageIcon(carritoIcon.getImage().getScaledInstance(
				btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btnCarrito.setIcon(iconCarrito);
		btnCarrito.setToolTipText("Carrito\r\n");
		btnCarrito.setBackground(null);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setOpaque(false);

		Boton btn_busqueda_factura = new Boton("",pantallaMenu,0,156,200,74);
		ImageIcon facturaIcon =  new ImageIcon("Img\\FacturaClaro.png"); //Las rutas relativas no estan sirviendo
		Icon iconFactura = new ImageIcon(facturaIcon.getImage().getScaledInstance(
				70, btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btn_busqueda_factura.setIcon(iconFactura);
		btn_busqueda_factura.setToolTipText("Factura\r\n");
		btn_busqueda_factura.setBackground(null);
		btn_busqueda_factura.setBorderPainted(false);
		btn_busqueda_factura.setContentAreaFilled(false);
		btn_busqueda_factura.setOpaque(false);

		Boton btn_pedidos = new Boton("",pantallaMenu,146,71,98,74);
		ImageIcon pedidosIcon =  new ImageIcon("Img\\PedidoClaro.png"); //Las rutas relativas no estan sirviendo
		Icon iconPedidos = new ImageIcon(pedidosIcon.getImage().getScaledInstance(
				70, btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		btn_pedidos.setIcon(iconPedidos);
		btn_pedidos.setToolTipText("Factura\r\n");
		btn_pedidos.setBackground(null);
		btn_pedidos.setBorderPainted(false);
		btn_pedidos.setContentAreaFilled(false);
		btn_pedidos.setOpaque(false);

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
		
		Boton btnregistro = new Boton("Registrar", pantallaMenu, 365, 150, 100, 25);
		btnregistro.setVisible(flag);
		
		//Metodo botones
		
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
				if (btnTema.getText().contains("CLARO")){ //Verificacion de tema actual de la pantalla

					/*
					 * Actualizacion de variables
					 */

					btnTema.setText("OSCURO"); //Cambio de bandera de tema
					btnTema.setIcon(iconOscuro);

					logoAppClaro.setVisible(false); //Cambio de logo
					logoAppOscuro.setVisible(true); //""
					
					Ejecucion.Tema = Ejecucion.ModoOscuro;
					pantallaMenu.getContenedor().setBackground(Ejecucion.Tema); //Cambio de color de fondo

					btnCarrito.setIcon(new ImageIcon(new ImageIcon("Img\\CarritoOscuro.png")
							.getImage().getScaledInstance(btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING))); //Cambio icono de carrito
					btn_busqueda_factura.setIcon(new ImageIcon(new ImageIcon("Img\\FacturaOscuro.png")
							.getImage().getScaledInstance(70, btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)));
					btn_pedidos.setIcon(new ImageIcon(new ImageIcon("Img\\PedidoOscuro.png")
							.getImage().getScaledInstance(70, btn_pedidos.getHeight(), Image.SCALE_AREA_AVERAGING)));
				}else {

					/*
					 * Actualizacion de variables
					 */

					btnTema.setText("CLARO"); //Cambio de bandera de tema
					btnTema.setIcon(iconClaro);

					logoAppClaro.setVisible(true); //Cambio de logo
					logoAppOscuro.setVisible(false); //""
					
					Ejecucion.Tema = Ejecucion.ModoClaro;
					pantallaMenu.getContenedor().setBackground(Ejecucion.Tema); //Cambio color de fondo

					btnCarrito.setIcon(new ImageIcon(new ImageIcon("Img\\CarritoClaro.png")
							.getImage().getScaledInstance(btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING))); //Cambio icono de carrito
					btn_busqueda_factura.setIcon(new ImageIcon(new ImageIcon("Img\\FacturaClaro.png")
							.getImage().getScaledInstance(70, btn_busqueda_factura.getHeight(), Image.SCALE_AREA_AVERAGING)));
					btn_pedidos.setIcon(new ImageIcon(new ImageIcon("Img\\PedidoClaro.png")
							.getImage().getScaledInstance(70, btn_pedidos.getHeight(), Image.SCALE_AREA_AVERAGING)));
				}

			}
		});
	

	}
}
