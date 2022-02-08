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
		
		
		Texto titulo = new Texto("Usuario | Rol",pantallaUsuarios,30,65, 200, 15);

		pantallaUsuarios.update(pantallaUsuarios.getGraphics());
/*
		Boton agregar = new Boton("",pantallaUsuarios,260, 105, 89, 32);
		agregar.volverIcono("agregar\r\n","Img\\AgregarClaro.png","Img\\AgregarOscuro.png");
		*/
		Boton agregar = new Boton("",pantallaUsuarios,280, 45, 45, 45);
		agregar.volverIcono("agregar\r\n");
		agregar.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.AUsuarioO:PantallaMenu.AUsuarioC);
		agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaUsuarios.setVisible(false);
				PantallaRegistro.main(null);
			}
		});
		/*
		Boton modificar = new Boton("",pantallaUsuarios,260, 149, 89, 32);
		modificar.volverIcono("agregar\r\n","Img\\ModificarClaro.png","Img\\ModificarOscuro.png");
		*/
		Boton modificar = new Boton("",pantallaUsuarios,280, 112, 45, 45);
		modificar.volverIcono("modificar\r\n","Img\\EditarUsuarioClaro.png","Img\\EditarUsuarioOscuro.png");
		modificar.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.EUsuarioO:PantallaMenu.EUsuarioC);
		modificar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(listaUsuarios.getSelectedValue()!=null) {
				if(listaUsuarios.getSelectedValue().equals(Ejecucion.usuario_admin.getUsuario()+" | Administrador")) {
					JOptionPane.showMessageDialog(pantallaUsuarios,"El Administrador principal no se puede modificar","NO",JOptionPane.ERROR_MESSAGE);					
				}else {
					String[] valor = listaUsuarios.getSelectedValue().toString().split(" | ");
					Usuario temp = new Usuario(valor[0],"");
					Usuario usuarioEncontrar = Ejecucion.usuarios.encontrar(temp).getDato();
					pantallaUsuarios.setVisible(false);
					PantallaModificarUsuario.main(usuarioEncontrar);
				}

			}else {
				JOptionPane.showMessageDialog(pantallaUsuarios,"Debe seleccionar un Usuario","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		});
/*
		Boton eliminarUsuario = new Boton("",pantallaUsuarios,260, 193, 89, 32);
		eliminarUsuario.volverIcono("volver\r\n","Img\\EliminarClaro.png","Img\\EliminarOscuro.png");
		*/
		Boton eliminarUsuario = new Boton("",pantallaUsuarios,280, 170, 45, 45);
		eliminarUsuario.volverIcono("eliminar\r\n","Img\\EliminarUsuarioClaro.png","Img\\EliminarUsuarioOscuro.png");
		eliminarUsuario.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.QUsuarioO:PantallaMenu.QUsuarioC);
		eliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listaUsuarios.getSelectedValue()!=null) {
					if(listaUsuarios.getSelectedValue().equals(Ejecucion.usuario_admin.getUsuario()+" | Administrador")) {
						JOptionPane.showMessageDialog(pantallaUsuarios,"Es el admin, No se puede eliminar","NO",JOptionPane.ERROR_MESSAGE);					
					}else {
						String[] valor = listaUsuarios.getSelectedValue().toString().split(" | ");
						Usuario temp = new Usuario(valor[0],"");
						Ejecucion.usuarios.eliminar(temp);
						JOptionPane.showMessageDialog(pantallaUsuarios,"Eliminacion exitosa","Usuario Eliminado",JOptionPane.INFORMATION_MESSAGE);
						modelo4.remove(listaUsuarios.getSelectedIndex());
					}

				}else {
					JOptionPane.showMessageDialog(pantallaUsuarios,"Debe seleccionar un Usuario","Error",JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		Boton regresarPedidos = new Boton("",pantallaUsuarios,285, 257, 40, 40);
		regresarPedidos.volverIcono("volver\r\n");
		regresarPedidos.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.RegresarO:PantallaMenu.RegresarC);
		
		regresarPedidos.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaUsuarios.desactivar();
				PantallaMenu.main(null);
			}});

	}

}
