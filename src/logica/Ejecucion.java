package logica;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import datos.Carrito;
import datos.Producto;
import datos.Usuario;
import estructuras.*;
import interfaz.Boton;
import interfaz.CampoL;
import interfaz.Contenedor;
import interfaz.Imagen;
import interfaz.Texto;
import interfaz.Ventana;

public class Ejecucion {
	
	private static String registroUsuariotxt;
	private static int i; //contador de productos en carrito
	private static long precio = 0; 

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		//-------------------------------------------PRUEBAS---------------------------------------------------------
		
		//referencias simples
		
		Cola_ref_simple<Integer> objeto = new Cola_ref_simple<Integer>();
		
		objeto.encolar(1);
		objeto.encolar(2);
		objeto.encolar(3);
		objeto.encolar(4);
		objeto.encolar(5);
		objeto.encolar(6);
		objeto.desencolar();
		
		objeto.imprimir();
	
		System.out.println();
		
		Pila_ref_simple<String> objeto2 = new Pila_ref_simple<String>();
		
		objeto2.push("hola");
		objeto2.push("cómo");
		objeto2.push("estás");
		objeto2.push("bebé");
		objeto2.pop();
		objeto2.pop();
		
		objeto2.imprimir();
		
        Lista_ref_simple<Integer> objeto5 = new Lista_ref_simple<Integer>();
		
		objeto5.agregar(1);
		objeto5.agregar(2);
		objeto5.agregar(3);
		objeto5.agregar(4);
		objeto5.agregar(5);
		
		System.out.print(objeto5.encontrar(0).getDato()+"\n");
		
		objeto5.imprimir();
		
		System.out.println();
		
		//arreglos dinamicos
		
		Pila_arreglo_dinamico<Integer> objeto3 = new Pila_arreglo_dinamico<Integer>();
		
		objeto3.push(1);
		objeto3.push(2);
		objeto3.push(3);
		objeto3.push(4);
		objeto3.pop();
		
		objeto3.imprimir();
		
		System.out.println();
		
        Cola_arreglo_dinamico<String> objeto4 = new Cola_arreglo_dinamico<String>();
		
		objeto4.encolar("eres");
		objeto4.encolar("todo");
		objeto4.encolar("un");
		objeto4.encolar("programador");
		objeto4.desencolar();
	
		
		objeto4.imprimir();
		
		System.out.println();
		
		Lista_arreglo_dinamico<Integer> objeto6 = new Lista_arreglo_dinamico<Integer>();
		
		objeto6.agregar(1);
		objeto6.agregar(2);
		objeto6.agregar(3);
		objeto6.agregar(4);
		objeto6.eliminar_en(1);
		
