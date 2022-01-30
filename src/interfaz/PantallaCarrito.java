package interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
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
	public static DefaultListModel modelo ;//= new DefaultListModel();
	@SuppressWarnings("rawtypes")
	public static DefaultListModel modelo2; //= new DefaultListModel();
	public static int i; //contador de productos en carrito
	public static long precio ; 
	@SuppressWarnings("rawtypes")
	public static JList list = new JList();
	public static Texto pagoCarrito;
	public static Texto prodCarrito;
	public static boolean flag = false;

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		modelo = new DefaultListModel();
		modelo2 = new DefaultListModel();
		precio = 0;
		i=0;
		
		for(int t=0; t<Ejecucion.inventario.getTamano();t++) { //Creacion de datos random para pruebas
			modelo.addElement(Ejecucion.inventario.encontrar(t).getDato().imprimir());
		}
		
		Ventana carrito = new Ventana("Carrito");
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensions = t.getScreenSize();
		carrito.setBounds(dimensions.width/2-300,dimensions.height/2-(350/2),600,350);
		
		Ejecucion.compra = new Lista_ref_simple<Producto>();
		
		Texto cabecera = new Texto("  ID  |  Precio  | Cantidad  ",carrito,31, 68, 233, 14);

		pagoCarrito = new Texto("$"+String.valueOf(precio),carrito,440, 143, 76, 23);
		
		Texto totalCarrito = new Texto("TOTAL",carrito,440, 118, 46, 14);

		Texto productosCarrito = new Texto("No. Productos",carrito,440, 68, 89, 14);

		prodCarrito = new Texto(String.valueOf(i),carrito,440, 93, 46, 14);

		Boton detalles = new Boton("Detalles",carrito,440, 139, 89, 23);

		Boton pago = new Boton("Pago",carrito,440, 173, 89, 23);
		pago.setVisible(!flag);
		
		Boton pedir = new Boton("Pedir",carrito,440, 173, 89, 23);
		pedir.setVisible(flag);

		Boton regresarCarrito = new Boton("Regresar",carrito,440, 207, 89, 23);

		list.setModel(modelo);

		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(31, 41, 150, 200);
		carrito.getContenedor().add(scroll);

		JList list2 = new JList();
		list2.setModel(modelo2);

		JScrollPane scroll2 = new JScrollPane(list2);
		scroll2.setBounds(257, 41, 150, 200);
		carrito.getContenedor().add(scroll2);

		CampoL cantidad = new CampoL(carrito,192, 44, 55, 35);
		cantidad.setText("1");
		
		Boton agregar = new Boton("+",carrito,192, 84, 55, 35);

		agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(list.getSelectedValue() != null) {
					
					int c = Integer.valueOf(cantidad.getText());
					//system.out.println(inventario.encontrar(list.getSelectedIndex()).getDato().getPre());
					precio += c*Ejecucion.inventario.encontrar(list.getSelectedIndex()).getDato().getPre();
					i += c;
					Producto temp = Ejecucion.inventario.encontrar(list.getSelectedIndex()).getDato();
					Producto a = new Producto(temp.getId(), temp.getNo(), temp.getDes(), temp.getPre(), null, c);
					Ejecucion.compra.agregar(a);
					modelo2.addElement(a.imprimir());
					pagoCarrito.setText("$"+String.valueOf(precio));
					prodCarrito.setText(String.valueOf(i));
					
					cantidad.setText("1");

				}

			}
		});

		Boton eliminar = new Boton("-",carrito,192, 126, 55, 35);
		eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(list2.getSelectedValue() != null) {

					int c = Integer.valueOf(cantidad.getText());
					Producto temp = Ejecucion.compra.encontrar(list2.getSelectedIndex()).getDato();
					precio -= c*temp.getPre();
					i -= c;
					
					if(temp.getCan()==c) {
						Ejecucion.compra.eliminar_en(list2.getSelectedIndex());
						modelo2.removeElementAt(list2.getSelectedIndex());
					}else {
						temp.setCan(temp.getCan()-c);
						System.out.print(temp);
						modelo2.clear();
						for(int i = 0; i<Ejecucion.compra.getTamano();i++) {
							modelo2.addElement(Ejecucion.compra.encontrar(i).getDato().imprimir());
						}
					}
					
					pagoCarrito.setText("$"+String.valueOf(precio));

					prodCarrito.setText(String.valueOf(i));
					
					cantidad.setText("1");
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
