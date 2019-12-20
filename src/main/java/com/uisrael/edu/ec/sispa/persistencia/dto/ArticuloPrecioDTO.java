/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Ivan
 *
 */
@Entity
@Table(name = "articuloprecio")
public class ArticuloPrecioDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6369479496037641333L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private BigDecimal costobruto;
	
	private BigDecimal costototal;
	
	private BigDecimal utilidad;
	
	private BigDecimal preciototal;
	
	private Date fecharegistro;
	
	private Integer usuarioregistro;
	
	private String estado;
	
	@JoinColumn(name = "idarticulo", referencedColumnName = "id")
    @ManyToOne
	private ArticuloDTO articuloDTO;

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
	 * @return the costobruto
	 */
	public BigDecimal getCostobruto() {
		return costobruto;
	}

	/**
	 * @param costobruto the costobruto to set
	 */
	public void setCostobruto(BigDecimal costobruto) {
		this.costobruto = costobruto;
	}

	/**
	 * @return the costototal
	 */
	public BigDecimal getCostototal() {
		return costototal;
	}

	/**
	 * @param costototal the costototal to set
	 */
	public void setCostototal(BigDecimal costototal) {
		this.costototal = costototal;
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

	/**
	 * @return the preciototal
	 */
	public BigDecimal getPreciototal() {
		return preciototal;
	}

	/**
	 * @param preciototal the preciototal to set
	 */
	public void setPreciototal(BigDecimal preciototal) {
		this.preciototal = preciototal;
	}

	/**
	 * @return the fecharegistro
	 */
	public Date getFecharegistro() {
		return fecharegistro;
	}

	/**
	 * @param fecharegistro the fecharegistro to set
	 */
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	/**
	 * @return the usuarioregistro
	 */
	public Integer getUsuarioregistro() {
		return usuarioregistro;
	}

	/**
	 * @param usuarioregistro the usuarioregistro to set
	 */
	public void setUsuarioregistro(Integer usuarioregistro) {
		this.usuarioregistro = usuarioregistro;
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
	 * @return the articuloDTO
	 */
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	/**
	 * @param articuloDTO the articuloDTO to set
	 */
	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}
	
}
