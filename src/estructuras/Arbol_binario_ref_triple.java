package estructuras;

import datos.Usuario;

public class Arbol_binario_ref_triple<T> {
	
	public Nodo raiz;
	private int tamano;
	
	
	public Arbol_binario_ref_triple() {
		
		raiz = null;
		tamano = 0;
	}

	public void agregar(T item) {

		Nodo nuevoNodo = new Nodo(item);
		Nodo auxiliar = raiz;
		boolean compuerta = true;

		if (raiz==null) {
			raiz = nuevoNodo;
			compuerta = false;
		}

		while(compuerta) {
			
			switch(es_mayor(item, auxiliar.dato)) {
			
			case 1:
				if(auxiliar.hijo_i == null) {

					auxiliar.hijo_i = nuevoNodo;
					nuevoNodo.padre = auxiliar;
					compuerta = false;
				}else {
					auxiliar = auxiliar.hijo_i;
				}
				tamano++;
				break;
				
			case 2:
				if(auxiliar.hijo_d == null) {

					auxiliar.hijo_d = nuevoNodo;
					nuevoNodo.padre = auxiliar;
					compuerta = false;
				}else {
					auxiliar = auxiliar.hijo_d;
				}
				tamano++;
				break;
				
			case -1:
				System.out.println("OBJETO NO DEFINIDO");
				compuerta = false;
			}
		}
	}
	
	public int es_mayor(T itemA, T itemB) {
		
		switch(itemA.getClass().getSimpleName()) {
		
		  case "Integer":
			  
              if((int)itemA > (int)itemB) {
				  
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
		
		//------------------------------------------------

}
