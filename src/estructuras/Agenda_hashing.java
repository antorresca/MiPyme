package estructuras;

import datos.Factura;

public class Agenda_hashing {
	
	private Arreglo_dinamico<Lista_ref_simple<Factura>> arreglo;
	private int L;
	private long p;
	private int a;
	private int b;
	private int m;
	private int n;
	private int c;
	
	public Agenda_hashing() {
		
		arreglo = new Arreglo_dinamico<Lista_ref_simple<Factura>>(100);
		
		L = 10;
        p = siguiente_primo((int) Math.pow(10, L)-1);
        a = 3;
        b = 8;
        m = arreglo.getLength();
        n = 0;
        c = 0;
	}

	public static boolean esPrimo(long num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public long siguiente_primo(long a) {
		
		while(true) {
			if(esPrimo(++a)) {
				return a;
			}
		}
	}

	public void agregar(Factura a) {

		int i = hash(Integer.parseInt(a.getCedula()));

		if(this.arreglo.obtener(i) == null) {

			Lista_ref_simple<Factura> aux = new Lista_ref_simple<Factura>();
			aux.agregar(a);

			this.arreglo.adicionar(i, aux);
		}else {

			this.arreglo.obtener(i).agregar(a);

			if(this.arreglo.obtener(i).getTamano() > this.c) {
				this.c = this.arreglo.obtener(i).getTamano();
			}
		}

		this.n++;

		reHash();
	}
	
	public Factura buscar(long x) {
		
		int i = hash(x);
		
		if(this.arreglo.obtener(i) == null) {
			
			return null;
		}else {
			
			if(this.arreglo.obtener(i).getTamano() > 1) {
				
				for(int j=0; j < this.arreglo.obtener(i).getTamano(); j++) {
					
					if(Integer.parseInt(this.arreglo.obtener(i).encontrar(j).getDato().getCedula()) == x){
						return this.arreglo.obtener(i).encontrar(j).getDato();
					}
				}
			}else {
				return this.arreglo.obtener(i).encontrar(0).getDato();
			}
		}
		
		return null;
	}
	
	public int hash(long x) {
		
		return (int) (((a*x+b)%p)%m);
	}
	
	public void reHash() {
		
		if(n/m > 1) {
			
			Arreglo_dinamico<Lista_ref_simple<Factura>> nuevo = new Arreglo_dinamico<Lista_ref_simple<Factura>>(this.arreglo.getLength()*2);
			
			this.m = nuevo.getLength();
			
			for(int i=0; i < this.arreglo.getLength() ; i++ ) {
				
				if(this.arreglo.obtener(i) != null) {
					
					int t = hash(Integer.parseInt(this.arreglo.obtener(i).encontrar(0).getDato().getCedula()));
					
					nuevo.adicionar(t, this.arreglo.obtener(i));
				}
			}
			
			this.arreglo = nuevo;
		}
	}

}
