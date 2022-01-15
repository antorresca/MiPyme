package logica;

import estructuras.*;

public class Analisis {
	
	public static void main(String[] args){
		
		Arbol_binario<Integer> lista1 = new Arbol_binario<>();
		//Lista_ref_doble<Integer> lista1 = new Lista_ref_doble<>();
		//Lista_ref_simple<Integer> lista1 = new Lista_ref_simple<>();
		
		/*for(int i = 1; i<=10;i++) {
			lista1.agregarA(i);
		}*/
		lista1.agregarA(17);
		lista1.agregarA(7);
		lista1.agregarA(46);
		lista1.agregarA(2);
		lista1.agregarA(5);
		lista1.agregarA(45);
		
		lista1.imprimir(lista1.getRaiz());
		/*
		long tiempo_inicial = System.nanoTime();
		
		lista1.eliminar();
		
		long tiempo_final = System.nanoTime()-tiempo_inicial;
		
		System.out.print(tiempo_final);
		
	*/	
		
	}

}
