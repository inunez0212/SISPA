/**
 * 
 */
package com.uisrael.edu.ec.sispa.vista.beans.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.UsuarioDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.ICatalogoServicio;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IUsuarioServicio;

/**
 * @author Ivan
 *
 */
@Named("usuarioController")
public class UsuarioController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4043774368357190192L;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private SessionController sessionController;
	
	private UsuarioDTO usuarioDTO;
	
	private UsuarioDTO usuarioDTOSelected;
	
	private List<UsuarioDTO> listaUsuarios ;
	
	private String perfil;
	
	

	/**
	 * @return the sessionController
	 */
	public SessionController getSessionController() {
		return sessionController;
	}

	/**
	 * @param sessionController the sessionController to set
	 */
	public void setSessionController(SessionController sessionController) {
		this.sessionController = sessionController;
	}

	/**
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	/**
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	/**
	 * @return the usuarioDTOSelected
	 */
	public UsuarioDTO getUsuarioDTOSelected() {
		return usuarioDTOSelected;
	}

	/**
	 * @param usuarioDTOSelected the usuarioDTOSelected to set
	 */
	public void setUsuarioDTOSelected(UsuarioDTO usuarioDTOSelected) {
		this.usuarioDTOSelected = usuarioDTOSelected;
	}

	/**
	 * @return the listaUsuarios
	 */
	public List<UsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(List<UsuarioDTO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	

}
