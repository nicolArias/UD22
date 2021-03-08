package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.controller.ProyectoController;
import Backend.PatronMVC.model.dao.ProyectoDao;
import Backend.PatronMVC.model.dto.Proyecto;



public class ProyectoServ {
	private ProyectoController proyectoController;
	public static boolean consultaProyecto= false;
	public static boolean modificaProyecto = false;


	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Proyecto proyecto) {
		ProyectoDao proyectoDao;

		String id = proyecto.getId();
		
		/*Dependiendo la respuesta que nos devuelva el método validarDni, si es verdadero 
		 * entonces el dni es valido y lo podemos registrar
		 */
		if (validarId(id)) {
			
			proyectoDao = new ProyectoDao();
			proyectoDao.registrarProyecto(proyecto);
		} else {
			JOptionPane.showMessageDialog(null, "El numero de documento no es válido", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public boolean validarId(String id) {
		char[] cadenaId = id.toCharArray();
		System.out.println("CADENA DNI "+cadenaId.length);

		boolean esValido = false;
		
		// Validar el tamaño de caracteres, deber ser menor o igual a 4
		if (cadenaId.length>0 && cadenaId.length<=4) {
				esValido = true;
		}
		return esValido;
	}

	
	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Proyecto validarConsulta(String id) {
		ProyectoDao proyectoDao;

		try {
			if (validarId(id)) {
				proyectoDao = new ProyectoDao();
				consultaProyecto = true;
				return proyectoDao.buscarProyecto(id);
			} else {
				JOptionPane.showMessageDialog(null, "El documento de la persona no cumple con el formato",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				consultaProyecto = false;
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaProyecto = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Proyecto proyecto) {
		ProyectoDao proyectoDao;
		if (proyecto.getNombre().length() > 5) {
			proyectoDao = new ProyectoDao();
			proyectoDao.modificarProyecto(proyecto);
			modificaProyecto = true;
		} else {
			JOptionPane.showMessageDialog(null, "El nombre debe tener mas de 5 caracteres", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			modificaProyecto = false;
		}
	}

	// Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String id) {
		ProyectoDao proyectoDao = new ProyectoDao();
		
		if(validarId(id)) {
			proyectoDao.eliminarProyecto(id);
		}else {
			JOptionPane.showMessageDialog(null, "El documento ingresado no es válido", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		
	}

	public ProyectoController getProyectoController() {
		return proyectoController;
	}

	public void setController(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}

}
