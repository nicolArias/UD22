package ud22.ej2.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import ud22.ej2.controller.ClienteController;
import ud22.ej2.controller.VideoController;
import ud22.ej2.model.dto.VideoDto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;


public class VisualBuscarVideo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VideoController VideoController;
	private ClienteController ClienteController;
	private JPanel contentPane;
	public JComboBox<Integer> comboBox;
	private JLabel lblNewLabel_2;
	private JTextField title;
	private JLabel lblNewLabel_3;
	private JTextField director;
	private JLabel lblNewLabel_4;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JComboBox cli_id;

	public VisualBuscarVideo() {
		setTitle("CRUD completo");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 389);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Buscar Video");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 10, 209, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 66, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox<Integer>();
		comboBox.setBounds(65, 62, 45, 21);
		contentPane.add(comboBox);
		
		lblNewLabel_2 = new JLabel("Título");
		lblNewLabel_2.setBounds(10, 121, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		title = new JTextField();
		title.setEnabled(false);
		title.setBounds(65, 118, 386, 19);
		contentPane.add(title);
		title.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Director");
		lblNewLabel_3.setBounds(10, 175, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		director = new JTextField();
		director.setEnabled(false);
		director.setBounds(65, 172, 386, 19);
		contentPane.add(director);
		director.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Id de cliente");
		lblNewLabel_4.setBounds(10, 232, 85, 13);
		contentPane.add(lblNewLabel_4);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(65, 287, 85, 21);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setBounds(178, 287, 85, 21);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(284, 287, 85, 21);
		contentPane.add(btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(178, 318, 85, 21);
		contentPane.add(btnCancelar);
		
		cli_id = new JComboBox();
		cli_id.setBounds(96, 227, 54, 22);
		contentPane.add(cli_id);
		
		btnBuscar.addActionListener(this);
		btnModificar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
	}
	
	

	/**
	 * @param VideoController the VideoController to set
	 */
	public void setVideoController(VideoController VideoController) {
		this.VideoController = VideoController;
	}
	
	/**
	 * @param clienteController the clienteController to set
	 */
	public void setClienteController(ClienteController clienteController) {
		this.ClienteController = clienteController;
	}



	public void llenar(int i) {
		comboBox.addItem(i);
	}

	public void llenarCliente(int i) {
		cli_id.addItem(i);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBuscar) {
			try {
				VideoDto miVideo = VideoController.buscarVideo(comboBox.getSelectedItem().toString());
			
			title.setText(miVideo.getTitleVideo());
			director.setText(miVideo.getDirectorVideo());
			//cli_id        //.setText(Integer.toString(miVideo.getCli_idCliente()));
			ClienteController.llenarComboVideo();
			cli_id.setSelectedItem(miVideo.getCli_idVideo());
			habilita(true,true,true,true,true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error al buscar el Video");
			}
			
		}
		if(e.getSource() == btnModificar) {
			
			try {
				VideoDto miVideo = new VideoDto();
				miVideo.setIdVideo(Integer.parseInt(comboBox.getSelectedItem().toString()));
				miVideo.setTitleVideo(title.getText());
				miVideo.setDirectorVideo(director.getText());
				miVideo.setCli_idVideo(Integer.parseInt(cli_id.getSelectedItem().toString()));
				
				VideoController.modificarVideo(miVideo);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error al actualizar el registro");
			}
		}
		
		if(e.getSource() == btnEliminar) {
			
			int respuesta = JOptionPane.showConfirmDialog(this,
					"Esta seguro de eliminar el Video "+comboBox.getSelectedItem().toString()+"?", "Confirmación",
					JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_NO_OPTION)
			{
				VideoController.eliminarVideo(comboBox.getSelectedItem().toString());
				comboBox.removeAllItems();
				limpiar();
			}
			
		}
		
		if(e.getSource() == btnCancelar) {
			comboBox.removeAllItems();
			this.dispose();
		}
		
	}



	private void limpiar() {
		VideoController.llenarComboBuscar();
		title.setText("");
		director.setText("");
		cli_id.removeAllItems();
		habilita(false,false,false,false,false);
		
	}



	private void habilita(boolean title, boolean director, boolean cli_id, boolean btnM, boolean btnE) {
		this.title.setEnabled(title);
		this.director.setEnabled(director);
		this.cli_id.setEnabled(cli_id);
		this.btnModificar.setEnabled(btnM);
		this.btnEliminar.setEnabled(btnE);
		
	}
}
