/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ivan
 *
 */
@Entity
@Table(name = "catalogo")
public class CatalogoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3938524883609070734L;

	@Id
    @Basic(optional = false)
	private String id;
	
	@Column(name="nombrecatalogo")
	private String nombreCatalogo;
	
	@Column(name="valorcatalogo")
	private String valorCatalogo;
	
	private String estado;

	@JoinColumn(name = "catalogorelacionado", referencedColumnName = "id")
    @ManyToOne
	private CatalogoDTO catalogoRelacionado;
	
	@OneToMany(mappedBy = "catalogoRelacionado")
    private Collection<CatalogoDTO> catalogoRelacionadoCOL;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombreCatalogo
	 */
	public String getNombreCatalogo() {
		return nombreCatalogo;
	}

	/**
	 * @param nombreCatalogo the nombreCatalogo to set
	 */
	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}

	

	
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the catalogoRelacionado
	 */
	public CatalogoDTO getCatalogoRelacionado() {
		return catalogoRelacionado;
	}

	/**
	 * @param catalogoRelacionado the catalogoRelacionado to set
	 */
	public void setCatalogoRelacionado(CatalogoDTO catalogoRelacionado) {
		this.catalogoRelacionado = catalogoRelacionado;
	}

	/**
	 * @return the catalogoRelacionadoCOL
	 */
	public Collection<CatalogoDTO> getCatalogoRelacionadoCOL() {
		return catalogoRelacionadoCOL;
	}

	/**
	 * @param catalogoRelacionadoCOL the catalogoRelacionadoCOL to set
	 */
	public void setCatalogoRelacionadoCOL(Collection<CatalogoDTO> catalogoRelacionadoCOL) {
		this.catalogoRelacionadoCOL = catalogoRelacionadoCOL;
	}

	/**
	 * @return the valorCatalogo
	 */
	public String getValorCatalogo() {
		return valorCatalogo;
	}

	/**
	 * @param valorCatalogo the valorCatalogo to set
	 */
	public void setValorCatalogo(String valorCatalogo) {
		this.valorCatalogo = valorCatalogo;
	}
	
}
