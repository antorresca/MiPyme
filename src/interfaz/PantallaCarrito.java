package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import datos.Factura;
import datos.Producto;
import estructuras.Lista_ref_simple;
import logica.Ejecucion;

public class PantallaCarrito {
	
	@SuppressWarnings("rawtypes")
	public static DefaultListModel modelo = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	public static DefaultListModel modelo2 = new DefaultListModel();
	public static int i; //contador de productos en carrito
	public static long precio = 0; 
	@SuppressWarnings("rawtypes")
	public static JList list = new JList();
	public static Texto pagoCarrito;
	public static Texto prodCarrito;
	public static boolean flag = false;

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		
		for(int t=0; t<Ejecucion.inventario.getTamano();t++) { //Creacion de datos random para pruebas
			modelo.addElement(Ejecucion.inventario.encontrar(t).getDato().imprimir());
		}
		
		Ventana carrito = new Ventana("Carrito");	
		
		Ejecucion.compra = new Lista_ref_simple<Producto>();
		
		Texto cabecera = new Texto("Producto  |  Precio",carrito,31, 68, 233, 14);

		pagoCarrito = new Texto(String.valueOf(precio),carrito,367, 143, 76, 23);
		
		Texto totalCarrito = new Texto("TOTAL",carrito,367, 118, 46, 14);

		Texto productosCarrito = new Texto("No. Productos",carrito,367, 68, 89, 14);

		prodCarrito = new Texto(String.valueOf(i),carrito,367, 93, 46, 14);

		Boton detalles = new Boton("Detalles",carrito,367, 139, 89, 23);

		Boton pago = new Boton("Pago",carrito,367, 173, 89, 23);
		pago.setVisible(!flag);
		
		Boton pedir = new Boton("Pedir",carrito,367, 173, 89, 23);
		pedir.setVisible(flag);

		Boton regresarCarrito = new Boton("Regresar",carrito,367, 207, 89, 23);

		list.setModel(modelo);

		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(31, 41, 117, 200);
		carrito.getContenedor().add(scroll);

		JList list2 = new JList();
		list2.setModel(modelo2);

		JScrollPane scroll2 = new JScrollPane(list2);
		scroll2.setBounds(227, 41, 117, 200);
		carrito.getContenedor().add(scroll2);

		Boton agregar = new Boton("+",carrito,162, 74, 55, 35);

		agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(list.getSelectedValue() != null) {

					//system.out.println(inventario.encontrar(list.getSelectedIndex()).getDato().getPre());
					precio += Ejecucion.inventario.encontrar(list.getSelectedIndex()).getDato().getPre();
					i += 1;
					Ejecucion.compra.agregar(Ejecucion.inventario.encontrar(list.getSelectedIndex()).getDato());
					modelo2.addElement(Ejecucion.compra.encontrar(Ejecucion.compra.getTamano()-1).getDato().imprimir());
					Ejecucion.compra.imprimir();
					pagoCarrito.setText(String.valueOf(precio));

					prodCarrito.setText(String.valueOf(i));

				}

			}
		});

		Boton eliminar = new Boton("-",carrito,162, 126, 55, 35);
		eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(list2.getSelectedValue() != null) {


					precio -= Ejecucion.compra.encontrar(list2.getSelectedIndex()).getDato().getPre();
					i -= 1;

					Ejecucion.compra.eliminar_en(list2.getSelectedIndex());
					modelo2.removeElementAt(list2.getSelectedIndex());
					pagoCarrito.setText(String.valueOf(precio));

					prodCarrito.setText(String.valueOf(i));
				}
			}
		});

		regresarCarrito.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				carrito.setVisible(false);
				if(!flag)PantallaMenu.main(null);
				else PantallaPedidos.main(null);
			}});

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2 && list.getSelectedValue() != null) { //Saber si se dio doble clic sobre elemento

					String producto = list.getSelectedValue().toString().split(" | ")[0]; //Obtener nombre del producto

					if(JOptionPane.showConfirmDialog(carrito, "Eliminar "+producto+ "?",
							"Elimacion completada", JOptionPane.YES_NO_OPTION) == 0) { //Mensaje de dialogo para eliminar productos

						/*
						 * Actualizacion de variables globales
						 */

						Ejecucion.inventario.eliminar_en(list.getSelectedIndex()); //Eliminacion de productos del objeto

						modelo.removeElementAt(list.getSelectedIndex()); //Eliminacion de producto en lista

						pagoCarrito.setText(String.valueOf(precio)); //Actualizar informacion mostrada
						prodCarrito.setText(String.valueOf(i)); //""

						JOptionPane.showMessageDialog(carrito,"Producto eliminado",
								"Elimacion completada",JOptionPane.INFORMATION_MESSAGE);	//Mensaje informativo						

					}
				}
			}
		});

		pago.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nombre = "";
				String cedula = "";
				String correo = "";
				
				while(nombre == "") {
					nombre = JOptionPane.showInputDialog(carrito,"Ingrese nombre del cliente","Nombre cliente");
				}
				while(cedula == "") {
					cedula = JOptionPane.showInputDialog(carrito,"Ingrese cedula del cliente","Cedula cliente");
				}
				while(correo == "" || !correo.contains("@") || !correo.contains(".")) {
					correo = JOptionPane.showInputDialog(carrito,"Ingrese correo del cliente","Correo cliente");
				}

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String Fecha = dtf.format(LocalDateTime.now());

				Factura nuevaFactura = new Factura(nombre,cedula, correo, Fecha, Ejecucion.usuario_admin, Ejecucion.compra);
				nuevaFactura.setId(nuevaFactura.getContador());
				nuevaFactura.setContador(nuevaFactura.getId()+1);
				Ejecucion.facturas.agregar(nuevaFactura);

				carrito.desactivar();
				VerFactura.main("carrito",nuevaFactura);
				
			}
		});

		pedir.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = "";
				String cedula = "";
				String correo = "";
				
				while(nombre == "") {
					nombre = JOptionPane.showInputDialog(carrito,"Ingrese nombre del cliente","Nombre cliente");
				}
				while(cedula == "") {
					cedula = JOptionPane.showInputDialog(carrito,"Ingrese cedula del cliente","Cedula cliente");
				}
				while(correo == "" || !correo.contains("@") || !correo.contains(".")) {
					correo = JOptionPane.showInputDialog(carrito,"Ingrese correo del cliente","Correo cliente");
				}

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String Fecha = dtf.format(LocalDateTime.now());

				Factura nuevaFactura = new Factura(nombre,cedula, correo, Fecha, Ejecucion.usuario_admin, Ejecucion.compra);
				nuevaFactura.setId(nuevaFactura.getContador());
				Ejecucion.pedidos.encolar(nuevaFactura);
				PantallaPedidos.i = PantallaPedidos.i + 1;

				carrito.desactivar();
				VerFactura.main("carrito",nuevaFactura);
			}
		});
		detalles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedValue() != null) { //Saber si hay seleccionado algun elemento en lista
					carrito.desactivar();
					PantallaDetalles.main(null);
				}else {
					JOptionPane.showMessageDialog(carrito,"Por favor elija un producto",
							"Error",JOptionPane.ERROR_MESSAGE); //Mensaje de error
				}
			}});

		
		
		
		
	}
	
}
