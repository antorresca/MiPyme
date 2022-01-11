package estructuras;

public class Lista_arreglo_dinamico<T> extends Metodos_pila_cola_arreglo_dinamico<T>{

	
    public void agregar(T item) {
		
		agregar_al_final(item);
	}
	
    public void agregar_comienzo(T item) {
		
		agregar_al_comienzo(item);
	}
    
    public void eliminar() {
		
		eliminar_al_final();
	}

    public void eliminar_comienzo() {
		
		eliminar_al_comienzo();
	}
    
    public T encontrar(int u) {
    	
    	
    	if(u < this.getTamano() && u > -1) {
    	   
    	   return this.getArreglo()[u];
    	   
    	} else {
    		
    		System.out.println("Posición no valida");	
    		
    	    return null;
    	}
      
    }
    
    public void agregar_despues_de(int u, T item) {
        
        
        if(u < this.getTamano() && u > -2 && this.getTamano() != 0) {
            
        	try {
        		
      		  for(int i=0; i<this.getTamano()-u-1; i++) {
      			
      			  this.getArreglo()[this.getTamano()-i] = this.getArreglo()[this.getTamano()-1-i];
      		  }
      		  
      		  this.getArreglo()[u+1] = item;
      		  
      		} catch (ArrayIndexOutOfBoundsException e) {
      			
                @SuppressWarnings("unchecked")
				T[] arreglo2 = (T[]) new Object[this.getArreglo().length*2];
      			
      			for(int i=0; i<this.getTamano(); i++) {
      				
      				arreglo2[i] = this.getArreglo()[i]; 
      			}
      			
      			this.setArreglo(arreglo2);
      			
      			for(int i=0; i<this.getTamano()-u-1; i++) {
          			
        			  this.getArreglo()[this.getTamano()-i] = this.getArreglo()[this.getTamano()-1-i];
        		}
      			
      			this.getArreglo()[u+1] = item;	
      		}
      		
      		this.setTamano(this.getTamano()+1);
    	   
        } else {
        	
        	System.out.println("Posición no valida");
        }
    }
    
    public T eliminar_en(int u) {
		
		
    	if(u < this.getTamano() && u > -1) {
			
    	  T retorno = this.getArreglo()[u];
    		
		  for(int i=u; i<this.getTamano()-1; i++) {
			  this.getArreglo()[i] = this.getArreglo()[i+1];
		  }
		  
		  this.setTamano(this.getTamano()-1);
		  
		  return retorno;
		  
    	}else {
    		
    	  System.out.println("Posición no valida");
    	  return null;
    	}
	}
}
