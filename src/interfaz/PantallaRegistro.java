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
		
		CampoL registroUsuario = new CampoL(pantallaRegistro,225,120,165,25);

		CampoL registroContrasena = new CampoL(pantallaRegistro,225,150,165,25);

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
					Usuario nuevo = new Usuario(registro_usuario,registro_contrasenia);
					if(Ejecucion.usuarios.encontrarN(nuevo)!=null) {
						JOptionPane.showMessageDialog(pantallaRegistro,"Ya existe un usuario con este nombre","Este usuario ya existe",JOptionPane.ERROR_MESSAGE);
					}else {
						Ejecucion.usuarios.agregarA(nuevo);
						//usuarios.agregar(new Usuario(registro_usuario,registro_contrasenia));

						registroUsuario.setText("");
						registroContrasena.setText("");

						JOptionPane.showMessageDialog(pantallaRegistro,"Creación de usuario exitosa","Exitoso",JOptionPane.INFORMATION_MESSAGE);
						pantallaRegistro.setVisible(false);
						PantallaMenu.main(null);
					}
					

				}

			}});

		BtnVolver.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaRegistro.setVisible(false);
				PantallaUsuarios.main(null);
				registroUsuario.setText("");
				registroContrasena.setText("");

			}});		

	}
	
}
