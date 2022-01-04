package estructuras;

public class Cola_arreglo_dinamico<T> extends Metodos_pila_cola_arreglo_dinamico<T>{
	
    public void encolar(T item) {
		
		agregar_al_final(item);
	}
	
	public void desencolar() {
		
		eliminar_al_comienzo();
	}

}
