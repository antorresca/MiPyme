package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import datos.Producto;

public class PantallaModificarProducto {
	static void main(Producto producto) {

		Ventana pantallaModificarP = new Ventana("Modificar Producto");

		Boton btnAceptar = new Boton("Aceptar",pantallaModificarP,77, 141, 89, 23);

		Boton btnCancelar = new Boton("Cancelar",pantallaModificarP,77, 175, 89, 23);
		

		Texto lblId = new Texto("ID",pantallaModificarP,25, 25+40, 85, 37);

		Texto lblNombre = new Texto("Nuevo Nombre",pantallaModificarP,25, 63+40, 118, 14);
				
		Texto lblPrecio = new Texto("Actualizar Precio",pantallaModificarP,25, 86+40, 85, 37);

		Texto lblDescripción = new Texto("Nueva Descripción",pantallaModificarP,25, 124+40, 118, 14);
		
		//Texto lblImagen = new Texto("Nueva Imagen",pantallaModificarP,25, 73+40, 118, 14);
		
		Texto lblCantidad = new Texto("Actualizar Cantidad",pantallaModificarP,25, 162+40, 118, 14);
		
	

		CampoL textField_Id = new CampoL(pantallaModificarP,153, 33, 86, 20);
		textField_Id.setText(producto.getId());
		textField_Id.setEnabled(false);
		
		CampoL textField_Nombre = new CampoL(pantallaModificarP,153, 60, 86, 20);
		textField_Nombre.setText(producto.getNo());
		
		CampoL textField_Precio  = new CampoL(pantallaModificarP,153, 87, 86, 20);
		textField_Precio.setText(String.valueOf(producto.getPre()));
		
		CampoL textField_Descripcion = new CampoL(pantallaModificarP,153, 114, 86, 20);
		textField_Descripcion.setText(producto.getDes());
		
		//CampoL textField_Imagen = new CampoL(pantallaModificar,153, 33, 86, 20);
		//textField_Imagen.setText(producto.getIm());
		
		CampoL textField_Cantidad = new CampoL(pantallaModificarP,153, 141, 86, 20);
		textField_Cantidad.setText(String.valueOf(producto.getCan()));

		

		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				producto.setNo(textField_Nombre.getText());
				producto.setPre(Long.valueOf(textField_Precio.getText()));
				producto.setDes(textField_Descripcion.getText());
				producto.setCan(Integer.valueOf(textField_Cantidad.getText()));
				JOptionPane.showMessageDialog(pantallaModificarP,"Producto modificado correctamente","\u00c9xito",JOptionPane.INFORMATION_MESSAGE);
				pantallaModificarP.setVisible(false);
				PantallaUsuarios.main(null);
			}
		});

		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaModificarP.setVisible(false);
				PantallaUsuarios.main(null);
			}
		});






	}
}
