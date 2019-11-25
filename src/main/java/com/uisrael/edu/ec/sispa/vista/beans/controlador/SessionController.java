/**
 * 
 */
package com.uisrael.edu.ec.sispa.vista.beans.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.ICatalogoServicio;
import com.uisrael.edu.ec.sispa.vista.beans.util.JsfUtil;

/**
 * @author Ivan
 *
 */
@Named("sessionController")
public class SessionController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7106328209673993342L;

	private String cedula;
	
	private String contrasenia;
	private List<CatalogoDTO> listaCatalogos = new ArrayList<>();

	@Autowired
	private ICatalogoServicio catalogoServicio;
	
	
	public void obtenerCatalogos() {
		try {
			listaCatalogos = this.catalogoServicio.listarTodos();
		}catch(Exception ex) {
			ex.printStackTrace();
			JsfUtil.addErrorMessage("Error al obtener catalogos");
		}
	}
	
	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
}
