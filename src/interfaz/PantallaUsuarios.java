package interfaz;

import java.awt.event.*;

import javax.swing.*;

import datos.Carrito;
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
		scroll .setBounds(70, 41, 117, 200);
		pantallaUsuarios.getContenedor().add(scroll);
		
		pantallaUsuarios.update(pantallaUsuarios.getGraphics());
		
		Boton agregar = new Boton("Agregar",pantallaUsuarios,210, 105, 89, 23);
		agregar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			pantallaUsuarios.setVisible(false);
			PantallaRegistro.main(null);
		}
		});

		Boton detalles = new Boton("Modificar",pantallaUsuarios,210, 139, 89, 23);
		

		Boton pago = new Boton("Eliminar",pantallaUsuarios,210, 173, 89, 23);

		Boton regresarPedidos = new Boton("Regresar",pantallaUsuarios,210, 207, 89, 23);
		
		regresarPedidos.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaUsuarios.desactivar();
				PantallaMenu.main(null);
			}});

	}

}
