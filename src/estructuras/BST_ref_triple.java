package estructuras;

import datos.Usuario;

public class BST_ref_triple<T> {
	
	private Nodo raiz;
	private int tamano;


	public BST_ref_triple() {

		raiz = null;
		tamano = 0;
	}

	public boolean agregar(T item) {

		Nodo nuevoNodo = new Nodo(item);
		
		if (raiz==null) {
			raiz = nuevoNodo;
			tamano++;
			return true;
		}
		
		Nodo auxiliar = raiz;

		while(true) {

			switch(es_mayor(item, auxiliar.dato)) {

			case 1:
				if(auxiliar.hijo_i == null) {

					auxiliar.hijo_i = nuevoNodo;
					nuevoNodo.padre = auxiliar;
					balancear(auxiliar);
					tamano++;
					return true;
				}else {
					auxiliar = auxiliar.hijo_i;
				}
				break;

			case 2:
				if(auxiliar.hijo_d == null) {

					auxiliar.hijo_d = nuevoNodo;
					nuevoNodo.padre = auxiliar;
					balancear(auxiliar);
					tamano++;
					return true;
				}else {
					auxiliar = auxiliar.hijo_d;
				}
				break;

			case -1:
				System.out.println("OBJETO NO DEFINIDO");
				return false;
			}
		}
	}
	
	public Nodo eliminar(T item) {

		Nodo eliminado = encontrar(item);

		if(eliminado == null) {
			return null;
		}
		
		this.tamano--;

		Nodo retorno = new Nodo(eliminado.dato);

		if(eliminado.hijo_d != null) {

			Nodo aux = eliminado.hijo_d;

			while(aux.hijo_i != null) {

				aux = aux.hijo_i;
			}

			cambiar(eliminado,aux);


			if(aux == aux.padre.hijo_i) {

				aux.padre.hijo_i = aux.hijo_d;

			}else {

				aux.padre.hijo_d = aux.hijo_d;
			}


			if(aux.hijo_d != null) {
				aux.hijo_d.padre = aux.padre;
			}
			
			/////////////////////////////////////////////////////////////////////////
			if(aux.padre.hijo_d != null) {
				balancear(aux.padre.hijo_d);
			}else {
				if(aux.padre.hijo_i != null) {
					balancear(aux.padre.hijo_i);
				}else {
					balancear(aux.padre);
				}
			}
            /////////////////////////////////////////////////////////////////////////

		}else {

			if(eliminado.hijo_i != null) {

				Nodo aux = eliminado.hijo_i;

				while(aux.hijo_d != null) {

					aux = aux.hijo_d;
				}

				cambiar(eliminado,aux);

				if(aux == aux.padre.hijo_d) {

					aux.padre.hijo_d = aux.hijo_i;

				}else {

					aux.padre.hijo_i = aux.hijo_i;
				}

				if(aux.hijo_i != null) {
					aux.hijo_i.padre = aux.padre;
				}	

				/////////////////////////////////////////////////////////////////////////
				if(aux.padre.hijo_i != null) {
					balancear(aux.padre.hijo_i);
					
					System.out.println("Si entró");
				}else {
					if(aux.padre.hijo_d != null) {
						balancear(aux.padre.hijo_d);
						System.out.println("Si entró 2");
					}else {
						balancear(aux.padre);
						System.out.println("Si entró 3");
					}
				}
				/////////////////////////////////////////////////////////////////////////

			}else {

				if(eliminado.padre != null) {
					
					if(eliminado == eliminado.padre.hijo_d) {

						eliminado.padre.hijo_d = null;

					}else {

						eliminado.padre.hijo_i = null;
					}

					/////////////////////////////////////////////////////////////////////////
					if(eliminado.padre.hijo_i != null) {
						balancear(eliminado.padre.hijo_i);

					}else {
						if(eliminado.padre.hijo_d != null) {
							balancear(eliminado.padre.hijo_d);
			
						}else {
							balancear(eliminado.padre);
						}
					}
					/////////////////////////////////////////////////////////////////////////
				}else {

					this.raiz = null;
				}
			}	
		}
		
		return retorno;
	}
	
