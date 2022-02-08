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

public class PantallaTarea {
	
	
	public static void main(String[] args) {
		
		
		Ventana pantallaTarea = new Ventana("Tareas");
		
		Contenedor pantallaTarea2 = new Contenedor(pantallaTarea);
		pantallaTarea2.desactivar();
		
		Ventana pantallaTarea3 = new Ventana("");
		pantallaTarea3.desactivar();
		
		Texto pendiente = new Texto("Pendiente",pantallaTarea, 30,40,100,50);
		Texto realizado = new Texto("Realizado",pantallaTarea, 30,40+100+55,100,50);
		
		Texto titulo = new Texto("Titulo:",pantallaTarea2, 40,40,100,50);
		
		CampoL campo_titulo = new CampoL(pantallaTarea2, 40,40,300,25);
		
		Texto descripcion = new Texto("Descripcion:",pantallaTarea2, 40,40+70,100,50);
		
		CampoA campo_descripcion = new CampoA(pantallaTarea2, 40,40+70,300,100);
		
		Texto titulo3 = new Texto("Titulo:",pantallaTarea3, 40,40,100,50);
		Texto titulo3_descripcion = new Texto("",pantallaTarea3, 40,40+20,100,50);
		
		Texto descripcion3 = new Texto("Descripcion:",pantallaTarea3, 40,40+70,100,50);
		Texto descripcion3_descripcion = new Texto("",pantallaTarea3, 40,40+70+20,300,100);
		
		
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
		
		
		Boton mas = new Boton("", pantallaTarea, 190, 155, 30, 30);
		mas.volverIcono("añadir\r\n","Img\\MasClaro.png","Img\\MasOscuro.png");
		
		mas.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
			
            Tarea seleccionada = interior.getSelectedValue();
			
			modelo.removeElement(seleccionada);
			modelo2.addElement(seleccionada);
		    //lo que va a hacer el botón

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		Boton menos = new Boton("", pantallaTarea, 190+70, 155, 30, 30);
		menos.volverIcono("quitar\r\n","Img\\MenosClaro.png","Img\\MenosOscuro.png",menos.getWidth(),menos.getHeight()/4);
		
		menos.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
			
            Tarea seleccionada = interior2.getSelectedValue();
			
			modelo2.removeElement(seleccionada);
			modelo.addElement(seleccionada);
			
		    //lo que va a hacer el botón

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		Boton detalles = new Boton("", pantallaTarea, 360, 100, 100, 50);
		detalles.volverIcono("Detalle\r\n");
		detalles.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.DetallesO:PantallaMenu.DetallesC);

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
				
				System.out.println("ENTRO rtx");
			}else {
				
				JOptionPane.showMessageDialog(pantallaTarea,"Seleccione una tarea","Error",JOptionPane.ERROR_MESSAGE);
			}
		    //lo que va a hacer el botón

		///////////////////////////////////////////////////////////////////////			
		}
		});
		/*
		Boton agregar_tarea = new Boton("", pantallaTarea, 360-12, 150+25, 100, 50);
		agregar_tarea.volverIcono("Nueva Tarea\r\n");
		agregar_tarea.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.AgregarO:PantallaMenu.AgregarC);
		*/
		
		Boton agregar_tarea = new Boton("",pantallaTarea,360+5, 150+25, 89, 32);
		agregar_tarea.volverIcono("Nueva Tarea\r\n");
		agregar_tarea.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.AgregarO:PantallaMenu.AgregarC);

		agregar_tarea.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
			pantallaTarea2.activar();
			pantallaTarea.getContenedor().desactivar();
			
			System.out.println("entro y leyo todo");
			
		    //lo que va a hacer el botón

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		Boton crear_tarea = new Boton("", pantallaTarea2, 100, 250, 100, 50);

		crear_tarea.volverIcono("Acepatar\r\n");
		crear_tarea.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.AceptarO:PantallaMenu.AceptarC);
		
		//Boton crear_tarea = new Boton("",pantallaTarea2, 100, 250, 89, 32);
		//crear_tarea.volverIcono("Crear\r\n","Img\\AceptarClaro.png","Img\\AceptarOscuro.png");

		crear_tarea.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
            
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String fecha = dtf.format(LocalDateTime.now());
			
			modelo.addElement(new Tarea(campo_titulo.getText(), campo_descripcion.getText(), PantallaInicio.actual, fecha));
			
			pantallaTarea.getContenedor().activar();
			pantallaTarea2.desactivar();
			
			campo_titulo.setText("");
			campo_descripcion.setText("");
		    //lo que va a hacer el botón

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		
		Boton atras_tarea = new Boton("", pantallaTarea2, 250, 250, 100,50);
		atras_tarea.volverIcono("Cancelar\r\n");
		atras_tarea.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.CancelarO:PantallaMenu.CancelarC);
		
		/*
		atras_tarea.volverIcono("Regresar");
		atras_tarea.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.cancelarO:PantallaMenu.cancelarC);
		
		
		//Boton atras_tarea = new Boton("",pantallaTarea2, 250, 250, 89, 32);
		//atras_tarea.volverIcono("Cancelar\r\n","Img\\CancelarClaro.png","Img\\CancelarOscuro.png");
        */
		
		atras_tarea.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
			pantallaTarea.getContenedor().activar();
			pantallaTarea2.desactivar();
		    //lo que va a hacer el botón

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		Boton atras2 = new Boton("", pantallaTarea3, 300, 250, 35,35);
		
		atras2.volverIcono("Regresar");
		atras2.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.RegresarO:PantallaMenu.RegresarC);
		
		atras2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
             
			pantallaTarea.activar();
			pantallaTarea3.desactivar();
		    //lo que va a hacer el botón

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
		Boton atras_menu = new Boton("", pantallaTarea,  360+30, 150+100,35,35);
		atras_menu.volverIcono("Regresar");
		atras_menu.setIcon((!PantallaMenu.temaFlag)?PantallaMenu.RegresarO:PantallaMenu.RegresarC);
		
		
		
		
		atras_menu.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		///////////////////////////////////////////////////////////////////////
			
			PantallaMenu.main(args);
			pantallaTarea.desactivar();
		    //lo que va a hacer el botón

		///////////////////////////////////////////////////////////////////////			
		}
		});
		
	}

}
