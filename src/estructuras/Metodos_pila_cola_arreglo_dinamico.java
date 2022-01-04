package estructuras;


public abstract class Metodos_pila_cola_arreglo_dinamico<T> {
	
	private T[] arreglo;
	private int tama�o;
	
	
	public Metodos_pila_cola_arreglo_dinamico() {
		
		arreglo = (T[]) new Object[1];
		
		tama�o = 0;
	}
	
	
	protected void agregar_al_final(T item) {
		
		try {
		
		arreglo[tama�o] = item;
		
		} catch (ArrayIndexOutOfBoundsException e) {
			
			
			T[] arreglo2 = (T[]) new Object[arreglo.length*2];
			
			for(int i=0; i<tama�o; i++) {
				
				arreglo2[i] = arreglo[i]; 
			}
			
			arreglo = arreglo2;
			
			arreglo[tama�o] = item;
		}
		
		tama�o++;
		
	}
	
	protected void agregar_al_comienzo(T item) {
		
		try {
		
		  for(int i=0; i<tama�o; i++) {
			
			  arreglo[tama�o-i] = arreglo[tama�o-1-i];
		  }
		  
		  arreglo[0] = item;
		  
		} catch (ArrayIndexOutOfBoundsException e) {
			
            T[] arreglo2 = (T[]) new Object[arreglo.length*2];
			
			for(int i=0; i<tama�o; i++) {
				
				arreglo2[i] = arreglo[i]; 
			}
			
			arreglo = arreglo2;
			
			for(int i=0; i<tama�o; i++) {
				
				  arreglo[tama�o-i] = arreglo[tama�o-1-i];
				
			}
			
			arreglo[0] = item;	
		}
		
		if(tama�o == 0) { arreglo[0]=item;}
		
		tama�o++;
		
	}
	
	protected void eliminar_al_comienzo() {
		
		
		if(tama�o != 0) {
			
		  for(int i=0; i<tama�o-1; i++) {
			  arreglo[i] = arreglo[i+1];
		  }
		  
		  tama�o--;
		} else {
			
			System.out.println("No fue posible la eliminaci�n, la "+this.getClass().getSimpleName()+" est� vac�a");
		}
	}
	
	protected void eliminar_al_final() {
		
		if(tama�o != 0) {
			
		   tama�o--;
	    } else {
				
		   System.out.println("No fue posible la eliminaci�n, la "+this.getClass().getSimpleName()+" est� vac�a");
		}
		
	}
	
    /////////////////////////////////////
	public T[] getArreglo() {
		return arreglo;
	}

	public void setArreglo(T[] arreglo) {
		this.arreglo = arreglo;
	}

	public int getTama�o() {
		return tama�o;
	}

	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
	}
	
    /////////////////////////////////////
	
	public void imprimir() {
		
		if(tama�o != 0) {
			
			for(int i=0; i<tama�o-1; i++) {
				System.out.print(arreglo[i]+", ");
			}
			
		    System.out.println(arreglo[tama�o-1]);
		} else {
			
			System.out.println(this.getClass().getSimpleName()+" vac�a");
		}
	}
	
	
	

}
