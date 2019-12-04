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
import com.uisrael.edu.ec.sispa.servicio.interfaces.ICatalogoServicio;
import com.uisrael.edu.ec.sispa.vista.beans.util.JsfUtil;

/**
 * @author Ivan
 *
 */
@Named("catalogoController")
public class CatalogoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2347872837244798582L;

	@Autowired
	private ICatalogoServicio catalogoServicio;
	
	@Autowired
	private SessionController sessionController;
	
	private CatalogoDTO catalogoDTO;
	
	private CatalogoDTO catalogoDTOSelected;
	
	private List<CatalogoDTO> listaCatalogos ;
	
	private String codigoRelacionado;
	
	private CatalogoController () {
		
	}
	
	@PostConstruct
	public void inicializar() {
		this.listaCatalogos = this.catalogoServicio.listarTodos();
		this.catalogoDTO = new CatalogoDTO();
		
	}
	
	
	
	
	
	public void registrar() {
    	try {
    		this.catalogoServicio.registrar(catalogoDTO);
    		inicializar();
    		JsfUtil.addSuccessMessage("Catalogo creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el catalogoValor");
		}
    }

    public void actualizar() {
    	try {
    		this.catalogoServicio.actualizar(catalogoDTO);
    		JsfUtil.addSuccessMessage("CatalogoValor actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el catalogoValor");
		}
    }

    public void eliminar() {
    	try {
    		this.catalogoServicio.eliminar(catalogoDTO);
    		JsfUtil.addSuccessMessage("CatalogoValorDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el catalogoValor");
		}
    }

    public void listarTodos() {
    	try {
    		listaCatalogos = this.catalogoServicio.listarTodos();
    		JsfUtil.addSuccessMessage("CatalogoValorDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el catalogoValor");
		}
    }
	
	/**
	 * @return the catalogoDTO
	 */
	public CatalogoDTO getCatalogoDTO() {
		return catalogoDTO;
	}

	/**
	 * @param catalogoDTO the catalogoDTO to set
	 */
	public void setCatalogoDTO(CatalogoDTO catalogoDTO) {
		this.catalogoDTO = catalogoDTO;
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
	 * @return the listaCatalogos
	 */
	public List<CatalogoDTO> getListaCatalogos() {
		return listaCatalogos;
	}



	/**
	 * @return the codigoRelacionado
	 */
	public String getCodigoRelacionado() {
		return codigoRelacionado;
	}



	/**
	 * @param codigoRelacionado the codigoRelacionado to set
	 */
	public void setCodigoRelacionado(String codigoRelacionado) {
		this.codigoRelacionado = codigoRelacionado;
	}



	/**
	 * @param listaCatalogos the listaCatalogos to set
	 */
	public void setListaCatalogos(List<CatalogoDTO> listaCatalogos) {
		this.listaCatalogos = listaCatalogos;
	}


	/**
	 * @return the catalogoDTOSelected
	 */
	public CatalogoDTO getCatalogoDTOSelected() {
		return catalogoDTOSelected;
	}

	/**
	 * @param catalogoDTOSelected the catalogoDTOSelected to set
	 */
	public void setCatalogoDTOSelected(CatalogoDTO catalogoDTOSelected) {
		this.catalogoDTOSelected = catalogoDTOSelected;
	}

}
