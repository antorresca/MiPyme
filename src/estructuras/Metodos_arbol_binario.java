package estructuras;

public abstract class Metodos_arbol_binario <T> {
	private Nodo raiz;
	public Nodo getRaiz() {
		return raiz;
	}
	
	Metodos_arbol_binario(){
		raiz = null;
	}
	
	protected void agregar(T item) {
		
		Nodo nuevoNodo = new Nodo(item);
		
		Nodo auxiliar = raiz;
		
		boolean compuerta = true;
		
		if (raiz==null) {
			raiz = nuevoNodo;
			compuerta = false;
			System.out.print("wtf");
		}
		
		while(compuerta) {
		
		if((int)item >= (int)auxiliar.dato) {
			
			if(auxiliar.derecha == null) {
			  
				auxiliar.derecha = nuevoNodo;
				compuerta = false;
			}else {
				auxiliar = auxiliar.derecha;
			}
		}else {
			
			if(auxiliar.izquierda == null) {
				  
				auxiliar.izquierda = nuevoNodo;
				compuerta = false;
			}else {
				auxiliar = auxiliar.izquierda;
			}
			
		}
	    
		}
	}
	
	
/////////////////////////////////////


//------------------------------------------------
	public class Nodo {

		private T dato;
		private Nodo derecha;
		private Nodo izquierda;

		Nodo(T d){

			this.dato=d;
			this.derecha  = null;
			this.izquierda = null;
		}

		public T getDato() {
			return dato;
		}

		public void setDato(T dato) {
			this.dato = dato;
		}

		public Nodo getDerecha() {
			return derecha;
		}

		public void setDerecha(Nodo derecha) {
			this.derecha = derecha;
		}

		public Nodo getIzquierda() {
			return izquierda;
		}

		public void setAnterior(Nodo izquierda) {
			this.izquierda = izquierda;
		}

	}

	//------------------------------------------------

}
