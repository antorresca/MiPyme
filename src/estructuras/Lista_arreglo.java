package estructuras;

public class Lista_arreglo <T> extends Metodos_pila_cola_arreglo<T>{

	
    public Lista_arreglo(int tamano_arreglo) {
    	
		super(tamano_arreglo);
	}

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
    		
    		System.out.println("Posici?n no valida");	
    		
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
    			System.out.println("Arreglo lleno");
    		}

    		if(this.getTamano() == 0) { this.getArreglo()[0]=item;}

    		this.setTamano(this.getTamano()+1);

    	} else {
        	
        	System.out.println("Posici?n no valida");
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
    		
    	  System.out.println("Posici?n no valida");
    	  return null;
    	}
	}
}