package Backend.PatronMVC.view;

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
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.model.service.Cientifico_ProyectoServ;

import java.awt.Font;

public class ViewBuscarCP extends JFrame implements ActionListener {
	

	private static final long serialVersionUID = 1L;
	
	private CPController cpController; //objeto cientificoController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textDni,textIdP;
	private JLabel lblDni,lblIdProyecto;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public ViewBuscarCP() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(330, 80, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("Administrar Cientificos y Proyectos");
		labelTitulo.setBounds(50, 39, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		lblDni=new JLabel();
		lblDni.setText("DNI Cientifico");
		lblDni.setBounds(94, 80, 67, 25);
		getContentPane().add(lblDni);
		
		lblIdProyecto=new JLabel();
		lblIdProyecto.setText("Id Proyecto");
		lblIdProyecto.setBounds(94, 120, 67, 25);
		getContentPane().add(lblIdProyecto);
		
		textDni=new JTextField();
		textDni.setBounds(171, 80, 139, 25);
		getContentPane().add(textDni);
		
		textIdP=new JTextField();
		textIdP.setBounds(171, 120, 139, 25);
		getContentPane().add(textIdP);
		
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
				cp.setDniC_fk(textDni.getText());
				cp.setIdP_fk((textIdP.getText()));
		
				cpController.modificarCP(cp);
				
				if (CientificoServ.modificaCientifico==true) {
					habilita(true, false,  true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cientifico_Proyecto cp=cpController.buscarCP(textDni.getText());
			if (cp!=null)
			{
				muestraCP(cp);
			}
			else if(Cientifico_ProyectoServ.consultaCP==true){
				JOptionPane.showMessageDialog(null, "El cientifico no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false,true,true,true,false,false);
			
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
					cpController.eliminarCP(textDni.getText());
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
	private void muestraCP(Cientifico_Proyecto cp) {
		textIdP.setText(cp.getIdP_fk());
		
		habilita(true, false,true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textDni.setText("");
		textIdP.setText("");
		
		habilita(true, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param dni
	 * @param id
	
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean dni, boolean id,boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textDni.setEditable(dni);
		textIdP.setEditable(id);
		
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
