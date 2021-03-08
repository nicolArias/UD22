/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de negocio, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite registrar la persona en
 * el Dao.
 */

package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.controller.CientificoController;
import Backend.PatronMVC.model.dao.CientificoDao;
import Backend.PatronMVC.model.dto.Cientifico;

public class CientificoServ {

	private CientificoController cientificoController;
	public static boolean consultaCientifico = false;
	public static boolean modificaCientifico = false;

	// Metodo de vinculación con el controller principal
	/*public void setCientificoController(CientificoController cientificoController) {
		this.setCientificoController(cientificoController);
		
	}*/

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cientifico cientifico) {
		CientificoDao cientificoDao;

		String dni = cientifico.getDNI();
		
		/*Dependiendo la respuesta que nos devuelva el método validarDni, si es verdadero 
		 * entonces el dni es valido y lo podemos registrar
		 */
		if (validarDni(dni)) {
			
			cientificoDao = new CientificoDao();
			cientificoDao.registrarCientifico(cientifico);
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
	public Cientifico validarConsulta(String dniC) {
		CientificoDao cientificoDao;

		try {
			if (validarDni(dniC)) {
				cientificoDao = new CientificoDao();
				consultaCientifico = true;
				return cientificoDao.buscarCientifico(dniC);
			} else {
				JOptionPane.showMessageDialog(null, "El documento de la persona no cumple con el formato",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				consultaCientifico = false;
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaCientifico = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cientifico cientifico) {
		CientificoDao cientificoDao;
		if (cientifico.getNomApels().length() > 5) {
			cientificoDao = new CientificoDao();
			cientificoDao.modificarCientifico(cientifico);
			modificaCientifico = true;
		} else {
			JOptionPane.showMessageDialog(null, "El nombre de la persona debe ser mayor a 5 digitos", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			modificaCientifico = false;
		}
	}

	// Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String dni) {
		CientificoDao cientificoDao = new CientificoDao();
		
		if(validarDni(dni)) {
			cientificoDao.eliminarCientifico(dni);
		}else {
			JOptionPane.showMessageDialog(null, "El documento ingresado no es válido", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		
	}

	public CientificoController getCientificoController() {
		return cientificoController;
	}

	public void setController(CientificoController cientificoController) {
		this.cientificoController = cientificoController;
	}

}
