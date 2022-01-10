package interfaz;

import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen extends JLabel{
	
	private Imagen(int x, int y, int ancho, int largo) {
		super("");
		setBounds(x,y-40,ancho,largo);
	}
	
	public Imagen(String Ruta,Ventana ventana,int x, int y,int ancho, int largo) {
		this(x, y,ancho, largo);
		ImageIcon imagen = new ImageIcon(Ruta);
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		this.setIcon(icono);
		ventana.getContenedor().add(this);
	}
}
