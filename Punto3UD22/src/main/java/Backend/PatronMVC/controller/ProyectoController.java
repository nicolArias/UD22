package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Proyecto;
import Backend.PatronMVC.model.service.ProyectoServ;
import Backend.PatronMVC.view.ViewBuscarProyecto;
import Backend.PatronMVC.view.ViewRegistroProyecto;

public class ProyectoController {
	private ProyectoServ proyectoServ;
	private ViewRegistroProyecto miVentanaRegistroP;
	private ViewBuscarProyecto miVentanaBuscarP;
	
	public ViewRegistroProyecto getViewRegistroP() {
		return miVentanaRegistroP;
	}
	public void setViewRegistroP(ViewRegistroProyecto miVentanaRegistroP) {
		this.miVentanaRegistroP = miVentanaRegistroP;
	}
	public ViewBuscarProyecto getViewBuscarP() {
		return miVentanaBuscarP;
	}
	public void setViewBuscarP(ViewBuscarProyecto miVentanaBuscarP) {
		this.miVentanaBuscarP = miVentanaBuscarP;
	}
	public ProyectoServ getProyectoServ() {
		return proyectoServ;
	}
	public void setProyectoServ(ProyectoServ proyectoServ) {
		this.proyectoServ = proyectoServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistroP.setVisible(true);
	}
	public void mostrarVentanaConsulta() {
		miVentanaBuscarP.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarProyecto(Proyecto proyecto) {
		proyectoServ.validarRegistro(proyecto);
	}
	
	public Proyecto buscarProyecto(String id) {
		return proyectoServ.validarConsulta(id);
	}
	
	public void modificarProyecto(Proyecto proyecto) {
		proyectoServ.validarModificacion(proyecto);
	}
	
	public void eliminarProyecto(String id) {
		proyectoServ.validarEliminacion(id);
	}

}
