package logica;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import interfaz.PantallaCargando;
import datos.Factura;
import datos.Producto;
import datos.Usuario;
import estructuras.*;
import interfaz.PantallaInicio;
import interfaz.PantallaMenu;

public class Ejecucion {

	public static boolean temaFlag = (Ejecucion.Tema == Ejecucion.ModoClaro);
	private static String registroUsuariotxt;
	public static Usuario usuario_admin = new Usuario("Admin","12345");
	public static Color ModoClaro = new Color(225,237,249); 
	public static Color ModoOscuro = new Color(20,31,59);
	public static Color Tema = ModoClaro;
	public static Arbol_avl<Producto> inventario = new Arbol_avl<Producto>();
	public static Agenda_hashing facturas = new Agenda_hashing();
	public static Cola_ref_simple<Factura> pedidos = new Cola_ref_simple<Factura>();
	public static Lista_ref_simple<Producto> compra = new Lista_ref_simple<Producto>();
	public static Arbol_avl<Usuario> usuarios = new Arbol_avl<Usuario>(); 
	//-------------------------------------------------------ICONOS------------------------------------------------

	static PantallaCargando screen;

	  private static void inicioPantalla() {
	    ImageIcon myImage = new ImageIcon(new ImageIcon(
	    		"Img\\LogoOscuro.jpeg").getImage().getScaledInstance( 300, 200, Image.SCALE_AREA_AVERAGING));
	    screen = new PantallaCargando(myImage);
	    screen.setLocationRelativeTo(null);
	    screen.setProgresoMax(100);
	    screen.setVisible(true);
	  }
	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) throws InterruptedException {
		Thread hilo = new Thread(new Runnable() {
			public void run() {
				PantallaMenu.cargar();
			}
		});
		hilo.start();
		inicioPantalla();
		screen.velocidadDeCarga();	
		usuario_admin.setAdmin(true);
		usuarios.insertar(usuario_admin);
		usuarios.insertar(new Usuario("A","1", true));


		//-----------------------------------------------OBTENCION DE DATOS------------------------------------------------------
		/*String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		compra.agregar(new Producto(0, "", "", 0, "", 0));
		int j = 0;
		int k=0;
		for(k=0;k<100000000;k++) {
			j = (int) (Math.random()*26);
			facturas.agregar(new Factura(alfabeto[j], j*k, alfabeto[j]+alfabeto[j], registroUsuariotxt, new Usuario(alfabeto[j]+String.valueOf(k),String.valueOf(k)), compra));
		}
		long inicial = System.nanoTime();
		facturas.buscar(j*k);
		System.out.print(System.nanoTime()-inicial);
		 */
		//--------------------------------------------TILDES--------------------------------------------------------------
		/*
		        \u00e1 = á
				\u00e9 = é
				\u00ed = í
				\u00f3 = ó
				\u00fa = ú
				\u00c1 = Á
				\u00c9 = É
				\u00cd = Í
				\u00d3 = Ó
				\u00da = Ú
				\u00f1 = ñ
				\u00d1 = Ñ
		 */
		//--------------------------------------------PLANTILLAS-----------------------------------------------------------
		/*

		//Ventanas emergentes

		JOptionPane.showMessageDialog(La_ventana,"mensaje","Título",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(La_ventana,"mensaje","Título",JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(La_ventana,"mensaje","Título",JOptionPane.ERROR_MESSAGE);

		if(JOptionPane.showConfirmDialog(contentPane, "Mensaje", "Título", JOptionPane.YES_NO_OPTION) == 0) {

		    //Lo que hace en caso de "YES"
		}

		//Ventana emergente para guardar un usuario o contraseña

		String cadena_texto = JOptionPane.showInputDialog(La_ventana,"mesaje", "titulo");

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
		//--------------------------------------------INSTANCIACIONES-----------------------------------------------------------

		Thread hilo2 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i<1000;i++) {
					inventario.insertar(new Producto(i,"Producto "+String.valueOf(i),"Este producto es...",(long) (Math.random()*10000),null,(int) (Math.random()*10)));
				}
			}
		});
		hilo2.start();


		//--------------------------------------------EJECUCIÓN DE INTERFAZ-----------------------------------------------------------
		PantallaInicio.main(null);	

	}
}

