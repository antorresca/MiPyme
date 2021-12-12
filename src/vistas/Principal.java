package vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import mipyme.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		int i = 0;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(MiPyme.ventana);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Principal(JFrame ventanaIntroducida) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tienda Don Pedro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 404, 36);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Nueva Venta");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Venta.main(null);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 58, 187, 54);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Encontrar Factura");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numero = -10;
				String campo = JOptionPane.showInputDialog(contentPane,"Ingrese ID de la factura");
				try {
					numero = Integer.valueOf(campo);	
					MiPyme.ventas.printBill(numero);
				}catch(Exception ex) {
					if(campo!=null) {
						if(campo.replaceAll(" ","").length()==0) {
							JOptionPane.showMessageDialog(contentPane,"No dejar campos vacios","Error",JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(contentPane,"Valor invalido","Error",JOptionPane.ERROR_MESSAGE);
						}}
				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(10, 123, 187, 54);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Agregar Usuario");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = "";
				String contrasena = "";
				usuario = (String) JOptionPane.showInputDialog(contentPane,"Ingrese su usuario");
				
				if(usuario!=null) {
				contrasena = (String) JOptionPane.showInputDialog(contentPane,"Ingrese su contrasena");
				
				if(contrasena!=null) {
				if((usuario != null && contrasena != null) && (contrasena.length()==0||usuario.length()==0)) {
					JOptionPane.showMessageDialog(contentPane,"No deje campo vacio","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					MiPyme.Usuarios.addUser(usuario, contrasena);
					JOptionPane.showMessageDialog(contentPane,"Creación exitosa","Exitoso",JOptionPane.INFORMATION_MESSAGE);
				}
				}
				}
												
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(207, 58, 207, 54);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Pedidos: "+MiPyme.pedidos.getTamaño());
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(MiPyme.pedidos.getTamaño() > 0) {
					int n = JOptionPane.showConfirmDialog(contentPane, MiPyme.pedidos.getCabeza().getDato().getNo()+"\n"+
                            MiPyme.pedidos.getCabeza().getDato().getNu()+"\n"+
                            MiPyme.pedidos.getCabeza().getDato().getAr()+"\n\n"+
                            "¿Terminar pedido?", "Pedidos", JOptionPane.YES_NO_OPTION);
					
					if(n==0) {
						
						MiPyme.pedidos.desencolar();
						btnNewButton_3.setText("Pedidos: "+MiPyme.pedidos.getTamaño());
					}
					
				}else {
					
					JOptionPane.showMessageDialog(contentPane,"No hay pedidos en cola","Exitoso",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(207, 123, 207, 54);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int n = JOptionPane.showConfirmDialog(contentPane, "¿Seguro que desea salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
				
				if(n==0) {
					
					ventanaIntroducida.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(150, 185, 100, 25);
		panel.add(btnNewButton_4);
	}

}
