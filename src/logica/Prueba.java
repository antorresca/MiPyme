package logica;

import datos.Usuario;
import estructuras.Cola_arreglo_dinamico;
import estructuras.Cola_ref_simple;
import estructuras.Lista_arreglo_dinamico;
import estructuras.Lista_ref_simple;
import estructuras.Pila_arreglo_dinamico;
import estructuras.Pila_ref_simple;

public class Prueba {

	public static void main(String[] args) {
		
		
		//Buscar en hashing
		//Agregar en hashing
		
		

		//referencias simples
        /*
		Cola_ref_simple<Integer> objeto = new Cola_ref_simple<Integer>();

		objeto.encolar(1);
		objeto.encolar(2);
		objeto.encolar(3);
		objeto.encolar(4);
		objeto.encolar(5);
		objeto.encolar(6);
		objeto.desencolar();

		objeto.imprimir();

		System.out.println();

		Pila_ref_simple<String> objeto2 = new Pila_ref_simple<String>();

		objeto2.push("hola");
		objeto2.push("cómo");
		objeto2.push("estás");
		objeto2.push("bebé");
		objeto2.pop();
		objeto2.pop();

		objeto2.imprimir();

		Lista_ref_simple<Integer> objeto5 = new Lista_ref_simple<Integer>();

		objeto5.agregar(1);
		objeto5.agregar(2);
		objeto5.agregar(3);
		objeto5.agregar(4);
		objeto5.agregar(5);

		System.out.print(objeto5.encontrar(0).getDato()+"\n");

		objeto5.imprimir();

		System.out.println();

		//arreglos dinamicos

		Pila_arreglo_dinamico<Integer> objeto3 = new Pila_arreglo_dinamico<Integer>();

		objeto3.push(1);
		objeto3.push(2);
		objeto3.push(3);
		objeto3.push(4);
		objeto3.pop();

		objeto3.imprimir();

		System.out.println();

		Cola_arreglo_dinamico<String> objeto4 = new Cola_arreglo_dinamico<String>();

		objeto4.encolar("eres");
		objeto4.encolar("todo");
		objeto4.encolar("un");
		objeto4.encolar("programador");
		objeto4.desencolar();


		objeto4.imprimir();

		System.out.println();

		Lista_arreglo_dinamico<Integer> objeto6 = new Lista_arreglo_dinamico<Integer>();

		objeto6.agregar(1);
		objeto6.agregar(2);
		objeto6.agregar(3);
		objeto6.agregar(4);
		objeto6.eliminar_en(1);

		objeto6.imprimir();


		/*
				//ANÁLISIS COMPARATIVO
				Lista_arreglo_dinamico<Integer> lista1 = new Lista_arreglo_dinamico<Integer>();
				Lista_ref_simple<Integer> lista2 = new Lista_ref_simple<Integer>();

				for(int i=0; i<100*1000000-5; i++) {

					lista1.agregar(i);
				}


				long tiempo_inicial = System.nanoTime();

				lista1.encontrar(100*1000000-7);

				long tiempo_final = System.nanoTime() - tiempo_inicial;

				System.out.print(tiempo_final);
		 */
		
		/*
		Arbol_binario_juan<Usuario> arbol = new Arbol_binario_juan<Usuario>();
		
		arbol.agregar(new Usuario("andres", "12345"));
		arbol.agregar(new Usuario("pedro", "12345"));
		arbol.agregar(new Usuario("fabian", "12345"));
		arbol.agregar(new Usuario("Brayan", "12345"));
		arbol.agregar(new Usuario("Marco", "12345"));
		*/
		
		
		
		
		
		



	}

}
