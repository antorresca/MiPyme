package estructuras;

import datos.Producto;

public class Lista_ref_simple<T> extends Metodos_pila_cola_ref_simple<T> {


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

			System.out.println("Posici\u00f3n no valida");	

			return new Nodo(null);
		}

	}

	public Nodo encontrar_por_nombre(String nombre) {

		Nodo auxiliar = this.getCabeza();
		int es_mayor; 
		if (auxiliar == null) {
			return auxiliar;
		}
		while(auxiliar.getSiguiente() !=null) {
			es_mayor = ((nombre).toLowerCase().compareTo((((Producto) auxiliar.getDato()).getNo()).toLowerCase()));
			/*if (es_mayor == 0) {   //Este pedazo sin comentar la hace case sensitive
				es_mayor = ((nombre).compareTo(((Producto) auxiliar.getDato()).getNo()));
			}*/
			if (es_mayor == 0) {
				return auxiliar;
			}
			auxiliar = auxiliar.getSiguiente();
		}
		System.out.println("No se encontr\u00f3 ese producto");
		return new Nodo(null);

	}
	
	/*public Nodo encontrar_por_id(int id) {

		Nodo auxiliar = this.getCabeza();

		if(id < this.getTamano() && id > -1) {

			for(int i=0; i<id; i++) {
				String valor = "";
				char[] a =((Producto) auxiliar.getDato()).getId().toCharArray();
				for(char b : a) {
					if(b!='|')valor+=b;
					else break;
				}			
				valor = valor.replace(" ","");
				valor = valor.replace("P","");
				//ultimoId = (ultimoId>Integer.valueOf(valor))?ultimoId:Integer.valueOf(valor);
				if(id < Integer.valueOf(valor)){
					return new Nodo(null);
				}
				auxiliar = auxiliar.getSiguiente();
			}

			return auxiliar;

		} else {

			System.out.println("Posici\u00f3n no valida");	

			return new Nodo(null);
		}

	}*/
	
	public void eliminar_por_id(int id) {

		Nodo auxiliar = this.getCabeza();

		if(id < this.getTamano() && id > -1) {
			
			if(auxiliar != null) {
				if(id == 0) {
					eliminar_comienzo();

				} else {
					for(int i=0; i<id-1; i++) {
						auxiliar = auxiliar.getSiguiente();
					}

					Nodo nuevo_nodo2 = auxiliar.getSiguiente();
					auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente());
					if(id == this.getTamano()-1) {
						this.setCola(auxiliar);
					}
					this.setTamano(this.getTamano()-1);
				}
			} else {
				System.out.print("Lista vac???a");
			}
		} else {
			System.out.println("Posici???n no valida");
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

					auxiliar.setSiguiente(nuevo_nodo);

					this.setTamano(this.getTamano()+1);

				}

			} else {

				agregar(item);
			}

		} else {


			System.out.println("Posici\u00f3n no valida");
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

					if(u == this.getTamano()-1) {

						this.setCola(auxiliar);

					}

					this.setTamano(this.getTamano()-1);

					return nuevo_nodo2;

				}

			} else {

				System.out.print("Lista vac???a");

				return null;

			}

		} else {

			System.out.println("Posici???n no valida");

			return null;
		}
	}

}
