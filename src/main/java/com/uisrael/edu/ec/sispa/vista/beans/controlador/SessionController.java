/**
 * 
 */
package com.uisrael.edu.ec.sispa.vista.beans.controlador;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sispa.persistencia.dto.UsuarioDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IUsuarioServicio;
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

	@Autowired
	private IUsuarioServicio usuarioServicio;

	private UsuarioDTO usuarioDTO;
	
	public void ingresar() {
		try {
			usuarioDTO = this.usuarioServicio.identificarUsuario(usuarioDTO);
			if(usuarioDTO!=null) {
				JsfUtil.addSuccessMessage("Bienvendo "+usuarioDTO.getNombre());
				FacesContext fContext = FacesContext.getCurrentInstance();
				ExternalContext extContext = fContext.getExternalContext();
				extContext.redirect(extContext.getRequestContextPath() + "/catalogo.xhtml");
			}else {
				usuarioDTO = new UsuarioDTO();
				JsfUtil.addErrorMessage("Usuario y/o contraseÃ±a incorrectos");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage("Problemas internos con el servicio");
		}
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
	
	
	
}
