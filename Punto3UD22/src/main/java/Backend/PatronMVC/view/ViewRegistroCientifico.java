package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.CientificoController;
import Backend.PatronMVC.model.dto.Cientifico;



public class ViewRegistroCientifico extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private CientificoController cientificoController; //objeto cientificoController que permite la relacion entre esta clase y la clase PersonaController
	private JLabel labelTitulo;
	private JTextField textDni,textNomApels;
	private JLabel lblDni,lblNombre;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public ViewRegistroCientifico() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 184, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(251, 184, 120, 25);
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
		lblNombre.setText("Nombre y Apellidos");
		lblNombre.setBounds(20, 120, 120, 25);
		getContentPane().add(lblNombre);
		
		textDni=new JTextField();
		textDni.setBounds(80, 80, 150, 25);
		getContentPane().add(textDni);
		
		textNomApels=new JTextField();
		textNomApels.setBounds(133, 120, 279, 25);
		getContentPane().add(textNomApels);
		
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
		textDni.setText("");
		textNomApels.setText("");
	
	}


	public void setCoordinador(CientificoController cientificoController) {
		this.cientificoController=cientificoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cientifico cientifico=new Cientifico();
				cientifico.setDNI(textDni.getText());
				cientifico.setNomApels(textNomApels.getText());
				
				cientificoController.registrarCientifico(cientifico);	
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
