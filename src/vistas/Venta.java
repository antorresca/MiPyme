package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mipyme.MiPyme;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Venta extends JFrame {

	private JPanel contentPane;
	private JTextField NombreVendedor;
	private JFormattedTextField IDCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venta frame = new Venta();
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
	public Venta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		NombreVendedor = new JTextField();
		NombreVendedor.setBounds(10, 36, 86, 20);
		panel.add(NombreVendedor);
		NombreVendedor.setColumns(10);
		
		IDCliente = new JFormattedTextField();
		IDCliente.setBounds(10, 89, 404, 20);
		panel.add(IDCliente);
		IDCliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Vendedor");
		lblNewLabel.setBounds(10, 11, 267, 14);
		panel.add(lblNewLabel);
		
		JTextArea ProductosVendidos = new JTextArea();
		ProductosVendidos.setBounds(10, 145, 404, 75);
		panel.add(ProductosVendidos);
		
		JLabel lblNewLabel_1 = new JLabel("ID Cliente");
		lblNewLabel_1.setBounds(10, 64, 119, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Productos");
		lblNewLabel_2.setBounds(10, 120, 252, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Procesar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Nombre = NombreVendedor.getText();
				String Cliente = IDCliente.getText();
				String Productos = ProductosVendidos.getText();
				if(Nombre.replaceAll(" ","").length()==0 || Cliente.replaceAll(" ","").length()==0 
						|| Productos.replaceAll(" ","").length()==0) {
					JOptionPane.showMessageDialog(contentPane,"No dejar campos vacios","Error",JOptionPane.ERROR_MESSAGE);
					System.out.print("Si");
				}else {
					MiPyme.ventas.newBill(Productos,Nombre,Cliente);
					MiPyme.ventas.printLastBill();
				}
				}
		});
		btnNewButton.setBounds(325, 231, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
				frame.dispose();
				Principal.main(null);
			}
		});
		btnNewButton_1.setBounds(10, 231, 89, 23);
		panel.add(btnNewButton_1);
	}
}
