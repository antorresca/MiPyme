package datos;

import estructuras.Lista_ref_simple;

public class Carrito {
	
	private Lista_ref_simple<Producto> productos;
	private Usuario usuario;
	
	public Carrito(Usuario usuario_cliente) {
       
		usuario = usuario_cliente;
		productos = new Lista_ref_simple<Producto>();
	}
	
	public void agregar(Producto item) {
		
		productos.agregar(item);
		
	}
	
	

}
