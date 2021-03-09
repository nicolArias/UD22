package ud22.ej1.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import ud22.ej1.controller.ClienteController;
import ud22.ej1.model.dto.ClienteDto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;


public class VisualBuscar extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteController clienteController;
	private JPanel contentPane;
	public JComboBox<Integer> comboBox;
	private JLabel lblNewLabel_2;
	private JTextField nombre;
	private JLabel lblNewLabel_3;
	private JTextField apellido;
	private JLabel lblNewLabel_4;
	private JTextField direcc;
	private JLabel lblNewLabel_5;
	private JTextField dni;
	private JLabel lblNewLabel_6;
	private JTextField fecha;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCancelar;

	public VisualBuscar() {
		setTitle("CRUD completo");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 389);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Buscar Cliente");
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
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 121, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		nombre = new JTextField();
		nombre.setEnabled(false);
		nombre.setBounds(65, 118, 96, 19);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setBounds(218, 121, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		apellido = new JTextField();
		apellido.setEnabled(false);
		apellido.setBounds(273, 118, 96, 19);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setBounds(10, 161, 63, 13);
		contentPane.add(lblNewLabel_4);
		
		direcc = new JTextField();
		direcc.setEnabled(false);
		direcc.setBounds(65, 158, 198, 19);
		contentPane.add(direcc);
		direcc.setColumns(10);
		
		lblNewLabel_5 = new JLabel("DNI");
		lblNewLabel_5.setBounds(10, 203, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		dni = new JTextField();
		dni.setEnabled(false);
		dni.setBounds(65, 203, 96, 19);
		contentPane.add(dni);
		dni.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Fecha");
		lblNewLabel_6.setBounds(218, 203, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		fecha = new JTextField();
		fecha.setEnabled(false);
		fecha.setBounds(273, 200, 96, 19);
		contentPane.add(fecha);
		fecha.setColumns(10);
		
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
		
		btnBuscar.addActionListener(this);
		btnModificar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
	}
	
	

	/**
	 * @param clienteController the clienteController to set
	 */
	public void setClienteController(ClienteController clienteController) {
		this.clienteController = clienteController;
		this.clienteController.llenarCombo();
	}
	
	public void llenar(int i) {
		comboBox.addItem(i);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBuscar) {
			try {
				ClienteDto miCliente = clienteController.buscarCliente(comboBox.getSelectedItem().toString());
			
			nombre.setText(miCliente.getNombreCliente());
			apellido.setText(miCliente.getApellidoCliente());
			direcc.setText(miCliente.getDireccionCliente());
			dni.setText(Integer.toString(miCliente.getDniCliente()));
			fecha.setText(miCliente.getFechaCliente());
			habilita(true,true,true,true,true,true,true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error al buscar el cliente");
			}
			
		}
		if(e.getSource() == btnModificar) {
			
			try {
				ClienteDto miCliente = new ClienteDto();
				miCliente.setIdCliente(Integer.parseInt(comboBox.getSelectedItem().toString()));
				miCliente.setNombreCliente(nombre.getText());
				miCliente.setApellidoCliente(apellido.getText());
				miCliente.setDireccionCliente(direcc.getText());
				miCliente.setDniCliente(Integer.parseInt(dni.getText()));
				miCliente.setFechaCliente(fecha.getText());
				
				clienteController.modificarCliente(miCliente);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error al actualizar el registro");
			}
		}
		
		if(e.getSource() == btnEliminar) {
			
			int respuesta = JOptionPane.showConfirmDialog(this,
					"Esta seguro de eliminar el Cliente "+comboBox.getSelectedItem().toString()+"?", "Confirmación",
					JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_NO_OPTION)
			{
				clienteController.eliminarCliente(comboBox.getSelectedItem().toString());
				comboBox.removeAllItems();
				limpiar();
			}
			
		}
		
		if(e.getSource() == btnCancelar) {
			this.dispose();
		}
		
	}



	private void limpiar() {
		clienteController.llenarCombo();
		nombre.setText("");
		apellido.setText("");
		direcc.setText("");
		dni.setText("");
		fecha.setText("");
		habilita(false,false,false,false,false,false,false);
		
	}



	private void habilita(boolean nombre, boolean apellido, boolean direcc, boolean dni, boolean fecha, boolean btnM, boolean btnE) {
		this.nombre.setEnabled(nombre);
		this.apellido.setEnabled(apellido);
		this.direcc.setEnabled(direcc);
		this.dni.setEnabled(dni);
		this.fecha.setEnabled(fecha);
		this.btnModificar.setEnabled(btnM);
		this.btnEliminar.setEnabled(btnE);
		
	}
}
