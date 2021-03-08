 
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.model.service.CientificoServ;

import Backend.PatronMVC.view.ViewBuscarCientifico;
import Backend.PatronMVC.view.ViewRegistroCientifico;


public class CientificoController {
	
	private CientificoServ cientificoServ;
	private ViewRegistroCientifico miVentanaRegistroC;
	private ViewBuscarCientifico miVentanaBuscarC;
	
	public ViewRegistroCientifico getViewRegistroC() {
		return miVentanaRegistroC;
	}
	public void setViewRegistroC(ViewRegistroCientifico miVentanaRegistroC) {
		this.miVentanaRegistroC = miVentanaRegistroC;
	}
	public ViewBuscarCientifico getViewBuscarC() {
		return miVentanaBuscarC;
	}
	public void setViewBuscarC(ViewBuscarCientifico miVentanaBuscarC) {
		this.miVentanaBuscarC = miVentanaBuscarC;
	}
	public CientificoServ getCientificoServ() {
		return cientificoServ;
	}
	public void setCientificoServ(CientificoServ cientificoServ) {
		this.cientificoServ = cientificoServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistroC.setVisible(true);
	}
	public void mostrarVentanaConsulta() {
		miVentanaBuscarC.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarCientifico(Cientifico cientifico) {
		cientificoServ.validarRegistro(cientifico);
	}
	
	public Cientifico buscarCientifico(String dni) {
		return cientificoServ.validarConsulta(dni);
	}
	
	public void modificarCientifico(Cientifico cientifico) {
		cientificoServ.validarModificacion(cientifico);
	}
	
	public void eliminarCientifico(String dni) {
		cientificoServ.validarEliminacion(dni);
	}


}
