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

		Boton btningreso = new Boton("Ingresar", pantallaInicio, 200, 230, 100, 25);
		pantallaInicio.activar();
		
		btningreso.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				Runnable mirun = new Runnable() {
					public void run() {
						pantallaInicio.setVisible(false);
						PantallaMenu.main(null);
					}
				};
				Thread hilo = new Thread (mirun);
			      //hilo.start();

				if (textoPassword.getText().equals("") && textoUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Por favor, llene los espacios en blanco","�OJO!",JOptionPane.WARNING_MESSAGE);
				}

				else if(textoUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Por favor ingrese su usuario","�OJO!",JOptionPane.WARNING_MESSAGE);
				}

				else if (textoPassword.getText().equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Ingrese la contrase�a","�OJO!",JOptionPane.WARNING_MESSAGE);
				}

				else if(!"".equals(textoUsuario.getText()) && !"".equals(textoPassword.getText())) {

					boolean compuerta_filtro = true;

					Usuario comparar = new Usuario(textoUsuario.getText(),textoPassword.getText());
					//system.out.print(comparar.getContrasena()+ comparar.getUsuario());
					Nodo usuarioEncontrado = Ejecucion.usuarios.encontrar(comparar);
					if((usuarioEncontrado!=null) && ((Usuario)usuarioEncontrado.getDato()).getContrasena().equals(textoPassword.getText())) {
						
						actual = (Usuario) usuarioEncontrado.getDato();
						PantallaMenu.flag = ((Usuario)usuarioEncontrado.getDato()).isAdmin();
						compuerta_filtro = false;
						pantallaInicio.setVisible(false);
						PantallaMenu.main(null);

					}

					if(compuerta_filtro) {

						JOptionPane.showMessageDialog(pantallaInicio,"Usuario o clave erronea","Error",JOptionPane.ERROR_MESSAGE);
					}

					textoUsuario.setText("");
					textoPassword.setText("");
				}
			}});

	}

}
