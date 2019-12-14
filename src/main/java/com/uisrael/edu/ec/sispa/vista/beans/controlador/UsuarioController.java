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
import com.uisrael.edu.ec.sispa.vista.beans.util.JsfUtil;

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
	
	@PostConstruct
	public void inicializar() {
		this.listaUsuarios = this.usuarioServicio.listarTodos();
		this.usuarioDTO = new UsuarioDTO();
		this.usuarioDTOSelected=null;
		this.perfil ="";
	}
	
	public void registrar() {
    	try {
    		if(this.validarRegistro()) {
    			this.usuarioServicio.registrar(usuarioDTO);
    			inicializar();
    			JsfUtil.addSuccessMessage("Usuario creado correctamente");
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el Usuario");
		}
    }
	
	

	private boolean validarRegistro() {
		boolean validacion = true;
		if(this.usuarioDTO.getCedula()==null || this.usuarioDTO.getCedula().equals("")) {
			JsfUtil.addErrorMessage("Cédula no puede estar vacio");
			validacion= false;
		}
		if(this.usuarioDTO.getNombre()==null || this.usuarioDTO.getNombre().equals("")) {
			JsfUtil.addErrorMessage("Nombre no puede estar vacio");
			validacion= false;
		}
		if(this.usuarioDTO.getApellido()==null || this.usuarioDTO.getApellido().equals("")) {
			JsfUtil.addErrorMessage("Apellido no puede estar vacia");
			validacion= false;
		}
		if(this.usuarioDTO.getDireccion()==null || this.usuarioDTO.getDireccion().equals("")) {
			JsfUtil.addErrorMessage("Direccion no puede estar vacia");
			validacion= false;
		}
		if(this.usuarioDTO.getContrasenia()==null || this.usuarioDTO.getContrasenia().equals("")) {
			JsfUtil.addErrorMessage("Contraseña no puede estar vacia");
			validacion= false;
		}
		if(this.usuarioDTO.getTelefono1()==null || this.usuarioDTO.getTelefono1().equals("")) {
			JsfUtil.addErrorMessage("Celular no puede estar vacio");
			validacion= false;
		}
		if(this.usuarioDTO.getCargo()==null || this.usuarioDTO.getCargo().equals("")) {
			JsfUtil.addErrorMessage("Cargo no puede estar vacio");
			validacion= false;
		}
		
		return validacion;
	}
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