		objeto6.imprimir();
		
		
		/*
		//ANÁLISIS COMPARATIVO
		Lista_arreglo_dinamico<Integer> lista1 = new Lista_arreglo_dinamico<Integer>();
		Lista_ref_simple<Integer> lista2 = new Lista_ref_simple<Integer>();
		
		for(int i=0; i<100*1000000-5; i++) {
			
			lista1.agregar(i);
		}
		
		
		long tiempo_inicial = System.nanoTime();
		
		lista1.encontrar(100*1000000-7);
		
		long tiempo_final = System.nanoTime() - tiempo_inicial;
		
		System.out.print(tiempo_final);
		 */
		
		
		//--------------------------------------------INSTANCIACIONES-----------------------------------------------------------
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//--------------------------------------------EJECUCIÓN DE INTERFAZ-----------------------------------------------------------
		
		
///////////////////////////////////////////////////////////////////////
		
/*
* Instancia de elementos de prueba
*/

Usuario user1 = new Usuario("Andres","12345");
Carrito carro1 = new Carrito(user1);
for(int i = 0; i<100;i++) {
carro1.agregar(new Producto(String.valueOf(i),"P"+String.valueOf(i),"Este producto es..."+String.valueOf(i),(long) (Math.random()*10000),null,2));
}

/*
* Colores
*/

Color ModoClaro = new Color(225,237,249); //Variable de colores (claro y oscuro)
Color ModoOscuro = new Color(20,31,59);
Color Tema = ModoClaro;

/*
* Ventanas
*/

Ventana pantallaInicio = new Ventana("MiPYME");
pantallaInicio.setBackground(Tema);

Ventana pantallaMenu = new Ventana("Menu"); 
pantallaMenu.setBackground(Tema);
pantallaMenu.desactivar();

Ventana pantallaRegistro = new Ventana("MiPYME - Registro");
pantallaRegistro.setBackground(Tema);
pantallaRegistro.desactivar();

Ventana carrito = new Ventana("Carrito");
carrito.setBackground(Tema);
carrito.desactivar();

Ventana pantallaDetalles = new Ventana("Detalles");
pantallaDetalles.desactivar();

////////////////////////////Pantalla Inicio///////////////////////////////////////////

Imagen bienvenida = new Imagen("Img\\LogoOscuro.png", pantallaInicio,140, 40, 200, 160);

Texto userLabel = new Texto("Usuario", pantallaInicio, 110, 205, 90, 35);

Texto passwordLabel = new Texto("Contrasena", pantallaInicio,110, 225, 90, 35);

CampoL textoUsuario = new CampoL(pantallaInicio,185,170,165,25);
CampoL textoPassword = new CampoL(pantallaInicio,185, 190, 165, 25);

/*
* Botones Inicio
*/

Boton btnregistro = new Boton("Registrarme", pantallaInicio, 255, 230, 100, 25);

Boton btningreso = new Boton("Ingresar", pantallaInicio, 130, 230, 100, 25);

/////////////////////////////////Pantalla Registro//////////////////////////////////////

JTextField registroUsuario = new JTextField(20);
registroUsuario.setBounds(225,120,165,25);
pantallaRegistro.getContenedor().add(registroUsuario);

JTextField registroContrasena = new JTextField(20);
registroContrasena.setBounds(225,150,165,25);
pantallaRegistro.getContenedor().add(registroContrasena);

Texto LabelRegistroU = new Texto("Escriba su usuario",pantallaRegistro,90, 155, 130, 35);

Texto LabelRegistroC = new Texto("Escriba su contrasena",pantallaRegistro,80, 185, 150, 35);

Texto LabelSuccess = new Texto("",pantallaRegistro,90, 285, 300, 35);		

/*
* Botones Registro 
*/

Boton BtnRegistrar = new Boton("Registrarme", pantallaRegistro, 255, 200, 100, 25);

Boton BtnVolver = new Boton("Regresar", pantallaRegistro, 130, 200, 100, 25);

///////////////////////////////Pantalla Menu////////////////////////////////////////

Imagen logoAppClaro = new Imagen("src\\Img\\LogoClaro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo claro
Imagen logoAppOscuro = new Imagen("src\\Img\\LogoOscuro.jpeg",pantallaMenu,0,40,1280/15,927/15); //Logo Oscuro
logoAppOscuro.setVisible(false);

/*
* Botones del menu
*/

Boton BtnCerrarSesion = new Boton("Cerrar Sesion", pantallaMenu, 130, 240, 200, 50);

Texto NombreUsuario = new Texto("Bienvenido, " + registroUsuariotxt,pantallaMenu,30, 10, 150,30);

Boton btnCarrito = new Boton("Carrito",pantallaMenu,38,71,98,74);
ImageIcon carritoIcon =  new ImageIcon("Img\\CarritoClaro.png"); //Las rutas relativas no estan sirviendo
Icon iconCarrito = new ImageIcon(carritoIcon.getImage().getScaledInstance(
btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING)); //Icono Carrito
btnCarrito.setIcon(iconCarrito);
btnCarrito.setToolTipText("Carrito\r\n");
btnCarrito.setBackground(null);
btnCarrito.setBorderPainted(false);
btnCarrito.setContentAreaFilled(false);
btnCarrito.setOpaque(false);

Boton btn2 = new Boton("Opcion 2",pantallaMenu,38,156,98,74);

Boton btn3 = new Boton("Opcion 3",pantallaMenu,146,71,98,74);

Boton btn4 = new Boton("Opcion 4",pantallaMenu,146,156,98,74);

Boton btn5 = new Boton("Opcion 5",pantallaMenu,254,71,98,74);

Boton btn6 = new Boton("Opcion 6",pantallaMenu,254,156,98,74);

JToggleButton btnTema = new JToggleButton("CLARO"); //BotÃ³n de seleccion de tema
btnTema.setBounds(374, 11, 80, 80);
ImageIcon claro = new ImageIcon("Img\\ModoClaro.png");
Icon iconClaro = new ImageIcon(claro.getImage().getScaledInstance(btnTema.getWidth()/2,btnTema.getHeight()/2, Image.SCALE_DEFAULT));
ImageIcon oscuro = new ImageIcon("Img\\ModoOscuro.png");
Icon iconOscuro = new ImageIcon(oscuro.getImage().getScaledInstance(btnTema.getWidth()/2,btnTema.getHeight()/2, Image.SCALE_DEFAULT));
btnTema.setIcon(iconClaro);
btnTema.setBackground(null);
btnTema.setBorderPainted(false);
btnTema.setContentAreaFilled(false);
btnTema.setOpaque(false);
pantallaMenu.getContenedor().add(btnTema);

///////////////////////////////Pantalla Carrito////////////////////////////////////////

Boton detalles = new Boton("Detalles",carrito,319, 139, 89, 23);

Boton pago = new Boton("Pago",carrito,319, 173, 89, 23);

Boton regresarCarrito = new Boton("Regresar",carrito,319, 207, 89, 23);

DefaultListModel modelo = new DefaultListModel();

for(i=0; i<carro1.obtenerProductos().getTamano();i++) { //Creacion de datos random para pruebas
modelo.addElement(carro1.obtenerProductos().encontrar(i).getDato().imprimir());
precio += carro1.obtenerProductos().encontrar(i).getDato().getPre();
}

JList list = new JList();
list.setModel(modelo);

JScrollPane scroll = new JScrollPane(list);
scroll.setBounds(76, 41, 233, 189);
carrito.getContenedor().add(scroll);

Texto cabecera = new Texto("Producto  |  Precio",carrito,76, 68, 233, 14);

Texto totalCarrito = new Texto("TOTAL",carrito,319, 118, 46, 14);

Texto productosCarrito = new Texto("No. Productos",carrito,319, 68, 89, 14);

Texto pagoCarrito = new Texto(String.valueOf(precio),carrito,319, 143, 76, 23); //Muestra precio total de productos

Texto prodCarrito = new Texto(String.valueOf(i),carrito,319, 93, 46, 14);

/////////////////////////////////Pantalla Detalles//////////////////////////////////////

///////////////////////Eventos en botones///////////////////////

regresarCarrito.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
@Override
public void mouseClicked(MouseEvent e) {
carrito.setVisible(false);
pantallaMenu.setVisible(true);
}});

