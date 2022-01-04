package datos;

import java.awt.Image;

public class Producto {
	
	private String id;
	private String no;
	private String des;
	private long pre;
	private Image im;
	private int can;
	
	Producto(String identificacion, String nombre, String descripcion, long precio, Image imagen, int cantidad){
		
		id = identificacion;
		no = nombre;
		des = descripcion;
		pre = precio;
		im = imagen;
		can = cantidad;
	}
	
	

}
