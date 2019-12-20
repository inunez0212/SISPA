/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ivan
 *
 */
@Entity
@Table(name = "articulo")
public class ArticuloDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 890717537059443604L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private String nombre;
	
	private String imagen;
	
	private BigDecimal costo;
	
	private BigDecimal precioactual;
	
	private BigDecimal utilidad;
	
	private String estado;
	
	@OneToMany(mappedBy = "articuloDTO")
    private Collection<ArticuloPrecioDTO> articulosPrecioCOL;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the costo
	 */
	public BigDecimal getCosto() {
		return costo;
	}

	/**
	 * @param costo the costo to set
	 */
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	/**
	 * @return the precioactual
	 */
	public BigDecimal getPrecioactual() {
		return precioactual;
	}

	/**
	 * @param precioactual the precioactual to set
	 */
	public void setPrecioactual(BigDecimal precioactual) {
		this.precioactual = precioactual;
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
	 * @return the articulosPrecioCOL
	 */
	public Collection<ArticuloPrecioDTO> getArticulosPrecioCOL() {
		return articulosPrecioCOL;
	}

	/**
	 * @param articulosPrecioCOL the articulosPrecioCOL to set
	 */
	public void setArticulosPrecioCOL(Collection<ArticuloPrecioDTO> articulosPrecioCOL) {
		this.articulosPrecioCOL = articulosPrecioCOL;
	}

	/**
	 * @return the utilidad
	 */
	public BigDecimal getUtilidad() {
		return utilidad;
	}

	/**
	 * @param utilidad the utilidad to set
	 */
	public void setUtilidad(BigDecimal utilidad) {
		this.utilidad = utilidad;
	}
	

}
