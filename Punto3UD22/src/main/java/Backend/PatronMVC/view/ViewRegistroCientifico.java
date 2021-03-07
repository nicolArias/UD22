package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.CientificoController;
import Backend.PatronMVC.controller.PersonaController;
import Backend.PatronMVC.model.dto.Persona;


public class ViewRegistroCientifico extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private CientificoController cientificoController; //objeto cientificoController que permite la relacion entre esta clase y la clase PersonaController
	private JLabel labelTitulo;
	private JTextField textDni,textNombre,textProfesion;
	private JLabel lblDni,lblNombre,lblApellidos;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public ViewRegistroCientifico() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE CIENTIFICOS");
		labelTitulo.setBounds(94, 21, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		lblDni=new JLabel();
		lblDni.setText("DNI");
		lblDni.setBounds(20, 80, 80, 25);
		getContentPane().add(lblDni);
		
		lblNombre=new JLabel();
		lblNombre.setText("Nombre");
		lblNombre.setBounds(20, 120, 80, 25);
		getContentPane().add(lblNombre);
		
		lblApellidos=new JLabel();
		lblApellidos.setText("Apellidos");
		lblApellidos.setBounds(20, 160, 80, 25);
		getContentPane().add(lblApellidos);
		
		textDni=new JTextField();
		textDni.setBounds(80, 80, 150, 25);
		getContentPane().add(textDni);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 340, 25);
		getContentPane().add(textNombre);
		

		textProfesion=new JTextField();
		textProfesion.setBounds(80, 160, 340, 25);
		getContentPane().add(textProfesion);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textCod.setText("");
		textNombre.setText("");
		textDNI.setText("");
		textProfesion.setText("");
	}


	public void setCoordinador(PersonaController personaController) {
		this.personaController=personaController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Persona miPersona=new Persona();
				miPersona.setIdPersona(Integer.parseInt(textCod.getText()));
				miPersona.setNombrePersona(textNombre.getText());
				miPersona.setTelefonoPersona(Integer.parseInt(textTelefono.getText()));
				miPersona.setEdadPersona(Integer.parseInt(textDNI.getText()));
				miPersona.setProfesionPersona(textProfesion.getText());
				
				personaController.registrarPersona(miPersona);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
	

}
