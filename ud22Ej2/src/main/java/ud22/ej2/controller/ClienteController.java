package ud22.ej2.controller;

import java.util.ArrayList;

import ud22.ej2.model.dto.ClienteDto;
import ud22.ej2.model.service.ClienteServ;
import ud22.ej2.view.VisualBuscarCliente;
import ud22.ej2.view.VisualBuscarVideo;
import ud22.ej2.view.VisualPrincipal;
import ud22.ej2.view.VisualRegistroCliente;

public class ClienteController {

	private ClienteServ clienteServ;
	private VisualPrincipal miVisualPrincipal;
	private VisualRegistroCliente miVisualRegistroCliente;
	private VisualBuscarCliente miVisualBuscarCliente;
	private VisualBuscarVideo miVisualBuscarVideo;

	/**
	 * @return the miVisualBuscarVideo
	 */
	public VisualBuscarVideo getMiVisualBuscarVideo() {
		return miVisualBuscarVideo;
	}

	/**
	 * @param miVisualBuscarVideo the miVisualBuscarVideo to set
	 */
	public void setMiVisualBuscarVideo(VisualBuscarVideo miVisualBuscarVideo) {
		this.miVisualBuscarVideo = miVisualBuscarVideo;
	}

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
	public VisualRegistroCliente getMiVisualRegistro() {
		return miVisualRegistroCliente;
	}

	/**
	 * @param miVisualRegistro the miVisualRegistro to set
	 */
	public void setMiVisualRegistro(VisualRegistroCliente miVisualRegistro) {
		this.miVisualRegistroCliente = miVisualRegistro;
	}

	/**
	 * @return the miVisualBuscar
	 */
	public VisualBuscarCliente getMiVisualBuscar() {
		return miVisualBuscarCliente;
	}

	/**
	 * @param miVisualBuscar the miVisualBuscar to set
	 */
	public void setMiVisualBuscar(VisualBuscarCliente miVisualBuscar) {
		this.miVisualBuscarCliente = miVisualBuscar;
	}

	// Hace visible las vistas de Registro y Consulta
	public void mostrarVisualRegistro() {
		miVisualRegistroCliente.setVisible(true);
	}

	public void mostrarVisualBuscar() {
		miVisualBuscarCliente.setVisible(true);
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
				miVisualBuscarCliente.llenar(i);
			}
	}
	public void llenarComboVideo() {
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids = clienteServ.getIds(); 
		
		for (Integer i : ids) {
			miVisualBuscarVideo.llenarCliente(i);
		}
}
	

}
