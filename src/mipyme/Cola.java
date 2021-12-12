package mipyme;


public class Cola {
	
private Nodo<Pedido> cabeza;
private Nodo<Pedido> cola;
private int tama�o;
	
	Cola(){
		
		cabeza = null;
	}
	
	
	public void encolar(Pedido p) {
		
		Nodo<Pedido> n = new Nodo<Pedido>(p);
		
		if(cola != null) {
			
			cola.siguiente=n;
			cola=n;
		}else {
			
			cabeza = n;
			cola=n;
		}
		
		tama�o++;
	}
	
	
	public void desencolar() {
		
		
		if(cabeza != null) {
			
			cabeza = cabeza.siguiente;
			
			if(cabeza == null) {  cola = null; }
			
			tama�o--;
		}
	}
	

	public Nodo<Pedido> getCabeza() {
		return cabeza;
	}

	public void setCabeza(Nodo<Pedido> cabeza) {
		this.cabeza = cabeza;
	}

	public Nodo<Pedido> getCola() {
		return cola;
	}

	public void setCola(Nodo<Pedido> cola) {
		this.cola = cola;
	}

	public int getTama�o() {
		return tama�o;
	}
	
	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
	}


	
	
	
	//------------------------------------------------

	public class Nodo<T> {
		
		private T dato;
		private Nodo<T> siguiente;
		
		Nodo(T d){
			dato=d;
			siguiente = null;
		}

		public T getDato() {
			return dato;
		}

		public void setDato(T dato) {
			this.dato = dato;
		}

		public Nodo<T> getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(Nodo<T> siguiente) {
			this.siguiente = siguiente;
		}
		
		
	}
	
	//------------------------------------------------


}
