package interfaz;

import java.awt.event.*;

import javax.swing.*;

import datos.Carrito;
import datos.Usuario;
import logica.Ejecucion;

public class PantallaUsuarios {



	@SuppressWarnings("rawtypes")
	static void main(String[] args) {

		DefaultListModel modelo4 = new DefaultListModel();
		Ejecucion.usuarios.usuarioEnOrden(Ejecucion.usuarios.getRaiz(),modelo4);
		Ventana pantallaUsuarios = new Ventana("Usuarios");
		pantallaUsuarios.setBounds(550, 180, 400, 400);


		if(modelo4==null)modelo4.addElement("Jumm");

		JList listaUsuarios = new JList();
		listaUsuarios.setModel(modelo4);
		JScrollPane scroll = new JScrollPane(listaUsuarios);
		scroll .setBounds(30, 41, 200, 250);
		pantallaUsuarios.getContenedor().add(scroll);

		pantallaUsuarios.update(pantallaUsuarios.getGraphics());

		Boton agregar = new Boton("Agregar",pantallaUsuarios,260, 105, 89, 23);
		agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaUsuarios.setVisible(false);
				PantallaRegistro.main(null);
			}
		});

		Boton detalles = new Boton("Modificar",pantallaUsuarios,260, 139, 89, 23);

		detalles.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(listaUsuarios.getSelectedValue()!=null) {
				if(listaUsuarios.getSelectedValue().equals(Ejecucion.usuario_admin.getUsuario()+" | Administrador")) {
					JOptionPane.showMessageDialog(pantallaUsuarios,"Es el admin, No se puede eliminar","NO",JOptionPane.ERROR_MESSAGE);					
				}else {
					String[] valor = listaUsuarios.getSelectedValue().toString().split(" | ");
					Usuario temp = new Usuario(valor[0],"");
					Usuario usuarioEncontrar = Ejecucion.usuarios.encontrarN(temp).getDato();
					pantallaUsuarios.setVisible(false);
					PantallaModificarUsuario.main(usuarioEncontrar);
				}

			}
		}
		});

		Boton eliminarUsuario = new Boton("Eliminar",pantallaUsuarios,260, 173, 89, 23);

		eliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listaUsuarios.getSelectedValue()!=null) {
					if(listaUsuarios.getSelectedValue().equals(Ejecucion.usuario_admin.getUsuario()+" | Administrador")) {
						JOptionPane.showMessageDialog(pantallaUsuarios,"Es el admin, No se puede eliminar","NO",JOptionPane.ERROR_MESSAGE);					
					}else {
						String[] valor = listaUsuarios.getSelectedValue().toString().split(" | ");
						Usuario temp = new Usuario(valor[0],"");
						//System.out.print((Ejecucion.usuarios.encontrarN(temp)).getDato().getContrasena());
						Ejecucion.usuarios.eliminarD(temp);
						JOptionPane.showMessageDialog(pantallaUsuarios,"Eliminacion exitosa","Usuario Eliminado",JOptionPane.INFORMATION_MESSAGE);
						modelo4.remove(listaUsuarios.getSelectedIndex());
					}

				}

			}
		});

		Boton regresarPedidos = new Boton("Regresar",pantallaUsuarios,260, 207, 89, 23);

		regresarPedidos.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaUsuarios.desactivar();
				PantallaMenu.main(null);
			}});

	}

}
