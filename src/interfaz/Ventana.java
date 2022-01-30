package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

import logica.Ejecucion;

@SuppressWarnings("serial")

public class Ventana extends JFrame {
	
	private JPanel contenedor;
	
	public Ventana(String texto, boolean puerta){
		
		super(texto);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensions = t.getScreenSize();
		contenedor = new JPanel(null);
		add(contenedor);
		contenedor.setVisible(puerta);
		contenedor.setBackground(Ejecucion.Tema);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pack();
		setBounds(dimensions.width/2,dimensions.height/2,500, 350);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Ventana n = this;
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	
                if(JOptionPane.showConfirmDialog(n, "¿Seguro que deseas salir?","Confirmaci\u00f3n", JOptionPane.YES_NO_OPTION) == 0) {
					
                	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
            }
        });
        
	}
	
    public Ventana(String texto){
        
		this(texto, true);
	}
	
    public void activar() {
    	
    	this.setVisible(true);
		
	}
	
	public void desactivar() {
		
		this.setVisible(false);	
	}

	public JPanel getContenedor() {
		return contenedor;
	}

	public void setContenedor(JPanel contenedor) {
		this.contenedor = contenedor;
	}

	
	
// Esto es una prueba 
	

	

}
