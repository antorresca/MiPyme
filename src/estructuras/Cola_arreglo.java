package estructuras;

public class Cola_arreglo<T> extends Metodos_pila_cola_arreglo <T> {
	
	
   public Cola_arreglo(int tamano_arreglo) {
		
		super(tamano_arreglo);
	}
	
    public void encolar(T item) {
		
		agregar_al_final(item);
	}
	
	public void desencolar() {
		
		eliminar_al_comienzo();
	}

}
