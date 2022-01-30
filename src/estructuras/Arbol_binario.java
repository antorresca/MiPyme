package estructuras;

import javax.swing.DefaultListModel;

import datos.Usuario;
import estructuras.Metodos_arbol_binario.Nodo;

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
	
	
	public void usuarioEnOrden(Nodo node, DefaultListModel modelo) {
        if (node != null) {
        	usuarioEnOrden(node.getIzquierda(), modelo);
        	modelo.addElement(((Usuario)node.getDato()).getUsuario() + " | " + (((Usuario)node.getDato()).isAdmin()?"Administrador":"Empleado"));
        	usuarioEnOrden(node.getDerecha(), modelo);
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