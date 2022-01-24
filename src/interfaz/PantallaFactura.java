package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import logica.Ejecucion;
import datos.Factura;
import datos.Producto;
import estructuras.Lista_ref_simple;
import estructuras.Metodos_pila_cola_ref_simple.Nodo;

public class PantallaFactura {
	public static boolean flag = false;
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		int n = -1;
		String entrada;
		
		Ventana pantalla_factura = new Ventana("Factura");
		pantalla_factura.desactivar();
		if(!flag) {
			while(n == -1) {
				entrada = JOptionPane.showInputDialog(pantalla_factura,"Ingrese numero de la factura","Busqueda de Factura");
				try {
					n = (entrada==null)?-2:(entrada.equals("Busqueda de Factura"))?-1:Integer.valueOf(entrada);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(pantalla_factura,"Entrada invalida","Solo numeros validos",JOptionPane.ERROR_MESSAGE);
				}

			}
		}
		try {

			
			/*if(!flag)for(int t=0; t<nuevaFactura.getProductos().getTamano();t++) { //Creacion de datos random para pruebas
				PantallaCarrito.modelo.addElement(nuevaFactura.getProductos().encontrar(t).getDato().imprimir());
			}*/

			pantalla_factura.setBounds(100, 100, 268, 600);
			Boton regresar = new Boton("Regresar",pantalla_factura,10, 17, 89, 23);
			Texto Titulo = new Texto("Mi Pyme",pantalla_factura,0, 102, 252, 25);
			Titulo.setHorizontalAlignment(SwingConstants.CENTER);
			Texto encabezado = new Texto("Factura de compra # ",pantalla_factura,0, 126, 252, 14);
			encabezado.setHorizontalAlignment(SwingConstants.CENTER);
			Texto lblNewLabel_2 = new Texto("------------------------------------------------",pantalla_factura,0, 147, 252, 14);
			Texto lblNewLabel_2_1 = new Texto("----------------------------------------------",pantalla_factura,0, 379, 252, 14);
			Texto lblNewLabel_3 = new Texto("Total a Pagar:",pantalla_factura,0, 400, 240, 14);
			Texto tituloNombre = new Texto("Nombre",pantalla_factura,10,400,50,14);
			Texto tituloCedula = new Texto("Cedula",pantalla_factura,10,440,50,14);
			Texto tituloCorreo = new Texto("Correo",pantalla_factura,10,480,50,14);
			Texto separador = new Texto("----------------------------------------------",pantalla_factura,0, 520, 252, 14);
			Texto tituloCajero = new Texto("Cajero:",pantalla_factura,10,540,50,14);
			Texto tituloFecha = new Texto("Fecha:",pantalla_factura,10,560,50,14);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			JList listProductos = new JList();
			listProductos.setEnabled(false);
			
			Factura nuevaFactura;
			if(!flag) nuevaFactura = Ejecucion.facturas.encontrar(n).getDato();
			else nuevaFactura = Ejecucion.pedidos.getCabeza().getDato();//lo logico es tener en cuenta la cabeza XD
			/*
			if(!flag)listProductos.setModel(PantallaCarrito.modelo2);
			else {
				DefaultListModel modeloPedidos = new DefaultListModel();
				for(int t=0; t<nuevaFactura.getProductos().getTamano();t++) { //Creacion de datos random para pruebas
					modeloPedidos.addElement(nuevaFactura.getProductos().encontrar(t).getDato().imprimir());
				}
				listProductos.setModel(modeloPedidos);
			}
			*/
			
			
			DefaultListModel modeloPedidos = new DefaultListModel();
			/*for(int t=0; t<nuevaFactura.getProductos().getTamano();t++) { //Creacion de datos random para pruebas
				modeloPedidos.addElement(nuevaFactura.getProductos().encontrar(t).getDato().imprimir());
			}*/
			Nodo productos = nuevaFactura.getProductos().getCabeza();
			while (productos!=null) {
				modeloPedidos.addElement( ((Producto)productos.getDato()).getNo());
				productos =productos.getSiguiente();
			}
			listProductos.setModel(modeloPedidos);
			
			
			JScrollPane LaFactura = new JScrollPane(listProductos);
			LaFactura.setBounds(0, 139, 252, 200);
			pantalla_factura.getContenedor().add(LaFactura);
			Texto precioProductos = new Texto("<precio>",pantalla_factura,0, 414, 240, 38);
			precioProductos.setHorizontalAlignment(SwingConstants.RIGHT);
			Texto nombreCliente = new Texto("<Nombre cliente>",pantalla_factura,10,420, 170, 14);
			Texto cedulaCliente = new Texto("<Cedula cliente>",pantalla_factura,10,460, 143,14);
			Texto correoCliente = new Texto("<Correo Cliente>",pantalla_factura,10,500, 143,14);
			Texto nombreCajero = new Texto("<Cajero>",pantalla_factura,50,540, 143,14);
			Texto fechaFactura = new Texto("<Fecha>",pantalla_factura,50,560, 143,14);

			pantalla_factura.activar();
			precioProductos.setText(String.valueOf(nuevaFactura.getPrecio()));
			nombreCliente.setText(nuevaFactura.getNombre());
			cedulaCliente.setText(nuevaFactura.getCedula());
			correoCliente.setText(nuevaFactura.getCorreo());
			nombreCajero.setText(nuevaFactura.getVendedor().getUsuario());
			fechaFactura.setText(nuevaFactura.getFecha());
			encabezado.setText(encabezado.getText()+String.valueOf(nuevaFactura.getId()));


			regresar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
				@Override
				public void mouseClicked(MouseEvent e) {
					pantalla_factura.desactivar(); 
					if(!flag) PantallaMenu.main(null);
					else PantallaPedidos.main(null);;
				}
			});
		}catch(Exception exp) {
			pantalla_factura.desactivar();
			PantallaMenu.main(null);
			if(n!=-2)JOptionPane.showMessageDialog(pantalla_factura,"Factura no encontrada","Factura no encontrada",JOptionPane.ERROR_MESSAGE);
		}
		

	}

}
