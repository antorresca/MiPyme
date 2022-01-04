package estructuras;

public class Pila_arreglo_dinamico<T> extends Metodos_pila_cola_arreglo_dinamico<T>{
	
	public void push(T item) {
		
		agregar_al_final(item);
	}
	
	public void pop() {
		
		eliminar_al_final();
	}

}
