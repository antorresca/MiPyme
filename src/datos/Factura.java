package datos;

import estructuras.Lista_ref_simple;

public class Factura {

	private int id;
	private String nombre;
	private String cedula;
	private String correo;
	public String fecha;
	public Usuario vendedor;
	public Lista_ref_simple<Producto> productos;
	private static int contador = 0;
	private long precio = 0;

	public Factura(String nombre_cliente, String cedula_cliente, String correo_cliente, String fecha_factura
			, Usuario vendedor2, Lista_ref_simple<Producto> productos2){
		
		cedula = cedula_cliente;
		id =  contador++;
		nombre = nombre_cliente;
		correo = correo_cliente;
		fecha = fecha_factura;
		vendedor = vendedor2;
		productos = productos2;
		setPrecio();
	}
	
	
	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public long getPrecio() {
		return precio;
	}

	public void setPrecio() {
		for(int i = 0; i<productos.getTamano();i++) {
			precio += productos.encontrar(i).getDato().getPre();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Lista_ref_simple<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Lista_ref_simple<Producto> productos) {
		this.productos = productos;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Factura.contador = contador;
	}

}