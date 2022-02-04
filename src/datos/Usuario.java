package datos;

public class Usuario {
	
	private String usuario;
	private String contrasena;
	private boolean admin = false;
	
	
	
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}


	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}


	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
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
	
	public Usuario(String nombre_usuario, String contrasena_usuario, boolean is_admin) {
		usuario = nombre_usuario;
		contrasena = contrasena_usuario;
		admin = is_admin;
	}
}
