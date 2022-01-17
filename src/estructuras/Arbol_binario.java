package estructuras;

public class Arbol_binario<T> extends Metodos_arbol_binario <T>{
	
	public void imprimir(Nodo actual) {
		
		if(actual != null){
			//System.out.print(" "+x.getDato()+" ");//
			imprimir(actual.getIzquierda());
			System.out.print(" "+actual.getDato()+" ");//in order
			imprimir(actual.getDerecha());
			//System.out.print(" "+actual.getDato()+" ");//
		}
	}
	
	public int getTamano() {
		return getTamanoN();
	}
	
	public void agregarA(T item) {
		agregar(item);
	}
	
	public Nodo encontrarN(T item) {
		return encontrar(item);
	}
	
	public Nodo eliminarD(T item) {
		return eliminar(item);
	}
	
	public Nodo getRaizA() {
		return getRaiz();
	}
}