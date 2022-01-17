package datos;

public class Usuario {
	
	private String usuario;
	private String contrasena;
	
	
	
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}


	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}



	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public Usuario(String nombre_usuario, String contrasena_usuario) {
		
		usuario = nombre_usuario;
		contrasena = contrasena_usuario;
		
	}

}
