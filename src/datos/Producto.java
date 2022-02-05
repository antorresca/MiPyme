package datos;

public class Producto { //Se añadieron getter y funcion Imprimir
	
	private int id;
	private String no;
	private String des;
	private long pre;
	private String im; //Ruta a la imagen
	private int can;
	public static int ultimoId = 0;
	
	
	/**
	 * @param can the can to set
	 */
	public void setCan(int can) {
		this.can = can;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @param des the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}

	/**
	 * @param pre the pre to set
	 */
	public void setPre(long pre) {
		this.pre = pre;
	}

	/**
	 * @param im the im to set
	 */
	public void setIm(String im) {
		this.im = im;
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
	public String getIm() {
		return im;
	}

	/**
	 * @return the can
	 */
	public int getCan() {
		return can;
	}
	
	public Producto(int identificacion, String nombre, String descripcion, long precio, String imagen, int cantidad){
		
		id = identificacion;
		no = nombre;
		des = descripcion;
		pre = precio;
		im = imagen;
		can = cantidad;
		
		
		ultimoId = (ultimoId>Integer.valueOf(id))?ultimoId:Integer.valueOf(id);
	}
	
	public Producto(int identificacion){

		id = identificacion;
		no = "buscador";
	}
	
	
	public String imprimir() {
		return " P"+ String.format("%-6s", id) + " | " + String.format("%-8s",  ("$"+pre))+  " | "+ String.format("%-8s", can);
	}

}
 