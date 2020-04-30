/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jorge
 *
 */
@Entity
@Table(name = "detallefactura")
public class DetalleFacturaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1886148624396210302L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Integer id;
	
	private Integer idfactura;
	
	private Integer idarticulo;
	
	private BigDecimal preciosinimpuestos;
	
	private BigDecimal precioconimpuestos;
	
	private BigDecimal ganancia;
	
	private String estado;

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
	 * @return the idfactura
	 */
	public Integer getIdfactura() {
		return idfactura;
	}

	/**
	 * @param idfactura the idfactura to set
	 */
	public void setIdfactura(Integer idfactura) {
		this.idfactura = idfactura;
	}

	/**
	 * @return the idarticulo
	 */
	public Integer getIdarticulo() {
		return idarticulo;
	}

	/**
	 * @param idarticulo the idarticulo to set
	 */
	public void setIdarticulo(Integer idarticulo) {
		this.idarticulo = idarticulo;
	}

	/**
	 * @return the preciosinimpuestos
	 */
	public BigDecimal getPreciosinimpuestos() {
		return preciosinimpuestos;
	}

	/**
	 * @param preciosinimpuestos the preciosinimpuestos to set
	 */
	public void setPreciosinimpuestos(BigDecimal preciosinimpuestos) {
		this.preciosinimpuestos = preciosinimpuestos;
	}

	/**
	 * @return the precioconimpuestos
	 */
	public BigDecimal getPrecioconimpuestos() {
		return precioconimpuestos;
	}

	/**
	 * @param precioconimpuestos the precioconimpuestos to set
	 */
	public void setPrecioconimpuestos(BigDecimal precioconimpuestos) {
		this.precioconimpuestos = precioconimpuestos;
	}

	/**
	 * @return the ganancia
	 */
	public BigDecimal getGanancia() {
		return ganancia;
	}

	/**
	 * @param ganancia the ganancia to set
	 */
	public void setGanancia(BigDecimal ganancia) {
		this.ganancia = ganancia;
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
	

}
