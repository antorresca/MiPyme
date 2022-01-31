package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import datos.Usuario;
import logica.Ejecucion;

public class PantallaInventario {

	@SuppressWarnings("rawtypes")
	static void main(String[] args) {

		DefaultListModel modelo6 = new DefaultListModel();
		
		for(int t=0; t<Ejecucion.inventario.getTamano();t++) { 
			modelo6.addElement(Ejecucion.inventario.encontrar(t).getDato().imprimir());
		}
		
		Ventana pantallaInventario = new Ventana("Inventario");
		pantallaInventario.setBounds(550, 180, 400, 400);


		if(modelo6==null)modelo6.addElement("Jumm");

		JList listaProductos = new JList();
		listaProductos.setModel(modelo6);
		JScrollPane scroll = new JScrollPane(listaProductos);
		scroll .setBounds(30, 41, 200, 250);
		pantallaInventario.getContenedor().add(scroll);

		pantallaInventario.update(pantallaInventario.getGraphics());

		Boton agregar = new Boton("Agregar",pantallaInventario,260, 105, 89, 23);
		agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaInventario.setVisible(false);
				PantallaRegistro.main(null);
			}
		});

		Boton detalles = new Boton("Modificar",pantallaInventario,260, 139, 89, 23);

		detalles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listaProductos.getSelectedValue()!=null) {

					String valor = "";
					char[] a =listaProductos.getSelectedValue().toString().toCharArray();
					for(char i : a) {
						if(i!='|')valor+=i;
						else break;
					}			
					valor = valor.replace(" ","");
					valor = valor.replace("P","");
					System.out.println(Ejecucion.inventario.encontrar(Integer.valueOf(valor)));
					pantallaInventario.desactivar();
					PantallaModificarProducto.main(Ejecucion.inventario.encontrar(Integer.valueOf(valor)).getDato());


				}
			}	
		});

		Boton eliminarUsuario = new Boton("Eliminar",pantallaInventario,260, 173, 89, 23);

		eliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listaProductos.getSelectedValue()!=null) {
					String valor = "";
					char[] a =listaProductos.getSelectedValue().toString().toCharArray();
					for(char i : a) {
						if(i!='|')valor+=i;
						else break;
					}			
					valor = valor.replace(" ","");
					valor = valor.replace("P","");
					Ejecucion.inventario.eliminar_en(Integer.valueOf(valor));
					JOptionPane.showMessageDialog(pantallaInventario,"Eliminacion exitosa","Usuario Eliminado",JOptionPane.INFORMATION_MESSAGE);
					modelo6.remove(listaProductos.getSelectedIndex());


				}
			}
		});

		Boton regresarPedidos = new Boton("Regresar",pantallaInventario,260, 207, 89, 23);

		regresarPedidos.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaInventario.desactivar();
				PantallaMenu.main(null);
			}});

	}

}
