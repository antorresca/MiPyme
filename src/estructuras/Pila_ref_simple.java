package estructuras;

public class Pila_ref_simple<T> extends Metodos_pila_cola_ref_simple<T> {
	
	
	public void push(T item) {
		
		agregar_al_comienzo(item);
	}
	
	public void pop() {
		
		eliminar_al_comienzo();
	}

}
