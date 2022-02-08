package interfaz;

import java.awt.Font;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class CampoL extends JTextField {
	
	private CampoL(int x, int y, int ancho, int largo) {
		
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBounds(x,y,ancho,largo);
	}
	
	public CampoL(Ventana ventana, int x, int y, int ancho, int largo) {
			
		this(x, y, ancho, largo);
		ventana.getContenedor().add(this);
	}
	

}
