package interfaz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import datos.Producto;
import logica.Ejecucion;

public class PantallaModificarProducto {
	static void main(Producto producto, boolean anadir) {

		Ventana pantallaModificarP = new Ventana(((anadir)?"Agregar " :"Modificar ")+ "Producto");
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensions = t.getScreenSize();
		pantallaModificarP.setBounds((dimensions.width-378)/2,(dimensions.height-408)/2,378,408);

		Boton btnAceptar = new Boton("Aceptar",pantallaModificarP,126, 284, 89, 23);

		Boton btnCancelar = new Boton("Cancelar",pantallaModificarP,126, 314, 89, 23);
		
		Texto titulo = new Texto(((anadir)?"Agregar " :"Modificar ")+ "Producto",pantallaModificarP,27, 25+40, 325, 14);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		Texto lblId = new Texto("ID",pantallaModificarP,27, 74+40, 121, 14);

		Texto lblNombre = new Texto( ((anadir)?"" :"Nuevo ") +"Nombre",pantallaModificarP,27, 99+40, 121, 14);
				
		Texto lblPrecio = new Texto(((anadir)?"" :"Actualizar ")+"Precio",pantallaModificarP,27, 124+40, 121, 14);

		Texto lblDescripción = new Texto(((anadir)?"" :"Nueva ")+"Descripción",pantallaModificarP,27, 174+40, 96, 14);
				
		Texto lblCantidad = new Texto(((anadir)?"" :"Actualizar ")+"Cantidad",pantallaModificarP,27, 149+40, 121, 14);
	

		CampoL textField_Id = new CampoL(pantallaModificarP,158, 71, 194, 20);
		textField_Id.setText(((anadir)? String.valueOf(producto.getId()+1) : String.valueOf(producto.getId())));
		textField_Id.setEnabled(false);
		
		CampoL textField_Nombre = new CampoL(pantallaModificarP,158, 96, 194, 20);
		textField_Nombre.setText(producto.getNo());
		
		CampoL textField_Precio  = new CampoL(pantallaModificarP,158, 121, 194, 20);
		textField_Precio.setText(String.valueOf(producto.getPre()));
		
		//CampoL textField_Descripcion = new CampoL(pantallaModificarP,153, 114, 86, 20);
		//textField_Descripcion.setText(producto.getDes());
		
		CampoA textField_Descripcion = new CampoA(pantallaModificarP,158, 174, 194, 66);
		textField_Descripcion.setText(producto.getDes());
		
		textField_Descripcion.setLineWrap(true);
		textField_Descripcion.setWrapStyleWord(true);
		
		//CampoL textField_Imagen = new CampoL(pantallaModificar,153, 33, 86, 20);
		//textField_Imagen.setText(producto.getIm());
		
		CampoL textField_Cantidad = new CampoL(pantallaModificarP,158, 146, 194, 20);
		textField_Cantidad.setText(String.valueOf(producto.getCan()));

		

		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				producto.setNo(textField_Nombre.getText());
				producto.setPre(Long.valueOf(textField_Precio.getText()));
				producto.setDes(textField_Descripcion.getText());
				producto.setCan(Integer.valueOf(textField_Cantidad.getText()));
				if(anadir) {
					producto.setId(++Producto.ultimoId);
					Ejecucion.inventario.insertar(producto);
				}
				JOptionPane.showMessageDialog(pantallaModificarP,"Producto "+ ((anadir)?"a\u00f1adido" :"modificado") +" correctamente","\u00c9xito",JOptionPane.INFORMATION_MESSAGE);
				pantallaModificarP.setVisible(false);
				PantallaInventario.main(null);
			}
		});

		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaModificarP.setVisible(false);
				PantallaInventario.main(null);
			}
		});






	}
}
