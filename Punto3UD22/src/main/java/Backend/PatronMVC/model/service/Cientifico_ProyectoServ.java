package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.controller.CPController;
import Backend.PatronMVC.model.dao.Cientifico_ProyectoDao;
import Backend.PatronMVC.model.dto.Cientifico_Proyecto;


public class Cientifico_ProyectoServ {
	
	
	private CPController cpController;
	public static boolean consultaCP = false;
	public static boolean modificaCP = false;



	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cientifico_Proyecto cp) {
		Cientifico_ProyectoDao cpDao;

		String dni_fk = cp.getDniC_fk();
		
		/*Dependiendo la respuesta que nos devuelva el método validarDni, si es verdadero 
		 * entonces el dni es valido y lo podemos registrar
		 */
		if (validarDni(dni_fk)) {
			
			cpDao = new Cientifico_ProyectoDao();
			cpDao.registrarC_P(cp);
		} else {
			JOptionPane.showMessageDialog(null, "El numero de documento no es válido", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public boolean validarDni(String dni) {
		char[] cadenaDni = dni.toCharArray();
		System.out.println("CADENA DNI "+cadenaDni.length);
		
		int[] numerosDni = new int[8];

		for (int i = 0; i<8; i++) {
			numerosDni[i] = cadenaDni[i];
		}
		System.out.println("NUMEROS DNI"+numerosDni.length);
		boolean esValido = false;
		
		// Validar el tamaño de caracteres, deber ser igual a 9
		if (cadenaDni.length == 9) {
			System.out.println("primera condicion");
			// Validar la cantidad de numeros, deber tener 8
			if (numerosDni.length == 8) {
				System.out.println("segunda condicion");
				int valorASCII = cadenaDni[8];// Se almacenara el la letra en un entero para convertirlo en un valor ASCII
				System.out.println(valorASCII+" "+cadenaDni[8] );
				// Validar que el caracter se encuentre dentro del alfabeto
				if ((valorASCII >= 65 && valorASCII <= 90) || (valorASCII >= 97 && valorASCII <= 122)) {
					
					esValido = true;
					System.out.println("entrooo "+valorASCII);
				}
			}
		}

		return esValido;

	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cientifico_Proyecto validarConsulta(String dni) {
		Cientifico_ProyectoDao cpDao;

		try {
			if (validarDni(dni)) {
				cpDao = new Cientifico_ProyectoDao();
				consultaCP = true;
				return cpDao.buscarC_P(dni);
			} else {
				JOptionPane.showMessageDialog(null, "El documento no cumple con el formato",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				consultaCP = false;
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaCP = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cientifico_Proyecto cp) {
		Cientifico_ProyectoDao cpDao;
		
		if (cp.getIdP_fk().length() <=4 ) {
			cpDao = new Cientifico_ProyectoDao();
			cpDao.modificarC_P(cp);
			modificaCP = true;
		} else {
			JOptionPane.showMessageDialog(null, "El codigo del proyecto debe tener menos de 5 caracteres", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			modificaCP = false;
		}
	}

	// Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String dni) {
		Cientifico_ProyectoDao cpDao = new Cientifico_ProyectoDao();
		
		if(validarDni(dni)) {
			cpDao.eliminarC_P(dni);
		}else {
			JOptionPane.showMessageDialog(null, "El documento ingresado no es válido", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		
	}

	public CPController getCPController() {
		return cpController;
	}

	public void setController(CPController cpController) {
		this.cpController = cpController;
	}

}
