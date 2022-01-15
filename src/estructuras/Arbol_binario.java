package estructuras;

public class Arbol_binario<T> extends Metodos_arbol_binario <T>{
	
	public void imprimir(Nodo x) {
		
		if(x != null){
			System.out.print(x.getDato());
			imprimir(x.getIzquierda());
			imprimir(x.getDerecha());
		}
	}
	
	public void agregarA(T item) {
		agregar(item);
	}
	
	public Nodo getRaizA() {
		return getRaiz();
	}
}
