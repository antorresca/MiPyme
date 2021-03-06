package estructuras;

import javax.swing.DefaultListModel;

import datos.Usuario;
import datos.Producto;
import estructuras.Metodos_arbol_binario.Nodo;
import logica.Ejecucion;

public class Arbol_avl <T>{
	Nodo raiz;

	// AVL tree implementation in Java

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public void imprimirEnOrden(Nodo node) {
        if (node != null) {
        	imprimirEnOrden(node.getIzquierda());
        	System.out.println(node.getDato());
        	imprimirEnOrden(node.getDerecha());
        }
    }
	
	public void usuarioEnOrden(Nodo node, DefaultListModel modelo) {
        if (node != null) {
        	usuarioEnOrden(node.getIzquierda(), modelo);
        	modelo.addElement(((Usuario)node.getDato()).getUsuario() + " | " + (((Usuario)node.getDato()).isAdmin()?"Administrador":"Empleado"));
        	usuarioEnOrden(node.getDerecha(), modelo);
        }
    }
	
	public void productoEnOrden(Nodo node, DefaultListModel modelo) {
        if (node != null) {
        	productoEnOrden(node.getIzquierda(), modelo);
        	modelo.addElement(((Producto)node.getDato()).imprimir());
        	productoEnOrden(node.getDerecha(), modelo);
        }
    } 
	Nodo salida;
	private Nodo obtenerIdProductoPorNombre(Nodo node, String nombre) {
		
		
        if (node != null) {
        	obtenerIdProductoPorNombre(node.getIzquierda(), nombre);
        	if(((Producto)node.getDato()).getNo().equals(nombre)) {
        		//System.out.println(((Producto)node.getDato()).getNo());
        		salida =  node;
        		return salida;
        	}
        	obtenerIdProductoPorNombre(node.getDerecha(), nombre);
        	
        }else {
        	return null;
        }
        
        return salida;
    } 
	
	// Create Nodo
	public class Nodo {
		int altura;
		T dato;
		Nodo izquierda, derecha; //padre;

		Nodo(T dato) {
			this.dato = dato;
			altura = 1;
		}
		
		public T getDato() {
			return dato;
		}

		public void setDato(T dato) {
			this.dato = dato;
		}
		public Nodo getIzquierda() {
			return izquierda;
		}

		public void setIzquierda(Nodo izquierda) {
			this.izquierda = izquierda;
		}

		public Nodo getDerecha() {
			return derecha;
		}

		public void setDerecha(Nodo derecha) {
			this.derecha = derecha;
		}

	}

	// Tree class
	public void insertar(T objeto) {
		raiz = insertarNodo(raiz, objeto);
	}
	
	public Nodo encontrar(T objeto) {
		return encontrarNodo(raiz, objeto);
	}
	
	public Nodo encontrar_por_nombre(String nombre) { //Esta pensado para ser usado con productos
		salida = null;
		if (obtenerIdProductoPorNombre(raiz, nombre)!=null) {
			//System.out.println(obtenerIdProductoPorNombre(raiz, nombre));
			
			return encontrarNodo(raiz, obtenerIdProductoPorNombre(raiz, nombre).getDato());
		}else
			return null;
	}
	
	public Nodo eliminar(T objeto) {
		return eliminarNodo(raiz, objeto);
	}
	
