package Backend.PatronMVC.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.CPController;
import Backend.PatronMVC.controller.CientificoController;
import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.model.dto.Cientifico_Proyecto;


public class ViewRegistroCP extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private CPController cpController; //objeto cientificoController que permite la relacion entre esta clase y la clase PersonaController
	private JLabel labelTitulo;
	private JTextField textDniC,textIdProyecto;
	private JLabel lblDniC,lblId;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public ViewRegistroCP() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(61, 184, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(208, 184, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE CIENTIFICOS Y PROYECTOS");
		labelTitulo.setBounds(33, 28, 346, 30);
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 14));

		lblDniC=new JLabel();
		lblDniC.setText("DNI Cientifico");
		lblDniC.setBounds(61, 80, 80, 25);
		getContentPane().add(lblDniC);
		
		lblId=new JLabel();
		lblId.setText("Id Proyecto");
		lblId.setBounds(61, 120, 62, 25);
		getContentPane().add(lblId);
		
		textDniC=new JTextField();
		textDniC.setBounds(179, 80, 150, 25);
		getContentPane().add(textDniC);
		
		textIdProyecto=new JTextField();
		textIdProyecto.setBounds(179, 120, 150, 25);
		getContentPane().add(textIdProyecto);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(415, 300);
		setTitle("LABORATORIO MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textIdProyecto.setText("");
		textDniC.setText("");
	
	}


	public void setCoordinador(CPController cpController) {
		this.cpController=cpController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cientifico_Proyecto cp=new Cientifico_Proyecto();
				cp.setDniC_fk(textDniC.getText());
				cp.setIdP_fk(textIdProyecto.getText());
				
				cpController.registrarCP(cp);	
				
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