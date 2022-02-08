package interfaz;

import java.awt.Font;
import javax.swing.JPasswordField;


@SuppressWarnings("serial")
public class CampoP extends JPasswordField {
	
	private CampoP(int x, int y, int ancho, int largo) {
		
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBounds(x,y,ancho,largo);
	}
	
	public CampoP(Ventana ventana, int x, int y, int ancho, int largo) {
			
		this(x, y, ancho, largo);
		ventana.getContenedor().add(this);
	}
	

}