	public int comparacion(T itemA, T itemB) {
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
		}else if (clase.equals("Producto")) {
			es_mayor = ((Producto) itemA).getId() - ((Producto) itemB).getId();
		}
		/*
		switch(clase) {
		case "String":
			es_mayor = ((String) itemA).toLowerCase().compareTo(((String) itemB).toLowerCase());
			if (es_mayor == 0) {
				es_mayor = ((String) itemA).compareTo((String) itemB);
			}
		case "Integer":
			es_mayor= ((int)itemA - (int)itemB) ;
		case "Usuario ":
			es_mayor = (((Usuario) itemA).getUsuario()).toLowerCase().compareTo((((Usuario) itemB).getUsuario()).toLowerCase());
			if (es_mayor == 0) {
				es_mayor = (((Usuario) itemA).getUsuario()).compareTo(((Usuario) itemB).getUsuario());
			}
		case "Producto ":
			es_mayor = ((Producto) itemA).getId() - ((Producto) itemB).getId();
			
		}*/
		return es_mayor;
	}
	
	

	private int altura(Nodo N) {
		if (N == null)
			return 0;
		return N.altura;
	}

	private String max(String a, String b) {//es un easter egg nunca se usa XD
		return (a.toLowerCase().compareTo(b.toLowerCase()) >= 0) ? a : b;
	}

	private int maxInt(int a, int b) {
		return (a > b) ? a : b;
	}

	Nodo rotacionDer(Nodo y) {
		Nodo x = y.izquierda;
		Nodo T2 = x.derecha;
		x.derecha = y;
		y.izquierda = T2;
		//x.padre = y.padre;
		//y.padre = x;
		//if(T2!=null) T2.padre = y;
		y.altura = maxInt(altura(y.izquierda), altura(y.derecha)) + 1;
		x.altura = maxInt(altura(x.izquierda), altura(x.derecha)) + 1;
		return x;
	}

	private Nodo rotacionIz(Nodo x) {
		Nodo y = x.derecha;
		Nodo T2 = y.izquierda;
		y.izquierda = x;
		x.derecha = T2;
		//y.padre = x.padre;
		//x.padre = y;
		//if(T2!=null) T2.padre = x;
		x.altura = maxInt(altura(x.izquierda), altura(x.derecha)) + 1;
		y.altura = maxInt(altura(y.izquierda), altura(y.derecha)) + 1;
		return y;
	}

	// Get balance factor of a Nodo
	private int getBalanceFactor(Nodo N) {
		if (N == null)
			return 0;
		return altura(N.izquierda) - altura(N.derecha);
	}

	// Insert a Nodo
	private Nodo insertarNodo(Nodo Nodo, T item) {

		// Find the position and insert the Nodo
		if (Nodo == null)
			return (new Nodo(item));
		if (comparacion(item,  Nodo.dato) < 0 ){
			Nodo.izquierda = insertarNodo(Nodo.izquierda, item);
			//Nodo.izquierda.padre = Nodo;
		}else if (comparacion(item,  Nodo.dato) > 0){
			Nodo.derecha = insertarNodo(Nodo.derecha, item);
			//Nodo.derecha.padre = Nodo;
		}else
			return Nodo;

		// Update the balance factor of each Nodo
		// And, balance the tree
		Nodo.altura = 1 + maxInt(altura(Nodo.izquierda), altura(Nodo.derecha));
		int balanceFactor = getBalanceFactor(Nodo);
		if (balanceFactor > 1) {
			if (comparacion(item,  Nodo.izquierda.dato) < 0) {
				return rotacionDer(Nodo);
			} else if (comparacion(item,  Nodo.izquierda.dato) > 0) {
				Nodo.izquierda = rotacionIz(Nodo.izquierda);
				return rotacionDer(Nodo);
			}
		}
		if (balanceFactor < -1) {
			if (comparacion(item,  Nodo.derecha.dato) > 0) {
				return rotacionIz(Nodo);
			} else if (comparacion(item,  Nodo.derecha.dato) < 0) {
				Nodo.derecha = rotacionDer(Nodo.derecha);
				return rotacionIz(Nodo);
			}
		}
		return Nodo;
	}
	
	private Nodo eliminarNodo(Nodo root, T item) {

		// Find the Nodo to be deleted and remove it
		if (root == null)
			return root;
		if (comparacion(item,  root.dato) < 0)
			root.izquierda = eliminarNodo(root.izquierda, item);
		else if (comparacion(item,  root.dato) > 0)
			root.derecha = eliminarNodo(root.derecha, item);
		else {
			if ((root.izquierda == null) || (root.derecha == null)) {
				Nodo temp = null;
				if (temp == root.izquierda)
					temp = root.derecha;
				else
					temp = root.izquierda;
				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;
			} else {
				Nodo temp = hijoMenor(root.derecha);
				root.dato = temp.dato;
				root.derecha = eliminarNodo(root.derecha, temp.dato);
			}
		}
		if (root == null)
			return root;

		// Update the balance factor of each Nodo and balance the tree
		root.altura = maxInt(altura(root.izquierda), altura(root.derecha)) + 1;
		int balanceFactor = getBalanceFactor(root);
		if (balanceFactor > 1) {
			if (getBalanceFactor(root.izquierda) >= 0) {
				return rotacionDer(root);
			} else {
				root.izquierda = rotacionIz(root.izquierda);
				return rotacionDer(root);
			}
		}
		if (balanceFactor < -1) {
			if (getBalanceFactor(root.derecha) <= 0) {
				return rotacionIz(root);
			} else {
				root.derecha = rotacionDer(root.derecha);
				return rotacionIz(root);
			}
		}
		return root;
	}
	

	
	private Nodo encontrarNodo(Nodo Nodo, T nombre){
		Nodo current = Nodo;

		if (current == null)
			return null;//esto toca cambiarlo
		if (comparacion(nombre,  current.dato) < 0 ){
			return encontrarNodo(current.izquierda, nombre);
		}else if (comparacion(nombre,  current.dato) > 0){
			return encontrarNodo(current.derecha, nombre);
		}else
			return current;
	}
	
	private Nodo encontrarNodo_por_id(Nodo Nodo, T nombre){
		Nodo current = Nodo;

		if (current == null)
			return null;//esto toca cambiarlo
		if (comparacion(nombre,  current.dato) < 0 ){
			return encontrarNodo(current.izquierda, nombre);
		}else if (comparacion(nombre,  current.dato) > 0){
			return encontrarNodo(current.derecha, nombre);
		}else
			return current;
	}

	public Nodo hijoMenor(Nodo Nodo){
		if(Nodo.izquierda!=null) return hijoMenor(Nodo.izquierda);
		else return Nodo;
	}

	public Nodo hijoMayor(Nodo Nodo){
		if(Nodo.derecha!=null) return hijoMayor(Nodo.derecha);
		else return Nodo;
	}



}
