package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import datos.Usuario;
import logica.Ejecucion;

public class PantallaRegistro {

	public static void main(String[] args) {
		
		Ventana pantallaRegistro = new Ventana("Mi PYME - Registro");
		pantallaRegistro.setBackground(Ejecucion.Tema);
		
		JTextField registroUsuario = new JTextField(20);
		registroUsuario.setBounds(225,120,165,25);
		pantallaRegistro.getContenedor().add(registroUsuario);

		JTextField registroContrasena = new JTextField(20);
		registroContrasena.setBounds(225,150,165,25);
		pantallaRegistro.getContenedor().add(registroContrasena);

		Texto LabelRegistroU = new Texto("Escriba su usuario",pantallaRegistro,90, 155, 130, 35);

		Texto LabelRegistroC = new Texto("Escriba su contrasena",pantallaRegistro,80, 185, 150, 35);

		Texto LabelSuccess = new Texto("",pantallaRegistro,90, 285, 300, 35);		

		//Botones Registro 

		Boton BtnRegistrar = new Boton("Crear", pantallaRegistro, 255, 200, 100, 25);

		Boton BtnVolver = new Boton("Regresar", pantallaRegistro, 130, 200, 100, 25);
		
		//Metodos Botones
		
		BtnRegistrar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {

				String registro_usuario = registroUsuario.getText();
				String registro_contrasenia = registroContrasena.getText();



				if (registro_contrasenia.equals("") && registro_usuario.equals("")) {

					LabelSuccess.setText("Por favor, llene los espacios en blanco");

				}


				else if(registro_usuario.equals("")) {

					LabelSuccess.setText("Por favor ingrese su usuario");

				}

				else if (registro_contrasenia.equals("")) {

					LabelSuccess.setText("Ingrese la contrasena");

				}

				else if(!"".equals(registro_usuario) && !"".equals(registro_contrasenia)) {

					JOptionPane.showMessageDialog(pantallaRegistro,"Creaci�n de usuario exitosa","Exitoso",JOptionPane.INFORMATION_MESSAGE);
					pantallaRegistro.setVisible(false);
					PantallaMenu.main(null);

					Ejecucion.usuarios.agregarA(new Usuario(registro_usuario,registro_contrasenia));
					//usuarios.agregar(new Usuario(registro_usuario,registro_contrasenia));

					registroUsuario.setText("");
					registroContrasena.setText("");

				}

			}});

		BtnVolver.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaRegistro.setVisible(false);
				PantallaMenu.main(null);
				registroUsuario.setText("");
				registroContrasena.setText("");

			}});		

	}
	
}
