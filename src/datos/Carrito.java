package datos;

import estructuras.Lista_ref_simple;
import interfaz.Ventana;

public class Carrito { //Se añadió funcion para obtener los productos
	
	private Lista_ref_simple<Producto> productos;
	private Usuario usuario;
	
	public Carrito(Usuario usuario_cliente) {
       
		usuario = usuario_cliente;
		productos = new Lista_ref_simple<Producto>();
	}
	
	public void agregar(Producto item) {
		
		productos.agregar(item);
		
	}
	
	public Lista_ref_simple<Producto> obtenerProductos() {
		return productos; 
	}	

}
