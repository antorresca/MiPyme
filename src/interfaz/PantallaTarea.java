package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import datos.Tarea;
import logica.Ejecucion;

public class PantallaTarea {
	
	private static Ventana pantallaTarea = new Ventana("Tareas");
    private static Ventana pantallaTarea2 = new Ventana("",false);
	private static Ventana pantallaTarea3 = new Ventana("",false);
	
	private static Boton mas = new Boton("", pantallaTarea, 190, 155, 30, 30);
	private static Boton menos = new Boton("", pantallaTarea, 190+70, 155, 30, 30);
	private static Boton detalles = new Boton("", pantallaTarea, 360, 100, 100, 50);
	private static Boton agregar_tarea = new Boton("",pantallaTarea,360+5, 150+25, 89, 32);
	private static Boton crear_tarea = new Boton("", pantallaTarea2, 100, 250, 100, 50);
	private static Boton atras_tarea = new Boton("", pantallaTarea2, 250, 250, 100,50);
	private static Boton atras2 = new Boton("", pantallaTarea3, 50, 250, 35,35);
	private static Boton atras_menu = new Boton("", pantallaTarea,  360+30, 150+100,35,35);
	
	private static Texto pendiente = new Texto("Pendiente",pantallaTarea, 30,40,100,50);
	private static Texto realizado = new Texto("Realizado",pantallaTarea, 30,40+100+55,100,50);
	private static Texto titulo = new Texto("Titulo:",pantallaTarea2, 40,40,100,50);
	private static CampoL campo_titulo = new CampoL(pantallaTarea2, 40,40,300,25);
	private static Texto descripcion = new Texto("Descripcion:",pantallaTarea2, 40,120,100,50);
	private static CampoA campo_descripcion = new CampoA(pantallaTarea2, 40,40+70,300,100);
	private static Texto titulo3 = new Texto("Titulo:",pantallaTarea3, 40,40,100,50);
	private static Texto titulo3_descripcion = new Texto("",pantallaTarea3, 40+1,40+25,100,50);
	private static Texto descripcion3 = new Texto("Descripcion:",pantallaTarea3, 40,120,100,50);
	private static Texto descripcion3_descripcion = new Texto("",pantallaTarea3, 40+1,120,300,100);
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		DefaultListModel<Tarea> modelo = new DefaultListModel<Tarea>();
		DefaultListModel<Tarea> modelo2 = new DefaultListModel<Tarea>();
		
		JList<Tarea> interior = new JList<Tarea>();
		interior.setModel(modelo);
		
		JList<Tarea> interior2 = new JList<Tarea>();
		interior2.setModel(modelo2);
		
		JScrollPane scroll = new JScrollPane(interior);
		scroll.setBounds(30, 40, 300, 100);
		pantallaTarea.getContenedor().add(scroll);
		
		JScrollPane scroll2 = new JScrollPane(interior2);
		scroll2.setBounds(30, 40+100+55, 300, 100);
		pantallaTarea.getContenedor().add(scroll2);
		
		detalles.volverIcono("Detalle\r\n");
		agregar_tarea.volverIcono("Nueva Tarea\r\n");
		crear_tarea.volverIcono("Aceptar\r\n");
		atras_tarea.volverIcono("Cancelar\r\n");
		atras2.volverIcono("Regresar\\r\\n");
		atras_menu.volverIcono("Regresar Menu\\r\\n");
		
		configurar_iconos();
		
		//------------------------------------------------------------------------------------------------------------
		
		mas.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
            Tarea seleccionada = interior.getSelectedValue();
			
			modelo.removeElement(seleccionada);
			modelo2.addElement(seleccionada);

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		
		menos.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
            Tarea seleccionada = interior2.getSelectedValue();
			
			modelo2.removeElement(seleccionada);
			modelo.addElement(seleccionada);

