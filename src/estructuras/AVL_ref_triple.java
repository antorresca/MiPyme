package estructuras;

public class AVL_ref_triple<T> extends BST_ref_triple<T> {

	/*
	public int encontrar_altura(T item) {

		int i =1;

		if(this.getRaiz() == null) {
			System.out.println("Arbol vacío");
			return 0;
		}

		Nodo auxiliar = this.getRaiz();

		while(true) {

			if(son_iguales(item, auxiliar.getDato())) {
				return i;
			}

			switch(es_mayor(item, auxiliar.getDato())) {

			case 1:

				if(auxiliar.getHijo_i() != null) {
					auxiliar = auxiliar.getHijo_i();
					i++;
				}else {
					return i;
				}
				break;

			case 2:

				if(auxiliar.getHijo_d() != null) {

					auxiliar = auxiliar.getHijo_d();
					i++;
				}else {

					return i;	
				}
				break;

			case -1:
				System.out.println("OBJETO NO DEFINIDO");
				return -1;
			}
		}	
	}
*/
	public boolean saber(Nodo b, int c) {

		if(b == b.getPadre().getHijo_i()) {

			return Math.abs(c-altura(b.getPadre().getHijo_d())) < 2;
		}else {

			return Math.abs(altura(b.getPadre().getHijo_i())-c) < 2;
		}
	}
	
	public void rotar_abajo_izquierda(Nodo a) {
		
		//rotar abajo a la izquierda
		a = a.getHijo_d();

		a.getPadre().setHijo_d(a.getHijo_i());
		a.setHijo_i(a.getPadre());
		a.setPadre(a.getPadre().getPadre());
		a.getHijo_i().getPadre().setHijo_i(a);
		a.getHijo_i().setPadre(a);
		
		if(a.getHijo_i().getHijo_d() != null) {
			a.getHijo_i().getHijo_d().setPadre(a.getHijo_i());	
		}
	}
	
	public void rotar_abajo_derecha(Nodo a) {
		
		//rotar abajo a la derecha
		a = a.getHijo_i();

		a.getPadre().setHijo_i(a.getHijo_d());
		a.setHijo_d(a.getPadre());
		a.setPadre(a.getPadre().getPadre());
		a.getHijo_d().getPadre().setHijo_d(a);
		a.getHijo_d().setPadre(a);
		
		if(a.getHijo_d().getHijo_i() != null) {
			a.getHijo_d().getHijo_i().setPadre(a.getHijo_d());	
		}
	}
	
	public void rotar_derecha(Nodo a) {
		
		//rotar a la derecha
		a.getPadre().setHijo_i(a.getHijo_d());
		a.setHijo_d(a.getPadre());
		a.setPadre(a.getPadre().getPadre());
		a.getHijo_d().setPadre(a);
		
        if(a.getPadre() != null) {
			
			if(a.getHijo_d() == a.getPadre().getHijo_d()) {
				a.getPadre().setHijo_d(a);
			}else {
				a.getPadre().setHijo_i(a);
			}	
		}
		
		if(a.getHijo_d().getHijo_i() != null) {
			a.getHijo_d().getHijo_i().setPadre(a.getHijo_d());
		}
	}
	
    public void rotar_izquierda(Nodo a) {
		
    	//rotar a la izquierda
		a.getPadre().setHijo_d(a.getHijo_i());
		a.setHijo_i(a.getPadre());
		a.setPadre(a.getPadre().getPadre());
		a.getHijo_i().setPadre(a);
		
		if(a.getPadre() != null) {
			
			if(a.getHijo_i() == a.getPadre().getHijo_i()) {
				a.getPadre().setHijo_i(a);
			}else {
				a.getPadre().setHijo_d(a);
			}	
		}
		
		if(a.getHijo_i().getHijo_d() != null) {
			a.getHijo_i().getHijo_d().setPadre(a.getHijo_i());
		}
	}
    
