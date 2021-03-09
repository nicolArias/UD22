package ud22.ej2.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.SwingConstants;

import ud22.ej2.controller.ClienteController;
import ud22.ej2.controller.VideoController;
import ud22.ej2.model.dto.VideoDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;

public class VisualRegistroVideo extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteController clienteController;
	private VideoController videoController;
	private JPanel contentPane;
	private JButton btnGuardar,btnCancelar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField titulo,director;
	JComboBox<Integer> idCliente;
	
	public VisualRegistroVideo() {
		setTitle("CRUD completo");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 297);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(62, 185, 116, 28);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(281, 185, 116, 28);
		contentPane.add(btnCancelar);
		
		lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(10, 43, 61, 18);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Añadir video");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(167, 10, 116, 28);
		contentPane.add(lblNewLabel_1);
		
		titulo = new JTextField();
		titulo.setBounds(62, 43, 96, 19);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Director");
		lblNewLabel_2.setBounds(209, 46, 61, 13);
		contentPane.add(lblNewLabel_2);
		
		director = new JTextField();
		director.setBounds(264, 43, 96, 19);
		contentPane.add(director);
		director.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID Cliente");
		lblNewLabel_3.setBounds(10, 99, 67, 17);
		contentPane.add(lblNewLabel_3);
		
		idCliente = new JComboBox<Integer>();
		idCliente.setBounds(86, 95, 45, 21);
		contentPane.add(idCliente);
		
		btnGuardar.addActionListener(this);
		btnCancelar.addActionListener(this);
		//clienteController.llenarCombo();
	}


	/**
	 * @param VideoController the VideoController to set
	 */
	public void setVideoController(VideoController videoController) {
		this.videoController = videoController;
	}
	/**
	 * @param ClienteController the ClienteController to set
	 */
	public void setClienteController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGuardar) {
			try {
				VideoDto miVideo = new VideoDto();
				
				miVideo.setTitleVideo(titulo.getText());
				miVideo.setDirectorVideo(director.getText());
				miVideo.setCli_idVideo(Integer.parseInt(idCliente.getSelectedItem().toString()));
				
				
				videoController.registrarVideo(miVideo);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error en el registro");
			}
		}
		
		if(e.getSource() == btnCancelar) {
			this.dispose();
			idCliente.removeAllItems();
		}
		
	}
	
	public void llenar(int i) {
		idCliente.addItem(i);
	}
}