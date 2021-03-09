package ud22.ej2.view;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import ud22.ej2.controller.ClienteController;
import ud22.ej2.controller.VideoController;

import javax.swing.JButton;


public class VisualPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteController clienteController; 
	private VideoController videoController;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnAdd, btnBuscar, btnAddV,btnBuscarV;



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
		
		lblNewLabel = new JLabel("Ejercicio 2 de la UD22");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(71, 53, 333, 69);
		contentPane.add(lblNewLabel);
		
		btnAdd = new JButton("Añadir cliente");
		btnAdd.setBounds(71, 132, 134, 28);
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);
		
		btnBuscar = new JButton("Buscar cliente");
		btnBuscar.setBounds(270, 132, 134, 28);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
		
		btnAddV = new JButton("Añadir Video");
		btnAddV.setBounds(71, 203, 134, 28);
		contentPane.add(btnAddV);
		
		btnBuscarV = new JButton("Buscar video");
		btnBuscarV.setBounds(270, 203, 134, 28);
		contentPane.add(btnBuscarV);
		btnAddV.addActionListener(this);
		btnBuscarV.addActionListener(this);
	}


	/**
	 * @param clienteController the clienteController to set
	 */
	public void setClienteController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}
	
	public void setVideoController(VideoController videoController) {
		this.videoController = videoController;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			clienteController.mostrarVisualRegistro();
		}
		
		if(e.getSource() == btnBuscar) {
			clienteController.mostrarVisualBuscar();
			clienteController.llenarCombo();
		}
		if(e.getSource() == btnAddV) {
			videoController.mostrarVisualRegistro();
			videoController.llenarComboRegistro();
		}
		if(e.getSource() == btnBuscarV) {
			videoController.mostrarVisualBuscar();
			videoController.llenarComboRegistro();
			videoController.llenarComboBuscar();
		}
		
	}
}