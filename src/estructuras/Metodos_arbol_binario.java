package estructuras;

public abstract class Metodos_arbol_binario <T> {
	private Nodo raiz;
	
	public class BinaryTree{
	    
	    
	    BinaryTree(T head){
	    	raiz = new Nodo(head);
	    }
	   
	    BinaryTree(){
	    	raiz = null;
	    }
	}
	
	protected void agregar(T item) {
		Nodo nodoActual = raiz;
		Nodo nuevoNodo = new Nodo(item);
	
		while (raiz.izquierda==null){
			
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
