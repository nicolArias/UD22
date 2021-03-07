package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.controller.CientificoController;


public class VentanaBuscar  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private CientificoController cientificoController; //objeto cientificoController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textDni,textNombre,textApellidos;
	private JLabel dni,nombre,apellidos;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscar() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 80, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("Administrar CIENTIFICOS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		dni=new JLabel();
		dni.setText("DNI");
		dni.setBounds(20, 80, 80, 25);
		getContentPane().add(dni);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		getContentPane().add(nombre);
		
		apellidos=new JLabel();
		apellidos.setText("Apellidos");
		apellidos.setBounds(20, 160, 80, 25);
		getContentPane().add(apellidos);
		
		textDni=new JTextField();
		textDni.setBounds(80, 80, 80, 25);
		getContentPane().add(textDni);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 327, 25);
		getContentPane().add(textNombre);
		
		textApellidos=new JTextField();
		textApellidos.setBounds(80, 160, 327, 25);
		getContentPane().add(textApellidos);
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		getContentPane().add(botonCancelar);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonModificar);
		getContentPane().add(botonEliminar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

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
				cientifico.setNomApels((textNombre.getText())+" "+(textApellidos.getText()));
		
				cientificoController.modificarCientifico(cientifico);
				
				if (CientificoServ.modificaCientifico==true) {
					habilita(true, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Persona miPersona=personaController.buscarPersona(textCod.getText());
			if (miPersona!=null)
			{
				muestraPersona(miPersona);
			}
			else if(PersonaServ.consultaPersona==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textCod.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Persona?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					personaController.eliminarPersona(textCod.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la persona consultada
	 * @param miPersona
	 */
	private void muestraPersona(Persona miPersona) {
		textNombre.setText(miPersona.getNombrePersona());
		textEdad.setText(miPersona.getEdadPersona()+"");
		textTelefono.setText(miPersona.getTelefonoPersona()+"");
		textProfesion.setText(miPersona.getProfesionPersona());
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCod.setText("");
		textNombre.setText("");
		textProfesion.setText("");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param edad
	 * @param tel
	 * @param profesion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean nombre, boolean edad, boolean tel, boolean profesion,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCod.setEditable(codigo);
		textNombre.setEditable(nombre);
		textProfesion.setEditable(profesion);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
