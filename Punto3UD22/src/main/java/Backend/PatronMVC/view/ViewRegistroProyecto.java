package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.ProyectoController;
import Backend.PatronMVC.model.dto.Proyecto;



public class ViewRegistroProyecto extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private ProyectoController proyectoController; //objeto cientificoController que permite la relacion entre esta clase y la clase PersonaController
	private JLabel labelTitulo;
	private JTextField textId,textNombre,textHoras;
	private JLabel lblId,lblNombre,lblHoras;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public ViewRegistroProyecto() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE PROYECTO");
		labelTitulo.setBounds(94, 21, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		lblId=new JLabel();
		lblId.setText("Id");
		lblId.setBounds(20, 80, 80, 25);
		getContentPane().add(lblId);
		
		lblNombre=new JLabel();
		lblNombre.setText("Nombre");
		lblNombre.setBounds(20, 120, 120, 25);
		getContentPane().add(lblNombre);
		
		textId=new JTextField();
		textId.setBounds(80, 80, 150, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 116, 271, 25);
		getContentPane().add(textNombre);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(20, 168, 46, 14);
		getContentPane().add(lblHoras);
		
		textHoras = new JTextField();
		textHoras.setBounds(80, 162, 113, 26);
		getContentPane().add(textHoras);
		
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("LABORATORIO MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
	}


	private void limpiar(){
		textId.setText("");
		textNombre.setText("");
	}


	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Proyecto proyecto=new Proyecto();
				proyecto.setId(textId.getText());
				proyecto.setNombre(textNombre.getText());
				proyecto.setHoras(Integer.parseInt(textHoras.getText()));
				
				proyectoController.registrarProyecto(proyecto);	
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
