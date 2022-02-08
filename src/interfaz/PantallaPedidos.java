package interfaz;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import datos.Factura;
import datos.Producto;
import estructuras.Metodos_pila_cola_ref_simple.Nodo;
import logica.Ejecucion;
// recordar nuevaFactura.setContador(nuevaFactura.getId()+1);
public class PantallaPedidos {
	@SuppressWarnings("rawtypes")
	public static DefaultListModel modelo;
	
	public static int i = 0 ; //contador de pedidos
	public static long precio = 0; 
	public static JList list = new JList();
	public static Texto pagoCarrito;
	public static Texto prodCarrito;

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		modelo = new DefaultListModel();
		for(int t=0; t<Ejecucion.pedidos.getTamano();t++) { //Creacion de datos random para pruebas
			Nodo temporal = Ejecucion.pedidos.desencolar();
			if(temporal != null) {
				
				Ejecucion.pedidos.encolar((Factura)temporal.getDato());
				modelo.addElement("P"+t+"  |  "+((Factura)temporal.getDato()).getPrecio());
			}
		}
		
		//----------------------IMPRIMIR-------------------------
		Nodo auxiliare = Ejecucion.pedidos.getCabeza();
		for(int t=0; t<Ejecucion.pedidos.getTamano();t++) {
            
			auxiliare = auxiliare.getSiguiente();
		}
		//-----------------------------------------------------------
		
		Ventana pedidos = new Ventana("Pedidos");
		pedidos.setBounds(550, 180, 300, 400);
		
		Texto cabecera = new Texto("Pedido |  Precio",pedidos,31, 68, 233, 14);

		//pagoCarrito = new Texto(String.valueOf(precio),pedidos,150, 143, 76, 23);

		Texto numPedidos = new Texto("No. Pedidos",pedidos,170, 68, 89, 14);

		numPedidos = new Texto(String.valueOf(i),pedidos,170, 93, 46, 14);

		Boton agregar = new Boton("",pedidos,170, 95, 89, 32);
		agregar.volverIcono("añadir\r\n","Img\\AgregarClaro.png","Img\\AgregarOscuro.png");
		
		Boton detalles = new Boton("",pedidos,170, 139, 89, 32);
		detalles.volverIcono("Detalles\r\n");
		detalles.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.detallesO:PantallaMenu.detallesC);

		Boton pago = new Boton("",pedidos,170, 183, 89, 32); //poner en otra ventana
		pago.volverIcono("pago\r\n");
		pago.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.PagoO:PantallaMenu.PagoC);
		
		Boton regresarPedidos = new Boton("",pedidos,170, 227, 35,35);
		regresarPedidos.volverIcono("volver\r\n");
		regresarPedidos.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.RegresarO:PantallaMenu.RegresarC);
		
		list.setModel(modelo);

		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(31, 41, 117, 200);
		pedidos.getContenedor().add(scroll);


		regresarPedidos.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pedidos.desactivar();
				PantallaMenu.main(null);
			}});

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2 && list.getSelectedValue() != null) { //Saber si se dio doble clic sobre elemento

					String producto = list.getSelectedValue().toString().split(" | ")[0]; //Obtener nombre del producto

					if(JOptionPane.showConfirmDialog(pedidos, "Eliminar "+producto+ "?",
							"Elimacion completada", JOptionPane.YES_NO_OPTION) == 0) { //Mensaje de dialogo para eliminar productos

						/*
						 * Actualizacion de variables globales
						 */
						String valor = "";
						char[] a =list.getSelectedValue().toString().toCharArray();
						for(char i : a) {
							if(i!='|')valor+=i;
							else break;
						}			
						valor = valor.replace(" ","");
						valor = valor.replace("P","");
						Ejecucion.inventario.eliminar(new Producto(Integer.valueOf(valor))); 
						modelo.removeElementAt(list.getSelectedIndex()); //Eliminacion de producto en lista

						pagoCarrito.setText(String.valueOf(precio)); //Actualizar informacion mostrada
						prodCarrito.setText(String.valueOf(i)); //""

						JOptionPane.showMessageDialog(pedidos,"Producto eliminado",
								"Elimacion completada",JOptionPane.INFORMATION_MESSAGE);	//Mensaje informativo						

					}
				}
			}
		});

		pago.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
