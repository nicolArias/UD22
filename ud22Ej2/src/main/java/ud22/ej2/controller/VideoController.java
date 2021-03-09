package ud22.ej2.controller;

import java.util.ArrayList;

import ud22.ej2.model.dto.VideoDto;
import ud22.ej2.model.service.ClienteServ;
import ud22.ej2.model.service.VideoServ;
import ud22.ej2.view.VisualBuscarVideo;
import ud22.ej2.view.VisualPrincipal;
import ud22.ej2.view.VisualRegistroVideo;

public class VideoController {

	private VideoServ VideoServ;
	private ClienteServ ClienteServ;
	private VisualPrincipal miVisualPrincipal;
	private VisualRegistroVideo miVisualRegistro;
	private VisualBuscarVideo miVisualBuscar;

	/**
	 * @return the clienteServ
	 */
	public ClienteServ getClienteServ() {
		return ClienteServ;
	}

	/**
	 * @param clienteServ the clienteServ to set
	 */
	public void setClienteServ(ClienteServ clienteServ) {
		ClienteServ = clienteServ;
	}

	/**
	 * @return the VideoServ
	 */
	public VideoServ getVideoServ() {
		return VideoServ;
	}

	/**
	 * @param VideoServ the VideoServ to set
	 */
	public void setVideoServ(VideoServ VideoServ) {
		this.VideoServ = VideoServ;
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
	public VisualRegistroVideo getMiVisualRegistro() {
		return miVisualRegistro;
	}

	/**
	 * @param miVisualRegistro the miVisualRegistro to set
	 */
	public void setMiVisualRegistro(VisualRegistroVideo miVisualRegistro) {
		this.miVisualRegistro = miVisualRegistro;
	}

	/**
	 * @return the miVisualBuscar
	 */
	public VisualBuscarVideo getMiVisualBuscar() {
		return miVisualBuscar;
	}

	/**
	 * @param miVisualBuscar the miVisualBuscar to set
	 */
	public void setMiVisualBuscar(VisualBuscarVideo miVisualBuscar) {
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
	public void registrarVideo(VideoDto miVideo) {
		VideoServ.validarRegistro(miVideo);
	}

	public VideoDto buscarVideo(String codigoVideo) {
		return VideoServ.validarConsulta(codigoVideo);
	}

	public void modificarVideo(VideoDto miVideo) {
		VideoServ.validarModificacion(miVideo);
	}

	public void eliminarVideo(String codigo) {
		VideoServ.validarEliminacion(codigo);
	}
	
	public ArrayList<Integer> getIds() {
		
		return VideoServ.getIds();
	}

	public void llenarComboBuscar() {
		
			ArrayList<Integer> ids = new ArrayList<Integer>();
			
			ids = VideoServ.getIds(); 
			
			for (Integer i : ids) {
				miVisualBuscar.llenar(i);
			}
	}
	public void llenarComboRegistro() {
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		ids = ClienteServ.getIds(); 
		
		for (Integer i : ids) {
			miVisualRegistro.llenar(i);
		}
}
	

}
