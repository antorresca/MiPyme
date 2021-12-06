package vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import mipyme.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Factura extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(Bill Imprimir) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Factura frame = new Factura(String.valueOf(Imprimir.Id),Imprimir.Date,Imprimir.Seller,Imprimir.Products);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Factura(String id,String FechaHora,String Vendedor1,String ProductosVendidos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tienda Don Pedro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 181, 48);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(10, 70, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel Identificador = new JLabel(id);
		Identificador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Identificador.setBounds(20, 95, 154, 14);
		panel.add(Identificador);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(10, 137, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel Fecha = new JLabel(FechaHora.split(" ")[0]);
		Fecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Fecha.setBounds(10, 162, 77, 14);
		panel.add(Fecha);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vendedor");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_2.setBounds(10, 200, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel Vendedor = new JLabel(Vendedor1);
		Vendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Vendedor.setBounds(20, 225, 154, 14);
		panel.add(Vendedor);
		
		JLabel lblNewLabel_1_3 = new JLabel("Productos");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_3.setBounds(10, 274, 46, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel Productos = new JLabel(ProductosVendidos.replaceAll(" ,","\n"));
		Productos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Productos.setBounds(20, 299, 154, 84);
		panel.add(Productos);
		
		JLabel Hora = new JLabel(FechaHora.split(" ")[1]);
		Hora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Hora.setBounds(97, 162, 77, 14);
		panel.add(Hora);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hora");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1_1.setBounds(97, 137, 46, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(Bills.delBill(Integer.valueOf(id)));
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
				frame.dispose();				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(10, 394, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.setBounds(102, 394, 89, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
				frame.dispose();				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton_1);
	}
}