	public Nodo encontrar(T item) {

		Nodo nulo = null;

		if(this.raiz == null) {
			System.out.println("Arbol vacío");
			return nulo;
		}

		Nodo auxiliar = this.raiz;

		while(true) {

			if(son_iguales(item, auxiliar.dato)) {
				return auxiliar;
			}

			switch(es_mayor(item, auxiliar.dato)) {

			case 1:

				if(auxiliar.hijo_i != null) {
					auxiliar = auxiliar.hijo_i;
				}else {
					return nulo;
				}
				break;

			case 2:

				if(auxiliar.hijo_d != null) {

					auxiliar = auxiliar.hijo_d;
				}else {

					return nulo;	
				}
				break;

			case -1:
				System.out.println("OBJETO NO DEFINIDO");
				return nulo;
			}
		}	

	}
	
	public void cambiar(Nodo a, Nodo b) {
		
		T c = a.dato;
		a.dato = b.dato;
		b.dato = c;
	}

	public int es_mayor(T itemA, T itemB) {

		switch(itemA.getClass().getSimpleName()) {

		case "Integer":

			if((int)itemA < (int)itemB) {

				return 1;
			}else {
				return 2;
			}

		case "String":

			if(((String)itemA).toLowerCase().compareTo(((String)itemB).toLowerCase())<0) {

				return 1;
			}else {
				return 2;
			}

		case "Usuario":

			if((((Usuario)itemA).getUsuario()).toLowerCase().compareTo((((Usuario)itemB).getUsuario()).toLowerCase())<0) {

				return 1;
			}else {
				return 2;
			}
		default:
			return -1;
		}
	}

	public boolean son_iguales(T itemA, T itemB) {

		switch(itemA.getClass().getSimpleName()) {

		case "Integer":
			return (int)itemA == (int)itemB; 
		case "String":
			return ((String)itemA).equals((String)itemB);  
		default:
			return itemA == itemB;
		}
	}
	/*
	public void balancear(Nodo a) {
		
		System.out.println("no hace nada");
	}
	*/
    public void balancear(Nodo a) {
		
		System.out.println("no hace nada");
	}
    
	public void imprimir(Nodo actual) {

		if(actual != null){

			imprimir(actual.hijo_i);

			//impresión-----------------------------------------------
			String clase = actual.dato.getClass().getSimpleName();
			boolean puerta = true;

			if(clase.equals("Integer")||clase.equals("String")) {
				System.out.print(" "+actual.getDato()+" ");
				puerta = false;
			}

			if(clase.equals("Usuario")) {
				System.out.print(" "+((Usuario)actual.getDato()).getUsuario()+" ");
				puerta = false;
			}

			if(puerta) {
				//ninguno
			}
			//-------------------------------------------------------
			imprimir(actual.hijo_d);
		}
	}

	public void imprimir() {
		imprimir(this.raiz);
	}

	/////////////////////////////////////
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	/////////////////////////////////////

	public class Nodo {

		private T dato;
		private Nodo padre;
		private Nodo hijo_i;
		private Nodo hijo_d;

		Nodo(T d){

			this.dato=d;
			this.padre = null;
			this.hijo_i = null;
			this.hijo_i = null;
		}

		public T getDato() {
			return dato;
		}

		public void setDato(T dato) {
			this.dato = dato;
		}

		public Nodo getPadre() {
			return padre;
		}

		public void setPadre(Nodo padre) {
			this.padre = padre;
		}

		public Nodo getHijo_i() {
			return hijo_i;
		}

		public void setHijo_i(Nodo hijo_i) {
			this.hijo_i = hijo_i;
		}

		public Nodo getHijo_d() {
			return hijo_d;
		}

		public void setHijo_d(Nodo hijo_d) {
			this.hijo_d = hijo_d;
		}

	}

}
