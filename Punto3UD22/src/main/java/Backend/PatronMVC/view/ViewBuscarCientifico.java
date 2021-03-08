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


public class ViewBuscarCientifico  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private CientificoController cientificoController; //objeto cientificoController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textDni,textNomApels;
	private JLabel dni,nombre;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public ViewBuscarCientifico() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(229, 80, 50, 25);
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
		nombre.setText("Nombre y Apellidos");
		nombre.setBounds(20, 120, 108, 25);
		getContentPane().add(nombre);
		
		textDni=new JTextField();
		textDni.setBounds(80, 80, 139, 25);
		getContentPane().add(textDni);
		
		textNomApels=new JTextField();
		textNomApels.setBounds(132, 120, 295, 25);
		getContentPane().add(textNomApels);
		
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
				cientifico.setNomApels((textNomApels.getText()));
		
				cientificoController.modificarCientifico(cientifico);
				
				if (CientificoServ.modificaCientifico==true) {
					habilita(true, false,  true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cientifico cientifico=cientificoController.buscarCientifico(textDni.getText());
			if (cientifico!=null)
			{
				muestraCientifico(cientifico);
			}
			else if(CientificoServ.consultaCientifico==true){
				JOptionPane.showMessageDialog(null, "El cientifico no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textDni.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar el Cientifico?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					cientificoController.eliminarCientifico(textDni.getText());
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
	 * permite cargar los datos del cientifico consultado
	 * @param Cientifico
	 */
	private void muestraCientifico(Cientifico cientifico) {
		textNomApels.setText(cientifico.getNomApels());
		
		habilita(true, false,true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textDni.setText("");
		textNomApels.setText("");
		
		habilita(true, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param dni
	 * @param nomApels
	
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean dni, boolean nomApels,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textDni.setEditable(dni);
		textNomApels.setEditable(nomApels);
		
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
