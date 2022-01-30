package datos;

import java.awt.Image;

public class Producto { //Se añadieron getter y funcion Imprimir
	
	private String id;
	private String no;
	private String des;
	private long pre;
	private Image im;
	private int can;
	
	
	/**
	 * @param can the can to set
	 */
	public void setCan(int can) {
		this.can = can;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @return the des
	 */
	public String getDes() {
		return des;
	}

	/**
	 * @return the pre
	 */
	public long getPre() {
		return pre;
	}

	/**
	 * @return the im
	 */
	public Image getIm() {
		return im;
	}

	/**
	 * @return the can
	 */
	public int getCan() {
		return can;
	}
	
	public Producto(String identificacion, String nombre, String descripcion, long precio, Image imagen, int cantidad){
		
		id = identificacion;
		no = nombre;
		des = descripcion;
		pre = precio;
		im = imagen;
		can = cantidad;
	}
	
	public String imprimir() {
		String.format("%6s", no);
		return " "+ String.format("%-6s", no) + " | " + String.format("%-8s",  ("$"+pre))+  " | "+ String.format("%-8s", can);
	}

}
 