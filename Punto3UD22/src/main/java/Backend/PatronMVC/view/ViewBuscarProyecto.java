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
import Backend.PatronMVC.model.service.ProyectoServ;


public class ViewBuscarProyecto extends JFrame implements ActionListener {
private static final long serialVersionUID = 1L;
	
	private ProyectoController proyectoController; //objeto cientificoController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textId,textNombre;
	private JLabel dni,lblNombre;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	private JTextField textHoras;
	private JLabel lblNew;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public ViewBuscarProyecto() {

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
		
		lblNombre=new JLabel();
		lblNombre.setText("Nombre");
		lblNombre.setBounds(20, 120, 108, 25);
		getContentPane().add(lblNombre);
		
		textId=new JTextField();
		textId.setBounds(80, 80, 139, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 295, 25);
		getContentPane().add(textNombre);
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		textHoras = new JTextField();
		textHoras.setBounds(80, 167, 139, 25);
		getContentPane().add(textHoras);
		textHoras.setColumns(10);
		
		lblNew = new JLabel("Horas");
		lblNew.setBounds(20, 172, 46, 14);
		getContentPane().add(lblNew);

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
		
				proyectoController.modificarProyecto(proyecto);
				
				if (ProyectoServ.modificaProyecto==true) {
					habilita(true, false,false,  true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Proyecto proyecto=proyectoController.buscarProyecto(textId.getText());
			if (proyecto!=null)
			{
				muestraProyecto(proyecto);
			}
			else if(ProyectoServ.consultaProyecto==true){
				JOptionPane.showMessageDialog(null, "El proyecto no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true,true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar el Proyecto?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					proyectoController.eliminarProyecto(textId.getText());
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
	 * permite cargar los datos del proyecto consultado
	 * @param Cientifico
	 */
	private void muestraProyecto(Proyecto proyecto) {
		textNombre.setText(proyecto.getNombre());
		textHoras.setText(Integer.toString(proyecto.getHoras()));
		
		habilita(true, false,false,true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textId.setText("");
		textNombre.setText("");
		textHoras.setText("");
		
		habilita(true, false,false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param id
	 * @param nombre
	 * @param horas
	
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean id, boolean nombre,boolean horas,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(id);
		textNombre.setEditable(nombre);
		textHoras.setEditable(horas);
		
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