		///////////////////////////////////////////////////////////////////////			
		}
		});

		detalles.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
			Tarea seleccionada = interior.getSelectedValue();
			Tarea seleccionada2 = interior2.getSelectedValue();
			
			Tarea sele = null;
			
			if(seleccionada != null) {
				
				sele = seleccionada;
			}else {
				if(seleccionada2 != null) {
					
					sele = seleccionada2;
				}
			}
			
			if(sele != null) {
				
				titulo3_descripcion.setText(sele.getTitulo());
				descripcion3_descripcion.setText(sele.getDescripcion());
				
				pantallaTarea3.activar();
				pantallaTarea.desactivar();
			}else {
				
				JOptionPane.showMessageDialog(pantallaTarea,"Seleccione una tarea","Error",JOptionPane.ERROR_MESSAGE);
			}

		///////////////////////////////////////////////////////////////////////			
		}
		});
		

		agregar_tarea.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
			pantallaTarea2.activar();
			pantallaTarea.desactivar();

		///////////////////////////////////////////////////////////////////////			
		}
		});

		crear_tarea.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
            
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String fecha = dtf.format(LocalDateTime.now());
			
			modelo.addElement(new Tarea(campo_titulo.getText(), campo_descripcion.getText(), PantallaInicio.actual, fecha));
			
			campo_titulo.setText("");
			campo_descripcion.setText("");
			
			pantallaTarea.activar();
			pantallaTarea2.desactivar();

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		atras_tarea.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
			campo_titulo.setText("");
			campo_descripcion.setText("");
			
			pantallaTarea.activar();
			pantallaTarea2.desactivar();

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		atras2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
             
			pantallaTarea.activar();
			pantallaTarea3.desactivar();

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		atras_menu.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
			PantallaMenu.main(args);
			pantallaTarea.desactivar();

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		PantallaMenu.inicializado = true;
		
	}
	
	public static void configurar_iconos() {
		
		mas.volverIcono("añadir\r\n","Img\\MasClaro.png","Img\\MasOscuro.png");
		menos.volverIcono("quitar\r\n","Img\\MenosClaro.png","Img\\MenosOscuro.png",menos.getWidth(),menos.getHeight()/4);
		
		detalles.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.DetallesO:PantallaMenu.DetallesC);
		agregar_tarea.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.AgregarO:PantallaMenu.AgregarC);
		crear_tarea.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.AceptarO:PantallaMenu.AceptarC);
		atras_tarea.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.CancelarO:PantallaMenu.CancelarC);
		atras2.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.RegresarO:PantallaMenu.RegresarC);
		atras_menu.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.RegresarO:PantallaMenu.RegresarC);
	}
	
    public static void cambiar_modo() {

    	pendiente.setForeground((PantallaMenu.temaFlag) ? Ejecucion.ModoOscuro : Ejecucion.ModoClaro);
		realizado.setForeground((PantallaMenu.temaFlag) ? Ejecucion.ModoOscuro : Ejecucion.ModoClaro);
		titulo.setForeground((PantallaMenu.temaFlag) ? Ejecucion.ModoOscuro : Ejecucion.ModoClaro);
		descripcion.setForeground((PantallaMenu.temaFlag) ? Ejecucion.ModoOscuro : Ejecucion.ModoClaro);
		titulo3.setForeground((PantallaMenu.temaFlag) ? Ejecucion.ModoOscuro : Ejecucion.ModoClaro);
		titulo3_descripcion.setForeground((PantallaMenu.temaFlag) ? Ejecucion.ModoOscuro : Ejecucion.ModoClaro);
		descripcion3.setForeground((PantallaMenu.temaFlag) ? Ejecucion.ModoOscuro : Ejecucion.ModoClaro);
		descripcion3_descripcion.setForeground((PantallaMenu.temaFlag) ? Ejecucion.ModoOscuro : Ejecucion.ModoClaro);
		configurar_iconos();
    	pantallaTarea.activar();
		
	}
	

	public static Ventana getPantallaTarea() {
		return pantallaTarea;
	}

	public static void setPantallaTarea(Ventana pantallaTarea) {
		PantallaTarea.pantallaTarea = pantallaTarea;
	}

}
