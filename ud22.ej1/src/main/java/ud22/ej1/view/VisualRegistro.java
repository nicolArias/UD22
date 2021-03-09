package ud22.ej1.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.SwingConstants;

import ud22.ej1.controller.ClienteController;
import ud22.ej1.model.dto.ClienteDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class VisualRegistro extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteController clienteController;
	private JPanel contentPane;
	private JButton btnGuardar,btnCancelar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField nombre,apellido,direcc,dni,dia,mes,ano;
	
	public VisualRegistro() {
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
		
		lblNewLabel = new JLabel("Nombre ");
		lblNewLabel.setBounds(10, 43, 61, 18);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("A\u00F1adir cliente");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(167, 10, 116, 28);
		contentPane.add(lblNewLabel_1);
		
		nombre = new JTextField();
		nombre.setBounds(62, 43, 96, 19);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(209, 46, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		apellido = new JTextField();
		apellido.setBounds(264, 43, 96, 19);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(10, 99, 61, 13);
		contentPane.add(lblNewLabel_3);
		
		direcc = new JTextField();
		direcc.setBounds(62, 96, 192, 19);
		contentPane.add(direcc);
		direcc.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DNI");
		lblNewLabel_4.setBounds(10, 145, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		dni = new JTextField();
		dni.setBounds(62, 142, 96, 19);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha");
		lblNewLabel_5.setBounds(209, 145, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		dia = new JTextField();
		dia.setBounds(264, 142, 31, 19);
		contentPane.add(dia);
		dia.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("/");
		lblNewLabel_6.setBounds(305, 145, 19, 13);
		contentPane.add(lblNewLabel_6);
		
		mes = new JTextField();
		mes.setBounds(315, 142, 31, 19);
		contentPane.add(mes);
		mes.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("/");
		lblNewLabel_7.setBounds(356, 145, 19, 13);
		contentPane.add(lblNewLabel_7);
		
		ano = new JTextField();
		ano.setBounds(366, 142, 31, 19);
		contentPane.add(ano);
		ano.setColumns(10);
		
		btnGuardar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}


	/**
	 * @param clienteController the clienteController to set
	 */
	public void setClienteController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGuardar) {
			try {
				ClienteDto miCliente = new ClienteDto();
				String fecha = ano.getText()+"-"+mes.getText()+"-"+dia.getText();
				miCliente.setNombreCliente(nombre.getText());
				miCliente.setApellidoCliente(apellido.getText());
				miCliente.setDireccionCliente(direcc.getText());
				miCliente.setDniCliente(Integer.parseInt(dni.getText()));
				miCliente.setFechaCliente(fecha);
				
				clienteController.registrarCliente(miCliente);
				limpiar();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error en el registro");
			}
		}
		
		if(e.getSource() == btnCancelar) {
			this.dispose();
		}
		
	}
	private void limpiar() {
		clienteController.getMiVisualBuscar().comboBox.removeAllItems();
		clienteController.llenarCombo();
		nombre.setText("");
		apellido.setText("");
		direcc.setText("");
		dni.setText("");
		ano.setText("");
		mes.setText("");
		dia.setText("");
		//habilita(false,false,false,false,false,false,false);
		
	}
}
