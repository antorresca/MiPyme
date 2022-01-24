package estructuras;

public class Cola_ref_simple<T> extends Metodos_pila_cola_ref_simple<T> {
	
	
	public void encolar(T item) {
		
		agregar_al_final(item);
	}
	
	public Nodo desencolar() {
		
		return eliminar_al_comienzo();
	}
	

}
