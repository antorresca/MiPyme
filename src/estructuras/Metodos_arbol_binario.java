package estructuras;
import javax.swing.DefaultListModel;

import datos.Usuario;
import logica.Ejecucion;

public abstract class Metodos_arbol_binario <T> {
	private Nodo raiz;
	private int tamano;
	
	public Nodo getRaiz() {
		return raiz;
	}
	
	Metodos_arbol_binario(){
		raiz = null;
	}
	
	protected int getTamanoN() {
		
		return tamano;
	}
	
	protected void agregar(T item) {
		
		Nodo nuevoNodo = new Nodo(item);
		
		Nodo auxiliar = raiz;
		
		tamano++;
		
		boolean compuerta = true;
		
		int aux = 0;
		
		if (raiz==null) {
			raiz = nuevoNodo;
			compuerta = false;
		}
		
		while(compuerta) {
			
			
			aux = comparacion(item, auxiliar.dato);
			
			if(aux >= 0) {

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
	
	protected Nodo encontrar(T item) {

		Nodo auxiliar = raiz;

		boolean compuerta = true;
		
		int aux = 1;
		
		if (raiz==null) {
			System.out.println("Este arbol_binario esta vacío :c");
			compuerta = false;
		}
		
		while(compuerta) {

			aux = comparacion(item, auxiliar.dato);

			if(aux > 0) {

				if(auxiliar.derecha == null) {
					
					compuerta = false;
					
					
				}else {
					auxiliar = auxiliar.derecha;
				}
			}else if (aux < 0){

				if(auxiliar.izquierda == null) {
					
					compuerta = false;
					
				}else {
					auxiliar = auxiliar.izquierda;
				}

			}else {
				compuerta = false;
			}

		}
		
		if (aux == 0) {
			return auxiliar;
		}else {
			//Nodo noExiste = new Nodo("Este dato NO existe en el arbol_binario :c");
			System.out.println("No existe :c");
			//return noExiste;
			return null;
		}
	}

	protected int comparacion(T itemA, T itemB) {
		String clase = itemA.getClass().getSimpleName();
		int es_mayor = 0; 
		
		if (clase.equals("String")) {
			es_mayor = ((String) itemA).toLowerCase().compareTo(((String) itemB).toLowerCase());
			if (es_mayor == 0) {
				es_mayor = ((String) itemA).compareTo((String) itemB);
			}
		}else if (clase.equals("Integer")) {
			es_mayor= ((int)itemA - (int)itemB) ;
		}else if (clase.equals("Usuario")) {
			es_mayor = (((Usuario) itemA).getUsuario()).toLowerCase().compareTo((((Usuario) itemB).getUsuario()).toLowerCase());
			if (es_mayor == 0) {
				es_mayor = (((Usuario) itemA).getUsuario()).compareTo(((Usuario) itemB).getUsuario());
			}
		}
		return es_mayor;
	}
	
	protected Nodo eliminar(T item){

		Nodo auxiliar = raiz;
		
		Nodo eliminado;
		
		Nodo padre = auxiliar;

		boolean compuerta = true;
		
		int aux = 1;
		
		if (raiz==null) {
			System.out.println("Este arbol_binario esta vacío :c");
			compuerta = false;
		}else if (raiz.derecha == null && raiz.izquierda == null) {
			eliminado = auxiliar;
			if(comparacion(item, auxiliar.dato)==0) {
				raiz = null;	
			}
			compuerta = false;
		}
		
		while(compuerta) {

			aux = comparacion(item, auxiliar.dato);

			if(aux > 0) {

				if(auxiliar.derecha == null) {
					
					compuerta = false;
					
					
				}else {
					padre = auxiliar;
					auxiliar = auxiliar.derecha;
				}
			}else if (aux < 0){

				if(auxiliar.izquierda == null) {
					
					compuerta = false;
					
				}else {
					padre = auxiliar;
					auxiliar = auxiliar.izquierda;
				}

			}else {
				compuerta = false;
			}

		}
		eliminado = auxiliar;//////////////
		
		if (raiz == null) {
			
		}else if(auxiliar.izquierda != null) {
			padre = auxiliar;
			auxiliar = auxiliar.izquierda;
			while(auxiliar.derecha!=null) {
				padre = auxiliar;
				auxiliar = auxiliar.derecha;
			}
			
			//mover dato del menor
		}else if(auxiliar.derecha != null) {
			padre = auxiliar;
			auxiliar = auxiliar.derecha;
			//mover dato del mayor
			while(auxiliar.izquierda!=null) {
				padre = auxiliar;
				auxiliar = auxiliar.izquierda;
			}
		}
			
		
		if (aux == 0) {
			T temporal = eliminado.getDato();
			eliminado.setDato(auxiliar.getDato());
			auxiliar.setDato(temporal);
			
			if(padre.izquierda == auxiliar) {
				if(auxiliar.derecha!=null) {
					padre.izquierda = auxiliar.derecha;
				}else {
					padre.izquierda = null;
				}
				
			}else if(padre.derecha == auxiliar){
				padre.derecha = null;
				if(auxiliar.izquierda!=null) {
					padre.derecha = auxiliar.izquierda;
				}else {
					padre.derecha = null;
				}
			}
			return auxiliar;
		}else {
			//Nodo noExiste = new Nodo((T)"Este dato NO existe en el arbol_binario :c");
			System.out.println("No existe :c");
			//return noExiste;
			return null;
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