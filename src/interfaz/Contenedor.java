package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Contenedor extends JPanel {
	
	
	public Contenedor(JFrame ventanaC){
		
		ventanaC.add(this);
	}
	
    public void activar() {
    	
    	this.setVisible(true);
		
	}
	
	public void desactivar() {
		
		this.setVisible(false);	
	}

}
