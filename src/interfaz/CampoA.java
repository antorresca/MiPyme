package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class CampoA extends JTextArea {
	
	private CampoA(int x, int y, int ancho, int largo) {
		
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBounds(x,y,ancho,largo);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
    public CampoA(Ventana ventana, int x, int y, int ancho, int largo) {
		
		this(x, y, ancho, largo);
		ventana.getContenedor().add(this);
	}
    

}

