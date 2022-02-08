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
		String entrada = "";
		
		Ventana pantalla_factura = new Ventana("Factura");
		pantalla_factura.desactivar();
		if(!flag) {
			while(n == -1) {
				entrada = JOptionPane.showInputDialog(pantalla_factura,"Ingrese numero de la factura","Busqueda de Factura");
				try {
					n = (entrada=="")?-2:(entrada.equals("Busqueda de Factura"))?-1:Integer.valueOf(entrada);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(pantalla_factura,"Entrada invalida","Solo numeros validos",JOptionPane.ERROR_MESSAGE);
				}

			}
		}
		try {
			
			Factura nuevaFactura;
			//if(!flag) nuevaFactura = Ejecucion.facturas.encontrar(n).getDato();
			
			if(!flag) { 
				nuevaFactura = Ejecucion.facturas.buscar(n);
			}else {
				nuevaFactura = Ejecucion.pedidos.getCabeza().getDato();
			}
			
			pantalla_factura.desactivar();
			
			if(!flag) {
				VerFactura.main("menu",nuevaFactura);
			}else {
				VerFactura.main("pedidos",nuevaFactura);
			}
			
		}catch(Exception exp) {
			pantalla_factura.desactivar();
			PantallaMenu.main(null);
			if(n!=-2)JOptionPane.showMessageDialog(pantalla_factura,"Factura no encontrada","Factura no encontrada",JOptionPane.ERROR_MESSAGE);
		}
		

	}

}
