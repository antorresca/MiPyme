package interfaz;

import java.awt.Font;
import java.util.Map;

import javax.swing.JLabel;

import logica.Ejecucion;

@SuppressWarnings("serial")
public class Texto extends JLabel{
	//Map attributes;
	private Texto(String texto, int x, int y, int ancho, int largo) {
		super(texto);
		//attributes.put(TextAttribute.FOREGROUND, "white");
		//this.setText("\u001B[33m"+texto);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBounds(x,y-40,ancho,largo);
		setForeground((Ejecucion.Tema == Ejecucion.ModoClaro) ? Ejecucion.ModoOscuro:Ejecucion.ModoClaro);
		
	}
	
    public Texto(String texto, Ventana ventana, int x, int y, int ancho, int largo) {
		
		this(texto, x, y, ancho, largo);
		ventana.getContenedor().add(this);
	}
    

}
