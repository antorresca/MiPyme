package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import datos.Usuario;

public class PantallaModificarUsuario {
	
	static void main(Usuario a) {
		
		Ventana pantallaModificar = new Ventana("Modificar Usuarios");
		
		Boton btnAceptar = new Boton("Aceptar",pantallaModificar,77, 141, 89, 23);
		
		Boton btnCancelar = new Boton("Cancelar",pantallaModificar,77, 175, 89, 23);
		
		Texto lblNewLabel = new Texto("Nuevo Usuario",pantallaModificar,25, 25+40, 85, 37);
		
		Texto lblNewLabel_1 = new Texto("Nuevo Contrasena",pantallaModificar,25, 73+40, 118, 14);
		
		JCheckBox comprobarAdmin = new JCheckBox("Admin");
		comprobarAdmin.setSelected(a.isAdmin());
		comprobarAdmin.setBounds(153, 106, 86, 23);
		pantallaModificar.getContenedor().add(comprobarAdmin);
			
		
		CampoL textField = new CampoL(pantallaModificar,153, 33, 86, 20);
		textField.setText(a.getUsuario());
		
		CampoL textField_1 = new CampoL(pantallaModificar,153, 70, 86, 20);
		textField_1.setText(a.getContrasena());
		
		btnAceptar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			a.setUsuario(textField.getText());
			a.setContrasena(textField_1.getText());
			a.setAdmin(comprobarAdmin.isSelected());
			JOptionPane.showMessageDialog(pantallaModificar,"Usuario modificado correctamente","\u00c9xito",JOptionPane.INFORMATION_MESSAGE);
			pantallaModificar.setVisible(false);
			PantallaUsuarios.main(null);
		}
		});
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaModificar.setVisible(false);
				PantallaUsuarios.main(null);
			}
		});
		
		
		
		
				
		
	}

}
