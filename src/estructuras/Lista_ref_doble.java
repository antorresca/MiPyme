package estructuras;

public class Lista_ref_doble<T> extends Metodos_pila_cola_ref_doble<T> {
	
	
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
    
    public Nodo encontrar(int u) {
    	
    	Nodo auxiliar = this.getCabeza();
    	
    	if(u < this.getTamano() && u > -1) {
    	
    	   for(int i=0; i<u; i++) {
  
    		   auxiliar = auxiliar.getSiguiente();
    	   }
    	   
    	   return auxiliar;
    	   
    	} else {
    		
    		System.out.println("Posición no valida");	
    		
    	    return new Nodo(null);
    	}
      
    }
    
    public void agregar_despues_de(int u, T item) {
    	
        Nodo auxiliar = this.getCabeza();
        
        Nodo nuevo_nodo = new Nodo(item);
        
        if(u < this.getTamano() && u > -2) {
        
        	
        	if(auxiliar != null && u != this.getTamano()-1) {
        		  
        	  if(u == -1) {
        		  
        		  agregar_comienzo(item);
        		  
        	  }else {
    	
    	      for(int i=0; i<u; i++) {
  
    		      auxiliar = auxiliar.getSiguiente();
    	      }


    	   
    	      nuevo_nodo.setSiguiente(auxiliar.getSiguiente());

              nuevo_nodo.setAnterior(auxiliar);

              auxiliar.getSiguiente().setAnterior(nuevo_nodo);
    	      
    	      auxiliar.setSiguiente(nuevo_nodo);
    	      
    	      this.setTamano(this.getTamano()+1);
    	      
        	  }
    	   
    	    } else {
    		
    	    	agregar(item);
    	    }
    	
        } else {
        	
        	
        	System.out.println("Posici�n no valida");
        }

    }
    
    public Nodo eliminar_en(int u) {
    	
        Nodo auxiliar = this.getCabeza();
        
        
        if(u < this.getTamano() && u > -1) {
        
        	
        	if(auxiliar != null) {
        		  
        	  if(u == 0) {
        		  
        		  eliminar_comienzo();
        		  
        		  return auxiliar;
        		  
        	  } else {
    	
    	         for(int i=0; i<u-1; i++) {
  
    		        auxiliar = auxiliar.getSiguiente();
    	         }
    	      
    	         
    	         Nodo nuevo_nodo2 = auxiliar.getSiguiente();
    	   
    	         auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente());

                 auxiliar.getSiguiente().setAnterior(auxiliar);
    	      
    	         if(u == this.getTamano()-1) {
    	    	  
    	    	   this.setCola(auxiliar);
    	    	  
    	         }
    	         
    	         this.setTamano(this.getTamano()-1);
    	         
    	         return nuevo_nodo2;
    	      
        	  }
    	   
    	    } else {
    		
    	    	System.out.print("Lista vac�a");
    	    	
    	    	return null;
    		
    	    }
    	
        } else {
        	
        	System.out.println("Posici�n no valida");
        	
        	return null;
        }
    }

}
