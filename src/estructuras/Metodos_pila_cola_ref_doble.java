package estructuras;

public abstract class Metodos_pila_cola_ref_doble<T>{
	
	private Nodo cabeza;
	private Nodo cola;
	private int tamano;
	
	
	public Metodos_pila_cola_ref_doble() {
		
		cabeza = null;
		cola = null;
		tamano = 0;
	}
	
		protected void agregar_al_final(T item) {
			
			Nodo n = new Nodo(item);
            //Node newNode = new Node(data);
            if (this.cabeza == null){
               this.cabeza = n;
               this.cola = this.cabeza;
            }else{
               if(this.cabeza.siguiente==null) this.cola = this.cabeza;
               this.cola.siguiente = n;
               n.anterior = this.cola;
               this.cola = this.cola.anterior;        
            }
			tamano++;
		}
		
		protected void agregar_al_comienzo(T item) {
			//revisar
			Nodo n = new Nodo(item);
			
			if(cabeza != null) {
			  n.siguiente = cabeza;
              cabeza.anterior = n;
			  cabeza = n;
			}else {
			  cabeza = n;
			  cola = n;
			}
			
			tamano++;
		}
		
		protected void eliminar_al_comienzo() {
			
			if (this.cabeza == null){
               System.out.println("No fue posible la eliminaci�n, la "+this.getClass().getSimpleName()+" est� vac�a");
            } else {        
               if(this.cabeza == this.cola){
                  this.cola = null;
                  this.cabeza = null;
               }else if(this.cabeza.siguiente!=null){
                  this.cabeza = this.cabeza.siguiente;
               }
            tamano--;
      
            }
		}
		
		
		protected void eliminar_al_final() {
			
			if (this.cabeza == null){
				
               System.out.println("No fue posible la eliminaci�n, la "+this.getClass().getSimpleName()+" est� vac�a");
            }else{ 
            	
               if(this.cabeza == this.cola){
            	   
                 this.cabeza = null;
                 this.cola = null;
               }else{
            	   
                 this.cola = this.cola.anterior;
                 this.cola.siguiente = null;
               }
               
               tamano--;
             }	
			
		}
		
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

		public void setTamano(int tamano) {
			this.tamano = tamano;
		}
        /////////////////////////////////////
	
		
		//------------------------------------------------

        public class Nodo {
			
		private T dato;
		private Nodo siguiente;
        private Nodo anterior;
			
			Nodo(T d){
				
				this.dato=d;
				this.siguiente = null;
                this.anterior = null;
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

			public Nodo getAnterior() {
				return anterior;
			}

			public void setAnterior(Nodo anterior) {
				this.anterior = anterior;
			}
			
		}
		
		//------------------------------------------------

}