BtnCerrarSesion.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent e) {

pantallaMenu.setVisible(false);
pantallaInicio.setVisible(true);

}

});

list.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
if(e.getClickCount()==2) { //Saber si se dio doble clic sobre elemento

String producto = list.getSelectedValue().toString().split(" | ")[0]; //Obtener nombre del producto

if(JOptionPane.showConfirmDialog(carrito, "Eliminar "+producto+ "?",
"Elimacion completada", JOptionPane.YES_NO_OPTION) == 0) { //Mensaje de dialogo para eliminar productos

/*
* Actualizacion de variables globales
*/

precio -= carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getPre(); 

i -= 1;

carro1.obtenerProductos().eliminar_en(list.getSelectedIndex()); //Eliminacion de productos del objeto

modelo.removeElementAt(list.getSelectedIndex()); //Eliminacion de producto en lista

pagoCarrito.setText(String.valueOf(precio)); //Actualizar informacion mostrada
prodCarrito.setText(String.valueOf(i)); //""

JOptionPane.showMessageDialog(carrito,"Producto eliminado",
"Elimacion completada",JOptionPane.INFORMATION_MESSAGE);	//Mensaje informativo						

}
}
}
});

detalles.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
if(list.getSelectedValue() != null) { //Saber si hay seleccionado algun elemento en lista
Ventana detalles = new Ventana("Detalles"); //Ventada de detalles de producto
carrito.desactivar();
detalles.activar();

/*
* Elementos de ventana
*/

Imagen imgProducto = new Imagen("Img\\shopping-cart (4).png"
,detalles,0,40,345-detalles.getWidth()/2,detalles.getHeight()/2); //Imagen de prueba

String nombre = carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getNo(); //Nombre de producto
Texto nombrePro = new Texto(nombre, detalles,0,40+imgProducto.getHeight(),detalles.getWidth(),15);

String descripcion = carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getDes(); //Descripcion de producto
Texto desPro = new Texto(descripcion, detalles,0,40+imgProducto.getHeight()+15,detalles.getWidth(),15);

String precioP = String.valueOf(carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getPre()); //Precio de producto
Texto prePro = new Texto(precioP, detalles,0,40+imgProducto.getHeight()+30,detalles.getWidth(),15);

Boton regresar = new Boton("Regresar",detalles,80,210, 89, 23);
Boton elimarPro = new Boton("Eliminar Producto",detalles,182,210, 150, 23);

/*
* Evento de botones
*/

regresar.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
detalles.desactivar();
carrito.activar();
}
});

elimarPro.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
String producto = list.getSelectedValue().toString().split(" | ")[0]; //Nombre del producto

if(JOptionPane.showConfirmDialog(carrito, "Eliminar "+
producto+ "?", "Elimacion completada", JOptionPane.YES_NO_OPTION) == 0) { //Eliminacion de producto
/*
* Actualizacion de variables globales
*/

precio -= carro1.obtenerProductos().encontrar(list.getSelectedIndex()).getDato().getPre();
i -= 1;
carro1.obtenerProductos().eliminar_en(list.getSelectedIndex());

modelo.removeElementAt(list.getSelectedIndex());	

pagoCarrito.setText(String.valueOf(precio));

prodCarrito.setText(String.valueOf(i));

JOptionPane.showMessageDialog(carrito,"Producto eliminado",
"Elimacion completada",JOptionPane.INFORMATION_MESSAGE); //Mensaje informativo

detalles.desactivar(); //Salida de ventana
carrito.activar();
}}});


}else {
JOptionPane.showMessageDialog(carrito,"Por favor elija un producto",
"Error",JOptionPane.ERROR_MESSAGE); //Mensaje de error
}
}});


