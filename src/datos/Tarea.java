package datos;

public class Tarea {
	
	private String titulo;
	private String descripcion;
	private Usuario realizador;
	
	public Tarea(String titulo_tarea, String descripcion_tarea, Usuario realizador_tarea) {
		
		titulo = titulo_tarea;
		descripcion = descripcion_tarea;
		realizador = realizador_tarea;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getRealizador() {
		return realizador;
	}

	public void setRealizador(Usuario realizador) {
		this.realizador = realizador;
	}

	@Override
	public String toString() {
		return this.titulo;
	}
	
	

}