    @Override
    public void balancear(Nodo a) {
    	
    	if(a.getPadre() != null) {

    		int altura_iz = altura(a.getPadre().getHijo_i());
    		int altura_de = altura(a.getPadre().getHijo_d());

    		if(altura_de - altura_iz > 1) {

    			if(a == a.getPadre().getHijo_i()) { a = a.getPadre().getHijo_d();}

    			if(altura(a.getHijo_i()) > altura(a.getHijo_d())) {
    				
    				//rotar abajo a la derecha---------------------------------------
    				a = a.getHijo_i();

    				a.getPadre().setHijo_i(a.getHijo_d());
    				a.setHijo_d(a.getPadre());
    				a.setPadre(a.getPadre().getPadre());
    				a.getHijo_d().getPadre().setHijo_d(a);
    				a.getHijo_d().setPadre(a);
    				
    				if(a.getHijo_d().getHijo_i() != null) {
    					a.getHijo_d().getHijo_i().setPadre(a.getHijo_d());	
    				}
    				//----------------------------------------------------------------
    			}
    			
    			//rotar a la izquierda---------------------------------------------
    			a.getPadre().setHijo_d(a.getHijo_i());
    			a.setHijo_i(a.getPadre());
    			a.setPadre(a.getPadre().getPadre());
    			a.getHijo_i().setPadre(a);
    			
    			if(a.getPadre() != null) {
    				
    				if(a.getHijo_i() == a.getPadre().getHijo_i()) {
    					a.getPadre().setHijo_i(a);
    				}else {
    					a.getPadre().setHijo_d(a);
    				}	
    			}
    			
    			if(a.getHijo_i().getHijo_d() != null) {
    				a.getHijo_i().getHijo_d().setPadre(a.getHijo_i());
    			}
    			//----------------------------------------------------------------

    		}else {

    			if(altura_iz - altura_de > 1) {

    				if(!(a == a.getPadre().getHijo_i())) { a = a.getPadre().getHijo_i();}

    				if(!(altura(a.getHijo_i()) >= altura(a.getHijo_d()))) {
    					
    					//rotar abajo a la izquierda-------------------------------------
    					a = a.getHijo_d();

    					a.getPadre().setHijo_d(a.getHijo_i());
    					a.setHijo_i(a.getPadre());
    					a.setPadre(a.getPadre().getPadre());
    					a.getHijo_i().getPadre().setHijo_i(a);
    					a.getHijo_i().setPadre(a);
    					
    					if(a.getHijo_i().getHijo_d() != null) {
    						a.getHijo_i().getHijo_d().setPadre(a.getHijo_i());	
    					}
    					//----------------------------------------------------------------
    				}
    				
    				//rotar a la derecha----------------------------------------------
    				a.getPadre().setHijo_i(a.getHijo_d());
    				a.setHijo_d(a.getPadre());
    				a.setPadre(a.getPadre().getPadre());
    				a.getHijo_d().setPadre(a);
    				
    		        if(a.getPadre() != null) {
    					
    					if(a.getHijo_d() == a.getPadre().getHijo_d()) {
    						a.getPadre().setHijo_d(a);
    					}else {
    						a.getPadre().setHijo_i(a);
    					}	
    				}
    				
    				if(a.getHijo_d().getHijo_i() != null) {
    					a.getHijo_d().getHijo_i().setPadre(a.getHijo_d());
    				}
    				//----------------------------------------------------------------
    				
    			}else {

    				balancear(a.getPadre());
    			}
    		}
    		
    		if(a.getPadre() == null) {
				this.setRaiz(a);
			}
    	}
    }
    
	/*
	@Override
	public void balancear(Nodo a) {
		
		if(a.getPadre() != null) {

			int altura_iz = altura(a.getPadre().getHijo_i());
			int altura_de = altura(a.getPadre().getHijo_d());
			
			System.out.println(altura_iz+" "+altura_de);

			if(a== a.getPadre().getHijo_i()) {

				if(altura_de - altura_iz > 1) {

					a = a.getPadre().getHijo_d();

					if(altura(a.getHijo_i()) > altura(a.getHijo_d())) {

						rotar_abajo_derecha(a);
						System.out.print("roto abajo a la derecha, ");
					}

					rotar_izquierda(a);
					
					System.out.println("roto a la izquierda");

				}else {

					if(altura_iz - altura_de > 1) {

						if(!(altura(a.getHijo_i()) >= altura(a.getHijo_d()))) {

							rotar_abajo_izquierda(a);
							System.out.print("rota abajo a la izquierda, ");
						}

						rotar_derecha(a);
						System.out.println("rota a la derecha");

					}else {

						balancear(a.getPadre());
					}
				}

			}else {

				if(altura_de - altura_iz > 1) {
					
					
					if(altura(a.getHijo_i()) > altura(a.getHijo_d())) {

						rotar_abajo_derecha(a);	
						System.out.print("rota abajo derecha, ");
					}

					rotar_izquierda(a);
					System.out.println("rota a la izquierda");

				}else {

					if(altura_iz - altura_de > 1) {

						a = a.getPadre().getHijo_i();

						if(!(altura(a.getHijo_i()) >= altura(a.getHijo_d()))) {

							rotar_abajo_izquierda(a);
							System.out.print("rota abajo izquierda, ");
						}

						rotar_derecha(a);
						System.out.println("rota a la derecha");

					}else {

						balancear(a.getPadre());
					}
				}
			}

			if(a.getPadre() == null) {
				this.setRaiz(a);
			}
			
		}

		
		
		
		
		
		
        /*
		if(a.getPadre() != null) {

			if(saber(a,i)) {

				iz = a == a.getPadre().getHijo_i();
				balancear(a.getPadre(),i+1,iz);
			}else {
				
				boolean iz = altura(a.getHijo_i())>altura(a.getHijo_d());
                
				if(a == a.getPadre().getHijo_i()) {
					
					
					if(!(altura(a.getHijo_i())>altura(a.getHijo_d()))) {
						
						//rotar abajo a la izquierda
						a = a.getHijo_d();

						a.getPadre().setHijo_d(a.getHijo_i());
						a.setHijo_i(a.getPadre());
						a.setPadre(a.getPadre().getPadre());
						a.getHijo_i().getPadre().setHijo_i(a);
						a.getHijo_i().setPadre(a);
						
						if(a.getHijo_i().getHijo_d() != null) {
							a.getHijo_i().getHijo_d().setPadre(a.getHijo_i());	
						}
					}
					
					//rotar a la derecha
					a.getPadre().setHijo_i(a.getHijo_d());
					a.setHijo_d(a.getPadre());
					a.setPadre(a.getPadre().getPadre());
					a.getHijo_d().setPadre(a);
					
                    if(a.getPadre() != null) {
						
						if(a.getHijo_d() == a.getPadre().getHijo_d()) {
							a.getPadre().setHijo_d(a);
						}else {
							a.getPadre().setHijo_i(a);
						}	
					}
					
					if(a.getHijo_d().getHijo_i() != null) {
						a.getHijo_d().getHijo_i().setPadre(a.getHijo_d());
					}
					
				}else {

					if(iz) {
						//rotar abajo a la derecha
						a = a.getHijo_i();

						a.getPadre().setHijo_i(a.getHijo_d());
						a.setHijo_d(a.getPadre());
						a.setPadre(a.getPadre().getPadre());
						a.getHijo_d().getPadre().setHijo_d(a);
						a.getHijo_d().setPadre(a);
						
						if(a.getHijo_d().getHijo_i() != null) {
							a.getHijo_d().getHijo_i().setPadre(a.getHijo_d());	
						}
					}
					
					//rotar a la izquierda
					a.getPadre().setHijo_d(a.getHijo_i());
					a.setHijo_i(a.getPadre());
					a.setPadre(a.getPadre().getPadre());
					a.getHijo_i().setPadre(a);
					
					if(a.getPadre() != null) {
						
						if(a.getHijo_i() == a.getPadre().getHijo_i()) {
							a.getPadre().setHijo_i(a);
						}else {
							a.getPadre().setHijo_d(a);
						}	
					}
					
					if(a.getHijo_i().getHijo_d() != null) {
						a.getHijo_i().getHijo_d().setPadre(a.getHijo_i());
					}
					
				}

				if(a.getPadre() == null) {
					this.setRaiz(a);
				}
			}
		}
		
	}
	*/
	public int altura(Nodo a) {
		return altura(a, 1, 1);
	}