/*
				Ventana Factura = new Ventana("Factura");
				Factura.desactivar();
				Factura.setBounds(100, 100, 268, 600);
				Boton regresar = new Boton("Regresar",Factura,10, 17, 89, 23);
				Texto Titulo = new Texto("Mi Pyme",Factura,0, 102, 252, 25);
				Titulo.setHorizontalAlignment(SwingConstants.CENTER);
				Texto encabezado = new Texto("Factura de compra # ",Factura,0, 126, 252, 14);
				encabezado.setHorizontalAlignment(SwingConstants.CENTER);
				Texto lblNewLabel_2 = new Texto("------------------------------------------------",Factura,0, 147, 252, 14);
				Texto lblNewLabel_2_1 = new Texto("----------------------------------------------",Factura,0, 379, 252, 14);
				Texto lblNewLabel_3 = new Texto("Total a Pagar:",Factura,0, 400, 240, 14);
				Texto tituloNombre = new Texto("Nombre",Factura,10,400,50,14);
				Texto tituloCedula = new Texto("Cedula",Factura,10,440,50,14);
				Texto tituloCorreo = new Texto("Correo",Factura,10,480,50,14);
				Texto separador = new Texto("----------------------------------------------",Factura,0, 520, 252, 14);
				Texto tituloCajero = new Texto("Cajero:",Factura,10,540,50,14);
				Texto tituloFecha = new Texto("Fecha:",Factura,10,560,50,14);
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
				JList listProductos = new JList();
				listProductos.setEnabled(false);
				
				
				JScrollPane LaFactura = new JScrollPane(listProductos);
				LaFactura.setBounds(0, 139, 252, 200);
				Factura.getContenedor().add(LaFactura);

				Texto precioProductos = new Texto("<precio>",Factura,0, 414, 240, 38);
				precioProductos.setHorizontalAlignment(SwingConstants.RIGHT);
				Texto nombreCliente = new Texto("<Nombre cliente>",Factura,10,420, 170, 14);
				Texto cedulaCliente = new Texto("<Cedula cliente>",Factura,10,460, 143,14);
				Texto correoCliente = new Texto("<Correo Cliente>",Factura,10,500, 143,14);
				Texto nombreCajero = new Texto("<Cajero>",Factura,50,540, 143,14);
				Texto fechaFactura = new Texto("<Fecha>",Factura,50,560, 143,14);*/


				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String Fecha = dtf.format(LocalDateTime.now());
				
				Nodo nuevaFactura = Ejecucion.pedidos.desencolar();
				//modelo = new DefaultListModel();
				
				
				//no hay facturas para pagar
				if (nuevaFactura!=null) {
					i--;
					Factura siguientePedido = (Factura)nuevaFactura.getDato(); 
					siguientePedido.setFecha(Fecha);
					/*
					DefaultListModel modeloPedidos = new DefaultListModel();
					for(int t=0; t<siguientePedido.getProductos().getTamano();t++) { //Creacion de datos random para pruebas
						modeloPedidos.addElement(siguientePedido.getProductos().encontrar(t).getDato().imprimir());
					}
					listProductos.setModel(modeloPedidos);*/
					
					siguientePedido.setId(siguientePedido.getContador());
					siguientePedido.setContador(siguientePedido.getId()+1);
					
					Ejecucion.facturas.agregar(siguientePedido);

					pedidos.desactivar();
					VerFactura.main("pedidos",siguientePedido);
					/* Factura.activar();
					precioProductos.setText(String.valueOf(siguientePedido.getPrecio()));
					nombreCliente.setText(siguientePedido.getNombre());
					cedulaCliente.setText(siguientePedido.getCedula());
					correoCliente.setText(siguientePedido.getCorreo());
					nombreCajero.setText(siguientePedido.getVendedor().getUsuario());
					fechaFactura.setText(siguientePedido.getFecha());
					encabezado.setText(encabezado.getText()+String.valueOf(siguientePedido.getId()));


					regresar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
						@Override
						public void mouseClicked(MouseEvent e) {
							Factura.desactivar(); 
							//pedidos.activar();
							PantallaPedidos.main(null);
						}
					});*/
				}else {
					JOptionPane.showMessageDialog(pedidos,"No hay pedidos pendientes por pagar",
							"No hay pedidos",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		detalles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedValue() != null) { //Saber si hay seleccionado algun elemento en lista
					pedidos.desactivar();
					PantallaFactura.flag = true;
					PantallaFactura.main(null);
				}else {
					JOptionPane.showMessageDialog(pedidos,"Por favor seleccione un pedido",
							"Error",JOptionPane.ERROR_MESSAGE); //Mensaje de error
				}
			}}
		);

		agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pedidos.desactivar();
				PantallaCarrito.flag = true;
				PantallaCarrito.main(null);
				
			}}
		);



	}
}
