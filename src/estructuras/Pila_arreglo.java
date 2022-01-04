package estructuras;

public class Pila_arreglo<T> extends Metodos_pila_cola_arreglo<T> {
	
	
    public Pila_arreglo(int tamaño_arreglo) {
		
		super(tamaño_arreglo);
	}
	
    public void push(T item) {
		
		agregar_al_final(item);
	}
	
	public void pop() {
		
		eliminar_al_final();
	}

}
