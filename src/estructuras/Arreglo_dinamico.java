package estructuras;

@SuppressWarnings("unchecked")
public class Arreglo_dinamico<T> {

	private T[] arre;
	
	public Arreglo_dinamico(int a) {
		
		arre = (T[]) new Object[a];
	}
	
    public T obtener(int u) {
    	
    	if(u > -1 && u < arre.length) {
    	   
    	   return this.arre[u];
    	} else {
    		
    		System.out.println("Posición no valida");	
    	    return null;
    	}
    }
    
    public void adicionar(int u, T item) {
    	
    	if(u > -1 && u < arre.length) {
     	   
     	   this.arre[u] = item;
     	} else {
     		
     		System.out.println("Posición no valida");	
     	}
    }

	public T[] getArre() {
		return arre;
	}

	public void setArre(T[] arreglo) {
		this.arre = arreglo;
	}
	
	public int getLength() {
		return arre.length;
	}
    
    
}
