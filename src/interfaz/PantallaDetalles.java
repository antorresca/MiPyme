package interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import datos.Producto;
import logica.Ejecucion;

public class PantallaDetalles {

	public static void main(String anterior,Producto temp) {
		Ventana detalles = new Ventana("Detalles");
		detalles.activar();
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensions = t.getScreenSize();
		detalles.setBounds((dimensions.width-283)/2,(dimensions.height-474)/2,283,474);

		/*
		 * Elementos de ventana
		 */
		
		Texto cantidadProducto = new Texto("<Cantidad>",detalles,96, 395, 161, 14);
				
		Texto precioProducto = new Texto("<Precio>",detalles,96, 419, 161, 14);
				
		Texto nombreProducto = new Texto("<Nombre>",detalles,82, 108, 104, 14);
				
		Texto descripcion = new Texto("Descripci\u00F3n:",detalles,10, 313, 161, 14);
		
		Texto nombre = new Texto("Nombre:",detalles,10, 108, 50, 14);
		
		Texto id = new Texto("ID:",detalles,10, 93, 46, 14);
		
		Texto idProducto = new Texto("<Id>",detalles,82, 93, 46, 14);
		
		Texto cantidad = new Texto("Cantidad:",detalles,10, 395, 81, 14);
		
		Texto lblNewLabel_2_1 = new Texto("Precio:",detalles,10, 419, 81, 14);
		
		String ruta = temp.getIm();
		if(ruta==null)ruta=(Ejecucion.Tema==Ejecucion.ModoClaro)?"Img\\NoImagenOscuro.png":"Img\\NoImagenClaro.png";
		Imagen imgProducto = new Imagen(ruta,detalles,(283/2)-75, 133, 150, 150); //Imagen de prueba
		
		JTextPane descripcionProducto = new JTextPane();
		descripcionProducto.setBounds(10, 291, 247, 53);
		descripcionProducto.setText(temp.getDes());
		descripcionProducto.setEnabled(false);
		JScrollPane scroll = new JScrollPane(descripcionProducto);
		scroll.setBounds(10, 291, 247, 53);
		scroll.setBackground(null);
		detalles.getContenedor().add(scroll);
		
		
		nombreProducto.setText(temp.getNo());
		
		precioProducto.setText("$"+String.valueOf(temp.getPre()));
		
		idProducto.setText(temp.getId());
		
		cantidadProducto.setText(String.valueOf(temp.getCan()));

		Boton regresar = new Boton("Regresar",detalles,10, 13, 89, 23);

		/*
		 * Evento de botones
		 */

		regresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				detalles.desactivar();
				switch(anterior) {
				case "menu":
					PantallaMenu.main(null);
				case "carrito":				
					PantallaCarrito.main(null);
				case "inventario":
					PantallaInventario.main(null);
				}
			}
		});
	}
	
}
