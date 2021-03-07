package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Backend.PatronMVC.controller.PersonaController;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private PersonaController personaController; //objeto PersonaController que permite la relacion entre esta clase y la clase PersonaController
	private JLabel labelTitulo, labelSeleccion;
	private JButton botonRegistrar,botonBuscar;
	

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana principal
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		botonRegistrar = new JButton();
		botonRegistrar.setBounds(61, 124, 120, 25);
		botonRegistrar.setText("Cientificos");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(61, 160, 120, 25);
		botonBuscar.setText("Proyectos");

		labelTitulo = new JLabel();
		labelTitulo.setText("CIENTIFICOS (MENÚ)");
		labelTitulo.setBounds(147, 41, 187, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja la tabla:");
		labelSeleccion.setBounds(66, 82, 250, 25);

		textoIntroduccion = "Esta aplicación presenta un ejemplo práctico del patron "
				+ "de diseño MVC.\n\n"
				+ "La aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Persona." +
				"tambien son vinculados algunos conceptos de los Patrones Value Object y Data Access Objetc\n";

		botonRegistrar.addActionListener(this);
		botonBuscar.addActionListener(this);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonRegistrar);
		getContentPane().add(labelSeleccion);
		getContentPane().add(labelTitulo);
	
		setSize(480, 350);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cientifico_Proyecto");
		btnNewButton.setBounds(61, 196, 153, 25);
		getContentPane().add(btnNewButton);

	}


	public void setCoordinador(PersonaController personaController) {
		this.personaController=personaController;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonRegistrar) {
			personaController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscar) {
			personaController.mostrarVentanaConsulta();			
		}
	}
}
