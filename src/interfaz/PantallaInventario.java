package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import datos.Producto;
import estructuras.Arbol_avl.Nodo;
import logica.Ejecucion;

public class PantallaInventario {

	@SuppressWarnings("rawtypes")
	static void main(String[] args) {

		DefaultListModel modelo6 = new DefaultListModel();
		
		
		Ejecucion.inventario.productoEnOrden(Ejecucion.inventario.getRaiz(),modelo6);
		
		Ventana pantallaInventario = new Ventana("Inventario");
		pantallaInventario.setBounds(550, 180, 400, 400);


		if(modelo6==null)modelo6.addElement("Jumm");

		JList listaProductos = new JList();
		listaProductos.setModel(modelo6);
		JScrollPane scroll = new JScrollPane(listaProductos);
		scroll.setBounds(30, 71, 200, 250);
		pantallaInventario.getContenedor().add(scroll);

		pantallaInventario.update(pantallaInventario.getGraphics());
		
		Texto lblId = new Texto("Ingrese el nombre del producto",pantallaInventario,30, 21+40, 200, 20);
		CampoL textField_buscar = new CampoL(pantallaInventario,30, 41, 150, 21);
		//textField_buscar.setText("");
		
		Boton buscar = new Boton("Q",pantallaInventario,180, 41, 50, 20);
		//buscar.volverIcono("buscar\r\n","Img\\MasClaro.png","Img\\MasOscuro.png");
		buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre_producto = textField_buscar.getText();
				if(!nombre_producto.equals("")) {
					//try {
					    Nodo comprobante =  Ejecucion.inventario.encontrar_por_nombre(nombre_producto);
					    if(comprobante == null) {
							JOptionPane.showMessageDialog(pantallaInventario,"Producto No Encontrado","No encontrado",JOptionPane.ERROR_MESSAGE);
						}else {
							Producto encontrado = (Producto)comprobante.getDato();
							pantallaInventario.setVisible(false);
							PantallaDetalles.main("inventario",encontrado);
						}
					
				}else {
					JOptionPane.showMessageDialog(pantallaInventario,"Debe ingresar alg\u00fan nombre","Ingrese un nombre",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		
		Boton agregar = new Boton("",pantallaInventario,260, 95, 89, 32);
		agregar.volverIcono("añadir\r\n","Img\\AgregarClaro.png","Img\\AgregarOscuro.png");
		
		agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaInventario.setVisible(false);
				
				Producto nuevo = new Producto(Producto.ultimoId, "Producto "+String.valueOf(Producto.ultimoId+1),"Este producto es...", 0, null, 0 );
				PantallaModificarProducto.main(nuevo,true);
			}
		});

		Boton modificar = new Boton("",pantallaInventario,260, 139, 89, 32);
		modificar.volverIcono("modificar\r\n","Img\\ModificarClaro.png","Img\\ModificarOscuro.png");
		modificar.addMouseListener(new MouseAdapter() {
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
					System.out.println(Ejecucion.inventario.encontrar( new Producto(Integer.valueOf(valor))));
					pantallaInventario.desactivar();
					PantallaModificarProducto.main(Ejecucion.inventario.encontrar( new Producto(Integer.valueOf(valor))).getDato(), false);
				}
			}	
		});

		Boton eliminarUsuario = new Boton("",pantallaInventario,260, 183, 89, 32);
		eliminarUsuario.volverIcono("eliminar\r\n","Img\\EliminarClaro.png","Img\\EliminarOscuro.png");
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
					Ejecucion.inventario.eliminar( new Producto(Integer.valueOf(valor)));
					JOptionPane.showMessageDialog(pantallaInventario,"Eliminacion exitosa","Usuario Eliminado",JOptionPane.INFORMATION_MESSAGE);
					modelo6.remove(listaProductos.getSelectedIndex());


				}
			}
		});

		Boton regresarPedidos = new Boton("",pantallaInventario,285, 247, 40, 40);
		regresarPedidos.volverIcono("volver\r\n");
		regresarPedidos.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.RegresarO:PantallaMenu.RegresarC);
		regresarPedidos.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaInventario.desactivar();
				PantallaMenu.main(null);
			}});

	}

}
