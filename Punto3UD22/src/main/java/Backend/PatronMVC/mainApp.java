package Backend.PatronMVC;

import Backend.PatronMVC.controller.CPController;
import Backend.PatronMVC.controller.CientificoController;
import Backend.PatronMVC.controller.PrincipalController;
import Backend.PatronMVC.controller.ProyectoController;
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.model.service.Cientifico_ProyectoServ;
import Backend.PatronMVC.model.service.ProyectoServ;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.ViewBuscarCP;
import Backend.PatronMVC.view.ViewBuscarCientifico;
import Backend.PatronMVC.view.ViewBuscarProyecto;
import Backend.PatronMVC.view.ViewRegistroCP;
import Backend.PatronMVC.view.ViewRegistroCientifico;
import Backend.PatronMVC.view.ViewRegistroProyecto;

public class mainApp {
	
	CientificoServ miCientificoServ;
	VentanaPrincipal miVentanaPrincipal;
	ViewBuscarCientifico miVentanaBuscarC;
	ViewRegistroCientifico miVentanaRegistroC;
	CientificoController cientificoController;
	PrincipalController principalController;
	
	//PROYECTO
	ProyectoServ miProyectoServ;
	ViewBuscarProyecto miVentanaBuscarP;
	ViewRegistroProyecto miVentanaRegistroP;
	ProyectoController proyectoController;
	
	//CIENTIFICO_PROYECTO
	Cientifico_ProyectoServ miCpServ;
	ViewBuscarCP miVentanaBuscarCP;
	ViewRegistroCP miVentanaRegistroCP;
	CPController cpController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mainApp miPrincipal=new mainApp();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		miVentanaPrincipal=new VentanaPrincipal();
		miVentanaRegistroC=new ViewRegistroCientifico();
		miVentanaBuscarC= new ViewBuscarCientifico();
		miCientificoServ=new CientificoServ();
		cientificoController= new CientificoController();
		//principalController=new PrincipalController();
		
		//PROYECTO
		miVentanaRegistroP=new ViewRegistroProyecto();
		miVentanaBuscarP=new ViewBuscarProyecto();
		miProyectoServ=new ProyectoServ();
		proyectoController=new ProyectoController();
		
		//CIENTIFICO_PROYECTO
		miVentanaRegistroCP=new ViewRegistroCP();
		miVentanaBuscarCP=new ViewBuscarCP();
		miCpServ=new Cientifico_ProyectoServ();
		cpController=new CPController();
		
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinadorC(cientificoController);
		//miVentanaPrincipal.setCoordinador(principalController);
		miVentanaRegistroC.setCoordinador(cientificoController);
		miVentanaBuscarC.setCoordinador(cientificoController);
		miCientificoServ.setController(cientificoController);
		
		//PROYECTO
		miVentanaPrincipal.setCoordinadorP(proyectoController);
		miVentanaRegistroP.setCoordinador(proyectoController);
		miVentanaBuscarP.setCoordinador(proyectoController);
		miProyectoServ.setController(proyectoController);
		
		//CIENTIFICO_PROYECTO
		miVentanaPrincipal.setCoordinadorCP(cpController);
		miVentanaRegistroCP.setCoordinador(cpController);
		miVentanaBuscarCP.setCoordinador(cpController);
		miCpServ.setController(cpController);
		
		/*Se establecen relaciones con la clase coordinador*/
		//principalController.setMiVentanaPrincipal(miVentanaPrincipal);
		cientificoController.setViewRegistroC(miVentanaRegistroC);
		cientificoController.setViewBuscarC(miVentanaBuscarC);
		cientificoController.setCientificoServ(miCientificoServ);
		
		//PROYECTO 
		proyectoController.setViewRegistroP(miVentanaRegistroP);
		proyectoController.setViewBuscarP(miVentanaBuscarP);
		proyectoController.setProyectoServ(miProyectoServ);
		
		//CIENTIFICO_PROYECTO
		cpController.setCPServ(miCpServ);
		cpController.setViewBuscarCP(miVentanaBuscarCP);
		cpController.setViewRegistroCP(miVentanaRegistroCP);
				
		miVentanaPrincipal.setVisible(true);
	}

}
