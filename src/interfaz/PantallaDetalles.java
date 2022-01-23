package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import logica.Ejecucion;

public class PantallaDetalles {

	public static void main(String[] args) {
		Ventana detalles = new Ventana("Detalles");
		detalles.activar();

		/*
		 * Elementos de ventana
		 */

		Imagen imgProducto = new Imagen("Img\\shopping-cart (4).png"
				,detalles,0,40,345-detalles.getWidth()/2,detalles.getHeight()/2); //Imagen de prueba

		String nombre = Ejecucion.inventario.encontrar(PantallaCarrito.list.getSelectedIndex()).getDato().getNo(); //Nombre de producto
		Texto nombrePro = new Texto(nombre, detalles,0,40+imgProducto.getHeight(),detalles.getWidth(),15);

		String descripcion = Ejecucion.inventario.encontrar(PantallaCarrito.list.getSelectedIndex()).getDato().getDes(); //Descripcion de producto
		Texto desPro = new Texto(descripcion, detalles,0,40+imgProducto.getHeight()+15,detalles.getWidth(),15);

		String precioP = String.valueOf(Ejecucion.inventario.encontrar(PantallaCarrito.list.getSelectedIndex()).getDato().getPre()); //Precio de producto
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
				PantallaCarrito.main(null);
			}
		});

		elimarPro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String producto = PantallaCarrito.list.getSelectedValue().toString().split(" | ")[0]; //Nombre del producto

				if(JOptionPane.showConfirmDialog(detalles, "Eliminar "+
						producto+ "?", "Elimacion completada", JOptionPane.YES_NO_OPTION) == 0) { //Eliminacion de producto
					/*
					 * Actualizacion de variables globales
					 */

					Ejecucion.inventario.eliminar_en(PantallaCarrito.list.getSelectedIndex());

					PantallaCarrito.modelo.removeElementAt(PantallaCarrito.list.getSelectedIndex());	

					PantallaCarrito.pagoCarrito.setText(String.valueOf(PantallaCarrito.precio));

					PantallaCarrito.prodCarrito.setText(String.valueOf(PantallaCarrito.i));

					JOptionPane.showMessageDialog(detalles,"Producto eliminado",
							"Elimacion completada",JOptionPane.INFORMATION_MESSAGE); //Mensaje informativo

					detalles.desactivar(); //Salida de ventana
					PantallaCarrito.main(null);
				}}});


		
	}
	
}
