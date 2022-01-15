package logica;

import estructuras.Lista_arreglo_dinamico;
import estructuras.Lista_ref_doble;
import estructuras.Lista_ref_simple;

public class Analisis {
	
	public static void main(String[] args){
		
		Lista_arreglo_dinamico<Integer> lista1 = new Lista_arreglo_dinamico<>();
		//Lista_ref_doble<Integer> lista1 = new Lista_ref_doble<>();
		//Lista_ref_simple<Integer> lista1 = new Lista_ref_simple<>();
		
		for(int i = 1; i<=100000000;i++) {
			lista1.agregar(i);
		}
		
		long tiempo_inicial = System.nanoTime();
		
		lista1.eliminar();
		
		long tiempo_final = System.nanoTime()-tiempo_inicial;
		
		System.out.print(tiempo_final);
		
		
		
	}

}