	public int altura(Nodo a, int i, int h) {

		if(a == null) { return 0;}

		if(a.getHijo_i() != null) {

			h = altura(a.getHijo_i(),i+1,h);
		}

		if(a.getHijo_d() != null) {

			h = altura(a.getHijo_d(),i+1,h);
		}

		if(i>h) {
			h = i;
		}
		return h;
	}
	
	/*
	public void balancear(Nodo a, int i, boolean iz) {

		if(a.getPadre() != null) {

			if(saber(a,i)) {

				iz = a == a.getPadre().getHijo_i();
				balancear(a.getPadre(),i+1,iz);
			}else {
                
				if(a == a.padre.hijo_i) {

					if(!iz) {
						//rotar abajo a la izquierda
						a = a.hijo_d;

						a.padre.hijo_d = a.hijo_i;
						a.hijo_i = a.padre;
						a.padre = a.padre.padre;
						a.hijo_i.padre.hijo_i = a;
						a.hijo_i.padre = a;
						
						if(a.hijo_i.hijo_d != null) {
							a.hijo_i.hijo_d.padre = a.hijo_i;	
						}
					}
					
					//rotar a la derecha
					a.padre.hijo_i = a.hijo_d;
					a.hijo_d = a.padre;
					a.padre = a.padre.padre;
					a.hijo_d.padre = a;
					
                    if(a.padre != null) {
						
						if(a.hijo_d == a.padre.hijo_d) {
							a.padre.hijo_d = a;
						}else {
							a.padre.hijo_i = a;
						}	
					}
					
					if(a.hijo_d.hijo_i != null) {
						a.hijo_d.hijo_i.padre = a.hijo_d;
					}
					
				}else {

					if(iz) {
						//rotar abajo a la derecha
						a = a.hijo_i;

						a.padre.hijo_i = a.hijo_d;
						a.hijo_d = a.padre;
						a.padre = a.padre.padre;
						a.hijo_d.padre.hijo_d = a;
						a.hijo_d.padre = a;
						
						if(a.hijo_d.hijo_i != null) {
							a.hijo_d.hijo_i.padre = a.hijo_d;	
						}
					}
					
					//rotar a la izquierda
					a.padre.hijo_d = a.hijo_i;
					a.hijo_i = a.padre;
					a.padre = a.padre.padre;
					a.hijo_i.padre = a;
					
					if(a.padre != null) {
						
						if(a.hijo_i == a.padre.hijo_i) {
							a.padre.hijo_i = a;
						}else {
							a.padre.hijo_d = a;
						}	
					}
					
					if(a.hijo_i.hijo_d != null) {
						a.hijo_i.hijo_d.padre = a.hijo_i;
					}
					
				}

				if(a.padre == null) {
					raiz = a;
				}
			}
		}
	}
*/
	
}
