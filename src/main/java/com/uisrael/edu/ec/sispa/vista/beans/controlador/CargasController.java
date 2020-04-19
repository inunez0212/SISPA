/**
 * 
 */
package com.uisrael.edu.ec.sispa.vista.beans.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sispa.constantes.Constantes;
import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IAlicuotaServicio;
import com.uisrael.edu.ec.sispa.servicio.interfaces.ICatalogoServicio;
import com.uisrael.edu.ec.sispa.vista.beans.util.JsfUtil;

/**
 * @author Jorge
 *
 */
@Named("cargasController")
public class CargasController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2730783974545513141L;
	
	@Autowired
	private ICatalogoServicio catalogoServicio;
	
	@Autowired
	private IAlicuotaServicio alicuotasServicio;
	
	@Autowired
	private SessionController sessionController;
	
	@Autowired 
	private AlicuotaController alicuotaController;
		
	private String anio;
	
	private Double valorAlicuota;
	
	private List<CatalogoDTO> catalogosAnio;
	
	@PostConstruct
	public void inicializar() {
		catalogosAnio = this.catalogoServicio.buscarPorRelacionado(Constantes.ANIO_CARGA);
	}
	
	/**
	 * Maneja el archivo cargado
	 */
    public void handleFileUpload(FileUploadEvent event) {
    	try {
    		this.alicuotasServicio.cargarDatos(event.getFile().getContents());
    		alicuotaController.inicializar();
    		JsfUtil.addSuccessMessage("Archivo cargado correctamente");
    	}catch (ArrayIndexOutOfBoundsException e) {
    		e.printStackTrace();
    		JsfUtil.addErrorMessage("Error, verifique que el delimitador del archivo sea: '"+Constantes.DELIMITADOR_ARCHIVO+"'");
		}
    	catch (IOException e) {
    		e.printStackTrace();
    		JsfUtil.addErrorMessage( e.getMessage());
    	}catch(Exception e) {
    		e.printStackTrace();
    		JsfUtil.addErrorMessage("Error en el archivo "+ event.getFile().getFileName());
    	}
    }
    
    public void nuevoAnio() {
    	try {
    		
    		CatalogoDTO catalogoAlicuota = this.catalogoServicio.buscarPorId(Constantes.VALOR_ALICUOTA);
    		if(catalogoAlicuota==null || StringUtils.isBlank(catalogoAlicuota.getValorCatalogo())) {
    			throw new Exception("No existe el valor de la alicuota");
       		}
    		valorAlicuota = Double.parseDouble(catalogoAlicuota.getValorCatalogo());
    		this.alicuotasServicio.generarNuevoAnio(this.anio, this.sessionController.getNombreUsuarioLogueado(),
    				BigDecimal.valueOf(this.valorAlicuota));
    		this.inicializar();
    		alicuotaController.inicializar();
    		JsfUtil.addSuccessMessage("Datos para el año " +this.anio+" cargados correctamente" );
    	}catch (Exception ioe) {
    		JsfUtil.addErrorMessage("Error, "+ ioe.getMessage());
    	}
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
	 * @return the alicuotaController
	 */
	public AlicuotaController getAlicuotaController() {
		return alicuotaController;
	}

	/**
	 * @param alicuotaController the alicuotaController to set
	 */
	public void setAlicuotaController(AlicuotaController alicuotaController) {
		this.alicuotaController = alicuotaController;
	}

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * @return the catalogosAnio
	 */
	public List<CatalogoDTO> getCatalogosAnio() {
		return catalogosAnio;
	}

	/**
	 * @param catalogosAnio the catalogosAnio to set
	 */
	public void setCatalogosAnio(List<CatalogoDTO> catalogosAnio) {
		this.catalogosAnio = catalogosAnio;
	}

	
    
}
