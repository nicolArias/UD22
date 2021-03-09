package ud22.ej1;

import ud22.ej1.controller.ClienteController;
import ud22.ej1.model.service.ClienteServ;
import ud22.ej1.view.VisualBuscar;
import ud22.ej1.view.VisualPrincipal;
import ud22.ej1.view.VisualRegistro;

public class mainApp {
	
	ClienteServ clienteServ;
	VisualPrincipal visualPrincipal;
	VisualRegistro visualRegistro;
	VisualBuscar visualBuscar;
	ClienteController clienteController;

	public static void main(String[] args) {
		mainApp ma = new mainApp();
		ma.inicio();

	}

	private void inicio() {
		//Instaciamos las clases
		visualPrincipal = new VisualPrincipal();
		visualRegistro = new VisualRegistro();
		visualBuscar = new VisualBuscar();
		clienteServ = new ClienteServ();
		clienteController = new ClienteController();
		
		//A�adimos las relaciones entre clases
		visualPrincipal.setClienteController(clienteController);
		visualRegistro.setClienteController(clienteController);
		clienteController.setMiVisualBuscar(visualBuscar);
		clienteController.setClienteServ(clienteServ);
		clienteServ.setClienteController(clienteController);
		visualBuscar.setClienteController(clienteController);
		
		
		//A�adimos las relaciones del controlador
		
		clienteController.setMiVisualPrincipal(visualPrincipal);
		clienteController.setMiVisualRegistro(visualRegistro);
		
		
		
		visualPrincipal.setVisible(true);
	}

}
