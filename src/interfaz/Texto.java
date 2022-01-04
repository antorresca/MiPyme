package interfaz;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Texto extends JLabel{
	
	private Texto(String texto, int x, int y, int ancho, int largo) {
		
		super(texto);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBounds(x,y-40,ancho,largo);
		
	}
	
    public Texto(String texto, Ventana ventana, int x, int y, int ancho, int largo) {
		
		this(texto, x, y, ancho, largo);
		ventana.getContenedor().add(this);
	}
    
    public Texto(String texto, Contenedor contenedor, int x, int y, int ancho, int largo) {
		
    	this(texto, x, y, ancho, largo);
		contenedor.add(this);	
	}

}
