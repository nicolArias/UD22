package ud22.ej1.view;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import ud22.ej1.controller.ClienteController;

import javax.swing.JButton;


public class VisualPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteController clienteController; 
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnAdd, btnBuscar;



	/**
	 * Create the frame.
	 */
	public VisualPrincipal() {
		setTitle("CRUD completo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 330);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("Ejercicio 1 de la UD22");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(71, 53, 333, 69);
		contentPane.add(lblNewLabel);
		
		btnAdd = new JButton("A\u00F1adir registro");
		btnAdd.setBounds(71, 187, 134, 28);
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);
		
		btnBuscar = new JButton("Buscar registro");
		btnBuscar.setBounds(270, 187, 134, 28);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
	}


	/**
	 * @param clienteController the clienteController to set
	 */
	public void setClienteController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			clienteController.mostrarVisualRegistro();
		}
		
		if(e.getSource() == btnBuscar) {
			clienteController.mostrarVisualBuscar();
		}
		
	}
}
