package estructuras;

public abstract class Metodos_pila_cola_ref_simple<T>{
	
	private Nodo cabeza;
	private Nodo cola;
	private int tamano;
	
	
	public Metodos_pila_cola_ref_simple() {
		
		cabeza = null;
		cola = null;
		tamano = 0;
	}
	
			
		
		protected void agregar_al_final(T item) {
			
			Nodo n = new Nodo(item);
			
			if(cola != null) {
				
				cola.siguiente=n;
				cola=n;
			}else {
				
				cabeza = n;
				cola = n;
			}
			
			tamano++;
			
		}
		
		protected void agregar_al_comienzo(T item) {
			
			Nodo n = new Nodo(item);
			
			if(cabeza != null) {
				
			    n.siguiente = cabeza;
			    cabeza = n;
			}else {
				
				cabeza = n;
				cola = n;
			}
			
			tamano++;
			
		}
		
		protected void eliminar_al_comienzo() {
			
			if(cabeza != null) {
				
			    cabeza = cabeza.siguiente;
			    if(cabeza == null) {  cola = null; }
			    
			    tamano--;
			    
			}else {
				
				System.out.println("No fue posible la eliminación, la "+this.getClass().getSimpleName()+" está vacía");
			}
		
		}
		
		//O(n)
		protected void eliminar_al_final() {
			
		
			if(cabeza != null) {
				
				
				if(cabeza.siguiente == null) {
					
					cabeza = null;
					cola = null;
					
				}else {
					
					Nodo auxiliar = cabeza;
				    while(auxiliar.siguiente.siguiente != null) {
					
					    auxiliar = auxiliar.siguiente;
					
				    }
				
				auxiliar.siguiente = null;
				cola = auxiliar;
				}
				
				tamano--;
				
			}else {
				
				System.out.println("No fue posible la eliminación, la "+this.getClass().getSimpleName()+" está vacía");
			}
		}
		
		
		/////////////////////////////////////
		public Nodo getCabeza() {
			return cabeza;
		}

		public void setCabeza(Nodo cabeza) {
			this.cabeza = cabeza;
		}

		public Nodo getCola() {
			return cola;
		}

		public void setCola(Nodo cola) {
			this.cola = cola;
		}

		public int getTamano() {
			return tamano;
		}

		public void setTamaño(int tamaño) {
			this.tamano = tamaño;
		}
        /////////////////////////////////////
		
		public void imprimir() {
			
            Nodo auxiliar = cabeza;
            
            if(cabeza != null) {
            	
            	while(auxiliar.siguiente != null) {
                	
                	System.out.print(auxiliar.dato+", ");
                	auxiliar=auxiliar.siguiente;
                }
            	
            	System.out.println(auxiliar.dato);
            } else {
            	
            	System.out.println(this.getClass().getSimpleName()+" vacía");
            }
		}
		
		//------------------------------------------------

		public class Nodo {
			
			private T dato;
			
			private Nodo siguiente;
			
			Nodo(T d){
				dato=d;
				siguiente = null;
			}

			public T getDato() {
				return dato;
			}

			public void setDato(T dato) {
				this.dato = dato;
			}

			public Nodo getSiguiente() {
				return siguiente;
			}

			public void setSiguiente(Nodo siguiente) {
				this.siguiente = siguiente;
			}
			
			
			
		}
		
		//------------------------------------------------

}
