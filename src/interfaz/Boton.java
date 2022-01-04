package interfaz;

import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Boton extends JButton {
	
	
	
    private Boton(String texto, int x, int y, int ancho, int largo) {
		
		super(texto);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBounds(x, y, ancho, largo);
	}
	
    public Boton(String texto, Contenedor contenedor, int x, int y, int ancho, int largo) {
		
		this(texto, x, y, ancho, largo);
		contenedor.add(this);
	}
    
    public Boton(String texto, Ventana ventana, int x, int y, int ancho, int largo) {
		
    	this(texto, x, y, ancho, largo);
    	ventana.getContenedor().add(this);
	}

}
