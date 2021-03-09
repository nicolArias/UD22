package ud22.ej1.model.service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ud22.ej1.controller.ClienteController;
import ud22.ej1.model.dao.ClienteDao;
import ud22.ej1.model.dto.ClienteDto;

public class ClienteServ {

	private ClienteController clienteController;
	public static boolean consultaCliente = false;
	public static boolean modificaCliente = false;

	/**
	 * @return the clienteController
	 */
	public ClienteController getClienteController() {
		return clienteController;
	}

	/**
	 * @param clienteController the clienteController to set
	 */
	public void setClienteController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(ClienteDto miCliente) {
		ClienteDao miClienteDao;
		if (miCliente.getDniCliente().toString().length() == 8) {
			miClienteDao = new ClienteDao();
			miClienteDao.registrarCliente(miCliente);
		} else {
			JOptionPane.showMessageDialog(null, "El DNI del cliente ha de tener 8 digitos", "Advertencia",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public ClienteDto validarConsulta(String codigoCliente) {
		ClienteDao miClienteDao;

		try {
			int codigo = Integer.parseInt(codigoCliente);
			if (codigo > 0) {
				miClienteDao = new ClienteDao();
				consultaCliente = true;
				return miClienteDao.buscarCliente(codigo);
			} else {
				JOptionPane.showMessageDialog(null, "El ID del cliente no puede ser 0 ni negativo", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				consultaCliente = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaCliente = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaCliente = false;
		}

		return null;
	}
	
	//Metodo que valida los datos de Modificaci�n antes de pasar estos al DAO
		public void validarModificacion(ClienteDto miCliente) {
			ClienteDao miClienteDao;
			if (miCliente.getDniCliente().toString().length() == 8) {
				miClienteDao = new ClienteDao();
				miClienteDao.modificarCliente(miCliente);	
				modificaCliente=true;
			}else{
				JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				modificaCliente=false;
			}
		}

		//Metodo que valida los datos de Eliminaci�n antes de pasar estos al DAO
		public void validarEliminacion(String codigo) {
			ClienteDao miPersonaDao=new ClienteDao();
			miPersonaDao.eliminarCliente(codigo);
		}
		
		public ArrayList<Integer> getIds(){
			ClienteDao miCliente = new ClienteDao();
			return miCliente.getIds();
		}

}
