package logica;

import java.awt.Color;
import datos.Factura;
import datos.Producto;
import datos.Usuario;
import estructuras.*;
import interfaz.PantallaInicio;

public class Ejecucion {

	private static String registroUsuariotxt;
	public static Usuario usuario_admin = new Usuario("Admin","12345");
	public static Color ModoClaro = new Color(225,237,249); 
	public static Color ModoOscuro = new Color(20,31,59);
	public static Color Tema = ModoClaro;
	public static Lista_ref_simple<Producto> inventario = new Lista_ref_simple<Producto>();
	public static Lista_ref_simple<Factura> facturas = new Lista_ref_simple<Factura>();
	public static Cola_ref_simple<Factura> pedidos = new Cola_ref_simple<Factura>();
	public static Lista_ref_simple<Producto> compra = new Lista_ref_simple<Producto>();
	//public static Arbol_binario<Usuario> usuarios = new Arbol_binario<Usuario>(); 
	public static Arbol_avl<Usuario> usuarios = new Arbol_avl<Usuario>(); 
	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) {
		usuario_admin.setAdmin(true);
		usuarios.insertar(usuario_admin);
		usuarios.insertar(new Usuario("A","1"));
		//-----------------------------------------------OBTENCION DE DATOS------------------------------------------------------
		/*String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		int j = 0;
		int k=0;
		for(k=0;k<10000000;k++) {
			j = (int) Math.random()*27;
			usuarios.agregarA(new Usuario(alfabeto[j]+String.valueOf(k),String.valueOf(k)));
		}
		long inicial = System.nanoTime();
		usuarios.eliminarD(new Usuario(alfabeto[j]+String.valueOf(j),String.valueOf(k)));
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
		//--------------------------------------------INSTANCIACIONES-----------------------------------------------------------


		for(int i = 0; i<1000;i++) {
			inventario.agregar(new Producto(String.valueOf(i),"Producto "+String.valueOf(i),"Este producto es...",(long) (Math.random()*10000),null,(int) (Math.random()*10)));
		}
		

		//--------------------------------------------EJECUCIÓN DE INTERFAZ-----------------------------------------------------------

		PantallaInicio.main(null);

			
	}
	}

