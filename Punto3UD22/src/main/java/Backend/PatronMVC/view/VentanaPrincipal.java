package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Backend.PatronMVC.controller.CPController;
import Backend.PatronMVC.controller.CientificoController;

import Backend.PatronMVC.controller.ProyectoController;


import java.awt.Font;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private ProyectoController proyectoController; 
	private CientificoController cientificoController;
	private CPController cpController;
	private JLabel labelTitulo, lblCientificos,lblProyectos,lblCP;
	private JButton btnCientificos,btnProyectos,btnCP,btnBuscarC,btnBuscarP,btnBuscarCP;
	

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

		btnCientificos = new JButton();
		btnCientificos.setBounds(61, 118, 120, 25);
		btnCientificos.setText("Registrar");
		
		btnProyectos = new JButton();
		btnProyectos.setBounds(61, 191, 120, 27);
		btnProyectos.setText("Registrar");

		labelTitulo = new JLabel();
		labelTitulo.setText("CIENTIFICOS (MENÚ)");
		labelTitulo.setBounds(147, 41, 187, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));
		
		lblCientificos = new JLabel();
		lblCientificos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCientificos.setText("Tabla Cientificos");
		lblCientificos.setBounds(66, 82, 250, 25);
		
		btnCP = new JButton("Registrar");
		btnCP.setBounds(61, 269, 120, 25);
		
		
		lblProyectos = new JLabel("Tabla Proyectos");
		lblProyectos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProyectos.setBounds(61, 166, 109, 14);
		
		
		lblCP = new JLabel("Tabla Cientificos_Proyectos");
		lblCP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCP.setBounds(61, 244, 194, 14);
		
		
		btnBuscarC = new JButton("Buscar");
		btnBuscarC.setBounds(282, 118, 120, 25);
		
		
		btnBuscarP = new JButton("Buscar");
		btnBuscarP.setBounds(282, 191, 120, 27);
		
		
		btnBuscarCP = new JButton("Buscar");
		btnBuscarCP.setBounds(282, 269, 120, 25);
		getContentPane().add(btnBuscarCP);


		btnCientificos.addActionListener(this);
		btnProyectos.addActionListener(this);
		btnCP.addActionListener(this);
		btnBuscarC.addActionListener(this);
		btnBuscarP.addActionListener(this);
		btnBuscarCP.addActionListener(this);
		getContentPane().add(btnProyectos);
		getContentPane().add(btnCientificos);
		getContentPane().add(btnCP);
		getContentPane().add(btnBuscarC);
		getContentPane().add(btnBuscarP);
		getContentPane().add(btnBuscarCP);
		getContentPane().add(lblCientificos);
		getContentPane().add(lblProyectos);
		getContentPane().add(lblCP);
		getContentPane().add(labelTitulo);
	
		setSize(480, 350);
		setTitle("LABORATORIO MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		
	}


	public void setCoordinadorC(CientificoController cientificoController) {
		this.cientificoController=cientificoController;
	}
	
	public void setCoordinadorP(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}
	
	public void setCoordinadorCP(CPController cpController) {
		this.cpController=cpController;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//CIENTIFICOS
		if (e.getSource()==btnCientificos) {
			cientificoController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==btnBuscarC) {
			cientificoController.mostrarVentanaConsulta();			
		}
		
		//PROYECTOS
		if (e.getSource()==btnProyectos) {
			proyectoController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==btnBuscarP) {
			proyectoController.mostrarVentanaConsulta();			
		}
		
		//CIENTIFICOS_PROYECTOS
		if (e.getSource()==btnCP) {
			//cientificoController.mostrarVentanaConsulta();			
		}
		if (e.getSource()==btnBuscarCP) {
			//cientificoController.mostrarVentanaConsulta();			
		}
		
		
	}
}
