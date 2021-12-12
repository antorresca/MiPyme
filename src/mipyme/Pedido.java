package mipyme;

public class Pedido {
	
	private String nu;
	private String no;
	private String ar;
	
	Pedido(String nombreDelComprador, String numeroDeCelular, String articulos){
		no=nombreDelComprador;
		nu=numeroDeCelular;
		ar=articulos;
	}

	public String getNu() {
		return nu;
	}

	public void setNu(String nu) {
		this.nu = nu;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getAr() {
		return ar;
	}

	public void setAr(String ar) {
		this.ar = ar;
	}
	
	

}
