package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logica.Ejecucion;

@SuppressWarnings("serial")
public class Contenedor extends JPanel {
	
	
	public Contenedor(JFrame ventanaC){
		
		super(null);
		
		ventanaC.add(this);
		
		this.setBackground(Ejecucion.Tema);
	}
	
    public void activar() {
    	
    	this.setVisible(true);
		
	}
	
	public void desactivar() {
		
		this.setVisible(false);	
	}

}
