package ud22.ej2.model.service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ud22.ej2.controller.VideoController;
import ud22.ej2.model.dao.VideoDao;
import ud22.ej2.model.dto.VideoDto;

public class VideoServ {

	private VideoController videoController;
	public static boolean consultaVideo = false;
	public static boolean modificaVideo = false;

	/**
	 * @return the VideoController
	 */
	public VideoController getVideoController() {
		return videoController;
	}

	/**
	 * @param VideoController the VideoController to set
	 */
	public void setVideoController(VideoController videoController) {
		this.videoController = videoController;
	}

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(VideoDto miVideo) {
		VideoDao miVideoDao;
		miVideoDao = new VideoDao();
		miVideoDao.registrarVideo(miVideo);
	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public VideoDto validarConsulta(String codigoVideo) {
		VideoDao miVideoDao;

		try {
			int codigo = Integer.parseInt(codigoVideo);
			if (codigo > 0) {
				miVideoDao = new VideoDao();
				consultaVideo = true;
				return miVideoDao.buscarVideo(codigo);
			} else {
				JOptionPane.showMessageDialog(null, "El ID del Video no puede ser 0 ni negativo", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				consultaVideo = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaVideo = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaVideo = false;
		}

		return null;
	}
	
	//Metodo que valida los datos de Modificaci�n antes de pasar estos al DAO
		public void validarModificacion(VideoDto miVideo) {
			VideoDao miVideoDao;
			
			miVideoDao = new VideoDao();
			miVideoDao.modificarVideo(miVideo);	
			modificaVideo=true;
			
		}

		//Metodo que valida los datos de Eliminaci�n antes de pasar estos al DAO
		public void validarEliminacion(String codigo) {
			VideoDao miPersonaDao=new VideoDao();
			miPersonaDao.eliminarVideo(codigo);
		}
		
		public ArrayList<Integer> getIds(){
			VideoDao miVideo = new VideoDao();
			return miVideo.getIds();
		}

}
