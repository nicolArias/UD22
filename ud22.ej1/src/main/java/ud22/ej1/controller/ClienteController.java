package ud22.ej1.controller;

import java.util.ArrayList;



import ud22.ej1.model.dto.ClienteDto;
import ud22.ej1.model.service.ClienteServ;
import ud22.ej1.view.VisualBuscar;
import ud22.ej1.view.VisualPrincipal;
import ud22.ej1.view.VisualRegistro;

public class ClienteController {

	private ClienteServ clienteServ;
	private VisualPrincipal miVisualPrincipal;
	private VisualRegistro miVisualRegistro;
	private VisualBuscar miVisualBuscar;

	/**
	 * @return the clienteServ
	 */
	public ClienteServ getClienteServ() {
		return clienteServ;
	}

	/**
	 * @param clienteServ the clienteServ to set
	 */
	public void setClienteServ(ClienteServ clienteServ) {
		this.clienteServ = clienteServ;
	}

	/**
	 * @return the miVisualPrincipal
	 */
	public VisualPrincipal getMiVisualPrincipal() {
		return miVisualPrincipal;
	}

	/**
	 * @param miVisualPrincipal the miVisualPrincipal to set
	 */
	public void setMiVisualPrincipal(VisualPrincipal miVisualPrincipal) {
		this.miVisualPrincipal = miVisualPrincipal;
	}

	/**
	 * @return the miVisualRegistro
	 */
	public VisualRegistro getMiVisualRegistro() {
		return miVisualRegistro;
	}

	/**
	 * @param miVisualRegistro the miVisualRegistro to set
	 */
	public void setMiVisualRegistro(VisualRegistro miVisualRegistro) {
		this.miVisualRegistro = miVisualRegistro;
	}

	/**
	 * @return the miVisualBuscar
	 */
	public VisualBuscar getMiVisualBuscar() {
		return miVisualBuscar;
	}

	/**
	 * @param miVisualBuscar the miVisualBuscar to set
	 */
	public void setMiVisualBuscar(VisualBuscar miVisualBuscar) {
		this.miVisualBuscar = miVisualBuscar;
	}

	// Hace visible las vistas de Registro y Consulta
	public void mostrarVisualRegistro() {
		miVisualRegistro.setVisible(true);
	}

	public void mostrarVisualBuscar() {
		miVisualBuscar.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarCliente(ClienteDto miCliente) {
		clienteServ.validarRegistro(miCliente);
	}

	public ClienteDto buscarCliente(String codigoCliente) {
		return clienteServ.validarConsulta(codigoCliente);
	}

	public void modificarCliente(ClienteDto miCliente) {
		clienteServ.validarModificacion(miCliente);
	}

	public void eliminarCliente(String codigo) {
		clienteServ.validarEliminacion(codigo);
	}
	
	public ArrayList<Integer> getIds() {
		
		return clienteServ.getIds();
	}

	public void llenarCombo() {
		
			ArrayList<Integer> ids = new ArrayList<Integer>();
			
			ids = clienteServ.getIds(); 
			
			for (Integer i : ids) {
				miVisualBuscar.llenar(i);
			}
			
		
		
	}
	

}
