package ud22.ej2;

import ud22.ej2.controller.ClienteController;
import ud22.ej2.controller.VideoController;
import ud22.ej2.model.service.ClienteServ;
import ud22.ej2.model.service.VideoServ;
import ud22.ej2.view.VisualBuscarCliente;
import ud22.ej2.view.VisualBuscarVideo;
import ud22.ej2.view.VisualPrincipal;
import ud22.ej2.view.VisualRegistroCliente;
import ud22.ej2.view.VisualRegistroVideo;

public class mainApp {
	
	ClienteServ clienteServ;
	VisualPrincipal visualPrincipal;
	VisualRegistroCliente visualRegistroCliente;
	VisualBuscarCliente visualBuscarCliente;
	ClienteController clienteController;
	VideoServ videoServ;
	VisualRegistroVideo visualRegistroVideo;
	VisualBuscarVideo visualBuscarVideo;
	VideoController videoController;
	
	public static void main(String[] args) {
		mainApp ma = new mainApp();
		ma.inicio();

	}

	private void inicio() {
		//Instaciamos las clases
		visualPrincipal = new VisualPrincipal();
		visualRegistroCliente = new VisualRegistroCliente();
		visualBuscarCliente = new VisualBuscarCliente();
		clienteServ = new ClienteServ();
		clienteController = new ClienteController();
		
		//A�adimos las relaciones entre clases
		visualPrincipal.setClienteController(clienteController);
		visualRegistroCliente.setClienteController(clienteController);
		clienteController.setMiVisualBuscar(visualBuscarCliente);
		clienteController.setClienteServ(clienteServ);
		clienteServ.setClienteController(clienteController);
		visualBuscarCliente.setClienteController(clienteController);
		
		
		//A�adimos las relaciones del controlador
		
		clienteController.setMiVisualPrincipal(visualPrincipal);
		clienteController.setMiVisualRegistro(visualRegistroCliente);
		
		//Video
		visualRegistroVideo = new VisualRegistroVideo();
		visualBuscarVideo = new VisualBuscarVideo();
		videoServ = new VideoServ();
		videoController = new VideoController();
		
		//A�adimos las relaciones entre clases
		visualPrincipal.setVideoController(videoController);
		visualRegistroVideo.setVideoController(videoController);
		visualRegistroVideo.setClienteController(clienteController);
		videoController.setMiVisualBuscar(visualBuscarVideo);
		videoController.setVideoServ(videoServ);
		videoController.setClienteServ(clienteServ);
		videoServ.setVideoController(videoController);
		visualBuscarVideo.setVideoController(videoController);
		visualBuscarVideo.setClienteController(clienteController);
		clienteController.setMiVisualBuscarVideo(visualBuscarVideo);
		
		//A�adimos las relaciones del controlador
		
		videoController.setMiVisualPrincipal(visualPrincipal);
		videoController.setMiVisualRegistro(visualRegistroVideo);
		
		
		
		
		visualPrincipal.setVisible(true);
	}

}
