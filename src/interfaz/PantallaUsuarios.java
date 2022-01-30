package interfaz;

import javax.swing.*;

import datos.Carrito;
import logica.Ejecucion;

public class PantallaUsuarios {

	@SuppressWarnings("rawtypes")
	static void main(String[] args) {

		Ventana usuarios = new Ventana("Usuarios");
		usuarios.setBounds(550, 180, 400, 400);

		DefaultListModel modelo4 = new DefaultListModel();
		JList listaUsuarios = new JList();
		JScrollPane scroll = new JScrollPane(listaUsuarios);
		scroll .setBounds(31, 41, 117, 200);
		usuarios.getContenedor().add(scroll);
		
		Ejecucion.usuarios.usuarioEnOrden(Ejecucion.usuarios.getRaiz(),modelo4);
		
		Boton agregar = new Boton("Agregar",usuarios,170, 105, 189, 23);

		Boton detalles = new Boton("Detalles",usuarios,170, 139, 189, 23);

		Boton pago = new Boton("Pago",usuarios,170, 173, 189, 23);

		

	}

}
