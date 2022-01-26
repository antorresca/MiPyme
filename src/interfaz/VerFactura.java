package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import datos.Factura;
import logica.Ejecucion;

public class VerFactura {

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String anterior,Factura nuevaFactura) {
		
		DefaultListModel modelo3 = new DefaultListModel();
		for(int i = 0;i<nuevaFactura.productos.getTamano();i++) {
			modelo3.addElement(nuevaFactura.productos.encontrar(i).getDato().imprimir());
		}
		
		Ventana Factura = new Ventana("Factura");
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
		listProductos.setModel(modelo3);
		JScrollPane LaFactura = new JScrollPane(listProductos);
		LaFactura.setBounds(0, 139, 252, 200);
		Factura.getContenedor().add(LaFactura);

		Texto precioProductos = new Texto("<precio>",Factura,0, 414, 240, 38);
		precioProductos.setHorizontalAlignment(SwingConstants.RIGHT);
		Texto nombreCliente = new Texto("<Nombre cliente>",Factura,10,420, 170, 14);
		Texto cedulaCliente = new Texto("<Cedula cliente>",Factura,10,460, 143,14);
		Texto correoCliente = new Texto("<Correo Cliente>",Factura,10,500, 143,14);
		Texto nombreCajero = new Texto("<Cajero>",Factura,50,540, 143,14);
		Texto fechaFactura = new Texto("<Fecha>",Factura,50,560, 143,14);
		
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
				Factura.desactivar();
				String nombre = anterior.toLowerCase();
				switch(nombre) {
				case "carrito":
					PantallaCarrito.main(null);
					break;
				case "menu":
					PantallaMenu.main(null);
					break;
				case "pedidos":
					PantallaPedidos.main(null);
					break;
				}
				/*
				if(anterior.toLowerCase().contains("carrito")) PantallaCarrito.main(null);
				else if(anterior.toLowerCase().contains("menu")) PantallaMenu.main(null);
				else if(anterior.toLowerCase().contains("pedidos")) PantallaPedidos.main(null);*/
			}
		});
		
	}
	
}