btnCarrito.addMouseListener(new MouseAdapter() {
@SuppressWarnings("unchecked")
@Override
public void mouseClicked(MouseEvent e) {
carrito.activar();
pantallaMenu.desactivar();

}
});

pago.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
@Override
public void mouseClicked(MouseEvent e) {
Ventana Factura = new Ventana("Factura");
carrito.desactivar();
Factura.setBounds(100, 100, 268, 534);
Boton regresar = new Boton("Regresar",Factura,10, 17, 89, 23);
Texto Titulo = new Texto("Mi Pyme",Factura,0, 102, 252, 25);
Titulo.setHorizontalAlignment(SwingConstants.CENTER);
//Titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
Texto encabezado = new Texto("Factura de compra",Factura,0, 126, 252, 14);
encabezado.setHorizontalAlignment(SwingConstants.CENTER);
Texto lblNewLabel_2 = new Texto("------------------------------------------------",Factura,0, 147, 252, 14);
JList list = new JList();
list.setEnabled(false);
list.setModel(modelo);
JScrollPane LaFactura = new JScrollPane(list);
LaFactura.setBounds(0, 139, 252, 285);
Factura.getContenedor().add(LaFactura);
Texto lblNewLabel_2_1 = new Texto("----------------------------------------------",Factura,0, 462, 252, 14);
Texto lblNewLabel_3 = new Texto("Total a Pagar:",Factura,0, 485, 170, 14);
lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
Texto lblNewLabel_4 = new Texto(String.valueOf(precio),Factura,99, 496, 143, 38);

regresar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
@Override
public void mouseClicked(MouseEvent e) {
Factura.desactivar(); 
carrito.activar();
}
});
}
});

btnTema.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
if (btnTema.getText().contains("CLARO")){ //Verificacion de tema actual de la pantalla

/*
* Actualizacion de variables
*/

btnTema.setText("OSCURO"); //Cambio de bandera de tema
btnTema.setIcon(iconOscuro);

logoAppClaro.setVisible(false); //Cambio de logo
logoAppOscuro.setVisible(true); //""

pantallaMenu.getContenedor().setBackground(ModoOscuro); //Cambio de color de fondo

btnCarrito.setIcon(new ImageIcon(new ImageIcon("Img\\CarritoOscuro.png")
.getImage().getScaledInstance(btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING))); //Cambio icono de carrito
}else {

/*
* Actualizacion de variables
*/

btnTema.setText("CLARO"); //Cambio de bandera de tema
btnTema.setIcon(iconClaro);

logoAppClaro.setVisible(true); //Cambio de logo
logoAppOscuro.setVisible(false); //""

pantallaMenu.getContenedor().setBackground(new Color(225,237,249)); //Cambio color de fondo

btnCarrito.setIcon(new ImageIcon(new ImageIcon("Img\\CarritoClaro.png")
.getImage().getScaledInstance(btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_AREA_AVERAGING))); //Cambio icono de carrito
}

}
});

/*
* Botones Registro
*/

BtnRegistrar.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
@Override
public void mouseClicked(MouseEvent e) {

String registroUsuariotxt = registroUsuario.getText();
String registroPasswordtxt = registroContrasena.getText();

if (registroPasswordtxt.equals("") && registroUsuariotxt.equals("")) {

LabelSuccess.setText("Por favor, llene los espacios en blanco");

}


else if(registroUsuariotxt.equals("")) {

LabelSuccess.setText("Por favor ingrese su usuario");

}

else if (registroPasswordtxt.equals("")) {

LabelSuccess.setText("Ingrese la contrasena");

}

else if(!"".equals(registroUsuariotxt) && !"".equals(registroPasswordtxt)) {

pantallaRegistro.setVisible(false);
pantallaMenu.setVisible(true);

}

}});

BtnVolver.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
@Override
public void mouseClicked(MouseEvent e) {
pantallaRegistro.setVisible(false);
pantallaInicio.setVisible(true);
}});		

btningreso.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
@Override
public void mouseClicked(MouseEvent e) {
pantallaInicio.setVisible(false);
pantallaMenu.setVisible(true);
}});

btnregistro.addMouseListener(new MouseAdapter() { //regresar a pantalla anterior
@Override
public void mouseClicked(MouseEvent e) {
pantallaInicio.setVisible(false);
pantallaRegistro.setVisible(true);
}});
}

}
