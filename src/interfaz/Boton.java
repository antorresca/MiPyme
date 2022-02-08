package interfaz;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import logica.Ejecucion;

@SuppressWarnings("serial")
public class Boton extends JButton {
	
	
	
    private Boton(String texto, int x, int y, int ancho, int largo) {
		
		super(texto);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBounds(x, y, ancho, largo);
		setCursor(new Cursor(JFrame.HAND_CURSOR));	

	}
	
    
    public Boton(String texto, Ventana ventana, int x, int y, int ancho, int largo) {
		
    	this(texto, x, y, ancho, largo);
    	ventana.getContenedor().add(this);
	}

    public void volverIcono( String nombre, String rutaImgClaro,String rutaImgOscuro) {
    	boolean temaFlag = (Ejecucion.Tema==Ejecucion.ModoClaro);
    	ImageIcon img =  new ImageIcon((temaFlag) ? rutaImgClaro:rutaImgOscuro);
    	Icon icon = new ImageIcon(img.getImage().getScaledInstance(
				this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		this.setIcon(icon);
		this.setToolTipText(nombre);
		this.setBackground(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
    }
    
    public void volverIcono( String nombre) {
    	boolean temaFlag = (Ejecucion.Tema==Ejecucion.ModoClaro);
		this.setToolTipText(nombre);
		this.setBackground(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
    }
    
    public void volverIcono( String nombre, String rutaImgClaro,String rutaImgOscuro, int ancho, int largo) {
    	boolean temaFlag = (Ejecucion.Tema==Ejecucion.ModoClaro);
    	ImageIcon img =  new ImageIcon((temaFlag) ? rutaImgClaro:rutaImgOscuro);
    	Icon icon = new ImageIcon(img.getImage().getScaledInstance(
				ancho, largo, Image.SCALE_AREA_AVERAGING)); //Icono Carrito
		this.setIcon(icon);
		this.setToolTipText(nombre);
		this.setBackground(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
    }
}
