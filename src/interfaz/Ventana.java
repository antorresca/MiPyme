package interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logica.Ejecucion;

@SuppressWarnings("serial")

public class Ventana extends JFrame {
	
	private Contenedor contenedor;
	private static int ancho = 500;
	private static int largo = 375;
	
	public Ventana(String texto, boolean activada){
		
		super(texto);
		
		Toolkit herramienta = Toolkit.getDefaultToolkit();
		Dimension pantalla_dimension = herramienta.getScreenSize();
		
		contenedor = new Contenedor(this);
		contenedor.setBackground(Ejecucion.Tema);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pack();
		setBounds(pantalla_dimension.width/2,pantalla_dimension.height/2, ancho, largo);
		setLocationRelativeTo(null);
		setVisible(activada);
		setResizable(false);
		
		Ventana n = this;
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	
                if(JOptionPane.showConfirmDialog(n, "¿Seguro que deseas salir?","Confirmaci\u00f3n", JOptionPane.YES_NO_OPTION) == 0) {
					
                	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
            }
        });
		
		addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
				
				//ancho = e.getComponent().getBounds().width;
				//largo = e.getComponent().getBounds().height;
				
				//System.out.println(e.getComponent().getBounds().width+"  "+e.getComponent().getBounds().height);
		    }
		});
        
	}
	
	public Ventana(String texto){
		
		this(texto, true);
	}
	
    public void activar() {
    	
    	this.getContenedor().setBackground(Ejecucion.Tema);
    	this.setVisible(true);
		
	}
	
	public void desactivar() {
		
		this.setVisible(false);	
	}

	public Contenedor getContenedor() {
		return contenedor;
	}

	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}
}
