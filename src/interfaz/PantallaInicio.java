package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import datos.Usuario;
import logica.Ejecucion;

public class PantallaInicio {
	
	public static void main(String[] args) {
		Ventana pantallaInicio = new Ventana("Mi PYME");
		pantallaInicio.setBackground(Ejecucion.Tema);
		
		Imagen bienvenida = new Imagen("Img\\LogoOscuro.png", pantallaInicio,140, 40, 200, 160);

		Texto userLabel = new Texto("Usuario", pantallaInicio, 110, 205, 90, 35);

		Texto passwordLabel = new Texto("Contrasena", pantallaInicio,110, 225, 90, 35);

		CampoL textoUsuario = new CampoL(pantallaInicio,185,170,165,25);
		CampoL textoPassword = new CampoL(pantallaInicio,185, 190, 165, 25);

		//Botones Inicio

		Boton btningreso = new Boton("Ingresar", pantallaInicio, 200, 230, 100, 25);

		btningreso.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {

				if (textoPassword.getText().equals("") && textoUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Por favor, llene los espacios en blanco","¡OJO!",JOptionPane.WARNING_MESSAGE);
				}

				else if(textoUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Por favor ingrese su usuario","¡OJO!",JOptionPane.WARNING_MESSAGE);
				}

				else if (textoPassword.getText().equals("")) {

					JOptionPane.showMessageDialog(pantallaInicio,"Ingrese la contrasena","¡OJO!",JOptionPane.WARNING_MESSAGE);
				}

				else if(!"".equals(textoUsuario.getText()) && !"".equals(textoPassword.getText())) {

					boolean compuerta_filtro = true;

					if(Ejecucion.usuario_admin.getUsuario().equals(textoUsuario.getText()) 
							&& Ejecucion.usuario_admin.getContrasena().equals(textoPassword.getText())) {

						pantallaInicio.setVisible(false);
						PantallaMenu.main(null);
						//---->btnregistro.setVisible(true);
						compuerta_filtro = false;
					}else {

						Ejecucion.usuarios.agregarA(Ejecucion.usuario_admin);
						Usuario comparar = new Usuario(textoUsuario.getText(),textoPassword.getText());
						//system.out.print(comparar.getContrasena()+ comparar.getUsuario());
						if((Ejecucion.usuarios.encontrarN(comparar)!=null) && Ejecucion.usuarios.encontrarN(comparar).getDato().getContrasena().equals(textoPassword.getText())) {
							
							pantallaInicio.setVisible(false);
							PantallaMenu.main(null);
							compuerta_filtro = false;
					
						}

						 
/*						for(int i=0; i < usuarios.getTamano(); i++) {

							if(usuarios.encontrar(i).getDato().getUsuario().equals(textoUsuario.getText()) && usuarios.encontrar(i).getDato().getContrasena().equals(textoPassword.getText())) {

								pantallaInicio.setVisible(false);
								pantallaMenu.setVisible(true);
								compuerta_filtro = false;
								break;
							}
						}*/
					}

					if(compuerta_filtro) {

						//----->JOptionPane.showMessageDialog(PantallaRegistro,"Usuario o clave erronea","Error",JOptionPane.ERROR_MESSAGE);
					}

					//registroUsuario.setText("");
					//registroContrasena.setText("");
				}
			}});

	}

}
