package estructuras;


public abstract class Metodos_pila_cola_arreglo_dinamico<T> {
	
	private T[] arreglo;
	private int tamaño;
	
	
	public Metodos_pila_cola_arreglo_dinamico() {
		
		arreglo = (T[]) new Object[1];
		
		tamaño = 0;
	}
	
	
	protected void agregar_al_final(T item) {
		
		try {
		
		arreglo[tamaño] = item;
		
		} catch (ArrayIndexOutOfBoundsException e) {
			
			
			T[] arreglo2 = (T[]) new Object[arreglo.length*2];
			
			for(int i=0; i<tamaño; i++) {
				
				arreglo2[i] = arreglo[i]; 
			}
			
			arreglo = arreglo2;
			
			arreglo[tamaño] = item;
		}
		
		tamaño++;
		
	}
	
	protected void agregar_al_comienzo(T item) {
		
		try {
		
		  for(int i=0; i<tamaño; i++) {
			
			  arreglo[tamaño-i] = arreglo[tamaño-1-i];
		  }
		  
		  arreglo[0] = item;
		  
		} catch (ArrayIndexOutOfBoundsException e) {
			
            T[] arreglo2 = (T[]) new Object[arreglo.length*2];
			
			for(int i=0; i<tamaño; i++) {
				
				arreglo2[i] = arreglo[i]; 
			}
			
			arreglo = arreglo2;
			
			for(int i=0; i<tamaño; i++) {
				
				  arreglo[tamaño-i] = arreglo[tamaño-1-i];
				
			}
			
			arreglo[0] = item;	
		}
		
		if(tamaño == 0) { arreglo[0]=item;}
		
		tamaño++;
		
	}
	
	protected void eliminar_al_comienzo() {
		
		
		if(tamaño != 0) {
			
		  for(int i=0; i<tamaño-1; i++) {
			  arreglo[i] = arreglo[i+1];
		  }
		  
		  tamaño--;
		} else {
			
			System.out.println("No fue posible la eliminación, la "+this.getClass().getSimpleName()+" está vacía");
		}
	}
	
	protected void eliminar_al_final() {
		
		if(tamaño != 0) {
			
		   tamaño--;
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

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	
    /////////////////////////////////////
	
	public void imprimir() {
		
		if(tamaño != 0) {
			
			for(int i=0; i<tamaño-1; i++) {
				System.out.print(arreglo[i]+", ");
			}
			
		    System.out.println(arreglo[tamaño-1]);
		} else {
			
			System.out.println(this.getClass().getSimpleName()+" vacía");
		}
	}
	
	
	

}
