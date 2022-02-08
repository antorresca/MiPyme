package interfaz;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import datos.Usuario;
import estructuras.Arbol_avl.Nodo;
import logica.Ejecucion;

public class PantallaInicio {
	
	public static CampoL textoUsuario;
	public static Usuario actual;
	
	public static void main(String[] args) {
		Ventana pantallaInicio = new Ventana("Mi PYME");
		
		pantallaInicio.desactivar();
		
		Imagen bienvenida = new Imagen((Ejecucion.Tema==Ejecucion.ModoClaro)?"Img\\LogoOscuro.png":"Img\\LogoClaro.png", pantallaInicio,140, 40, 200, 160);

		Texto userLabel = new Texto("Usuario", pantallaInicio, 110, 205, 90, 35);

		Texto passwordLabel = new Texto("Contrase\u00f1a", pantallaInicio,110, 225, 90, 35);
		
		//JPasswordField  textoPassword = new JPasswordField();
		//passwordLabel.setBounds(185, 190, 165, 25);
		//pantallaInicio.getContenedor().add(passwordLabel);

		textoUsuario = new CampoL(pantallaInicio,185,170,165,25);
		CampoP textoPassword = new CampoP(pantallaInicio,185, 190, 165, 25);

		//Botones Inicio

		Boton btningreso = new Boton("", pantallaInicio, 150, 240, 200, 50);
		btningreso.volverIcono("iniciar Sesion\r\n");
		btningreso.setIcon((!PantallaMenu.temaFlag)? PantallaMenu.ingresarO: PantallaMenu.ingresarC);
		
		pantallaInicio.activar();
				
		btningreso.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = textoUsuario.getText();
				String password = textoPassword.getText();
				if (password.equals("") && usuario.equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Por favor, llene los espacios en blanco","¡OJO!",JOptionPane.WARNING_MESSAGE);
				}

				else if(usuario.equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Por favor ingrese su usuario","¡OJO!",JOptionPane.WARNING_MESSAGE);
				}

				else if (password.equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Ingrese la contraseña","¡OJO!",JOptionPane.WARNING_MESSAGE);
				}

				else if(!"".equals(usuario) && !"".equals(password)) {

					Usuario comparar = new Usuario(usuario,password);
					Nodo usuarioEncontrado = Ejecucion.usuarios.encontrar(comparar);
					//Nodo usuarioEncontrado = Ejecucion.usuarios.encontrar_por_nombre(textoUsuario.getText());
					if((usuarioEncontrado!=null) && ((Usuario)usuarioEncontrado.getDato()).getContrasena().equals(textoPassword.getText())) {
						
						actual = (Usuario) usuarioEncontrado.getDato();
						PantallaMenu.flag = ((Usuario)usuarioEncontrado.getDato()).isAdmin();
						pantallaInicio.setVisible(false);
						PantallaMenu.main(null);

					}else{
						JOptionPane.showMessageDialog(pantallaInicio,"Usuario o clave erronea","Error",JOptionPane.ERROR_MESSAGE);
					}
							
					textoUsuario.setText("");
					textoPassword.setText("");
				}
			}});

	}

}
