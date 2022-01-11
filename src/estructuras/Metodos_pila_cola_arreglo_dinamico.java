package estructuras;


public abstract class Metodos_pila_cola_arreglo_dinamico<T> {
	
	private T[] arreglo;
	private int tamano;
	
	
	public Metodos_pila_cola_arreglo_dinamico() {
		
		arreglo = (T[]) new Object[1];
		
		tamano = 0;
	}
	
	
	protected void agregar_al_final(T item) {
		
		try {
		
		arreglo[tamano] = item;
		
		} catch (ArrayIndexOutOfBoundsException e) {
			
			
			T[] arreglo2 = (T[]) new Object[arreglo.length*2];
			
			for(int i=0; i<tamano; i++) {
				
				arreglo2[i] = arreglo[i]; 
			}
			
			arreglo = arreglo2;
			
			arreglo[tamano] = item;
		}
		
		tamano++;
		
	}
	
	protected void agregar_al_comienzo(T item) {
		
		try {
		
		  for(int i=0; i<tamano; i++) {
			
			  arreglo[tamano-i] = arreglo[tamano-1-i];
		  }
		  
		  arreglo[0] = item;
		  
		} catch (ArrayIndexOutOfBoundsException e) {
			
            T[] arreglo2 = (T[]) new Object[arreglo.length*2];
			
			for(int i=0; i<tamano; i++) {
				
				arreglo2[i] = arreglo[i]; 
			}
			
			arreglo = arreglo2;
			
			for(int i=0; i<tamano; i++) {
				
				  arreglo[tamano-i] = arreglo[tamano-1-i];
				
			}
			
			arreglo[0] = item;	
		}
		
		if(tamano == 0) { arreglo[0]=item;}
		
		tamano++;
		
	}
	
	protected void eliminar_al_comienzo() {
		
		
		if(tamano != 0) {
			
		  for(int i=0; i<tamano-1; i++) {
			  arreglo[i] = arreglo[i+1];
		  }
		  
		  tamano--;
		} else {
			
			System.out.println("No fue posible la eliminación, la "+this.getClass().getSimpleName()+" está vacía");
		}
	}
	
	protected void eliminar_al_final() {
		
		if(tamano != 0) {
			
		   tamano--;
	    } else {
				
		   System.out.println("No fue posible la eliminación, la "+this.getClass().getSimpleName()+" está vacía");
		}
		
	}
	
    /////////////////////////////////////
	public T[] getArreglo() {
		return arreglo;
	}

	public void setArreglo(T[] arreglo) {
		this.arreglo = arreglo;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	
    /////////////////////////////////////
	
	public void imprimir() {
		
		if(tamano != 0) {
			
			for(int i=0; i<tamano-1; i++) {
				System.out.print(arreglo[i]+", ");
			}
			
		    System.out.println(arreglo[tamano-1]);
		} else {
			
			System.out.println(this.getClass().getSimpleName()+" vacía");
		}
	}
	
	
	

}
