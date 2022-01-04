package interfaz;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Ventana extends JFrame {
	
	private JPanel contenedor;
	
	public Ventana(String texto, boolean puerta){
		
		super(texto);
		
		contenedor = new JPanel(null);
		add(contenedor);
		contenedor.setVisible(puerta);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pack();
		setBounds(-7,0,450,300);
		setVisible(true);
		
		Ventana n = this;
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	
                if(JOptionPane.showConfirmDialog(n, "¿Seguro que deseas salir?","Confirmación", JOptionPane.YES_NO_OPTION) == 0) {
					
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
	
	

	

	

}
