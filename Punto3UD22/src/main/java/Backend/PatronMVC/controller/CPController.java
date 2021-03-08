package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Cientifico_Proyecto;
import Backend.PatronMVC.model.service.Cientifico_ProyectoServ;
import Backend.PatronMVC.view.ViewBuscarCP;
import Backend.PatronMVC.view.ViewRegistroCP;

public class CPController {
	
	private Cientifico_ProyectoServ cpServ;
	private ViewRegistroCP miVentanaRegistroCP;
	private ViewBuscarCP miVentanaBuscarCP;
	
	public ViewRegistroCP getViewRegistroCP() {
		return miVentanaRegistroCP;
	}
	public void setViewRegistroCP(ViewRegistroCP miVentanaRegistroCP) {
		this.miVentanaRegistroCP = miVentanaRegistroCP;
	}
	public ViewBuscarCP getViewBuscarCP() {
		return miVentanaBuscarCP;
	}
	public void setViewBuscarCP(ViewBuscarCP miVentanaBuscarCP) {
		this.miVentanaBuscarCP = miVentanaBuscarCP;
	}
	public Cientifico_ProyectoServ getCPServ() {
		return cpServ;
	}
	public void setCPServ(Cientifico_ProyectoServ cpServ) {
		this.cpServ = cpServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistroCP.setVisible(true);
	}
	public void mostrarVentanaConsulta() {
		miVentanaBuscarCP.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarCP(Cientifico_Proyecto cp) {
		cpServ.validarRegistro(cp);
	}
	
	public Cientifico_Proyecto buscarCP(String dni) {
		return cpServ.validarConsulta(dni);
	}
	
	public void modificarCP(Cientifico_Proyecto cp) {
		cpServ.validarModificacion(cp);
	}
	
	public void eliminarCP(String dni) {
		cpServ.validarEliminacion(dni);
	}


}
