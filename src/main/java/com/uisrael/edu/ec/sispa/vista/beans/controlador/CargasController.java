/**
 * 
 */
package com.uisrael.edu.ec.sispa.vista.beans.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sispa.constantes.Constantes;
import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.ICatalogoServicio;
import com.uisrael.edu.ec.sispa.vista.beans.util.JsfUtil;

/**
 * @author kali
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
	
	private String anio;
	
	private Integer valorAlicuota;
	
	private List<CatalogoDTO> catalogosAnio;
	
	@PostConstruct
	public void inicializar() {
		catalogosAnio = this.catalogoServicio.buscarPorRelacionado(Constantes.ANIO_CARGA);
	}
	
    public void handleFileUpload(FileUploadEvent event) {
        JsfUtil.addSuccessMessage( event.getFile().getFileName() + " is uploaded.");
    }
    
    public void nuevoAnio() {
    	JsfUtil.addSuccessMessage("Datos para el año " +this.anio+" cargados correctamente" );
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

	/**
	 * @return the valorAlicuota
	 */
	public Integer getValorAlicuota() {
		return valorAlicuota;
	}

	/**
	 * @param valorAlicuota the valorAlicuota to set
	 */
	public void setValorAlicuota(Integer valorAlicuota) {
		this.valorAlicuota = valorAlicuota;
	}

	
    
}
